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

1. Logical Link Control (LLC) - This IEEE 802.2 sublayer communicates between the networking software at the upper layers and the device hardware at the lower layers. It places information in the frame that identifies which network layer protocol is being used for the frame. 
    - This information allows multiple Layer 3 protocols, such as IPv4 and IPv6, to use the same network interface and media.

2. Media Access Control (MAC) – Implements this sublayer (IEEE 802.3, 802.11, or 802.15) in hardware. It is responsible for data encapsulation and media access control. It provides data link layer addressing and it is integrated with various physical layer technologies.