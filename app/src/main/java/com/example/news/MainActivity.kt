package com.example.news

import android.annotation.SuppressLint
import android.app.ActivityOptions
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = arrayListOf <Mysources>( )

        val callback : Call<MyItem> = ApiClient().getClient().create(ApiService::class.java).getItem("us")
        callback.enqueue(object : Callback<MyItem>{
            override fun onFailure(p0: Call<MyItem>, p1: Throwable) {
                Toast.makeText(this@MainActivity, "error" ,Toast.LENGTH_LONG).show()
            }

            @SuppressLint("CutPasteId")
            override fun onResponse(p0: Call<MyItem>, p1: Response<MyItem>) {
                if(p1.isSuccessful){

                    val body=p1.body()
                     (if (body != null) {

                         list.addAll(body.articles)


                         val testadapter = MyAdapter(list)
                         findViewById<RecyclerView>(R.id.myrecyclerview).adapter= testadapter
                         findViewById<RecyclerView>(R.id.myrecyclerview).layoutManager= LinearLayoutManager(this@MainActivity )

                         testadapter.setOnItemClickListener(object :  MyAdapter.ClickListener {
                             @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
                             override fun onItemClick(v: View, position: Int) {
                                 val rv = findViewById<RecyclerView>(R.id.myrecyclerview)

                                 val myintent = Intent ( this@MainActivity, SecendActivity::class.java )
                                 myintent.putExtra("desc" , list[position].description)
                                 myintent.putExtra("title" , list[position].title)
                                 myintent.putExtra("img" , list[position].urlToImage)
                                 val sharedImage = v.findViewById<ImageView>(R.id.newsimageView)
                                 startActivity(myintent
                                         , ActivityOptions.makeSceneTransitionAnimation(this@MainActivity
                                         ,sharedImage,
                                         list[position].urlToImage
                                         ).toBundle())

                             }

                         })

                            })

                }else{

                }

            }

        })



    }
}

