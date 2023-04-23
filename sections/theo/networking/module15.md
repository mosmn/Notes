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