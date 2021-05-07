-- Question 1: Tạo view có chứa danh sách nhân viên thuộc phòng ban sale
CREATE OR REPLACE VIEW account_of_department AS
SELECT *
FROM department d
WHERE d.DepartmentName = 'sale';
 
-- Question 2: Tạo view có chứa thông tin các account tham gia vào nhiều group nhất
CREATE OR REPLACE VIEW account_of_group AS
SELECT a.Email , a.Username , a.FullName , COUNT(ga.GroupID) AS number_of_groups
FROM `account` a
INNER JOIN groupaccount ga ON ga.AccountID = a.AccountID
GROUP BY ga.AccountID
HAVING COUNT(ga.GroupID) = (SELECT MAX(number_of_groups) FROM (SELECT COUNT(ga.GroupID) AS number_of_groups
							FROM `account` a
							INNER JOIN groupaccount ga ON ga.AccountID = a.AccountID
					        GROUP BY ga.AccountID) AS temp);


-- Question 3: Tạo view có chứa câu hỏi có những content quá dài (content quá 300 từ được coi là quá dài) và xóa nó đi
CREATE OR REPLACE VIEW content_too_long AS
	 SELECT *
	 FROM  `question` q
	 WHERE LENGTH(Content) > 30;
	 SELECT *
	 FROM content_too_long;
	 DROP VIEW content_too_long;
-- Question 4: Tạo view có chứa danh sách các phòng ban có nhiều nhân viên nhất
CREATE OR REPLACE VIEW department_of_account AS 
	SELECT a.FullName, d.DepartmentName ,COUNT(a.AccountID) AS number_of_account
    FROM `account` a
    JOIN department d ON a.DepartmentID = d.DepartmentID
    GROUP BY a.DepartmentID
    HAVING COUNT(a.AccountID) = (SELECT MAX(number_of_account) FROM (
		SELECT COUNT(a.AccountID) AS number_of_account
		FROM `account` a
		JOIN department d ON a.DepartmentID = d.DepartmentID
		GROUP BY a.DepartmentID) AS temp);
-- Question 5: Tạo view có chứa tất các các câu hỏi do user họ Nguyễn tạo
CREATE OR REPLACE VIEW vw_QuesHoNguyen AS
		SELECT a.FullName , q.Content
        FROM `question` q
        JOIN `account` a ON a.AccountID = q.CreatorID
        WHERE SUBSTRING_INDEX(a.FullName,' ',1) = 'Nguyễn';
	
        SELECT 	* 
		FROM 	vw_QuesHoNguyen;



















