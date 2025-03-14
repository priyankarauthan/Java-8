# Java 8 Interview Coding Questions

### 1. What are the key features of Java 8?

Java 8 introduced several new features, including:

✅ Lambda Expressions – Enables functional programming
✅ Functional Interfaces – Single abstract method interfaces
✅ Streams API – Process collections in a functional way
✅ Default & Static Methods in Interfaces – Method implementation inside interfaces
✅ Optional Class – Avoids NullPointerException
✅ New Date and Time API – LocalDate, LocalTime, LocalDateTime
✅ Collectors and Functional Interfaces – Collectors.toList(), Predicate, Consumer



## Static Methods in Interfaces in Java (Java 8+)

 These static methods belong to the interface itself, not to the implementing classes.

1. Why Use Static Methods in an Interface?
   
✅ To provide utility/helper methods that relate to the interface.
✅ To avoid code duplication by providing common functionality to all implementations.
✅ They cannot be overridden by implementing classes, ensuring consistency.

### What is CompletableFuture? 🤔
CompletableFuture is a way to run tasks in the background without blocking your main program. It helps execute long-running tasks (like fetching data from a database or calling an API) asynchronously.

### Why Use CompletableFuture?
Imagine you order food online 🍔. While waiting, you can do other work instead of just sitting idle.
Similarly, CompletableFuture lets your program continue doing other work while waiting for a task to finish.

### When to Use CompletableFuture?
🚀 Fetching data from APIs or databases
🚀 Running multiple tasks in parallel
🚀 Avoiding blocking operations



