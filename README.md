# Java 8 & Above Interview Coding Questions

### 1. What are the key features of Java 8?

Java 8 introduced several new features, including:

✅ Lambda Expressions – Enables functional programming

✅ Functional Interfaces – Single abstract method interfaces

✅ Streams API – Process collections in a functional way

✅ Default & Static Methods in Interfaces – Method implementation inside interfaces

✅ Optional Class – Avoids NullPointerException

✅ New Date and Time API – LocalDate, LocalTime, LocalDateTime

✅ Collectors and Functional Interfaces – Collectors.toList(), Predicate, Consumer

### DATE TIME API

1. Immutability & Thread Safety
✅ New API (java.time): Immutable and thread-safe.
❌ Old API (java.util.Date, Calendar): Mutable and not thread-safe.

2. Package & Class Structure
✅ New API: Introduced in java.time package (LocalDate, LocalTime, LocalDateTime, ZonedDateTime).
❌ Old API: Used java.util and java.sql (Date, Calendar, TimeZone), which were confusing and inconsistent.

3. Clearer API Design
✅ New API: Months start at 1 (January = 1).
❌ Old API: Months start at 0 (January = 0), which often led to confusion.

4. Better Time Zone Handling
✅ New API: Uses ZoneId and ZonedDateTime, providing robust time zone support.
❌ Old API: Used TimeZone, which had limited capabilities and required manual conversions.

5. Improved Date Formatting & Parsing
✅ New API: Uses DateTimeFormatter (thread-safe and easy to use).
❌ Old API: Used SimpleDateFormat (not thread-safe, required synchronization).

6. Built-in Support for Durations and Periods
✅ New API: Provides Duration (time-based) and Period (date-based) classes for date-time differences.
❌ Old API: Required manual date difference calculations, making it error-prone.

7. Fluent API for Date Manipulation
✅ New API: Uses methods like .plusDays(), .minusWeeks(), .withDayOfMonth().
❌ Old API: Required modifying Calendar fields manually (add(), set()).

8. LocalDate and LocalTime Separation
✅ New API: Clearly separates date (LocalDate), time (LocalTime), and both (LocalDateTime).
❌ Old API: java.util.Date included both date and time, leading to confusion.

9. Handling of Leap Years & DST Adjustments
✅ New API: Properly handles leap years and Daylight Saving Time (DST) changes.
❌ Old API: Required manual handling of leap years and DST.

10. More Readable and Expressive Code
✅ New API: Uses clear and expressive method names (LocalDate.of(2024, 3, 25)).
❌ Old API: Required cumbersome and unintuitive code (Calendar.set(Calendar.MONTH, 2)).





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

### 🔹 Core Difference Between map and flatmap

 map()- transforms elements
 flatMap()- transforms AND flattens nested structures

### Records

Java records are immutable data carrier classes that reduce boilerplate code by automatically generating constructors, accessors, equals, hashCode, and toString.

a) Records are final

b) Fields are implicitly final

c) Cannot extend other classes

d) Can implement interfaces

e) Introduced in Java 16 (preview in 14)

## ✨ With Record Java automatically generates

public record Employee(String name, int age) { }


Java automatically generates:

✅ Constructor

✅ Getters

✅ equals()

✅ hashCode()

✅ toString()


## 🧾 Create a Java Record

Example: Country
```
public record Country(String name, String capital, int population) {
}
```
That’s the entire class.

## 🔹 How to use this Record
```
public class TestRecord {
    public static void main(String[] args) {

        Country country = new Country("India", "New Delhi", 140);

        System.out.println(country.name());
        System.out.println(country.capital());
        System.out.println(country.population());

        System.out.println(country);
    }
}
```

##  What methods does Java generate automatically?

For this record:
```
public record Country(String name, String capital, int population) { }
```

Java generates the following:-

#### 1️⃣ Canonical Constructor
```
public Country(String name, String capital, int population) {
    this.name = name;
    this.capital = capital;
    this.population = population;
}
```
📌 Used when you do:

new Country("India", "New Delhi", 140);

#### 2️⃣ Accessor Methods (NOT getters)
```
public String name() { return name; }
public String capital() { return capital; }
public int population() { return population; }
```


##### ⚠️ Important:-

❌ getName()

✅ name()

#### 3️⃣ equals() Method
```
@Override
public boolean equals(Object o) {
    // compares all components: name, capital, population
}
```

📌 Two records are equal if all fields are equal

#### 4️⃣ hashCode() Method
```
@Override
public int hashCode() {
    // based on name, capital, population
}
```


📌 Makes records perfect for:

HashMap keys

HashSet elements


#### 5️⃣ toString() Method
Country[name=India, capital=New Delhi, population=140]


Automatically generated format.

🔒 Other Things Java Enforces Automatically

Fields are:

private final String name;
private final String capital;
private final int population;


Record class is:

public final class Country


❌ No setters allowed


## What is a Virtual Thread?
Virtual threads are lightweight threads introduced as a stable feature in Java 21 under Project Loom (JEP 444). They are managed by the JVM rather than the operating system.

The Problem They Solve
Traditional platform threads are expensive — each one consumes ~1MB of stack memory and requires an OS syscall to create. In high-concurrency apps (e.g., a server handling 10,000 requests), this becomes a bottleneck fast.
The old workaround was reactive/async programming (CompletableFuture, WebFlux), which works but makes code complex and hard to debug.
Virtual threads solve this without sacrificing simplicity.

How They Work

The JVM maintains a pool of carrier threads (platform threads, usually = CPU cores)
Virtual threads are mounted onto a carrier thread to execute
When a virtual thread blocks (e.g., waiting for a DB response), the JVM unmounts it and lets the carrier thread run another virtual thread
When the block resolves, the virtual thread gets remounted and continues

This means thousands of virtual threads can share just a handful of carrier threads.

[ Virtual Thread 1 ] ──┐
[ Virtual Thread 2 ] ──┼──► [ Carrier Thread 1 (OS Thread) ] ──► CPU Core 1
[ Virtual Thread 3 ] ──┘

[ Virtual Thread 4 ] ──┐
[ Virtual Thread 5 ] ──┼──► [ Carrier Thread 2 (OS Thread) ] ──► CPU Core 2
[ Virtual Thread 6 ] ──┘

## Key Differences

| Aspect | Virtual Thread | Carrier Thread |
|------|------|------|
| **Definition** | Lightweight JVM-managed thread | OS-backed platform thread hosting virtual threads |
| **Creation Cost** | Extremely low (nanoseconds) | High (involves OS syscall) |
| **Memory Footprint** | Small (a few KB, grows as needed) | Large (≈ 1 MB stack by default) |
| **Quantity** | Millions possible | Limited (usually ≈ number of CPU cores) |
| **Blocking Behavior** | Unmounts from carrier thread when blocked | Blocks the OS thread entirely |
| **Scheduling** | JVM scheduler (cooperative) | OS scheduler (preemptive) |
| **Use Case** | I/O-bound, high-concurrency tasks | CPU-bound tasks, runs virtual threads |
| **Created By** | Developer / application code | JVM internally (ForkJoinPool) |
| **Thread Identity** | `Thread.isVirtual()` returns `true` | `Thread.isVirtual()` returns `false` |
| **Pinning Risk** | Can get pinned to carrier when using `synchronized` | Not applicable |


## . Records (

Records reduce boilerplate code.

Before:
```
class User {
    private String name;
    private int age;
}
```

After:
```
record User(String name, int age) {}
```

***Automatically generates:-***

constructor

getters

equals

hashCode

toString
## Helpful NullPointerException

Java shows exact variable causing null.

Before:

NullPointerException

After:

Cannot invoke "user.getName()" because "user" is null

## Sealed Classes (Introduced in Java 17)

A Sealed Class is a class that restricts which other classes can extend or implement it.

Normally in Java, any class can extend a public class.
But with sealed classes, the parent class controls which subclasses are allowed.

This gives better control over inheritance.

