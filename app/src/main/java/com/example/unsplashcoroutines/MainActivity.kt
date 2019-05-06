package com.example.unsplashcoroutines

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.unsplashcoroutines.BigImale.BigImageActivity
import com.example.unsplashcoroutines.PhotosFragment.PhotosFragment
import org.koin.standalone.KoinComponent


class MainActivity : AppCompatActivity(), KoinComponent {


    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ac_main)

//        val photosViewModel:PhotosViewModel by inject()

        changeFragment(PhotosFragment.newInstanse())
    }


    fun changeFragment(fragment: Fragment) {
        var fm: FragmentManager = supportFragmentManager
        fm.beginTransaction()
            .replace(R.id.container, fragment)
            .commitNow()
    }

    fun openBigImage(url: String,imageView: ImageView){
        //open image detail activity with shared element transition
        val intent = Intent(this, BigImageActivity::class.java)
        intent.putExtra("url",url)
        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
            this,
            imageView,
            ViewCompat.getTransitionName(imageView).toString()
        )
        startActivity(intent,options.toBundle())
    }

}
