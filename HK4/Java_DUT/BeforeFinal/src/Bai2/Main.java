package Bai2;

import java.util.List;

public class Main {
	public static void main(String[] args) {
        // Đọc dữ liệu từ file input.txt
        String inputFile = "D:\\GiaoPhan_Workspace\\HK4\\Java_DUT\\data-fnexam\\input.txt";
        List<String> data = FileDataReader.readData(inputFile);

        // Chèn dữ liệu vào cơ sở dữ liệu và ghi lại lỗi vào file error.txt
        String errorFile = "D:\\GiaoPhan_Workspace\\HK4\\Java_DUT\\data-fnexam\\error.txt";
        ErrorFileWriter.processAndLogErrors(data, errorFile);

        System.out.println("Quá trình xử lý hoàn tất. Kiểm tra file error.txt để xem các lỗi (nếu có).");
    }
}
