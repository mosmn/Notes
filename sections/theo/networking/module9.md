# MAC and IP

### Destination on Same Network

There are two primary addresses assigned to a device on an Ethernet LAN:
- Physical address (the MAC address) – Used for NIC to NIC communications on the same Ethernet network.
- Logical address (the IP address) – Used to send the packet from the source device to the destination device. The destination IP address may be on the same IP network as the source or it may be on a remote network.

### Destination on Remote Network

When the destination IP address (IPv4 or IPv6) is on a remote network, the destination MAC address will be the address of the host default gateway (i.e., the router interface).

Routers examine the destination IPv4 address to determine the best path to forward the IPv4 packet. When the router receives the Ethernet frame:
- it de-encapsulates the Layer 2 information. Using the destination IPv4 address
- it determines the next-hop device
- and then encapsulates the IPv4 packet in a new data link frame for the outgoing interface.

How are the IP addresses of the IP packets in a data flow associated with the MAC addresses on each link along the path to the destination?
- For IPv4 packets, this is done through a process called Address Resolution Protocol (ARP). 
- For IPv6 packets, the process is ICMPv6 Neighbor Discovery (ND).

# ARP

### ARP Overview

ARP, is what you need to map IPv4 addresses to MAC addresses.

ARP is a protocol that a device uses to determine the destination MAC address of a local device when it knows its IPv4 address.

ARP provides two basic functions:
- Resolving IPv4 addresses to MAC addresses
- Maintaining a table of IPv4 to MAC address mappings

### ARP Functions

When a packet is sent to the data link layer to be encapsulated into an Ethernet frame, the device refers to a table in its memory to find the MAC address that is mapped to the IPv4 address. This table is stored temporarily in RAM memory and called the ARP table or the ARP cache.

The sending device will search its ARP table for a destination IPv4 address and a corresponding MAC address.
- If the packet’s destination IPv4 address is on the same network as the source IPv4 address, the device will search the ARP table for the destination IPv4 address.
- If the destination IPv4 address is on a different network than the source IPv4 address, the device will search the ARP table for the IPv4 address of the default gateway.

In both cases, the search is for an IPv4 address and a corresponding MAC address for the device.

If the device locates the IPv4 address, its corresponding MAC address is used as the destination MAC address in the frame. If there is no entry is found, then the device sends an ARP request.

### ARP Request

![ARP Request](/imgs/arpr.png)

An ARP request is sent when a device needs to determine the MAC address that is associated with an IPv4 address, and it does not have an entry for the IPv4 address in its ARP table.

ARP messages are encapsulated directly within an Ethernet frame. There is no IPv4 header. The ARP request is encapsulated in an Ethernet frame using the following header information:
- Destination MAC address – This is a broadcast address FF-FF-FF-FF-FF-FF requiring all Ethernet NICs on the LAN to accept and process the ARP request.
- Source MAC address – This is MAC address of the sender of the ARP request.
- Type - ARP messages have a type field of 0x806. This informs the receiving NIC that the data portion of the frame needs to be passed to the ARP process.

Because ARP requests are broadcasts, they are flooded out all ports by the switch, except the receiving port. All Ethernet NICs on the LAN process broadcasts and must deliver the ARP request to its operating system for processing. Every device must process the ARP request to see if the target IPv4 address matches its own. A router will not forward broadcasts out other interfaces.

Only one device on the LAN will have an IPv4 address that matches the target IPv4 address in the ARP request. All other devices will not reply.

### ARP Reply


### ARP Role in Remote Communications

### Removing Entries from an ARP Table

### ARP Tables on Networking Devices

### ARP Issues - ARP Broadcasts and ARP Spoofing