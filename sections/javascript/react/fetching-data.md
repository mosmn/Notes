# Fetching Data

**A Basic Fetch Request**

Before we dive into the React-specific aspects of data fetching, let's briefly revisit how we can utilize the `fetch` API to retrieve data from a server:

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

Now, let's see how we can integrate data fetching into a similar React component. A common scenario is fetching data from an API when a component mounts, allowing us to display that data on the screen.

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

By incorporating these error and loading states, we ensure a smoother user experience, even when dealing with unreliable network conditions.

# 