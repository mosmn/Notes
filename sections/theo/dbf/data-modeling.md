# Demo PROJECT ERD

```mermaid
erDiagram
    Contractors ||--|{ Works : "works for"
    Contractors ||--o{ Services : "provides"
    Customers ||--|{ Works : "hires"
    Customers ||--o{ Services : "requests"
    Works ||--o{ Services : "involves"
    Works ||--|{ Contractors : "employs"
    Works ||--|{ Customers : "requested by"
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

```mermaid
erDiagram
    Contractors ||--o{ Works : "performs"
    Customers ||--o{ Works : "requests"
    Works }o--|| Services : "contains"
    Works }|--|| Payments : "includes"
    Contractors {
        ContractorID (PK)
        ContractorFirstName
        ContractorLastName
        ContractorDescription
        ContractorEmail
        ContractorContact
        ContractorHourlyRate
        HireDate
    }
    Customers {
        CustomerID (PK)
        CustomerName
        CustomerEmail
        CustomerPhone
        RegistrationDate
        ContractExpiryDate
    }
    Services {
        ServiceID (PK)
        ServiceName
        ServiceDescription
        ServiceCategory
        UnitCost
        LeadTime
        Availability
        ServiceReviewsAndRatings
    }
    Works {
        InvoiceNumber (PK)
        StartDate
        EndDate
        Cost
        TransactionDate
        PaymentMethod
        Status
    }
    Payments {
        PaymentID (PK)
        PaymentAmount
        PaymentDate
        PaymentMethod
    }
```

```mermaid
erDiagram
    Contractors {
        Contractor_ID (PK)
        Contractor_First_Name
        Contractor_Last_Name
        Contractor_Description
        Contractor_Email
        Contractor_Contact
        Contractor_Hourly_Rate
        Hire_Date
        Service_ID (FK)
        Customer_ID (FK)
    }

    Customers {
        Customer_ID (PK)
        Customer_Name
        Customer_Email
        Customer_Phone
        Registration_Date
        Contract_Expiry_Date
        Service_ID (FK)
    }

    Services {
        Service_ID (PK)
        Service_Name
        Service_Description
        Service_Category
        Unit_Cost
        Lead_Time
        Availability
        Service_Reviews_Ratings
    }

    Works {
        Invoice_Number (PK)
        Start_Date
        End_Date
        Cost
        Transaction_Date
        Status
        Customer_ID (FK)
        Contractor_ID (FK)
        Service_ID (FK)
    }

    Contractors }|--|| Works
    Customers }|--|| Works
    Services }|--|| Works
```
