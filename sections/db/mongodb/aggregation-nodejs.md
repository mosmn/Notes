# MongoDB Aggregation Operations

## Introduction

Aggregation operations process data records and return computed results. In MongoDB, you can quickly run complex operations involving multiple stages to gather metrics for your project. Aggregation operations are incredibly useful, powerful, and flexible for generating reports and displaying useful metadata.

## Aggregation Pipeline

An aggregation pipeline consists of one or more stages that process documents. Each stage performs an operation on the input documents. Some common stages include filtering, grouping, and calculating values.

### Using $match

The `$match` stage filters documents based on criteria. You can use simple equality matches like `$match: { author: "Dave" }` or aggregation expressions with comparison operators like `$match: { likes: { $gt: 100 } }`. Place `$match` early in the pipeline to reduce the number of documents processed.

### Using $group

The `$group` stage separates documents based on a group key and returns one document for every unique group key. You can use aggregation expressions within `$group` to perform calculations on grouped documents. For example:

```javascript
$group: { _id: "$movie", totalTickets: { $sum: "$tickets" } }
```

Here, "$movie" is the group key, and `totalTickets` is the result of the `$sum` operator.

## Working with Node.js

When working with MongoDB aggregation stages in Node.js, you can build an aggregation pipeline and use the `aggregate` method to run it. Here's an example:

```javascript
const pipeline = [
  // Stage 1: match the accounts with a balance greater than $1,000
  { $match: { balance: { $lt: 1000 } } },
  // Stage 2: Calculate average balance and total balance
  {
    $group: {
      _id: "$account_type",
      total_balance: { $sum: "$balance" },
      avg_balance: { $avg: "$balance" },
    },
  },
];

const main = async () => {
  try {
    await client.connect();
    console.log(`Connected to the database 🌍.`);
    let result = await accountsCollection.aggregate(pipeline);
    for await (const doc of result) {
      console.log(doc);
    }
  } catch (err) {
    console.error(`Error connecting to the database: ${err}`);
  } finally {
    await client.close();
  }
};

main();
```

# Additional Aggregation Stages: $sort and $project

## Using $sort

The `$sort` stage allows you to sort input documents in a specific order. You can sort documents in ascending or descending order based on a specified field. For example:

- `{ $sort: { balance: 1 } }` sorts documents in ascending order by the `balance` field.
- `{ $sort: { balance: -1 } }` sorts documents in descending order by the `balance` field.

## Using $project

The `$project` stage lets you pass along only a subset of fields from input documents. You can specify fields to include or exclude. Additionally, you can create computed fields based on data from the original documents. For example:

```javascript
{
  $project: {
    _id: 0,
    account_id: 1,
    account_type: 1,
    balance: 1,
    gbp_balance: { $divide: ["$balance", 1.3] }, // Example of a computed field
  },
}
```

In this example, the `$project` stage includes the `account_id`, `account_type`, `balance` fields, and a computed field `gbp_balance`.

## Running the Pipeline

To run an aggregation pipeline, append the `aggregate` method to the collection. Here's an example:

```javascript
const result = await accountsCollection.aggregate(pipeline);
for await (const doc of result) {
  console.log(doc);
}
```

This code defines a pipeline and iterates over the results obtained using the `aggregate` method.