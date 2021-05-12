DROP PROCEDURE IF EXISTS sp_GetDepNameFromDepID;
DELIMITER $$
CREATE PROCEDURE sp_GetDepNameFromDepID(IN in_depID TINYINT, OUT in_depName VARCHAR(50))
BEGIN
   
	SELECT d.DepartmentName INTO in_depName FROM department d 
	WHERE d.DepartmentID = in_depID;
END$$
DELIMITER ;

SET @dep_name= '';
 

Call sp_GetDepNameFromDepID('8', @dep_name );


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
DELIMITER ;
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
DELIMITER ;
Call sp_GetAccountFromGroup('Testing System');

-- Question 3: Tạo store để thống kê mỗi type question có bao nhiêu question được tạo trong tháng hiện tại
DROP PROCEDURE IF EXISTS sp_GetCountTypeInMonth;
DELIMITER $$
CREATE PROCEDURE sp_GetCountTypeInMonth()
BEGIN
	SELECT * FROM typequestion tq
	INNER JOIN `question` q ON q.TypeID = tq.TypeID
	WHERE month(q.CreateDate) = month(now()) AND year(q.CreateDate) = year(now())
	GROUP BY q.TypeID;
END$$
DELIMITER;
Call sp_GetCountTypeInMonth();
-- Question 4: Tạo store để trả ra id của type question có nhiều câu hỏi nhất
DROP PROCEDURE IF EXISTS sp_TypeID_MaxQuestion;
DELIMITER $$
CREATE PROCEDURE sp_TypeID_MaxQuestion(OUT Ques_ID TINYINT)
BEGIN 
		WITH CTE_CountTypeID AS(
			SELECT q.TypeID,count(q.TypeID) AS number_type
			FROM `question` q
			GROUP BY q.TypeID
		)
		SELECT q.TypeID INTO Ques_ID FROM `question` q
		GROUP BY q.TypeID
		HAVING count(q.TypeID) = (SELECT max(number_type) FROM CTE_CountTypeID);
END$$
DELIMITER ;
SET @Ques_ID = 0;
CALL sp_TypeID_MaxQuestion(@Ques_ID);
SELECT @Ques_ID;

-- Question 5: Sử dụng store ở question 4 để tìm ra tên của type question
DROP PROCEDURE IF EXISTS sp_findNameByIDTypeQuestion;
DELIMITER $$
CREATE PROCEDURE sp_findNameByIDTypeQuestion(OUT type_name VARCHAR(50) )

BEGIN
	WITH CTE_CountTypeID AS(
			SELECT q.TypeID,count(q.TypeID) AS number_type
			FROM `question` q
			GROUP BY q.TypeID
		)
		SELECT tq.TypeName INTO type_name  FROM `question` q
        INNER JOIN `typequestion` tq ON tq.TypeID = q.TypeID
		GROUP BY q.TypeID
		HAVING count(q.TypeID) = (SELECT max(number_type) FROM CTE_CountTypeID);
END$$
DELIMITER ;
SET @type_name = ' ' ;
CALL sp_findNameByIDTypeQuestion(@type_name);
SELECT @type_name;



DROP PROCEDURE IF EXISTS sp_findNameByIDTypeQuestion;
DELIMITER $$
CREATE PROCEDURE sp_findNameByIDTypeQuestion()
BEGIN

	WITH MAX_Count_TypeID AS(
		SELECT		COUNT(TypeID) AS max_type
		FROM		Question 
		GROUP BY	TypeID
        HAVING COUNT(TypeID) = (SELECT MAX(max_type) FROM (SELECT COUNT(TypeID) AS max_type 
																	FROM Question 
                                                                    GROUP BY TypeID) AS Temp)
				          )
    SELECT 		TQ.TypeName
    FROM		Question Q 
	INNER JOIN 	TypeQuestion TQ ON Q.TypeID = TQ.TypeID
    GROUP BY 	Q.TypeID
    HAVING		COUNT(Q.TypeID) = (SELECT * FROM MAX_Count_TypeID);		
	
END$$
DELIMITER ;



-- Question 6: Viết 1 store cho phép người dùng nhập vào 1 chuỗi và trả về group có tên chứa chuỗi của người dùng nhập vào hoặc trả về user có username chứa
				-- chuỗi của người dùng nhập vào
 DROP PROCEDURE IF EXISTS sp_getNameAccOrGroup;
 DELIMITER $$
 CREATE PROCEDURE sp_getNameAccOrGroup(IN var_string VARCHAR(50) ,flag TINYINT)
 BEGIN
		IF flag = 1 THEN 
        SELECT g.GroupName FROM `group`g
        WHERE  g.GroupName LIKE concat('%', var_string , '%');
        ELSE
        SELECT a.FullName FROM `account`a
        WHERE  a.FullName LIKE concat('%', var_string , '%');
        END IF ;
        
 END$$
 DELIMITER ;
 CALL sp_getNameAccOrGroup('VTI' , 1);
-- Question 7: Viết 1 store cho phép người dùng nhập vào thông tin fullName, email và trong store sẽ tự động gán:
				-- username sẽ giống email nhưng bỏ phần @..mail đi
				-- positionID: sẽ có default là developer
				-- departmentID: sẽ được cho vào 1 phòng chờ . Sau đó in ra kết quả tạo thành công
 DROP PROCEDURE IF EXISTS sp_insertAccount;
 DELIMITER $$
 CREATE PROCEDURE sp_insertAccount(IN in_fullName VARCHAR(50) , IN in_Email VARCHAR(50))
 BEGIN
		DECLARE Username     VARCHAR(50) DEFAULT (in_Email , '@' , 1);
        DECLARE PositionID   TINYINT UNSIGNED DEFAULT PositionID = 1;
		DECLARE departmentID TINYINT UNSIGNED DEFAULT departmentID = 12;
		DECLARE CreateDate   DATETIME DEFAULT NOW();
        INSERT INTO `Account` 	(Email		,Username, FullName		, DepartmentID,	PositionID,	CreateDate)
        VALUE					(in_email	,Username, in_fullName	, departmentID, PositionID, CreateDate);
	
        SELECT * FROM `account` a
        WHERE a.Username = Username ;
 END$$
 DELIMITER ;
 CALL sp_insertAccount('abc111' , 'abc@gmail.com');
-- Question 8: Viết 1 store cho phép người dùng nhập vào Essay hoặc Multiple-Choice 
-- để thống kê câu hỏi essay hoặc multiple-choice nào có content dài nhất
DROP PROCEDURE IF EXISTS sp_maxContentWithTypeName; 
DELIMITER $$
CREATE PROCEDURE sp_maxContentWithTypeName(IN in_TypeName VARCHAR(50))
BEGIN
	   IF(in_TypeName = 'Essay')    			 THEN
		   SELECT content , MAX(length(content)) FROM question
		   WHERE TypeID = 1;
	   ELSEIF(in_TypeName = 'Multiple-Choice')   THEN
		   SELECT content , MAX(length(content)) FROM question
		   WHERE TypeID = 2;
		END IF;
END$$
DELIMITER ;
CALL sp_maxContentWithTypeName('Multiple-Choice');
-- Question 9: Viết 1 store cho phép người dùng xóa exam dựa vào ID
DROP PROCEDURE IF EXISTS sp_DeleteExamOfID;
DELIMITER $$
CREATE PROCEDURE sp_DeleteExamOfID(IN in_idExam TINYINT UNSIGNED)
BEGIN
      DELETE FROM exam
      WHERE ExamID = in_idExam;
END$$
DELIMITER ;
CALL sp_DeleteExamOfID('11');
-- Question 10: Tìm ra các exam được tạo từ 3 năm trước và xóa các exam đó đi (sử dụng store ở câu 9 để xóa)
				-- Sau đó in số lượng record đã remove từ các table liên quan trong khi removing
DROP PROCEDURE IF EXISTS sp_delExam3YearAgo()
DELIMITER $$
CREATE PROCEDURE sp_delExam3YearAgo(IN in_idExam TINYINT UNSIGNED)
BEGIN
	  WITH CTE_Exam3YearAgo 
      AS(
			SELECT ExamID
            FROM   exam
            WHERE (YEAR(NOW() - YEAR(CreateDate)) > 3
      )
      DELETE
      FROM 	    exam
      WHERE 	ExamID = (SELECT * FROM CTE_Exam3YearAgo)
END$$
DELIMITER ;
 
--  Question 11: Viết store cho phép người dùng xóa phòng ban bằng cách người dùng nhập vào tên phòng ban và các account thuộc phòng ban đó sẽ được
					-- chuyển về phòng ban default là phòng ban chờ việc
DROP PROCEDURE IF EXISTS SP_DelDepFromName;
DELIMITER $$
CREATE PROCEDURE SP_DelDepFromName(IN var_DepartmentName VARCHAR(30))
BEGIN
	DECLARE v_DepartmentID VARCHAR(30) ;
    SELECT D1.DepartmentID   INTO v_DepartmentID FROM department D1 WHERE D1.DepartmentName = var_DepartmentName;

	UPDATE `account` A SET A.DepartmentID  = '11' WHERE A.DepartmentID = v_DepartmentID;
    
	DELETE FROM department d WHERE d.DepartmentName = var_DepartmentName;
END$$
DELIMITER ;

Call SP_DelDepFromName('Marketing');
 
 
-- Question 12: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong năm nay
 DROP PROCEDURE IF EXISTS sp_questionOfMonth;
 DELIMITER $$
 CREATE PROCEDURE sp_questionOfMonth()
	 BEGIN
	    SELECT EachMonthInYear.MONTH, COUNT(QuestionID) AS COUNT
		FROM
		(
             SELECT 1 AS MONTH
             UNION SELECT 2 AS MONTH
             UNION SELECT 3 AS MONTH
             UNION SELECT 4 AS MONTH
             UNION SELECT 5 AS MONTH
             UNION SELECT 6 AS MONTH
             UNION SELECT 7 AS MONTH
             UNION SELECT 8 AS MONTH
             UNION SELECT 9 AS MONTH
             UNION SELECT 10 AS MONTH
             UNION SELECT 11 AS MONTH
             UNION SELECT 12 AS MONTH
        ) AS EachMonthInYear
        LEFT JOIN Question ON EachMonthInYear.MONTH = MONTH(CreateDate)
		GROUP BY EachMonthInYear.MONTH
		ORDER BY EachMonthInYear.MONTH ASC;
	 END$$
DELIMITER ;
CALL sp_questionOfMonth() ;
 
 -- Question 13: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong 6 tháng gần đây nhất
				-- (Nếu tháng nào không có thì sẽ in ra là "không có câu hỏi nào trong tháng")

 


