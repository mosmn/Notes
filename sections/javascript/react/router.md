# Client-Side Routing

Client-side routing is internal handling of routes inside the JS file that is rendered to the client (front-end). Client-side routing helps in building single-page applications (SPAs) without refreshing as the user navigates. For example, when a user clicks a navbar element, the URL changes, and the view of the page is modified accordingly within the client.

## React Router

- React Router is the standard routing library for React applications. To install it, use `npm i react-router-dom`.
- It allows specifying which component should be rendered based on the route.
- From version 4 onwards, React Router uses dynamic routes, which means routing takes place as the app is rendering.

[React Router Documentation](https://reactrouter.com/en/main/start/overview)

## Steps to Use React Router

1. Create a new project using `create-react-app`.
2. Remove the boilerplate code in the created project, keeping only the `index.js` and `App.js` files.
3. Create a new file called `Profile.js` inside the `src` directory.

```javascript
// Profile.js
import React from "react";

const Profile = () => {
  return (
    <div>
      <h1>Hello from Profile</h1>
    </div>
  );
};

export default Profile;
```

4. Create a new file called `RouteSwitch.js`.
5. Install the `react-router-dom` package using `npm i react-router-dom`.

```jsx
// RouteSwitch.js
import React from "react";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import App from "./App";
import Profile from "./Profile";

const RouteSwitch = () => {
  return (
    // Is a router, which uses the history API (pushState, replaceState and the popstate event) to keep your UI in sync with the URL. For completion we have to mention that there are other options than BrowserRouter, but for your current projects you can assume that BrowserRouter is at the root of all your projects.
    <BrowserRouter>
    // Renders the first child Route that matches the location. In other words, the Routes component is going to look through all your Routes and checks their path. The first Route, whose path matches the url exactly will be rendered; all others will be ignored. Important to note is that in previous versions of react-router-dom the exact keyword was needed to achieve this behavior.
      <Routes>
    //   Those are our routes with a path, which equals the url path, and a component that should be rendered when we navigate to this url.
        <Route path="/" element={<App />} />
        <Route path="/profile" element={<Profile />} />
      </Routes>
    </BrowserRouter>
  );
};

export default RouteSwitch;
```
6. Update the `index.js` file to render the `RouteSwitch` component as the first file.
```javascript
// index.js
import React from "react";
import ReactDOM from "react-dom";
import RouteSwitch from "./RouteSwitch";

ReactDOM.render(
  <React.StrictMode>
    <RouteSwitch />
  </React.StrictMode>,
  document.getElementById("root")
);
```

## Link

- The `Link` component is used to navigate between pages.
- It is similar to the `a` tag in HTML, but it does not refresh the page.
- It is imported from `react-router-dom`.

```jsx
// App.js
import React from "react";
import { Link } from "react-router-dom";

const App = () => {
  return (
    <div>
      <h1>Hello from App</h1>
      <Link to="/profile">Go to Profile</Link>
    </div>
  );
};

export default App;
```

## Dynamic parameter

- Dynamic parameters are used to pass data to a component.
- They are used to create dynamic routes.
- They are defined using a colon (`:`) followed by the parameter name.
- They are accessed using the `useParams` hook.

```jsx
// RouteSwitch.js
import React from "react";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import App from "./App";
import Profile from "./Profile";
import Post from "./Post";

const RouteSwitch = () => {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<App />} />
        <Route path="/profile" element={<Profile />} />
        <Route path="/profile/:id" element={<Post />} />
      </Routes>
    </BrowserRouter>
  );
};

export default RouteSwitch;
```
- The `:id` is a dynamic parameter that can be used to access the id of the current route.
- It is used in the `path` prop of the `Route` component.
```jsx
// Profile.js
import React from "react";
import { Link } from "react-router-dom";

const Profile = () => {
  return (
    <div>
      <h1>Hello from Profile</h1>
      <Link to="/profile/1">Go to Post 1</Link>
      <Link to="/profile/2">Go to Post 2</Link>
      <Link to="/profile/3">Go to Post 3</Link>
    </div>
  );
};

export default Profile;
```

## useParams

- The `useParams` hook is used to access the parameters of the current route.
- It returns an object with the parameters passed in the URL.
- It is imported from `react-router-dom`.

```jsx
// Post.js
import React from "react";
import { useParams } from "react-router-dom";

const Post = () => {
  const { id } = useParams();
  return (
    <div>
      <h1>Post {id}</h1>
    </div>
  );
};

export default Post;
```

## Error Page

- The `Route` component can be used to create an error page.
- The `*` is used to match all routes that are not defined.
- It is used in the `path` prop of the `Route` component.

```jsx
// RouteSwitch.js
import React from "react";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import App from "./App";
import Profile from "./Profile";
import Post from "./Post";

const RouteSwitch = () => {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<App />} />
        <Route path="/profile" element={<Profile />} />
        <Route path="/profile/:id" element={<Post />} />
        <Route path="*" element={<h1>404 Not Found</h1>} />
      </Routes>
    </BrowserRouter>
  );
};

export default RouteSwitch;
```

## Nesting Route

- The `Route` component can be used to nest routes.
```jsx
// RouteSwitch.js
import React from "react";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import App from "./App";
import Profile from "./Profile";
import Post from "./Post";

const RouteSwitch = () => {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<App />} />
        <Route path="/profile">
            <Route index element={<Profile />} />
            <Route path=":id" element={<Post />} />
        </Route>
        <Route path="*" element={<h1>404 Not Found</h1>} />
      </Routes>
    </BrowserRouter>
  );
};

export default RouteSwitch;
```
- The `index` is used to match the route without any parameters.

## Sharing a layout

- Creating a layout component.
```jsx
// PostLayout.js
import {Link, Outlet} from 'react-router-dom';

const PostLayout = () => {
    return (
        <div>
            <h1>Post Layout</h1>
            <Link to="/profile/1">Go to Post 1</Link>
            <Link to="/profile/2">Go to Post 2</Link>
            <Link to="/profile/3">Go to Post 3</Link>
            <Outlet />
        </div>
    )
}

export default PostLayout;
```
- The `Outlet` component is used to render the content of the current route.
```jsx
// RouteSwitch.js
import React from "react";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import App from "./App";
import Profile from "./Profile";
import Post from "./Post";
import PostLayout from "./PostLayout";

const RouteSwitch = () => {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<App />} />
        <Route path="/profile" element={<PostLayout />}>
            <Route index element={<Profile />} />
            <Route path=":id" element={<Post />} />
        </Route>
        <Route path="*" element={<h1>404 Not Found</h1>} />
      </Routes>
    </BrowserRouter>
  );
};

export default RouteSwitch;
```

### You can also remove the path prop from the parent route if your routs dont have any common path but share a common layout.

```jsx
// RouteSwitch.js
import React from "react";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import App from "./App";
import Profile from "./Profile";
import Post from "./Post";
import PostLayout from "./PostLayout";

const RouteSwitch = () => {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<App />} />
        <Route element={<PostLayout />}>
            <Route index element={<Profile />} />
            <Route path=":id" element={<Post />} />
        </Route>
        <Route path="*" element={<h1>404 Not Found</h1>} />
      </Routes>
    </BrowserRouter>
  );
};

export default RouteSwitch;
```

### Outlet context prop

- The `Outlet` component can be used to pass props to the child routes using the `context` prop.
```jsx
// PostLayout.js
import {Link, Outlet} from 'react-router-dom';

const PostLayout = () => {
    return (
        <div>
            <h1>Post Layout</h1>
            <Link to="/profile/1">Go to Post 1</Link>
            <Link to="/profile/2">Go to Post 2</Link>
            <Link to="/profile/3">Go to Post 3</Link>
            <Outlet context={{name: "John Doe"}} />
        </div>
    )
}

export default PostLayout;
```
- Now you can access the `name` prop in the child routes using the `useOutletContext` hook.
```jsx
// Post.js
import React from "react";
import { useOutletContext, useParams } from "react-router-dom";

const Post = () => {
  const { id } = useParams();
  const obj = useOutletContext();
    return (
        <div>
        <h1>Post {id}</h1>
        <h2>Author: {obj.name}</h2>
        </div>
    );
};

export default Post;
```






