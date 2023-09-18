# Introduction to Data Modeling

Data modeling is a crucial aspect of database design that involves defining how data is stored, organized, and related to meet the information needs of an application or system. It plays a vital role in ensuring that data is structured efficiently for storage and retrieval. Data modeling also helps in documenting data requirements, identifying relationships between different entities, and detecting errors in development plans before any code is written.

Here are some key considerations when approaching data modeling:

1. **Application Functionality:** Understand what your application does and how it interacts with data. This includes identifying the core tasks it performs and the data it needs to perform those tasks.

2. **Data Storage:** Determine what data you need to store. This includes defining the types of information, such as user profiles, product details, or transaction records, that your application will manage.

3. **Data Access Patterns:** Consider how users will access this data. Understand the types of queries or operations that will be performed on the data, as this will influence the way you structure and index your data.

4. **Data Value:** Identify which data elements are most valuable to your application. Prioritize the data that is critical for your application's core functionality and user experience.

5. **Tasks and Users:** Think about the tasks your application needs to perform and how they relate to the data. Consider the roles and responsibilities of different users and how they interact with the data.

6. **Data Relationships:** Understand the relationships that exist among different entities in your data. Determine how various pieces of data are connected or related to each other.

7. **Tooling:** Consider the database management system and tools you plan to use. Different databases have various capabilities and constraints that can impact your data modeling decisions.

8. **Access Patterns:** Anticipate the access patterns that might emerge as your application evolves. Ensure that your data model can efficiently support these patterns.

A well-designed data model can offer several benefits, including:

- **Ease of Data Management:** It makes it easier to manage data, organize it logically, and maintain data integrity.

- **Efficient Queries:** Properly structured data models can significantly improve query performance, reducing the time it takes to retrieve information.

- **Optimized Resource Usage:** A good data model can use less memory and CPU resources, resulting in better overall system performance.

- **Cost Reduction:** By optimizing data storage and access, you can reduce infrastructure and operational costs.

In MongoDB, a fundamental principle is that data that is accessed together should be stored together. MongoDB's flexible document data model allows you to store data in rich, multi-dimensional documents that align with your application's natural structure. Each document in MongoDB can have a different structure, which is known as polymorphism.

## Types of Data Relationships

When modeling data, it's important to consider the relationships between different entities. MongoDB supports various types of data relationships:

1. **One-to-One Relationship:** In this relationship, a data entity in one set is connected to exactly one data entity in another set. For example, associating a user with their profile details.

2. **One-to-Many Relationship:** This relationship involves one data entity in one set being connected to any number of data entities in another set. For instance, a user can have multiple orders associated with them.

3. **Many-to-Many Relationship:** In a many-to-many relationship, any number of data entities in one set can be connected to any number of data entities in another set. For example, multiple users can belong to multiple groups.

The two primary ways of modeling data relationships in MongoDB are:

- **Embedding:** Storing related data within a single document. This approach simplifies queries, improves query performance, and is ideal for one-to-many and many-to-many relationships. However, it may lead to large or unbounded documents in some cases.

- **Referencing:** Storing references (typically document IDs) to related data in other collections. This approach helps avoid large documents but requires additional queries to retrieve related data.

Consider the use case and access patterns when choosing between these two approaches.

## Modeling Data Relationships

### Example: Redesigning the Accounts Collection

Let's consider a scenario where you need to redesign the accounts collection in a banking database to make the information clearer. The goal is to keep customer contact information and account details separate. Here's a sample document from the accounts collection:

```json
{
  "account_id": "MDB653115886",
  "account_holder": "Herminia Mckinney",
  "account_type": "savings",
  "balance": 6617.34,
  "street_num": 123,
  "street": "Main St",
  "city": "Tulsa",
  "state": "OK",
  "zip": 74008,
  "country": "USA",
  "home_phone": 1234567890,
  "cell_phone": 1111111111,
  "transfers": [
    ...
  ]    
}
```

You have two main options for redesigning this collection:

1. **Creating Two Collections:** One for accounts and one for customer_info. This aligns with the customer's requirements and ensures that data accessed together is stored together.

2. **Embedding Phone Numbers:** Store the phone numbers as a subdocument within the accounts document. This can improve the schema design and maintain data access patterns.

# Embedding Data in Documents

Embedding data in documents involves storing related data within the same document. This approach simplifies queries and can improve overall query performance. It is particularly suitable for one-to-many and many-to-many relationships among data. However, it has pitfalls, such as potentially leading to large or unbounded documents.

# Referencing Data in Documents

Referencing data in documents involves storing references, usually document IDs, to related data in other collections. This approach helps avoid issues with large documents but requires additional queries to retrieve related data when needed. It is useful for modeling complex relationships and scenarios where data needs to be accessed independently.

![Embed vs. Reference](https://d36ai2hkxl16us.cloudfront.net/course-uploads/ae62dcd7-abdc-4e90-a570-83eccba49043/7ev1uxwmqacn-embeddingreferencing.png)

Consider a scenario where you have a users collection and a posts collection. Each post contains comments, and you reference the user who made each comment using their user ID.

```json
{
    "author": "Aileen Long",
    "title": "Learn MongoDB in 30 Mins",
    "published_date": ISODate("2020-05-18T14:10:30Z"),
    "tags": ["mongodb", "introductory", "database", "nosql"],
    "comments": [
        {
            "comment_id": "LM001",
            "user_id": "AL001",
            "comment_date": ISODate("2020-05-19T14:22:00Z"),
            "comment": "Great read!"
        },
        {
            "comment_id": "LM002",
            "user_id": "AL002",
            "comment_date": ISODate("2020-06-01T08:00:00Z"),
            "comment": "So easy to understand - thanks!"
        }
    ]
}
```

However, as the comments array grows, it can lead to problems such as increased memory usage, write performance issues, difficulties in implementing pagination for comments, and hitting the maximum document size limit of

 16MB.

To avoid these issues, you can break the comments into a separate collection and reference the blog id in each comments document. like so:

### Blog Post Document

```json
{
  "_id": ObjectId("post001"),
  "title": "MongoDB in Practice",
  "content": "MongoDB is a NoSQL database...",
}
```

### Comment Document (Separate Collection)

```json
{
  "_id": ObjectId("comment001"),
  "blog_post_id": ObjectId("post001"),
  "user_id": ObjectId("user001"),
  "text": "Great article!"
}
```

In this revised structure:

- Each blog post is stored in its own collection without the comments.
- Comments are stored in a separate collection where each comment document references the ID of the associated blog post using `blog_post_id`.
- The `blog_post_id` field establishes the relationship between comments and the specific blog post they belong to.

This approach helps in avoiding the issues of unbounded documents and allows for more efficient querying and management of comments, especially when dealing with a large number of comments for multiple blog posts.

# Scaling a Data Model

When scaling a data model, you aim to achieve optimal efficiency in terms of query response times, memory usage, CPU utilization, and storage space. It's essential to monitor and fine-tune your data model as your application grows to maintain its performance and responsiveness.

One critical consideration is avoiding unbounded documents. Unbounded documents are documents that can grow infinitely, causing performance issues. For instance, using embedding for a blog post and its comments can lead to unbounded documents.

Problems associated with unbounded documents include:

- Exceeding the document size limit of 16MB.
- Degraded query performance.
- Reduced write performance.
- Increased memory consumption.

To address these issues, consider strategies such as breaking out related data into separate collections, referencing data, and implementing pagination for large datasets.

# Using Atlas Tools for Schema Help

MongoDB Atlas provides tools to help you optimize your data schema and identify potential issues:

- **Schema Anti-Patterns Tab:** This tool highlights any schema anti-patterns in your collection and provides guidance on how to resolve them. It helps you improve your schema design by addressing issues proactively.

- **Performance Advisor:** Available in M10+ cluster tiers, the Performance Advisor tool helps you monitor the performance of your queries and provides recommendations to enhance query performance. It offers insights into query result times, memory usage, CPU usage, and storage space utilization.

By leveraging these tools, you can ensure that your MongoDB schema is well-optimized and can handle the demands of your application efficiently.