# Notes

References notes on various topics. (git(how to), css, html, javascript, c++)

## Table of Contents

- [Git](#git)
- [CSS](#css)
- [HTML](#html)
- [JavaScript](#javascript)
- [C++](#c)

## Git

### How to

To add a new file to the repository:

    git add <file>

To commit the changes:
    
        git commit -m "message"

To push the changes to the remote repository:

    git push

To pull the changes from the remote repository:

    git pull

To clone a repository:

    git clone <url>

To create a new branch:

    git checkout -b <branch>

To switch to an existing branch:

    git checkout <branch>

To merge a branch into the current branch:

    git merge <branch>

To delete a branch:

    git branch -d <branch>

To delete a branch on the remote repository:

    git push origin --delete <branch>

To delete a file from the repository:

    git rm <file>

To delete a file from the repository and commit the changes:

    git rm <file> && git commit -m "message"

### Steps to create a new repository

1. Create a new repository on GitHub.
2. Copy the SSH URL(located under "Code") of the repository.
3. Open a terminal and navigate to the directory where you want to create the repository.
4. Run the following command to clone the repository:

        git clone <url>

5. Navigate to the newly created directory.
6. Run `code .` to open the directory in VS Code.

## Steps to create a new branch and push it to the remote repository

1. Create a new branch:

        git checkout -b <branch>

2. Add the changes to the branch:

        git add <file>

3. Commit the changes:

        git commit -m "message"

4. Push the changes to the remote repository:

        git push -u origin <branch>

### Steps to merge a branch into the current branch

1. Switch to the branch you want to merge into:

        git checkout <branch>

2. Merge the branch:

        git merge <branch>

3. Push the changes to the remote repository:

        git push

### Steps to delete a branch

1. Delete the branch locally:

        git branch -d <branch>

2. Delete the branch on the remote repository:

        git push origin --delete <branch>

## CSS




