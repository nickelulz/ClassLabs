#!/bin/bash

if [ "$#" -lt 1 && "$#" -gt 2 ]; then
  echo "ERROR: expecting one argument, the name of lab without extension (e.g. \"1\")"
  exit 0
fi

main=""
dir=""

if [ "$1" = "0" ]; then
  main="GraphRunner"
  dir="0 - DFS Traversal"
elif [ "$1" = "1" ]; then
  main="GraphRunner"
  dir="1 - Connections"
elif [ "$1" = "2" ]; then
  main="ShortestPathGraphRunner"
  dir="2 - Shortest Path Connection"
elif [ "$1" = "3" ]; then
  main="BiDirectionalGraphRunner"
  dir="3 - Bidirectional Graph"
elif [ "$1" = "4" ]; then
  main="MazeRunner"
  dir="4 - Maze"
elif [ "$1" = "5" ]; then
  main="ShortestPathMazeRunner"
  dir="5 - Shortest Path Maze"
elif [ "$1" = "6" ]; then
  main="Graph"
  dir="6 - Adjacency Matrix and Adjacency List"
elif [ "$1" = "7" ]; then
  main="AStarGrader" # and DijkstraGrader
  dir="7 - BFS Traversal"
elif [ "$1" = "8" ]; then
  main="Graph"
  dir="8 - Djikstra's Algorithm"
fi

clear

echo "making: ${dir}/${main}.java"
echo
cd "${dir}"
rm -f *.class
javac ${main}.java
java ${main}