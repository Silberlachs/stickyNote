This software is under no copyright protection.
In fact, kudos if you hacked the fuck out of it.

This is meant as a sort of "crash only software";
There will be a writing routine after each input,
so crashing or stopping the process will have 
no consequences to functionality.

This program is intended to launch via a Desktop launcher.
To create said launcher, create a file on your Ubuntu Desktop
called "stickynotes.desktop" , then paste these entries into the file:

[Desktop Entry]
Version=1.0
Type=Application
Terminal=false
Exec=sh -c "cd __PATH_TO_FOLDER__;java mainClass"
Name=Sticky Noodlez
icon=icon.png

Replace __PATH_TO_FOLDER__ with your path, obviously.

You might want to create a folder in your home directory called .icon and move the application icon there,
I found no other way of doing this up until now.

Lastly, right click and select "allow launching" 


Written by clockw0rk