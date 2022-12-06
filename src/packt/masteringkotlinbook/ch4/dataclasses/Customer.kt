package packt.masteringkotlinbook.ch4.dataclasses

data class Customer(
    val name: String,
    val id: Int,
    val city: String,
)

fun main() {
    val customer1 = Customer("Customer 1", 10, "Egypt")
    val customer2 = Customer("Customer 2", 20, "Giza")

    /**
     * If name, id, and city are the same, it returns true otherwise, returns false
     */

    if (customer1 == customer2)
        println("Identical")
    else
        println("Not same")

}