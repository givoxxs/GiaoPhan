package Bai2_only_one;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class Main {
    public static void main(String[] args) {
        // Đường dẫn tới file input.txt và error.txt
        String inputFilePath = "D:\\GiaoPhan_Workspace\\HK4\\Java_DUT\\data-fnexam\\input.txt";
        String errorFilePath = "D:\\GiaoPhan_Workspace\\HK4\\Java_DUT\\data-fnexam\\error.txt";

        // Bước 1: Đọc dữ liệu từ file input.txt
        List<String> inputData = FileDataReader.readData(inputFilePath);
        
        // Bước 2: Đưa dữ liệu vào bảng HOCVIEN và ghi lại các lỗi vào file error.txt
        ErrorFileWriter.processAndLogErrors(inputData, errorFilePath);

        System.out.println("Chương trình đã hoàn thành!");
    }
}

class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/java_final_exam";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

class FileDataReader {
    public static List<String> readData(String fileName) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    lines.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
}

class ErrorFileWriter {
    private static final String INSERT_SQL = "INSERT INTO HOCVIEN (MaHocVien, TenHocVien, NgaySinh, GioiTinh, DiemThi) VALUES (?, ?, ?, ?, ?)";

    public static void processAndLogErrors(List<String> data, String errorFile) {
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(INSERT_SQL);
             BufferedWriter writer = new BufferedWriter(new FileWriter(errorFile))) {

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            for (int i = 0; i < data.size(); i++) {
                String line = data.get(i);
                try {
                    if (line.trim().isEmpty()) {
                        throw new Exception("empty String");
                    }

                    // Thêm khoảng trắng nếu dòng không đủ 77 ký tự
                    if (line.length() < 77) {
                        line = String.format("%-77s", line);
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
                } catch (SQLException | ParseException | NumberFormatException e) {
                    writer.write("Line " + (i + 1) + ": " + e.getMessage());
                    writer.newLine();
                } catch (Exception e) {
                    writer.write("Line " + (i + 1) + ": " + e.getMessage());
                    writer.newLine();
                }
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
