# Ethernet Frames

### Ethernet Encapsulation

Ethernet is one of two LAN technologies used today, with the other being wireless LANs (WLANs). 

Ethernet uses wired communications, including twisted pair, fiber-optic links, and coaxial cables.

Ethernet operates in the data link layer and the physical layer

Ethernet is defined by data link layer and physical layer protocols.

### MAC Sublayer

We know that the MAC sublayer is responsible for data encapsulation and accessing the media.

Data Encapsulation:

IEEE 802.3 data encapsulation includes the following:
- Ethernet frame - This is the internal structure of the Ethernet frame.
- Ethernet Addressing - The Ethernet frame includes both a source and destination MAC address to deliver the Ethernet frame from Ethernet NIC to Ethernet NIC on the same LAN.
- Ethernet Error detection - The Ethernet frame includes a frame check sequence (FCS) trailer used for error detection.

Accessing the Media: the IEEE 802.3 MAC sublayer includes the specifications for different Ethernet communications standards over various types of media including copper and fiber.

### Ethernet Frame Fields

The minimum Ethernet frame size is 64 bytes and the expected maximum is 1518 bytes. This includes all bytes from the destination MAC address field through the frame check sequence (FCS) field. 

The preamble field is not included when describing the size of the frame.

Any frame less than 64 bytes in length is considered a “collision fragment” or “runt frame” and is __automatically discarded by receiving stations.__ 

Frames with more than 1500 bytes of data are considered “jumbo” or “baby giant frames”.

__If the size of a transmitted frame is less than the minimum, or greater than the maximum, the receiving device drops the frame.__

Ethernet Frame Fields Detail:

Field | Description
---|---
Preamble and Start Frame Delimiter Fields | The Preamble (7 bytes) and Start Frame Delimiter (SFD), also called the Start of Frame (1 byte), fields are used for synchronization between the sending and receiving devices. These first eight bytes of the frame are used to get the attention of the receiving nodes. Essentially, the first few bytes tell the receivers to get ready to receive a new frame.
Destination MAC Address Field | This 6-byte field is the identifier for the intended recipient. As you will recall, this address is used by Layer 2 to assist devices in determining if a frame is addressed to them. The address in the frame is compared to the MAC address in the device. If there is a match, the device accepts the frame. Can be a unicast, multicast or broadcast address.
Source MAC Address Field | This 6-byte field identifies the originating NIC or interface of the frame.
Type / Length | This 2-byte field identifies the upper layer protocol encapsulated in the Ethernet frame. Common values are, in hexadecimal, 0x800 for IPv4, 0x86DD for IPv6 and 0x806 for ARP. Note: You may also see this field referred to as EtherType, Type, or Length.
Data Field | This field (46 - 1500 bytes) contains the encapsulated data from a higher layer, which is a generic Layer 3 PDU, or more commonly, an IPv4 packet. All frames must be at least 64 bytes long. __If a small packet is encapsulated, additional bits called a pad are used to increase the size of the frame to this minimum size.__
Frame Check Sequence Field | The Frame Check Sequence (FCS) field (4 bytes) is used to detect errors in a frame. It uses a cyclic redundancy check (CRC). The sending device includes the results of a CRC in the FCS field of the frame. The receiving device receives the frame and generates a CRC to look for errors. If the calculations match, no error occurred. Calculations that do not match are an indication that the data has changed; therefore, the frame is dropped. A change in the data could be the result of a disruption of the electrical signals that represent the bits.

# Ethernet MAC Address

### MAC Address and Hexadecimal

An Ethernet MAC address consists of a 48-bit binary value.

Hexadecimal is used to identify an Ethernet address because a single hexadecimal digit represents four binary bits. Therefore, a 48-bit Ethernet MAC address can be expressed using only 12 hexadecimal values.

When using hexadecimal, leading zeroes are always displayed to complete the 8-bit representation. For example, in the table, the binary value 0000 1010 is shown in hexadecimal as 0A.

Hexadecimal numbers are often represented by the value preceded by 0x (e.g., 0x73) to distinguish between decimal and hexadecimal values in documentation.

Hexadecimal may also be represented by a subscript 16, or the hex number followed by an H (e.g., 73H).

### Ethernet MAC Address

The MAC address is used to identify the physical source and destination devices (NICs) on the local network segment.

An Ethernet MAC address is a 48-bit address expressed using 12 hexadecimal digits, as shown in the figure. Because a byte equals 8 bits, we can also say that a MAC address is 6 bytes in length.

All MAC addresses must be unique to the Ethernet device or Ethernet interface. To ensure this, all vendors that sell Ethernet devices must register with the IEEE to obtain a unique 6 hexadecimal (i.e., 24-bit or 3-byte) code called the organizationally unique identifier (OUI).

When a vendor assigns a MAC address to a device or Ethernet interface, the vendor must do as follows:
- Use its assigned OUI as the first 6 hexadecimal digits.
- Assign a unique value in the last 6 hexadecimal digits.

Therefore, an Ethernet MAC address consists of a 6 hexadecimal vendor OUI code followed by a 6 hexadecimal vendor-assigned value, as shown in the figure.

### Frame Processing

Sometimes the MAC address is referred to as a burned-in address (BIA) because the address is hard coded into read-only memory (ROM) on the NIC. This means that the address is encoded into the ROM chip permanently.

When the computer boots up, the NIC copies its MAC address from ROM into RAM. When a device is forwarding a message to an Ethernet network, the Ethernet header includes these:
- Source MAC address - This is the MAC address of the source device NIC.
- Destination MAC address - This is the MAC address of the destination device NIC.

When a NIC receives an Ethernet frame, it examines the destination MAC address to see if it matches the physical MAC address that is stored in RAM. If there is no match, the device discards the frame. If there is a match, it passes the frame up the OSI layers, where the de-encapsulation process takes place.

### Unicast MAC Address

A unicast MAC address is the unique address that is used when a frame is sent from a single transmitting device to a single destination device.

The process that a source host uses to determine the destination MAC address associated with an IPv4 address is known as Address Resolution Protocol (ARP). 

The process that a source host uses to determine the destination MAC address associated with an IPv6 address is known as Neighbor Discovery (ND).

### Broadcast MAC Address

An Ethernet broadcast frame is received and processed by every device on the Ethernet LAN. The features of an Ethernet broadcast are as follows:
- It has a destination MAC address of FF-FF-FF-FF-FF-FF in hexadecimal (48 ones in binary).
- It is flooded out all Ethernet switch ports except the incoming port.
- It is not forwarded by a router.

### Multicast MAC Address

An Ethernet multicast frame is received and processed by a group of devices on the Ethernet LAN that belong to the same multicast group. The features of an Ethernet multicast are as follows:

- There is a destination MAC address of 01-00-5E when the encapsulated data is an IPv4 multicast packet and a destination MAC address of 33-33 when the encapsulated data is an IPv6 multicast packet.
- There are other reserved multicast destination MAC addresses for when the encapsulated data is not IP, such as Spanning Tree Protocol (STP) and Link Layer Discovery Protocol (LLDP).
- It is flooded out all Ethernet switch ports except the incoming port, unless the switch is configured for multicast snooping.
- It is not forwarded by a router, unless the router is configured to route multicast packets.

# The MAC Address Table

### Switch Fundamentals

A Layer 2 Ethernet switch uses Layer 2 MAC addresses to make forwarding decisions

It is completely unaware of the data (protocol) being carried in the data portion of the frame

An Ethernet switch examines its MAC address table to make a forwarding decision for each frame

### Switch Learning and Forwarding

The switch dynamically builds the MAC address table by examining the source MAC address of the frames received on a port.  

The switch forwards frames by searching for a match between the destination MAC address in the frame and an entry in the MAC address table.

1. Examine the Source MAC Address

Every frame that enters a switch is checked for new information to learn. It does this by examining the source MAC address of the frame and the port number where the frame entered the switch. If the source MAC address does not exist, it is added to the table along with the incoming port number. If the source MAC address does exist, the switch updates the refresh timer for that entry in the table. By default, most Ethernet switches keep an entry in the table for 5 minutes.

2. Find the Destination MAC Address

If the destination MAC address is a unicast address, the switch will look for a match between the destination MAC address of the frame and an entry in its MAC address table. If the destination MAC address is in the table, it will forward the frame out the specified port. If the destination MAC address is not in the table, the switch will forward the frame out all ports except the incoming port. This is called an unknown unicast.

# Switch Speeds and Forwarding Methods

### Frame Forwarding Methods on Cisco Switches

Store-and-forward switching - This frame forwarding method receives the entire frame and computes the CRC. CRC uses a mathematical formula, based on the number of bits (1s) in the frame, to determine whether the received frame has an error. If the CRC is valid, the switch looks up the destination address, which determines the outgoing interface. Then the frame is forwarded out of the correct port.

Cut-through switching - This frame forwarding method forwards the frame before it is entirely received. At a minimum, the destination address of the frame must be read before the frame can be forwarded.

A big advantage of store-and-forward switching is that it determines if a frame has errors before propagating the frame. 

When an error is detected in a frame, the switch discards the frame. 

Discarding frames with errors reduces the amount of bandwidth consumed by corrupt data. 

Store-and-forward switching is required for quality of service (QoS) analysis on converged networks where frame classification for traffic prioritization is necessary.

### Cut-Through Switching

There are two variants of cut-through switching:

1. Fast-forward switching - Fast-forward switching offers the lowest level of latency. Fast-forward switching immediately forwards a packet after reading the destination address. Because fast-forward switching starts forwarding before the entire packet has been received, there may be times when packets are relayed with errors. This occurs infrequently, and the destination NIC discards the faulty packet upon receipt. In fast-forward mode, latency is measured from the first bit received to the first bit transmitted. Fast-forward switching is the typical cut-through method of switching.
2. Fragment-free switching - In fragment-free switching, the switch stores the first 64 bytes of the frame before forwarding. Fragment-free switching can be viewed as a compromise between store-and-forward switching and fast-forward switching. __The reason fragment-free switching stores only the first 64 bytes of the frame is that most network errors and collisions occur during the first 64 bytes. Fragment-free switching tries to enhance fast-forward switching by performing a small error check on the first 64 bytes of the frame to ensure that a collision has not occurred before forwarding the frame.__ Fragment-free switching is a compromise between the high latency and high integrity of store-and-forward switching, and the low latency and reduced integrity of fast-forward switching.

### Memory Buffering on Switches

Memory Buffering Methods

1. Port-based memory:
- Frames are stored in queues that are linked to specific incoming and outgoing ports.
- A frame is transmitted to the outgoing port only when all the frames ahead in the queue have been successfully transmitted.
- It is possible for a single frame to delay the transmission of all the frames in memory because of a busy destination port.
- This delay occurs even if the other frames could be transmitted to open destination ports.

2. Shared memory:
- Deposits all frames into a common memory buffer shared by all switch ports and the amount of buffer memory required by a port is dynamically allocated.
- The frames in the buffer are dynamically linked to the destination port enabling a packet to be received on one port and then transmitted on another port, without moving it to a different queue.

### Duplex and Speed Settings

There are two types of duplex settings used for communications on an Ethernet network:
- Full-duplex - Both ends of the connection can send and receive simultaneously.
- Half-duplex - Only one end of the connection can send at a time.

 It is critical that the duplex and bandwidth(speed) settings match between the switch port and the connected devices, such as a computer or another switch.

 Autonegotiation: is an optional function found on most Ethernet switches and NICs. It enables two devices to automatically negotiate the best speed and duplex capabilities. Full-duplex is chosen if both devices have the capability along with their highest common bandwidth.

Duplex mismatch: It occurs when one port on the link operates at half-duplex while the other port operates at full-duplex

### Auto-MDIX

A crossover cable is used when connecting like devices, and a straight-through cable is used for connecting unlike devices.

Most switch devices now support the automatic medium-dependent interface crossover (auto-MDIX) feature. When enabled, the switch automatically detects the type of cable attached to the port and configures the interfaces accordingly. Therefore, you can use either a crossover or a straight-through cable for connections to a copper 10/100/1000 port on the switch, regardless of the type of device on the other end of the connection.
