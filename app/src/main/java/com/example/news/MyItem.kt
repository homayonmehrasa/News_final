package com.example.news

import android.annotation.SuppressLint
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

data class MyItem (val status : String, val articles :List<Mysources>) {

}
data class Mysources ( val title :String , val description : String , val urlToImage : String , val publishedAt : String){


    @SuppressLint("SimpleDateFormat" )
    fun getstringdate (): Date {


        val formatter: DateFormat = SimpleDateFormat("yyyy-MM-dd")
        val mydate: Date = formatter.parse(publishedAt) as Date
        return mydate



    }


}