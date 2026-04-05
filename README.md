Topics:-

- [Virtual Threads](#what-is-a-virtual-thread) 
- [Sealed Classes](#sealed-classes) 
- [Records](#records) 
- [CompletableFuture](#completablefuture)
- [Java 17 Features](#java-17-features)
- [Switch Expression Improvement](#switch-expression-improvement)
- [Lombok vs Records](#difference-between-lombok-and-records)
- [What is Optional?](#optional)







## Difference Between Lombok and Records

| Feature         | Lombok                     | Records                  |
| --------------- | -------------------------- | ------------------------ |
| Type            | Library                    | Java language feature    |
| Mutability      | Mutable by default         | Immutable                |
| Dependency      | Requires Lombok dependency | No dependency            |
| Code generation | Annotation processing      | Built into Java compiler |
| Flexibility     | Very flexible              | Limited structure        |
| Java version    | Works with Java 8+         | Java 16+                 |




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

## Optional

Optional is a container object that may contain a value or may be empty.

Instead of writing:
```
String name = getName();
if(name != null){
    System.out.println(name);
}

We use:

Optional<String> name = getName();
name.ifPresent(System.out::println);
```

a) **Optional.of()**

Creates Optional with a non-null value.

If value is null → NullPointerException    
b) **Optional.ofNullable()**

Handles null safely.



| Method        | Purpose                    |
| ------------- | -------------------------- |
| empty()       | create empty optional      |
| of()          | create optional with value |
| ofNullable()  | handle null safely         |
| isPresent()   | check value                |
| get()         | retrieve value             |
| ifPresent()   | execute if value exists    |
| orElse()      | default value              |
| orElseGet()   | lazy default value         |
| orElseThrow() | throw exception            |
| map()         | transform value            |
| flatMap()     | avoid nested optional      |
| filter()      | conditional filtering      |




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

### CompletableFuture? 🤔
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

## Java 21 Features

a) Virtual Threads    
b) Structured Concurrency (Preview)    
c) Scoped Values (Preview)    
d) Sequenced Collections    
e) Pattern Matching for Switch (Final)    
f) Record Patterns (Final)    
g) Unnamed Patterns and Variables (Preview)    
h) String Templates (Preview)    
i) Foreign Function & Memory API (Final)    
j) Vector API (Sixth Incubator)    
k) Key Encapsulation Mechanism (KEM) API    
l) Deprecation of Windows 32-bit x86 Port    
m) Garbage Collector Improvements (ZGC, G1)    






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
Virtual threads are lightweight threads introduced as a stable feature in Java 21 under Project Loom. They are managed by the JVM rather than the operating system.

## The Problem They Solve
Traditional platform threads are expensive — each one consumes ~1MB of stack memory and requires an OS syscall to create. In high-concurrency apps (e.g., a server handling 10,000 requests), this becomes a bottleneck fast.
The old workaround was reactive/async programming (CompletableFuture, WebFlux), which works but makes code complex and hard to debug.
Virtual threads solve this without sacrificing simplicity.

##  How Virtual Thread Scheduling Works

Steps:

Step-by-step:-
a) Virtual thread starts running
b) JVM mounts it on a carrier thread (platform thread)
c) It executes normally
d) Blocking call happens (sleep, I/O, DB, HTTP, etc.)
e) JVM does:
Un-mounts (parks) the virtual thread
Saves its state (stack, progress)
Carrier thread becomes free
→ Picks up another virtual thread
f) When blocking operation completes:
The same virtual thread becomes runnable again
g)JVM schedules it:
It gets any available carrier thread (not necessarily same one)
It resumes exactly from where it stopped

This is why virtual threads scale extremely well.

## Creating Virtual Threads
Method 1 (Simple)
```
Thread.startVirtualThread(() -> {
    System.out.println("Running virtual thread");
});
```

Method 2 (Executor Service)
```
ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();

executor.submit(() -> {
    System.out.println("Task running in virtual thread");
});
```
## Example with Multiple Tasks
```
import java.util.concurrent.*;

public class VirtualThreadExample {

    public static void main(String[] args) throws Exception {

        ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();

        for(int i=1;i<=5;i++){
            int task=i;
            executor.submit(() -> {
                System.out.println("Task "+task+" running in "+Thread.currentThread());
                Thread.sleep(1000);
                return null;
            });
        }

        executor.shutdown();
    }
}
```

## When to Use Virtual Threads

Best for:

✔ Web servers
✔ Microservices
✔ API calls
✔ Database queries
✔ I/O heavy workloads

Example:

Spring Boot APIs
HTTP calls
DB queries
File operations

 ## When NOT to Use Virtual Threads

Not useful for:

❌ CPU heavy tasks
❌ Parallel computation

Use:

ForkJoinPool
Parallel Streams
CompletableFuture

## Virtual Thread Example with Spring Boot
Spring Boot can run each request on a virtual thread.
 ```
spring.threads.virtual.enabled=true
```

Now:

1 API request = 1 virtual thread

This allows millions of concurrent requests.

## Why JVM Stores Them in Heap

Because virtual threads must support suspension.

Example:

Thread.sleep(1000);

What happens:

1. JVM pauses virtual thread
2. Saves stack frames in heap
3. Releases carrier thread
4. Later resumes execution

This is called continuation.

## Mount / Unmount Mechanism

When a virtual thread runs:

Virtual Thread
      ↓
Mounted on Carrier Thread
      ↓
Executed on CPU

When it blocks:

Virtual Thread
      ↓
Unmounted from carrier thread
      ↓
Stack stored in heap

Carrier thread becomes free.

##  Scheduling Happens

Virtual threads are scheduled by the JVM scheduler, not the OS.

Internally they are stored in a ForkJoinPool queue.

Architecture:

Virtual Thread
      ↓
JVM Scheduler
      ↓
ForkJoinPool Queue
      ↓
Carrier Thread (Platform Thread)
      ↓
CPU
## How They Work?

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


##  Records (

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

## Sealed Classes

A Sealed Class is a class that restricts which other classes can extend or implement it.

Normally in Java, any class can extend a public class.
But with sealed classes, the parent class controls which subclasses are allowed.

This gives better control over inheritance.

## Java 17 Features
Java 17 is a Long-Term Support (LTS) release (released in September 2021). Many companies upgraded from Java 8/11 to Java 17 because it introduces performance improvements, new language features, and security enhancements.

Below are the most important Java 17 features (especially relevant for interviews).

**1️⃣ Sealed Classes**

Sealed classes allow you to restrict which classes can extend or implement a class/interface.

This gives better control over inheritance.

Example
```
public sealed class Shape
    permits Circle, Rectangle {
}
```

Only these classes can extend Shape.
```
final class Circle extends Shape { }

final class Rectangle extends Shape { }
```
**Benefits**

a)Better domain modeling

b)More secure inheritance

c)Works well with pattern matching

**2️⃣ Pattern Matching for instanceof**

Before Java 17, type casting was required.

Before
```
if (obj instanceof String) {
    String s = (String) obj;
    System.out.println(s.length());
}
```
Java 17
```
if (obj instanceof String s) {
    System.out.println(s.length());
}
```

No explicit casting required.

**Benefits:**

Cleaner code

Less boilerplate

**3️⃣ Records (Standardized)**

Records were introduced earlier but fully standardized in Java 16/17.

Records are used to create immutable data classes with less code.

Example
```
public record User(String name, int age) {}
```

Compiler automatically generates:

constructor

getters

equals()

hashCode()

toString()

Equivalent traditional class:
```
class User {
   private final String name;
   private final int age;
}
```

Much more boilerplate.

**4️⃣ Switch Expression Improvements**

Switch statements are now more concise.

Old switch
```
switch(day) {
 case MONDAY:
 case TUESDAY:
     result = "Weekday";
     break;
}
```
Java 17 switch expression
```
String result = switch(day) {
    case MONDAY, TUESDAY -> "Weekday";
    case SATURDAY, SUNDAY -> "Weekend";
};
```
**Benefits:**

Less boilerplate

Safer

Returns values directly

Java 17 includes enhancements to the switch statement, mainly making it more concise, safer, and expressive. These improvements started in Java 12–14 and became standard by Java 17.

**There are two major improvements:**

a) Switch Expressions

b) Arrow (->) syntax

**1️⃣ Problem with Old Switch (Before Java 14)**

The traditional switch had problems:

Required break statements

Risk of fall-through bugs

Verbose syntax

Old Switch Example
int day = 2;
String result;
```
switch(day) {
    case 1:
        result = "Monday";
        break;
    case 2:
        result = "Tuesday";
        break;
    default:
        result = "Invalid";
}
```

Problems:

Forgetting break causes bugs.

Example bug:
```

case 1:
    result = "Monday";
case 2:
    result = "Tuesday";
```

Output becomes Tuesday due to fall-through.

**2️⃣ Switch Expression (Java 17)**

Now switch can return values directly.

Example
int day = 2;

String result = switch(day) {
    case 1 -> "Monday";
    case 2 -> "Tuesday";
    default -> "Invalid";
};

System.out.println(result);

Benefits:

No break

No fall-through

Cleaner syntax

**3️⃣ Multiple Labels in One Case**

You can combine cases easily.

Example
```
int day = 6;

String type = switch(day) {
    case 1,2,3,4,5 -> "Weekday";
    case 6,7 -> "Weekend";
    default -> "Invalid";
};
```

Output:

Weekend
**4️⃣ Using Block Logic in Switch**

If logic is complex, use {} with yield.

Example
```
int num = 5;

String result = switch(num) {
    case 1 -> "One";

    case 5 -> {
        System.out.println("Processing number 5");
        yield "Five";
    }

    default -> "Unknown";
};
```

yield returns value from the switch block.

**5️⃣ Switch Works with Strings**

Java 17 switch works nicely with strings.
```
String role = "ADMIN";

String access = switch(role) {
    case "ADMIN" -> "Full Access";
    case "USER" -> "Limited Access";
    default -> "No Access";
};
```
**6️⃣ Comparison (Old vs New)**
Feature	Old Switch	Java 17 Switch
Break required	Yes	No
Fall-through risk	Yes	No
Returns value	No	Yes
Multiple labels	Hard	Easy
Syntax	Verbose	Concise
**7️⃣ Real Backend Example**

Example role-based access:
```
String role = "ADMIN";

String permission = switch(role) {
    case "ADMIN" -> "ALL_PERMISSIONS";
    case "MANAGER" -> "LIMITED_PERMISSIONS";
    case "USER" -> "BASIC_ACCESS";
    default -> "NO_ACCESS";
};
```
🧠 Best Interview Answer

You can say:

Java 17 enhanced switch statements by introducing switch expressions and arrow syntax. The new switch allows returning values directly, eliminates the need for break statements, prevents fall-through errors, and supports multiple case labels. It makes switch statements more concise and readable.




**5️⃣ Text Blocks**

Text blocks allow writing multi-line strings easily.

Example
```
String json = """
{
   "name": "Priyanka",
   "role": "Engineer"
}
""";
```

Before Java 17:
```
String json = "{\n" +
              "\"name\":\"Priyanka\"\n" +
              "}";
```

Much cleaner now.

**6️⃣ New Random Number Generator API**

Java 17 introduced new random generator interfaces.

Example:
```
RandomGenerator generator = RandomGenerator.getDefault();
System.out.println(generator.nextInt());
```

Benefits:

Better randomness algorithms

Improved performance

**7️⃣ Strong Encapsulation of JDK Internals**

Java 17 strongly encapsulates internal JDK APIs.

This improves:

security

maintainability

modularity

Example:

Accessing internal APIs like:

sun.misc.Unsafe

is restricted.

8️⃣ Foreign Function & Memory API (Incubator)

Allows Java programs to interact with native memory and external libraries without JNI.

Example use cases:

calling C libraries

working with off-heap memory

9️⃣ Deprecation and Removal

Java 17 removed or deprecated some old APIs:

Examples:

Applet API deprecated

Security manager deprecated

1️⃣0️⃣ Performance Improvements

Java 17 also improved:

Garbage collectors

JVM performance

Startup time

Memory management

Examples:

ZGC improvements

G1GC improvements

