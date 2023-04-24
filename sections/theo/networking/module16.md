# Security Threats and Vulnerabilities

### Types of Threats

 Intruders who gain access by modifying software or exploiting software vulnerabilities are called threat actors.

 After the threat actor gains access to the network, four types of threats may arise:

 1. Information theft - is breaking into a computer to obtain confidential information. Information can be used or sold for various purposes such as when someone is stealing proprietary information of an organization, like research and development data.

 2. Data loss and manipulation - is breaking into a computer to destroy or alter data records. An example of data loss is a threat actor sending a virus that reformats a computer hard drive. An example of data manipulation is breaking into a records system to change information, such as the price of an item.

 3. Identity theft - is a form of information theft where personal information is stolen for the purpose of taking over the identity of someone. Using this information, a threat actor can obtain legal documents, apply for credit, and make unauthorized online purchases. Identify theft is a growing problem costing billions of dollars per year.

 4. Disruption of service - is preventing legitimate users from accessing services to which they are entitled. Examples include denial of service (DoS) attacks on servers, network devices, or network communications links.

### Types of Vulnerabilities

1. Technological Vulnerabilities
Vulnerability | Description
---|---
TCP/IP Protocol Weakness | Hypertext Transfer Protocol (HTTP), File Transfer Protocol (FTP), and Internet Control Message Protocol (ICMP) are inherently insecure. Simple Network Management Protocol (SNMP) and Simple Mail Transfer Protocol (SMTP) are related to the inherently insecure structure upon which TCP was designed.
Operating System Weakness | Each operating system has security problems what must be addressed. UNIX, Linux, Mac OS, Mac OS X, Windows Server 2012, Windows 7, Windows 8 They are documented in the Computer Emergency Response Team (CERT) archives at http://www.cert.org
Network Equipment Weakness | Various types of network equipment, such as routers, firewalls, and switches have security weaknesses that must be recognized and protected against. Their weaknesses include password protection, lack of authentication, routing protocols, and firewall holes.

2. Configuration Vulnerabilities
Vulnerability | Description
---|---
Unsecured user accounts | User account information may be transmitted insecurely across the network, exposing usernames and passwords to threat actors.
System accounts with easily guessed passwords | This common problem is the result of poorly created user passwords.
Misconfigured internet services | Turning on JavaScript in web browsers enables attacks by way of JavaScript controlled by threat actors when accessing untrusted sites. Other potential sources of weaknesses include misconfigured terminal services, FTP, or web servers (e.g., Microsoft Internet Information Services (IIS), and Apache HTTP Server.
Unsecured default settings within products | Many products have default settings that create or enable holes in security.
Misconfigured network equipment | Misconfigurations of the equipment itself can cause significant security problems. For example, misconfigured access lists, routing protocols, or SNMP community strings can create or enable holes in security.

3. Policy Vulnerabilities
Vulnerability | Description
---|---
Lack of written security policy | A security policy cannot be consistently applied or enforced if it is not written down.
Politics | Political battles and turf wars can make it difficult to implement a consistent security policy.
Lack of authentication continuity | Poorly chosen, easily cracked, or default passwords can allow unauthorized access to the network.
Logical access controls not applied | Inadequate monitoring and auditing allow attacks and unauthorized use to continue, wasting company resources. This could result in legal action or termination against IT technicians, IT management, or even company leadership that allows these unsafe conditions to persist.
Software and hardware installation and changes do not follow policy | Unauthorized changes to the network topology or installation of unapproved application create or enable holes in security.
Disaster recovery plan is nonexistent | The lack of a disaster recovery plan allows chaos, panic, and confusion to occur when a natural disaster occurs or a threat actor attacks the enterprise.

### Physical Security

The four classes of physical threats are as follows:
- Hardware threats - This includes physical damage to servers, routers, switches, cabling plant, and workstations.
- Environmental threats - This includes temperature extremes (too hot or too cold) or humidity extremes (too wet or too dry).
- Electrical threats - This includes voltage spikes, insufficient supply voltage (brownouts), unconditioned power (noise), and total power loss.
- Maintenance threats - This includes poor handling of key electrical components (electrostatic discharge), lack of critical spare parts, poor cabling, and poor labeling.

# Network Attacks

### Types of Malware

- Malware is short for malicious software designed to damage, disrupt, steal, or inflict illegitimate action on data, hosts, or networks.
- Types of malware include viruses, worms, and Trojan horses.
- Viruses propagate by inserting a copy of themselves into another program and can range from mildly annoying to causing severe damage.
    - Almost all viruses are attached to an executable file, which means the virus may exist on a system but will not be active or able to spread until a user runs or opens the malicious host file or program.
    - Viruses spread when the software or document they are attached to is transferred from one computer to another using the network, a disk, file sharing, or infected email attachments.
- Worms are standalone software that can replicate and spread through the network unaided.
- Trojan horses are harmful software that look legitimate and require user interaction to spread, and can cause a range of attacks on the host system.
- Malware can spread through various means such as network transfers, infected email attachments, and downloading and running files from the internet.
- It is important to be aware of the different types of malware and how they can spread to protect against network threats.

### Reconnaissance Attacks

Network attacks can be classified into three major categories:
- Reconnaissance attacks - The discovery and mapping of systems, services, or vulnerabilities.
- Access attacks - The unauthorized manipulation of data, system access, or user privileges.
- Denial of service - The disabling or corruption of networks, systems, or services.

For reconnaissance attacks, external threat actors can use internet tools, such as the nslookup and whois utilities, to easily determine the IP address space assigned to a given corporation or entity.

After the IP address space is determined, a threat actor can then ping the publicly available IP addresses to identify the addresses that are active. To help automate this step, a threat actor may use a ping sweep tool, such as fping or gping(This systematically pings all network addresses in a given range or subnet. This is similar to going through a section of a telephone book and calling each number to see who answers.)

### Access Attacks

Access attacks exploit known vulnerabilities in authentication services, FTP services, and web services to gain entry to web accounts, confidential databases, and other sensitive information. 

An access attack allows individuals to gain unauthorized access to information that they have no right to view. 

Access attacks can be classified into four types:

1. Password Attacks

Threat actors can implement password attacks using several different methods:

Brute-force attacks
Trojan horse attacks
Packet sniffers

2. Trust Exploitation

In a trust exploitation attack, a threat actor uses unauthorized privileges to gain access to a system, possibly compromising the target.

3. Port Redirection

In a port redirection attack, a threat actor uses a compromised system as a base for attacks against other targets. 

4. Man-in-the-Middle

In a man-in-the-middle attack, the threat actor is positioned in between two legitimate entities in order to read or modify the data that passes between the two parties. 

### Denial of Service Attacks

1. DoS Attack

DoS attacks are a major risk because they interrupt communication and cause significant loss of time and money. These attacks are relatively simple to conduct, even by an unskilled threat actor.

2. DDoS Attack

A DDoS is similar to a DoS attack, but it originates from multiple, coordinated sources. For example, a threat actor builds a network of infected hosts, known as zombies. A network of zombies is called a botnet. The threat actor uses a command and control (CnC) program to instruct the botnet of zombies to carry out a DDoS attack.

# Network Attack Mitigations

### The Defense-in-Depth Approach

Several security devices and services are implemented to protect an organization’s users and assets against TCP/IP threats.
- VPN - A router is used to provide secure VPN services with corporate sites and remote access support for remote users using secure encrypted tunnels.
- ASA Firewall - This dedicated device provides stateful firewall services. It ensures that internal traffic can go out and come back, but external traffic cannot initiate connections to inside hosts.
- IPS - An intrusion prevention system (IPS) monitors incoming and outgoing traffic looking for malware, network attack signatures, and more. If it recognizes a threat, it can immediately stop it.
- ESA/WSA - The email security appliance (ESA) filters spam and suspicious emails. The web security appliance (WSA) filters known and suspicious internet malware sites.
- AAA Server - This server contains a secure database of who is authorized to access and manage network devices. Network devices authenticate administrative users using this database.

### Keep Backups

Backing up device configurations and data is one of the most effective ways of protecting against data loss.

The table shows backup considerations and their descriptions.

Consideration | Description
---|---
Frequency | Perform backups on a regular basis as identified in the security policy. Full backups can be time-consuming, therefore perform monthly or weekly backups with frequent partial backups of changed files.
Validation | Always validate backups to ensure the integrity of the data and validate the file restoration procedures.
Storage | Backups should be transported to an approved offsite storage location on a daily, weekly, or monthly rotation, as required by the security policy.
Security | Backups should be protected using strong passwords. The password is required to restore the data.

### Upgrade, Update, and Patch

The most effective way to mitigate a worm attack is to download security updates from the operating system vendor and patch all vulnerable systems.

One solution to the management of critical security patches is to make sure all end systems automatically download updates

### Authentication, Authorization, and Accounting

AAA is a way to control 
- who is permitted to access a network (authenticate)
- what actions they perform while accessing the network (authorize)
- and making a record of what was done while they are there (accounting).

### Firewalls

A firewall is one of the most effective security tools available for protecting users from external threats. 

A firewall protects computers and networks by preventing undesirable traffic from entering internal networks.

A firewall could allow outside users controlled access to specific services. For example, servers accessible to outside users are usually located on a special network referred to as the demilitarized zone (DMZ)

### Types of Firewalls

- Packet filtering - Prevents or allows access based on IP or MAC addresses
- Application filtering - Prevents or allows access by specific application types based on port numbers
- URL filtering - Prevents or allows access to websites based on specific URLs or keywords
- Stateful packet inspection (SPI) - Incoming packets must be legitimate responses to requests from internal hosts. Unsolicited packets are blocked unless permitted specifically. SPI can also include the capability to recognize and filter out specific types of attacks, such as denial of service (DoS)

### Endpoint Security

Securing endpoint devices is one of the most challenging jobs of a network administrator because it involves human nature. 

- A company must have well-documented policies in place and employees must be aware of these rules. 
- Employees need to be trained on proper use of the network. 
- Policies often include the use of antivirus software and host intrusion prevention. 

More comprehensive endpoint security solutions rely on network access control.

# Device Security

### Cisco AutoSecure

For Cisco routers, the Cisco AutoSecure feature can be used to assist securing the system, as shown in the example.
```bash
Router# auto secure
                --- AutoSecure Configuration ---
*** AutoSecure configuration enhances the security of
the router but it will not make router absolutely secure
from all security attacks ***
```

In addition, there are some simple steps that should be taken that apply to most operating systems:
- Default usernames and passwords should be changed immediately.
- Access to system resources should be restricted to only the individuals that are authorized to use those resources.
- Any unnecessary services and applications should be turned off and uninstalled when possible.

### Passwords

standard guidelines to follow:

- Use a password length of at least eight characters, preferably 10 or more characters. A longer password is a more secure password.
- Make passwords complex. Include a mix of uppercase and lowercase letters, numbers, symbols, and spaces, if allowed.
- Avoid passwords based on repetition, common dictionary words, letter or number sequences, usernames, relative or pet names, biographical information, such as birthdates, ID numbers, ancestor names, or other easily identifiable pieces of information.
- Deliberately misspell a password. For example, Smith = Smyth = 5mYth or Security = 5ecur1ty.
- Change passwords often. If a password is unknowingly compromised, the window of opportunity for the threat actor to use the password is limited.
- Do not write passwords down and leave them in obvious places such as on the desk or monitor.

On Cisco routers, leading spaces are ignored for passwords, but spaces after the first character are not. Therefore, one method to create a strong password is to use the space bar and create a phrase made of many words. This is called a passphrase. A passphrase is often easier to remember than a simple password. It is also longer and harder to guess.

### Additional Password Security

- Encrypting all plaintext passwords
- Setting a minimum acceptable password length
- Deterring brute-force(This attack continuously attempts to guess the valid passwords until one works) password guessing attacks(limiting the number of login attempts)
- Disabling an inactive privileged EXEC mode access after a specified amount of time.

To ensure that all configured passwords are a minimum of a specified length, use the `security passwords min-length length` command in global configuration mode.

Use the `login block-for # attempts # within #` global configuration command to deter brute-force password guessing attacks.

By default, Cisco routers will logout an EXEC session after 10 minutes of inactivity. However, you can reduce this setting using the `exec-timeout` minutes seconds line configuration command

```bash
R1(config)# service password-encryption 
R1(config)# security passwords min-length 8 
R1(config)# login block-for 120 attempts 3 within 60
R1(config)# line vty 0 4 
R1(config-line)# password cisco123 
R1(config-line)# exec-timeout 5 30 
R1(config-line)# transport input ssh 
R1(config-line)# end 
R1# 
R1# show running-config | section line vty
line vty 0 4
 password 7 094F471A1A0A
 exec-timeout 5 30
 login
 transport input ssh
R1#
```

### Enable SSH

- Step 1. Configure a unique device hostname.
- Step 2. Configure the IP domain name.(`ip domain-name name`)
- Step 3. Generate a key to encrypt SSH traffic. using the global configuration command `crypto key generate rsa general-keys modulus bits`
- Step 4. Verify or create a local database entry.
- Step 5. Authenticate against the local database. Use the login local line configuration command to authenticate the vty line against the local database.
- Step 6. Enable vty inbound SSH sessions. By default, no input session is allowed on vty lines. You can specify multiple input protocols including Telnet and SSH using the transport input {ssh | telnet} command.

```bash
Router# configure terminal
Router(config)# hostname R1
R1(config)# ip domain name span.com
R1(config)# crypto key generate rsa general-keys modulus 1024
The name for the keys will be: Rl.span.com % The key modulus size is 1024 bits
% Generating 1024 bit RSA keys, keys will be non-exportable...[OK]
Dec 13 16:19:12.079: %SSH-5-ENABLED: SSH 1.99 has been enabled
R1(config)#
R1(config)# username Bob secret cisco
R1(config)# line vty 0 4
R1(config-line)# login local
R1(config-line)# transport input ssh
R1(config-line)# exit
R1(config)#
```

### Disable Unused Services

The type of services that are on by default will vary depending on the IOS version. For example, IOS-XE typically will have only HTTPS and DHCP ports open. You can verify this with the show
ip ports all command, as shown in the example.
```
Router# show ip ports all
Proto Local Address               Foreign Address             State       PID/Program Name
TCB       Local Address               Foreign Address             (state)
tcp   :::443                     :::*                        LISTEN      309/[IOS]HTTP CORE
tcp   *:443                      *:*                         LISTEN      309/[IOS]HTTP CORE
udp   *:67                        0.0.0.0:0                               387/[IOS]DHCPD Receive
Router#
```
IOS versions prior to IOS-XE use the show control-plane host open-ports command. We mention this command because you may see it on older devices. The output is similar. However, notice that this older router has an insecure HTTP server and Telnet running. Both of these services should be disabled. As shown in the example, disable HTTP with the no ip http server global configuration command. Disable Telnet by specifying only SSH in the line configuration command, transport input ssh.
```
Router# show control-plane host open-ports 
Active internet connections (servers and established)
Prot        Local Address      Foreign Address                  Service    State
 tcp                 *:23                  *:0                   Telnet   LISTEN
 tcp                 *:80                  *:0                HTTP CORE   LISTEN
 udp                 *:67                  *:0            DHCPD Receive   LISTEN
Router# configure terminal
Router(config)# no ip http server
Router(config)# line vty 0 15
Router(config-line)# transport input ssh
```