DROP DATABASE IF EXISTS TestingSystem;


CREATE DATABASE TestingSystem;
USE TestingSystem;

DROP DATABASE IF EXISTS Department;

CREATE TABLE Department(
	DepartmentId			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	DepartmentName			NVARCHAR(30) NOT NULL UNIQUE KEY
);	

CREATE TABLE `Position`(
	PositionId				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	PositionName			ENUM('Dev','Test','Scrum Master','PM') NOT NULL UNIQUE KEY
);	

CREATE TABLE `Account`(
	AccountId				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	Email					VARCHAR(50) NOT NULL UNIQUE KEY,
    Username				VARCHAR(50) NOT NULL UNIQUE KEY,
    Fullname				NVARCHAR(50) NOT NULL,
    DepartmentId			TINYINT UNSIGNED NOT NULL,
    PositionId				TINYINT UNSIGNED NOT NULL,
    CreatDate				DATETIME DEFAULT NOW(),
    FOREIGN KEY(DepartmentId) REFERENCES Department(DepartmentId),
    FOREIGN KEY(PositionId) REFERENCES `Position`(PositionId)
    
);	
CREATE TABLE `Group`(
	GroupId				    TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	GroupName				VARCHAR(50) NOT NULL UNIQUE KEY,
    CreatorId 				TINYINT UNSIGNED NOT NULL,
    CreateDate 				DATETIME DEFAULT NOW()
);	
CREATE TABLE GroupAccount(
	GroupId				    TINYINT UNSIGNED NOT NULL ,
	AccountId				TINYINT UNSIGNED NOT NULL,
    JoinDate 				DATETIME DEFAULT NOW(),
    PRIMARY KEY(GroupId,AccountId),
    FOREIGN KEY(GroupId)   	REFERENCES `Group`(GroupId),
    FOREIGN KEY(AccountId)  REFERENCES `Account`(AccountId)
);	

CREATE TABLE TypeQuestion(
	TypeId  				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	TypeName				ENUM('Essay', 'Multiple-Choice') NOT NULL
);
CREATE TABLE CategoryQuestion(
	CategoryId				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	CategoryName			VARCHAR(50) NOT NULL UNIQUE KEY
);
CREATE TABLE Question(
	QuestionId				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	Content					VARCHAR(50) NOT NULL UNIQUE KEY,
    CategoryId				TINYINT UNSIGNED NOT NULL UNIQUE KEY,
    TypeId                  TINYINT UNSIGNED NOT NULL,
    CreatorId				TINYINT UNSIGNED NOT NULL,
	FOREIGN KEY(CategoryId) REFERENCES CategoryQuestion(CategoryId),
    FOREIGN KEY(TypeId) 	REFERENCES TypeQuestion(TypeId),
    FOREIGN KEY(CreatorId) 	REFERENCES `Account`(AccountId)
);
DROP DATABASE IF EXISTS Answer;
CREATE TABLE Answer(
	AnswerId				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	Content					VARCHAR(50) NOT NULL UNIQUE KEY,
    QuestionId				TINYINT UNSIGNED NOT NULL,
    isCorrect 				ENUM('True','False'),
    FOREIGN KEY(QuestionId) REFERENCES Question(QuestionId)
);
CREATE TABLE Answer(
	AnswerId				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	Content					VARCHAR(50) NOT NULL UNIQUE KEY,
    QuestionId				TINYINT UNSIGNED NOT NULL,
    isCorrect 				ENUM('True','False')
);
CREATE TABLE Exam(
	ExamId					TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	`Code`					VARCHAR(50) NOT NULL UNIQUE KEY,
    Title				    VARCHAR(50) NOT NULL UNIQUE KEY,
    CategoryId				TINYINT UNSIGNED NOT NULL ,
    Duration				VARCHAR(3) NOT NULL,
    CreatorId				TINYINT UNSIGNED NOT NULL,
	CreateDate				DATETIME DEFAULT NOW(), 
    -- CONSTRAINT fk_CategoryQuestion FOREIGN KEY(CategoryId) REFERENCES CategoryQuestion(CategoryId),
	FOREIGN KEY(CreatorId) 	REFERENCES `Account`(AccountId)
);
CREATE TABLE ExamQuestion(
	ExamId					TINYINT UNSIGNED,
	QuestionId		 		TINYINT UNSIGNED NOT NULL UNIQUE KEY,
	FOREIGN KEY(ExamId) 	REFERENCES Exam(ExamId),
	FOREIGN KEY(QuestionId) REFERENCES Question(QuestionId),
    PRIMARY KEY(ExamId,QuestionId)
);
ALTER TABLE Exam ADD CONSTRAINT fk_CategoryQuestion FOREIGN KEY (CategoryId) REFERENCES CategoryQuestion(CategoryId);
-- INSERT INTO Department(DepartmentName)
--   VALUES 				(N'Hoai'),
-- 						(N'Nhan1'),
--                         (N'Nhan2'),
--                         (N'Nhan3'),
--                         (N'Nhan4'),
--                         (N'Nhan5'),
--                         (N'Nhan6'),
--                         (N'Nhan7');

-- INSERT INTO Exam(`Code`,Title,CategoryId,Duration,CreatorId)
--   VALUES                ('100','De thi 1',1,'90p',1),
-- 						('101','De thi 2',2,'90p',3),
-- 						('110','De thi 3',3,'90p',5),	
--                         ('111','De thi 4',4,'90p',8),
--                         ('000','De thi 5',5,'90p',13),
--                         ('001','De thi 6',6,'90p',21),
--                         ('010','De thi 7',7,'90p',34),
--                         ('011','De thi 8',8,'90p',55),
--                         ('1000','De thi 9',9,'90p',89),
--                         ('1001','De thi 10',10,'90p',100);
INSERT INTO CategoryQuestion(CategoryName)
  VALUES				('Java'),
						('.NET'),
						('Ruby'),
						('Csharp'),
						('JavaScript'),
						('Html'),
						('Css'),
						('SQL'),
						('Postman'),
						('C++');

                        
                        

  





