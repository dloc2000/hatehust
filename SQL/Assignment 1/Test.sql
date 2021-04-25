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
	CategoryName			VARCHAR(50) NOT NULL
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
    CategoryId				TINYINT UNSIGNED NOT NULL,
    Duration				TINYINT UNSIGNED NOT NULL,
    CreatorId				TINYINT UNSIGNED NOT NULL,
    CreateDate				DATETIME DEFAULT NOW(),
    FOREIGN KEY(CategoryId) REFERENCES CategoryQuestion(CategoryId),
	FOREIGN KEY(CreatorId) 	REFERENCES `Account`(AccountId)
);
CREATE TABLE ExamQuestion(
	ExamId					TINYINT UNSIGNED,
	QuestionId		 	TINYINT UNSIGNED NOT NULL UNIQUE KEY,
	FOREIGN KEY(ExamId) REFERENCES Exam(ExamId),
	FOREIGN KEY(QuestionId) 	REFERENCES Question(QuestionId),
    PRIMARY KEY(ExamId,QuestionId)
);
INSERT INTO Department(DepartmentName)
  VALUES 				(N'Hoai'),
						(N'Nhan1'),
                        (N'Nhan2'),
                        (N'Nhan3'),
                        (N'Nhan4'),
                        (N'Nhan5'),
                        (N'Nhan6'),
                        (N'Nhan7')
                        

  





