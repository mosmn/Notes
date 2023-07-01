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
This will open up a text editor where we can change the commit message. We can also add `test4.md` to the commit message.

__only amend commits that have not been pushed anywhere__