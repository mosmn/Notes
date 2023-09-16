# INSERTING DOCUMENTS IN A MONGODB COLLECTION

In MongoDB, you can insert documents into a collection using various methods. Below is an explanation of how to insert documents, either singly or in multiples.

## Insert a Single Document

To insert a single document into a MongoDB collection, you can use the `insertOne()` method. This method takes an object containing the document data as its argument. Here's an example:

```javascript
db.grades.insertOne({
  student_id: 654321,
  products: [
    {
      type: "exam",
      score: 90,
    },
    {
      type: "homework",
      score: 59,
    },
    {
      type: "quiz",
      score: 75,
    },
    {
      type: "homework",
      score: 88,
    },
  ],
  class_id: 550,
})
```

**Explanation**: The `insertOne()` method allows you to insert a single document with a specified structure into the collection. In this example, a student's grades and class ID are being inserted into the "grades" collection.

## Insert Multiple Documents

To insert multiple documents at once, you can use the `insertMany()` method. This method takes an array of documents, and each document should be separated by a comma. Here's an example:

```javascript
db.grades.insertMany([
  {
    student_id: 546789,
    products: [
      {
        type: "quiz",
        score: 50,
      },
      {
        type: "homework",
        score: 70,
      },
      // ... (other documents)
    ],
    class_id: 551,
  },
  // ... (other documents)
])
```

**Explanation**: The `insertMany()` method is useful when you want to insert multiple documents into the collection in a single operation. Each document within the array represents a separate record in the "grades" collection.

# FINDING DOCUMENTS IN A MONGODB COLLECTION

MongoDB provides robust querying capabilities for finding documents in a collection. Here's how you can perform queries:

## Find a Document with Equality

You can use the `find()` method to query for a document that matches a specific field, such as `_id`. For instance:

```javascript
db.zips.find({ _id: ObjectId("5c8eccc1caa187d17ca6ed16") })
```

**Explanation**: This query fetches a document from the "zips" collection where the `_id` field matches the provided ObjectId. MongoDB will return the specified document.

## Find a Document by Using the $in Operator

The `$in` operator allows you to select documents where a field's value equals any value in a specified array. For example:

```javascript
db.zips.find({ city: { $in: ["PHOENIX", "CHICAGO"] } })
```

**Explanation**: This query retrieves documents from the "zips" collection where the "city" field matches either "PHOENIX" or "CHICAGO." The `$in` operator is particularly useful for filtering documents based on multiple possible values.

# FINDING DOCUMENTS BY USING COMPARISON OPERATORS

MongoDB offers various comparison operators for more advanced querying. Here are some commonly used ones:

## $gt (Greater Than)

Use the `$gt` operator to match documents where a field is greater than a given value. For instance:

```javascript
db.sales.find({ "items.price": { $gt: 50 }})
```

**Explanation**: This query retrieves documents from the "sales" collection where the price of items is greater than 50.

## $lt (Less Than)

The `$lt` operator is used to match documents where a field is less than a given value. Example:

```javascript
db.sales.find({ "items.price": { $lt: 50 }})
```

**Explanation**: This query retrieves documents from the "sales" collection where the price of items is less than 50.

## $lte (Less Than or Equal To)

The `$lte` operator matches documents where a field is less than or equal to a given value. For example:

```javascript
db.sales.find({ "customer.age": { $lte: 65 }})
```

**Explanation**: This query retrieves documents from the "sales" collection where the age of the customer is 65 or less.

## $gte (Greater Than or Equal To)

The `$gte` operator matches documents where a field is greater than or equal to a given value. For instance:

```javascript
db.sales.find({ "customer.age": { $gte: 65 }})
```

**Explanation**: This query retrieves documents from the "sales" collection where the age of the customer is 65 or greater.

# QUERYING ON ARRAY ELEMENTS IN MONGODB

MongoDB allows you to query documents based on elements within arrays. Here are some examples:

## Find Documents with an Array That Contains a Specified Value

In the following query, "InvestmentFund" is not enclosed in square brackets, so MongoDB returns all documents within the "accounts" collection where the "products" array contains the specified value:

```javascript
db.accounts.find({ products: "InvestmentFund" })
```

**Explanation**: This query searches for documents in the "accounts" collection where the "products" array includes the string "InvestmentFund."

## Find a Document by Using the $elemMatch Operator

The `$elemMatch` operator is used to find documents containing a specified subdocument. For example:

```javascript
db.sales.find({
  items: {
    $elemMatch: { name: "laptop", price: { $gt: 800 }, quantity: { $gte: 1 } },
  },
})
```

**Explanation**: This query retrieves documents from the "sales" collection where there is at least one item in the "items" array that matches the specified conditions using `$elemMatch`. This is useful for complex queries involving arrays.

# FINDING DOCUMENTS BY USING LOGICAL OPERATORS

MongoDB allows you to perform complex queries using logical operators. Here are some examples:

## Find a Document by Using Implicit $and

Implicit `$and` allows you to select documents that match multiple expressions. For instance:

```javascript
db.routes.find({ "airline.name": "Southwest Airlines", stops: { $gte: 1 } })
```

**Explanation**: This query retrieves documents from the "routes" collection where both conditions are met: the airline's name is "Southwest Airlines," and there are at least one or more stops in the route.

## Find a Document by Using the $or Operator

The `$or` operator lets you select documents that match at least one of the included expressions. For example:

```javascript
db.routes.find({
  $or: [{ dst_airport: "SEA" }, { src_airport: "SEA" }],
})
```

**Explanation**: This query retrieves documents from the "routes" collection where either the destination airport is "SEA" or the source airport is "SEA." At least one condition must be satisfied.

## Find a Document by Using the $and Operator

The `$and` operator is used to combine multiple `$or` expressions in your query. For example:

```javascript
db.routes.find({
  $and: [
    { $or: [{ dst_airport: "SEA" }, { src_airport: "SEA" }] },
    { $

or: [{ "airline.name": "American Airlines" }, { airplane: 320 }] },
  ],
})
```

**Explanation**: This query retrieves documents from the "routes" collection where both sets of conditions are met: either the destination or source airport is "SEA," and the airline's name is "American Airlines" or the airplane type is 320. This demonstrates the use of `$and` to combine multiple `$or` expressions for more complex queries.