Protocols are sets of agreed upon rules that have been created by standards organizations.
Models give you a way to visualize the rules and their place in your network.

# The Rules

### Video - Devices in a Bubble

- The only thing a device(pc, phone, etc...) knows is its own addressing information.
- How does a device know its ip and what network it belongs to?
  How does it know if the destination device it nedds to send info to is on the same network or not?
  If the destination device is on a different network, how does it know how to get there?
  How does a source device know if the info sent was received?
  How to know if it needs to resend the info?
    - The answer to all of these questions is Protocols. the rules that govern how devices communicate with each other.
- TCP is the protocol that ensures Reliability.

### Communications Fundamentals

Elements of a communication method:
- Message source(sender) - the device that is sending the message to the destination device.
- Message destination(receiver) - the device that is receiving the message from the source device and interpreting it.
- Channel - the medium that the message is sent over.

### Communication Protocols

- All communications are governed by protocols.
- Protocols are the rules that communications will follow.
- These rules vary depending on the protocol.

### Rule Establishment

Before comunication some rules need to be established.

To successfully communicate, Protocols must account for the following:
- An identified sender and receiver
- Common language and grammar(format)
- Speed and timing of delivery
- Confirmation of acknowledgement requirements

### Network Protocol Requirements

Common computer protocols include the following requirements:

- Message encoding
- Message formatting and encapsulation
- Message size
- Message timing
- Message delivery options

### Message Encoding

Its the process the process od converting information into another acceptable format for transmission. decoding reverses this process to interpret the information.

### Message Formatting and Encapsulation

Message formats depend on the type of message and the channel that is being used to send the message.

The process of placing one message format (the letter) inside another message format (the envelope) is called encapsulation. De-encapsulation occurs when the process is reversed by the recipient and the letter is removed from the envelope.

### Message Size

- Messages sent across the network are converted to bits. not sent all at once, but in packets. The size of the packets is determined by the protocol.
- The bits are then encoded into a pattern of light, sound, or electrical impulses depending on the channel used to send the message.
- The destination device receives the message and decodes it back to interptet the message.

### Message Timing

- Flow control - the process of managing the rate of data transmission to prevent the sender from overwhelming the receiver.
- Response timeout - hosts on the network use network protocols that specify how long to wait for responses and what action to take if no response is received.
- Acess method - determins when someone can send a message. It is used to prevent collisions on a shared medium. So it checks if the medium is available before sending a message.

### Message Delivery Options

May be one of the following methods:
- Unicast - a message is sent to a single device. one to one.
- Multicast - a message is sent to multiple devices. one to many(not all).
- Broadcast - a message is sent to all devices on the network. one to all. (used in IPv4 but not an option in IPv6)

# Protocols

### Network Protocol Overview

Protocol type | Description
---|---
Network Communications Protocols | Protocols enable two or more devices to communicate over one or more networks. The Ethernet family of technologies involves a variety of protocols such as IP, Transmission Control Protocol (TCP), HyperText Transfer Protocol (HTTP), and many more.
Network Security Protocols | Protocols secure data to provide authentication, data integrity, and data encryption. Examples of secure protocols include Secure Shell (SSH), Secure Sockets Layer (SSL), and Transport Layer Security (TLS).
Routing Protocols | Protocols enable routers to exchange route information, compare path information, and then to select the best path to the destination network. Examples of routing protocols include Open Shortest Path First (OSPF) and Border Gateway Protocol (BGP).
Service Discovery Protocols | Protocols are used for the automatic detection of devices or services. Examples of service discovery protocols include Dynamic Host Configuration Protocol (DHCP) which discovers services for IP address allocation, and Domain Name System (DNS) which is used to perform name-to-IP address translation.

### Network Protocol Functions

Function | Description
---|---
Addressing | identifies the sender and receiver of a message using a defined addressing scheme. such as IPv4 and IPv6.
Reliability | provides garenteed delivery mechanisms in case messages are lost or corrupted in transit. TCP is the most common protocol used for reliability.
Flow control | ensures that data flows at an efficient rate. TCP provides this.
Sequencing | uniquely lables each transmitted segement of data. the receiving device uses this to reassemble the data in the correct order. useful if data segments are lost or arrive out of order. TCP provides this.
Error detection | determines if data became corrupted during transmission. many protocols provide including Ethernet, TCP, IPv4, and IPv6.
Application interface | contains information used for process-to-process communications between network applications. For example, when accessing a web page, HTTP or HTTPS protocols are used to communicate between the client and server web processes.

### Protocol Interaction

Common network protocols used when a device sends a request to a web server for its web page:

- Hypertext Transfer Protocol (HTTP) - controls the way how the web server an web client communicate. it defines the content and formatting of the request and response that are exchanged. both client and server software implement this protocol as part of the application. it relies on other protocols to provide the underlying transport and network services.
- Transmission Control Protocol (TCP) - manages individual conversations. its responsible for garanteeinf the reliable delivery of data and managing flow control.
- Internet Protocol (IP) - responsible for delivering data from one device to another. its used by routers to forward message from one network to another.
- Ethernet - responsible for delivering message from one NIC(network interface card) to another on the same Ethernet local area network LAN.

# Protocol Suites

### Network Protocol Suites

- A protocol suite is a group of inter-related(work together) protocols necessary to perform a communication function.

- A protocol stack shows how the individual protocols within a suite are implemented.

- The protocols are viewed in terms of layers, with each higher-level service depending on the functionality defined by the protocols shown in the lower levels.

- Lower layers are concerned with moving data over the network and providing services to the higher layers.

- Higher layers are concerned with the content of the message being sent.

### Evolution of Protocol Suites

There were several compering types of protocol suites:
1. Internet protocol suite or TCP/IP - the most common and relevant protocol suite used today. its an open standard protocol suit maintained by the Internet Engineering Task Force (IETF).
2. Open system interconnection (OSI) protocols - developed jointly in 1977 by the international organization for standerdization (ISO) and the International Telecommunications Union (ITU). it includes seven layer model called the OSI model. replaced by the TCP/IP suite.
3. AppleTalk - developed by Apple in 1985. it was used in Apple computers and networks. in 1995 Apple discontinued AppleTalk and replaced it with TCP/IP.
4. Novell NetWare - developed by Novell in 1983. it was used in Novell networks. in 1995 Novell discontinued NetWare and replaced it with TCP/IP to replace IPX.

### TCP/IP Protocol Suite

The two most important aspects of TCP/IP for vendors and manufacturers are:
- Open standard protocol suite - its freely avaliable to anyone who wants to use it.
- Standard-based protocol suite - its been endorsed by the network industry and approved by a standards organization.

### TCP/IP Communication Process​

- A web server encapsulating and sending a web page to a client.
- A client de-encapsulating the web page for the web browser

# Standards Organizations

### Open Standards

Open standards encourage:
- interoperability - the ability of different devices to work together.
- competition - the ability of different vendors to compete for business.
- innovation - the ability of different vendors to develop new products and services.

Standards organizations are:
- vendor-neutral - they are not owned or controlled by any one vendor.
- non-profit organizations - they are not owned or controlled by any one vendor.
- established to develop and promote open standards.

### Internet Standards

- Internet society promotes the open development and evolution of the Internet.
- Internet architecture board (IAB) - responsible for management and development of the Internet standards.
- Internet engineering task force (IETF) - develops, updates, and maintains Internet and TCP/IP technologies.
- Internet research task force (IRTF) - long-term researches and develops new Internet technologies.

Organizations involved with the development of TCP/IP:
- Internet corporation for assigned names and numbers (ICANN) - Coordinates IP address allocation, the management of domain names, and assignment of other information
- Internet assigned numbers authority (IANA) - Oversees and manages IP address allocation, domain name management, and protocol identifiers for ICANN

### Electronic and Communications Standards

# Reference Models