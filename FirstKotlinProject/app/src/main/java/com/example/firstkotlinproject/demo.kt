package com.example.firstkotlinproject

import java.util.*

fun main(){
    var num1=123
        num1=8765  // change values in var keyword


    val msg="This is first kotlin app"
  //  msg ="This is new msg"     //cannot change in val keyword

    println(num1)
    println(msg)
    var x=26
    var y=12
    val check=x>y  // 26 > 12 =>true
    println("x > y ="+check)
    println("x > y = $check")

    //1st method
    println("enter your name :")
    val name= readLine()
    print(name)

    //2nd method
    val sc=Scanner(System.`in`)
    println("enter any number :")
    var number1:Int=sc.nextInt();
    println(number1)

//if(x>y){}
//else{}

            //1st method
    val arr1= arrayOf(1,2,3,4,5,6,"abc",14.653,'D',"xyz")
            //2nd method
     val arr2= arrayOf<Int>(1,2,3,4,5,6)
    val std= arrayOf<String>("Haris","Sana","Haider","Tooba","Naeem")

    println(arr1[6])
    println(std[3])

    //loop
    for (item in std){
        println(item)
    }

}