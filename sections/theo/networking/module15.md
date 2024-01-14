# Application, Presentation, and Session

### Application Layer

it is the layer that provides the interface between the applications used to communicate, and the underlying network over which messages are transmitted.

Application layer protocols are used to exchange data between programs running on the source and destination hosts.

Protocols:
- Domain Name System (DNS)
- Hypertext Transfer Protocol (HTTP)
- Simple Mail Transfer Protocol (SMTP)
- Post Office Protocol (POP3)
- Dynamic Host Configuration Protocol (DHCP)
- File Transfer Protocol (FTP)
- Internet Message Access Protocol (IMAP)

### Presentation and Session Layer

The presentation layer has three primary functions:
- Formatting, or presenting, data at the source device into a compatible format for receipt by the destination device.
- Compressing data in a way that can be decompressed by the destination device.
- Encrypting data for transmission and decrypting data upon receipt.

Standards:
- Matroska video (MKV)
- Motion Picture Experts Group (MPEG)
- QuickTime video (MOV)
- Graphics Interchange Format (GIF)
- Joint Photographic Experts Group (JPEG)
- Portable Network Graphics (PNG)

Session Layer
- create and maintain dialogs between source and destination applications. 
- The session layer handles the exchange of information to initiate dialogs, keep them active, and to restart sessions that are disrupted or idle for a long period of time.

### TCP/IP Application Layer Protocols

1. Name System

DNS - Domain Name System (or Service)
- TCP, UDP 53
- Translates domain names, such as cisco.com, into IP addresses.

2. Host Config
BOOTP - Bootstrap Protocol
- UDP client 68, server 67
- Enables a diskless workstation to discover its own IP address, the IP address of a BOOTP server on the network, and a file to be loaded into memory to boot the machine
- BOOTP is being superseded by DHCP

DHCP - Dynamic Host Configuration Protocol
- UDP client 68, server 67
- Dynamically assigns IP addresses to be re-used when no longer needed

3. Email
SMTP - Simple Mail Transfer Protocol
- TCP 25
- Enables clients to send email to a mail server
- Enables servers to send email to other servers

POP3 - Post Office Protocol
- TCP 110
- Enables clients to retrieve email from a mail server
- Downloads the email to the local mail application of the client

IMAP - Internet Message Access Protocol
- TCP 143
- Enables clients to access email stored on a mail server
- Maintains email on the server

4. File Transfer
FTP - File Transfer Protocol
- TCP 20 to 21
- Sets rules that enable a user on one host to access and transfer files to and from another host over a network
- FTP is a reliable, connection-oriented, and acknowledged file delivery protocol

TFTP - Trivial File Transfer Protocol
- UDP client 69
- A simple, connectionless file transfer protocol with best-effort, unacknowledged file delivery
- It uses less overhead than FTP

5. Web
HTTP - Hypertext Transfer Protocol
- TCP 80, 8080
- A set of rules for exchanging text, graphic images, sound, video, and other multimedia files on the World Wide Web

HTTPS - HTTP Secure
- TCP, UDP 443
- The browser uses encryption to secure HTTP communications
- Authenticates the website to which you are connecting your browser

# Peer-to-Peer

### Client-Server Model

Client and server processes are considered to be in the application layer. The client begins the exchange by requesting data from the server, which responds by sending one or more streams of data to the client. Application layer protocols describe the format of the requests and responses between clients and servers. In addition to the actual data transfer, this exchange may also require user authentication and the identification of a data file to be transferred.

Data transfer from a client to a server is referred to as an upload and data from a server to a client as a download.

### Peer-to-Peer Networks

In the peer-to-peer (P2P) networking model, the data is accessed from a peer device without the use of a dedicated server

The P2P network model involves two parts: P2P networks and P2P applications

In a P2P network, two or more computers are connected via a network and can share resources (such as printers and files) without having a dedicated server. 

Every connected end device (known as a peer) can function as both a server and a client. 

One computer might assume the role of server for one transaction while simultaneously serving as a client for another. The roles of client and server are set on a per request basis.

### Peer-to-Peer Applications

A P2P application allows a device to act as both a client and a server within the same communication, as shown in the figure. In this model, every client is a server and every server is a client. P2P applications require that each end device provide a user interface and run a background service.

Some P2P applications use a hybrid system where resource sharing is decentralized, but the indexes that point to resource locations are stored in a centralized directory. In a hybrid system, each peer accesses an index server to get the location of a resource stored on another peer.

### Common P2P Applications

With P2P applications, each computer in the network that is running the application can act as a client or a server for the other computers in the network that are also running the application. Common P2P networks include the following:
- BitTorrent
- Direct Connect
- eDonkey
- Freenet

Some P2P applications are based on the Gnutella protocol, where each user shares whole files with other users.

Gnutella-compatible client software allows users to connect to Gnutella services over the internet, and to locate and access resources shared by other Gnutella peers. Many Gnutella client applications are available, including μTorrent, BitComet, DC++, Deluge, and emule.

# Web and Email Protocols

### Hypertext Transfer Protocol and Hypertext Markup Language

When a web address or Uniform Resource Locator (URL) is typed into a web browser, the web browser establishes a connection to the web service.

The web service is running on the server that is using the HTTP protocol.

URLs and Uniform Resource Identifiers (URIs) are the names most people associate with web addresses.

#### Step 1

The browser interprets the three parts of the URL:
- http (the protocol or scheme)
- www.cisco.com (the server name)
- index.html (the specific filename requested)

#### Step 2

The browser then checks with a name server to convert www.cisco.com into a numeric IP address, which it uses to connect to the server. The client initiates an HTTP request to a server by sending a GET request to the server and asks for the index.html file.

#### Step 3

In response to the request, the server sends the HTML code for this web page to the browser.

#### Step 4

The browser deciphers the HTML code and formats the page for the browser window.

### HTTP and HTTPS

HTTP is a request/response protocol. When a client, typically a web browser, sends a request to a web server, HTTP specifies the message types used for that communication. The three common message types are GET (see figure), POST, and PUT:
- GET - This is a client request for data. A client (web browser) sends the GET message to the web server to request HTML pages.
- POST - This uploads data files to the web server, such as form data.
- PUT - This uploads resources or content to the web server, such as an image.

Although HTTP is remarkably flexible, it is not a secure protocol. The request messages send information to the server in plaintext that can be intercepted and read. The server responses, typically HTML pages, are also unencrypted.

For secure communication across the internet, the HTTP Secure (HTTPS) protocol is used. HTTPS uses authentication and encryption to secure data as it travels between the client and server. HTTPS uses the same client request-server response process as HTTP, but the data stream is encrypted with Transport Layer Security (TLS) or its predecessor Secure Socket Layer (SSL) before being transported across the network.

### Email Protocols

Email is a store-and-forward method of sending, storing, and retrieving electronic messages across a network. 

Email messages are stored in databases on mail servers.

Mail servers communicate with other mail servers to transport messages from one domain to another.

An email client does not communicate directly with another email client when sending email. Instead, both clients rely on the mail server to transport messages.

### SMTP, POP, and IMAP

1. SMTP

SMTP message formats require a message header and a message body. Although the message body can contain any amount of text, the message header must have a properly formatted recipient email address and a sender address.

When a client sends email, the client SMTP process connects with a server SMTP process on well-known port 25. After the connection is made, the client attempts to send the email to the server across the connection. When the server receives the message, it either places the message in a local account, if the recipient is local, or forwards the message to another mail server for delivery.

The destination email server may not be online, or may be busy, when email messages are sent. Therefore, SMTP spools messages to be sent at a later time. Periodically, the server checks the queue for messages and attempts to send them again. If the message is still not delivered after a predetermined expiration time, it is returned to the sender as undeliverable.

2. POP

POP is used by an application to retrieve mail from a mail server. With POP, mail is downloaded from the server to the client and then deleted on the server. This is the default operation of POP.

The server starts the POP service by passively listening on TCP port 110 for client connection requests. When a client wants to make use of the service, it sends a request to establish a TCP connection with the server, as shown in the figure. When the connection is established, the POP server sends a greeting. The client and POP server then exchange commands and responses until the connection is closed or aborted.

With POP, email messages are downloaded to the client and removed from the server, so there is no centralized location where email messages are kept. Because POP does not store messages, it is not recommended for a small business that needs a centralized backup solution.

POP3 is the most commonly used version.

3. IMAP

IMAP is another protocol that describes a method to retrieve email messages. Unlike POP, when the user connects to an IMAP-capable server, copies of the messages are downloaded to the client application, as shown in the figure. The original messages are kept on the server until manually deleted. Users view copies of the messages in their email client software.

Users can create a file hierarchy on the server to organize and store mail. That file structure is duplicated on the email client as well. When a user decides to delete a message, the server synchronizes that action and deletes the message from the server.

# IP Addressing Services

### Domain Name System

On the internet, fully-qualified domain names (FQDNs), such as http://www.cisco.com, are much easier for people to remember than 198.133.219.25, which is the actual numeric address for this server. If Cisco decides to change the numeric address of www.cisco.com, it is transparent to the user because the domain name remains the same. The new address is simply linked to the existing domain name and connectivity is maintained.

The DNS protocol defines an automated service that matches resource names with the required numeric network address. It includes the format for queries, responses, and data. The DNS protocol communications use a single format called a message. This message format is used for all types of client queries and server responses, error messages, and the transfer of resource record information between servers.

- Step 1 - The user types an FQDN into a browser application Address field.
- Step 2 - A DNS query is sent to the designated DNS server for the client computer.
- Step 3 - The DNS server matches the FQDN with its IP address.
- Step 4 - The DNS query response is sent back to the client with the IP address for the FQDN.
- Step 5 - The client computer uses the IP address to make requests of the server.

### DNS Message Format

The DNS server stores different types of resource records that are used to resolve names. These records contain the name, address, and type of record. Some of these record types are as follows:
- A - An end device IPv4 address
- NS - An authoritative name server
- AAAA - An end device IPv6 address (pronounced quad-A)
- MX - A mail exchange record
When a client makes a query, the server DNS process first looks at its own records to resolve the name. If it is unable to resolve the name by using its stored records, it contacts other servers to resolve the name. After a match is found and returned to the original requesting server, the server temporarily stores the numbered address in the event that the same name is requested again.

The DNS cient service on Windows PCs also stores previously resolved names in memory. The ipconfig /displaydns command displays all of the cached DNS entries.

As shown in the table, DNS uses the same message format between servers, consisting of a question, answer, authority, and additional information for all types of client queries and server responses, error messages, and transfer of resource record information.

DNS message sectionDescriptionQuestionThe question for the name serverAnswerResource Records answering the questionAuthorityResource Records pointing toward an authorityAdditionalResource Records holding additional information.

DNS message sections | DNS message sections
---|---
Question | The question for the name server
Answer | Resource Records answering the question
Authority | Resource Records pointing toward an authority
Additional | Resource Records holding additional information

### DNS Hierarchy

The DNS protocol uses a hierarchical system to create a database to provide name resolution, as shown in the figure. DNS uses domain names to form the hierarchy.

The naming structure is broken down into small, manageable zones. Each DNS server maintains a specific database file and is only responsible for managing name-to-IP mappings for that small portion of the entire DNS structure. When a DNS server receives a request for a name translation that is not within its DNS zone, the DNS server forwards the request to another DNS server within the proper zone for translation. DNS is scalable because hostname resolution is spread across multiple servers.

The different top-level domains represent either the type of organization or the country of origin. Examples of top-level domains are the following:
- .com - a business or industry
- .org - a non-profit organization
- .au - Australia
- .co - Colombia

### The nslookup Command

Computer operating systems also have a utility called Nslookup that allows the user to manually query the name servers to resolve a given host name. This utility can also be used to troubleshoot name resolution issues and to verify the current status of the name servers.

```bash
C:\Users> nslookup
Default Server:  dns-sj.cisco.com
Address:  171.70.168.183
> www.cisco.com
Server:  dns-sj.cisco.com
Address:  171.70.168.183
Name:    origin-www.cisco.com
Addresses:  2001:420:1101:1::a
          173.37.145.84
Aliases:  www.cisco.com
> cisco.netacad.net
Server:  dns-sj.cisco.com
Address:  171.70.168.183
Name:    cisco.netacad.net
Address:  72.163.6.223
>
```

### Dynamic Host Configuration Protocol

The Dynamic Host Configuration Protocol (DHCP) for IPv4 service automates the assignment of IPv4 addresses, subnet masks, gateways, and other IPv4 networking parameters.

When a host connects to the network, the DHCP server is contacted, and an address is requested. The DHCP server chooses an address from a configured range of addresses called a pool and assigns (leases) it to the host.

DHCP can allocate IP addresses for a configurable period of time, called a lease period. The lease period is an important DHCP setting, When the lease period expires or the DHCP server gets a DHCPRELEASE message the address is returned to the DHCP pool for reuse. Users can freely move from location to location and easily re-establish network connections through DHCP.

various types of devices can be DHCP servers. The DHCP server in most medium-to-large networks is usually a local, dedicated PC-based server. With home networks, the DHCP server is usually located on the local router that connects the home network to the ISP.

DHCP is used for general purpose hosts, such as end user devices. Static addressing is used for network devices, such as gateway routers, switches, servers, and printers.

DHCP for IPv6 (DHCPv6) provides similar services for IPv6 clients. One important difference is that DHCPv6 does not provide a default gateway address. This can only be obtained dynamically from the Router Advertisement message of the router.

### DHCP Operation

when an IPv4, DHCP-configured device boots up or connects to the network, the client broadcasts a DHCP discover (DHCPDISCOVER) message to identify any available DHCP servers on the network. 

A DHCP server replies with a DHCP offer (DHCPOFFER) message, which offers a lease to the client. The offer message contains the IPv4 address and subnet mask to be assigned, the IPv4 address of the DNS server, and the IPv4 address of the default gateway. The lease offer also includes the duration of the lease.

The client may receive multiple DHCPOFFER messages if there is more than one DHCP server on the local network. Therefore, it must choose between them, and sends a DHCP request (DHCPREQUEST) message that identifies the explicit server and lease offer that the client is accepting. A client may also choose to request an address that it had previously been allocated by the server.

Assuming that the IPv4 address requested by the client, or offered by the server, is still available, the server returns a DHCP acknowledgment (DHCPACK) message that acknowledges to the client that the lease has been finalized. If the offer is no longer valid, then the selected server responds with a DHCP negative acknowledgment (DHCPNAK) message. If a DHCPNAK message is returned, then the selection process must begin again with a new DHCPDISCOVER message being transmitted. After the client has the lease, it must be renewed prior to the lease expiration through another DHCPREQUEST message.

The DHCP server ensures that all IP addresses are unique (the same IP address cannot be assigned to two different network devices simultaneously). Most ISPs use DHCP to allocate addresses to their customers.

DHCPv6 has a set of messages that is similar to those for DHCPv4. The DHCPv6 messages are SOLICIT, ADVERTISE, INFORMATION REQUEST, and REPLY.

# File Sharing Services

### File Transfer Protocol

FTP was developed to allow for data transfers between a client and a server. 

An FTP client is an application which runs on a computer that is being used to push and pull data from an FTP server.

- The client establishes the first connection to the server for control traffic using TCP port 21. The traffic consists of client commands and server replies.
- The client establishes the second connection to the server for the actual data transfer using TCP port 20. This connection is created every time there is data to be transferred.
- The data transfer can happen in either direction. The client can download (pull) data from the server, or the client can upload (push) data to the server.

### Server Message Block

Here are three functions of SMB messages:

Start, authenticate, and terminate sessions.
Control file and printer access.
Allow an application to send or receive messages to or from another device.