# Network Layer Characteristics

### The Network Layer

To accomplish end-to-end communications across network boundaries, network layer protocols perform four basic operations:
- Addressing end devices - End devices must be configured with a unique IP address for identification on the network.
- Encapsulation - The network layer encapsulates the protocol data unit (PDU) from the transport layer into a packet. The encapsulation process adds IP header information, such as the IP address of the source (sending) and destination (receiving) hosts. The encapsulation process is performed by the source of the IP packet.
- Routing - The network layer provides services to direct the packets to a destination host on another network. To travel to other networks, the packet must be processed by a router. The role of the router is to select the best path and direct packets toward the destination host in a process known as routing. A packet may cross many routers before reaching the destination host. Each router a packet crosses to reach the destination host is called a hop.
- De-encapsulation - When the packet arrives at the network layer of the destination host, the host checks the IP header of the packet. If the destination IP address within the header matches its own IP address, the IP header is removed from the packet. After the packet is de-encapsulated by the network layer, the resulting Layer 4 PDU is passed up to the appropriate service at the transport layer. The de-encapsulation process is performed by the destination host of the IP packet.

### IP Encapsulation

IP encapsulates the transport layer (the layer just above the network layer) segment or other data by adding an IP header. 

The IP header is used to deliver the packet to the destination host.

The process of encapsulating data layer by layer enables the services at the different layers to develop and scale without affecting the other layers.

### Characteristics of IP

These are the basic characteristics of IP:
- Connectionless - There is no connection with the destination established before sending data packets.
- Best Effort - IP is inherently unreliable because packet delivery is not guaranteed.
- Media Independent - Operation is independent of the medium (i.e., copper, fiber-optic, or wireless) carrying the data.

### Connectionless

IP is connectionless, meaning that no dedicated end-to-end connection is created by IP before data is sent. 

Connectionless communication is conceptually similar to sending a letter to someone without notifying the recipient in advance.

IP requires no initial exchange of control information to establish an end-to-end connection before packets are forwarded.

### Best Effort

IP also does not require additional fields in the header to maintain an established connection. This process greatly reduces the overhead of IP. 

However, with no pre-established end-to-end connection, senders are unaware whether destination devices are present and functional when sending packets, nor are they aware if the destination receives the packet, or if the destination device is able to access and read the packet.

IP does not guarantee that all sent packets will be received. Other protocols manage the process of tracking packets and ensuring their delivery.

### Media Independent

IP operates independently of the media that carry the data at lower layers of the protocol stack.

The OSI data link layer is responsible for taking an IP packet and preparing it for transmission over the communications medium. This means that the delivery of IP packets is not limited to any particular medium.

There is, however, one major characteristic of the media that the network layer considers: the maximum size of the PDU that each medium can transport. This characteristic is referred to as the maximum transmission unit (MTU).

Part of the control communication between the data link layer and the network layer is the establishment of a maximum size for the packet.

The data link layer passes the MTU value up to the network layer. The network layer then determines how large packets can be.

fragmentation: splitting up an IP packet when forwarding it from one medium to another medium with a smaller MTU.

# IPv4 Packet

### IPv4 Packet Header

The IPv4 packet header is used to ensure that this packet is delivered to its next stop on the way to its destination end device.

### IPv4 Packet Header Fields

Significant fields in the IPv4 header include the following:

- Version - Contains a 4-bit binary value set to 0100 that identifies this as an IPv4 packet.
- Differentiated Services or DiffServ (DS) - Formerly called the type of service (ToS) field, the DS field is an 8-bit field used to determine the priority of each packet. The six most significant bits of the DiffServ field are the differentiated services code point (DSCP) bits and the last two bits are the explicit congestion notification (ECN) bits.
- Time to Live (TTL) – TTL contains an 8-bit binary value that is used to limit the lifetime of a packet. The source device of the IPv4 packet sets the initial TTL value. It is decreased by one each time the packet is processed by a router. If the TTL field decrements to zero, the router discards the packet and sends an Internet Control Message Protocol (ICMP) Time Exceeded message to the source IP address. Because the router decrements the TTL of each packet, the router must also recalculate the Header Checksum.
- Protocol – This field is used to identify the next level protocol. This 8-bit binary value indicates the data payload type that the packet is carrying, which enables the network layer to pass the data to the appropriate upper-layer protocol. Common values include ICMP (1), TCP (6), and UDP (17).
- Header Checksum – This is used to detect corruption in the IPv4 header.
- Source IPv4 Address – This contains a 32-bit binary value that represents the source IPv4 address of the packet. The source IPv4 address is always a unicast address.
- Destination IPv4 Address – This contains a 32-bit binary value that represents the destination IPv4 address of the packet. The destination IPv4 address is a unicast, multicast, or broadcast address.

# IPv6 Packet

### Limitations of IPv4

Three major issues:

- IPv4 address depletion - IPv4 has a limited number of unique public addresses available. Although there are approximately 4 billion IPv4 addresses, the increasing number of new IP-enabled devices, always-on connections, and the potential growth of less-developed regions have increased the need for more addresses.
- Lack of end-to-end connectivity - Network Address Translation (NAT) is a technology commonly implemented within IPv4 networks. NAT provides a way for multiple devices to share a single public IPv4 address. However, because the public IPv4 address is shared, the IPv4 address of an internal network host is hidden. This can be problematic for technologies that require end-to-end connectivity.
- Increased network complexity – While NAT has extended the lifespan of IPv4 it was only meant as a transition mechanism to IPv6. NAT in its various implementation creates additional complexity in the network, creating latency and making troubleshooting more difficult.

### IPv6 Overview

mprovements that IPv6 provides include the following:

- Increased address space - IPv6 addresses are based on 128-bit hierarchical addressing as opposed to IPv4 with 32 bits.
- Improved packet handling - The IPv6 header has been simplified with fewer fields.
- Eliminates the need for NAT - With such a large number of public IPv6 addresses, NAT between a private IPv4 address and a public IPv4 is not needed. This avoids some of the NAT-induced problems experienced by applications that require end-to-end connectivity.

### IPv6 Packet Header

The fields in the IPv6 packet header include the following:

- Version - This field contains a 4-bit binary value set to 0110 that identifies this as an IP version 6 packet.
- Traffic Class - This 8-bit field is equivalent to the IPv4 Differentiated Services (DS) field.
- Flow Label - This 20-bit field suggests that all packets with the same flow label receive the same type of handling by routers.
- Payload Length - This 16-bit field indicates the length of the data portion or payload of the IPv6 packet. This does not include the length of the IPv6 header, which is a fixed 40-byte header.
- Next Header - This 8-bit field is equivalent to the IPv4 Protocol field. It indicates the data payload type that the packet is carrying, enabling the network layer to pass the data to the appropriate upper-layer protocol.
- Hop Limit - This 8-bit field replaces the IPv4 TTL field. This value is decremented by a value of 1 by each router that forwards the packet. When the counter reaches 0, the packet is discarded, and an ICMPv6 Time Exceeded message is forwarded to the sending host,. This indicates that the packet did not reach its destination because the hop limit was exceeded. Unlike IPv4, IPv6 does not include an IPv6 Header Checksum, because this function is performed at both the lower and upper layers. This means the checksum does not need to be recalculated by each router when it decrements the Hop Limit field, which also improves network performance.
- Source IPv6 Address - This 128-bit field identifies the IPv6 address of the sending host.
- Destination IPv6 Address - This 128-bit field identifies the IPv6 address of the receiving host.

Unlike IPv4, routers do not fragment routed IPv6 packets.

# How a Host Routes

### Host Forwarding Decision

The source host must be able to direct the packet to the destination host. To do this, host end devices create their own routing table. This topic discusses how end devices use routing tables.

Another role of the network layer is to direct packets between hosts. A host can send a packet to the following:
- Itself - A host can ping itself by sending a packet to a special IPv4 address of 127.0.0.1 or an IPv6 address ::1, which is referred to as the loopback interface. Pinging the loopback interface tests the TCP/IP protocol stack on the host.
- Local host - This is a destination host that is on the same local network as the sending host. The source and destination hosts share the same network address.
- Remote host - This is a destination host on a remote network. The source and destination hosts do not share the same network address.

The router connected to the local network segment is referred to as the default gateway.

### Default Gateway

On a network, a default gateway is usually a router with these features:
- It has a local IP address in the same address range as other hosts on the local network.
- It can accept data into the local network and forward data out of the local network.
- It routes traffic to other networks.

### A Host Routes to the Default Gateway

In IPv4, the host receives the IPv4 address of the default gateway either dynamically from Dynamic Host Configuration Protocol (DHCP) or configured manually. 

In IPv6, the router advertises the default gateway address or the host can be configured manually.

### Host Routing Tables

Entering the netstat -r command or the equivalent route print command displays three sections related to the current TCP/IP network connections:
- Interface List - Lists the Media Access Control (MAC) address and assigned interface number of every network-capable interface on the host, including Ethernet, Wi-Fi, and Bluetooth adapters.
- IPv4 Route Table - Lists all known IPv4 routes, including direct connections, local network, and local default routes.
- IPv6 Route Table - Lists all known IPv6 routes, including direct connections, local network, and local default routes.

# Introduction to Routing

### Router Packet Forwarding Decision

where to send the packet. If the destination host is on a remote network, the packet is forwarded to the default gateway, which is usually the local router.

When the packet arrives on the router interface:
- The router examines the destination IP address of the packet and searches its routing table to determine where to forward the packet.
- The routing table contains a list of all known network addresses (prefixes) and where to forward the packet.
- These entries are known as route entries or routes.
- The router will forward the packet using the best (longest) matching route entry.

### IP Router Routing Table

The routing table stores three types of route entries:
- Directly-connected networks - These network route entries are active router interfaces. Routers add a directly connected route when an interface is configured with an IP address and is activated. Each router interface is connected to a different network segment. In the figure, the directly-connected networks in the R1 IPv4 routing table would be 192.168.10.0/24 and 209.165.200.224/30.
- Remote networks - These network route entries are connected to other routers. Routers learn about remote networks either by being explicitly configured by an administrator or by exchanging route information using a dynamic routing protocol. In the figure, the remote network in the R1 IPv4 routing table would be 10.1.1.0/24.
- Default route – Like a host, most routers also include a default route entry, a gateway of last resort. The default route is used when there is no better (longer) match in the IP routing table. In the figure, the R1 IPv4 routing table would most likely include a default route to forward all packets to router R2.

A router can learn about remote networks in one of two ways:
- Manually - Remote networks are manually entered into the route table using static routes.
- Dynamically - Remote routes are automatically learned using a dynamic routing protocol.

### Static Routing

Static routes are route entries that are manually configured.

Static routing has the following characteristics:
- A static route must be configured manually.
- The administrator needs to reconfigure a static route if there is a change in the topology and the static route is no longer viable.
- A static route is appropriate for a small network and when there are few or no redundant links.

### Dynamic Routing

A dynamic routing protocol allows the routers to automatically learn about remote networks, including a default route, from other routers.

If there is a change in the network topology, routers share this information using the dynamic routing protocol and automatically update their routing tables.

Dynamic routing protocols include 
- OSPF
- Enhanced Interior Gateway Routing Protocol (EIGRP).

The dynamic routing protocol will automatically do as follows:
- Discover remote networks
- Maintain up-to-date routing information
- Choose the best path to destination networks
- Attempt to find a new best path if the current path is no longer available

### Introduction to an IPv4 Routing Table

The show ip route privileged EXEC mode command is used to view the IPv4 routing table on a Cisco IOS router. The example shows the IPv4 routing table of router R1. At the beginning of each routing table entry is a code that is used to identify the type of route or how the route was learned. Common route sources (codes) include these:

- L - Directly connected local interface IP address
- C – Directly connected network
- S – Static route was manually configured by an administrator
- O - OSPF
- D - EIGRP