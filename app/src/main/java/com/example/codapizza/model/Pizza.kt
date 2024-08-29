package com.example.codapizza.model

data class Pizza(
    val toppings: Map<Topping, ToppingPosition> = emptyMap()
){
    fun withTopping(topping: Topping, placement: ToppingPosition?): Pizza {
        return copy(
            toppings = if (placement == null) {
                toppings - topping
            } else {
                toppings + (topping to placement)
            }
        )
    }
}
