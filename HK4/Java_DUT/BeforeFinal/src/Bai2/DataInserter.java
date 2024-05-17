// Đưa dữ liệu vào bảng HOCVIEN
package Bai2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class DataInserter {
	private static final String queryInsert = "insert into HOCVIEN (MaHocVien, TenHocVien, NgaySinh, GioiTinh, DiemThi) Values (?, ?, ?, ?, ?)";
	
	public static void insertData(List<String> data) {
		try (Connection conn = DBCon.getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(queryInsert)) {
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			for (String line : data) {
				String maHocVien = line.substring(0, 10).trim();
				String tenHocVien = line.substring(10, 60).trim();
				String ngaySinhStr = line.substring(60, 70).trim();
				String gioiTinh = line.substring(70, 73).trim();
				float diemThi = Float.parseFloat(line.substring(73, 77).trim());
				
				java.util.Date ngaySinh = dateFormat.parse(ngaySinhStr);
				java.sql.Date sqlNgaySinh = new java.sql.Date(ngaySinh.getTime());
				
				pstmt.setString(1, maHocVien);
				pstmt.setString(2, tenHocVien);
				pstmt.setDate(3, sqlNgaySinh);
				pstmt.setString(4, gioiTinh);
				pstmt.setFloat(5, diemThi);
				pstmt.executeUpdate();
			}
			
		} catch (SQLException | ParseException e) {
			e.printStackTrace();
		}
	}
}
