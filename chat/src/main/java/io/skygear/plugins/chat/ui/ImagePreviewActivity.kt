package io.skygear.plugins.chat.ui

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.ImageView
import com.squareup.picasso.Picasso

import io.skygear.plugins.chat.R
import android.view.MenuItem


class ImagePreviewActivity : AppCompatActivity() {

    companion object {
        val ImageURLIntentKey = "IMAGE_URL"

        fun newIntent(context: Context, imageURL: String): Intent {
            val intent = Intent(context, ImagePreviewActivity::class.java)
            intent.putExtra(ImageURLIntentKey, imageURL)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_preview)

        setTitle("")

        val photoView = findViewById(R.id.iv_photo) as ImageView

        var url = intent.getStringExtra(ImageURLIntentKey)

        Picasso.with(this)
                .load(url)
                .into(photoView)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.image_preview, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.close -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
