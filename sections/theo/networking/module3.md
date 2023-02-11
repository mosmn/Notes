Protocols are sets of agreed upon rules that have been created by standards organizations.
Models give you a way to visualize the rules and their place in your network.

# The Rules

### Video - Devices in a Bubble

- The only thing a device(pc, phone, etc...) knows is its own addressing information.
- How does a device know its ip and what network it belongs to?
  How does it know if the destination device it nedds to send info to is on the same network or not?
  If the destination device is on a different network, how does it know how to get there?
  How does a source device know if the info sent was received?
  How to know if it needs to resend the info?
    - The answer to all of these questions is Protocols. the rules that govern how devices communicate with each other.
- TCP is the protocol that ensures Reliability.

### Communications Fundamentals

Elements of a communication method:
- Message source(sender) - the device that is sending the message to the destination device.
- Message destination(receiver) - the device that is receiving the message from the source device and interpreting it.
- Channel - the medium that the message is sent over.

### Communication Protocols

- All communications are governed by protocols.
- Protocols are the rules that communications will follow.
- These rules vary depending on the protocol.

### Rule Establishment

Before comunication some rules need to be established.

To successfully communicate, Protocols must account for the following:
- An identified sender and receiver
- Common language and grammar(format)
- Speed and timing of delivery
- Confirmation of acknowledgement requirements

### Network Protocol Requirements

Common computer protocols include the following requirements:

- Message encoding
- Message formatting and encapsulation
- Message size
- Message timing
- Message delivery options

### Message Encoding

Its the process the process od converting information into another acceptable format for transmission. decoding reverses this process to interpret the information.

### Message Formatting and Encapsulation

Message formats depend on the type of message and the channel that is being used to send the message.

The process of placing one message format (the letter) inside another message format (the envelope) is called encapsulation. De-encapsulation occurs when the process is reversed by the recipient and the letter is removed from the envelope.

### Message Size

- Messages sent across the network are converted to bits. not sent all at once, but in packets. The size of the packets is determined by the protocol.
- The bits are then encoded into a pattern of light, sound, or electrical impulses depending on the channel used to send the message.
- The destination device receives the message and decodes it back to interptet the message.

### Message Timing

- Flow control - the process of managing the rate of data transmission to prevent the sender from overwhelming the receiver.
- Response timeout - hosts on the network use network protocols that specify how long to wait for responses and what action to take if no response is received.
- Acess method - determins when someone can send a message. It is used to prevent collisions on a shared medium. So it checks if the medium is available before sending a message.

### Message Delivery Options

May be one of the following methods:
- Unicast - a message is sent to a single device. one to one.
- Multicast - a message is sent to multiple devices. one to many(not all).
- Broadcast - a message is sent to all devices on the network. one to all. (used in IPv4 but not an option in IPv6)

# Protocols

### Network Protocol Overview
