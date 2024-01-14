# Binary Number System

### Binary and IPv4 Addresses

- Binary numbering system consists of 1s and 0s, called bits​
- Decimal numbering system consists of digits 0 through 9​
- Hosts, servers, and network equipment using binary addressing to identify each other.​
- Each address is made up of a string of 32 bits, divided into four sections called octets.​
- Each octet contains 8 bits (or 1 byte) separated by a dot.​
- For ease of use by people, this dotted notation is converted to dotted decimal.

### Video - Converting Between Binary and Decimal Numbering Systems

![d](/imgs/decb.png)

![b](/imgs/binb.png)

![btd](/imgs/bitoip.png)

### Binary Positional Notation

Positional notation means that a digit represents different values depending on the “position” the digit occupies in the sequence of numbers.

The decimal positional notation system operates as described in the table.
Radix | 10 | 10 | 10 | 10
--- | --- | --- | --- | ---
Position in Number | 3 | 2 | 1 | 0
Calculate | (10^3) | (10^2) | (10^1) | (10^0)
Position value | 1000 | 100 | 10 | 1

The binary positional notation system operates as shown in the tables below.​
Radix | 2 | 2 | 2 | 2 | 2 | 2 | 2 | 2
--- | --- | --- | --- | --- | --- | --- | --- | ---
Position in Number | 7 | 6 | 5 | 4 | 3 | 2 | 1 | 0
Calculate | (2^7) | (2^6) | (2^5) | (2^4) | (2^3) | (2^2) | (2^1) | (2^0)
Position value | 128 | 64 | 32 | 16 | 8 | 4 | 2 | 1

### IPv4 Addresses

Routers and computers only understand binary, while humans work in decimal. It is important for you to gain a thorough understanding of these two numbering systems and how they are used in networking.

# Hexadecimal Number System

### Hexadecimal and IPv6 Addresses

- To understand IPv6 addresses, you must be able to convert hexadecimal to decimal and vice versa.​
- Hexadecimal is a base sixteen numbering system, using the digits 0 through 9 and letters A to F.​
- It is easier to express a value as a single hexadecimal digit than as four binary bit.​
- Hexadecimal is used to represent IPv6 addresses and MAC addresses.
- IPv6 addresses are 128 bits in length. Every 4 bits is represented by a single hexadecimal digit. That makes the IPv6 address a total of 32 hexadecimal values.​
- The figure shows the preferred method of writing out an IPv6 address, with each X representing four hexadecimal values.​
- Each four hexadecimal character group is referred to as a hextet.

### Decimal to Hexadecimal Conversions

Follow the steps listed to convert decimal numbers to hexadecimal values:​
1. Convert the decimal number to 8-bit binary strings.​
2. Divide the binary strings in groups of four starting from the rightmost position.​
3. Convert each four binary numbers into their equivalent hexadecimal digit.​

For example, 168 converted into hex using the three-step process.
1. 168 in binary is 10101000.​
2. 10101000 in two groups of four binary digits is 1010 and 1000.​
3. 1010 is hex A and 1000 is hex 8, so 168 is A8 in hexadecimal.

### Hexadecimal to Decimal Conversion

Follow the steps listed to convert hexadecimal numbers to decimal values:​
1. Convert the hexadecimal number to 4-bit binary strings.​
2. Create 8-bit binary grouping starting from the rightmost position.​
3. Convert each 8-bit binary grouping into their equivalent decimal digit.​

For example, D2 converted into decimal using the three-step process:​
1. D2 in 4-bit binary strings is 1101 and 0010.​
2. 1101 and 0010 is 11010010 in an 8-bit grouping.​
3. 11010010 in binary is equivalent to 210 in decimal, so D2 is 210 is decimal

