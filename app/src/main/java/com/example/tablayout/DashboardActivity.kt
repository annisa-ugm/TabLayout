package com.example.tablayout

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.tablayout.databinding.ActivityDashboardBinding

class DashboardActivity : AppCompatActivity() {
    private var nameFromLogin: String? = null
    private var emailFromLogin: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        nameFromLogin = intent.getStringExtra("name")
        emailFromLogin = intent.getStringExtra("email")


        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.dashboard_options, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.icon_user -> {
                val intent = Intent(this, ProfileActivity::class.java)
                intent.putExtra("name", nameFromLogin)
                intent.putExtra("email", emailFromLogin)
                startActivity(intent)
                true
            }
            R.id.icon_logout -> {
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("target_tab", 0)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
