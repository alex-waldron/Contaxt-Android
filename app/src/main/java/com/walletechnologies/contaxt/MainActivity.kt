package com.walletechnologies.contaxt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.navigateUp
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration : AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val host: NavHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment? ?: return

        val inflater = host.navController.navInflater

        val graph = inflater.inflate(R.navigation.nav_graph)
        if (Firebase.auth.currentUser != null) {
            graph.setStartDestination(R.id.dataPointFragment)
        }else{
            graph.setStartDestination(R.id.loginFragment)
        }

        host.navController.graph = graph
        // Set up Action Bar
        val navController = host.navController


        appBarConfiguration = AppBarConfiguration(setOf(
            R.id.dataPointFragment,
            R.id.loginFragment

        ))
        setupActionBarWithNavController(navController, appBarConfiguration)

    }
    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.nav_host_fragment).navigateUp(appBarConfiguration)
    }
}