package rs.raf.projekat1.marko_gajin_RM8517.view.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import rs.raf.projekat1.marko_gajin_RM8517.view.fragments.HospitalizedFragment
import rs.raf.projekat1.marko_gajin_RM8517.view.fragments.ReleasedFragment
import rs.raf.projekat1.marko_gajin_RM8517.view.fragments.WaitingFragment

class TabAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {
        private const val ITEM_COUNT = 3
        const val WAITING = 0
        const val HOSPITALIZED = 1
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            WAITING -> WaitingFragment()
            HOSPITALIZED -> HospitalizedFragment()
            else -> ReleasedFragment()
        }
    }

    override fun getCount(): Int {
        return ITEM_COUNT
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            WAITING -> "Waiting Room"
            HOSPITALIZED -> "Hospitalized"
            else -> "Released"
        }
    }
}