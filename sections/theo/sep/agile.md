Agile software development AKA Rapid software development:

- Rapid development and delivery of software is now often the most important requirement for a software project. because:
    - Businesses operate in a fast-changing environment and is hard to produce a set of stable software requirements.
    - Most of the time requirements are onl clear when the user has gained experience with the software.
    - Software has to evolve quickly to keep up with the changing business environment.
- Plan-driven is essential for some type of systems(critical systems, safety-critical systems, etc.) but doesnt meet these business needs.
- Agile development methods aim is to radically reduce the delivery time of working software systems.

All agile methods have these characteristics in common:
- the processes of specification, design & implementation are interleaved.
- the system is developed in a series od increments.
- Extensive tool support is used to support the development process.

# Agile methods

The dissatisfaction with the overheads involved in software design methods of the 1980s and 1990s led to the creation of agile methods in the late 1990s.
- Allowed developers to focuse on the code rather than the design.
- Are based on an iterative approach to software development.
- Intended to deliver working software as quickly as possible. and evolve the software through the use of feedback from the users.

Aim: to reduce the overheads in the software process (for example, limiting the time spent on documentation) and to be able to respond quickly to changing requirements without excessive rework.

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

See how the align with agile principles:
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

# Scaling agile methods​