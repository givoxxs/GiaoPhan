#ifndef PRE_H
#define PRE_H
#include "Book.h"
#include "Person.h"
#include "Customer.h"
#include "Employee.h"
#include "Sold.h"
#include "Save.h"
#include <iostream>
#include <vector>
#include <string.h>
#include <iomanip>
#include <fstream>
#include <sstream>

void canhtren(int x);
void canhnoi(int x);
void canhduoi(int x);


extern int solds[100];


struct Node_Book {
    Book data;
    Node_Book *next;

    Node_Book(const Book& _data) : data(_data), next(nullptr) {}
};
extern Node_Book *headBook;

struct Node_Cus {
    customer data;
    Node_Cus *next;

    Node_Cus(const customer& _data) : data(_data), next(nullptr) {}
};
extern Node_Cus *headCus;

struct Node_Emp {
    employee data;
    Node_Emp *next;

    Node_Emp(const employee& _data) : data(_data), next(nullptr) {}
};
extern Node_Emp *headEmp;

struct Node_Save {
    Save data;
    Node_Save *next;

    Node_Save(const Save& _data) : data(_data), next(nullptr) {}
};
extern Node_Save *headSave;


void create_book_list();
void create_cus_list();
void create_emp_list();
void create_sold_list();
void create_save_list();
void thay_doi_tep_books();
void thay_doi_tep_customers();
void thay_doi_tep_employees();
void thay_doi_tep_save();


//ham lay so tu chuoi
#endif
