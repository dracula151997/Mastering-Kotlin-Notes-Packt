package packt.masteringkotlinbook.ch4.data_classes

/**
 * What is a Data class?
 * Fundamentally, Data Class is a simple class that is used to hold data or state, and includes standard functionality.
 * It refers to a class, which contains only fields and crude methods for accessing them (getters and setters).
 * By data keyword, you can create a data class
 *
 *
 * Data classes rules:
 * 1.It's a primary constructor with at least one parameter.
 * 2.It cannot be a sealed class, open, inner, or abstract.
 * 3.Each parameter of the primary constructor must indicate as val or var.
 * It can inherit another class, and it can implement an interface.
 *
 * Look at the following example for Java data class
 * <insert the java data class img>
 *
 * We can rewrite the above example in kotlin with single line of code
 *
 * The best thing about data classes is that they generate copy(), equals(), hashCode(), and toString() automatically.
 *
 * Data class includes the following built-in functions:
 * equals(): Boolean
 * hashCode(): Int
 * toString(): String
 * copy()
 * componentN()
 *
 * Note: Primary constructor properties will be included in the generated implementations of copy(), equals(), hashCode(), and toString().
 *
 * To compare whether two objects are structurally the same, the equivalent of calling .equals(), use ==. To check whether two variables point to the same object, use ===.
 *
 */
data class Article(val title: String, val author: String){
    /**
     * A data class may also contain properties that are not defined in the primary constructor.
     * Data class properties not defined in the primary constructor will not be included in compiler-generated methods, which we will examine in the next section.
     *
     *
     * This property will not be included in compiler-generated methods.
     */
    var snippet: String = ""
}

fun main(args: Array<String>) {
    val article1 = Article("Kotlin is great", "Nate")
    val article2 = Article("Kotlin is great", "Nate")

    article1.snippet = "an article about Kotlin"
    article2.snippet = "a Kotlin article"

    /**
     * equals():
     * It compares the title and author properties of the primary constructor only ,but does not compare the snippet property.
     *
     * If title and author are the same but snippet is different, a structural comparison of the two objects using == will return true
     *
     * Note: If relying on the structural comparison of data classes, it's important to include all relevant properties in the primary constructor,
     * or you'll have to override equals() and hashCode() as you would for any other class.
     *
     * toString()
     * A data class will also generate an implementation of toString() if one is not already provided.
     *
     * This is useful for debugging or output, but if you require all properties to be included,
     * you will have to ensure that all properties are present in the primary constructor or override toString() on your own.
     *
     * copy()
     * It can be used to copy a data class.
     * We can use named arguments to modify specific properties on the copied class.
     * It is used to create a copy or colon of an object in the data class. So, you can be able to modify some or all properties of an object.
     * It is suggested to apply val parameters in a data classes constructor in order to use immutable properties of an object.
     * Note: Immutable objects are easier when you want to work with multithreaded applications.
     */
    if (article1 == article2) {
        println("They are the same")
    }

    val (title, author) = article1

    println(article1.toString())
}
