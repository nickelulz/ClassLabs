#!/bin/bash

if [ "$#" -lt 1 && "$#" -gt 2 ]; then
  echo "ERROR: expecting one argument, the name of lab without extension (e.g. \"1\")"
  exit 0
fi

main=""
dir=""

if [ "$1" = "1" ]; then
  main="Lab18a"
  dir="lab18a_MyHeap"
elif [ "$1" = "2" ]; then
  main="Lab18b"
  dir="lab18b_YourPQ"
elif [ "$1" = "3" ]; then
  main="Lab18c"
  dir="lab18c_HeapSort"
fi

clear

echo "making: ${dir}/${main}.java"

cd ${dir}
rm -f *.class
javac ${main}.java
java ${main}