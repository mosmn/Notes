# IPv4 Address Structures

### Network and Host Portions

An IPv4 address is a 32-bit hierarchical address that is made up of a network portion and a host portion. example 192.168.10.10:

Network portion | Host portion
--- | ---
192 . 168 . 10 .| 10
11000000 . 10101000 . 00001010 .| 00001010

The bits within the network portion of the address must be identical for all devices that reside in the same network.

The bits within the host portion of the address must be unique to identify a specific host within a network.

The role of the subnet mask is to help hosts know which bits are part of the network portion and which bits are part of the host portion.

### The Subnet Mask

assigning an IPv4 address to a host requires the following:
- IPv4 address - This is the unique IPv4 address of the host.
- Subnet mask- This is used to identify the network/host portion of the IPv4 address.

When an IPv4 address is assigned to a device, the subnet mask is used to determine the network address of the device. The network address represents all the devices on the same network.

To identify the network and host portions of an IPv4 address, the subnet mask is compared to the IPv4 address bit for bit, from left to right as shown in the figure.

Network portion | Host portion
--- | ---
192 . 168 . 10 .| 10
11000000 . 10101000 . 00001010 .| 00001010
255 . 255 . 255 .| 0
11111111 . 11111111 . 11111111 .| 00000000

Note that the subnet mask does not actually contain the network or host portion of an IPv4 address, it just tells the computer where to look for the part of the IPv4 address that is the network portion and which part is the host portion.

The actual process used to identify the network portion and host portion is called __ANDing.__

### The Prefix Length

Prefix length is a method for identifying a subnet mask.

The prefix length is the number of bits set to 1 in the subnet mask. It is written in “slash notation”, which is noted by a forward slash (/) followed by the number of bits set to 1. Therefore, count the number of bits in the subnet mask and prepend it with a slash.

Comparing the Subnet Mask and Prefix Length
Subnet Mask | 32-bit Address | Prefix Length
--- | --- | ---
255.0.0.0 | 11111111.00000000.00000000.00000000 | /8
255.255.0.0 | 11111111.11111111.00000000.00000000 | /16
255.255.255.0 | 11111111.11111111.11111111.00000000 | /24
255.255.255.128	| 11111111.11111111.11111111.10000000 | /25
255.255.255.192	| 11111111.11111111.11111111.11000000 | /26
255.255.255.224 | 11111111.11111111.11111111.11100000 | /27
255.255.255.240 | 11111111.11111111.11111111.11110000 | /28
255.255.255.248 | 11111111.11111111.11111111.11111000 | /29
255.255.255.252 | 11111111.11111111.11111111.11111100 | /30

When representing an IPv4 address using a prefix length, the IPv4 address is written followed by the prefix length with no spaces. For example, 192.168.10.10 255.255.255.0 would be written as 192.168.10.10/24. Using various types of prefix lengths will be discussed later. For now, the focus will be on the /24 (i.e. 255.255.255.0) prefix

### Determining the Network: Logical AND

A logical AND is one of three Boolean operations used in Boolean or digital logic. The other two are OR and NOT. 

The AND operation is used in determining the network address.

Logical AND is the comparison of two bits that produce the results shown below:
- 1 AND 1 = 1
- 1 AND 0 = 0
- 0 AND 1 = 0
- 0 AND 0 = 0
In digital logic, 1 represents True and 0 represents False. When using an AND operation, both input values must be True (1) for the result to be True (1).

To identify the network address of an IPv4 host, the IPv4 address is logically ANDed, bit by bit, with the subnet mask. __ANDing between the address and the subnet mask yields the network address.__

To illustrate how AND is used to discover a network address, consider a host with IPv4 address 192.168.10.10 and subnet mask of 255.255.255.0, as shown in the figure:
- IPv4 host address (192.168.10.10) - The IPv4 address of the host in dotted decimal and binary formats.
- Subnet mask (255.255.255.0) - The subnet mask of the host in dotted decimal and binary formats.
- Network address (192.168.10.0) - The logical AND operation between the IPv4 address and subnet mask results in an IPv4 network address shown in dotted decimal and binary formats.

![IPv4 Address Structures](/imgs/ipv41.png)

A host determines its network address by performing an AND operation between its IPv4 address and its subnet mask.

### Network, Host, and Broadcast Addresses

Within each network are three types of IP addresses:
1. Network address
2. Host addresses
3. Broadcast address

#### Network address

A network address is an address that represents a specific network. A device belongs to this network if it meets three criteria:
- It has the same subnet mask as the network address.
- It has the same network bits as the network address, as indicated by the subnet mask.
- It is located on the same broadcast domain as other hosts with the same network address.

As shown in the table, the network address has all 0 bits in the host portion, as determined by the subnet mask. In this example, the network address is 192.168.10.0/24. A network address cannot be assigned to a device.

Network, Host, and Broadcast Addresses

![Network, Host, and Broadcast Addresses](/imgs/ipv42.png)

#### Host addresses

Host addresses are addresses that can be assigned to a device such as a host computer, laptop, smart phone, web camera, printer, router, etc. The host portion of the address is the bits indicated by 0 bits in the subnet mask. 

Host addresses can have any combination of bits in the host portion except for all 0 bits (this would be a network address) or all 1 bits (this would be a broadcast address).

Notice that in the table, there is a first and last host address:
- First host address - This first host within a network has all 0 bits with the last (right-most) bit as a 1 bit. In this example it is 192.168.10.1/24.
- Last host address - This last host within a network has all 1 bits with the last (right-most) bit as a 0 bit. In this example it is 192.168.10.254/24.
Any addresses between and including, 192.168.10.1/24 through 192.168.10.254/24 can be assigned to a device on the network.

#### Broadcast address

A broadcast address is an address that is used when it is required to reach all devices on the IPv4 network. 

As shown in the table, the network broadcast address has all 1 bits in the host portion, as determined by the subnet mask. In this example, the network address is 192.168.10.255/24. 

A broadcast address cannot be assigned to a device.

# IPv4 Unicast, Broadcast, and Multicast

### Unicast

Unicast transmission refers to one device sending a message to one other device in one-to-one communications.

A unicast packet has a destination IP address that is a unicast address which goes to a single recipient. 

A source IP address can only be a unicast address, because the packet can only originate from a single source(common sense right?). This is regardless of whether the destination IP address is a unicast, broadcast or multicast.

### Broadcast

Broadcast transmission refers to a device sending a message to all the devices on a network in one-to-all communications.

A broadcast packet has a destination IP address with all ones (1s) in the host portion, or 32 one (1) bits.

Note: IPv4 uses broadcast packets. However, there are no broadcast packets with IPv6.

A broadcast packet must be processed by all devices in the same broadcast domain. A broadcast domain identifies all hosts on the same network segment. A broadcast may be directed or limited. A directed broadcast is sent to all hosts on a specific network. For example, a host on the 172.16.4.0/24 network sends a packet to 172.16.4.255. A limited broadcast is sent to 255.255.255.255. By default, routers do not forward broadcasts.

#### IP limited broadcasts

Broadcast traffic should be limited so that it does not adversely affect the performance of the network or devices.

Because routers separate broadcast domains, subdividing networks can improve network performance by eliminating excessive broadcast traffic.

#### IP directed broadcasts

Is a sperate/unique broadcast IPv4 address for each network.

This address uses the highest address in the network, which is the address where all the host bits are 1s.

For example, the directed broadcast address for 192.168.1.0/24 is 192.168.1.255. This address allows communication to all the hosts in that network. 

To send data to all the hosts in a network, a host can send a single packet that is addressed to the broadcast address of the network.

A device that is not directly connected to the destination network forwards an IP directed broadcast in the same way it would forward unicast IP packets destined to a host on that network. When a directed broadcast packet reaches a router that is directly connected to the destination network, that packet is broadcast on the destination network

Note: Because of security concerns and prior abuse from malicious users, directed broadcasts are turned off by default starting with Cisco IOS Release 12.0 with the global configuration command no `ip directed-broadcasts`.

### Multicast

Multicast transmission reduces traffic by allowing a host to send a single packet to a selected set of hosts that subscribe to a multicast group.

A multicast packet is a packet with a destination IP address that is a multicast address. 

IPv4 has reserved the 224.0.0.0 to 239.255.255.255 addresses as a multicast range.

Hosts that receive particular multicast packets are called multicast clients. The multicast clients use services requested by a client program to subscribe to the multicast group.

Each multicast group is represented by a single IPv4 multicast destination address. When an IPv4 host subscribes to a multicast group, the host processes packets addressed to this multicast address, and packets addressed to its uniquely allocated unicast address.

Routing protocols such as OSPF use multicast transmissions. For example, routers enabled with OSPF communicate with each other using the reserved OSPF multicast address 224.0.0.5. Only devices enabled with OSPF will process these packets with 224.0.0.5 as the destination IPv4 address. All other devices will ignore these packets.

# Types of IPv4 Addresses

### Public and Private IPv4 Addresses

Public IPv4 addresses are addresses which are globally routed between internet service provider (ISP) routers.

Private IPv4 addresses are blocks of addresses that are used by most organizations to assign IPv4 addresses to internal hosts, cannot be used on the internet.

private IPv4 addresses were introduced because of the depletion of IPv4 address space

Private IPv4 addresses are not unique and can be used internally within any network.

Note: The long-term solution to IPv4 address depletion was IPv6.

The Private Address Blocks
Network Address and Prefix | RFC 1918 Private Address Range
---|---
10.0.0.0/8 | 10.0.0.0 - 10.255.255.255
172.16.0.0/12 | 172.16.0.0 - 172.31.255.255
192.168.0.0/16 | 192.168.0.0 - 192.168.255.255

### Routing to the Internet

Most internal networks, from large enterprises to home networks, use private IPv4 addresses for addressing all internal devices (intranet) including hosts and routers. However, private addresses are not globally routable.

Packets with a private address must be filtered (discarded) or translated to a public address before forwarding the packet to an ISP.

Before the ISP can forward this packet, it must translate the source IPv4 address, which is a private address, to a public IPv4 address using Network Address Translation (NAT). 

NAT is used to translate between private IPv4 and public IPv4 addresses. This is usually done on the router that connects the internal network to the ISP network. Private IPv4 addresses in the organization’s intranet will be translated to public IPv4 addresses before routing to the internet.

Organizations that have resources available to the internet, such as a web server, will also have devices that have public IPv4 addresses. this part of the network is known as the DMZ (demilitarized zone)

### Special Use IPv4 Addresses

There are certain addresses, such as the network address and broadcast address, that cannot be assigned to hosts. 

There are also special addresses that can be assigned to hosts, but with restrictions on how those hosts can interact within the network.

#### Loopback addresses

Loopback addresses (127.0.0.0 /8 or 127.0.0.1 to 127.255.255.254) are more commonly identified as only 127.0.0.1, these are special addresses used by a host to direct traffic to itself. 

For example, it can be used on a host to test if the TCP/IP configuration is operational, as shown in the figure. Notice how the 127.0.0.1 loopback address replies to the ping command. Also note how any address within this block will loop back to the local host, which is shown with the second ping in the figure.

Pinging the Loopback Interface
```
C:\Users\NetAcad> ping 127.0.0.1
Pinging 127.0.0.1 with 32 bytes of data:
Reply from 127.0.0.1: bytes=32 time<1ms TTL=128
Reply from 127.0.0.1: bytes=32 time<1ms TTL=128
Reply from 127.0.0.1: bytes=32 time<1ms TTL=128
Reply from 127.0.0.1: bytes=32 time<1ms TTL=128
Ping statistics for 127.0.0.1:
    Packets: Sent = 4, Received = 4, Lost = 0 (0% loss),
Approximate round trip times in milli-seconds:
    Minimum = 0ms, Maximum = 0ms, Average = 0ms
C:\Users\NetAcad> ping 127.1.1.1
Pinging 127.1.1.1 with 32 bytes of data:
Reply from 127.1.1.1: bytes=32 time<1ms TTL=128
Reply from 127.1.1.1: bytes=32 time<1ms TTL=128
Reply from 127.1.1.1: bytes=32 time<1ms TTL=128
Reply from 127.1.1.1: bytes=32 time<1ms TTL=128
Ping statistics for 127.1.1.1:
    Packets: Sent = 4, Received = 4, Lost = 0 (0% loss),
Approximate round trip times in milli-seconds:
    Minimum = 0ms, Maximum = 0ms, Average = 0ms
C:\Users\NetAcad>
```

#### Link-local addresses

Link-local addresses (169.254.0.0 /16 or 169.254.0.1 to 169.254.255.254) are more commonly known as the Automatic Private IP Addressing (APIPA) addresses or self-assigned addresses. They are used by a Windows DHCP client to self-configure in the event that there are no DHCP servers available. 

Link-local addresses can be used in a peer-to-peer connection but are not commonly used for this purpose.

### Legacy Classful Addressing

In 1981, IPv4 addresses were assigned using classful addressing as defined in [RFC 790](https://tools.ietf.org/html/rfc790), Assigned Numbers. Customers were allocated a network address based on one of three classes, A, B, or C. The RFC divided the unicast ranges into specific classes as follows:
- Class A (0.0.0.0/8 to 127.0.0.0/8) - Designed to support extremely large networks with more than 16 million host addresses. Class A used a fixed /8 prefix with the first octet to indicate the network address and the remaining three octets for host addresses (more than 16 million host addresses per network).
- Class B (128.0.0.0 /16 - 191.255.0.0 /16) - Designed to support the needs of moderate to large size networks with up to approximately 65,000 host addresses. Class B used a fixed /16 prefix with the two high-order octets to indicate the network address and the remaining two octets for host addresses (more than 65,000 host addresses per network).
- Class C (192.0.0.0 /24 - 223.255.255.0 /24) - Designed to support small networks with a maximum of 254 hosts. Class C used a fixed /24 prefix with the first three octets to indicate the network and the remaining octet for the host addresses (only 254 host addresses per network).
Note: There is also a Class D multicast block consisting of 224.0.0.0 to 239.0.0.0 and a Class E experimental address block consisting of 240.0.0.0 - 255.0.0.0.

In the mid-1990s, with the introduction of the World Wide Web (WWW), classful addressing was deprecated to more efficiently allocate the limited IPv4 address space. Classful address allocation was replaced with classless addressing, which is used today. Classless addressing ignores the rules of classes (A, B, C). Public IPv4 network addresses (network addresses and subnet masks) are allocated based on the number of addresses that can be justified.

### Assignment of IP Addresses

Public IPv4 addresses are addresses which are globally routed over the internet. Public IPv4 addresses must be unique.

Both IPv4 and IPv6 addresses are managed by the Internet Assigned Numbers Authority (IANA). The IANA manages and allocates blocks of IP addresses to the Regional Internet Registries (RIRs). The five RIRs are:
- AfriNIC (African Network Information Centre) - Africa Region
- APNIC (Asia Pacific Network Information Centre) - Asia/Pacific Region
- ARIN (American Registry for Internet Numbers) - North America Region
- LACNIC (Regional Latin-American and Caribbean IP Address Registry) - Latin America and some Caribbean Islands
- RIPE NCC (Réseaux IP Européens Network Coordination Centre) - Europe, the Middle East, and Central Asia

RIRs are responsible for allocating IP addresses to ISPs who provide IPv4 address blocks to organizations and smaller ISPs. Organizations can also get their addresses directly from an RIR (subject to the policies of that RIR).

# Network Segmentation

### Broadcast Domains and Segmentation

Have you ever received an email that was addressed to every person at your work or school? This was a broadcast email.

often a broadcast is not really pertinent to everyone in the mailing list. Sometimes, only a segment of the population needs to read that information.

In an Ethernet LAN, devices use broadcasts and the Address Resolution Protocol (ARP) to locate other devices.. ARP sends Layer 2 broadcasts to a known IPv4 address on the local network to discover the associated MAC address. Devices on Ethernet LANs also locate other devices using services. A host typically acquires its IPv4 address configuration using the Dynamic Host Configuration Protocol (DHCP) which sends broadcasts on the local network to locate a DHCP server.

Switches propagate broadcasts out all interfaces except the interface on which it was received. For example, if a switch in the figure were to receive a broadcast, it would forward it to the other switches and other users connected in the network.

Routers do not propagate broadcasts. When a router receives a broadcast, it does not forward it out other interfaces.

Therefore, each router interface connects to a broadcast domain and broadcasts are only propagated within that specific broadcast domain.

### Problems with Large Broadcast Domains

A large broadcast domain is a network that connects many hosts. A problem with a large broadcast domain is that these hosts can generate excessive broadcasts and negatively affect the network. Example, LAN 1 connects 400 users that could generate an excess amount of broadcast traffic. This results in slow network operations due to the significant amount of traffic it can cause, and slow device operations because a device must accept and process each broadcast packet.

Solution:
- __Subnetting__: is the process of dividing a network into smaller networks(called Subnets). Subnetting is used to reduce the size of broadcast domains and to increase the number of available hosts on a network.

In the Example, the 400 users in LAN 1 with network address 172.16.0.0 /16 have been divided into two subnets of 200 users each: 172.16.0.0 /24 and 172.16.1.0 /24. Broadcasts are only propagated within the smaller broadcast domains. Therefore, a broadcast in LAN 1 would not propagate to LAN 2.

Notice how the prefix length has changed from a single /16 network to two /24 networks. This is the basis of subnetting: using host bits to create additional subnets.

### Reasons for Segmenting Networks

1. Subnetting reduces overall network traffic and improves network performance. 
2. It also enables an administrator to implement security policies such as which subnets are allowed or not allowed to communicate together. 
3. Another reason is that it reduces the number of devices affected by abnormal broadcast traffic due to misconfigurations, hardware/software problems, or malicious intent.

There are various ways of using subnets to help manage network devices, e.g.:
- by Location
- By group or function
- By Device Type
so on...

# Subnet an IPv4 Network

### Subnet on an Octet Boundary

IPv4 subnets are created by using one or more of the host bits as network bits. 

This is done by extending the subnet mask to borrow some of the bits from the host portion of the address to create additional network bits. The more host bits that are borrowed, the more subnets that can be defined. 

The more bits that are borrowed to increase the number of subnets reduces the number of hosts per subnet.

Networks are most easily subnetted at the octet boundary of /8, /16, and /24. The table identifies these prefix lengths. Notice that using longer prefix lengths decreases the number of hosts per subnet.

Subnet Masks on Octet Boundaries

![Subnet Masks on Octet Boundaries](/imgs/ipv43.png)

### Subnet within an Octet Boundary

The examples shown thus far borrowed host bits from the common /8, /16, and /24 network prefixes. However, subnets can borrow bits from any host bit position to create other masks.

For instance, a /24 network address is commonly subnetted using longer prefix lengths by borrowing bits from the fourth octet. This provides the administrator with additional flexibility when assigning network addresses to a smaller number of end devices.

Subnet a /24 Network

![Subnet a /24 Network](/imgs/ipv44.png)

For each bit borrowed in the fourth octet, the number of subnetworks available is doubled, while reducing the number of host addresses per subnet:
- /25 row - Borrowing 1 bit from the fourth octet creates 2 subnets supporting 126 hosts each.
- /26 row - Borrowing 2 bits creates 4 subnets supporting 62 hosts each.
- /27 row - Borrowing 3 bits creates 8 subnets supporting 30 hosts each.
- /28 row - Borrowing 4 bits creates 16 subnets supporting 14 hosts each.
- /29 row - Borrowing 5 bits creates 32 subnets supporting 6 hosts each.
- /30 row - Borrowing 6 bits creates 64 subnets supporting 2 hosts each.

### Subnet with the Magic Number

its the last binary 1 in the subnet mask. [The magic number](https://contenthub.netacad.com/itn-dl/11.5.4)

# Subnet a Slash 16 and a Slash 8 Prefix

### Create Subnets with a Slash 16 prefix

In a situation requiring a larger number of subnets, an IPv4 network is required that has more hosts bits available to borrow. For example, the network address 172.16.0.0 has a default mask of 255.255.0.0, or /16. This address has 16 bits in the network portion and 16 bits in the host portion. The 16 bits in the host portion are available to borrow for creating subnets. The table highlights all the possible scenarios for subnetting a /16 prefix.

Subnet a /16 Network

![Subnet a /16 Network](/imgs/ipv45.png)

### Create 100 Subnets with a Slash 16 prefix

Consider a large enterprise that requires at least 100 subnets and has chosen the private address 172.16.0.0/16 as its internal network address.

When borrowing bits from a /16 address, start borrowing bits in the third octet, going from left to right. Borrow a single bit at a time until the number of bits necessary to create 100 subnets is reached.

The figure displays the number of subnets that can be created when borrowing bits from the third octet and the fourth octet. Notice there are now up to 14 host bits that can be borrowed.

Number of Subnets Created by Borrowing Bits:

![Number of Subnets Created by Borrowing Bits](/imgs/ipv46.png)

To satisfy the requirement of 100 subnets for the enterprise, 7 bits (i.e., 27 = 128 subnets) would need to be borrowed (for a total of 128 subnets)

Recall that the subnet mask must change to reflect the borrowed bits. In this example, when 7 bits are borrowed, the mask is extended 7 bits into the third octet. In decimal, the mask is represented as 255.255.254.0, or a /23 prefix, because the third octet is 11111110 in binary and the fourth octet is 00000000 in binary.

using the magic number technique, we can find the resulting subnets from 172.16.0.0 /23 up to 172.16.254.0 /23. watch the video for more details [The magic number](https://contenthub.netacad.com/itn-dl/11.5.4)

for a total of 9 bits that were not borrowed. 29 results in 512 total host addresses. The first address is reserved for the network address and the last address is reserved for the broadcast address, so subtracting for these two addresses (29 - 2) equals 510 available host addresses for each /23 subnet.

### Create 1000 Subnets with a Slash 8 prefix

Some organizations, such as small service providers or large enterprises, may need even more subnets. For example, take a small ISP that requires 1000 subnets for its clients. Each client will need plenty of space in the host portion to create its own subnets.

The ISP has a network address 10.0.0.0 255.0.0.0 or 10.0.0.0/8. This means there are 8 bits in the network portion and 24 host bits available to borrow toward subnetting. Therefore, the small ISP will subnet the 10.0.0.0/8 network.

To create subnets, you must borrow bits from the host portion of the IPv4 address of the existing internetwork. Starting from the left to the right with the first available host bit, borrow a single bit at a time until you reach the number of bits necessary to create 1000 subnets. As shown in the figure, you need to borrow 10 bits to create 1024 subnets (210 = 1024). This includes 8 bits in the second octet and 2 additional bits from the third octet.

The graphic shows how to compute the number of subnets created when borrowing bits from the second and third octets of an IPv4 network address. The formula to determine the number of subnets created is 2 to the power of the number of bits borrowed. The graphic shows an address of 10.0.0.0. Underneath, are the letters nnnnnnnn.hhhhhhhh.hhhhhhhh.hhhhhhhh. It starts by borrowing the first h bit in the second octet which results in 2 to the power of 1 = 2 subnets. When the first two h bits in the second octet are borrowed, the formula is 2 to the power of 2 = 4. This continues until the first 10 h bits are borrowed from the second and third octets resulting in 2 to the power of 10 = 1024.

Number of Subnets Created by Borrowing Bits:

![Number of Subnets Created by Borrowing Bits](/imgs/ipv47.png)

This figure displays the network address and the resulting subnet mask, which converts to 255.255.192.0 or 10.0.0.0/18.

Borrowing 10 bits to create the subnets, leaves 14 host bits for each subnet. Subtracting two hosts per subnet (one for the network address and one for the broadcast address) equates to 214 - 2 = 16382 hosts per subnet. This means that each of the 1000 subnets can support up to 16,382 hosts.

# Subnet to Meet Requirements

### Subnet Private versus Public IPv4 Address Space

While it is nice to quickly segment a network into subnets, your organization’s network may use both public and private IPv4 addresses. This affects how you will subnet your network.

a typical enterprise network:
- Intranet - This is the internal part of a company’s network, accessible only within the organization. Devices in the intranet use private IPv4 addresses.
- DMZ - This is part of the company’s network containing resources available to the internet such as a web server. Devices in the DMZ use public IPv4 addresses.

Both the intranet and the DMZ have their own subnetting requirements and challenges.

The intranet uses private IPv4 addressing space. This allows an organization to use any of the private IPv4 network addresses including the 10.0.0.0/8 prefix with 24 host bits and over 16 million hosts.

Using a network address with 24 host bits makes subnetting easier and more flexible. This includes subnetting on an octet boundary using a /16 or /24.

For example, the private IPv4 network address 10.0.0.0/8 can be subnetted using a /16 mask. As shown in the table, this results in 256 subnets, with 65,534 hosts per subnet. If an organization has a need for fewer than 200 subnets, allowing for some growth, this gives each subnet more than enough host addresses.

What about the DMZ?
- Because these devices need to be publicly accessible from the internet, the devices in the DMZ require public IPv4 addresses. The depletion of public IPv4 address space became an issue beginning in the mid-1990s. Since 2011, IANA and four out of five RIRs have run out of IPv4 address space. Although organizations are making the transition to IPv6, the remaining IPv4 address space remains severely limited. This means an organization must maximize its own limited number of public IPv4 addresses. This requires the network administrator to subnet their public address space into subnets with different subnet masks, in order to minimize the number of unused host addresses per subnet. This is known as Variable Subnet Length Masking (VLSM).

### Minimize Unused Host IPv4 Addresses and Maximize Subnets

there are two considerations when planning subnets:
1. the number of host addresses required for each network 
2. and the number of individual subnets needed.

### Example: Efficient IPv4 Subnetting

In this example, corporate headquarters has been allocated a public network address of 172.16.0.0/22 (10 host bits) by its ISP. this will provide 1,022 host addresses.(2^10-2)

Note: 172.16.0.0/22 is part of the IPv4 private address space. We are using this address instead of an actual public IPv4 address.

The topology shown in the figure consists of five sites; a corporate office and four branch sites. Each site requires internet connectivity and therefore, five internet connections. This means that the organization requires 10 subnets from the company’s 172.16.0.0/22 public address. The largest subnet requires 40 addresses.

![i](/imgs/ipv48.png)

Because the largest subnet requires 40 hosts, a minimum of 6 host bits are needed to provide addressing for 40 hosts. This is determined by using this formula: 26 - 2 = 62 hosts.

Using the formula for determining subnets results in 16 subnets: 24 = 16. Because the example internetwork requires 10 subnets, this will meet the requirement and allow for some additional growth.

Therefore, the first 4 host bits can be used to allocate subnets. This means two bits from the 3rd octet and two bits from the 4th octet will be borrowed. When 4 bits are borrowed from the 172.16.0.0/22 network, the new prefix length is /26 with a subnet mask of 255.255.255.192.

# VLSM

### VLSM Basics - Video

1. Subnets dont have to be equal sizes, as long as their address ranges do not overlap
2. when creating subnets it is easier to work from larger to smalller