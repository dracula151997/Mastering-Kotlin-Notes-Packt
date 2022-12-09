## Chapter[4]

### Enums and Sealed classes

## Enums

A useful feature while programming is having the ability to indicate that a variable only has a _finite set of possible
values._ To accomplish this, most programming languages introduced the concept of **enumerations**.
Although enumerations usually represent just a mere named list of _predefined constant values_, Kotlin enums are much
more than that.

Enums in Kotlin are **real classes**, and not simple types or limited data structured. They can have **custom properties
and methods, implement interfaces, use anonymous classes** and much more.

### Defining enums

* Kotlin enum classes is to treat them as collections of constants.

```enum class Day {
    MONDAY, 
    TUESDAY,
    WEDNESDAY, 
    THURSDAY, 
    FRIDAY, 
    SATURDAY,
    SUNDAY
}
```

> Enum's names should always be in **UPPERCASE** letters.

### Initializing enums

* Kotlin enums are _classes_, which means that they can have **one or more constructors.**
* You can initialize enum constants by passing the values required to one of the valid constructors.

```
enum class Day(val dayOfWeek: Int) {  
    MONDAY(1), 
    TUESDAY(2),
    WEDNESDAY(3), 
    THURSDAY(4), 
    FRIDAY(5), 
    SATURDAY(6),
    SUNDAY(7)
}
```

> Usually, the constructor-based approach is used to provide enum constants with useful information or meaningful
> values.

### Enums build-in functions

* `ordinal`: allows you to retrieve where the current enum constant appears in the list.

> Enum's list is zero-based index, which means that the first constant in the enum list has value 0, and so on.

* `name`: returns the name of enum constant as a string.

```
fun main() {  
    for (day in DAY.values())
        println("[${day.ordinal}] -> ${day.name} (${day.dayOfWeek}^ day of the week)")
}
```

By running this code, you would get the following result:

```
[0] -> MONDAY (1^ day of the week)
[1] -> TUESDAY (2^ day of the week)
[2] -> WEDNESDAY (3^ day of the week)
[3] -> THURSDAY (4^ day of the week)
[4] -> FRIDAY (5^ day of the week)
[5] -> SATURDAY (6^ day of the week)
[6] -> SUNDAY (7^ day of the week)
```

## Advanced Features of Kotlin Enums

### Adding custom properties and methods

* In particular, methods and properties must be added _**below**_ the enum constants definition, after a semicolon.
* You can provide them with a default  value
* It can have both _instance_ and _static methods_

  ```
  enum class Day {
    MONDAY(1, "Monday"),
    TUESDAY(2, "Tuesday"),
    WEDNESDAY(3, "Wednesday"),
    THURSDAY(4, "Thursday"),
    FRIDAY(5, "Friday"),
    SATURDAY(6, "Saturday"),
    SUNDAY(7, "Sunday"); //end of the constants

    var dayOfWeek: Int? = null
    var weekName: String? = null

    constructor()

    // Custom constructor
    constructor(dayOfWeek: Int?, weekName: String?) {
        this.dayOfWeek = dayOfWeek
        this.weekName = weekName
    }

    //Custom method
    fun printDay(): String {
        return "$dayOfWeek -> $weekName"
    }

    companion object {
       fun getNumberOfDays() = values().size
    }
  ```

}


> Properties and methods can be accessed through _instances_, which are the enum constants.
`Day.MONDAY.dayOfWeek` `Day.MONDAY.printDay()` `Day.getNumberOfDays()`

> Methods defined inside companion objects do not depend on specific instances and be accessed statically.

### Using anonymous classes to define enum constants

* In Kotlin, You can create anonymous classes to define specific enum constants. 
* Each enum constant is instantiated by declaring its own anonymous classes while overriding the required abstract method.

```
enum class Day(val dayOfWeek: Int, val weekName: String) {
    MONDAY(1, "Monday") {
        override fun nextDay() = TUESDAY
    },
    TUESDAY(2, "Tuesday") {
        override fun nextDay() = WEDNESDAY
    },
    WEDNESDAY(3, "Wednesday") {
        override fun nextDay() = THURSDAY
    },
    THURSDAY(4, "Thursday") {
        override fun nextDay() = FRIDAY
    },
    FRIDAY(5, "Friday") {
        override fun nextDay() = SATURDAY
    },
    SATURDAY(6, "Saturday") {
        override fun nextDay() = SUNDAY
    },
    SUNDAY(7, "Sunday") {
        override fun nextDay() = MONDAY
    };


    abstract fun nextDay(): Day
}
```


