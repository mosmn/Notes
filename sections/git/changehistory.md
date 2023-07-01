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
This will open up a text editor where we can change the commit message:
```
Your message here

# Please enter the commit message for your changes. Lines starting
# with '#' will be ignored, and an empty message aborts the commit.
# Explicit paths specified without -i or -o; assuming --only paths...
# On branch master
# Changes to be committed:
#       new file:   test3.md
#       new file:   test4.md
:wq
```
Press the `Esc` key to switch to command mode.
Type `:wq`(including the colon) and press Enter. This command saves the commit message and exits the editor.


__only amend commits that have not been pushed anywhere__. The reason for this is that `git commit --amend` does not simply edit the last commit,_it replaces that commit with an entirely new one_. This means that you could potentially destroy a commit other developers are basing their work on.