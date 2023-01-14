### Steps to create a new branch and push it to the remote repository

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