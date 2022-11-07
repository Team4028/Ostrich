     # Ostrich Team

<br/>

## Goal
The goal for Ostrich Team is to learn the basics of subsystem creation and design by re-controlling Eclipse.

<br/>

### Task 1: Familiarization
Familiarize yourself with which motors have which CAN IDs using Phoenix Tuner and write down a complete robot map of every device with its corresponding ID.

<br/>

### Task 2: Drive
Create a simple Tank-drive Drivetrain subsystem with basic driver controls.
No need for anything fancy, just the ability to     drive using a controller.

<br/>

### Task 3: Yoshi
Manipulate the intake arms, called "Yoshis" on Eclipse. Each Yoshi has three critical components: The motor which positions the arm, the limit switch which indicates the arm is home, and the motor which spins the green wheel.

Once you've identified the components, begin moving the arms. Start by having one button move the arms away from one another, and another button move them towards each other. Then get a homing routine, and finally the ability to toggle between multiple pre-set positions. Feel free to refer to the previous example code from the Resources section for hints here.

<br/><br/>

#### **Tips**
- You will need to be sure to include the vendor dependencies (REV, CTRE, etc).
- When spinning a motor for the first time, _never_ go above 10% speed.


<br/>

#### **Helpful Resources**
- [2022 Re-control code](https://github.com/Team4028/2023-Eclipse)
- [2018 Eclipse Competition Code](https://github.com/Team4028/2018-Competition)

