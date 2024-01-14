# Fetching Data

**A Basic Fetch Request**

`fetch` API to retrieve data from a server:

```javascript
const image = document.querySelector("img");
fetch("https://jsonplaceholder.typicode.com/photos", {
  mode: "cors",
})
  .then((response) => response.json())
  .then((data) => {
    image.src = data[0].url;
  })
  .catch((error) => console.error(error));
```

Here, we're making a request to the JSONPlaceholder API to fetch an image and then setting its URL as the source for an `<img>` element.

**Using `fetch` in React Components**

A common scenario is fetching data from an API when a component mounts, allowing us to display that data on the screen.

When a component needs to make a request during rendering, it's often best to encapsulate the `fetch` operation within a React effect.

```javascript
import { useEffect, useState } from "react";

const Image = () => {
  const [imageURL, setImageURL] = useState(null);

  useEffect(() => {
    fetch("https://jsonplaceholder.typicode.com/photos", { mode: "cors" })
      .then((response) => response.json())
      .then((data) => setImageURL(data[0].url))
      .catch((error) => console.error(error));
  }, []);

  return (
    imageURL && (
      <>
        <h1>An image</h1>
        <img src={imageURL} alt={"placeholder text"} />
      </>
    )
  );
};

export default Image;
```

Here, the `useState` hook helps us manage the `imageURL` state, while the `useEffect` hook facilitates side effects. In this case, the side effect is fetching data from an external API. By providing an empty dependency array (`[]`), we ensure that the data is fetched only once when the component mounts.

**Handling Errors**

Working over a network introduces inherent unpredictability. The API might be down, there could be network issues, or the response may contain errors. Many things can go awry, and if we don't anticipate errors, our website can break or appear unresponsive to users.

To address this, we need to check for errors before rendering JSX in the `Image` component. We'll introduce an `error` state:

```javascript
if (error) return <p>A network error occurred</p>;
```

To implement this, we add the `error` state to the component:

```javascript
const [imageURL, setImageURL] = useState(null);
const [error, setError] = useState(null);
```

Then, we handle errors within the `fetch` operation by checking the response status:

```javascript
.then((response) => {
  if (response.status >= 400) {
    throw new Error("Server error");
  }
  return response.json();
})
.then((data) => setImageURL(data[0].url))
.catch((error) => setError(error));
```

Now, when a bad URL is provided or the API responds unexpectedly, the page informs the user of the issue.

**Loading State**

In addition to error handling, we can also introduce a loading state to check whether the request is still pending:

```javascript
const [imageURL, setImageURL] = useState(null);
const [error, setError] = useState(null);
const [loading, setLoading] = useState(true);
```

Within the `fetch` operation, we update the loading state upon completion:

```javascript
.finally(() => setLoading(false));
```

This allows us to conditionally render a loading message:

```javascript
if (loading) return <p>Loading...</p>;
```

# Custom Hooks

**Creating a Custom Hook**

Let's start by elevating our data-fetching logic to a custom hook. This approach allows us to make the logic reusable and easily testable. Here's how we can achieve this for our example:

```javascript
import { useState, useEffect } from "react";

const useImageURL = () => {
  const [imageURL, setImageURL] = useState(null);
  const [error, setError] = useState(null);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    fetch("https://jsonplaceholder.typicode.com/photos", { mode: "cors" })
      .then((response) => {
        if (response.status >= 400) {
          throw new Error("server error");
        }
        return response.json();
      })
      .then((response) => setImageURL(response[0].url))
      .catch((error) => setError(error))
      .finally(() => setLoading(false));
  }, []);

  return { imageURL, error, loading };
};

const Image = () => {
  const { imageURL, error, loading } = useImageURL();

  if (error) return <p>A network error was encountered</p>;
  if (loading) return <p>Loading...</p>;

  return (
    <>
      <h1>An image</h1>
      <img src={imageURL} alt={"placeholder text"} />
    </>
  );
};
```

With this custom hook, we encapsulate the data-fetching logic and reuse it in our `Image` component. This separation of concerns enhances code maintainability and reusability.

**Managing Multiple Fetch Requests**

In a real-world web application, you'll often need to make multiple requests, which requires careful organization. One common issue new React developers face when dealing with multiple requests is known as a "waterfall of requests." Let's explore this concept with an example:

```javascript
import { useEffect, useState } from 'react';
import Bio from './Bio.jsx';

const Profile = ({ delay }) => {
  const [imageURL, setImageURL] = useState(null);

  useEffect(() => {
    setTimeout(() => {
      fetch('https://jsonplaceholder.typicode.com/photos', { mode: 'cors' })
        .then((response) => response.json())
        .then((response) => setImageURL(response[0].url))
        .catch((error) => console.error(error));
    }, delay);
  }, [delay]);

  // ...
};

export default Profile;

import { useState, useEffect } from 'react';

const Bio = ({ delay }) => {
  const [bioText, setBioText] = useState(null);

  useEffect(() => {
    setTimeout(() => {
      fetch('https://jsonplaceholder.typicode.com/photos', { mode: 'cors' })
        .then((response) => response.json())
        .then((response) => setBioText('I like long walks on the beach and JavaScript'))
        .catch((error) => console.error(error));
    }, delay);
  }, []);

  // ...
};
```

In this example, both `Profile` and its child component `Bio` make fetch requests independently. However, this approach can lead to performance issues, as the child component (`Bio`) waits for the parent component (`Profile`) to complete its request before rendering.

To address this, we can lift the request to the higher-level component and pass the response as a prop to the child component. This ensures that both requests are initiated simultaneously, improving performance and maintaining a smooth user experience. as such:

```javascript
import { useEffect, useState } from 'react';
import Bio from './Bio.jsx';

const Profile = ({ delay }) => {
  const [imageURL, setImageURL] = useState(null);
  const [bioText, setBioText] = useState(null);

  useEffect(() => {
    setTimeout(() => {
      fetch('https://jsonplaceholder.typicode.com/photos', { mode: 'cors' })
        .then((response) => response.json())
        .then((response) => setImageURL(response[0].url))
        .catch((error) => console.error(error));
    }, delay);

    setTimeout(() => {
      fetch('https://jsonplaceholder.typicode.com/photos', { mode: 'cors' })
        .then((response) => response.json())
        .then((response) => setBioText('I like long walks on the beach and JavaScript'))
        .catch((error) => console.error(error));
    }, delay);
  }, [delay]);

  // ...
};
```