### Git Basic Commands

#### git status

To check the status of your repository and see which files are modified, staged, or untracked, use the following command:

```shell
git status
```

#### git log

To view the commit history of your repository, including the author, date, and commit message, use the following command:

```shell
git log
```

#### git add

To add a new file or stage changes to an existing file for the next commit, use the following command:

```shell
git add <file>
```

#### git commit

To commit your changes with a descriptive message, use the following command:

```shell
git commit -m "message"
```

#### git push

To push your committed changes to a remote repository, use the following command:

```shell
git push
```

#### git pull

To fetch and merge the latest changes from a remote repository to your local repository, use the following command:

```shell
git pull
```

#### git clone

To create a local copy of a remote repository, use the following command:

```shell
git clone <url>
```

#### git checkout

To switch to a different branch or create a new branch, use the following command:

```shell
git checkout <branch>
```

To create a new branch and switch to it in a single command, use:

```shell
git checkout -b <branch>
```

#### git merge

To merge changes from one branch into the current branch, use the following command:

```shell
git merge <branch>
```

#### git branch

To list all branches in your repository, use the following command:

```shell
git branch
```

To delete a branch, use the following command:

```shell
git branch -d <branch>
```

#### git rm

To delete a file from the repository, use the following command:

```shell
git rm <file>
```

To delete a file from the repository and commit the changes in a single command, use:

```shell
git rm <file> && git commit -m "message"
```

These are just a few of the basic Git commands that can help you manage your version-controlled projects effectively. Feel free to explore more advanced Git functionalities and learn about additional commands as you become more familiar with Git.