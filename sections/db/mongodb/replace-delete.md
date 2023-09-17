# REPLACING A DOCUMENT IN MONGODB

Replacing a document in MongoDB involves using the `replaceOne()` method. This method requires three parameters: `filter`, `replacement`, and `options`.

- `filter`: This is a query that identifies the document you want to replace.
- `replacement`: It's the new document that will replace the old one.
- `options`: An object where you can specify various options for the update operation.

In the example code below, we are using the `_id` field to filter the document. The `replacement` document contains the data that should be inserted in place of the old document:

```javascript
db.books.replaceOne(
  {
    _id: ObjectId("6282afeb441a74a98dbbec4e"),
  },
  {
    title: "Data Science Fundamentals for Python and MongoDB",
    isbn: "1484235967",
    publishedDate: new Date("2018-5-10"),
    thumbnailUrl:
      "https://m.media-amazon.com/images/I/71opmUBc2wL._AC_UY218_.jpg",
    authors: ["David Paper"],
    categories: ["Data Science"],
  }
)
```

**Explanation**: In this example, we are replacing a document in the "books" collection based on its `_id`. The new document provided in the `replacement` parameter will entirely replace the existing document.

# UPDATING MONGODB DOCUMENTS BY USING `updateOne()`

The `updateOne()` method allows you to update documents in MongoDB by providing a `filter` document, an `update` document, and an optional `options` object. MongoDB provides several update operators and options for more flexible updates. We will explore three of them: `$set`, `upsert`, and `$push`.

## `$set` Operator

The `$set` operator replaces the value of a field with the specified value. Here's an example:

```javascript
db.podcasts.updateOne(
  {
    _id: ObjectId("5e8f8f8f8f8f8f8f8f8f8f8"),
  },
  {
    $set: {
      subscribers: 98562,
    },
  }
)
```

**Explanation**: This query uses the `$set` operator to update the "subscribers" field in a document from the "podcasts" collection. The field's value will be replaced with 98562.

## `upsert` Option

The `upsert` option is used to create a new document if no documents match the specified criteria. Example:

```javascript
db.podcasts.updateOne(
  { title: "The Developer Hub" },
  { $set: { topics: ["databases", "MongoDB"] } },
  { upsert: true }
)
```

**Explanation**: If there is no document with the title "The Developer Hub," this operation will create a new document with the specified fields and values. The `upsert` option enables this behavior.

## `$push` Operator

The `$push` operator adds a new value to an array field. Example:

```javascript
db.podcasts.updateOne(
  { _id: ObjectId("5e8f8f8f8f8f8f8f8f8f8f8") },
  { $push: { hosts: "Nic Raboy" } }
)
```

**Explanation**: This query uses the `$push` operator to add a new value ("Nic Raboy") to the "hosts" array field in a document from the "podcasts" collection.

# UPDATING MONGODB DOCUMENTS BY USING `findAndModify()`

The `findAndModify()` method allows you to find and replace a single document in MongoDB. It accepts a `query` document, an `update` document, and an optional `options` object. By default, it returns the unmodified document before updating it. When using `upsert`, it can also insert a new document if no matches are found.

Here's an example:

```javascript
db.podcasts.findAndModify({
  query: { _id: ObjectId("6261a92dfee1ff300dc80bf1") },
  update: { $inc: { subscribers: 1 } },
  new: true,
  upsert: true,
})
```

**Explanation**: In this example, we use `findAndModify()` to increment the "subscribers" field of a document from the "podcasts" collection. If no document with the specified `_id` is found, it will insert a new one due to the `upsert: true` option.

# UPDATING MONGODB DOCUMENTS BY USING `updateMany()`

To update multiple documents, you can use the `updateMany()` method. This method accepts a `filter` document, an `update` document, and an optional `options` object.

Here's an example:

```javascript
db.books.updateMany(
  { publishedDate: { $lt: new Date("2019-01-01") } },
  { $set: { status: "LEGACY" } }
)
```

**Explanation**: In this example, we use `updateMany()` to set the "status" field to "LEGACY" for all documents in the "books" collection where the "publishedDate" is earlier than January 1, 2019.

# DELETING DOCUMENTS IN MONGODB

To delete documents in MongoDB, you can use either the `deleteOne()` or `deleteMany()` methods. Both methods require a `filter` document to specify which documents to delete.

## Delete One Document

Here's an example of using the `deleteOne()` method to delete a single document:

```javascript
db.podcasts.deleteOne({ _id: Objectid("6282c9862acb966e76bbf20a") })
```

**Explanation**: This operation deletes a single document from the "podcasts" collection based on its `_id`.

## Delete Many Documents

The `deleteMany()` method is used to delete multiple documents that match the specified filter:

```javascript
db.podcasts.deleteMany({ category: "crime" })
```

**Explanation**: This operation deletes all documents from the "podcasts" collection where the "category" field is equal to "crime".