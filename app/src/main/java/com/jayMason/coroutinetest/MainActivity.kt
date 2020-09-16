package com.jayMason.coroutinetest

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity()
{
	override fun onCreate(savedInstanceState: Bundle?)
	{
		setTheme(R.style.AppTheme)
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)


		val mainLooper = mainLooper // Looper.getMainLooper

		GlobalScope.launch (context = Dispatchers.IO){
			val imageUrl = URL("https://wallpaperplay.com/walls/full/1/c/7/38027.jpg")
			val connection = imageUrl.openConnection() as HttpURLConnection
			connection.doInput = true
			connection.connect()

			val inputStream = connection.inputStream
			val bitmap = BitmapFactory.decodeStream(inputStream)

				launch { mainImage.setImageBitmap(bitmap) }
		}
	}

}