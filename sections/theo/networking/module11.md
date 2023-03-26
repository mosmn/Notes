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