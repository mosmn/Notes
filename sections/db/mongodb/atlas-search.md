# Using Relevance-Based Search and Search Indexes

## Relevance-Based Search

Relevance-based search is a way to surface records from a database based on their relevance to a search term. It allows users to find information that matches their query effectively. Here's an example of how relevance-based search works:

![Relevance-Based Search](https://d36ai2hkxl16us.cloudfront.net/course-uploads/ae62dcd7-abdc-4e90-a570-83eccba49043/y2a02tbr03tu-relevancesearch.png)

In relevance-based search, you specify search terms, and the database returns records that match those terms in a way that prioritizes their relevance.

## Database Indexes

Database indexes are data structures used by developers and database administrators to improve the efficiency of frequent database queries. They enhance the speed at which data can be retrieved from the database. Indexes are used to optimize query performance and are essential for making applications responsive and scalable.

## Search Indexes

Search indexes, on the other hand, are used to specify how records are referenced for relevance-based search, which is the end-users' way of querying for information. Search indexes define the rules and configurations for search algorithms.

Here's an example of how a search index might look:

```json
{
  "analyzer": "lucene.standard",
  "searchAnalyzer": "lucene.standard",
  "mappings": {
    "dynamic": true,
    "fields": {
      "title": {
        "type": "string"
      },
      "plot": {
        "type": "string"
      }
    }
  }
}
```

In this example:

- `analyzer` specifies the analyzer used for the search index (in this case, "lucene.standard" is the default).
- `searchAnalyzer` specifies the analyzer used for searching.
- `mappings` declare field mappings and turn off dynamic indexing in favor of field mappings.

A search index defines how the application's search algorithm should function, and it can be customized according to the requirements of the application.

## Creating a Search Index with Dynamic Mapping

When you create a search index with dynamic mapping, the index queries all fields, including nested fields. Dynamic field mapping searches all fields for the search term, with equal weight placed on all fields.

## Creating a Search Index with Static Field Mapping

In contrast, if you create a search index with static field mapping, you specify which fields to index explicitly. Only queries for the specified fields will return results. Other fields won't be indexed or searchable.

## Using $search and Compound Operators

In MongoDB, you can use the `$search` aggregation stage to perform relevance-based searches. The `$search` stage allows you to specify various compound operators to control the behavior of the search. These compound operators include:

- `must`: Excludes records that do not meet the criteria.
- `mustNot`: Excludes results that do meet the criteria.
- `should`: Allows you to give weight to results that meet the criteria to prioritize them.
- `filter`: Removes results that do not meet the criteria.

Here's an example of how you can use these compound operators within the `$search` aggregation stage:

```json
$search: {
  "compound": {
    "must": [
      {
        "text": {
          "query": "field",
          "path": "habitat"
        }
      }
    ],
    "should": [
      {
        "range": {
          "gte": 45,
          "path": "wingspan_cm",
          "score": {
            "constant": {
              "value": 5
            }
          }
        }
      }
    ]
  }
}
```

These compound operators allow you to filter, prioritize, and fine-tune your search results based on various criteria.

## Grouping Search Results by Using Facets

When working with relevance-based search, you can use `$searchMeta` and `$facet` to group and analyze search results. `$searchMeta` provides metadata related to the search, while `$facet` allows you to define facets for grouping results.

Here's an example of how to use `$searchMeta` and `$facet` to group search results:

```json
$searchMeta: {
  "facet": {
    "operator": {
      "text": {
        "query": ["Northern Cardinal"],
        "path": "common_name"
      }
    },
    "facets": {
      "sightingWeekFacet": {
        "type": "date",
        "path": "sighting",
        "boundaries": [
          ISODate("2022-01-01"),
          ISODate("2022-01-08"),
          ISODate("2022-01-15"),
          ISODate("2022-01-22")
        ],
        "default": "other"
      }
    }
  }
}
```

In this example:

- `facet` is an operator within `$searchMeta`.
- `operator` refers to the search query itself.
- `facets` operator is where you define the buckets for grouping the results.

By using `$facet`, you can organize search results into meaningful categories or facets, making it easier for users to navigate and refine their search.