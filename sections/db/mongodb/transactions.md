# INTRODUCTION TO ACID TRANSACTIONS

An ACID (Atomicity, Consistency, Isolation, Durability) transaction is a fundamental concept in database management, ensuring data integrity and reliability. Let's delve into the core principles of ACID transactions to understand their importance:

## Atomicity

Atomicity guarantees that a transaction is treated as a single, indivisible unit of work. It ensures that all the database operations within a transaction are either completed successfully or leave the database unchanged if any part of the transaction fails. In simple terms, it's an "all or nothing" principle.

For instance, consider a scenario where you transfer money from one bank account to another. Atomicity ensures that the money is deducted from one account and added to the other, or none of these actions occurs.

## Consistency

Consistency ensures that a transaction brings the database from one valid state to another. It checks that all database operations comply with defined constraints and rules. If any operation violates these constraints, the entire transaction is rolled back, and the database remains unchanged.

For example, if an account balance cannot be negative, a transaction attempting to make such a balance negative would be rejected.

## Isolation

Isolation guarantees that concurrent transactions do not interfere with each other. Even when multiple transactions are executed simultaneously, the final state of the database should be as if these transactions had been executed sequentially. This prevents scenarios where one transaction reads intermediate, incomplete data from another transaction.

## Durability

Durability guarantees that once a transaction is successfully committed, its changes are permanent and survive even in the face of system failures (e.g., power outage or hardware issues). The changes made by committed transactions are stored in non-volatile memory, ensuring data persistence.

In summary, ACID transactions are crucial in scenarios where data integrity, reliability, and consistency are paramount, such as financial systems, inventory management, or any situation where data accuracy is critical.

# ACID TRANSACTIONS IN MONGODB

MongoDB, a popular NoSQL database, provides support for ACID transactions, but it's important to note that not all operations are inherently atomic. While single-document operations in MongoDB are atomic, multi-document operations require extra steps to ensure atomicity.

To make multi-document operations in MongoDB ACID-compliant, you need to wrap them within a multi-document transaction. Multi-document transactions are precise tools designed for specific use cases, especially in scenarios involving the exchange of value between different parties, such as banking or business applications.

It's crucial to be aware that multi-document transactions may incur a performance cost, so they should only be used when ACID properties are essential for maintaining data consistency and integrity.

By employing multi-document transactions, MongoDB ensures that a series of operations affecting more than one document within a database adhere to the ACID principles, ultimately guaranteeing that the database remains in a consistent state once the transaction is either successfully committed or rolled back.

# USING TRANSACTIONS IN MONGODB

## Multi-Document Transactions

ACID transactions in MongoDB are typically employed by applications where data exchanges between different parties demand strong data integrity, such as financial or business applications. When you find yourself in a scenario requiring a multi-document transaction, you'll likely complete it using one of MongoDB's drivers. For now, let's explore how to execute and cancel multi-document transactions in the MongoDB shell to gain familiarity with the process.

### Using a Transaction: Code Example

Here's a summary of the code used to complete a multi-document transaction in MongoDB:

```javascript
const session = db.getMongo().startSession();

session.startTransaction();

const collection = session.getDatabase('<add database name>').getCollection('<add collection name>');

// Add your database operations like .updateOne() here

session.commitTransaction();
```
If it's successful, .commitTransaction() will output a message to the shell that resembles the following:
```javascript
{
  ok: 1,
  '$clusterTime': {
    clusterTime: Timestamp({ t: 1647437775, i: 5 }),
    signature: {
      hash: Binary(Buffer.from("b0d88d5a96372efb9af22021cdd59021741ddb5c", "hex"), 0),
      keyId: Long("7019511514256113665")
    }
  },
  operationTime: Timestamp({ t: 1647437775, i: 5 })
}
```

This code demonstrates the essential steps to initiate and execute a multi-document transaction using a MongoDB session. Remember to replace `<add database name>` and `<add collection name>` with your specific database and collection names.

### Aborting a Transaction: Code Example

In situations requiring the rollback of database operations before a transaction's completion, you can abort the transaction. Doing so will restore the database to its original state before the transaction was initiated.

Here's a summary of the code used to cancel a transaction before its completion:

```javascript
const session = db.getMongo().startSession();

session.startTransaction();

const collection = session.getDatabase('<add database name>').getCollection('<add collection name>');

// Add your database operations like .updateOne() here

session.abortTransaction();
```

This code snippet outlines the steps to cancel a transaction, ensuring that any changes made during the transaction are rolled back, leaving the database unaffected. Again, replace `<add database name>` and `<add collection name>` with your specific database and collection names.

ACID transactions in MongoDB offer a robust mechanism for maintaining data consistency and reliability in scenarios where precision and integrity are paramount.