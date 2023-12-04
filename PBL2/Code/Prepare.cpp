#include "Prepare.h"
#include <string>
#include <iostream>
using namespace std;

void canhtren(int x)
{
    std::cout << char(218);
    for (int i = 0; i < x; i++)
    {
        std::cout << char(196);
    }
    std::cout << char(191);
    std::cout << std::endl;
}

void canhduoi(int x)
{
    std::cout << char(192);
    for (int i = 0; i < x; i++)
    {
        std::cout << char(196);
    }
    std::cout << char(217);
    std::cout << std::endl;
}

void canhnoi(int x)
{
    std::cout << char(195);
    for (int i = 0; i < x; i++)
    {
        std::cout << char(196);
    }
    std::cout << char(180);
    std::cout << std::endl;
}

Node_Book *headBook = NULL;
Node_Cus *headCus = NULL;
Node_Emp *headEmp = NULL;
Node_Save *headSave = NULL;

vector<Save> saveOrder;
int solds[100] = {0};

void create_book_list()
{
    ifstream inventoryFile("books.txt");
    if (!inventoryFile)
    {
        cerr << "Không thể mở tệp books.txt để đọc dữ liệu." << endl;
        return;
    }

    string line;
    Node_Book *current = nullptr; // Con trỏ trỏ đến nút cuối cùng của danh sách

    while (getline(inventoryFile, line))
    {
        stringstream ss(line);
        string item;
        int id;
        string title, author, genre, publisher, bookShelves, language;
        int price, quantity, publishingYear;

        getline(ss, item, ',');
        stringstream(item) >> id;

        getline(ss, title, ',');
        getline(ss, author, ',');
        getline(ss, genre, ',');

        getline(ss, item, ',');
        stringstream(item) >> price;

        getline(ss, item, ',');
        stringstream(item) >> quantity;

        getline(ss, publisher, ',');
        getline(ss, item, ',');
        stringstream(item) >> publishingYear;

        getline(ss, bookShelves, ',');
        getline(ss, language, ',');

        Book book(id, title, author, genre, price, quantity, publisher, publishingYear, bookShelves, language);

        Node_Book *newNode = new Node_Book(book);

        if (headBook == nullptr)
        {
            // Danh sách liên kết đang trống, nút mới làm nút đầu tiên và nút cuối cùng
            headBook = newNode;
            current = newNode;
        }
        else
        {
            // Thêm nút mới vào cuối danh sách liên kết
            current->next = newNode;
            current = newNode;
        }
    }

    inventoryFile.close();
}

void thay_doi_tep_books()
{
    std::ofstream outputFile("books.txt");
    if (outputFile.is_open())
    {
        Node_Book *current = headBook;
        while (current != nullptr)
        {
            outputFile << current->data.get_id() << ","
                       << current->data.get_title() << ","
                       << current->data.get_author() << ","
                       << current->data.get_genre() << ","
                       << current->data.get_price() << ","
                       << current->data.get_quantity() << ","
                       << current->data.get_publisher() << ","
                       << current->data.get_publishingYear() << ","
                       << current->data.get_bookShelves() << ","
                       << current->data.get_language() << endl;

            current = current->next;
        }

        outputFile.close();
    }
}

void create_cus_list()
{
    ifstream inventoryFile("customers.txt");
    if (!inventoryFile)
    {
        cerr << "Không thể mở tệp customers.txt để đọc dữ liệu." << endl;
        return;
    }

    string line;
    Node_Cus *current = nullptr;
    while (getline(inventoryFile, line))
    {
        stringstream ss(line);
        string item1, item2;
        int year, point;
        string id, name, phone_number;

        getline(ss, id, ',');
        getline(ss, name, ',');
        getline(ss, phone_number, ',');

        getline(ss, item1, ',');
        stringstream(item1) >> year;
        getline(ss, item2, ',');
        stringstream(item2) >> point;
        customer a(id, name, phone_number, year, point);
        Node_Cus *newNode = new Node_Cus(a);

        if (headCus == nullptr)
        {
            // Danh sách liên kết đang trống, nút mới làm nút đầu tiên và nút cuối cùng
            headCus = newNode;
            current = newNode;
        }
        else
        {
            // Thêm nút mới vào cuối danh sách liên kết
            current->next = newNode;
            current = newNode;
        }
    }

    inventoryFile.close();
}

void thay_doi_tep_customers()
{
    ofstream outputFile("customers.txt");
    if (outputFile.is_open())
    {
        Node_Cus *current = headCus;
        while (current != nullptr)
        {
            outputFile << current->data.get_id() << ","
                       << current->data.get_name() << ","
                       << current->data.get_phone_num() << ","
                       << current->data.get_year_of_birthday() << ","
                       << current->data.get_point() << endl;
            current = current->next;
        }
        outputFile.close();
    }
}

void create_emp_list()
{
    ifstream inventoryFile("employees.txt");
    if (!inventoryFile)
    {
        cerr << "Không thể mở tệp employees.txt để đọc dữ liệu." << endl;
        return;
    }

    string line;
    Node_Emp *current = nullptr;
    while (getline(inventoryFile, line))
    {
        stringstream ss(line);
        string item;
        int year_of_birthday;
        float wage;
        string id, name, phone_number, CICard, address;

        getline(ss, id, ',');

        getline(ss, name, ',');
        getline(ss, phone_number, ',');

        getline(ss, item, ',');
        stringstream(item) >> year_of_birthday;

        getline(ss, CICard, ',');
        getline(ss, address, ',');

        getline(ss, item, ',');
        stringstream(item) >> wage;
        employee a(id, name, phone_number, wage, CICard, address, year_of_birthday);
        Node_Emp *newNode = new Node_Emp(a);

        if (headEmp == nullptr)
        {
            headEmp = newNode;
            current = newNode;
        }
        else
        {

            current->next = newNode;
            current = newNode;
        }
    }

    inventoryFile.close();
}

void thay_doi_tep_employees()
{
    ofstream outputFile("employees.txt");
    if (outputFile.is_open())
    {
        Node_Emp *current = headEmp;
        while (current != nullptr)
        {
            outputFile << current->data.get_id() << ","
                       << current->data.get_name() << ","
                       << current->data.get_phone_num() << ","
                       << current->data.get_year_of_birthday() << ","
                       << current->data.get_CI() << ","
                       << current->data.getAddress() << ","
                       << current->data.get_wage() << endl;

            current = current->next;
        }
        outputFile.close();
    }
}

void create_save_list()
{
    ifstream inputFile("save.txt");

    if (inputFile.is_open())
    {
        string line;
        Node_Save *current = nullptr;
        while (getline(inputFile, line))
        {
            istringstream iss(line);
            string order_id;
            int year, month, day, hour, minute, second;
            string id_nhanvien;
            string sdt_cus;
            vector<sold> items;

            // Đọc dữ liệu từ mỗi dòng
            iss >> order_id >> year >> month >> day >> hour >> minute >> second >> id_nhanvien >> sdt_cus;

            int book_id, book_qtt;
            while (iss >> book_id >> book_qtt)
            {
                sold item;
                item.set_book_id(book_id);
                item.set_book_qtt(book_qtt);
                items.push_back(item);
            }

            Date date(year, month, day, hour, minute, second);

            Save a(order_id, date, id_nhanvien, sdt_cus, items);

            Node_Save*newNode = new Node_Save(a);

            if (headSave == nullptr)
            {
                headSave = newNode;
                current = newNode;
            }
            else
            {

                current->next = newNode;
                current = newNode;
            }
        }

        inputFile.close();

        // Bây giờ bạn đã có vector s chứa các đối tượng Save và sold từ tệp tin.
    }
    else
    {
        std::cerr << "Không thể mở tệp tin save.txt" << std::endl;
    }
}

void thay_doi_tep_save()
{

    // Điền vector s với dữ liệu

    std::ofstream outputFile("save.txt");

    if (outputFile.is_open())
    {
        Node_Save *current =  headSave;
        while(current!=nullptr) 
        {
            // ghi ma hoa don
            outputFile << current->data.getOrder_id() << " ";
            // Ghi thông tin ngày
            outputFile << current->data.getDate().getYear() << " " << current->data.getDate().getMonth() << " " << current->data.getDate().getDay() << " ";
            outputFile << current->data.getDate().getHour() << " " << current->data.getDate().getMinute() << " " << current->data.getDate().getSecond() << " ";

            // Ghi mã nhân viên
            outputFile << current->data.getEmp_id() << " ";
            // ghi ma khach hang
            outputFile << current->data.getSdt_cus() << " ";

            // Ghi thông tin về sách
            for (int i = 0; i < current->data.getSave().size(); i++)
            {
                outputFile << current->data.getSave()[i].get_book_id() << " " << current->data.getSave()[i].get_book_qtt() << " ";
            }

            // Xuống dòng cho dòng tiếp theo
            outputFile << "\n";
            current=current->next;
        }

        outputFile.close();
    }
    else
    {
        std::cerr << "Không thể mở tệp tin save.txt để ghi dữ liệu." << std::endl;
    }
}