

-- 2. Viết lệnh để
-- a) Lấy tất cả các sinh viên chưa có đề tài hướng dẫn
-- b) Lấy ra số sinh viên làm đề tài ‘DeTai 6’
SELECT sv.* FROM huongdan hd
RIGHT JOIN sinhvien sv ON sv.Id_SV = hd.Id_SV
WHERE hd.Id_SV IS NULL;

SELECT COUNT(hd.Id_SV) AS So_sv_detai6 FROM huongdan hd
JOIN sinhvien sv ON sv.Id_SV = hd.Id_SV
JOIN detai dt    ON dt.Id_DeTai = hd.Id_DeTai
WHERE hd.Id_DeTai = 6
GROUP BY hd.Id_DeTai
HAVING COUNT(hd.Id_SV);
-- 3. Tạo view có tên là "SinhVienInfo" lấy các thông tin về học sinh bao gồm:
--    mã số, họ tên và tên đề tài
--   (Nếu sinh viên chưa có đề tài thì column tên đề tài sẽ in ra "Chưa có")
CREATE OR REPLACE VIEW SinhVienInfo AS
	 SELECT sv.Id_SV,sv.Ten_SV,dt.Ten_DeTai FROM huongdan hd
	 JOIN sinhvien sv      ON sv.Id_SV = hd.Id_SV
	 JOIN detai dt         ON dt.Id_DeTai = hd.Id_DeTai
     UNION
     SELECT sv.Id_SV,sv.Ten_SV, 'Chua co' FROM sinhvien sv
     LEFT JOIN huongdan hd ON sv.Id_SV = hd.Id_SV
     WHERE hd.Id_SV IS NULL;
-- 4. Tạo trigger cho table SinhVien khi insert sinh viên có năm sinh <= 1950
-- thì hiện ra thông báo "Moi ban kiem tra lai nam sinh"
DROP TRIGGER IF EXISTS Trg_KiemTraNamSinh;
DELIMITER $$
		CREATE TRIGGER Trg_KiemTraNamSinh
        BEFORE INSERT ON sinhvien
        FOR EACH ROW
        BEGIN
			IF(NEW.NamSinh <= 1950) THEN
            SIGNAL SQLSTATE '12345'
            SET MESSAGE_TEXT = "Moi ban kiem tra lai nam sinh";
            END IF;
        END$$
DELIMITER ;         
INSERT INTO `ql_doan`.`sinhvien`(`Ten_SV` , `NamSinh` , `QueQuan`)
		VALUES					('sinhvien11' , '1988' ,'Hatay');	
-- 5. Hãy cấu hình table sao cho khi xóa 1 sinh viên nào đó thì sẽ tất cả thông
-- tin trong table HuongDan liên quan tới sinh viên đó sẽ bị xóa đi
ALTER TABLE huongdan DROP FOREIGN KEY fk_hd_SinhVien;
ALTER TABLE huongdan ADD CONSTRAINT  fk_hd_SinhVien FOREIGN KEY(Id_SV)
REFERENCES sinhvien(Id_SV) ON DELETE CASCADE;

-- 6. Viết 1 Procedure để khi nhập vào tên của sinh viên thì sẽ thực hiện xóa toàn bộ thông tin
-- liên quan của sinh viên trên hệ thống:-- 
DROP PROCEDURE IF EXISTS sp_XoaSinhVien;
DELIMITER $$
CREATE PROCEDURE sp_XoaSinhVien(IN in_tensinhvien VARCHAR(50) )
			BEGIN
			    DECLARE v_IDsinhvien TINYINT;
                SELECT sv.Id_SV INTO v_IDsinhvien FROM sinhvien
                WHERE  sv.Ten_SV = in_tensinhvien;
                DELETE FROM `ql_doan`.`huongdan` WHERE Id_SV = v_IDsinhvien;
                DELETE FROM `ql_doan`.`sinhvien` WHERE Id_SV = v_IDsinhvien;                                        
			END$$
DELIMITER ;
CALL sp_XoaSinhVien('sinhvien11');







