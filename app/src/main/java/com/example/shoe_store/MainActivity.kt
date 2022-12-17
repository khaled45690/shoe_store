package com.example.shoe_store

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.shoe_store.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val navController = findNavController(R.id.nav_host_fragment_activity_main)

        // this app configuration to prevent the back button from appearing
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.loginFragment, R.id.fragmentWelcome, R.id.shoeListFragment , R.id.addShoe , R.id.instructionFragment
            )
        )

        setupActionBarWithNavController(navController , appBarConfiguration)
    }
}