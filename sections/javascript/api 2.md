# APIs

Servers that are created for serving data for external use (in websites or apps) are often referred to as APIs or ‘Application Programming Interfaces’.

There are multiple ways of requesting data from an API, but all of them basically do the same thing. For the most part:
- APIs are accessed through URLs
- and the specifics of how to query these URLs change based on the specific service you are using.
- For example, WeatherAPI has several types of data that you can request. such as:
    - Current weather
    - Forecast
    - Historical data
    - etc.

In most cases, you will have to create an account and request an “API key” from the API service before attempting to fetch data from their endpoints. Once obtained, an API key will usually have to be included with every data request, such as another URL query string parameter:
```
https://api.weatherapi.com/v1/current.json?key=11111111111111111&q=london
```
API key is random and unique to you.
- As such, services like WeatherAPI can correlate your API key to your requests of their data, including how much and how often you are requesting it.
    - On one hand, issuing API keys allows an API service to better track abuse of their systems and data. 
    - On the other hand, it can also be a way for those services to mitigate and recuperate operating costs. 
        - WeatherAPI, for example, provides not only a free tier but a variety of paid tiers that can cost up to 65 USD/month! After all, running servers costs money, and APIs are no exception.
- As such, you’ll find that most API services, if not all, provide paid tiers that come with the ability to make more frequent requests, or provide access to more information unavailable in lower tiers

# Fetching Data

So how do we actually get the data from an API into our code?
A couple of years ago the main way to access API data in your code was using an `XMLHttpRequest`. This function still works in all browsers, but unfortunately, it is not particularly nice to use. The syntax looks something like this:
```js
// Just getting XHR is a mess!
if (window.XMLHttpRequest) { // Mozilla, Safari, ...
  request = new XMLHttpRequest();
} else if (window.ActiveXObject) { // IE
  try {
    request = new ActiveXObject('Msxml2.XMLHTTP');
  }
  catch (e) {
    try {
      request = new ActiveXObject('Microsoft.XMLHTTP');
    }
    catch (e) {}
  }
}

// Open, send.
request.open('GET', 'https://url.com/some/url', true);
request.send(null);
```
Developers, feeling the pain of having to write that stuff out, began writing 3rd party libraries to take care of this and make it much easier to use. Some of the more popular libraries are:
- [axios](https://github.com/axios/axios)
- [superagent](https://github.com/ladjs/superagent)
both of which have their strengths and weaknesses.

More recently, however, web browsers have begun to implement a new native function for making HTTP requests. Meet fetch:
```js
// URL (required), options (optional)
fetch('https://url.com/some/url')
  .then(function(response) {
    // Successful response :)
  })
  .catch(function(err) {
    // Error :(
  });
```
This does the same thing as the XHR code above, but it’s much easier to use.
- Unlike `XMLHttpRequest` that is a callback-based API, Fetch is promise-based and provides a better alternative that can be easily used in service workers. 

## CORS(Cross-Origin Resource Sharing)

For security reasons, by default, browsers restrict HTTP requests to outside sources.

Cross-Origin Resource Sharing (CORS) is an HTTP-header based mechanism that allows a server to indicate any origins (domain, scheme, or port) other than its own from which a browser should permit loading resources. 

- [WIKI](https://en.wikipedia.org/wiki/Cross-origin_resource_sharing)
- [ARTICLE](https://javascript.info/fetch-crossorigin)

With fetch, you are able to easily supply a JavaScript object for options. It comes right after the URL as a second parameter to the fetch function:
```js
fetch('https://url.com/some/url', {
  mode: 'cors'
})
```

- [Using the Fetch API](https://developer.mozilla.org/en-US/docs/Web/API/Fetch_API/Using_Fetch)
