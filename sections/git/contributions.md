## A Git Workflow For Open Source Contribution

1. Read the contributing guide for the project.
2. Fork the original ("upstream") repository into your own GitHub account by using the "fork" button at the top of that repo's page on GitHub.
3. Clone your forked repository onto your local machine using the following command:
   ```
   git clone <SSH key / URL>
   ```
4. Set up the upstream repository as another remote by using the following command inside the project folder:
   ```
   git remote add upstream <the original repo that you forked e.g. git@github.com:TheOdinProject/curriculum.git>
   ```

### Ongoing Workflow

1. Create a new feature branch for the specific feature you want to build. Use descriptive branch names and follow the branching practices you learned in the Revisiting Rock Paper Scissors lesson.
2. When you're done with your feature, fetch the most updated copy of the upstream repository using the following command:
   ```
   git fetch upstream
   ```
3. Merge the upstream's changes into your local version of the main branch using the following commands:
   ```
   git checkout main
   git merge upstream/main
   ```
   Or
   ```
   git pull upstream main
   ```
4. Switch back to your feature branch using the following command:
   ```
   git checkout your_feature_name
   ```
5. Merge the main branch into your feature branch to resolve conflicts, if any, using the following command:
   ```
   git merge main
   ```
6. Resolve any merge conflicts using the skills you learned in the Deeper Look at Git lesson.
7. Send your feature branch back up to your origin (your fork of the upstream repository) by using the following command:
   ```
   git push origin your_feature_name
   ```
8. If you have completed an assigned issue, submit a pull request (PR) to merge your feature branch into the original upstream repository's main branch using GitHub's interface.