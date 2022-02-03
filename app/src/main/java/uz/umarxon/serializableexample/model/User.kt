package uz.umarxon.serializableexample.model

import java.io.Serializable

class User :Serializable{
    var name:String? = null
    var number:String? = null

    constructor(name: String?, number: String?) {
        this.name = name
        this.number = number
    }

    constructor()
}