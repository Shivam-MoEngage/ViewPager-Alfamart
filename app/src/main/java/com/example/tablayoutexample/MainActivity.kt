package com.example.tablayoutexample

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.example.tablayoutexample.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.moengage.cards.ui.CardActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewPagerAdapter: ViewPagerAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupTabLayout()

        viewPagerAdapter = ViewPagerAdapter(this)
        binding.viewPager.adapter = viewPagerAdapter
        binding.viewPager.setCurrentItem(0, true)

        binding.viewPager.registerOnPageChangeCallback(object : OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.tabLayout.selectTab(binding.tabLayout.getTabAt(position))
            }
        });

        binding.run {

            binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

                override fun onTabSelected(tab: TabLayout.Tab?) {
                    if (tab == null){
                        return
                    }

                    when(tab.text){

                        "Cards" ->
                            if (binding.viewPager.currentItem != 0){
                                binding.viewPager.setCurrentItem(0, true)
                            }

                        "Inbox" ->

                            if (binding.viewPager.currentItem != 1){
                                binding.viewPager.setCurrentItem(1, true)
                            }

                    }
                }

                override fun onTabReselected(tab: TabLayout.Tab?) {
                    // Write code to handle tab reselect

                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {
                    // Write code to handle tab reselect

                }
            })
        }
    }

    private fun setupTabLayout() {

        val selectedPosition = binding.tabLayout.selectedTabPosition
    }

}