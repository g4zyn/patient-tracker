package rs.raf.projekat1.marko_gajin_RM8517.view.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_list.*
import rs.raf.projekat1.marko_gajin_RM8517.R
import rs.raf.projekat1.marko_gajin_RM8517.view.viewpager.TabAdapter

class ListFragment : Fragment(R.layout.fragment_list) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        initTabs()
    }

    private fun initTabs() {
        viewPager.adapter = TabAdapter(childFragmentManager)
        tabLayout.setupWithViewPager(viewPager)
    }

}







