# USING RELEVANCE-BASED SEARCH AND SEARCH INDEXES

Relevance-Based Search
Surface records based on a search term, example:

![Relevance-Based Search](https://d36ai2hkxl16us.cloudfront.net/course-uploads/ae62dcd7-abdc-4e90-a570-83eccba49043/y2a02tbr03tu-relevancesearch.png)

Database Indexes
Used by developers and
database administrators
to make their frequent
database queries easier
and more efficient
Search Indexes
Specify how records are
referenced for relevance
based search(end users query for information)
{
  "analyzer": "lucene.standard", //This is where we specify the analyzer that we will use for the search index - lucene.standard is the default.
  "searchAnalyzer": "lucene.standard",
  "mappings": {
    "dynamic": true,
    fields: {This is where we start to declare our field mappings, and turn off dynamic indexing in favor of field mappings.
      "title": {
        "type": "string"
      },
        "plot": {
            "type": "string"
        } These are the fields in our collection that are being mapped to be indexed.
  }
}
A search index is used to describe how the application search algorithm should work. You can customize this with Atlas Search.

# CREATING A SEARCH INDEX WITH DYNAMIC MAPPING

Search Index

Defines how a search
should be performed

Database Index

Makes database queries
more efficient

A search with a dynamic index will query against all of the fields, including nested fields.
Dynamic field mapping is used to search all of the fields for the search term, with equal weight placed on all fields.

# CREATING A SEARCH INDEX WITH STATIC FIELD MAPPING
If the search index is statically mapped and the only field mapping is for the "storeLocation" field, and you searched for one of the items sold by the office supply company, notepads, how many results will come up?
The only field indexed is the location of the store, so data such as the items sold have not been indexed by the search algorithm. Only queries for names of cities present as values in the storeLocation field will be returned.

{
    "mappings": {
        "dynamic": false,
        "fields": {
            "common_name": [
            {
                "dynamic": true,
                "type": "document"
            },
            {
                "type": "string"
            }
            ]
        }
    }
}

# Using $search and Compound Operators
The compound operator within the $search aggregation stage allows us to give weight to different field and also filter our results without having to create additional aggregation stages. The four options for the compound operator are "must", "mustNot, "should", and "filter".

"must" will exclude records that do not meet the criteria. "mustNot" will exclude results that do meet the criteria. "should" will allow you to give weight to results that do meet the criteria so that they appear first. "filter" will remove results that do not meet the criteria.

$search {
  "compound": {
    "must": [{
      "text": {
        "query": "field",
        "path": "habitat"
      }
    }],
    "should": [{
      "range": {
        "gte": 45,
        "path": "wingspan_cm",
        "score": {"constant": {"value": 5}}
      }
    }]
  }
}

"Must", "must not", "should", and "filter" are all clauses, but "filter" does not impact the score given to the results.

# Grouping Search Results by Using Facets
$searchMeta and $facet
$searchMeta is an aggregation stage for Atlas Search where the metadata related to the search is shown. This means that if our search results are broken into buckets, using $facet, we can see that in the $searchMeta stage, because those buckets are information about how the search results are formatted.

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
                "boundaries": [ISODate("2022-01-01"), 
                    ISODate("2022-01-08"),
                    ISODate("2022-01-15"),
                    ISODate("2022-01-22")],
                "default" : "other"
            }
        }
    }
}
"facet" is an operator within $searchMeta. "operator" refers to the search operator - the query itself. "facets" operator is where we put the definition of the buckets for the facets.