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