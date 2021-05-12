
                                                        -- ///////////////////////////////////////////////////////////// --


DROP DATABASE IF EXISTS  QL_DoAn;
CREATE DATABASE  QL_DoAn;
USE  QL_DoAn;
/*============================== CREATE TABLE=== =======================================*/
/*======================================================================================*/

-- create table 1: GiangVien
DROP TABLE IF EXISTS GiangVien;
CREATE TABLE GiangVien(
	Id_GV  			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    Ten_GV			CHAR(50) NOT NULL ,
    Tuoi			TINYINT UNSIGNED NOT NULL,
    HocVi			NVARCHAR(50) 
);
DROP TABLE IF EXISTS SinhVien;
CREATE TABLE SinhVien(
	Id_SV			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	Ten_SV			CHAR(50) NOT NULL ,
    NamSinh			VARCHAR(10) NOT NULL,
    QueQuan			VARCHAR(50) NOT NULL
);
DROP TABLE IF EXISTS DeTai;
CREATE TABLE DeTai(
	Id_DeTai			TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	Ten_DeTai			CHAR(50) NOT NULL UNIQUE KEY
);
DROP TABLE IF EXISTS HuongDan;
CREATE TABLE HuongDan(
	Id				TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	Id_SV			TINYINT UNSIGNED  NOT NULL,
    Id_DeTai		TINYINT UNSIGNED  NOT NULL,
    Id_GV  			TINYINT UNSIGNED  NOT NULL,
    Diem			TINYINT UNSIGNED NOT NULL,
    CONSTRAINT fk_hd_SinhVien  FOREIGN KEY(Id_SV) 	    REFERENCES `SinhVien`(Id_SV),
    CONSTRAINT fk_hd_DeTai     FOREIGN KEY(Id_DeTai) 	REFERENCES `DeTai`(Id_DeTai),
    CONSTRAINT fk_hd_GiangVien FOREIGN KEY(Id_GV) 		REFERENCES `GiangVien`(Id_GV)
);
-- Add Giang_Vien
INSERT INTO `ql_doan`.`giangvien` (`Id_GV`, `Ten_GV`, `Tuoi`, `HocVi`) VALUES ('1', 'Giảng Viên 1', '42', 'Ths');
INSERT INTO `ql_doan`.`giangvien` (`Id_GV`, `Ten_GV`, `Tuoi`, `HocVi`) VALUES ('2', 'Giảng Viên 2', '43', 'PGS');
INSERT INTO `ql_doan`.`giangvien` (`Id_GV`, `Ten_GV`, `Tuoi`, `HocVi`) VALUES ('3', 'Giảng viên 3', '44', 'Ts');
INSERT INTO `ql_doan`.`giangvien` (`Id_GV`, `Ten_GV`, `Tuoi`, `HocVi`) VALUES ('4', 'Giảng viên 4', '45', 'GS');
INSERT INTO `ql_doan`.`giangvien` (`Id_GV`, `Ten_GV`, `Tuoi`, `HocVi`) VALUES ('5', 'Giảng viên 5', '46', 'Ths');
INSERT INTO `ql_doan`.`giangvien` (`Id_GV`, `Ten_GV`, `Tuoi`, `HocVi`) VALUES ('6', 'Giảng viên 6', '47', 'Ts');
INSERT INTO `ql_doan`.`giangvien` (`Id_GV`, `Ten_GV`, `Tuoi`, `HocVi`) VALUES ('7', 'Giảng viên 7', '48', 'GS');
INSERT INTO `ql_doan`.`giangvien` (`Id_GV`, `Ten_GV`, `Tuoi`, `HocVi`) VALUES ('8', 'Giảng viên 8', '60', 'PGS');
INSERT INTO `ql_doan`.`giangvien` (`Id_GV`, `Ten_GV`, `Tuoi`, `HocVi`) VALUES ('9', 'Giảng viên 9', '80', 'Ths');
INSERT INTO `ql_doan`.`giangvien` (`Id_GV`, `Ten_GV`, `Tuoi`, `HocVi`) VALUES ('10', 'Giảng viên 10', '50', 'Ths');
-- Add đề tài 
INSERT INTO `ql_doan`.`detai` (`Id_DeTai`, `Ten_DeTai`) VALUES ('3', 'đề tài 3');
INSERT INTO `ql_doan`.`detai` (`Id_DeTai`, `Ten_DeTai`) VALUES ('4', 'đề tài 4');
INSERT INTO `ql_doan`.`detai` (`Id_DeTai`, `Ten_DeTai`) VALUES ('5', 'đề tài 5');
INSERT INTO `ql_doan`.`detai` (`Id_DeTai`, `Ten_DeTai`) VALUES ('6', 'đề tài 6');
INSERT INTO `ql_doan`.`detai` (`Id_DeTai`, `Ten_DeTai`) VALUES ('7', 'đề tài 7');
INSERT INTO `ql_doan`.`detai` (`Id_DeTai`, `Ten_DeTai`) VALUES ('8', 'đề tài 8');
INSERT INTO `ql_doan`.`detai` (`Id_DeTai`, `Ten_DeTai`) VALUES ('9', 'đề tài 9');
INSERT INTO `ql_doan`.`detai` (`Id_DeTai`, `Ten_DeTai`) VALUES ('10', 'đề tài 10');
