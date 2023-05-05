package com.example.mv4.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.mv4.R

import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tabLayout = findViewById(R.id.tabLayout)
        viewPager = findViewById(R.id.viewpager)

        tabLayout.setupWithViewPager(viewPager)

        val vpadapter = VPAdapter(
            supportFragmentManager,
            FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
        )
        vpadapter.addFragment(desinfeccion(), "Desinfección")
        vpadapter.addFragment(cloracion(), "Cloración")
        viewPager.setAdapter(vpadapter)

    }
}