# Changing history

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