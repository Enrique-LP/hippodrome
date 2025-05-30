# Hippodrome Simulation Project

## Project Overview
This project is a simulation of a hippodrome (horse racing track) with added testing and logging functionality.



## Description
This program simulates a hippodrome where multiple horses compete in a race. The project focuses on implementing proper testing and logging mechanisms for a robust and maintainable codebase.

## Required Tests Implementation

### Horse Class Tests
1. Constructor Tests:
   - Verify `IllegalArgumentException` when passing `null` as first parameter
   - Verify exception message "Name cannot be null" when passing `null`
   - Verify `IllegalArgumentException` for empty or whitespace-only strings
   - Verify exception message "Name cannot be blank" for empty strings
   - Verify `IllegalArgumentException` for negative speed values
   - Verify exception message "Speed cannot be negative"
   - Verify `IllegalArgumentException` for negative distance values
   - Verify exception message "Distance cannot be negative"

2. Method Tests:
   - `getName()`: Verify return value matches constructor input
   - `getSpeed()`: Verify return value matches constructor input
   - `getDistance()`: 
     - Verify return value matches constructor input
     - Verify zero return for two-parameter constructor
   - `move()`:
     - Verify `getRandomDouble` call with parameters (0.2, 0.9)
     - Verify distance calculation formula

### Hippodrome Class Tests
1. Constructor Tests:
   - Verify `IllegalArgumentException` for `null` input
   - Verify exception message "Horses cannot be null"
   - Verify `IllegalArgumentException` for empty list
   - Verify exception message "Horses cannot be empty"

2. Method Tests:
   - `getHorses()`: Verify returned list matches constructor input
   - `move()`: Verify movement call on all horses
   - `getWinner()`: Verify horse with maximum distance is returned

### Main Class Tests
- `main()`: Verify execution time under 22 seconds (disabled by default)

## Logging Requirements

### Main Class Logging
- Race start: `INFO` level with participants count
- Race end: `INFO` level with winner name

### Hippodrome Class Logging
- `ERROR` level for null horses list
- `ERROR` level for empty horses list
- `DEBUG` level for successful creation

### Horse Class Logging
- `ERROR` level for null name
- `ERROR` level for blank name
- `ERROR` level for negative speed
- `ERROR` level for negative distance
- `DEBUG` level for successful creation

## Log File Configuration
- Base file: `logs/hippodrome.log`
- Daily rollover pattern: `hippodrome.YYYY-MM-DD.log`
- 7-day retention policy
- Uses RollingFile appender with DefaultRolloverStrategy

## Getting Started
1. Fork the repository from: https://github.com/CodeGymCC/hippodrome
2. Clone your forked repository
3. Implement the required tests and logging functionality
4. Verify all tests pass and logging works as expected

## Technologies
- Java
- JUnit for testing
- Log4j2 for logging
- Maven for project management
