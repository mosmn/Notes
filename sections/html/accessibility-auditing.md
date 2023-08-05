# Accessibility DevTools

Using your browser's DevTools is incredibly useful for a variety of tasks, such as checking the styles applied to a page and debugging code. However, you may not be aware that you can also use the DevTools to examine various accessibility features, which can be a quick and easy way to audit your website's accessibility.

Some of the accessibility features you can check using DevTools include contrast ratios (as we mentioned in a previous lesson), various accessibility properties, and the accessibility tree. By examining these features, you can quickly identify any accessibility issues on your website and take steps to address them.

To access the accessibility features in DevTools, simply open the DevTools window in your browser and navigate to the Accessibility panel. From there, you can explore the various accessibility features and use them to audit your website's accessibility.

### Accessibility Auditing

There are plenty of third-party tools to audit the accessibility of a web page, each with their own pros and cons, though we're only going to mention three of those tools here. By getting into the habit of auditing your web pages, you'll be able to track down any outstanding a11y issues that you may have missed. If you decide to utilize one of these tools, or another auditing tool if you prefer one you come across, you should focus on fixing issues related to the concepts introduced in these lessons only for now.

1. [axe DevTools for Chrome](https://chrome.google.com/webstore/detail/axe-devtools-web-accessib/lhdoppojpmngadmnindnejefpokejbdd?hl=en-US): This extension-based tool returns a list of issues ranked by severity level and will note any issues for you to manually check.

2. [Lighthouse for Chrome](https://developers.google.com/web/tools/lighthouse): Lighthouse is available in the Chrome DevTools by default (it might also be listed as the Auditing tab) or it can be run from the command line. Lighthouse provides more than just a11y auditing, including performance, best practices, search engine optimization (SEO), and progressive web app (PWA) if applicable. Any issues will be separated by category, and like the axe DevTools, there may be a list of issues for you to manually check.

3. [WebAIM's WAVE](https://wave.webaim.org/): This website-based tool allows you to enter the URL of the page you want to audit, though there are also browser extension and API options. WAVE will return a preview of the page with an overlay of icons on it, and issues are separated into categories of alerts, warnings, and contrast errors. Unfortunately, the icons that are placed on the page may cause the layout to break, but that could be a minor issue if you're more focused on the a11y issues that are found.

### Additional Resources to Read:

* [Accessibility features reference](https://developer.chrome.com/docs/devtools/accessibility/reference/#pane): This provides a brief overview of Chrome's accessibility features in the DevTools, starting from the Accessibility pane section.

* [Emulate vision deficiencies](https://developer.chrome.com/blog/new-in-devtools-83/#vision-deficiencies): This resource is from the Chrome 83 update page and allows you to emulate vision deficiencies using DevTools.

* [Open the Issues tab](https://developer.chrome.com/docs/devtools/issues/#open): This section teaches you how to open the Issues tab in your DevTools. You can find a11y issues in addition to any other issues found.

* [Features of the Accessibility panel](https://firefox-source-docs.mozilla.org/devtools-user/accessibility_inspector/index.html#features-of-the-accessibility-panel): Although tailored to Firefox, this section in MDN's documentation provides useful information that may still be valuable for Chrome users. It explains differences between browsers in terms of the value of the role property and how a11y properties are presented.