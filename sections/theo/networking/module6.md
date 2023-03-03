Data must have help to move it across different media. The data link layer provides this help.

# Purpose of the Data Link Layer

### The Data Link Layer

- Prepares network data for the physical network
- responsible for network interface card (NIC) to network interface card communications

Data link layer does:
- Enables upper layers to access the media. The upper layer protocol is completely unaware of the type of media that is used to forward the data.
- Accepts data, usually Layer 3 packets (i.e., IPv4 or IPv6), and encapsulates them into Layer 2 frames.
- Controls how data is placed and received on the media.
- Exchanges frames between endpoints over the network media.
- Receives encapsulated data, usually Layer 3 packets, and directs them to the proper upper-layer protocol.
- Performs error detection and rejects any corrupt frame.

Why do we need the data link layer?
- Without the data link layer, network layer protocols such as IP, would have to make provisions for connecting to every type of media that could exist along a delivery path. Additionally, every time a new network technology or medium was developed IP, would have to adapt.

### IEEE 802 LAN/MAN Data Link Sublayers

The IEEE 802 LAN/MAN data link layer consists of the following two sublayers:

1. Logical Link Control (LLC) - This IEEE 802.2 sublayer communicates between the networking software at the upper layers and the device hardware at the lower layers. It places information in the frame that identifies which network layer protocol is being used for the frame. (flow control)
    - This information allows multiple Layer 3 protocols, such as IPv4 and IPv6, to use the same network interface and media.

2. Media Access Control (MAC) – Implements this sublayer (IEEE 802.3, 802.11, or 802.15) in hardware. It is responsible for:
- data encapsulatio
- media access control. 

It provides data link layer addressing and it is integrated with various physical layer technologies.

in short:
- The LLC sublayer takes the network protocol data, which is typically an IPv4 or IPv6 packet, and adds Layer 2 control information to help deliver the packet to the destination node. 
- The MAC sublayer controls the NIC and other hardware that is responsible for sending and receiving data on the wired or wireless LAN/MAN medium.

The MAC sublayer provides data encapsulation:
- Frame delimiting - The framing process provides important delimiters to identify fields within a frame. These delimiting bits provide synchronization between the transmitting and receiving nodes.
- Addressing - Provides source and destination addressing for transporting the Layer 2 frame between devices on the same shared medium.
- Error detection - Includes a trailer used to detect transmission errors.

The MAC sublayer also provides media access control, allowing multiple devices to communicate over a shared (half-duplex) medium. Full-duplex communications do not require access control.

### Providing Access to Media

Serial interface/connection connects two network environments
Ethernet interface connects to the LAN

At each hop along the path, a router performs the following Layer 2 functions:
- Accepts a frame from a medium
- De-encapsulates the frame
- Re-encapsulates the packet into a new frame
- Forwards the new frame appropriate to the medium of that segment of the physical network

As the router processes frames, it will use data link layer services to:
- receive the frame from one mediums
- de-encapsulate it to the Layer 3 PDU (packet)
- re-encapsulate the PDU into a new frame
- and place the frame on the medium of the next link of the network.

# Topologies

### Physical and Logical Topologies

This topic explains the ways in which the data link layer works with different logical network topologies.

There are two types of topologies used when describing LAN and WAN networks:
- Physical topology – Identifies the physical connections and how end devices and intermediary devices (i.e, routers, switches, and wireless access points) are interconnected. The topology may also include specific device location such as room number and location on the equipment rack. Physical topologies are usually point-to-point or star.
- Logical topology - Refers to the way a network transfers frames from one node to the next. This topology identifies virtual connections using device interfaces and Layer 3 IP addressing schemes.

The data link layer "sees" the logical topology of a network when controlling data access to the media. 

It is the logical topology that influences the type of network framing and media access control used.

### WAN Topologies

1. Point-to-point - This is the simplest and most common WAN topology. It consists of a permanent link between two endpoints.
2. Hub and Spoke - This is the simplest and most common WAN topology. It consists of a permanent link between two endpoints.
3. Mesh - This topology provides high availability but requires that every end system is interconnected to every other system. Therefore, the administrative and physical costs can be significant. Each link is essentially a point-to-point link to the other node.

### Point-to-Point WAN Topology

When using a serial communications protocol such as Point-to-Point Protocol (PPP), a node does not have to make any determination about whether an incoming frame is destined for it or another node.

(Note: A point-to-point connection over Ethernet requires the device to determine if the incoming frame is destined for this node.)

The logical data link protocols can be very simple, as all frames on the media can only travel to or from the two nodes.

A source and destination node may be indirectly connected. adding intermediary physical connections may not change the logical topology. The logical point-to-point connection is the same.

### LAN Topologies

Legacy LAN Topologies:
- Bus - All end systems are chained to each other and terminated in some form on each end. Infrastructure devices such as switches are not required to interconnect the end devices. Legacy Ethernet networks were often bus topologies using coax cables because it was inexpensive and easy to set up.
- Ring - End systems are connected to their respective neighbor forming a ring. The ring does not need to be terminated, unlike in the bus topology. Legacy Fiber Distributed Data Interface (FDDI) and Token Ring networks used ring topologies.

### Half and Full Duplex Communication

refers to the direction of data transmission between two devices.

Half-duplex communication:
- Both devices can transmit and receive on the media but cannot do so simultaneously. WLANs and legacy bus topologies with Ethernet hubs use the half-duplex mode. Half-duplex allows only one device to send or receive at a time on the shared medium

Full-duplex communication
- Both devices can simultaneously transmit and receive on the shared media. The data link layer assumes that the media is available for transmission for both nodes at any time. Ethernet switches operate in full-duplex mode by default, but they can operate in half-duplex if connecting to a device such as an Ethernet hub.

### Access Control Methods

Ethernet LANs and WLANs are examples of multiaccess networks. 

A multiaccess network is a network that can have two or more end devices attempting to access the network simultaneously.

Two basic access control methods for shared media:

1. Contention-based access 

In contention-based multiaccess networks, all nodes are operating in half-duplex, competing for the use of the medium. However, only one device can send at a time. Therefore, there is a process if more than one device transmits at the same time. Examples of contention-based access methods include the following:
- Carrier sense multiple access with collision detection (CSMA/CD) used on legacy bus-topology Ethernet LANs
- Carrier sense multiple access with collision avoidance (CSMA/CA) used on Wireless LANs

2. Controlled access

In a controlled-based multiaccess network, each node has its own time to use the medium. These deterministic types of legacy networks are inefficient because a device must wait its turn to access the medium. Examples of multiaccess networks that use controlled access include the following:
- Legacy Token Ring
- Legacy ARCNET

Note: Today, Ethernet networks operate in full-duplex and do not require an access method.

### Contention-Based Access - CSMA/CD

If two devices transmit at the same time, a collision will occur. For legacy Ethernet LANs, both devices will detect the collision on the network. This is the collision detection (CD) portion of CSMA/CD. The NIC compares data transmitted with data received, or by recognizing that the signal amplitude is higher than normal on the media. The data sent by both devices will be corrupted and will need to be resent.

### Contention-Based Access - CSMA/CA

CMSA/CA uses a method similar to CSMA/CD to detect if the media is clear. CMSA/CA uses additional techniques. In wireless environments it may not be possible for a device to detect a collision. CMSA/CA does not detect collisions but attempts to avoid them by waiting before transmitting. Each device that transmits includes the time duration that it needs for the transmission. All other wireless devices receive this information and know how long the medium will be unavailable.

