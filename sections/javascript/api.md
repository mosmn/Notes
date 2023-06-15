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