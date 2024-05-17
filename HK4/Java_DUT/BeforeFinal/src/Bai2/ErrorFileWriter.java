package Bai2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class ErrorFileWriter {
    private static final String INSERT_SQL = "INSERT INTO HOCVIEN (MaHocVien, TenHocVien, NgaySinh, GioiTinh, DiemThi) VALUES (?, ?, ?, ?, ?)";

    public static void processAndLogErrors(List<String> data, String errorFile) {
        try (Connection conn = DBCon.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(INSERT_SQL);
             BufferedWriter writer = new BufferedWriter(new FileWriter(errorFile))) {

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            for (int i = 0; i < data.size(); i++) {
                String line = data.get(i);
                try {
                    if (line.length() < 77) {
                        throw new IllegalArgumentException("Line length is less than expected: " + line.length());
                    }
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
                } catch (SQLException | ParseException | IllegalArgumentException e) {
                    writer.write("Line " + (i + 1) + ": " + e.getMessage());
                    writer.newLine();
                }
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
