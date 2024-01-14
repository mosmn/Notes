# Lint and Format Code with ESLint (VS Code)

1. Firs initialize a project with `npm init`.

```bash
npm init --yes
```
2. this will create a `package.json` file. that will contain all the dependencies of the project.

Then install ESLint.

```bash
npm install eslint --save-dev
```

3. Initialize ESLint.

```bash
./node_modules/.bin/eslint --init
```

4. Select the following options:

```bash
? How would you like to use ESLint? To check syntax, find problems, and enforce code style
? What type of modules does your project use? CommonJS (require/exports)
? Which framework does your project use? None of these
? Does your project use TypeScript? No
? Where does your code run? Browser
? How would you like to define a style for your project? Use a popular style guide
? Which style guide do you want to follow? Airbnb:
? What format do you want your config file to be in? JSON
```

# Formatting on Save

1. use the command `Ctrl+Shift+P` to open the command palette.
2. search Preferences: Open Workspace Settings (JSON).
3. add the following code to the settings.json file.

```json
{
    "editor.codeActionsOnSave": {
        "source.fixAll.eslint": true
    },
    "eslint.validate": ["javascript"]
}
```








