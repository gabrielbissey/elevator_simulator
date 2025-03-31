# Elevator Simulator

## Running

Run `./gradlew run`

## Assumptions
- There needs to be a GUI.
- I thought it would be most helpful to randomly generate people to use the elevator.
I suppose an alternate approach would have been to create a GUI that would allow a user
to interact with the elevator instead. This may have added arguably unnecessary complexity
to this program, but it also allowed me to work with multithreading and concurrency.

## Features not implemented
- The ability for multiple people to be generated at a time, and for the elevator to
handle them elegantly.
- Multiple elevators running concurrently
  - This could be tied into the above feature where if one elevator is currently
  occupied and a new person is generated, that person could use a different elevator
- Smoother animations would be nice, as in the elevator could smoothly slide from
one floor to another.

## Helpful resources used
- https://medium.com/@michael71314/java-lesson-21-drawing-and-coloring-shapes-on-the-jframe-d740970e1d68
- https://www.youtube.com/watch?v=FAteFoclDEw&t=1126s
- https://web.mit.edu/6.005/www/fa14/classes/20-queues-locks/message-passing/
- https://www.geeksforgeeks.org/mvc-design-pattern/
