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