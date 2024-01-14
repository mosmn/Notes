# Node.js and BSON

Node.js driver converts BSON to JSON automatically. This enables you to access the data immediately within your application. In addition, you've identified that BSON documents are binary encoded and allow for more data types than JSON.

## Insert

### Insert a Document

You can insert a document into a collection using the `collection.insertOne()` method. To insert a document, define an object that contains the fields and values that you want to store. If the specified collection does not exist, the `insertOne()` method creates the collection.

You can specify additional query options using the options parameter. For more information on the method parameters, see the [insertOne() API documentation](link). For more information on this method, see the [insertOne() API documentation](link).

If the operation successfully inserts a document, it appends an insertedId field to the object passed in the method call, and sets the value of the field to the _id of the inserted document.

#### Example

```javascript
// Replace the uri string with your MongoDB deployment's connection string.
const uri = "<connection string uri>";
const client = new MongoClient(uri);

async function run() {
  try {
    // Connect to the "insertDB" database and access its "haiku" collection
    const database = client.db("insertDB");
    const haiku = database.collection("haiku");
    
    // Create a document to insert
    const doc = {
      title: "Record of a Shriveled Datum",
      content: "No bytes, no problem. Just insert a document, in MongoDB",
    }

    // Insert the defined document into the "haiku" collection
    const result = await haiku.insertOne(doc);

    // Print the ID of the inserted document
    console.log(`A document was inserted with the _id: ${result.insertedId}`);
  } finally {
    // Close the MongoDB client connection
    await client.close();
  }
}

// Run the function and handle any errors
run().catch(console.dir);
```

If you run the preceding example, you should see the following output:

```
A document was inserted with the _id: <your _id value>
```

### Insert Multiple Documents

You can insert multiple documents using the `collection.insertMany()` method. The `insertMany()` takes an array of documents to insert into the specified collection.

You can specify additional options in the options object passed as the second parameter of the `insertMany()` method. Specify `ordered:true` to prevent inserting the remaining documents if the insertion failed for a previous document in the array.

Specifying incorrect parameters for your `insertMany()` operation can cause problems. Attempting to insert a field to a value that would violate unique index rules will throw a duplicate key error.

#### Example

```javascript
// Replace the uri string with your MongoDB deployment's connection string.
const uri = "<connection string uri>";
const client = new MongoClient(uri);

async function run() {
  try {
    // Get the database and collection on which to run the operation
    const database = client.db("insertDB");
    const foods = database.collection("foods");

    // Create an array of documents to insert
    const docs = [
      { name: "cake", healthy: false },
      { name: "lettuce", healthy: true },
      { name: "donut", healthy: false }
    ];

    // Prevent additional documents from being inserted if one fails
    const options = { ordered: true };

    // Execute insert operation
    const result = await foods.insertMany(docs, options);
   
    // Print result
    console.log(`${result.insertedCount} documents were inserted`);
  } finally {
    await client.close();
  }
}

run().catch(console.dir);
```

If you run the preceding example, you should see the following output:

```
3 documents were inserted
```

## Find

### Find a Document

You can query for a single document in a collection with the `collection.findOne()` method. The `findOne()` method uses a query document that you provide to match only the subset of the documents in the collection that match the query. If you don't provide a query document or if you provide an empty document, MongoDB matches all documents in the collection. The `findOne()` operation only returns the first matched document.

You can also define additional query options such as sort and projection to configure the returned document. You can specify the additional options in the options object passed as the second parameter of the `findOne` method. For detailed reference documentation, see [collection.findOne()](link).

#### Example

The following snippet finds a single document from the movies collection. It uses the following parameters:

- A query document that configures the query to return only movies with the title of exactly the text 'The Room'.
- A sort that organizes matched documents in descending order by rating, so if our query matches multiple documents the returned document will be the document with the highest rating.
- A projection that explicitly excludes the _id field from returned documents and explicitly includes only the title and imdb object (and its embedded fields).

```javascript
// Replace the uri string with your MongoDB deployment's connection string.
const uri = "<connection string uri>";
const client = new MongoClient(uri);

async function run() {
  try {
    // Get the database and collection on which to run the operation
    const database = client.db("sample_mflix");
    const movies = database.collection("movies");
    
    // Query for a movie that has the title 'The Room'
    const query = { title: "The Room" };
    const options = {
      // Sort matched documents in descending order by rating
      sort: { "imdb.rating": -1 },
      // Include only the `title` and `imdb` fields in the returned document
      projection: { _id: 0, title: 1, imdb: 1 },
    };

    // Execute query
    const movie = await movies.findOne(query, options);

    // Print the document returned by findOne()
    console.log(movie);
  } finally {
    await client.close();
  }
}

run().catch(console.dir);
```

If you run the preceding example, you should see the following output:

```
{ title: 'The Room', imdb: { rating: 3.5, votes: 25673, id: 368226 } }
```

### Find Multiple Documents

You can query for multiple documents in a collection with `collection.find()`. The `find()` method uses a query document that you provide to match the subset of the documents in the collection that match the query. If you don't provide a query document (or if you provide an empty document), MongoDB returns all documents in the collection.

You can also define additional query options such as sort and projection to configure the result set. You can specify these in the options parameter in your `find()` method call in sort and projection objects. See [collection.find()](link) for more information on the parameters you can pass to the method.

The `find()` method returns a `FindCursor` that manages the results of your query. You can iterate through the matching documents using the `for await...of` syntax, or one of the following cursor methods:

- next()
- toArray()

If no documents match the query, `find()` returns an empty cursor.

#### Example

The following snippet finds documents from the movies collection. It uses the following parameters

:

- A query document that configures the query to return only movies with a runtime of less than 15 minutes.
- A sort that organizes returned documents in ascending order by title (alphabetical order in which "A" comes before "Z" and "1" before "9").
- A projection that explicitly excludes the _id field from returned documents and explicitly includes only the title and imdb object (and its embedded fields).

```javascript
// Replace the uri string with your MongoDB deployment's connection string.
const uri = "<connection string uri>";
const client = new MongoClient(uri);

async function run() {
  try {
    // Get the database and collection on which to run the operation
    const database = client.db("sample_mflix");
    const movies = database.collection("movies");

    // Query for movies that have a runtime less than 15 minutes
    const query = { runtime: { $lt: 15 } };
    const options = {
      // Sort returned documents in ascending order by title (A->Z)
      sort: { title: 1 },
      // Include only the `title` and `imdb` fields in each returned document
      projection: { _id: 0, title: 1, imdb: 1 },
    };

    // Execute query 
    const cursor = movies.find(query, options);

    // Print a message if no documents were found
    if ((await movies.countDocuments(query)) === 0) {
      console.log("No documents found!");
    }

    // Print returned documents
    for await (const doc of cursor) {
      console.dir(doc);
    }
  } finally {
    await client.close();
  }
}

run().catch(console.dir);
```

If you run the preceding example, you should see the following output:

```
{ title: '10 Minutes', imdb: { rating: 7.9, votes: 743, id: 339976 } }
{ title: '3x3', imdb: { rating: 6.9, votes: 206, id: 1654725 } }
{ title: '7:35 in the Morning', imdb: { rating: 7.3, votes: 1555, id: 406501 } }
{ title: '8', imdb: { rating: 7.8, votes: 883, id: 1592502 } }
...
```

The sort and projection options can also be specified as methods (sort() and project(), respectively) chained to the `find()` method. The following two commands are equivalent:

```javascript
movies.find({ runtime: { $lt: 15 } }, { sort: { title: 1 }, projection: { _id: 0, title: 1, imdb: 1 }});
movies.find({ runtime: { $lt: 15 } }).sort({ title: 1}).project({ _id: 0, title: 1, imdb: 1 });
```

### Using `find()`

The `find()` method is a read operation that returns a cursor to the documents that match the query. The `find()` method takes a query or filter document as an argument. If you do not specify a query document, the `find()` method returns all documents in the collection.

In this example, we find all accounts that have a balance greater than or equal to 4700. The `find()` method accepts a query filter, which we assign to a variable called `documentsToFind`. We process each document that’s returned from the `find()` method by iterating the cursor, which is assigned to the variable `result`.

```javascript
// Document used as a filter for the find() method
const documentsToFind = { balance: { $gt: 4700 } }
 
const main = async () => {
 try {
   await connectToDatabase()
   // find() method is used here to find documents that match the filter
   let result = accountsCollection.find(documentsToFind)
   let docCount = accountsCollection.countDocuments(documentsToFind)
   await result.forEach((doc) => console.log(doc))
   console.log(`Found ${await docCount} documents`)
 } catch (err) {
   console.error(`Error finding documents: ${err}`)
 } finally {
   await client.close()
 }
}

main()
```

### Using `findOne()`

In this example, we return a single document from a query, which is assigned to a variable called `documentToFind`. We use the `findOne()` method on the collection object to return the first document that matches the filter criteria, which are defined in the `documentToFind` variable.

```javascript
// Document used as a filter for the findOne() method
const documentToFind = { _id: ObjectId("62a3638521a9ad028fdf77a3") }

const main = async () => {
 try {
   await connectToDatabase()
   // findOne() method is used here to find a the first document that matches the filter
   let result = await accountsCollection.findOne(documentToFind)
   console.log(`Found one document`)
   console.log(result)
 } catch (err) {
   console.error(`Error finding document: ${err}`)
 } finally {
   await client.close()
 }
}

main()
```

## Update

### Using `updateOne()`

In this example, we use the `updateOne()` to update the value of an existing field in a document. Append the `updateOne()` method to the collection object to update a single document that matches the filter criteria, which are stored in the `documentToUpdate` variable. The update document contains the changes to be made and is stored in the `update` variable.

```javascript
const documentToUpdate = { _id: ObjectId("62d6e04ecab6d8e130497482") }

const update = { $inc: { balance: 100 } }

const main = async () => {
  try {
    await connectToDatabase()
    let result = await accountsCollection.updateOne(documentToUpdate, update)
    result.modifiedCount === 1
      ? console.log("Updated one document")
      : console.log("No documents updated")
  } catch (err) {
    console.error(`Error updating document: ${err}`)
  } finally {
    await client.close()
  }
}

main()
```

### Using `updateMany()`

In this example, we update many documents by adding a value to the transfers_complete array of all checking account documents. The `updateMany()` method is appended to the collection object. The method accepts a filter that matches the document(s) that we want to update and an update statement that instructs the driver how to change the matching document. Both the filter and the update documents are stored in variables. The `updateMany()` method updates all the documents in the collection that match the filter.

```javascript
const documentsToUpdate = { account_type: "checking" }

const update = { $push: { transfers_complete: "TR413308000" } }

const main = async () => {
  try {
    await connectToDatabase()
    let result = await accountsCollection.updateMany(documentsToUpdate, update)
    result.modifiedCount > 0
      ? console.log(`Updated ${result.modifiedCount} documents`)
      : console.log("No documents updated")
  } catch (err) {
    console.error(`Error updating documents: ${err}`)
  } finally {
    await client.close()
  }
}



main()
```

## Delete

### Using `deleteOne()`

To delete a single document from a collection, use the `deleteOne()` method on a collection object. This method accepts a query filter that matches the document that you want to delete. If you do not specify a filter, MongoDB matches and deletes the first document in the collection. Here's an example:

```javascript
const documentToDelete = { _id: ObjectId("62d6e04ecab6d8e13049749c") }

const main = async () => {
  try {
    await connectToDatabase()
    let result = await accountsCollection.deleteOne(documentToDelete)
    result.deletedCount === 1
      ? console.log("Deleted one document")
      : console.log("No documents deleted")
  } catch (err) {
    console.error(`Error deleting documents: ${err}`)
  } finally {
    await client.close()
  }
}

main()
```

### Using `deleteMany()`

You can delete multiple documents from a collection in a single operation by calling the `deleteMany()` method on a collection object. To specify which documents to delete, pass a query filter that matches the documents that you want to delete. If you provide an empty document, MongoDB matches all documents in the collection and deletes them. In the following example, we delete all accounts with a balance of less than 500 by using a query filter. Then, we print the total number of deleted documents:

```javascript
const documentsToDelete = { balance: { $lt: 500 } }

const main = async () => {
 try {
   await connectToDatabase()
   let result = await accountsCollection.deleteMany(documentsToDelete)
   result.deletedCount > 0
     ? console.log(`Deleted ${result.deletedCount} documents`)
     : console.log("No documents deleted")
 } catch (err) {
   console.error(`Error deleting documents: ${err}`)
 } finally {
   await client.close()
 }
}

main()
```

## Transaction

### Creating a Transaction

In this section, we'll go through the code to create a transaction step by step. We start the transaction by using the session’s `withTransaction()` method. We then define the sequence of operations to perform inside the transactions, passing the session object to each operation in the transactions.

```javascript
// Collections
const accounts = client.db("bank").collection("accounts")
const transfers = client.db("bank").collection("transfers")

// Account information
let account_id_sender = "MDB574189300"
let account_id_receiver = "MDB343652528"
let transaction_amount = 100

// Start a new session
const session = client.startSession()

// Begin a transaction with the WithTransaction() method on the session
const transactionResults = await session.withTransaction(async () => {
  // Operations will go here
})
```

- Update the balance field of the sender’s account by decrementing the `transaction_amount` from the balance field.

```javascript
const senderUpdate = await accounts.updateOne(
  { account_id: account_id_sender },
  { $inc: { balance: -transaction_amount } },
  { session }
)
```

- Update the balance field of the receiver’s account by incrementing the `transaction_amount` to the balance field.

```javascript
const receiverUpdate = await accounts.updateOne(
  { account_id: account_id_receiver },
  { $inc: { balance: transaction_amount } },
  { session }
)
```

- Create a transfer document and insert it into the transfers collection.

```javascript
const transfer = {
  transfer_id: "TR21872187",
  amount: 100,
  from_account: account_id_sender,
  to_account: account_id_receiver,
}

const insertTransferResults = await transfers.insertOne(transfer, { session })
```

- Update the transfers_complete array of the sender’s account by adding the transfer_id to the array.

```javascript
const updateSenderTransferResults = await accounts.updateOne(
  { account_id: account_id_sender },
  { $push: { transfers_complete: transfer.transfer_id } },
  { session }
)
```

- Update the transfers_complete array of the receiver’s account by adding the transfer_id to the array.

```javascript
const updateReceiverTransferResults = await accounts.updateOne(
  { account_id: account_id_receiver },
  { $push: { transfers_complete: transfer.transfer_id } },
  { session }
)
```

- Log a message regarding the success or failure of the transaction.

```javascript
if (transactionResults) {
  console.log("Transaction completed successfully.")
} else {
  console.log("Transaction failed.")
}
```

- Catch any errors and close the session.

```javascript
} catch (err) {
  console.error(`Transaction aborted: ${err}`)
  process.exit(1)
} finally {
  await session.endSession()
  await client.close()
}
```