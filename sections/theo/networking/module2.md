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

1. Click on Device(pc) > Terminal emulation program > ok > and you will be prsented with a console CLI, that is the Cisco IOS CLI. press enter to get started.

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

# Basic Device Configuration
