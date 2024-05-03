# Word Ladder Solver

## Table of Contents

- [General Info](#general-information)
- [Technologies Used](#technologies-used)
- [Requirements](#requirements)
- [Features](#features)
- [Setup](#setup)
- [Usage](#usage)
- [Contact](#contact)

## General Information

Word ladder (also known as Doublets, word-links, change-the-word puzzles, paragrams, laddergrams, or word golf) is a word game that is well known to all circles. Word ladder was discovered by Lewis Carroll, a writer and mathematician, in 1877. In this game, players are given two words called a start word and an end word. To win the game, players must find a chain of words that can connect the start word and end word. The number of letters at the start word and end word is always the same. Each adjacent word in the word chain can only differ by one letter. In this game, the optimal solution is expected, namely the solution that minimizes the number of words included in the word chain.

## Technologies Used

- java version "22.0.1" 2024-04-16
- Java(TM) SE Runtime Environment (build 22.0.1+8-16)

## Features

- Uniform Cost Search (UCS) Algorithm
- Greedy Best First Search (GBFS) Algorithm
- A\* Algorithm

## Requirements

- java version "22.0.1" 2024-04-16
- Java(TM) SE Runtime Environment (build 22.0.1+8-16)
- Linux

## Setup

- To run using makefile, simply run

```bash
make all
```

The above command simply run `make clean`, `make build`, and finally `make run` sequentially.

- To run manually, build the program by running

```bash
javac --source-path src -d bin src/Main.java
```

Run the program by running

```bash
java -cp bin Main
```

Clean the bin by running

```bash
rm -rf bin/*
```

## Usage

![Demo Illustration](https://github.com/dewodt/Tucil3_13522011/tree/main/test/readme/demo.png)

1. Input start word
2. Input end word
3. Input algorithm (UCS / GBFS / A\*)
4. Wait for result
5. Enjoy!

## Contact

Created by [@dewodt](https://dewodt.com/) - feel free to contact me!
