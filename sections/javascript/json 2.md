# JSON (JavaScript Object Notation)

- Standardized format for structuring data.
- It is heavily based on the syntax for JavaScript objects.
- You will often encounter JSON formatted data when working with external servers or APIs 
- it is essentially the universal format for transmitting data on the web(e.g., sending some data from the server to the client, so it can be displayed on a web page, or vice versa).

JSON exists as a string — useful when you want to transmit data across a network. It needs to be converted to a native JavaScript object when you want to access the data. This is not a big issue — JavaScript provides a global JSON object that has methods available for converting between the two.

Converting a string to a native object is called deserialization, while converting a native object to a string so it can be transmitted across the network is called serialization.

- JSON is purely a string with a specified data format — it contains only properties, no methods.
- JSON requires double quotes to be used around strings and property names. Single quotes are not valid other than surrounding the entire JSON string.
- Even a single misplaced comma or colon can cause a JSON file to go wrong, and not work. You should be careful to validate any data you are attempting to use (although computer-generated JSON is less likely to include errors, as long as the generator program is working correctly). You can validate JSON using an application like JSONLint.
- JSON can actually take the form of any data type that is valid for inclusion inside JSON, not just arrays or objects. So for example, a single string or number would be valid JSON.
- Unlike in JavaScript code in which object properties may be unquoted, in JSON only quoted strings may be used as properties.

## JSON structure

You can include the same basic data types inside JSON as you can in a standard JavaScript object — strings, numbers, arrays, booleans, and other object literals. This allows you to construct a data hierarchy, like so:

```json
{
  "squadName": "Super hero squad",
  "homeTown": "Metro City",
  "formed": 2016,
  "secretBase": "Super tower",
  "active": true,
  "members": [
    {
      "name": "Molecule Man",
      "age": 29,
      "secretIdentity": "Dan Jukes",
      "powers": ["Radiation resistance", "Turning tiny", "Radiation blast"]
    },
    {
      "name": "Madame Uppercut",
      "age": 39,
      "secretIdentity": "Jane Wilson",
      "powers": [
        "Million tonne punch",
        "Damage resistance",
        "Superhuman reflexes"
      ]
    },
    {
      "name": "Eternal Flame",
      "age": 1000000,
      "secretIdentity": "Unknown",
      "powers": [
        "Immortality",
        "Heat Immunity",
        "Inferno",
        "Teleportation",
        "Interdimensional travel"
      ]
    }
  ]
}
```

If we loaded this string into a JavaScript program and parsed it into a variable called `superHeroes` for example, we could then access the data inside it using the same dot/bracket notation:

```js
//parse the JSON string into a JavaScript object
let superHeroes = JSON.parse(jsonString);

//access the members array
superHeroes.members;
superHeroes["members"];
```

To access data further down the hierarchy, you have to chain the required property names and array indexes together. For example, to access the third superpower of the second hero listed in the members list, you'd do this:

```js
superHeroes.members[1].powers[2];
//or
superHeroes["members"][1]["powers"][2];
```

## Arrays as JSON

Above we mentioned that JSON text basically looks like a JavaScript object inside a string. We can also convert arrays to/from JSON. Below is also valid JSON, for example:

```json
[
  {
    "name": "Molecule Man",
    "age": 29,
    "secretIdentity": "Dan Jukes",
    "powers": ["Radiation resistance", "Turning tiny", "Radiation blast"]
  },
  {
    "name": "Madame Uppercut",
    "age": 39,
    "secretIdentity": "Jane Wilson",
    "powers": [
      "Million tonne punch",
      "Damage resistance",
      "Superhuman reflexes"
    ]
  }
]
```
The above is perfectly valid JSON. You'd just have to access array items (in its parsed version) by starting with an array index, for example `[0]["powers"][0]`.

## Converting between objects and text

- `parse()`: Accepts a JSON string as a parameter, and returns the corresponding JavaScript object.
    - A common use of JSON is to exchange data to/from a web server.
    - When receiving data from a web server, the data is always a string.
    - Parse the data with `JSON.parse()`, and the data becomes a JavaScript object.
    - [SEE MORE](https://www.w3schools.com/js/js_json_parse.asp)
- `stringify()`: Accepts an object as a parameter, and returns the equivalent JSON string.
    - When sending data to a web server, the data has to be a string.
    - Convert a JavaScript object into a string with `JSON.stringify()`.
    - [SEE MORE](https://www.w3schools.com/js/js_json_stringify.asp)

[SEE MORE](https://developer.mozilla.org/en-US/docs/Learn/JavaScript/Objects/JSON#converting_between_objects_and_text)