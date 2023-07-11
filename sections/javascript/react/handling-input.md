# Handling Inputs, Rendering Lists, and Form Submission in React

1. To render lists in React, use the `map` function to iterate over an array of items and return a component for each item.
   ```jsx
   <ul>
     {tasks.map((task) => {
       return <li key={task.id}>{task.text}</li>;
     })}
   </ul>
   ```

2. When rendering lists, make sure to assign a unique `key` prop to each component. The `key` helps React efficiently update and re-render components when the list changes.
   ```jsx
   {tasks.map((task) => {
     return <li key={task.id}>{task.text}</li>;
   })}
   ```

3. To handle input fields and forms in React, use event handlers and state management.
   ```jsx
   <input
     onChange={handleChange}
     value={task.text}
     type="text"
     id="taskInput"
   />
   ```

4. For form submission, use the `onSubmit` event on the `<form>` element. Prevent the default form behavior using `e.preventDefault()` to avoid page refresh.
   ```jsx
   <form onSubmit={onSubmitTask}>
     <input
       onChange={handleChange}
       value={task.text}
       type="text"
       id="taskInput"
     />
     <button type="submit">Add Task</button>
   </form>
   ```

5. Use the `concat` or spread operator to update arrays in state. Avoid directly modifying state arrays or using the `push` method, as it can lead to errors and incorrect rendering.
   ```jsx
   this.setState({
     tasks: this.state.tasks.concat(this.state.task),
     task: { text: "" },
   });
   ```

6. When rendering components, pass data as props to child components. This allows child components to access and display the data.
   ```jsx
   <Overview tasks={tasks} />
   ```

7. Remember to import necessary modules, such as `React`, `Component`, and any additional packages or components used in your code.
   ```jsx
   import React, { Component } from "react";
   ```

### Complete code:
```jsx
// Overview.js

import React from "react";

const Overview = (props) => {
  const { tasks } = props;

  return (
    <ul>
      {tasks.map((task) => {
        return <li key={task.id}>{task.text}</li>;
      })}
    </ul>
  );
};

export default Overview;
```

```jsx
// App.js

import React, { Component } from "react";
import Overview from "./components/Overview";
import uniqid from "uniqid";

class App extends Component {
  constructor() {
    super();

    this.state = {
      task: {
        text: '', 
        id: uniqid()
      },
      tasks: [],
    };
  }

  handleChange = (e) => {
    this.setState({
      task: {
        text: e.target.value,
        id: this.state.task.id,
      },
    });
  };

  onSubmitTask = (e) => {
    e.preventDefault();
    this.setState({
      tasks: this.state.tasks.concat(this.state.task),
      task: {
        text: '', 
        id: uniqid()
      },
    });
  };

  render() {
    const { task, tasks } = this.state;

    return (
      <div>
        <form onSubmit={this.onSubmitTask}>
          <label htmlFor="taskInput">Enter task</label>
          <input
            onChange={this.handleChange}
            value={task.text}
            type="text"
            id="taskInput"
          />
          <button type="submit">Add Task</button>
        </form>
        <Overview tasks={tasks} />
      </div>
    );
  }
}

export default App;
```

## Displaying Task Numbers

1. Modify the `Overview` component code in `Overview.js`.
2. Add the `index` parameter in the `map` function callback.
3. Use `index + 1` to display the task number in the list item.

```jsx
// Overview.js

import React from "react";

const Overview = (props) => {
  const { tasks } = props;

  return (
    <ul>
      {tasks.map((task, index) => {
        return <li key={task.id}>{`Task ${index + 1}: ${task.text}`}</li>;
      })}
    </ul>
  );
};

export default Overview;
```

## Editing Tasks

1. Modify the `Overview` component code in `Overview.js`.
2. Add the `handleEditTask` and `handleDeleteTask` props.
3. Add edit and delete buttons for each task.
4. Add `onClick` event handlers to the edit and delete buttons, calling the respective functions with the task as the argument.

```jsx
// Overview.js

import React from "react";

const Overview = (props) => {
  const { tasks, handleEditTask, handleDeleteTask } = props;

  return (
    <ul>
      {tasks.map((task) => {
        return (
          <li key={task.id}>
            <span>{task.text}</span>
            <button onClick={() => handleEditTask(task)}>Edit</button>
            <button onClick={() => handleDeleteTask(task)}>Delete</button>
          </li>
        );
      })}
    </ul>
  );
};

export default Overview;
```

1. Modify the `App` component code in `App.js`.
2. Import the `Overview` component and `uniqid` package.
3. Add the `editingTaskId` state variable to track the currently edited task.
4. Create the `handleEditTask` function to set the task and `editingTaskId` in state.
5. Create the `handleDeleteTask` function to remove the task from state.
6. Modify the `onSubmitTask` function to handle both adding a new task and updating an existing task.
7. Update the render method to pass the necessary props to the `Overview` component.

```jsx
// App.js

import React, { Component } from "react";
import Overview from "./components/Overview";
import uniqid from "uniqid";

class App extends Component {
  constructor() {
    super();

    this.state = {
      task: {
        text: "",
        id: uniqid(),
      },
      tasks: [],
      editingTaskId: null,
    };
  }

  handleChange = (e) => {
    this.setState({
      task: {
        text: e.target.value,
        id: this.state.task.id,
      },
    });
  };

  onSubmitTask = (e) => {
    e.preventDefault();
    const { tasks, task, editingTaskId } = this.state;

    if (editingTaskId) {
      // Update existing task
      const updatedTasks = tasks.map((t) => {
        if (t.id === editingTaskId) {
          return { ...t, text: task.text };
        }
        return t;
      });

      this.setState({
        tasks: updatedTasks,
        task: { text: "", id: uniqid() },
        editingTaskId: null,
      });
    } else {
      // Add new task
      this.setState({
        tasks: tasks.concat(task),
        task: { text: "", id: uniqid() },
      });
    }
  };

  handleEditTask = (task) => {
    this.setState({
      task: { text: task.text, id: task.id },
      editingTaskId: task.id,
    });
  };

  handleDeleteTask = (task) => {
    const { tasks } = this.state;
    const updatedTasks = tasks.filter((t) => t.id !== task.id);
    this.setState({ tasks: updatedTasks });
  };

  render() {
    const { task, tasks } = this.state;

    return (
      <div>
        <form onSubmit={this.onSubmitTask}>
          <label htmlFor="taskInput">Enter task</label>
          <input
            onChange={this.handleChange}
            value={task.text}
            type="text"
            id="taskInput"
          />
          <button type="submit">Add Task</button>
        </form>
        <Overview
          tasks={tasks}
          handleEditTask={this.handleEditTask}
          handleDeleteTask={this.handleDeleteTask}
        />
      </div>
    );
  }
}

export default App;
```
