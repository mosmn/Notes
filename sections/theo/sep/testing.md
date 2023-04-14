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

System Testing policies
- Exhaustive system testing(testing all posible conditions) is impossible so testing policies which define the required system test coverage may be developed.
- Examples of testing policies:
    - All system functions that are accessed through menus should be tested.
    - Combinations of functions (e.g. text formatting) that are accessed through the same menu must be tested.
    - Where user input is provided, all functions must be tested with both correct and incorrect input.
 
# Release testing

Release testing:
- Release testing is testing the system to check that changes have not broken previously working code.
- Normally done through automated testing, expensive if conducted manually
- All tests are rerun every time a change is made to the program.
- Tests must run ‘successfully’ before the change is committed.

Release testing vs System testing:
- The system development team should not be responsible for release testing.
- Release testing is a process of validation checking to ensure that a system meets its requirements and is good enough for use by system customers. 
- System testing by the development team should focus on discovering bugs in the system (defect testing).

Goal of Release Testing:
- to convince the supplier of the system that it is good enough for use.
- show that the system delivers its specified functionality, performance and dependability, and that it does not fail during normal use.
- Usually a black-box testing process where tests are only derived from the system specification.
- Another name is functional testing

## Requirements based testing

- Requirements-based testing involves examining each requirement and developing a test or tests for it.
- A validation rather than defect testing
- to demonstrate that the system has properly implemented its requirements.

### Example of Requirements tests

Mentcare system requirements:
- If a patient is known to be allergic to any particular medication, then prescription of that medication shall result in a warning message being issued to the system user.
- If a prescriber chooses to ignore an allergy warning, they shall provide a reason why this has been ignored.

Proposed Test Cases
- Set up a patient record with no known allergies. Prescribe medication for allergies that are known to exist. Check that a warning message is not issued by the system.
- Set up a patient record with a known allergy. Prescribe the medication to that the patient is allergic to, and check that the warning is issued by the system.
- Set up a patient record in which allergies to two or more drugs are recorded. Prescribe both of these drugs separately and check that the correct warning for each drug is issued.
- Prescribe two drugs that the patient is allergic to. Check that two warnings are correctly issued.
- Prescribe a drug that issues a warning and overrule that warning. Check that the system requires the user to provide information explaining why the warning was overruled.

## Scenario Testing

- An approach to release testing whereby you devise typical scenarios of use and use these scenarios to develop test cases for the system.
- Scenario :
    - a story that describes one way in which the system might be used
    - should be realistic and real system users should be able to relate to them
    - scenarios or user stories from the requirements engineering process may be able to reuse them as testing scenarios

### A usage scenario for the Mentcare system

- George is a nurse who specializes in mental healthcare. One of his responsibilities is to visit patients at home to check that their treatment is effective and that they are not suffering from medication side effects.
- On a day for home visits, George logs into the Mentcare system and uses it to print his schedule of home visits for that day, along with summary information about the patients to be visited. He requests that the records for these patients be downloaded to his laptop. He is prompted for his key phrase to encrypt the records on the laptop.
- One of the patients that he visits is Jim, who is being treated with medication for depression. Jim feels that the medication is helping him but believes that it has the side effect of keeping him awake at night. George looks up Jim’s record and is prompted for his key phrase to decrypt the record. He checks the drug prescribed and queries its side effects. Sleeplessness is a known side effect so he notes the problem in Jim’s record and suggests that he visits the clinic to have his medication changed. Jim agrees so George enters a prompt to call him when he gets back to the clinic to make an appointment with a physician. George ends the consultation and the system re-encrypts Jim’s record.
- After, finishing his consultations, George returns to the clinic and uploads the records of patients visited to the database. The system generates a call list for George of those patients who He has to contact for follow-up information and make clinic appointments.

Features tested by scenario from Mentcare System:
- Authentication by logging on to the system.
- Downloading and uploading of specified patient records to a laptop.
- Home visit scheduling.
- Encryption and decryption of patient records on a mobile device.
- Record retrieval and modification.
- Links with the drugs database that maintains side-effect information.
- The system for call prompting.

## Performance testing

- Part of release testing may involve testing the emergent properties of a system, such as performance and reliability.
- Tests should reflect the profile of use of the system.
- Performance tests usually involve planning a series of tests where the load is steadily increased until the system performance becomes unacceptable.
- Stress testing is a form of performance testing where the system is deliberately overloaded to test its failure behaviour.

### Purpose of Stress Testing

- Test the failure behavior of the system.
- Reveal defects that only show up when the system is fully loaded.

# User testing 

- A stage in the testing process in which users or customers provide input and advice on system testing.
- Essential, even when comprehensive system and release testing have been carried out.
- May be conducted in two ways:
    - Formally - test a system that has been commissioned from an external supplier.
    - Informally - users experiment with a new software product to see if they like it and to check that it does what they need.

## Types of user testing

- Alpha testing
    - Users of the software work with the development team to test the software at the developer’s site.
- Beta testing
    - A release of the software is made available to users to allow them to experiment and to raise problems that they discover with the system developers.
- Acceptance testing
    - Customers test a system to decide whether or not it is ready to be accepted from the system developers and deployed in the customer environment.
    - Primarily for custom systems.

## The acceptance testing stages

![The acceptance testing stages](/imgs/stvv4.png)

1. Define acceptance criteria
    - take place early in the process before the contract for the system is signed.
    - The acceptance criteria should be part of the system contract and be approved by the customer and the developer.
2. Plan acceptance testing
    - involves deciding on the resources, time, and budget for acceptance testing and establishing a testing schedule.
    - discuss the required coverage of the requirements and the order in which system features are tested.
    - define risks to the testing process and discuss how these risks can be mitigated.
3. Derive acceptance tests
    - Tests have to be designed to check whether or not a system is acceptable.
    - aim to test both the functional and non-functional characteristics
    - should ideally provide complete coverage of the system requirements.
4. Run acceptance tests
    - should take place in the actual environment where the system will be used, but this may be disruptive and impractical.
    - Otherwise, a user testing environment may have to be set up to run these tests
5. Negotiate test results
    - It is very unlikely that all of the defined acceptance tests will pass and that there will be no problems with the system.
    - the developer and the customer have to negotiate to decide if the system is good enough to be used.
    - They must also agree on how the developer will fix the identified problems.
6. Reject/accept system
    - involves a meeting between the developers and the customer to decide on whether or not the system should be accepted.
    - If the system is not good enough for use, then further development is required to fix the identified problems.
    - Once complete, the acceptance testing phase is repeated.
