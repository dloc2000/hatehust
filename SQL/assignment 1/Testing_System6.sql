DROP PROCEDURE IF EXISTS sp_GetDepNameFromDepID;
DELIMITER $$
CREATE PROCEDURE sp_GetDepNameFromDepID(IN in_depID TINYINT, OUT in_depName VARCHAR(50))
BEGIN
    DECLARE dep_name VARCHAR(50) DEFAULT 0 ;
	SELECT d.DepartmentName INTO in_depName FROM department d 
	WHERE d.DepartmentID = in_depID;
END$$
DELIMITER ;

SET @dep_name= '';
 

Call sp_GetDepNameFromDepID(6, @dep_name );


 SELECT @dep_name;
 
 
 -- Question 1: Tạo store để người dùng nhập vào tên phòng ban và in ra tất cả các account thuộc phòng ban đó
DROP PROCEDURE IF EXISTS sp_GetAccountByDep;
DELIMITER $$
CREATE PROCEDURE sp_GetAccountByDep(IN in_depName VARCHAR(50))
BEGIN
	SELECT a.AccountID , a.FullName , a.Email FROM `account` a
    JOIN department d ON a.DepartmentID = d.DepartmentID
	WHERE d.departmentName = in_depName;
END$$

Call sp_GetAccountByDep('Sale');



 
 
-- Question 2: Tạo store để in ra số lượng account trong mỗi group
DROP PROCEDURE IF EXISTS sp_GetAccountFromGroup;
DELIMITER $$
CREATE PROCEDURE sp_GetAccountFromGroup(IN in_groupName NVARCHAR(30))
BEGIN
	SELECT g.GroupName, COUNT(ga.AccountID) AS number_of_account FROM `groupaccount` ga
    INNER JOIN `group` g
    WHERE g.GroupName = in_groupName;
END$$
Call sp_GetAccountFromGroup('Testing System');

-- Question 3: Tạo store để thống kê mỗi type question có bao nhiêu question được tạo trong tháng hiện tại
SELECT * FROM 



-- Question 4: Tạo store để trả ra id của type question có nhiều câu hỏi nhất