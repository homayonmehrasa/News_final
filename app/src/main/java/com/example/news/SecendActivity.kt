package com.example.news

import android.graphics.drawable.Drawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.news.databinding.ActivitySecendBinding
import com.google.android.material.appbar.CollapsingToolbarLayout

class SecendActivity : AppCompatActivity() {


     lateinit var binding : ActivitySecendBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecendBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        supportPostponeEnterTransition()
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val collapsingToolbar = findViewById<CollapsingToolbarLayout>(R.id.toolbar_layout)
        collapsingToolbar.isTitleEnabled = false
        collapsingToolbar.setExpandedTitleTextAppearance(R.style.test)

        val mydescription = intent.getStringExtra("desc")
        binding.secdesc.text =mydescription
        val mytitile = intent.getStringExtra( "title")
        binding.sectitle.text = mytitile
        val img = intent.getStringExtra("img")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            binding.myimg.transitionName = img
        }
        Glide.with(this).load(img).into(binding.imgToolbar!!)
        Glide.with(this).load(img).addListener(object:RequestListener<Drawable?>{
            override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable?>?, isFirstResource: Boolean): Boolean {
                supportStartPostponedEnterTransition()
                return false
            }

            override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable?>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                supportStartPostponedEnterTransition()
                return false
            }

        }).into(binding.myimg)


    }
}