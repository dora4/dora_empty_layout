package dora.widget

import android.graphics.drawable.AnimationDrawable
import android.media.Image
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var emptyLayout: EmptyLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        emptyLayout = findViewById(R.id.emptyLayout)
        emptyLayout
                .onEmpty {
                    Toast.makeText(this@MainActivity, "onEmpty", Toast.LENGTH_SHORT).show()
                }
                .onError { e ->
                    val tvError = findViewById<TextView>(R.id.tvError)
                    tvError.text = e.message
                    Toast.makeText(this@MainActivity, "onError", Toast.LENGTH_SHORT).show()
                }
                .onLoading {
                    ((this as ImageView).drawable as AnimationDrawable).start()
                    Toast.makeText(this@MainActivity, "onLoading", Toast.LENGTH_SHORT).show()
                }
                .onRefresh {
                    Toast.makeText(this@MainActivity, "onRefresh", Toast.LENGTH_SHORT).show()
                }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_empty -> emptyLayout.showEmpty()
            R.id.menu_error -> emptyLayout.showError(Exception("网络不可用，请稍后重试"))
            R.id.menu_loading -> emptyLayout.showLoading()
            R.id.menu_content -> emptyLayout.showContent()
        }
        return true
    }
}