package packt.masteringkotlinbook.ch4.enums

import packt.masteringkotlinbook.ch4.enums.Day.*

enum class Day {
    MONDAY(1, "Monday"),
    TUESDAY(2, "Tuesday"),
    WEDNESDAY(3, "Wednesday"),
    THURSDAY(4, "Thursday"),
    FRIDAY(5, "Friday"),
    SATURDAY(6, "Saturday"),
    SUNDAY(7, "Sunday");

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
}

enum class DayAsAnonymousClass(val dayOfWeek: Int, val weekName: String) {
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


    abstract fun nextDay(): DayAsAnonymousClass
}

fun main(currentDay: Day) {
/*    when(currentDay){
        MONDAY -> TODO()
        TUESDAY -> TODO()
        WEDNESDAY -> TODO()
        THURSDAY -> TODO()
        FRIDAY -> TODO()
        SATURDAY -> TODO()
        SUNDAY -> TODO()
    }*/
    for (value in Day.values()){
        println(
            "Day ${value.dayOfWeek} -> ${value.weekName}"
        )
    }
/*
    for (value in DayAsAnonymousClass.values()) {

    }
*/
}