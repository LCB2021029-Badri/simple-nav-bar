package com.example.fragnav

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class RegimentsActivity : AppCompatActivity() {

    lateinit var bottom_nav_bar : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regiments)

        val scoutsFragment = ScoutsFragment()
        val guardsFragment = GuardsFragment()
        val militaryFragment = MilitaryFragment()
        val allFragment = AllFragment()

        bottom_nav_bar = findViewById(R.id.navigation_bar)

        //default navigation page
        displayFragment(scoutsFragment)

        //functionality of the bottom navigation bar
        bottom_nav_bar.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.op_scouts -> displayFragment(scoutsFragment)
                R.id.op_guards -> displayFragment(guardsFragment)
                R.id.op_military -> displayFragment(militaryFragment)
                else -> displayFragment(allFragment)
            }
            true
        }

    }

    //function to change the fragments
    private fun displayFragment(fragment: Fragment){

        //setting transaction manager
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        //implementing transaction
        fragmentTransaction.replace(R.id.fragment_container,fragment)
        fragmentTransaction.commit()
    }

}