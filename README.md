# Java 8 Interview Coding Questions

1. What are the key features of Java 8?
Java 8 introduced several new features, including:
✅ Lambda Expressions – Enables functional programming
✅ Functional Interfaces – Single abstract method interfaces
✅ Streams API – Process collections in a functional way
✅ Default & Static Methods in Interfaces – Method implementation inside interfaces
✅ Optional Class – Avoids NullPointerException
✅ New Date and Time API – LocalDate, LocalTime, LocalDateTime
✅ Collectors and Functional Interfaces – Collectors.toList(), Predicate, Consumer



## Static Methods in Interfaces in Java (Java 8+)
In Java 8, interfaces can have static methods in addition to default methods. These static methods belong to the interface itself, not to the implementing classes.

1. Why Use Static Methods in an Interface?
✅ To provide utility/helper methods that relate to the interface.
✅ To avoid code duplication by providing common functionality to all implementations.
✅ They cannot be overridden by implementing classes, ensuring consistency.

