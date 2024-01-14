# Using MongoDB Indexes in Collections

**Indexes:**
Indexes are data structures that significantly improve the performance of database queries by allowing for fast data retrieval. They support efficient equality matches and range-based query operations and can return sorted results. However, it's essential to keep in mind that indexes come with a trade-off; they enhance read/query performance at the cost of reduced write performance.

**Common Types of Indexes:**
1. **Single Field Index:** A single field index is created on a single field of a document. MongoDB automatically creates a single field index on the `_id` field, but additional indexes may be required for other fields. A single field index can also be a multikey index if it operates on an array field.

2. **Compound Index:** A compound index holds references to multiple fields within a collection's documents. It is created by specifying the fields that the index should reference and their sort order. The order of the fields in the compound index is crucial, as it determines the order in which documents are returned when querying the collection. A compound index can also be a multikey index if one of the fields is an array.

3. **Multikey Index:** A multikey index is created on an array field. Each element in the array gets an index key, which supports efficient querying against array fields. Both single field and compound indexes can have an array field, resulting in both multikey single field indexes and multikey compound indexes.

## Creating a Single Field Index in MongoDB

To create a single field index in MongoDB, you can use the `createIndex()` method. Here's how to do it:

**Create a Single Field Index:**
```javascript
db.collection.createIndex({
  field_name: 1
})
```

**Create a Unique Single Field Index:**
You can add `{ unique: true }` as an optional second parameter in `createIndex()` to enforce uniqueness in the indexed field values. This prevents duplicates.

```javascript
db.collection.createIndex({
  email: 1
}, {
  unique: true
})
```

**View the Indexes Used in a Collection:**
You can use `getIndexes()` to see all the indexes created in a collection.

```javascript
db.collection.getIndexes()
```

**Check if an Index Is Being Used in a Query:**
Use `explain()` when running a query to see the execution plan. It provides details of the execution stages, including whether an index is being used.

```javascript
db.collection.explain().find({
  field_name: "value"
})
```

## Creating a Multikey Index in MongoDB

To create a multikey index in MongoDB, you can use the `createIndex()` method as well. Here's how to do it:

**Create a Single Field Multikey Index:**
```javascript
db.collection.createIndex({
  array_field: 1
})
```

**View the Indexes Used in a Collection:**
You can still use `getIndexes()` to see all the indexes created in a collection.

```javascript
db.collection.getIndexes()
```

**Check if an Index Is Being Used in a Query:**
Again, you can use `explain()` when running a query to check whether an index is being used.

```javascript
db.collection.explain().find({
  array_field: "value"
})
```

## Working with Compound Indexes in MongoDB

To create a compound index in MongoDB, use the `createIndex()` method with an object that contains two or more fields and their sort order:

**Create a Compound Index:**
```javascript
db.collection.createIndex({
  field1: 1,
  field2: -1
})
```

**Order of Fields in a Compound Index:**
The order of fields in a compound index matters. It's recommended to list the fields in the following order: Equality, Sort, and Range.

- **Equality:** Fields that are used for equality matches in queries.
- **Sort:** Fields that specify the sorting order of the results.
- **Range:** Fields used for range-based queries.

When querying, MongoDB optimizes queries by using the first field in the compound index for equality matches. The second field determines the sorting order, and the third field handles range queries.

**Cover a Query by the Index:**
An index is considered to cover a query when MongoDB doesn't need to fetch data from memory because all required data is returned by the index. Use projections to limit the returned fields to only those in the index.

```javascript
db.collection.explain().find(
  {
    query_conditions
  },
  {
    projected_fields
  }
)
```

**Deleting an Index:**

**View the Indexes Used in a Collection:**
Use `getIndexes()` to see all the indexes created in a collection.

```javascript
db.collection.getIndexes()
```

**Delete an Index by Name:**
You can delete an index by specifying its name.

```javascript
db.collection.dropIndex("index_name")
```

**Delete an Index by Key:**
You can delete an index by specifying the same fields used when creating it.

```javascript
db.collection.dropIndex({
  field1: 1,
  field2: -1
})
```

**Delete All Indexes:**
To delete all indexes (except the default `_id` index) from a collection, use `dropIndexes()`.

```javascript
db.collection.dropIndexes()
```

You can also pass an array of index names to `dropIndexes()` to delete specific indexes.