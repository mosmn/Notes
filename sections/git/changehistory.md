# Changing history

First make sure you understand the following concepts:

1. HEAD:
   - In Git, HEAD is a special pointer that represents the current commit you are viewing or working on in your repository.
   - It is essentially a reference to the latest commit on the current branch.
   - HEAD helps you navigate through the commit history and work with the files in your repository.
   - It can be visualized as a pointer pointing to the tip of the current branch.

   Example:
   Let's say you have a Git repository with three commits: A, B, and C, where C is the latest commit. The branch you're currently on is called "main." In this case, HEAD will be pointing to commit C, indicating that it's the commit you are currently viewing or working on.

   ```
   main
     |
     v
   A -> B -> C (HEAD)
   ```

2. Staging Area (Index):
   - The staging area, also known as the index, is an intermediate area between your working directory and the Git repository.
   - It is where you assemble and prepare the changes you want to include in the next commit.
   - Before a commit, you add the modified or new files to the staging area to include them in the upcoming commit.
   - It allows you to selectively stage specific changes or files rather than committing all the changes in your working directory.

   Example:
   Imagine you have made changes to three files: file1.txt, file2.txt, and file3.txt. Out of these, you want to include changes from file1.txt and file3.txt in the next commit. To achieve this, you would add file1.txt and file3.txt to the staging area while keeping file2.txt unchanged.

   ```
   Changes in working directory:
   file1.txt (modified)
   file2.txt (unchanged)
   file3.txt (modified)

   Staging area:
   file1.txt (modified)
   file3.txt (modified)
   ```

   By adding file1.txt and file3.txt to the staging area, you are preparing them to be part of the next commit. The files in the staging area will be included in the commit when you run the `git commit` command.

### Changing The Last Commit

Lets say we run this command:
```shell
git add test3.md && git commit -m 'Create third file and create fourth file'
```
But we forgot to add `test4.md` to the staging area(`git add test4.md`). We can fix this by running:
```shell
git add test4.md
git commit --amend
```
This will open up a text editor where we can change the commit message, Save and close the editor to finish amending the commit.

__only amend commits that have not been pushed anywhere__. The reason for this is that `git commit --amend` does not simply edit the last commit,_it replaces that commit with an entirely new one_. This means that you could potentially destroy a commit other developers are basing their work on.

### Changing Multiple Commits

To enable the Gitlense interactive rebase tool make sure you have Gitlense installed in VSCode, then `cmd + shift + p` and type `Gitlense: Enable Interactive Rebase Tool`, then run the following command:
```shell
git config --global core.editor "code --wait"
```

To modify commits further back in history, we can use the `git rebase` command.

`rebase -i` is a command which allows us to interactively stop after each commit we’re trying to modify, and then make whatever changes we wish.

We do have to tell this command which is the last commit we want to edit. For example, `git rebase -i HEAD~2 `allows us to edit the last two commits.
```shell
git rebase -i HEAD~2
```
- If we wanted to edit one of these commits, we would change the word `pick` to be `edit` for the appropriate commit.
```shell
edit eacf39d Create send file
pick 92ad0af Create third file and create fourth file
```
This would allow us to edit the typo in the Create send file commit to be Create second file.

Save and exit the editor, which will allow us to edit the commit with the following instructions:
```shell
You can amend the commit now, with
       git commit --amend
Once you're satisfied with your changes, run
       git rebase --continue
```
- If we wanted to remove a commit, we would simply remove it from the list.
- If we wanted to change their order, we would change their position in the list.

__this is a very dangerous tool if misused, so be careful. Most importantly, remember that if you have to rebase commits in a shared repository, make sure you’re doing so for a very good reason that your coworkers are aware of.__

### Squashing Commits

Let’s say we want to squash the second commit into the first commit on the list, which is Create first file. First let’s rebase all the way back to our root commit by typing `git rebase -i --root`. Now what we’ll do is pick that first commit, as the one which the second commit is being squashed into:
```shell
pick e30ff48 Create first file
squash 92aa6f3 Create second file
pick 05e5413 Create third file and create fourth file
```
Rename the commit to Create first and second file, then finish the rebase.

### Splitting Up a Commit

Let’s have a look at the commit `Create third file and create fourth file`. At the moment we’re using blank files for convenience, but let’s say these files contained functionality and the commit was describing too much at once. In that case what we could do is split it up into two smaller commits by, once again, using the interactive `rebase` tool.

Change pick to edit for the commit we’re going to split. Now, run `git reset HEAD^`, which resets the commit to the one right before HEAD. This allows us to add the files individually, add, and commit them individually. All together it would look something like this:
```shell
$ git reset HEAD^
$ git add test3.md && git commit -m 'Create third file'
$ git add test4.md && git commit -m 'Create fourth file'
```

To split the commit "Create third file and create fourth file" into two smaller commits using the interactive rebase tool and `git reset`, follow these steps:

1. Open the interactive rebase tool by running the command:

   ```
   git rebase -i HEAD~2
   ```

2. In the interactive rebase file, locate the commit "Create third file and create fourth file" and change the command from `pick` to `edit`. Save and close the file.

3. Run the following command to reset the commit to the one right before HEAD:

   ```
   git reset HEAD^
   ```

4. Now you can add and commit the files individually. For example:

   ```
   git add test3.md
   git commit -m 'Create third file'
   ```

   ```
   git add test4.md
   git commit -m 'Create fourth file'
   ```

5. Once you have added and committed the files separately, you can continue the rebase process by running:

   ```
   git rebase --continue
   ```

   This will apply the remaining commits and complete the rebase.

#### Different `git reset` options:

- `git reset` without any additional flags will reset both the HEAD and the staging area (index) to the specified commit.
- `git reset --soft` will only move the HEAD to the specified commit while leaving the staging area unchanged.
- `git reset --hard` will move the HEAD, update the staging area, and overwrite the working directory to match the specified commit. This can potentially result in data loss, so use it with caution.

__When using `git reset --hard`, be aware that it modifies history and can have implications for shared repositories and collaboration with other developers. Make sure you understand the consequences and communicate with your team members about its usage.__

# Working with Remotes:

1. When collaborating with others on a project, Git requires you to update your local branch with the latest commits from the remote repository before pushing your changes.
2. If you attempt to push a commit that would create a conflict on the remote repository without updating your local branch, you'll receive an error message to prevent overwriting other people's work.
3. Instead of using `git push --force` to overwrite the remote repository, it is recommended to update your local history by fetching the latest changes, merging them into your branch, and then attempting to push again.
       1. Fetch the latest changes from the remote repository:
       ```
       git fetch origin
       ```

       2. Switch to your branch (e.g., `main`):
       ```
       git checkout main
       ```

       3. Merge the changes from the remote branch (e.g., `origin/main`) into your local branch:
       ```
       git merge origin/main
       ```

       4. Resolve any merge conflicts if they occur. Git will guide you through the process.

       5. Once the conflicts are resolved, commit the merged changes:
       ```
       git commit -m "Merge remote-tracking branch 'origin/main' into main"
       ```

       6. Finally, push the merged changes to the remote repository:
       ```
       git push origin main
       ```
By following these steps, you ensure that your local branch is updated with the latest changes from the remote repository, and you can push your changes without overwriting commits created by others.

Using `git push --force`:
1. The `git push --force` command overwrites the remote repository with your own local history.
2. However, using `git push --force` can be dangerous when collaborating with others since it can potentially destroy their work.
3. It is best to use `git push --force` only when necessary and when you are certain it is appropriate, such as when updating pull requests or removing sensitive information accidentally uploaded to a repository.
4. An alternative to `git push --force` is `git push --force-with-lease`, which checks if the branch you're attempting to push to has been updated and sends an error message if it has, allowing you to fetch the work and update your local repository.

# Branches as Pointers

1. In Git, a branch is not a group of commits but a pointer to a single commit.
2. Each commit is a snapshot of the file contents and also a pointer that points to the commit that came before it.
3. When you create a branch, it points to the most recent commit in the branch.
4. The HEAD pointer is a special pointer that keeps track of the branch you're currently on.
5. Git uses these pointers to navigate and track the commit history.
6. For example, when using `git rebase -i HEAD~2`, Git starts with the HEAD pointer, which points to the most recent commit. It then follows the pointers of subsequent commits to identify which commits to edit.

Remember that working with remotes and manipulating history can have serious implications when collaborating with others. It's important to use caution, communicate with your team, and follow best practices to avoid destroying or overwriting their work.