#include "Employee.h"
#include "Prepare.h"
#include "MyLib.h"
#include "EmployeeLib_Menu.h"
#include <iostream>
#include <iomanip>
#include <string>
using namespace std;

employee::employee() {}

employee::employee(string id, string name, string phone_number, int wage, string cic, string address, int yob) : person(id, name, phone_number, yob)
{
    this->CICard = cic;
    this->address = address;
    this->wage = wage;
}

employee::~employee() {}

string employee::get_CI()
{
    return this->CICard;
}

string employee::getAddress()
{
    return this->address;
}

int employee::get_wage()
{
    return wage;
}

int employee::get_salary() {
    return this->wage*1700000;
}

void employee::set_wage(int wage)
{
    this->wage = wage;
}

employee employee::add()
{
    getchar();
    int new_id;
    Node_Emp *current = headEmp;
    while (current->next != nullptr)
    {
        current = current->next;
    }
    new_id = get_number_from_string(current->data.get_id()) + 1;
    string temp = "NV" + to_string(new_id);
    this->id = temp;
    int x = 80, y = 5, h = 2;
    system("cls");
    bar_Add_Employee();
    gotoXY(x + 11, y + 1);
    cout << temp;  
    gotoXY(x + 12, y + 3);
    getline(cin, name);
    gotoXY(x + 16, y + 5);
    getline(cin, phone_number);
    gotoXY(x + 11, y + 7);
    cin >> year_of_birthday;
    getchar();
    gotoXY(x + 12, y + 9);
    getline(cin, CICard);
    gotoXY(x + 25, y + 11);
    getline(cin, address);
    gotoXY(x + 14, y + 13);
    cin >> wage;
    Node_Emp *newNode = new Node_Emp(*this);
    if (headEmp == nullptr)
    {
        headEmp = newNode;
    }
    else
    {
        Node_Emp *current = headEmp;
        while (current->next != nullptr)
        {
            current = current->next;
        }
        current->next = newNode;
    }
    return *this;
}

void employee::add_new_emp()
{
    employee newemp;
    newemp.add();
    gotoXY(80, 5 + 16);
    ofstream inventoryFile("employees.txt", ios::app);

    if (!inventoryFile)
    {
        cerr << "Khong the mo employees.txt de ghi du lieu." << endl;
        return;
    }
    inventoryFile << newemp.get_id() << ","
                  << newemp.get_name() << ","
                  << newemp.get_phone_num() << ","
                  << newemp.get_year_of_birthday() << ","
                  << newemp.get_CI() << ","
                  << newemp.getAddress() << ","
                  << newemp.get_wage() << "," << endl;
    inventoryFile.close();
    cout << "Nhan vien da duoc them vao tep" << endl;
    gotoXY(80, 5 + 17);
    system("pause");
}

void employee::display()
{
    cout << setiosflags(ios::left) << setw(10) << id;
    cout << setw(30) << name;
    cout << setw(18) << phone_number;
    cout << setw(14) << year_of_birthday;
    cout << setw(20) << CICard;
    cout << setw(20) << address;
    cout << setw(20) << wage*1250000;
    cout << endl;
}

void employee::display_All()
{
    cout << setiosflags(ios::left) << setw(10) << "ID";
    cout << setw(30) << "Ten nhan vien";
    cout << setw(18) << "So dien thoai";
    cout << setw(14) << "Nam sinh";
    cout << setw(20) << "Can cuoc cong dan";
    cout << setw(20) << "Dia chi";
    cout << setw(20) << "Luong";
    cout << endl
         << endl;
    Node_Emp *current = headEmp;
    while (current != nullptr)
    {
        current->data.display();
        cout << endl;
        current = current->next;
    }
}

void employee::re_wage()
{
    int x = 70, y = 14;
    string thay_doi = "";
    gotoXY(x + 15, y + 1);
    cin >> thay_doi;
    Node_Emp *current = headEmp;
    while (current != nullptr)
    {
        if (no_space(current->data.get_id()) == no_space(thay_doi))
        {
            int new_wage = 0;
            gotoXY(x + 20 + 7, y + 3);
            cin >> new_wage;
            current->data.set_wage(new_wage);
            gotoXY(70, 14 + 10);
            cout << "Thay doi thanh cong!!!" << endl;
            gotoXY(70, 14 + 11);
            return;
        }
        current = current->next;
    }
    thay_doi = "";
    gotoXY(70, 14 + 10);
    cout << "Thay doi chua thanh cong!!!" << endl;
    gotoXY(70, 14 + 11);
}

void employee::re_phone()
{
    int x = 70, y = 14;
    string thay_doi = "";
    gotoXY(x + 15, y + 1);
    cin >> thay_doi;

    Node_Emp *current = headEmp;
    while (current != nullptr)
    {
        if (no_space(current->data.get_id()) == no_space(thay_doi))
        {
            gotoXY(x + 22 + 7, y + 3);
            current->data.re_phone_num();
            gotoXY(70, 14 + 10);
            cout << "Thay doi thanh cong!!!" << endl;
            gotoXY(70, 14 + 11);
            return;
        }
        current = current->next;
    }
    thay_doi = "";
    gotoXY(70, 14 + 10);
    cout << "Thay doi chua thanh cong!!!" << endl;
    gotoXY(70, 14 + 11);
}

void employee::search()
{
    int choose, n = 3, count;
    string nd[n], nd1;
    nd[0] = "Tim theo TEN / Search by Name";
    nd[1] = "Tim theo LUONG / Search by Wage";
    nd[2] = "THOAT / EXIT";
    nd1 = "         TUY CHON TIM KIEM / CHANGE OPTIONS";

    do
    {
        system("cls");
        system("cls");
        box(70 - 2, 5 - 2, 50 + 4, 2 + 12, 11, 75, nd1);
        choose = Menu(70, 5, 50, 2, 11, 75, nd, n);
        std::string searching = "";
        int searching2 = 0.0;
        switch (choose)
        {
        case 0:
        {
            searching = bar_Search_Employee_1("Ten Nhan vien");
            Node_Emp *current = headEmp;
            while (current != nullptr)
            {
                current->data.search_name(searching);
                current = current->next;
            }
            system("pause");
            break;
        }
        case 1:
        {
            searching2 = bar_Search_Employee_2("He So Luong");
            Node_Emp *current = headEmp;
            while (current != nullptr)
            {
                current->data.search_wage(searching2);
                current = current->next;
            }
            system("pause");
            break;
        }
        case 2:
        {
            break;
        }
        }
    } while (n - choose - 1);
}

void employee::change()
{
    int choose, n = 4;
    string nd[n], nd1;
    nd[0] = "Thay doi he so luong / Change wage";
    nd[1] = "Thay doi so dien thoai / Change phone number";
    nd[2] = "Thay doi dia chi / Change Address";
    nd[3] = "THOAT / EXIT";
    nd1 = "         TUY CHON THAY DOI / CHANGE OPTIONS";

    do
    {
        system("cls");
        system("cls");
        box(70 - 2, 5 - 2, 50 + 4, 2 + 15, 11, 75, nd1);
        choose = Menu(70, 5, 50, 2, 11, 75, nd, n);
        // bar_Change();
        switch (choose)
        {
        case 0:
            bar_Change("He so luong");
            employee::re_wage();
            thay_doi_tep_employees();
            system("pause");
            break;
        case 1:
            bar_Change("So dien thoai");
            employee::re_phone();
            thay_doi_tep_employees();
            system("pause");
            break;
        case 2:
            bar_Change("Dia chi");
            employee::re_address();
            thay_doi_tep_employees();
            system("pause");
            break;
        case 3:
            break;
        }
    } while (n - choose - 1);
}

void employee::search_wage(int search)
{
    if (search == get_wage())
    {
        this->display();
        cout << endl;
    }
}

void employee::re_address()
{
    int x = 70, y = 14;
    string thay_doi = "";

    gotoXY(x + 15, y + 1);
    cin >> thay_doi;

    Node_Emp *current = headEmp;
    while (current != nullptr)
    {
        if (no_space(current->data.get_id()) == no_space(thay_doi))
        {
            string new_address = "";
            gotoXY(x + 22, y + 3);
            getchar();
            getline(cin, new_address);
            current->data.set_address(new_address);
            gotoXY(70, 14 + 10);
            cout << "Thay doi thanh cong!!!" << endl;
            gotoXY(70, 14 + 11);
            return;
        }
        current = current->next;
    }
    thay_doi = "";
    gotoXY(70, 14 + 10);
    cout << "Thay doi chua thanh cong!!!" << endl;
    gotoXY(70, 14 + 11);
}

void employee::set_address(string address)
{
    this->address = address;
}

void employee::delete_emp()
{
    string id_dlt;
    cout << "Nhap vao ID nhan vien can xoa: ";
    cin >> id_dlt;
    Node_Emp *current = headEmp;
    Node_Emp *previous = nullptr;
    while (current != nullptr)
    {
        if (current->data.get_id() == id_dlt)
        {
            if (previous != nullptr)
            {
                previous->next = current->next;
            }
            else
            {
                headEmp = current->next;
            }
            delete current;
            break;
        }
        previous = current;
        current = current->next;
    }
    thay_doi_tep_employees();
}

