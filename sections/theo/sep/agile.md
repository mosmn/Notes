Agile software development AKA Rapid software development:

- Rapid development and delivery of software is now often the most important requirement for a software project. because:
    - Businesses operate in a fast-changing environment and is hard to produce a set of stable software requirements.
    - Most of the time requirements are only clear when the user has gained experience with the software.
    - Software has to evolve quickly to keep up with the changing business environment.
- Plan-driven is essential for some type of systems(critical systems, safety-critical systems, etc.) but doesnt meet these business needs.
- Agile development methods aim is to radically reduce the delivery time of working software systems.

All agile methods have these characteristics in common:
- the processes of specification, design & implementation are interleaved.
- the system is developed in a series of increments.
- Extensive tool support is used to support the development process.

# Agile methods

The dissatisfaction with the overheads involved in software design methods of the 1980s and 1990s led to the creation of agile methods in the late 1990s.
- Allowed developers to focuse on the code rather than the design.
- Are based on an iterative approach to software development.
- Intended to deliver working software as quickly as possible. and evolve the software through the use of feedback from the users.

Aim: 
- to reduce the overheads in the software process (for example, limiting the time spent on documentation) 
- and to be able to respond quickly to changing requirements without excessive rework.

## Agile Manifesto

It values:
- Individuals and interactions over processes and tools.
- Working software over comprehensive documentation.
- Customer collaboration over contract negotiation.
- Responding to change over following a plan.

Based on the manifesto, all different agile processes share a common set of principles:

Principle | Description
---|---
Customer involvement | Customers should be closely involved throughout the development process. Their role is provide and prioritize new system requirements and to evaluate the iterations of the system.
Incremental delivery | The software is developed in increments with the customer specifying the requirements to be included in each increment.
People not process | The skills of the development team should be recognized and exploited. Team members should be left to develop their own ways of working without prescriptive processes.
Embrace change | Expect the system requirements to change and so design the system to accommodate these changes.
Maintain simplicity | Focus on simplicity in both the software being developed and in the development process. Wherever possible, actively work to eliminate complexity from the system.

## Applicability

- Product development where a software company is developing a small to medium sized product for sale.
- Custom system development within an organization, where there is a clear commitment from the customer to become involved in the development process and where there are few external rules and regulations that affect the software.​

# Agile development techniques

## Extreme programming (XP)

- A lightweight methodolgy for small to medium sized teams developing software in the face of vague or rapidly changing requirements.

- Its humanistic because its centered on people and their interactions.

- Its a discipline, meaning it includes practices that we need to follow not just randomlly programming.

Adopte a mentality of sufficiency, meaning delivering only what is necessary to meet the requirements and avoid over-engineering. In other words, developers should strive to create the simplest solution that solves the problem at hand without adding unnecessary features or complexity. This approach can help to avoid waste, reduce costs, and increase the speed of development.

Most important aspects of XP:
- Rapidly develop and deliver working software.
- Fast response to change.
- Easy to manage people (small and medium development teams).

Lightweight is considered as not overburdening the development process. How is it realized in Agile practice?​
- Focus on code rather than documentation​
- Activities for  design  , implementation, testing are interleaved instead of in separate phase

XP values & principles:
- communication, tries to keep the right communication flowing.
- simplicity, we wanna build something simple but not trash.
- feedback, used to drive changes.
- courage, we need to be brave to try new things and throw away things that dont work.

How do we accomplish these values?​ here are some XP practices that help us to achieve these values:
Practices | Description
---|---
Test-first development | Write tests for a new feature before writing the code to implement the feature.
Sustainable pace | The development team should work at a sustainable pace, not overloading the team with too much work.
Small releases | First the important functionality that provide business value is developed. releases of the system are then frequent and small increments.
Simple design | The design of the system should be simple and easy to understand.
Pair programming | Two developers work in pairs, checking each other's work.
On-site customer | The customer is on-site with the development team, working closely with them to ensure that the system is being developed to meet the customer's needs.
Incremental planning | requirements are recorded on "story cards" and the development team breaks these down into "tasks".
Continuous integration | The development team integrates their code into a shared repository several times a day.(pull request)
Collective ownership | The development team owns the code and is responsible for its quality.
Refactoring | All developers are expected to refactor the code continuously as soon as possible code improvements are found. This keeps the code simple and maintainable.

See how they align with agile principles:
![s](/imgs/aprin.png)

XP and agile principles:
- Incremental development is supported through small, frequent system releases.​
- Customer involvement means continous customer engagement with the team.
- People, not process, are supported  through pair programming, collective ownership and a process that avoids long working hours.
- Change supported through regular system releases to customers, test-first​ development, refactoring to avoid code degeneration, and continuous integration​ of new functionality.
- Maintaining simplicity through constant refactoring of code to improves code​ quality and by using simple designs

### Key XP practices
- User stories for specification​
- Refactoring​
- Test-first development​
- Pair programming

#### User stories for specification

When an agile team capture requirements they do so from a user's perspective. This is done by writing a user story. Written on index cards hence the name "story cards". Each story card describes a feature of the system from the user's perspective. The story card is written in the following format:

As a < who wants this piece of fuctionality >, I need < what the user wnats > so that < why the user wants it >.

- The "so that" part is expressing the benifit. its important in agile since we want to deliver value to the customer.
- Acceptance criteria are written on the story card to define when the story is complete.
- In short, a Story card allows you to record a compelling story that tells you what the user wants and why they want it.
- After the story cards are written, and the work is chunked down into samller pieces, the team can start prioritizing and estimating the story cards on the backlog.


#### Refactoring

It means to take a piece of code whos design might be suboptimal and restructuring it so that it becomes simple and maintainable.

We change the code but we don’t change the behavior.

When to refactor?​
- as soon as opportunities for improvement are found.
- The key point here we dont want to refactor on speculations, we want to refactor on demand. the goal is to keep the code simple and maintainable.

#### Test-first development Or Test-driven development

A software development discipline where developers write automated tests cases before writing the code to implement the feature.

How does it work?
- Create the test and test it with the current code which is ging to fail because the new feature is not yet implemented…create code for that feature…test the code again using the created test, after it passes the test we can refactor the code.

What are the benefits of TDD?
- Ensure the quality​
- To make the code testable, simple ​
- To make it understood by other team members​- 
- Repeatable test (use the test every time the code change)

What are the agile principles supported by TDD?
- Respond to change

How does refactoring work in TDD?
- Refactoring happens after the code pass

Customer involvement in TDD:
- to help develop acceptance tests for the stories that are to be implemented in the next release of the system. ​
- writes tests together with team as development proceeds. ​
- All new code is validated to ensure that it is what the customer needs. ​
- However, in real life customer have limited time available and so cannot work full-time with the development team. Only provides  the requirements and not involved in the testing process. 

Test automation​:
- essential for test-first development​
- tests are written as executable components before the task is implemented ​
- Testing components should :​
    - stand-alone​
    - simulate the submission of input to be tested ​
    - check that the result meets the output specification​
- An automated test framework is a system that makes it easy to write executable tests and submit a set of tests for execution. (e.g. Junit) ​
- As testing is automated, there is always a set of tests that can be quickly and easily executed​
    - Whenever any functionality is added to the system, the tests can be run and problems that the new code has introduced can be caught immediately.  

Problems with test-first development:
- Programmers prefer programming to testing and sometimes they take short cuts when writing tests. For example, they may write incomplete tests that do not check for all possible exceptions that may occur. ​
- Some tests can be very difficult to write incrementally. For example, in a complex user interface, it is often difficult to write unit tests for the code that implements the ‘display logic’ and workflow between screens. ​
- It difficult to judge the completeness of a set of tests. Although you may have a lot of system tests, your test set may not provide complete coverage.

#### Pair programming

Why is it called pair programming?​
- Two programmer works using the same computer​

What is the benefits of pair programming​?
- Develop faster​
- Backup for people who know the code besides than you​
- Knowledge sharing (learn from each other)​

How pair programming can support the Agile principles​?
- People and Interaction

# Agile project management​

## Scrum

An implementation of agile. A project management framework for managing and controlling iterative and incremental projects.

Cycle:
- Plane, we do just enough planning to get started and then we adapt the plan as we go along.
- Build, we buid what we planned
- Test & review, we test and review that feature set and get it ready to ship

When that cycle is complete we endup with a potentially shippable product.

This process takes 1-3 weeks to complete.

The process is then repeated time and time again reducing the time from planning to development to testing and review.

You end up with several incremental releases called sprints.

3 key rols in scrum:
- Product owner​, person responsibe for defining the features that are needed in the product.
- Scrum master​, servent leader to the team responsible for protecting the team, the process, and running the meetings.
- Development team​, made of anyone that helps to build the product.

3 Artifacts in scrum:
- Product backlog​, list of all the features(user stories) that are needed in the product by the product owner.
- Sprint backlog​, has the highest proirity user stories. these get estimated for size and committed for the next sprint.
- Burndown chart​, shows the progress of the sprint.

3 ceremonies in scrum:
- Sprint planning​, the product owner, scrummaster, and team meeet to discuss & estimates the size of the user stories.
- Daily scrum​, a brief standup meeting that takes place every day of the sprint, the team discusses what they compleated since the last meeting, what they are working on, and anything that might be blocked or need help.
- Sprint review​, the team demos the work that they have done in the sprint to the product owner and other stakeholders and what they can do to improve the process going forward.

### Scrum workflow
1. Product owner - creates a product backlog with the features that are needed in the product, then proritizes them and bring the list to the team.
2. Sprint planning - the team, product owner, and scrum master meet to discuss the to priority user stories determing what can go into the next sprint.
3. Sprint backlog - the output of the sprint planning meeting is a list of user stories that are ready to be worked on for the next sprint.
4. Sprint - 1-3 weeks of work, the team works on the user stories in the sprint backlog until they are done. during the sprint the daily scrum is held every day.
5. Outcome - potentially shippable product, the product owner can decide to release the product or not.
6. Sprint review - the team demos the work that they have done in the sprint to the product owner and other stakeholders.
7. Sprint retrospective - the team discusses what went well and what didn't go well in the sprint and what they can do to improve the process going forward.

![scrum workflow](/imgs/scrum.png)

# Scaling agile methods​

Agile methods have proved to be successful for small and medium sized projects that can be developed by a small co-located team.​

It is sometimes argued that the success of these methods comes because of improved communications which is possible when everyone is working together.​

Scaling up agile methods involves changing these to cope with larger, longer projects where there are multiple development teams, perhaps working in different locations.

- Scaling up - using agile methods for developing large software systems that cannot be developed by a small team.
- Scaling out - how agile methods can be introduced across a large organization with many years of software development experience.

Practical problems with agile methods:
- The informality of agile development is incompatible with the legal approach to contract definition that is commonly used in large companies.​
- Agile methods are most appropriate for new software development rather than software maintenance. Yet the majority of software costs in large companies come from maintaining their existing software systems.​
- Agile methods are designed for small co-located teams yet much software development now involves worldwide distributed teams.

Contractual issues:
- Most software contracts for custom systems are based around a specification, which sets out what has to be implemented by the system developer for the system customer.​

- However, this precludes interleaving specification and development as is the norm in agile development.​

- A contract that pays for developer time rather than functionality is required. However, this is seen as a high risk on many legal departments because what has to be delivered cannot be guaranteed

### Agile methods and software maintenance

Most organizations spend more on maintaining existing software than they do on new software development. So, if agile methods are to be successful, they have to support maintenance as well as original development.

Two key issues:​
- Are systems that are developed using an agile approach maintainable, given the emphasis in the development process of minimizing formal documentation?​
- Can agile methods be used effectively for evolving a system in response to customer change requests?​

Problems may arise if original development team cannot be maintained.

Agile maintenance:
- Key problems are:​
    - Lack of product documentation​
    - Keeping customers involved in the development process​
    - Maintaining the continuity of the development team​
- Agile development relies on the development team knowing and understanding what has to be done. ​
- For long-lifetime systems, this is a real problem as the original developers will not always work on the system.

### Agile vs plan-driven methods

Is it important to have a very detailed specification and design before moving to implementation? ​
- If so, you probably need to use a plan-driven approach.​

Is the incremental delivery strategy, where you deliver the software to customers and get rapid feedback from them, is realistic? ​
- If so, consider using agile methods.​

How large is the system that is being developed?​
- Agile methods are most effective when the system can be developed with a small co-located team who can communicate informally. This may not be possible for large systems that require larger development teams so a plan-driven approach may have to be used.

### System issues

How large is the system being developed?​(size)
- Agile methods are most effective a relatively small co-located team who can communicate informally. ​

What type of system is being developed?​(complexity)
- Systems that require a lot of analysis before implementation need a fairly detailed design to carry out this analysis. ​

What is the expected system lifetime?​(lifecycle)
- Long-lifetime systems require documentation to communicate the intentions of the system developers to the support team. ​

Is the system subject to external regulation?​(regulation)
- If a system is regulated you will probably be required to produce detailed documentation as part of the system safety case.

### Scaling up to large systems

- A completely incremental approach to requirements engineering is impossible.​

- There cannot be a single product owner or customer representative.​

- For large systems development, it is not possible to focus only on the code of the system.  ​

- Cross-team communication mechanisms have to be designed and used. ​

- Continuous integration is practically impossible. However, it is essential to maintain frequent system builds and regular releases of the system.

### Characteristics of Multi-team Scrum​

- Role replication ​- Each team has a Product Owner for their work component and ScrumMaster. ​

- Product architects ​- Each team chooses a product architect and these architects collaborate to design and evolve the overall system architecture.​

- Release alignment ​- The dates of product releases from each team are aligned so that a demonstrable and complete system is produced.​

- Scrum of Scrums ​- There is a daily Scrum of Scrums where representatives from each team meet to discuss progressand plan work to be done.​