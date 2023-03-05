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

fragmentation: splitting up an IP packet when forwarding it from one medium to another medium with a smaller MTU