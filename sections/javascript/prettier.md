# Prettier Setup (VS Code)

1. Install the extension `Prettier - Code formatter` by Esben Petersen.
2. run
```bash
npm install --save-dev --save-exact prettier
```
3. create a file named `.prettierrc` in the root of the project.
```bash
echo {}> .prettierrc.json
```
4. create a file named `.prettierignore`.

```bash
touch .prettierignore
```
this file will contain all the files that you want to ignore when formatting. for example, if you want to ignore all the files in the `node_modules` and `app.js` folder, you can add the following line to the `.prettierignore` file.

```bash
# ignore artifacts:
app.js
node_modules
``` 

5. finally to formate all files in the project, run the following command.

```bash
npx prettier --write .
```

to format a specific file, run the following command.

```bash
npx prettier --write app/components/Button.js
```

to check if a file is formatted correctly, run the following command.

```bash
npx prettier --check
```

## eslint-config-prettier

This package contains the shareable ESLint configuration that disables all rules that are unnecessary or might conflict with Prettier.

1. install the package.

```bash
npm install --save-dev eslint-config-prettier
```

2. add the `"prettier"` to the `extends` array in the `.eslintrc.json` file.

```json
{
    "extends": ["prettier"]
}
```

3. use this CLI HELP TOOL to find the rules that are unnecessary or might conflict with Prettier.

```bash
npx eslint-config-prettier path/to/main.js
```
Change the `path/to/main.js` to the path of the file that you want to check.

## Git hooks 
git hooks are scripts that run automatically when certain git events occur. for example, when you commit a file, a git hook will run automatically and check if the file is formatted correctly. if the file is not formatted correctly, the commit will be aborted. and you will have to format the file and commit it again. this is a good way to make sure that all the files in the project are formatted correctly.

1. install the package `husky` and `lint-staged`.

```bash
npm install --save-dev husky lint-staged
npx husky install
npm pkg set scripts.prepare="husky install"
npx husky add .husky/pre-commit "npx lint-staged"
```

2. add the following code to the `package.json` file.

```json
{
  "lint-staged": {
    "**/*": "prettier --write --ignore-unknown"
  }
}
```

3. Pre-commit hooks (if using eslint)

```bash
npx mrm@2 lint-staged
```






