														
                                                        -- Exercise 1: Join--
                                                        
-- Question 1: Viết lệnh để lấy ra danh sách nhân viên và thông tin phòng ban của họ
SELECT * FROM `account` as a
INNER JOIN department as d ON d.departmentID = a.departmentID;

-- Question 2: Viết lệnh để lấy ra thông tin các account được tạo sau ngày 20/12/2010 
SELECT * FROM `account`a
WHERE CreateDate > '2020-03-05 00:00:00';

-- Question 3: Viết lệnh để lấy ra tất cả các developer
SELECT a.AccountID , p.PositionName FROM `account` a
INNER JOIN position p ON p.PositionID = a.PositionID
WHERE p.PositionName = 'dev';

-- Question 4: Viết lệnh để lấy ra danh sách các phòng ban có >3 nhân viên 
SELECT d.departmentName,Count(a.DepartmentID) FROM `account` as a
INNER JOIN department as d ON d.departmentID = a.departmentID
GROUP BY a.DepartmentID
HAVING Count(a.DepartmentID) > 3;

-- Question 5: Viết lệnh để lấy ra danh sách câu hỏi được sử dụng trong đề thi nhiều nhất
SELECT q.Content,COUNT(eq.QuestionID) FROM examquestion eq
INNER JOIN question q ON q.QuestionID = eq.QuestionID
GROUP BY eq.QuestionID
HAVING COUNT(eq.QuestionID)
ORDER BY COUNT(eq.QuestionID) DESC
LIMIT 1;

-- Question 6: Thông kê mỗi category Question được sử dụng trong bao nhiêu Question
SELECT q.QuestionID,COUNT(cq.CategoryID) FROM question q
INNER JOIN categoryquestion cq ON q.CategoryID = cq.CategoryID
GROUP BY q.CategoryID
HAVING COUNT(cq.CategoryID);

-- Question 7: Thông kê mỗi Question được sử dụng trong bao nhiêu Exam
SELECT ExamID,count(QuestionID) FROM examquestion
GROUP BY QuestionID
HAVING count(QuestionID);

-- Question 8: Lấy ra Question có nhiều câu trả lời nhất
SELECT a.Content,count(a.QuestionID),q.Content  FROM answer a
INNER JOIN question q ON a.QuestionID = q.QuestionID
GROUP BY a.QuestionID
HAVING count(a.QuestionID)
ORDER BY COUNT(a.QuestionID) DESC
LIMIT 1;

-- Question 9: Thống kê số lượng account trong mỗi group 
SELECT ga.GroupID, g.GroupName,count(ga.GroupID) FROM groupaccount ga
-- INNER JOIN `account` a ON a.AccountID = ga.AccountID 
INNER JOIN `group` g ON g.GroupID = ga.GroupID
GROUP BY ga.GroupID
HAVING count(ga.GroupID);
-- Question 10: Tìm chức vụ có ít người nhất
SELECT p.PositionName,count(a.PositionID) FROM `account` a
INNER JOIN `position` p ON p.PositionID = a.PositionID
GROUP BY a.PositionID
HAVING count(a.PositionID)
ORDER BY count(a.PositionID) ASC
LIMIT 1;
-- Question 11: Thống kê mỗi phòng ban có bao nhiêu dev, test, scrum master, PM
SELECT d.DepartmentID , d.DepartmentName, p.positionName , count(p.positionName)  FROM `account` a
INNER JOIN department d ON a.DepartmentID = d.DepartmentID
INNER JOIN position p ON a.PositionID = p.PositionID
GROUP BY p.positionID , d.DepartmentID
ORDER BY a.DepartmentID;
-- Question 12: Lấy thông tin chi tiết của câu hỏi bao gồm: thông tin cơ bản của  question, loại câu hỏi, ai là người tạo ra câu hỏi, câu trả lời là gì, … --
SELECT q.QuestionID ,a.FullName,q.Content,an.Content FROM question q
INNER JOIN `account` a ON a.AccountID = q.CreatorID
INNER JOIN `categoryquestion` cq ON cq.CategoryID = q.CategoryID
INNER JOIN answer an ON an.QuestionID = q.QuestionID
GROUP BY a.AccountID , cq.CategoryID ,an.QuestionID;
-- Question 13: Lấy ra số lượng câu hỏi của mỗi loại tự luận hay trắc nghiệm
SELECT tq.TypeName,count(q.TypeID) FROM question q
INNER JOIN typequestion tq ON tq.TypeID = q.TypeID
GROUP BY q.TypeID
HAVING count(q.TypeID);
-- Question 14:Lấy ra group không có account nào
SELECT * FROM `group` g
LEFT JOIN groupaccount ga ON g.GroupID = ga.GroupID
WHERE ga.AccountID IS NULL;
-- Question 15: Lấy ra account không có group nào
SELECT * FROM `account` a
LEFT JOIN groupaccount ga ON a.AccountID = ga.AccountID
WHERE ga.GroupID IS NULL;
-- Question 16: Lấy ra question không có answer nào
SELECT * FROM answer a
RIGHT JOIN question q ON q.QuestionID = a.QuestionID
WHERE a.AnswerID IS NULL;

																	-- Exercise 2: Union --
-- Question 17:
-- a) Lấy các account thuộc nhóm thứ 1
-- b) Lấy các account thuộc nhóm thứ 2
-- c) Ghép 2 kết quả từ câu a) và câu b) sao cho không có record nào trùng nhau
SELECT a.FullName,ga.GroupID FROM `Account` a
JOIN GroupAccount ga ON a.AccountID = ga.AccountID
WHERE ga.GroupID = 1
UNION
SELECT a.FullName,ga.GroupID FROM `Account` a
JOIN GroupAccount ga ON a.AccountID = ga.AccountID
WHERE ga.GroupID = 2;
-- Question 18:
-- a) Lấy các group có lớn hơn 5 thành viên
-- b) Lấy các group có nhỏ hơn 7 thành viên
-- c) Ghép 2 kết quả từ câu a) và câu b)
SELECT g.GroupName,COUNT(ga.GroupID) FROM `groupaccount` ga
JOIN `group` g ON g.GroupID = ga.GroupID
GROUP BY g.GroupID
HAVING COUNT(g.GroupID) >= 5
UNION
SELECT g.GroupName,COUNT(ga.GroupID) FROM `groupaccount` ga
JOIN `group` g ON g.GroupID = ga.GroupID
GROUP BY g.GroupID
HAVING COUNT(g.GroupID) <= 7


















