# Sorting and Limiting Query Results in MongoDB

In MongoDB, you can use the `sort()` and `limit()` methods to control the order and quantity of query results. Here's how to use these methods:

## Sorting Results

To sort query results, you can use the `sort()` method. The `sort()` method takes an object that specifies the field(s) to sort by and the order of the sort. Use `1` for ascending order and `-1` for descending order.

### Syntax:

```javascript
db.collection.find(<query>).sort(<sort>)
```

### Example:

```javascript
// Return data on all music companies, sorted alphabetically from A to Z.
db.companies.find({ category_code: "music" }).sort({ name: 1 });
```

**Explanation**: In this example, we are querying the "companies" collection to find all documents with the "category_code" field equal to "music." We then sort the results in ascending order based on the "name" field.

To ensure consistent sorting order, it's a good practice to include a field with unique values in the sort. You can use the `_id` field for this purpose:

### Example (with consistent sort order):

```javascript
// Return data on all music companies, sorted alphabetically from A to Z. Ensure consistent sort order
db.companies.find({ category_code: "music" }).sort({ name: 1, _id: 1 });
```

## Limiting Results

To limit the number of documents returned in a query, you can use the `limit()` method. The `limit()` method specifies the maximum number of documents to return.

### Syntax:

```javascript
db.collection.find(<query>).limit(<number>)
```

### Example:

```javascript
// Return the three music companies with the highest number of employees. Ensure consistent sort order.
db.companies
  .find({ category_code: "music" })
  .sort({ number_of_employees: -1, _id: 1 })
  .limit(3);
```

**Explanation**: In this example, we first sort the documents based on the "number_of_employees" field in descending order and then use `limit(3)` to retrieve only the top three results.

# Returning Specific Data from a Query in MongoDB

You can select specific fields to include or exclude in the result set by using a projection document as the second parameter in the `db.collection.find()` method. Here's how you can do it:

## Add a Projection Document

To specify which fields to include or exclude from the result set, add a projection document after the query in the `find()` method.

### Syntax:

```javascript
db.collection.find(<query>, <projection>)
```

## Include a Field

To include a specific field in the result, set its value to `1` in the projection document.

### Syntax:

```javascript
db.collection.find(<query>, { <field>: 1 })
```

### Example:

```javascript
// Return all restaurant inspections - business name, result, and _id fields only
db.inspections.find(
  { sector: "Restaurant - 818" },
  { business_name: 1, result: 1 }
)
```

## Exclude a Field

To exclude a specific field from the result, set its value to `0` in the projection document.

### Syntax:

```javascript
db.collection.find(query, { <field>: 0 })
```

### Example:

```javascript
// Return all inspections with a result of "Pass" or "Warning" - exclude date and zip code
db.inspections.find(
  { result: { $in: ["Pass", "Warning"] } },
  { date: 0, "address.zip": 0 }
)
```

While the `_id` field is included by default, you can suppress it by setting its value to `0` in the projection document.

### Example (excluding the `_id` field):

```javascript
// Return all restaurant inspections - business name and result fields only
db.inspections.find(
  { sector: "Restaurant - 818" },
  { business_name: 1, result: 1, _id: 0 }
)
```

# Counting Documents in a MongoDB Collection

To count the number of documents that match a query in MongoDB, you can use the `countDocuments()` method. This method takes two parameters: a query document and an options document.

## Syntax:

```javascript
db.collection.countDocuments(<query>, <options>)
```

## Examples:

### Count all documents in the "trip" collection:

```javascript
db.trips.countDocuments({})
```

### Count trips over 120 minutes by subscribers:

```javascript
db.trips.countDocuments({ tripduration: { $gt: 120 }, usertype: "Subscriber" })
```

**Explanation**: In this example, we count the documents in the "trips" collection based on two criteria: the "tripduration" field must be greater than 120 minutes, and the "usertype" field must be "Subscriber."