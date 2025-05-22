#!/bin/sh

javac mainClass.java
mv ./*.class ./classFolder/
cd classFolder
java mainClass
cd ..
