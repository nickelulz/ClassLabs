#!/bin/bash

if [ "$#" -lt 1 && "$#" -gt 2 ]; then
  echo "ERROR: expecting one argument, the name of lab without extension (e.g. \"1\")"
  exit 0
fi

main=""
dir=""

if [ "$1" = "1" ]; then
  main="Lab17a"
  dir="17a_BST"
elif [ "$1" = "2" ]; then
  main="Lab17a"
  dir="17a_generic___warning_free"
elif [ "$1" = "3" ]; then
  main="Lab15b"
  dir="17b_HistoTree"
elif [ "$1" = "4" ]; then
  main="Lab17c"
  dir="17c_HistoTree2"
fi

clear

echo "making: ${dir}/${main}.java"

if [ "$2" = "-v" -or "$2" == "--verbose" ]; then
  echo cd ./${dir}
fi

cd ${dir}

if [ "$2" = "-v" || "$2" == "--verbose" ]; then
  echo rm -f *.class
fi
rm -f *.class

if [ "$2" = "-v" || "$2" == "--verbose" ]; then
  echo javac ${main}.java
fi
javac ${main}.java

if [ "$2" = "-v" || "$2" == "--verbose" ]; then
  echo java ${main}
fi
java ${main}