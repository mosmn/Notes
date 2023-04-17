# Transportation of Data

### Role of the Transport Layer

The transport layer is responsible for logical communications between applications running on different hosts.

This may include services such as establishing a temporary session between two hosts and the reliable transmission of information for an application.

The transport layer has no knowledge of the destination host type, the type of media over which the data must travel, the path taken by the data, the congestion on a link, or the size of the network.

The transport layer includes two protocols:
- Transmission Control Protocol (TCP)
- User Datagram Protocol (UDP)

### Transport Layer Responsibilities

1. Tracking Individual Conversations

At the transport layer, each set of data flowing between a source application and a destination application is known as a conversation and is tracked separately. It is the responsibility of the transport layer to maintain and track these multiple conversations.

Most networks have a limitation on the amount of data that can be included in a single packet. Therefore, data must be divided into manageable pieces.(segmentation)

2. Segmenting Data and Reassembling Segments

It is the transport layer responsibility to divide the application data into appropriately sized blocks. Depending on the transport layer protocol used, the transport layer blocks are called either segments or datagrams.

3. Add Header Information

The transport layer protocol also adds header information containing binary data organized into several fields to each block of data. It is the values in these fields that enable various transport layer protocols to perform different functions in managing data communication.

For instance, the header information is used by the receiving host to reassemble the blocks of data into a complete data stream for the receiving application layer program.

The transport layer ensures that even with multiple application running on a device, all applications receive the correct data.

4. Identifying the Applications

The transport layer must be able to separate and manage multiple communications with different transport requirement needs. To pass data streams to the proper applications, the transport layer identifies the target application using an identifier called a port number.

5. Conversation Multiplexing

Sending some types of data (e.g., a streaming video) across a network, as one complete communication stream, can consume all the available bandwidth. This would prevent other communication conversations from occurring at the same time. It would also make error recovery and retransmission of damaged data difficult.

As shown in the figure, the transport layer uses segmentation and multiplexing to enable different communication conversations to be interleaved on the same network.

Error checking can be performed on the data in the segment, to determine if the segment was altered during transmission.

### Transport Layer Protocols

IP is concerned only with the structure, addressing, and routing of packets. IP does not specify how the delivery or transportation of the packets takes place.

Transport layer protocols specify how to transfer messages between hosts, and are responsible for managing reliability requirements of a conversation. 

The transport layer includes the TCP and UDP protocols.

### Transmission Control Protocol (TCP)

TCP is considered a reliable, full-featured transport layer protocol, which ensures that all of the data arrives at the destination. 

TCP includes fields which ensure the delivery of the application data. These fields require additional processing by the sending and receiving hosts.

Note: TCP divides data into segments.

TCP provides reliability and flow control using these basic operations:
- Number and track data segments transmitted to a specific host from a specific application
- Acknowledge received data
- Retransmit any unacknowledged data after a certain amount of time
- Sequence data that might arrive in wrong order
- Send data at an efficient rate that is acceptable by the receiver

In order to maintain the state of a conversation and track the information, TCP must first establish a connection between the sender and the receiver. This is why TCP is known as a __connection-oriented protocol.__

### User Datagram Protocol (UDP)

UDP is a simpler transport layer protocol than TCP.

It does not provide reliability and flow control, which means it requires fewer header fields. 

Because the sender and the receiver UDP processes do not have to manage reliability and flow control, this means UDP datagrams can be processed faster than TCP segments.

UDP provides the basic functions for delivering datagrams between the appropriate applications, with very little overhead and data checking.

UDP is a connectionless protocol. Because UDP does not provide reliability or flow control, it does not require an established connection. Because UDP does not track information sent or received between the client and server, UDP is also known as a __stateless protocol.__

UDP is also known as a __best-effort delivery protocol__ because there is no acknowledgment that the data is received at the destination. With UDP, there are no transport layer processes that inform the sender of a successful delivery.

### The Right Transport Layer Protocol for the Right Application

Some applications can tolerate some data loss during transmission over the network, but delays in transmission are unacceptable. For these applications, UDP is the better choice because it requires less network overhead. 

UDP is preferable for applications such as Voice over IP (VoIP). Acknowledgments and retransmission would slow down delivery and make the voice conversation unacceptable.

UDP is also used by request-and-reply applications where the data is minimal, and retransmission can be done quickly. For example, Domain Name System (DNS) uses UDP for this type of transaction. The client requests IPv4 and IPv6 addresses for a known domain name from a DNS server. If the client does not receive a response in a predetermined amount of time, it simply sends the request again.

For example, if one or two segments of a live video stream fail to arrive, it creates a momentary disruption in the stream. This may appear as distortion in the image or sound, but may not be noticeable to the user. If the destination device had to account for lost data, the stream could be delayed while waiting for retransmissions, therefore causing the image or sound to be greatly degraded. In this case, it is better to render the best media possible with the segments received, and forego reliability.

For other applications it is important that all the data arrives and that it can be processed in its proper sequence. For these types of applications, TCP is used as the transport protocol. For example, applications such as databases, web browsers, and email clients, require that all data that is sent arrives at the destination in its original condition.

Any missing data could corrupt a communication, making it either incomplete or unreadable. For example, it is important when accessing banking information over the web to make sure all the information is sent and received correctly.

Application developers must choose which transport protocol type is appropriate based on the requirements of the applications. Video may be sent over TCP or UDP. Applications that stream stored audio and video typically use TCP. The application uses TCP to perform buffering, bandwidth probing, and congestion control, in order to better control the user experience.

Real-time video and voice usually use UDP, but may also use TCP, or both UDP and TCP. A video conferencing application may use UDP by default, but because many firewalls block UDP, the application can also be sent over TCP.

Applications that stream stored audio and video use TCP. For example, if your network suddenly cannot support the bandwidth needed to watch an on-demand movie, the application pauses the playback. During the pause, you might see a “buffering...” message while TCP works to re-establish the stream. When all the segments are in order and a minimum level of bandwidth is restored, your TCP session resumes, and the movie resumes playing.

The figure summarizes differences between UDP and TCP.

![e](/imgs/tranl1.png)

# TCP Overview

### TCP Features

In addition to supporting the basic functions of data segmentation and reassembly, TCP also provides the following services:
- Establishes a Session - TCP is a connection-oriented protocol that negotiates and establishes a permanent connection (or session) between source and destination devices prior to forwarding any traffic. Through session establishment, the devices negotiate the amount of traffic that can be forwarded at a given time, and the communication data between the two can be closely managed.
- Ensures Reliable Delivery - For many reasons, it is possible for a segment to become corrupted or lost completely, as it is transmitted over the network. TCP ensures that each segment that is sent by the source arrives at the destination.
- Provides Same-Order Delivery - Because networks may provide multiple routes that can have different transmission rates, data can arrive in the wrong order. By numbering and sequencing the segments, TCP ensures segments are reassembled into the proper order.
- Supports Flow Control - Network hosts have limited resources (i.e., memory and processing power). When TCP is aware that these resources are overtaxed, it can request that the sending application reduce the rate of data flow. This is done by TCP regulating the amount of data the source transmits. Flow control can prevent the need for retransmission of the data when the resources of the receiving host are overwhelmed.

### TCP Header

A TCP segment adds 20 bytes (i.e., 160 bits) of overhead when encapsulating the application layer data.

![e](/imgs/tranl2.png)

### TCP Header Fields

TCP Header Field | Description
---|---
Source Port | A 16-bit field used to identify the source application by port number.
Destination Port | A 16-bit field used to identify the destination application by port number.
Sequence Number | A 32-bit field used for data reassembly purposes.
Acknowledgment Number | A 32-bit field used to indicate that data has been received and the next byte expected from the source.
Header Length | A 4-bit field known as ʺdata offsetʺ that indicates the length of the TCP segment header.
Reserved | A 6-bit field that is reserved for future use.
Control bits | A 6-bit field that includes bit codes, or flags, which indicate the purpose and function of the TCP segment.
Window size | A 16-bit field used to indicate the number of bytes that can be accepted at one time.
Checksum | A 16-bit field used for error checking of the segment header and data.
Urgent | A 16-bit field used to indicate if the contained data is urgent.

### Applications that use TCP

TCP is a good example of how the different layers of the TCP/IP protocol suite have specific roles. TCP handles all tasks associated with dividing the data stream into segments, providing reliability, controlling data flow, and reordering segments. TCP frees the application from having to manage any of these tasks.

applications would use the TCP transport layer protocol:
- HTTP
- FTP
- SMTP
- SSH

# UDP Overview

### UDP Features

- Data is reconstructed in the order that it is received.
- Any segments that are lost are not resent.
- There is no session establishment.
- The sending is not informed about resource availability.

### UDP Header

The UDP header is far simpler than the TCP header because it only has four fields and requires 8 bytes (i.e., 64 bits). 

![e](/imgs/tranl3.png)

### UDP Header Fields

UDP Header Field | Description
---|---
Source Port | A 16-bit field used to identify the source application by port number.
Destination Port | A 16-bit field used to identify the destination application by port number.
Length | A 16-bit field that indicates the length of the UDP datagram header.
Checksum | A 16-bit field used for error checking of the datagram header and data.


### Applications that use UDP

There are three types of applications that are best suited for UDP:
- Live video and multimedia applications - These applications can tolerate some data loss, but require little or no delay. Examples include VoIP and live streaming video.
- Simple request and reply applications - Applications with simple transactions where a host sends a request and may or may not receive a reply. Examples include DNS and DHCP.
- Applications that handle reliability themselves - Unidirectional communications where flow control, error detection, acknowledgments, and error recovery is not required, or can be handled by the application. Examples include SNMP and TFTP.

applications that require UDP:
- DHCP
- DNS
- SNMP
- TFTP
- VoIP
- video conferencing

# Port Numbers

### Multiple Separate Communications

The source port number is associated with the originating application on the local host whereas the destination port number is associated with the destination application on the remote host.

For instance, assume a host is initiating a web page request from a web server. When the host initiates the web page request, the source port number is dynamically generated by the host to uniquely identify the conversation. Each request generated by a host will use a different dynamically created source port number. This process allows multiple conversations to occur simultaneously.

In the request, the destination port number is what identifies the type of service being requested of the destination web server.. For example, when a client specifies port 80 in the destination port, the server that receives the message knows that web services are being requested.

A server can offer more than one service simultaneously such as web services on port 80 while it offers File Transfer Protocol (FTP) connection establishment on port 21.

### Socket Pairs

The source and destination ports are placed within the segment. The segments are then encapsulated within an IP packet. The IP packet contains the IP address of the source and destination. The combination of the source IP address and source port number, or the destination IP address and destination port number is known as a socket.

![e](/imgs/tranl4.png)

The socket is used to identify the server and service being requested by the client. A client socket might look like this, with 1099 representing the source port number: 192.168.1.5:1099

The socket on a web server might be 192.168.1.7:80

Together, these two sockets combine to form a socket pair: 192.168.1.5:1099, 192.168.1.7:80

### Port Number Groups

The Internet Assigned Numbers Authority (IANA) is the standards organization responsible for assigning various addressing standards, including the 16-bit port numbers. The 16 bits used to identify the source and destination port numbers provides a range of ports from 0 through 65535.

Port group | Number Range | Description
---|---|---
Well-known Ports | 0 to 1,023 | These port numbers are reserved for common or popular services and applications such as web browsers, email clients, and remote access clients. Defined well-known ports for common server applications enables clients to easily identify the associated service required.
Registered Ports | 1,024 to 49,151 | These port numbers are assigned by IANA to a requesting entity to use with specific processes or applications. These processes are primarily individual applications that a user has chosen to install, rather than common applications that would receive a well-known port number. For example, Cisco has registered port 1812 for its RADIUS server authentication process.
Private and/or Dynamic Ports | 49,152 to 65,535 | These ports are also known as ephemeral ports. The client’s OS usually assign port numbers dynamically when a connection to a service is initiated. The dynamic port is then used to identify the client application during communication.

Well-Known Port Numbers:

Port Number | Protocol | Application
---|---|---
20 | TCP | File Transfer Protocol (FTP) - Data
21 | TCP | File Transfer Protocol (FTP) - Control
22 | TCP | Secure Shell (SSH)
23 | TCP | Telnet
25 | TCP | Simple Mail Transfer Protocol (SMTP)
53 | UDP, TCP | Domain Name System (DNS)
67 | UDP | Dynamic Host Configuration Protocol (DHCP) - Server
68 | UDP | Dynamic Host Configuration Protocol - Client
69 | UDP | Trivial File Transfer Protocol (TFTP)
80 | TCP | Hypertext Transfer Protocol (HTTP)
110 | TCP | Post Office Protocol version 3 (POP3)
143 | TCP | Internet Message Access Protocol (IMAP)
161 | UDP | Simple Network Management Protocol (SNMP)
443 | TCP | Hypertext Transfer Protocol Secure (HTTPS)

Some applications may use both TCP and UDP. For example, DNS uses UDP when clients send requests to a DNS server. However, communication between two DNS servers always uses TCP.

### The netstat Command

Unexplained TCP connections can pose a major security threat. They can indicate that something or someone is connected to the local host. Sometimes it is necessary to know which active TCP connections are open and running on a networked host. Netstat is an important network utility that can be used to verify those connections. As shown below, enter the command netstat to list the protocols in use, the local address and port numbers, the foreign address and port numbers, and the connection state.
```
C:\> netstat

Active Connections

  Proto  Local Address          Foreign Address            State
  TCP    192.168.1.124:3126     192.168.0.2:netbios-ssn    ESTABLISHED
  TCP    192.168.1.124:3158     207.138.126.152:http       ESTABLISHED
  TCP    192.168.1.124:3159     207.138.126.169:http       ESTABLISHED
  TCP    192.168.1.124:3160     207.138.126.169:http       ESTABLISHED
  TCP    192.168.1.124:3161     sc.msn.com:http            ESTABLISHED
  TCP    192.168.1.124:3166     www.cisco.com:http         ESTABLISHED
(output omitted)
C:\>
```
By default, the netstat command will attempt to resolve IP addresses to domain names and port numbers to well-known applications. The -n option can be used to display IP addresses and port numbers in their numerical form.

# TCP Communication Process

### TCP Server Processes

An individual server cannot have two services assigned to the same port number within the same transport layer services. For example, a host running a web server application and a file transfer application cannot have both configured to use the same port, such as TCP port 80.

An active server application assigned to a specific port is considered open, which means that the transport layer accepts, and processes segments addressed to that port. Any incoming client request addressed to the correct socket is accepted, and the data is passed to the server application. There can be many ports open simultaneously on a server, one for each active server application.

### TCP Connection Establishment

In some cultures, when two persons meet, they often greet each other by shaking hands. Both parties understand the act of shaking hands as a signal for a friendly greeting. Connections on the network are similar. In TCP connections, the host client establishes the connection with the server using the three-way handshake process.

- Step 1. SYN(syncrnaization): The initiating client requests a client-to-server communication session with the server.

![e](/imgs/tranl5.png)

- Step 2. ACK(acknowldgment) and SYN: The server acknowledges the client-to-server communication session and requests a server-to-client communication session.

![e](/imgs/tranl6.png)

- Step 3. ACK: The initiating client acknowledges the server-to-client communication session.

![e](/imgs/tranl7.png)

The three-way handshake validates that the destination host is available to communicate. In this example, host A has validated that host B is available.

### Session Termination

To close a connection, the Finish (FIN) control flag must be set in the segment header. 

To end each one-way TCP session, a two-way handshake, consisting of a FIN segment and an Acknowledgment (ACK) segment, is used. 

Therefore, to terminate a single conversation supported by TCP, four exchanges are needed to end both sessions. Either the client or the server can initiate the termination.

- Step 1. FIN: When the client has no more data to send in the stream, it sends a segment with the FIN flag set.

![e](/imgs/tranl8.png)

- Step 2. ACK: The server sends an ACK to acknowledge the receipt of the FIN to terminate the session from client to server.

![e](/imgs/tranl9.png)

- Step 3. FIN: The server sends a FIN to the client to terminate the server-to-client session.

![e](/imgs/tranl10.png)

- Step 4. ACK: The client responds with an ACK to acknowledge the FIN from the server.

![e](/imgs/tranl11.png)


### TCP Three-way Handshake Analysis

TCP is a full-duplex protocol, where each connection represents two one-way communication sessions.

To establish the connection, the hosts perform a three-way handshake. As shown in the figure, control bits in the TCP header indicate the progress and status of the connection.

These are the functions of the three-way handshake:
- It establishes that the destination device is present on the network.
- It verifies that the destination device has an active service and is accepting requests on the destination port number that the initiating client intends to use.
- It informs the destination device that the source client intends to establish a communication session on that port number.

__The connection and session mechanisms enable TCP reliability function.__

The six bits in the Control Bits field of the TCP segment header are also known as flags. A flag is a bit that is set to either on or off.

The six control bits flags are as follows:
- URG - Urgent pointer field significant
- ACK - Acknowledgment flag used in connection establishment and session termination
- PSH - Push function
- RST - Reset the connection when an error or timeout occurs
- SYN - Synchronize sequence numbers used in connection establishment
- FIN - No more data from sender and used in session termination

# Reliability and Flow Control

### TCP Reliability - Guaranteed and Ordered Delivery

TCP can also help maintain the flow of packets so that devices do not become overloaded.​

There may be times when TCP segments do not arrive at their destination or arrive out of order.​

All the data must be received and the data in these segments must be reassembled into the original order.​

Sequence numbers are assigned in the header of each packet to achieve this goal.

### TCP Reliability - Data Loss and Retransmission

No matter how well designed a network is, data loss occasionally occurs.​

TCP provides methods of managing these segment losses. Among these is a mechanism to retransmit segments for unacknowledged data.

Host operating systems today typically employ an optional TCP feature called selective acknowledgment (SACK), negotiated during the three-way handshake. If both hosts support SACK, the receiver can explicitly acknowledge which segments (bytes) were received including any discontinuous segments. The sending host would therefore only need to retransmit the missing data. For example, in the next figure, again using segment numbers for simplicity, host A sends segments 1 through 10 to host B. If all the segments arrive except for segments 3 and 4, host B can acknowledge that it has received segments 1 and 2 (ACK 3), and selectively acknowledge segments 5 through 10 (SACK 5-10). Host A would only need to resend segments 3 and 4.

### TCP Flow Control - Window Size and Acknowledgments

TCP also provides mechanisms for flow control as follows:​
- Flow control is the amount of data that the destination can receive and process reliably.​
- Flow control helps maintain the reliability of TCP transmission by adjusting the rate of data flow between source and destination for a given session.

### TCP Flow Control - Maximum Segment Size (MSS)

Maximum Segment Size (MSS) is the maximum amount of data that the destination device can receive.​

A common MSS is 1,460 bytes when using IPv4.​

A host determines the value of its MSS field by subtracting the IP and TCP headers from the Ethernet maximum transmission unit (MTU), which is 1500 bytes be default. ​

1500 minus 40 (20 bytes for the IPv4 header and 20 bytes for the TCP header) leaves 1460 bytes.​

### TCP Flow Control – Congestion Avoidance

When congestion occurs on a network, it results in packets being discarded by the overloaded router.​

To avoid and control congestion, TCP employs several congestion handling mechanisms, timers, and algorithms.​

# UDP Communication

### UDP Low Overhead versus Reliability

UDP does not establish a connection. UDP provides low overhead data transport because it has a small datagram header and no network management traffic.

### UDP Datagram Reassembly

UDP does not track sequence numbers the way TCP does.​

UDP has no way to reorder the datagrams into their transmission order.​

UDP simply reassembles the data in the order that it was received and forwards it to the application.​

### UDP Server Processes and Requests

UDP-based server applications are assigned well-known or registered port numbers.​

UDP receives a datagram destined for one of these ports, it forwards the application data to the appropriate application based on its port number.

### UDP Client Processes

The UDP client process dynamically selects a port number from the range of port numbers and uses this as the source port for the conversation.​

The destination port is usually the well-known or registered port number assigned to the server process.​

After a client has selected the source and destination ports, the same pair of ports are used in the header of all datagrams in the transaction.​