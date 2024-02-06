### Study Notes:

#### Keep it secret, keep it safe:

1. **Introduction:**
   - Security beyond password encryption involves safeguarding sensitive information like Express session secrets, MongoDB URLs, and API keys.
   - Never commit such details to Git repositories or publish them.

2. **Dotenv Usage:**
   - **Package:** [dotenv](https://www.npmjs.com/package/dotenv)
   - Create a file named `.env` in the project directory.
   - Add variables using the syntax `[key]=[value]`, e.g., `SECRET_KEY="something hard to guess"`.
   - **Important:** Add `.env` to `.gitignore` to prevent Git commits.
   - Simple and widely used for basic secrets management.

3. **Nconf Usage:**
   - **Package:** [nconf](https://www.npmjs.com/package/nconf)
   - Offers a more robust solution, usable alone or alongside dotenv.
   - Supports defining configuration files in multiple ways for flexibility.
   - Example: Create a `config.js` file for secrets, allowing overrides via command-line arguments.
   - Useful for larger projects with complex configuration needs.

4. **Secrets and PaaS:**
   - When deploying a project, importing environment variables to the chosen PaaS is crucial.
   - Example: For Fly.io, run `fly secrets import < .env` from the command line.
   - Research how to handle environment variables in your PaaS to avoid deployment failures.

### Additional Resources:
- [Dotenv Documentation](https://www.npmjs.com/package/dotenv)
- [Nconf Documentation](https://www.npmjs.com/package/nconf)

### Key Takeaway:
- Prioritize securing sensitive information.
- Utilize dotenv and nconf for effective management of secrets.
- Ensure proper handling of secrets when deploying on PaaS.