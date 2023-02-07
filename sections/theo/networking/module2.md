# Cisco IOS Access

### Operating Systems

- Shell, the user interface that allows users to request specific tasks from computer. These requests can be made either through the CLI or GUI.
- Kernel, communicates between the hardware and software and manages how hardware resources are used to meet software requirements.
- Hardware, the physical components of the computer.

### GUI

- Graphical User Interface allows the user to interact with the system using an environment of graphical icons, menus and windows.
- Most user rely on the GUI to perform tasks on the computer because it requires less knowledge of the underlying command structure that controls the computer.
- However, network devices rely on CLI because GUIs may not always be able to provide all the features that are available in the CLI.
- The CLI is less resource intensive and very stable when compared to a GUI.
- Network operating systems used on may Cisco devices is called Cisco internetwork operating system (IOS). (other OSs include IOS XE, IOS XR, and NX-OS).


### Purpose of an OS

Network operating systems are just like PC operating systems.

Via a GUI, a PC operating system allows the user to do the following:
- Use mouse to make selections and run programs
- Enter text and text-based commands
- View output on monitor

Via a CLI, a network operating system allows the user to do the following:
- Use a keyboard to run CLI-based network programs
- Enter text and text-based commands
- View output on monitor

### Access Methods

Console:(out-of-band)
- A Physical management port on the device
- Advantage, device is accessible even if no networking services are available.
- A computer running terminal emulation software and a special console cable to connect to the device are required for a console connection.

Secure Shell (SSH):(in-band)
- Recommended method for remote establishing a CLI connection to a device, through a virtual interface, over a network.
- Requires active networking services on the device + an active interface configured with an IP address.
- Advantage, provides a secure connection to the device.

Telnet:(in-band)
- Insecure method for remote establishing a CLI connection to a device, through a virtual interface, over a network.
- Unlike SSH, Telnet does not encrypt the data that is sent over the network.
- User authentication, password, and commands are sent over the network in plain text.
- Should only be used in a lab environment.

AUX port(legacy auxillary port): (out-of-band)
- Used to establish a CLI session remotely over a telephone connection using a modem
- Does not require networking services on the device.

Note:
In-band communication refers to sending control, management, and data signals over the same network channel used for user data. This method can be convenient, but can also lead to performance degradation if the management traffic consumes a significant portion of the network bandwidth.

Out-of-band communication, on the other hand, refers to sending control, management, and data signals over a dedicated network channel that is separate from the channel used for user data. This method can provide better network reliability and security, but requires additional infrastructure and may be more complex to set up and manage.


# IOS Navigation

### Primary Command Modes

Command Mode | Description | Default Device Prompt
--- | --- | ---
User Exec Mode | Mode allows access to only a limited number of basic monitoring commands. It is often referred to as “view-only" mode. | Switch> Router>
Privileged EXEC Mode | Mode allows access to all commands and features. The user can use any monitoring commands and execute configuration and management commands. | Switch# Router#

### Configuration Mode and Subconfiguration Modes

To configure the device, the user must enter global configuration mode, which is commonly called global config mode. its identified by the prompt Switch(config)# or Router(config)#.

From this mode(global) the user can enter subconfiguration modes to configure specific features of the device. Two common subconfiguration modes include:

- Line Configuration Mode - Used to configure console, SSH, Telnet, or AUX access.
- Interface Configuration Mode - Used to configure a switch port or router network interface.

In the CLI, the mode is identified by the prompt Switch(config-line)# for line configuration mode and Switch(config-if)# for interface configuration mode.

### Video - IOS CLI Primary Command Modes

1. Click on Device(pc) > Terminal emulation program > ok > and you will be prsented with a console CLI, that is the Cisco IOS. press enter to get started.

2. Default mod is User exec, to switch to privileged EXEC mode type `enable` and press enter. to return to user exec mode type `disable` and press enter.

3. To go to a higher level (Global config mode) type `configure terminal` or `config t` and press enter. to return to privileged EXEC mode type `end` or `exit` and press enter.

### Navigate Between IOS Modes

To enter line you use the line command followed by the management line type and number you wish to access.
```
Switch> enable
Switch# configure terminal
Switch(config)# line console 0
Switch(config-line)# exit
Switch(config)#
```
`exit` is used to exit the current mode and return to the previous mode.
`end` is used to exit the current mode and return to privileged EXEC mode.

To enter interface configuration mode, use the interface command followed by the interface type and number you wish to access.
```
Switch> enable
Switch# configure terminal
Switch(config)# interface fastEthernet 0/1
Switch(config-if)# exit
Switch(config)#
```

You can also move directly from one subconfiguration mode to another. Notice how after selecting an interface, the command prompt changes from (config-line)# to (config-if)#.
```
Switch(config-line)# interface fastEthernet 0/1
Switch(config-if)#
```

# The Command Structure

### Basic IOS Command Structure

Each IOS command has a specific format, or syntax, and can only be executed in the appropriate mode

![c](/imgs/comstruc.png)
- Keyword - This is a specific parameter defined in the operating system (in the figure, ip protocols).
- Argument - This is not predefined; it is a value or variable defined by the user (in the figure, 192.168.10.5).

### IOS Command Syntax Check

To determine the keywords and arguments required for a command, refer to the command syntax. The syntax provides the pattern, or format, that must be used when entering a command.
Convention | Description
--- | ---
boldface | Boldface text indicates commands and keywords that you enter literally as shown.
italics | Italic text indicates arguments for which you supply values.
[x] | Square brackets indicate an optional element (keyword or argument).
{x} | Braces indicate a required element (keyword or argument).
[x {y | z }] | Braces and vertical lines within square brackets indicate a required choice within an optional element. Spaces are used to clearly delineate parts of the command.

Conventions used to document and use IOS commands:
- ping ip-address - This command is ping followed by an user-defined argument, ip-address. e.g. ping 10.10.10.5
- traceroute ip-address - This command is traceroute followed by an user-defined argument, ip-address. e.g. traceroute 192.168.254.254

### IOS Help Features

To access context-sensitive help, simply enter a question mark, ?, at the CLI.

- its context-sensitive, meaning that it matters when and where you enter the question mark.
- it provides a list of commands that are valid in the current mode.
    - if you enter a question mark in user exec mode, the list of commands that are valid in user exec mode is displayed.
    - if you enter a question mark in privileged EXEC mode, the list of commands that are valid in privileged EXEC mode is displayed.
    - if you enter a question mark in global config mode, the list of commands that are valid in global config mode is displayed. and so on...
- press the spacebar to get the next page of the list of commands.
- it can also be used to finish a partially entered command `in?`. and it will tell you the arguments that are required for the command `interface ?`.

The command syntax checker shows you whats wrong with your command, if you enter a command that is not valid in the current mode, the command syntax checker will tell you what you did wrong.

# Basic Device Configuration

### Device Names

By default, all devices are assigned a factory default name.

The default name should be changed to something more descriptive. By choosing names wisely, it is easier to remember, document, and identify network devices. Here are some important naming guidelines for hosts:

- Start with a letter
- Contain no spaces
- End with a letter or digit
- Use only letters, digits, and dashes
- Be less than 64 characters in length

When network devices are named they are easy to identify for configuration purposes and troubleshooting.

From global configuration mode, enter the command hostname followed by the name of the switch and press Enter. Notice the change in the command prompt name.

```
Switch# configure terminal
Switch(config)# hostname Sw-Floor-1
Sw-Floor-1(config)#
```

Note: To return the switch to the default prompt, use the no hostname global config command.
```
Sw-Floor-1(config)# no hostname
Switch(config)#
```

### Password Guidelines

Cisco IOS can be configured to use hierarchical mode passwords to allow different access privileges to a network device.

All networking devices should limit administrative access by securing privileged EXEC, user EXEC, and remote Telnet access with passwords. In addition, all passwords should be encrypted and legal notifications provided.

When choosing passwords, use strong passwords that are not easily guessed. There are some key points to consider when choosing passwords:

- Use passwords that are more than eight characters in length.
- Use a combination of upper and lowercase letters, numbers, special characters, and/or numeric sequences.
- Avoid using the same password for all devices.
- Do not use common words because they are easily guessed.

### Configure Passwords

To secure user EXEC mode access, enter line console configuration mode using the line console 0 global configuration command, as shown in the example. The zero is used to represent the first (and in most cases the only) console interface. Next, specify the user EXEC mode password using the `password password` command. Finally, enable user EXEC access using the `login` command.
    
```
Sw-Floor-1# configure terminal
Sw-Floor-1(config)# line console 0
Sw-Floor-1(config-line)# password cisco
Sw-Floor-1(config-line)# login
Sw-Floor-1(config-line)# end
Sw-Floor-1#
```

To secure privileged EXEC access, use the `enable secret password` global config command, as shown in the example.

```
Sw-Floor-1# configure terminal
Sw-Floor-1(config)# enable secret class
Sw-Floor-1(config)# exit
Sw-Floor-1#
```

Virtual terminal (VTY) lines enable remote access using Telnet or SSH to the device. Many Cisco switches support up to 16 VTY lines that are numbered 0 to 15.

To secure VTY lines, enter line VTY mode using the line vty 0 15 global config command. Next, specify the VTY password using the `password password` command. Lastly, enable VTY access using the `login` command.

```
Sw-Floor-1# configure terminal
Sw-Floor-1(config)# line vty 0 15
Sw-Floor-1(config-line)# password cisco 
Sw-Floor-1(config-line)# login 
Sw-Floor-1(config-line)# end
Sw-Floor-1#
```

### Encrypt Passwords

To encrypt all plaintext passwords, use the `service password-encryption` global config command as shown in the example.

```
Sw-Floor-1# configure terminal
Sw-Floor-1(config)# service password-encryption
Sw-Floor-1(config)#
```
The command applies weak encryption to all unencrypted passwords. This encryption applies only to passwords in the configuration file, not to passwords as they are sent over the network. The purpose of this command is to keep unauthorized individuals from viewing passwords in the configuration file.

Use the `show running-config` command to verify that passwords are now encrypted.

### Banner Messages

Banners can be an important part of the legal process in the event that someone is prosecuted for breaking into a device.

To create a banner message of the day on a network device, use the `banner motd # the message of the day #` global config command. (The # characters are used to delimit the banner message. any character can be used to delimit the banner message but it cannot be in the message itself.)
```
Sw-Floor-1# configure terminal
Sw-Floor-1(config)# banner motd # Unauthorized access is prohibited. #
Sw-Floor-1(config)#
```

# Save Configuration 
