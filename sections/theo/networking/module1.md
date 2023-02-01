# 1.2 Network components

### Host

All computers that are connected to a network and participate directly in network communication are classified as hosts. some are called end devices, and also clients.

Internet Protocol (IP) address is the number that identifies a host on a network.

- Servers, computers that provide services to end devices e.g. web servers, mail servers, file servers, etc. Each service requires separate server software.
- Clients, computers that use (or send request to the servers) services provided by servers e.g. web browsers, mail clients, etc.

### Peer to peer

Peer to peer (P2P) is when a computer functions as both a client and a server.

Advantages | Disadvantages
--- | ---
Easy to set up | No centralized administration
Less complex | Not as secure
Lower cost | Not scalable
Used for simple tasks: transferring files and sharing printers | Slower performance

### End devices

An end device is either the source or destination of a message transmitted over the network. each end device on a network has an address that is used to identify it.

### Intermediary Network Devices

Intermediary network devices are used to connect individual end devices to the network. They are also used to connect networks together to form an internetwork.

Their job is to provide connectivity and ensure data flow across the network.

They use the end device destination address in conjunction with info about the network interconnections to determine the path the message should take.

Other roles include:
- Regenerate and retransmit data signals.
- Maintain information about what pathways exist in the network.
- Notify other devices of errors and communication failures.

### Network Media

Network media is the physical medium that carries the data signals from one device to another. e.g copper wire, fiber optic cable, radio waves, etc.

Media Types | Description
--- | ---
Metal wires within cables | Uses electrical impulses
Glass or plastic fibers within cables (fiber-optic cable) | Uses pulses of light.
Wireless transmission | Uses modulation of specific frequencies of electromagnetic waves.(bluetooth, WiFi, infrared.... )

# 1.3 Network Representations and Topologies

### Network Representation
Network diagrams, often called topology diagrams, use symbols to represent devices within the network.

Specialized terminology used to describe how each of these devices and media connect to each other:
- Network interface card (NIC) - physically connects an end device to the network.
- Physical port - a connector on a network device that connects to a media.
- Interface - specialized ports on a networking device that connect to individual networks. Because routers connect networks, the ports on a router are referred to as network interfaces.


### Topology Diagrams

They provide a visual map of how the network is connected. There are two types of topology diagrams: physical and logical.

- Physical topology diagrams illustrate the physical location of devices and media, lets you see the actual location of intermediary devices and cable installations.
- Logical topology diagrams illustrate devices, ports, and the addressing scheme of the network, lets you see which end devices are connected to which intermediary devices and what media is being used.

# 1.4 Common Types of Networks

### Networks of Many Sizes

Size | Description
--- | ---
Small Home Networks | connect a few computers to each other and the Internet
Small Office/Home Office | enables computer within a home or remote office to connect to a corporate network
Medium to Large Networks | many locations with hundreds or thousands of interconnected computers
World Wide Networks | connects hundreds of millions of computers worldwide – such as the internet

### LANs and WANs

Network infrastructures vary greatly in
terms of:

- Size of the area covered
- Number of users connected
- Number and types of services available
- Area of responsibility

![LANs and WANs](/imgs/lanwan.png)

### The Internet

The internet is a worldwide collection of interconnected LANs and WANs (basicly just collection of interconnected networks).
- LANs are connected to each other using WANs.
- WANs may use copper wires, fiber opticcables, and wireless transmissions

Internet is not owned by any single entity. There are organizations that were developed to help maintain the structure and standardization of internet protocols and processes. e.g. Internet Engineering Task Force (IETF), Internet Corporation for Assigned Names and Numbers (ICANN), Internet Architecture Board (IAB), etc.

### Intranet and Extranet

Intranet, Intranet is a term often used to refer to a private connection of LANs and WANs that belongs to an organization.

Extranet, Extranet is a term often used to refer to a private connection of LANs and WANs that belongs to an organization but is shared with other organizations. so basically it's a private network that is connects more than one organization together.

# 1.5 Internet Connections

### Internet Access Technologies

- Home users/Small offices
    - typically require a connection to an internet service provider (ISP) to access the internet.
    - connection options vary depending on the type of ISP and geographic location, including:
        - DSL (Digital Subscriber Line)
        - Cable
        - Satellite
        - Wireless WANs

- Large organizations
    - Fast connections are required to support business services including IP phones, video conferencing, and data center storage.
    - Service providers (SPs) offer business class interconnections to fulfill these needs. these services include:
        - business DSL
        - Metro Ethernet
        - eased lines

### Home and Small Office Internet Connections

Connection | Description
--- | ---
Cable | high bandwidth, always on, internet offered by cable television service providers.
DSL | high bandwidth, always on, internet connection that runs over a telephone line.
Cellular | uses a cell phone network to connect to the internet.
Satellite | major benefit to rural areas without Internet Service Providers.
Dial-up telephone | an inexpensive, low bandwidth option using a modem.

### Businesses Internet Connections

Businesses may require higher bandwidth, dedicated bandwidth, and managed services.

Connection | Description
--- | ---
Dedicated Leased Line | These are reserved circuits within the service provider’s network that connect distant offices with private voice and/or data networking.
Ethernet WAN | This extends LAN access technology into the WAN.
DSL | Business DSL is available in various formats including Symmetric Digital Subscriber Lines (SDSL).
Satellite | This can provide a connection when a wired solution is not available.

### The Converging Network

Traditional Separate Networks | Converging Networks
--- | ---
Each network uses different technologies to carry the communication signal | Capable of delivering data, voice, and video between many different types of devices over the same network infrastructure
Each network had its own set of rules and standards | Uses the same set of rules, agreements, and implementation standards
Multiple services ran on multiple networks. | Multiple services run on a single network.

# 1.6 Reliable Networks

### Network Architecture

In this context, network architecture refers to the technologies used to build the network. It is the foundation of the network and is the most important factor in determining the reliability of the network. to meet user expectations, the network must address the following: Fault Tolerance, Scalability, Quality of Service (QoS), Security

### Fault Tolerance

Fault tolerance network limits the number of devices affected during a failure.

it does that by having multiple paths between the source and destination devices. this is called Redundancy.

Packet switching networks are inherently fault tolerant because they use multiple paths to send data. it breaks down a single message into smaller packets and sends them along different paths. that way the UX is not affected if one of the paths fails.

### Scalability

When a network is scalable, it means it can quickly expand to support new users and applications without affecting(degrading) the performance of the network.

### Quality of Service (QoS)

Network congestion, occurs when the demand for network bandwidth exceeds its availability.

Network bandwidth is measured in the number of bits that can be transmitted in a single second, or bits per second (bps).

Devices will hold the packets in memory until resources become available to transmit them.

This is handled by having a QoS policy that prioritizes certain types of traffic over others. The type of traffic is important not the content of the traffic.

### Security

Tow types of security:
- Network infrastructure security: Physical security of network devices by preventing unauthorized access to the network.
- Information security: Protecting the data that is transmitted over the network.

Three goals of network security:
- Confidentiality – only intended recipients can read the data
- Integrity – assurance that the data has not be altered with during transmission
- Availability – assurance of timely and reliable access to data for authorized users

# 1.7 Network Trends