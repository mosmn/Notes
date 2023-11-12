# Golden Rule of Design

To achieve effective design, it is crucial to follow the golden rule: understand your materials. This involves understanding:

1. **Understand Computers**
   - Recognize the limitations, capacities, tools, and platforms of computers.

2. **Understand People**
   - Consider the psychological and social aspects of human interaction with technology.
   - Take into account the potential for human error and learn how to mitigate it.

3. **Understand how people interact with technology to create a harmonious interface.**

# Design Process

Rosson and Carroll describe the design process as follows:

- Design is a dynamic process, not a static state.
- The design process is nonhierarchical, involving collaboration and multiple phases.
- The process is radically transformational, leading to innovative solutions.
- Design intrinsically involves the discovery of new goals.

![Design process]()

## Design Process: Phase 1 - Requirements Analysis

This initial phase involves gathering information regarding system behavior.

![Design process](https://slideplayer.com/slide/12219038/72/images/7/Design+Process%3A+Phase+1+-+Requirements+Analysis.jpg)

## Design Process: Phase 2 – Preliminary and Detailed Design

The design phase consists of two stages:
1. A preliminary stage, where the high-level design or architecture of the interactive system is derived.
2. A detailed stage, where the specifics of each interaction are planned out.

- The preliminary stage is also known as architectural or conceptual design.
- Suitable design methods include sketching, paper mockups, and high-fidelity prototypes.
- These methods can be further clarified using tools, patterns, and best practices.

## Design Process: Phase 3 – Implementation

In this phase, the planning from the previous stages is transformed into actual, running code. The actual software and hardware engineering are executed to achieve this. Consider the following:

- Evaluate tool capabilities, ease of use, ease of learning, cost, and performance.
- Tailor tool choices to match the size and complexity of the project.

## Design Process: Phase 4 – Evaluation

Developers test and validate the system implementation to ensure it aligns with the requirements and design established earlier in the process. This phase is crucial for verifying the success of the design and functionality.

## Design Frameworks

- **User-centered design (UCD)**
  - UCD takes into account the needs, wants, and limitations of the actual end users during each phase of the design process.
  
- **Participatory design (PD)**
  - PD involves the direct involvement of people in the collaborative design of the things and technologies they use.
  
- **Agile Interaction Design**
  - Agile interaction design is about development methods for self-organizing, dynamic teams that facilitate flexible, adaptive, and rapid development, which is robust to changing requirements and needs.

## Design Tools, Practices, and Patterns

- **Design Tools**
  - Dedicated prototyping design tools are specifically designed for creating interface mockups rapidly and effortlessly.

- **Design Guidelines and Standards**
  - Guideline documents are powerful tools for interaction design. They provide standards and best practices for designing interfaces.
  - The "Four E’s" concept includes Education, Enforcement, Exemption, and Enhancement.

- **Interaction Design Patterns**
  - These are best-practice solutions to commonly occurring problems. They are specified in a way that allows them to be reused and applied to slightly different variations of a problem repeatedly.
  - Examples include Model-View-Controller (MVC), document interface, and web app page architecture.

# User Focus

- **Know Your Users**
  - Understand who your users are, and remember that they may not be like you.
  - It's essential to talk to them, watch them, and use your imagination to empathize with their needs.

## User Models

- User modeling and profiling are used to evaluate systems and predict user behaviors.
- Building and modifying a user model is essential for providing a better user experience.
- A user model represents personal data associated with a specific user, used to predict the user's actions and common routines.
- Different types of user models are used based on the application's requirements, and data gathering is crucial in user modeling.
- The key to user modeling is the data gathering

## User Profiling

- User profiling is the process of establishing knowledge about the users.
- Defining user profiles is a key activity in designing interactive systems.
- The "Personas" technique is an excellent way to describe user profiles, including who the users are, their goals in using the product, and the tasks involved.

## Persona

- A persona is a description of an 'example' user, not necessarily a real person.
- Personas are used as surrogate users to understand how they would interact with a product.
- Details matter in creating personas to make them feel 'real' and relatable.

### Persona Example

"Betty is 37 years old,  She has been Warehouse Manager for five years and worked for Simpkins Brothers Engineering for twelve years.  She didn’t go to university, but has studied in her evenings for a business diploma.  She has two children aged 15 and 7 and does not like to work late.  She did part of an introductory in-house computer course some years ago, but it was interrupted when she was promoted and could no longer afford to take the time.  Her vision is perfect, but her right-hand movement is slightly restricted following an industrial accident 3 years ago.  She is enthusiastic about her work and is happy to delegate responsibility and take suggestions from her staff.  However, she does feel threatened by the introduction of yet another new computer system (the third in her time at SBE)."

## Cultural Probes

**Definition**: Cultural probes are a method used to access environments that are difficult to observe directly and capture the "felt life" of individuals.

- **Direct Observation** is Sometimes challenging...
  - Occurs in the home.
  - Often used with psychiatric patients and other hard-to-reach populations.

- **Probe Packs**:
  - Include items to prompt responses (e.g., glass to listen at the wall, camera, postcard).
  - Given to people to open in their own environment, where they record what is meaningful to them.

## Scenario-Based Design

**Definition**: Designing based on an understanding of users, what they do, and why they do it.

- **User Models**:
  - Used to develop personas.

- **Scenarios**:
  - Narrative explanations of how personas use the product to achieve their goals.
  - Goal-directed and describe the interaction from the user's viewpoint.
  - Can be used to define design requirements, design the interaction, and specify interface design elements.
  - Address questions like what users want to do, provide step-by-step walkthroughs, and consider what users can see, do, and think.
  - Use and reuse throughout the design process.

- **Why Use Scenarios**:
  - To communicate with others (designers, clients, users).
  - To validate other models.
  - To express dynamics through behavior and appearance.

## User profile vs. Persona vs. Scenario

| Document          | Definition                                    | Purpose                                               | Content                                        |
  -- - |
| User Profile       | Detailed description of your users' attributes | To ensure that you know who you are developing your product for, and to recruit for usability activities | - Demographic data<br>- Skills<br>- Education<br>- Occupation |
| Persona            | A fictional individual created to describe end users during design based on the user profile | To represent a group of end users during design discussions, and keep everyone focused on the same target goals and tasks | - Identity and photo<br>- Status <br>- Goals and tasks<br>- Skill set<br>- Requirements and expectations <br>- Relationship |
| Scenario           | Story that describes how a particular persona completes a task or behaves in a given situation | To bring your users to life, test to see if your product meets the users' needs, and develop artifacts for usability activities (e.g., tasks for usability tests, day-in-the-life videos for focus groups) | - Setting<br>- Actors<br>- Sequences of events<br>- Objects or goals<br>- Outcome |

## User Requirements

**Definition**: Captures the characteristics of the intended user group, considering novices, casual users, and experts. Always important to know your users.

- **Novice & Casual Users**:
  - Require clear, step-by-step introductions.

- **Expert & Frequent Users**:
  - Need flexible interactions, a wide range of power and control, and shortcut keys.

# **Screen Design - Four Golden Rules**

1. **Knowing Where You Are**
   - Users should always have a clear understanding of their current location within an application or website. This ensures a seamless navigation experience and prevents disorientation.
   - *Example*: Breadcrumbs in a website display the path through the hierarchy, providing users with a visual indication of where they are.

2. **Knowing What You Can Do**
   - Users should be aware of the available actions or functionalities at any given point. This knowledge empowers them to make informed decisions about their interactions with the interface.
   - *Example*: Clearly labeled buttons, links, or icons that indicate specific actions, such as "Save," "Delete," or "Submit."

3. **Knowing Where You Are Going or What Will Happen**
   - Anticipating the outcome of an action or navigation step is essential for user confidence. Users should have a reasonable expectation of what will follow their interactions.
   - *Example*: Tooltips or descriptive hints that appear when hovering over an action button, providing insight into the expected outcome.

4. **Knowing Where You’ve Been or What You’ve Done**
   - A history or record of past actions helps users retrace their steps and understand their journey within an application, enhancing overall user control.
   - *Example*: Browser history that allows users to revisit previously visited pages, aiding in backtracking and reviewing their online session.

### **Basic Principles At Screen Level**

1. **Ask**
   - Designers should ask themselves what specific tasks users are performing on a screen. Understanding user actions guides the layout and presentation of information.
   - *Example*: In a banking app, the screen for fund transfers will be designed with a focus on entering recipient details and transferring money.

2. **Think**
   - Critical thinking about the information users need, the comparisons they may make, and the order in which they perform tasks lays the foundation for effective screen design.
   - *Example*: A product comparison website organizes information logically, allowing users to evaluate features side by side.

3. **Design**
   - The form of the design should align with the intended function. Aesthetic choices should enhance user experience rather than detract from it.
   - *Example*: The layout of a news website prioritizes readability, with clear headings, legible fonts, and a logical flow of articles.

### **Where You Are – Breadcrumbs**

- Breadcrumbs are a navigation aid that shows the user's location within a website's hierarchy. Each level is typically a clickable link, allowing users to jump back to a higher level.
- *Example*: Consider a shopping website where breadcrumbs display the path: Home > Electronics > Smartphones > iPhone X.

### **Navigating Hierarchies**

- Deep structures can be challenging for users to navigate. Misusing the principle of Miller's 7 ± 2 can lead to cognitive overload.
- *Example*: To optimize user experience, a menu might display only the most relevant items and use submenus for additional options, preventing information overload.

### **Available Tools**

1. **Grouping of Items**
   - Logically related items should be physically grouped together, promoting clarity and organization.
   - *Example*: In an e-commerce checkout, billing details, delivery details, and order details are logically grouped together.

2. **Order of Items**
   - The order of items on a screen should align with the natural sequence of user actions, facilitating a smooth flow of control.
   - *Example*: In a form, the sequence might follow the logical order of entering personal information before moving on to payment details.

3. **Decoration**
   - Minimalistic use of fonts, boxes, and other decorative elements enhances visual appeal without overwhelming the user.
   - *Example*: In a clean and modern interface, subtle borders or shading may be used to distinguish between different sections without being distracting.

4. **Alignment of Items**
   - Proper alignment aids readability. Aligning text, names, and numbers consistently helps users scan information efficiently.
   - *Example*: In a list of names, aligning them by surname facilitates quick scanning for users.

5. **White Space Between Items**
   - Adequate white space between items prevents visual clutter and allows users to distinguish between different elements.
   - *Example*: On a website page, strategic use of white space around paragraphs, images, and buttons enhances readability and visual appeal.

### **Grouping And Structure**

- Logically related information should be physically grouped together, promoting a clear and intuitive layout.
- *Example*: In an online shopping cart, grouping billing details, delivery details, and order details logically organizes information for the user.

### **Flow of Control**

- The natural sequence of user actions should guide the flow of control across a screen. This enhances efficiency and transparency.
- *Example*: In a multi-step form, users progress from one section to the next, following the logical flow of providing information.

### **Order of Groups and Items**

- The order

 should match the natural sequence of user actions. Instructions should avoid confusion and guide users effectively.
- *Example*: In an online recipe, the ingredients are listed first, followed by step-by-step instructions, ensuring a logical and user-friendly presentation.

### **A “Natural” Flow of Control**

- Consider cultural constraints when designing the flow of control. Aligning with Western reading habits enhances user understanding.
- *Example*: For Western cultures, the natural flow is from left to right and top to bottom. Design interfaces accordingly for optimal user experience.

### **Decoration**

- Use boxes and fonts strategically to group items and provide emphasis. Excessive decoration can be distracting.
- *Example*: In a webpage, a subtle border around related content or a change in font size for headings can provide visual cues without overwhelming the user.

### **Alignment - Text**

- Left alignment is often preferred for readability in English and European languages, following the natural reading direction.
- *Example*: Aligning paragraphs, headings, and other text elements to the left ensures a familiar and easy-to-read layout.

### **Alignment - Names**

- Aligning names consistently aids in scanning. Consider cultural preferences for surname-first or given-name-first formats.
- *Example*: Alphabetical lists of names can be presented consistently for easy scanning, whether by surname or given name.

### **Alignment - Numbers**

- Visually, long numbers can be perceived as larger. Aligning decimal points or right-aligning integers aids in visual comprehension.
- *Example*: In a financial report, aligning currency figures at the decimal point ensures a clear and organized presentation.

### **Multiple Columns**

- Multiple columns can be challenging to scan, but leaders or greying can assist in maintaining clarity.
- *Example*: In a table of product prices and quantities, using leaders to connect items in each row helps users follow the information across columns.

### **White Space - The Counter**

- Consider both the content and the gaps between elements. White space aids in visual separation and prevents overcrowding.
- *Example*: In a product catalog, adequate white space around each item ensures a clean and visually appealing layout.

### **Different Use of Space**

- Space can be used for separation, structuring, and highlighting specific elements. Purposeful use enhances visual hierarchy.
- *Example*: In a dashboard, space might separate different sections, structure widgets logically, and highlight important metrics for quick reference.

### **Physical Controls**

- Physical controls, like buttons and sliders, benefit from grouping, order, decoration, alignment, and white space for an intuitive interface.
- *Example*: In a microwave control panel, grouping settings logically (defrost, type of food, time to cook) with proper order and alignment ensures a user-friendly experience.

### **Entering Information**

- Forms and dialogue boxes should follow a logical layout based on task analysis. Grouping and natural order ease information entry.
- *Example*: In an address form, arranging fields logically (name, address) with clear labels and proper tab order facilitates efficient data entry.

### **Knowing What to Do**

- Users should easily distinguish active and passive elements. Consistent styles, labels, and icons contribute to clarity.
- *Example*: On a web page, underlined links indicate clickable actions, ensuring users know where to click for additional information or navigation.

### **Affordances**

- Affordances suggest potential actions. On screens, buttons 'afford' clicking, and physical-like objects suggest specific uses.
- *Example*: Icons on a touchscreen 'afford' tapping, guiding users to interact with the displayed options.

### **Presenting Information**

- Consider the purpose of presenting information. Use paper presentation principles and add interactivity for a user-friendly experience.
- *Example*: On a financial dashboard, presenting data in a tabular format with the ability to reorder columns enhances user control and understanding.

### **Aesthetics and Utility**

- Aesthetically pleasing designs increase user satisfaction, but beauty should not compromise utility. Striking a balance is crucial.
- *Example*: A visually appealing website with a clean layout, high-quality graphics, and intuitive navigation enhances user satisfaction and usability.

### **Colour and 3D**

- Colour and 3D effects should be used sparingly to reinforce information. Overuse can lead to visual clutter and distraction.
- *Example*: In a data visualization tool, using colour to highlight specific data points in a chart enhances understanding without overwhelming the user.

### **Bad Use of Colour**

- Overusing colour without a good reason, poor contrast, and neglecting color-blind users can result in a suboptimal user experience.
- *Example*: In a website, using bright, clashing colours without a clear purpose can create visual discomfort and hinder readability.

### **Across Countries and Cultures**

- Considerations for localisation and internationalisation involve adapting interfaces to specific cultures and languages.
- *Example*: Icons representing universal concepts (e.g., a magnifying glass for search) remain consistent across cultures, ensuring a global understanding.
