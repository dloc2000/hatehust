
-- Question 2 : lấy ra tất cả các phòng ban --
SELECT * 
FROM TestingSystem.department;

-- Question 3: lấy ra id của phòng ban "Sale"--
SELECT * 
FROM department
WHERE DepartmentName = 'sale';

-- Question 4: lấy ra thông tin account có full name dài nhất --
SELECT * 
FROM `account`
WHERE LENGTH(Fullname) = (SELECT MAX(LENGTH(Fullname)) FROM `Account`);

-- Question 5: Lấy ra thông tin account có full name dài nhất và thuộc phòng ban có id =3 --
WITH CTE_MaxFullDep3 
AS (
SELECT * FROM `account` AS a
WHERE DepartmentID = 3
)
SELECT  * FROM `account`
WHERE LENGTH(a.FullName) = (SELECT MAX(length(a.FullName)) * FROM CTE_MaxFullDep3);
-- Question 6: Lấy ra tên group đã tham gia trước ngày 20/07/2020 --
SELECT *
FROM TestingSystem.`group`
WHERE CreateDate < '2020-04-10 00:00:00';

-- Question 7: Lấy ra ID của question có >= 4 câu trả lời --

SELECT * FROM answer
GROUP BY QuestionID
HAVING COUNT(QuestionID)>=4;


-- Question 8: Lấy ra các mã đề thi có thời gian thi >= 60 phút và được tạo trước ngày 20/07/2020
SELECT *
FROM TestingSystem.exam
WHERE CreateDate < '2020-04-10 00:00:00'
GROUP BY Duration
HAVING Duration >= 60;

-- Question 9: Lấy ra 5 group được tạo gần đây nhất --
SELECT *
FROM 	`Group`
ORDER BY   CreatDate DESC
LIMIT 5;


-- Question 10: Đếm số nhân viên thuộc department có id = 2 --
SELECT count(DepartmentID)
FROM TestingSystem.`account` 
WHERE DepartmentID = 2;


-- Question 11: Lấy ra nhân viên có tên bắt đầu bằng chữ "D" và kết thúc bằng chữ "o" --
SELECT * 
FROM `account`
WHERE (SUBSTRING_INDEX(FullName, ' ' , -1)) LIKE 'D%o';

-- Question 12: Xóa tất cả các exam được tạo trước ngày 20/12/2019 --

DELETE
FROM TestingSystem.exam
WHERE CreateDate < '2020-04-10 00:00:00';


   
-- Question 13: Xóa tất cả các question có nội dung bắt đầu bằng từ "câu hỏi" --
DELETE
FROM question
WHERE (SUBSTRING_INDEX(Content,' ',2)) LIKE 'Câu hỏi%';



-- Question 14: Update thông tin của account có id = 5 thành tên "Nguyễn Bá Lộc" và email thành loc.nguyenba@vti.com.vn --
UPDATE `account`
SET  Username = 'Nguyễn Bá Lộc' , Email = 'loc.nguyenba@vti.com.vn'
WHERE AccountID = 5;

-- Question 15: update account có id = 5 sẽ thuộc group có id = 4 --

UPDATE `account`
SET departmentID = 4
WHERE AccountID = 5











































