
-- Question 1: Tạo trigger không cho phép người dùng nhập vào Group có ngày tạo trước 1 năm trước
DROP TRIGGER IF EXISTS Trg_notAddGroup ;
DELIMITER $$
		CREATE TRIGGER Trg_notAddGroup
        BEFORE INSERT ON `group`
        FOR EACH ROW
        BEGIN
			IF NEW.CreateDate < DATE_SUB(CURDATE(), INTERVAL 1 YEAR) THEN
            SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT = " Cant insert data ";
            END IF;
        END$$
DELIMITER ; 
INSERT INTO `group`(`GroupName` , `CreatorID` ,`CreateDate`)
VALUES				('2' ,  '1' , '2020-03-07 00:00:00');       
-- Question 2: Tạo trigger Không cho phép người dùng thêm bất kỳ user nào vào
-- 				department "Sale" nữa, khi thêm thì hiện ra thông báo "Department
--  			"Sale" cannot add more user"
DROP TRIGGER IF EXISTS Trg_notAddUser ;
DELIMITER $$
		CREATE TRIGGER Trg_notAddUser
		BEFORE INSERT ON `account`
		FOR EACH ROW
		BEGIN
			DECLARE v_depID TINYINT;
            SELECT d.DepartmentID INTO v_depID FROM `department` d WHERE d.DepartmentName = 'Sale';
				IF (NEW.DepartmentID = v_depID) THEN
                SIGNAL SQLSTATE '12345'
                SET MESSAGE_TEXT = 'cannot add more user ';
            END IF;    
       
        
        END$$
DELIMITER ;       
INSERT INTO `testingsystem`.`account` (Email    ,     Username  , FullName,  DepartmentID,PositionID) 
				VALUES      	 	  (   2	,        222       ,   222   ,    2 ,    1   );

-- Question 3: Cấu hình 1 group có nhiều nhất là 5 user
DROP TRIGGER IF EXISTS Trg_maxUserOfGroups ;
DELIMITER $$
			CREATE TRIGGER Trg_maxUserOfGroups
            BEFORE INSERT ON `groupaccount` 
            FOR EACH ROW
            BEGIN
				DECLARE countUser TINYINT DEFAULT 0;
                SELECT  count(ga.GroupID) INTO countUser  FROM `groupaccount` ga 
                GROUP BY ga.GroupID;
                IF(countUser > 5) THEN
					SIGNAL SQLSTATE '12345'
					SET MESSAGE_TEXT = 'cant insert user';
				END IF;    
            END$$
DELIMITER ;  
INSERT INTO  `groupaccount`(GroupID , AccountID,JoinDate)
	   VALUES              (  '1'  ,  '2'    , now());

-- Question 4: Cấu hình 1 bài thi có nhiều nhất là 10 Question
DROP TRIGGER IF EXISTS Trg_maxQuesOfExam ;
DELIMITER $$
			CREATE TRIGGER Trg_maxQuesOfExam
            BEFORE INSERT ON `examquestion` 
            FOR EACH ROW
            BEGIN
				DECLARE countQues TINYINT DEFAULT 0;
                SELECT  count(ExamID) AS ques_of_exam INTO countQues  FROM `examquestion`  
                GROUP BY QuestionID;
                IF(countQues < 11) THEN
					SIGNAL SQLSTATE '12345'
					SET MESSAGE_TEXT = 'cant insert question for exam';
				END IF;    
            END$$
DELIMITER ;   


-- Question 5: Tạo trigger không cho phép người dùng xóa tài khoản có email là admin@gmail.com 
--             (đây là tài khoản admin, không cho phép user xóa),
--             còn lại các tài khoản khác thì sẽ cho phép xóa và sẽ xóa tất cả các thông tin liên quan tới user đó
DROP TRIGGER IF EXISTS Trg_notDelAdmin ;
DELIMITER $$
	CREATE TRIGGER Trg_notDelAdmin 
	BEFORE DELETE ON `account`
	FOR EACH ROW
	BEGIN 
		DECLARE email VARCHAR(50);
        SELECT a.Email INTO email FROM `account` a WHERE a.AccountID = OLD.AccountID;
			IF email = 'vti176@gmail.com' THEN
				SIGNAL SQLSTATE '12345'
                SET MESSAGE_TEXT = 'cant del this acc';
            END IF;    
	END$$
DELIMITER ;
 
 DELETE FROM `account` WHERE (AccountID = '12');
 


-- Question 6: Không sử dụng cấu hình default cho field DepartmentID của table Account
-- hãy tạo trigger cho phép người dùng khi tạo account không điền vào departmentID thì sẽ được phân vào phòng ban "waiting Department"
 
-- Question 7: Cấu hình 1 bài thi chỉ cho phép user tạo tối đa 4 answers cho mỗi question, trong đó có tối đa 2 đáp án đúng.
 DROP TRIGGER IF EXISTS Trg_insAnsForQues ;
DELIMITER $$
	CREATE TRIGGER Trg_insAnsForQues
	BEFORE INSERT ON `question`
	FOR EACH ROW
	BEGIN 
			
	END$$
DELIMITER ;
 
 
 
-- Question 8: Viết trigger sửa lại dữ liệu cho đúng:
-- Nếu người dùng nhập vào gender của account là nam, nữ, chưa xác định
-- Thì sẽ đổi lại thành M, F, U cho giống với cấu hình ở database


-- Question 9: Viết trigger không cho phép người dùng xóa bài thi mới tạo được 2 ngày
DROP TRIGGER IF EXISTS Trg_notDelExam ;
DELIMITER $$
	CREATE TRIGGER Trg_notDelExam
	BEFORE DELETE ON `exam`
	FOR EACH ROW
	BEGIN 
			IF NEW.CreateDate < DATE_SUB(CURDATE(), INTERVAL 2 DAY) THEN 
             SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT = " Cant del exam  ";
            END IF;
	END$$
DELIMITER ;
 
-- Question 10: Viết trigger chỉ cho phép người dùng chỉ được update, delete các question khi question đó chưa nằm trong exam nào
DROP TRIGGER IF EXISTS Trg_notDelExam ;
DELIMITER $$
	CREATE TRIGGER Trg_notDelExam
	BEFORE DELETE ON `examquestion`
	FOR EACH ROW
	BEGIN 
		IF(NEW.question	
	END$$
DELIMITER ;
 
-- Question 12: Lấy ra thông tin exam trong đó:
-- Duration <= 30 thì sẽ đổi thành giá trị "Short time"
-- 30 < Duration <= 60 thì sẽ đổi thành giá trị "Medium time"
-- Duration > 60 thì sẽ đổi thành giá trị "Long time"



-- Question 13: Thống kê số account trong mỗi group và in ra thêm 1 column nữa có tên là the_number_user_amount và mang giá trị được quy định như sau:
-- Nếu số lượng user trong group =< 5 thì sẽ có giá trị là few
-- Nếu số lượng user trong group <= 20 và > 5 thì sẽ có giá trị là normal
-- Nếu số lượng user trong group > 20 thì sẽ có giá trị là higher




-- Question 14: Thống kê số mỗi phòng ban có bao nhiêu user, nếu phòng ban nào không có user thì sẽ thay đổi giá trị 0 thành "Không có User"
        
