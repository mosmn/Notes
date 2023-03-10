# Purpose of the Physical Layer

### The Physical Connection

A physical connection can be:
- a wired connection using a cable 
- or a wireless connection using radio waves.

The type of physical connection used depends upon the setup of the network.

These are the components of an access point:

1. The wireless antennas (These are embedded inside the router version shown in the figure above.)
2. Several Ethernet switchports
3. An internet port

- Network interface cards (NICs) connect a device to the network.
    - Ethernet NICs are used for a wired connection
    - wireless local area network (WLAN) NICs are used for wireless

Not all physical connections offer the same level of performance.

### The Physical Layer

- The OSI physical layer provides the means to transport the bits that make up a data link layer frame across the network media
- Accepts a complete frame from the Data Link Layer and encodes it as a series of signals that are transmitted to the local media
- This is the last step in the encapsulation process.
- The next device in the path to the destination receives the bits and re-encapsulates the frame, then decides what to do with it.

# Physical Layer Characteristics

### Physical Layer Standards

Physical Layer Standards address three functional areas:​
- Physical Components​
- Encoding​
- Signaling

### Physical Components

The Physical Components are the hardware devices, media, and other connectors that transmit the signals that represent the bits.​

Hardware components like NICs, interfaces and connectors, cable materials, and cable designs are all specified in standards associated with the physical layer.

### Encoding

Encoding is the process of converting a stream of bits into a predefined "code" that can be transmitted over a physical medium.​ Before it becomes a signal its encoded using predefined code meaning every 4 bits is represented by 5 bits using the 4b/5b table. This is encoding, then after that the coded bits go through signaling process depending on the media.

In the diagram on netcad, the transition from higher to low is 0, and from low to high is 1. This is Manchester encoding.

Codes are groupings of bits used to provide a predictable pattern that can be recognized by both the sender and the receiver.

### Signaling

 The way that bits are represented is called the signaling method.

 The physical layer must generate the electrical, optical, or wireless signals that represent the "1" and "0" on the media.

 The physical layer standards must define what type of signal represents a "1" and what type of signal represents a "0".

 ### Bandwidth

Bandwidth is the capacity at which a medium can carry data.​

Digital bandwidth measures the amount of data that can flow from one place to another in a given amount of time; how many bits can be transmitted in a second.​

Physical media properties, current technologies, and the laws of physics play a role in determining available bandwidth.

### Bandwidth Terminology

Latency​:
- Amount of time, including delays, for data to travel from one given point to another​

Throughput​:
- The measure of the transfer of bits across the media over a given period of time​

Goodput​:
- The measure of usable data transferred over a given period of time​
- Goodput = Throughput - traffic overhead

# Copper Cabling

### Characteristics of Copper Cabling

Data is transmitted on copper cables as electrical pulses.

Networks use copper media because its:
- inexpensive
- easy to install
- has low resistance to electrical current. 

However, copper media is limited by:
1. distance:
    - Signal attenuation: the farther the signal travels, the more it deteriorates.
        - For this reason, all copper media must follow strict distance limitations as specified by the guiding standards.
2. signal interference:
    - Electromagnetic interference (EMI) or Radio Frequency Interference (RFI) signal interference can cause data corruption.
        - EMI can be caused by:
            - electrical motors
            - fluorescent lights
            - power lines
            - other electrical devices
    - Crosstalk is the interference that occurs when signals on one cable interfere with signals on another cable.
        - Crosstalk can be caused by:
            - nearby cables
            - nearby electrical devices
            - nearby fluorescent lights
            - nearby power lines

Mitigation:
- Some kinds of copper cable mitigate EMI and RFI by using metallic shielding and grounding.​
- Some kinds of copper cable mitigate crosstalk by twisting opposing circuit pair wires together.

A detector in the network interface of a destination device must receive a signal that can be successfully decoded to match the signal sent.


### Types of Copper Cabling

- Unshielded Twisted Pair (UTP) cable
- Shielded Twisted Pair (STP) cable
- Coaxial cable

### Unshielded Twisted Pair (UTP) Cable

UTP is the most common networking media.​

Terminated with RJ-45 connectors​

Interconnects hosts with intermediary network devices.

Key Characteristics of UTP​
- The outer jacket protects the copper wires from physical damage.​
- Twisted pairs protect the signal from interference.​
- Color-coded plastic insulation electrically isolates the wires from each other and identifies each pair.

### Shielded Twisted Pair (STP) Cable

Better noise protection than UTP​

More expensive than UTP​

Harder to install than UTP​

Terminated with RJ-45 connectors​

Interconnects hosts with intermediary network devices

Key Characteristics of STP​
- The outer jacket protects the copper wires from physical damage​
- Braided or foil shield provides EMI/RFI protection​
- Foil shield for each pair of wires provides EMI/RFI protection​
- Color-coded plastic insulation electrically isolates the wires from each other and identifies each pair

### Coaxial Cable

Consists of the following:​
- Outer cable jacket to prevent minor physical damage​
- A woven copper braid, or metallic foil, acts as the second wire in the circuit and as a shield for the inner conductor.​
- A layer of flexible plastic insulation​
- A copper conductor is used to transmit the electronic signals.

There are different types of connectors used with coax cable. e.g. BNC, N-Type, F-Type, etc.

Commonly used in the following situations:​
- Wireless installations - attach antennas to wireless devices​
- Cable internet installations - customer premises wiring

# UTP Cabling

### Properties of UTP Cabling

UTP has four pairs of color-coded copper wires twisted together and encased in a flexible plastic sheath.No shielding is used.

UTP relies on the following properties to limit crosstalk:​
- Cancellation - Each wire in a pair of wires uses opposite polarity. One wire is negative, the other wire is positive. They are twisted together and the magnetic fields effectively cancel each other and outside EMI/RFI.​
- Variation in twists per foot in each wire - Each wire is twisted a different amount, which helps prevent crosstalk amongst the wires in the cable.​


### UTP Cabling Standards and Connectors

Standards for UTP are established by the TIA/EIA. TIA/EIA-568 standardizes elements like:​
- Cable Types​
- Cable Lengths​
- Connectors​
- Cable Termination​
- Testing Methods

Electrical standards for copper cabling are established by the IEEE, which rates cable according to its performance. Examples include:​
- Category 3​
- Category 5 and 5e​
- Category 6​

### Straight-through and Crossover UTP Cables 

Cable type | Standard | Application
---|---|---
Ethernet Straight-through | Both ends T568A or T568B | Host to Network Device
Ethernet Crossover * | One end T568A, other end T568B | Host-to-Host, Switch-to-Switch, Router-to-Router
| Considered Legacy due to most NICs using Auto-MDIX to sense cable type and complete connection |
Rollover | Cisco Proprietary | Host serial port to Router or Switch Console Port, using an adapter

# Fiber-Optic Cabling

### Properties of Fiber-Optic Cabling

Not as common as UTP because of the expense involved​

Ideal for some networking scenarios​

Transmits data over longer distances at higher bandwidth than any other networking media​

Less susceptible to attenuation, and completely immune to EMI/RFI​

Made of flexible, extremely thin strands of very pure glass​

Uses a laser or LED to encode bits as pulses of light​

The fiber-optic cable acts as a wave guide to transmit light between the two ends with minimal signal loss

### Types of Fiber Media

Single-mode fiber​ | Multi-mode fiber
---|---
Very small core​ | Larger core
Uses expensive lasers​ | Uses less expensive LEDs
Long-distance applications​ | LEDs transmit at different angles
Up to 10 Gbps over 550 meters​ | Up to 10 Gbps over 550 meters

Dispersion refers to the spreading out of a light pulse over time. Increased dispersion means increased loss of signal strength. MMF has greater dispersion than SMF, with a the maximum cable distance for MMF is 550 meters.

### Fiber-Optic Cabling Usage

Fiber-optic cabling is now being used in four types of industry:​

- Enterprise Networks - Used for backbone cabling applications and interconnecting infrastructure devices​
- Fiber-to-the-Home (FTTH) - Used to provide always-on broadband services to homes and small businesses​
- Long-Haul Networks - Used by service providers to connect countries and cities​
- Submarine Cable Networks - Used to provide reliable high-speed, high-capacity solutions capable of surviving in harsh undersea environments at up to transoceanic distances. 

### Fiber-Optic Connectors

- Straight-Tip (ST) Connectors​
- Lucent Connector (LC) Simplex Connectors​
- Subscriber Connector (SC) Connectors​
- Duplex Multimode LC Connectors​

### Fiber Patch Cords

in slides

A yellow jacket is for single-mode fiber cables and orange (or aqua) for multimode fiber cables.


### Fiber versus Copper

Optical fiber is primarily used as backbone cabling for high-traffic, point-to-point​ connections between data distribution facilities and for the interconnection of buildings​ in multi-building campuses.

Implementation Issues​ | UTP Cabling | Fiber-Optic Cabling
---|---|---
Bandwidth supported | 10 Mb/s - 10 Gb/s | 10 Mb/s - 100 Gb/s
Distance | Relatively short (1 - 100 meters) | Relatively long ( 1 - 100,000 meters)
Immunity to EMI and RFI | Low | High (Completely immune)
Immunity to electrical hazards | Low | High (Completely immune)
Media and connector costs | Lowest | Highest
Installation skills required | Lowest | Highest
Safety precautions | Lowest | Highest

# Wireless Media

### Properties of Wireless Media

It carries electromagnetic signals representing binary digits using radio or microwave frequencies. This provides the greatest mobility option. Wireless connection numbers continue to increase.​


Some of the limitations of wireless:​
- Coverage area - Effective coverage can be significantly impacted by the physical characteristics of the deployment location.​
- Interference - Wireless is susceptible to interference and can be disrupted by many common devices.​
- Security - Wireless communication coverage requires no access to a physical strand of media, so anyone can gain access to the transmission.​
- Shared medium - WLANs operate in half-duplex, which means only one device can send or receive at a time. Many users accessing the WLAN simultaneously results in reduced bandwidth for each user.

### Types of Wireless Media

The IEEE and telecommunications industry standards for wireless data communications​ cover both the data link and physical layers. In each of these standards, physical layer​ specifications dictate:​
- Data to radio signal encoding methods​
- Frequency and power of transmission​
- Signal reception and decoding requirements​
- Antenna design and construction

### Wireless LAN

In general, a Wireless LAN (WLAN) requires the following devices:​
- Wireless Access Point (AP) - Concentrate wireless signals from users and connect to the existing copper-based network infrastructure​
- Wireless NIC Adapters - Provide wireless communications capability to network hosts​

There are a number of WLAN standards. When purchasing WLAN equipment, ensure compatibility, and interoperability.​

Network Administrators must develop and apply stringent security policies and processes to protect WLANs from unauthorized access and damage.