package Source_ThanhTU;

import java.io.*;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.*;
public class baitap2 {
    public static void main(String s[]) throws ClassNotFoundException, SQLException, ParseException, IOException {
        String filePath = "D:\\GiaoPhan_Workspace\\HK4\\Java_DUT\\data-fnexam\\input.txt";
        String maHocVien, tenHocVien, ngaysinh, gioitinh, diemthi;

        // Kết nối CSDL
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/java_final_exam";
        Connection con = DriverManager.getConnection(url, "root", "");

        String sql = "INSERT INTO hocvien (MaHocVien, TenHocVien, NgaySinh, GioiTinh, DiemThi) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = con.prepareStatement(sql);

        int count = 0;
        try (BufferedWriter errorWriter = new BufferedWriter(new FileWriter("D:\\GiaoPhan_Workspace\\HK4\\Java_DUT\\data-fnexam\\error.txt", true))) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = br.readLine()) != null) {
                    count++;
                    if (line.length() >= 77) {
                        maHocVien = line.substring(0, 10).trim();
                        tenHocVien = line.substring(10, 60).trim();
                        ngaysinh = line.substring(60, 70).trim();
                        gioitinh = line.substring(70, 73).trim();
                        diemthi = line.substring(73, 77).trim();

                        try {
                            // Kiểm tra định dạng ngày sinh
                            dateFormat.setLenient(false);
                            dateFormat.parse(ngaysinh);

                            // Kiểm tra điểm có phải là số hợp lệ không
                            if (diemthi.matches("\\d+(\\.\\d+)?")) {
                                // Nếu là số hợp lệ, tiếp tục thực hiện insert vào CSDL
                                preparedStatement.setString(1, maHocVien);
                                preparedStatement.setString(2, tenHocVien);
                                preparedStatement.setDate(3, new java.sql.Date(dateFormat.parse(ngaysinh).getTime())); // Sử dụng setDate cho ngày sinh
                                preparedStatement.setString(4, gioitinh);
                                preparedStatement.setDouble(5, Double.parseDouble(diemthi));
                                preparedStatement.executeUpdate();
                            } else {
                                // Nếu điểm không phải là số hợp lệ, ghi lỗi vào file
                                errorWriter.write("Lỗi ở dòng " + count + ": Điểm không hợp lệ - " + diemthi);
                                errorWriter.newLine();
                            }
                        } catch (ParseException e) {
                            // Ghi lỗi vào file
                            errorWriter.write("Lỗi ở dòng " + count + ": Định dạng ngày sinh không hợp lệ - " + ngaysinh);
                            errorWriter.newLine();
                        }
                        System.out.println("ma hoc vien:" + maHocVien + ", ten hoc vien=" + tenHocVien + ",ngaysinh =" + ngaysinh + ", gioitinh =" + gioitinh + ", diemthi =" + diemthi);
                    } else {
                        errorWriter.write("Lỗi ở dòng " + count + ": Dòng không đủ độ dài");
                        errorWriter.newLine();
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                preparedStatement.close();
                con.close();
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
