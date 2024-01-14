# Introduction to MongoDB Aggregation

In MongoDB, aggregation refers to the collection and summary of data using a series of stages in a pipeline. Each stage is a built-in method that can be applied to the data, but it does not permanently alter it. The aggregation pipeline is a sequence of stages that are applied in order to process and transform the data.

Here's the structure of an aggregation pipeline:

```javascript
db.collection.aggregate([
    {
        $stage1: {
            <expression1>,
            <expression2>,
            // ...
        },
    },
    {
        $stage2: {
            <expression1>,
            // ...
        }
    }
])
```

Here's an example of an aggregation pipeline applied to a "movies" collection:

```javascript
db.movies.aggregate([
    {
        $match: {
            "imdb.rating": { $gte: 7 },
            name: { $concat: ["$first_name", " ", "$last_name"] },
            genres: { $nin: ["Crime", "Horror"] },
            rated: { $in: ["PG", "G"] },
            languages: { $all: ["English", "Japanese"] }
        }
    },
    {
        $project: {
            _id: 0,
            title: 1,
            rated: 1
        }
    }
])
```

In this example, we use the `$match` stage to filter documents that meet specific conditions and the `$project` stage to specify which fields to include or exclude in the result set.

# Using `$match` and `$group` Stages in a MongoDB Aggregation Pipeline

## `$match` Stage

The `$match` stage is used to filter documents that match specified conditions. Here's the code for the `$match` stage:

```javascript
{
  $match: {
     "field_name": "value"
  }
}
```

## `$group` Stage

The `$group` stage groups documents by a group key and performs aggregate operations on the grouped data. Here's the code for the `$group` stage:

```javascript
{
  $group: {
    _id: <expression>, // Group key
    <field>: { <accumulator> : <expression> }
  }
}
```

In an aggregation pipeline, you can use the `$match` stage to filter documents and then apply the `$group` stage to perform aggregation operations on the filtered data.

Here's an example aggregation pipeline that finds documents with a "state" field matching "CA" and then groups those documents by the group key "$city" while counting the total number of zip codes in the state of California:

```javascript
db.zips.aggregate([
    {
        $match: {
            state: "CA"
        }
    },
    {
        $group: {
            _id: "$city",
            totalZips: { $count: {} }
        }
    }
])
```

# Using `$sort` and `$limit` Stages in a MongoDB Aggregation Pipeline

## `$sort` Stage

The `$sort` stage is used to sort all input documents and return them in a specified order. Use `1` for ascending order and `-1` for descending order:

```javascript
{
    $sort: {
        "field_name": 1
    }
}
```

## `$limit` Stage

The `$limit` stage returns only a specified number of records:

```javascript
{
    $limit: 5
}
```

In an aggregation pipeline, you can use the `$sort` stage to sort documents and then apply the `$limit` stage to restrict the number of results.

Here's an example aggregation pipeline that sorts documents in descending order based on the "pop" field and limits the output to the first five documents after sorting:

```javascript
db.zips.aggregate([
    {
        $sort: {
            pop: -1
        }
    },
    {
        $limit: 5
    }
])
```

# Using `$project`, `$count`, and `$set` Stages in a MongoDB Aggregation Pipeline

## `$project` Stage

The `$project` stage is used to specify which fields of the output documents should be included or excluded. Use `1` to include a field, `0` to exclude a field, and you can also assign new values to fields:

```javascript
{
    $project: {
        state: 1,
        zip: 1,
        population: "$pop",
        _id: 0
    }
}
```

## `$set` Stage

The `$set` stage creates new fields or changes the value of existing fields in documents:

```javascript
{
    $set: {
        place: {
            $concat: ["$city", ",", "$state"]
        },
        pop: 10000
    }
}
```

## `$count` Stage

The `$count` stage creates a new document with a specified field name and sets its value to the number of documents at that stage in the aggregation pipeline:

```javascript
{
    $count: "total_zips"
}
```

These stages can be used to reshape and transform the data in an aggregation pipeline.

# Using the `$out` Stage in a MongoDB Aggregation Pipeline

The `$out` stage is used to write the documents returned by an aggregation pipeline into a collection. It must be the last stage in the pipeline. If the collection specified in `$out` does not already exist, it will be created. If it exists, the existing collection will be replaced with the new data.

Here's the syntax for the `$out` stage:

```javascript
$out: {
    db: "<db>",
    coll: "<newcollection>"
}
```

For example:

```javascript
db.zips.aggregate([
    {
        $group: {
            _id: "$state",
            total_pop: { $sum: "$pop" }
        }
    },
    {
        $match: {
            total_pop: { $lt: 1000000 }
        }
    },
    {
        $out: "small_states"
    }
])
```

In this example, the aggregation pipeline first groups documents by the "state" field and calculates the total population. Then, it filters for states with a total population less than 1,000,000 and writes the result to a new collection called "small_states."

After running the pipeline, you can find the results in the "small_states" collection.