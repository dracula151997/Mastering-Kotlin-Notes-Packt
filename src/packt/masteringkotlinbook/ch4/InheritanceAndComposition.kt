package packt.masteringkotlinbook.ch4

import kotlin.random.Random

/**
 * Interfaces
 */
interface GameObject {
    val id: String
    fun update(currentTime: Long) {
        println("id: $id updated")
    }

}

interface Movable : GameObject {
    fun move(currentTime: Long)
}

interface Drawable {
    fun draw()
    fun update(currentTime: Long) {
        println("$this drawable updated")
    }
}

class Player : Movable, Drawable {
    override fun move(currentTime: Long) {
        println("Player #$id move")
    }

    override val id: String
        get() = Random.nextInt(500).toString()

    override fun update(currentTime: Long) {
        super<Movable>.update(currentTime)
        super<Drawable>.update(currentTime)
    }

    override fun draw() {
        println("Player #$id draw")
    }


}

/**
 * Subclasses and abstract classes
 */
interface Shape {
    fun getArea(): Int
    fun printArea()
}

//abstract class Rectangle : Shape

/**
 * Classes in Kotlin are closed by default(final) so you must use open keyword
 * to indicate the compiler that this class is open for extension
 */
open class Rectangle(
    val width: Int,
    val height: Int
) : Shape {

    /**
     * Methods in kotlin are closed by default (final methods). Means that the subclasses cannot override this method.
     * By using open keyword, you can override this method in the subclasses
     */
    open fun printToString() {
        println(this)
    }

    /**
     * Once a method has been overridden, it is open by default.
     */
    override fun printArea() = println("Area = ${getArea()}")

    /**
     * By using final keyword for overridden method prevents the future modification of getArea method
     * since any subclass will have its area calculated the same way
     *
     * So you cannot override getArea in subclasses because it is final and cannot be overridden.
     */
    final override fun getArea(): Int {
        return width * height
    }


}

class Square(edgeLength: Int) : Rectangle(edgeLength, edgeLength) {
    override fun printArea() {
        println("Square Area = ${getArea()}")
    }

    override fun printToString() {
        println(this)
    }
}

/**
 * Understanding the Nested classes
 *
 * Nested classes in Kotlin is a class defined within another class.
 * By default, it is not an inner class, meaning it cannot reference the outer class and cannot access to its properties
 */
class Outer {
    val outerValue = "a"

    /**
     * Under the hood, this nested class is a static class
     * and therefore cannot access members of the outer class.
     */
    /*  class Nested1 {
          val c = outerValue //compile error because the class isn't inner class
      }*/

    /**
     * By using inner keyword, the nested class is no longer static, and it can reference the outer class
     */
    inner class Nested2 {
        val c = outerValue
    }
}

/**
 * Understanding delegation
 */
fun main() {
//    val player = Player()
//    player.update(1000)
//    player.draw()
//    player.move(1000)
    val square = Square(50)
    square.printArea()
}

