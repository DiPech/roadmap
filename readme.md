# RoadMap Test Project (2019)

## What I was asked to implement

You have cities and roads which connect the cities. Design and implement the RoadMap service:
- City:
  - Unique name.
  - Coords (x, y).
- Road:
  - Connects two cities.
  - Unique name.
  - Length.
- API:
  - Add a city.
  - Add a road.
  - Delete a road.
  - Get a city by a name.
  - Get roads list by a name of a city.
- Requirements:
  - InMemory storage.
  - Data consistency.
  - External libs are prohibited.
  - Thread-safe implementation (additionally).

## Implementation explanations

- I split the app logic into layers (`controller`, `service`, `model`, `storage`).
- I handled exceptions by outputting text in the console.
- To prevent data inconsistency I didn't store roads' lengths but calculated them automatically in `RoadTo`.
- I used `synchronized` inside the controller because it was the simplest way to do it fast 
(but not so optimal of course)
- Please keep in mind that it took less than 2h to implement it.
- I can do it much better for now, but I don't want to waste time on it.

## Possible further improvements

- Add some tests, even without any external libs.
- Use better synchronization tools from `java.util.concurrent`.
- Improve exceptions and exception handling.
- Use Stream API to make the code more pretty.
- Combine `executeOrSout` and `returnOrSout`, don't duplicate the code.
- Refactor the whole code, I don't write things that way anymore.
