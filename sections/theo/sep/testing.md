Software testing:
- To show that a program does what it is intended to do
- and to discover program defects before it is put into use.

• Goal :
- Demonstrate to the developer and the
customer that the software meets its
requirements.
- Find inputs or input sequences where the
behavior of the software is incorrect,
undesirable, or does not conform to its
specification.

Can reveal the presence of errors NOT their absence.

Testing is part of a more general verification and
validation process, which also includes static validation
techniques.
- with static we test the software without executing it.
- with dynamic we test the software by executing it.

- Verification: Are we building the product right?
    - The software should conform to its specification.(during specification & design&implementation, its more on preventing errors)
- Validation: Are we building the right product?
    - The software should do what the user really requires.(after we complete the development, its more on finding errors)

Aim and Goal of V&V Process
- Verification to check conformance with the specifications.
- Validation to ensure that the software meets the customer’s expectations.
- Goal of V &V to establish confidence that the software system is “fit for purpose.”

V & V confidence level(this explains why "fit for purpose" is a subjective decision, it dependes on the user)
- Software purpose
    - The level of confidence depends on how
critical the software is to an organisation.
- User expectations
    - Users may have low expectations of certain
kinds of software.
- Marketing environment
    - Getting a product to market early may be
more important than finding defects in the
program.

Inspections(verification) and testing(validation) are the two main techniques used in V & V:
- analyze and check the system requirements, design models,
the program source code, and even proposed system tests.

![f](/imgs/stvv1.png)

Advantages of inspections:
- During testing, errors can mask (hide) other errors. Because inspection is a
static process, don’t have to be concerned with interactions between errors.
- Incomplete versions of a system can be inspected without additional costs.
- Check on broader quality attributes of a program, such as compliance with
standards, portability and maintainability.

Inspections and testing are
complementary and not opposing
verification techniques.

Both should be used during the V & V
process.

Inspections can check conformance
with a specification but not
conformance with the customer’s real
requirements.

Inspections cannot check nonfunctional characteristics such as
performance, usability, etc.

A traditional model of the software testing process:

![f](/imgs/stvv2.png)

![f](/imgs/stvv3.png)

Stages of testing:
1. Development testing(by developers)
- the system is tested during
development to discover bugs
and defects.
2. Release testing(by testers)
- a separate testing team test a
complete version of the
system before it is released to
users.
3. User testing(tester and also users)
- users or potential users of a
system test the system in
their own environment.
- this is when user makes a decision whether the system is fit for purpose or not.

# Development testing

divided into 3 activities:
1. Unit testing
- individual program units or object classes are tested.
- focus on testing the functionality of objects or methods.
2. Component testing
- several individual units are integrated to create composite components.
- focus on testing component interfaces.
3. System testing
- some or all of the components in a system are integrated and the system is tested as a whole.
- focus on testing component interactions.

## Unit testing

- Unit testing is the process of testing
individual components in isolation.
- It is a defect testing process.
- Units may be:
    - Individual functions or methods within an object
    - Object classes with several attributes and methods
    - Composite components with defined interfaces used to access their functionality.

Automated test components:
- make use of a test automation framework (such as JUnit) to write and run your program tests.
- Consist of three parts:
    - setup - initialize the system with the test case (the inputs and expected outputs)
    - call-  call the object or method to be tested.
    - assertion-  compare the result of the call with the expected result (pass/ fail)

Choosing unit test cases:
- Testing is expensive and time consuming
- Effective unit test cases:
1. The test cases should show that,
when used as expected, the
component that you are testing
does what it is supposed to do.
2. If there are defects in the
component, these should be
revealed by test cases

Two designs of test case:
- Reflect normal operation of a
program and should show that
the component works as
expected.

- Based on testing experience of
where common problems arise.

Strategies to choose test cases:
- Partition testing:
identify groups of inputs that have common
characteristics and should be processed in the
same way.
choose tests from within each of these groups.
- Guideline-based testing:
reflect previous experience of the kinds of errors
that programmers often make when developing
components.

Partition testing
- Input data and output results categorized
into different classes where all members of a
class are related.
- Each of these classes is an equivalence
partition or domain where the program
behaves in an equivalent way for each class
member.
- Test cases should be chosen from each
partition.

Guidelines for partition testing with sequences, arrays, or lists:
- Test software with sequences which have
only a single value.
- Use sequences of different sizes in different
tests.
- Derive tests so that the first, middle and last
elements of the sequence are accessed.
- Test with sequences of zero length.

General testing guidelines
- Choose - Choose inputs that force the system to generate all error messages
- Design - Design inputs that cause input buffers to overflow
- Repeat - Repeat the same input or series of inputs numerous times
- Force - Force invalid outputs to be generated
- Force - Force computation results to be too large or too small.

Component testing
- Components: composite components that are made up of several interacting objects.
- The functionality of these objects is define through defined component interface.
- Focus on showing that the component interface behaves according to its specification.
- Assume that unit tests on the individual objects within the component have been completed.

Testing interfaces between program components
- Objectives are to detect faults due to interface errors or invalid assumptions about interfaces.
- Interface types:
    - Parameter interfaces Data passed from one method or procedure to another.
    - Shared memory interfaces Block of memory is shared between procedures or functions.
    - Procedural interfaces Sub-system encapsulates a set of procedures to be called by other sub-systems.
    - Message passing interfaces Sub-systems request services from other sub-systems

Interface errors
- Interface misuse
    - A calling component calls another component and makes an error in its use of its interface e.g. parameters in the wrong order.
- Interface misunderstanding
    - A calling component embeds assumptions about the behaviour of the called component which are incorrect.
- Timing errors
    - The called and the calling component operate at different speeds and out-of-date information is accessed.

Interface testing guidelines
- Design tests so that parameters to a called procedure are at the extreme ends of their ranges.
- Always test pointer parameters with null pointers.
- Design tests which cause the component to fail.
- Use stress testing in message passing systems.
- In shared memory systems, vary the order in which components are activated.

System testing
- Involves integrating components to create a version of the system and then testing the integrated system.
- Focus : testing the interactions between components.
- Checks that components are compatible, interact correctly and transfer the right data at the right time across their interfaces.
- Tests the emergent behavior of a system.

System and component testing
- Reusable components (separately developed) + off-the-shelf systems = complete system  test
- Integration of components developed by different team members or subteams  test

Use-case testing
- to identify system interactions as a basis for system testing.
- Each use case usually involves several system components so testing the use case forces these interactions to occur.
- The sequence diagrams associated with the use case documents the components and interactions that are being tested.

Test cases derived from sequence diagram
- SatComms:request → WeatherStation:reportWeather → Commslink:Get(summary)→ WeatherData:summarize

Testing policies
- Exhaustive system testing is impossible so testing policies which define the required system test coverage may be developed.
- Examples of testing policies:
    - All system functions that are accessed through menus should be tested.
    - Combinations of functions (e.g. text formatting) that are accessed through the same menu must be tested.
    - Where user input is provided, all functions must be tested with both correct and incorrect input.
 
# Release testing

# User testing 