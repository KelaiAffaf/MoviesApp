
package com.example.tp7

import com.google.gson.annotations.SerializedName



data class  Actor (

     @SerializedName("firstname") val firstname:String ,
     @SerializedName("lastname") val lastname:String,
     @SerializedName("gender")val gender:String)