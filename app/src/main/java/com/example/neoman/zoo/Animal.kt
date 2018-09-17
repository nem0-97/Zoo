package com.example.neoman.zoo

class Animal{
    var name:String?=null
    var desc:String?=null
    var pic:Int?=null
    var predator:Boolean=false

    constructor(name:String,desc:String,pic:Int,predator:Boolean){
        this.name=name
        this.pic=pic
        this.desc=desc
        this.predator=predator
    }
}