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

The ARP reply is encapsulated in an Ethernet frame using the following header information:
- Destination MAC address – This is the MAC address of the sender of the ARP request.
- Source MAC address – This is the MAC address of the sender of the ARP reply.
- Type - ARP messages have a type field of 0x806. This informs the receiving NIC that the data portion of the frame needs to be passed to the ARP process.

Only the device that originally sent the ARP request will receive the unicast ARP reply. After the ARP reply is received, the device will add the IPv4 address and the corresponding MAC address to its ARP table. Packets destined for that IPv4 address can now be encapsulated in frames using its corresponding MAC address.

If no device responds to the ARP request, the packet is dropped because a frame cannot be created.

Entries in the ARP table are time stamped. If a device does not receive a frame from a particular device before the timestamp expires, the entry for this device is removed from the ARP table.

Additionally, static map entries can be entered in an ARP table, but this is rarely done. Static ARP table entries do not expire over time and must be manually removed


### ARP Role in Remote Communications

When a host creates a packet for a destination, it compares the destination IPv4 address and its own IPv4 address to determine if the two IPv4 addresses are located on the same Layer 3 network. If the destination host is not on its same network, the source checks its ARP table for an entry with the IPv4 address of the default gateway. If there is not an entry, it uses the ARP process to determine a MAC address of the default gateway.

The process is quite similar to that of a host that is on the same network as the destination host. The only difference is that the source host uses the IPv4 address of the default gateway as the target IPv4 address in the ARP request.
1. router receives the ARP request
2. router checks if the destination IPv4 address matches its own IPv4 address
3. if it does, it sends an ARP reply
4. the source host receives the ARP reply and stores the IPv4 address and the corresponding MAC address in its ARP table

### Removing Entries from an ARP Table

For each device, an ARP cache timer removes ARP entries that have not been used for a specified period of time. The times differ depending on the operating system of the device. 

Commands may also be used to manually remove some or all of the entries in the ARP table. After an entry has been removed, the process for sending an ARP request and receiving an ARP reply must occur again to enter the map in the ARP table.
### ARP Tables on Networking Devices

On a Cisco router, `show ip arp` on a Cisco router will display the ARP table on the router.
``` 
R1# show ip arp
Protocol  Address          Age (min)  Hardware Addr   Type   Interface
Internet  192.168.10.1            -   a0e0.af0d.e140  ARPA   GigabitEthernet0/0/0
Internet  209.165.200.225         -   a0e0.af0d.e141  ARPA   GigabitEthernet0/0/1
Internet  209.165.200.226         1   a03d.6fe1.9d91  ARPA   GigabitEthernet0/0/1
R1#
```

On a Windows 10 PC, the `arp –a` command is used to display the ARP table
```
C:\Users\PC> arp -a
Interface: 192.168.1.124 --- 0x10
  Internet Address      Physical Address      Type
  192.168.1.1           c8-d7-19-cc-a0-86     dynamic
  192.168.1.101         08-3e-0c-f5-f7-77     dynamic
  192.168.1.110         08-3e-0c-f5-f7-56     dynamic
  192.168.1.112         ac-b3-13-4a-bd-d0     dynamic
  192.168.1.117         08-3e-0c-f5-f7-5c     dynamic
  192.168.1.126         24-77-03-45-5d-c4     dynamic
  192.168.1.146         94-57-a5-0c-5b-02     dynamic
  192.168.1.255         ff-ff-ff-ff-ff-ff     static
  224.0.0.22            01-00-5e-00-00-16     static
  224.0.0.251           01-00-5e-00-00-fb     static
  239.255.255.250       01-00-5e-7f-ff-fa     static
  255.255.255.255       ff-ff-ff-ff-ff-ff     static
C:\Users\PC>
```

### ARP Issues - ARP Broadcasts and ARP Spoofing

As a broadcast frame, an ARP request is received and processed by every device on the local network. On a typical business network, these broadcasts would probably have minimal impact on network performance. 

However, if a large number of devices were to be powered up and all start accessing network services at the same time, there could be some reduction in performance for a short period of time. After the devices send out the initial ARP broadcasts and have learned the necessary MAC addresses, any impact on the network will be minimized.

In some cases, the use of ARP can lead to a potential security risk.
- A threat actor can use ARP spoofing to perform an __ARP poisoning__ attack. This is a technique used by a threat actor to reply to an ARP request for an IPv4 address that belongs to another device, such as the default gateway, as shown in the figure. The threat actor sends an ARP reply with its own MAC address. The receiver of the ARP reply will add the wrong MAC address to its ARP table and send these packets to the threat actor.

Enterprise level switches include mitigation techniques known as dynamic ARP inspection (DAI). DAI is beyond the scope of this course.

# IPv6 Neighbor Discoverys

 ND, is what you need to match IPv6 addresses to MAC addresses.

 1. Source host examines its Neighbor Cache to see if it has a matching entry for the destination IPv6 address.
 2. If it does, the source host uses the MAC address in the Neighbor Cache entry to create an IPv6 packet.
 3. If it does not, the source host creates an ICMPv6 Neighbor Solicitation message(this is similar to an ARP request in ipv4) and forwards it the switch.
 4. the switch will flood the ethernet multicast frame out all ports except the one it came in on.
 5. the ethernet NIC on the receiving hosts will receive the frame and examine the destination MAC address.
 6. the ethernet NIC will accept frames whos destination MAC address matches the destination MAC address of the NIC, is boadcast MAC address, or is a multicast MAC address that maps to one of the IPv6 multicast addresses.

 One significant difference between IPv4 ARP request and IPv6 Neighbor Solicitation is that the ARP request is sent directly over ethernet, IPv4 is not involved. IPv6 Neighbor Solicitation uses ICMPv6 which is then encapsulated in an IPv6 header and then encapsulated in an Ethernet frame.

 The IPv6 Neighbor Solicitation message includes the following information:
 - Target IPv6 address - which is the same as target IPv6 address for the packet that the source host is trying to send
 - Destination IPv6 SN Multicast - the target IPv6 address is maped to a special IPv6 solicited-node multicast address. 
 - Source IPv6 address - the source host's IPv6 address
 - Source MAC address - the source host's MAC address
 - Destination MAC Multicast - the IPv6 solicited-node multicast address is mapped to a special ethernet multicast MAC address
 ![ip](/imgs/ip6ns.png)

### IPv6 Neighbor Discovery Messages

ICMPv6 ND uses five ICMPv6 messages to perform these services:
- Neighbor Solicitation messages
- Neighbor Advertisement messages
- Router Solicitation messages
- Router Advertisement messages
- Redirect Message

Neighbor Solicitation and Neighbor Advertisement messages are used for device-to-device messaging such as address resolution (similar to ARP for IPv4). Devices include both host computers and routers.

Router Solicitation and Router Advertisement messages are for messaging between devices and routers. Typically router discovery is used for dynamic address allocation and stateless address autoconfiguration (SLAAC).

### IPv6 Neighbor Discovery - Address Resolution

ICMPv6 Neighbor Solicitation and Neighbor Advertisement messages are used for MAC address resolution. This is similar to ARP Requests and ARP Replies used by ARP for IPv4. 

ICMPv6 Neighbor Solicitation messages are sent using special Ethernet and IPv6 multicast addresses. 
- This allows the Ethernet NIC of the receiving device to determine whether the Neighbor Solicitation message is for itself without having to send it to the operating system for processing (unlike in IPv4 ARP).