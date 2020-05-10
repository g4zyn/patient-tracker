package rs.raf.projekat1.marko_gajin_RM8517.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import rs.raf.projekat1.marko_gajin_RM8517.R
import rs.raf.projekat1.marko_gajin_RM8517.view.viewpager.NavigationAdapter


class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        initViewPager()
        initNavigation()
    }
    
    private fun initViewPager() {
        viewPager.adapter = NavigationAdapter(supportFragmentManager)
    }

    private fun initNavigation() {
        bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.statusNav -> {
                    viewPager.setCurrentItem(NavigationAdapter.FRAGMENT_OVERVIEW, false)
                }
                R.id.inputNav -> {
                    viewPager.setCurrentItem(NavigationAdapter.FRAGMENT_NEW_PATIENT, false)
                }
                R.id.listNav -> {
                    viewPager.setCurrentItem(NavigationAdapter.FRAGMENT_LIST, false)
                }
                R.id.profileNav -> {
                    viewPager.setCurrentItem(NavigationAdapter.FRAGMENT_PROFILE, false)
                }
            }
            true
        }
    }

}
