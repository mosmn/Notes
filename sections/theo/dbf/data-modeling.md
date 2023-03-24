# Demo PROJECT ERD


create a ERD using mermaid base on these tables primary keys(PK) and foreign keys(FK):
Contractors 

Contractor ID (PK) 

Contractor First Name 

Contractor Last Name 

Contractor Description 

Contractor Email 

Contractor Contact 

Contractor Hourly Rate 

Hire Date 

Service ID (FK) 

Customer ID (FK) 

 

Customers  

Customer ID (PK) 

Customer Name 

Customer Email 

Customer Phone 

Registration Date 

Contract Expiry Date 

Service ID (FK) 

Services 

Service ID (PK) 

Service Name 

Service Description 

Service category 

Unit Cost 

Lead time (time required for delivery or completion of the service) 

Availability 

Service reviews and ratings 

Contractor ID (FK) – Since this is only a list of services, we don’t need to add FK to this table. 

Customer ID (FK) – Since this is only a list of services, we don’t need to add FK to this table. 

 

Works 

Invoice Number (PK) 

Start date 

End date 

Cost 

Transaction Date 

Payment Method 

Status  (pending, in progress, completed, cancelled) 

Customer ID (FK) 

Contractor ID (FK) 

Service ID (FK)

```mermaid
erDiagram
    CONTRACTORS ||..|| SERVICES : is
    CONTRACTORS ||--o{ CUSTOMERS : serves
    CONTRACTORS ||--o{ WORKS : works
    CUSTOMERS ||--o{ WORKS : works
    SERVICES ||--o{ WORKS : works
    CONTRACTORS ||--|{ CONTRACTORS : is
    CUSTOMERS ||--|{ CUSTOMERS : is
    SERVICES ||--|{ SERVICES : is
    WORKS ||--|{ WORKS : is
    CONTRACTORS {
        string ContractorID
        string ContractorFirstName
        string ContractorLastName
        string ContractorDescription
        string ContractorEmail
        string ContractorContact
        string ContractorHourlyRate
        string HireDate
        string ServiceID
        string CustomerID
    }
    CUSTOMERS {
        string CustomerID
        string CustomerName
        string CustomerEmail
        string CustomerPhone
        string RegistrationDate
        string ContractExpiryDate
        string ServiceID
    }
    SERVICES {
        string ServiceID
        string ServiceName
        string ServiceDescription
        string ServiceCategory
        string UnitCost
        string LeadTime
        string Availability
        string ServiceReviewsAndRatings
    }
    WORKS {
        string InvoiceNumber
        string StartDate
        string EndDate
        string Cost
        string TransactionDate
        string PaymentMethod
        string Status
        string CustomerID
        string ContractorID
        string ServiceID
    }
```

