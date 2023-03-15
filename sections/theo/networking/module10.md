# Configure Initial Router Settings

### Basic Router Configuration Steps

1. Configure the device name.
```
Router(config)# hostname hostname
```

2. Secure privileged EXEC mode.
```
Router(config)# enable secret password
```

3. Secure user EXEC mode.
```
Router(config)# line console 0
Router(config-line)# password password
Router(config-line)# login
``` 

4. Secure remote Telnet / SSH access.
```
Router(config-line)# line vty 0 4
Router(config-line)# password password
Router(config-line)# login
Router(config-line)# transport input {ssh | telnet}
```

5. Secure all passwords in the config file.
```
Router(config-line)# exit
Router(config)# service password-encryption
```

6. Provide legal notification.
```
Router(config)# banner motd delimiter message delimiter
```

7. Save the configuration.
```
Router(config)# end
Router# copy running-config startup-config
```

### Basic Router Configuration Example

To configure the device name for R1, use the following commands.
```
Router> enable 
Router# configure terminal 
Enter configuration commands, one per line.
End with CNTL/Z.
Router(config)# hostname R1 
R1(config)#
```

The following commands secure privileged EXEC mode and user EXEC mode, enable Telnet and SSH remote access, and encrypt all plaintext (i.e., user EXEC and VTY line) passwords.
```
R1(config)# enable secret class 
R1(config)#
R1(config)# line console 0 
R1(config-line)# password cisco 
R1(config-line)# login 
R1(config-line)# exit 
R1(config)#
R1(config)# line vty 0 4 
R1(config-line)# password cisco 
R1(config-line)# login 
R1(config-line)# transport input ssh telnet 
R1(config-line)# exit 
R1(config)#
R1(config)# service password-encryption 
R1(config)#
```

# Configure Interfaces

### Configure Router Interfaces

the Cisco ISR 4321 router is equipped with two Gigabit Ethernet interfaces:
- GigabitEthernet 0/0/0 (G0/0/0)
- GigabitEthernet 0/0/1 (G0/0/1)

The task to configure a router interface is very similar to a management SVI on a switch. Specifically, it includes issuing the following commands:
```
Router(config)# interface type-and-number
Router(config-if)# description description-text
Router(config-if)# ip address ipv4-address subnet-mask
Router(config-if)# ipv6 address ipv6-address/prefix-length
Router(config-if)# no shutdown
```
Although the description command is not required to enable an interface, it is good practice to use it. It can be helpful in troubleshooting on production networks by providing information about the type of network connected. For example, if the interface connects to an ISP or service carrier, the description command would be helpful to enter the third-party connection and contact information.

Note: The description-text is limited to 240 characters.

Using the no shutdown command activates the interface and is similar to powering on the interface.

### Configure Router Interfaces Example

To configure the the interfaces on R1, use the following commands.
```
R1> enable
R1# configure terminal
Enter configuration commands, one per line.
End with CNTL/Z.
R1(config)# interface gigabitEthernet 0/0/0
R1(config-if)# description Link to LAN
R1(config-if)# ip address 192.168.10.1 255.255.255.0
R1(config-if)# ipv6 address 2001:db8:acad:10::1/64
R1(config-if)# no shutdown
R1(config-if)# exit
R1(config)#
*Aug  1 01:43:53.435: %LINK-3-UPDOWN: Interface GigabitEthernet0/0/0, changed state to down
*Aug  1 01:43:56.447: %LINK-3-UPDOWN: Interface GigabitEthernet0/0/0, changed state to up
*Aug  1 01:43:57.447: %LINEPROTO-5-UPDOWN: Line protocol on Interface GigabitEthernet0/0/0, changed state to up
R1(config)#
R1(config)#
R1(config)# interface gigabitEthernet 0/0/1
R1(config-if)# description Link to R2
R1(config-if)# ip address 209.165.200.225 255.255.255.252
R1(config-if)# ipv6 address 2001:db8:feed:224::1/64
R1(config-if)# no shutdown
R1(config-if)# exit
R1(config)#
*Aug  1 01:46:29.170: %LINK-3-UPDOWN: Interface GigabitEthernet0/0/1, changed state to down
*Aug  1 01:46:32.171: %LINK-3-UPDOWN: Interface GigabitEthernet0/0/1, changed state to up
*Aug  1 01:46:33.171: %LINEPROTO-5-UPDOWN: Line protocol on Interface GigabitEthernet0/0/1, changed state to up
R1(config)#
```
Note: Notice the informational messages informing us that G0/0/0 and G0/0/1 are enabled.

### Verify Interface Configuration

The most useful of these is the `show ip interface brief` and `show ipv6 interface brief` commands
```
R1#  show ip interface brief
Interface              IP-Address      OK? Method Status                Protocol 
GigabitEthernet0/0/0   192.168.10.1    YES manual up                    up 
GigabitEthernet0/0/1   209.165.200.225 YES manual up                    up 
Vlan1                  unassigned      YES unset  administratively down down 
R1#  show ipv6 interface brief
GigabitEthernet0/0/0       [up/up]
    FE80::201:C9FF:FE89:4501
    2001:DB8:ACAD:10::1
GigabitEthernet0/0/1       [up/up]
    FE80::201:C9FF:FE89:4502
    2001:DB8:FEED:224::1
Vlan1                      [administratively down/down]
    unassigned 
R1#
```

### Configuration Verification Commands

The table summarizes the more popular show commands used to verify interface configuration.

Commands | Description
--- | ---
show ip interface brief | The output displays all interfaces, their IP addresses, and their current status. The configured and connected interfaces should display a Status of “up” and Protocol of “up”. Anything else would indicate a problem with either the configuration or the cabling.
show ipv6 interface brief | Displays the contents of the IP routing tables stored in RAM.
show ip route | Displays the IPv4 statistics for all interfaces on a router.
show ipv6 route | Displays the IPv6 statistics for all interfaces on a router.
show interfaces | Displays statistics for all interfaces on the device. However, this command will only display the IPv4 addressing information.
show ip interface | Displays the IPv4 statistics for all interfaces on a router.
show ipv6 interface | Displays the IPv6 statistics for all interfaces on a router.

# Configure the Default Gateway

### Default Gateway on a Host

If your local network has only one router, it will be the gateway router and all hosts and switches on your network must be configured with this information. If your local network has multiple routers, you must select one of them to be the default gateway router. 

The default gateway is only used when the host wants to send a packet to a device on another network.

### Default Gateway on a Switch

To configure an IPv4 default gateway on a switch, use the `ip default-gateway ip-address` global configuration command. The ip-address that is configured is the IPv4 address of the local router interface connected to the switch.

Note: Packets originating from host computers connected to the switch must already have the default gateway address configured on their host computer operating systems.

A workgroup switch can also be configured with an IPv6 address on an SVI. However, the switch does not require the IPv6 address of the default gateway to be configured manually. The switch will automatically receive its default gateway from the ICMPv6 Router Advertisement message from the router.
