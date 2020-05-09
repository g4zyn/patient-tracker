package rs.raf.projekat1.marko_gajin_RM8517.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import rs.raf.projekat1.marko_gajin_RM8517.R
import rs.raf.projekat1.marko_gajin_RM8517.view.viewpager.PagerAdapter


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
        viewPager.adapter = PagerAdapter(supportFragmentManager)
    }

    private fun initNavigation() {
        bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.statusNav -> {
                    viewPager.setCurrentItem(PagerAdapter.FRAGMENT_STATUS, false)
                }
                R.id.inputNav -> {
                    viewPager.setCurrentItem(PagerAdapter.FRAGMENT_INPUT, false)
                }
                R.id.listNav -> {
                    viewPager.setCurrentItem(PagerAdapter.FRAGMENT_LIST, false)
                }
                R.id.profileNav -> {
                    viewPager.setCurrentItem(PagerAdapter.FRAGMENT_PROFILE, false)
                }
            }
            true
        }
    }

//    private fun initFragment() {
//        val transaction = supportFragmentManager.beginTransaction()
//        transaction.add(R.id.testFcv, TestFragment())
//        transaction.commit()
//    }

}
