# Demo PROJECT ERD


erDiagram
    Contractors ||--|{ Works : "works for"}
    Contractors ||--o{ Services : "provides"}
    Customers ||--|{ Works : "hires"}
    Customers ||--o{ Services : "requests"}
    Works ||--o{ Services : "involves"}
    Works ||--|{ Contractors : "employs"}
    Works ||--|{ Customers : "requested by"}
    Contractors {
        int Contractor_ID (PK)
        string Contractor_First_Name
        string Contractor_Last_Name
        string Contractor_Description
        string Contractor_Email
        string Contractor_Contact
        float Contractor_Hourly_Rate
        date Hire_Date
        int Service_ID (FK)
        int Customer_ID (FK)
    }
    Customers {
        int Customer_ID (PK)
        string Customer_Name
        string Customer_Email
        string Customer_Phone
        date Registration_Date
        date Contract_Expiry_Date
        int Service_ID (FK)
    }
    Services {
        int Service_ID (PK)
        string Service_Name
        string Service_Description
        string Service_Category
        float Unit_Cost
        int Lead_Time
        boolean Availability
        int Service_Reviews_and_Ratings
    }
    Works {
        int Invoice_Number (PK)
        date Start_Date
        date End_Date
        float Cost
        date Transaction_Date
        string Payment_Method
        string Status
        int Customer_ID (FK)
        int Contractor_ID (FK)
        int Service_ID (FK)
    }

```mermaid
erDiagram
    Contractors ||--|{ Works : "works for"}
    Contractors ||--o{ Services : "provides"}
    Customers ||--|{ Works : "hires"}
    Customers ||--o{ Services : "requests"}
    Works ||--o{ Services : "involves"}
    Works ||--|{ Contractors : "employs"}
    Works ||--|{ Customers : "requested by"}
    Contractors {
        int Contractor_ID (PK)
        string Contractor_First_Name
        string Contractor_Last_Name
        string Contractor_Description
        string Contractor_Email
        string Contractor_Contact
        float Contractor_Hourly_Rate
        date Hire_Date
        int Service_ID (FK)
        int Customer_ID (FK)
    }
    Customers {
        int Customer_ID (PK)
        string Customer_Name
        string Customer_Email
        string Customer_Phone
        date Registration_Date
        date Contract_Expiry_Date
        int Service_ID (FK)
    }
    Services {
        int Service_ID (PK)
        string Service_Name
        string Service_Description
        string Service_Category
        float Unit_Cost
        int Lead_Time
        boolean Availability
        int Service_Reviews_and_Ratings
    }
    Works {
        int Invoice_Number (PK)
        date Start_Date
        date End_Date
        float Cost
        date Transaction_Date
        string Payment_Method
        string Status
        int Customer_ID (FK)
        int Contractor_ID (FK)
        int Service_ID (FK)
    }
```

[]: # ## Pointers to Structures
[]: # 
[]: # - We can declare pointers to structures.
[]: # - The syntax is similar to that of declaring pointers to other data types.
[]: # ```C++
[]: # struct person
[]: # {
[]: #     char name[20];
[]: #     int age;
[]: #     float salary;
[]: # };
[]: # 
[]: # int main()
[]: # {
[]: #     struct person p1;
[]: #     struct person *ptr; // or we can just write struct person *ptr = &p1;
[]: #     ptr = &p1;
[]: #     cout << "Enter name: ";
[]: #     cin >> ptr->name;
[]: #     cout << "Enter age: ";
[]: #     cin >> ptr->age;
