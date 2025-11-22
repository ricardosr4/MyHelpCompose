package com.example.myhelpcompose.practice.roadmap

import org.junit.Test

class VarVal {
    @Test
    fun variablesConstants(){

        //la palabras declaradas con var son de tipo mutable y pueden ser modificadas
        var name: String = "Richard"
        var age: Int = 33

        println("mi nombre es $name y mi edad es de $age años")

        name = "Ricardo"
        age = 35

        println("En realidad me llamo $name y la verdad es que tengo $age años")


        //la palabras declaradas con val son de tipo inmutable y no se pueden modificar

    }
}