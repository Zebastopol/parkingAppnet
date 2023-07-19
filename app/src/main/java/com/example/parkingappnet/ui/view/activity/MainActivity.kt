package com.example.parkingappnet.ui.view.activity

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.parkingappnet.R
import com.example.parkingappnet.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var binding: ActivityMainBinding
    private lateinit var togle: ActionBarDrawerToggle
    private lateinit var navController: NavController
    //lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.myFrame) as NavHostFragment //beginTransaction().add(R.id.myFrame, HomeFragmentIngreso()).commit()
        binding.myNavigationView.setNavigationItemSelectedListener(this)
        navController = navHostFragment.findNavController()
        val  toolbar = binding.myToolbar.toolbar//navController = findNavController(R.id.fragmentContainerView)//setupActionBarWithNavController(navController)
        toolbar.setupWithNavController(navController)
        setSupportActionBar(toolbar)
        togle = setDrawerTogle()
        binding.myDrawerLayout.addDrawerListener(togle)
        togle.syncState()
        binding.myNavigationView.setupWithNavController(navController)
    }

    private fun setSupportActionBar(toolbar: Toolbar): ActionBar? {
        return supportActionBar.apply {(this as AppCompatActivity).setSupportActionBar(toolbar)
        }
    }

    private fun setDrawerTogle(): ActionBarDrawerToggle {
        return ActionBarDrawerToggle(this,
            binding.myDrawerLayout, R.string.drawer_open,R.string.drawer_close)
    }
    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        togle.onConfigurationChanged(newConfig)
    }
    override fun onPostCreate( savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        togle.syncState()
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (togle.onOptionsItemSelected(item)) { true
        } else super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        return super.onSupportNavigateUp() || super.onSupportNavigateUp()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val navController = findNavController(R.id.myFrame)
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        when (item.itemId) {
            R.id.navIngreso -> navController.navigate(R.id.fragment_home) /* fragmentTransaction.replace(R.id.myFrame, HomeFragmentIngreso(),item.title.toString()).commit()*/
            R.id.navBusqueda -> navController.navigate(R.id.fragment_search) /*fragmentTransaction.replace(R.id.myFrame, BusquedaFragment(),item.title.toString()).commit()*/
            /*R.id.navResumen -> ft.replace(R.id.myFrame, ResumenFragment()).commit()R.id.navCuenta -> ft.replace(R.id.myFrame, ResumenFragment()).commit()R.id.navResumen -> ft.replace(R.id.myFrame, ResumenFragment()).commit()*/
            R.id.navSalir -> {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }

        }
        //title = item.title //para mostrar el título
        binding.myDrawerLayout.closeDrawer(GravityCompat.START) //para cerrar drawer

        return true
    }
}

