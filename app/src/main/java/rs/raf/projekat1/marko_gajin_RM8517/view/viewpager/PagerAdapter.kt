package rs.raf.projekat1.marko_gajin_RM8517.view.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import rs.raf.projekat1.marko_gajin_RM8517.view.fragments.InputFragment
import rs.raf.projekat1.marko_gajin_RM8517.view.fragments.ListFragment
import rs.raf.projekat1.marko_gajin_RM8517.view.fragments.ProfileFragment
import rs.raf.projekat1.marko_gajin_RM8517.view.fragments.StatusFragment

class PagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {
        private const val ITEM_COUNT = 4
        const val FRAGMENT_STATUS = 0
        const val FRAGMENT_INPUT = 1
        const val FRAGMENT_LIST = 2
        const val FRAGMENT_PROFILE = 3
    }

    override fun getItem(position: Int): Fragment {

        return when(position) {
            FRAGMENT_STATUS -> StatusFragment()
            FRAGMENT_INPUT -> InputFragment()
            FRAGMENT_LIST -> ListFragment()
            else -> ProfileFragment()
        }
    }

    override fun getCount(): Int {
        return ITEM_COUNT
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position) {
            FRAGMENT_STATUS -> "status"
            FRAGMENT_INPUT -> "input"
            FRAGMENT_LIST -> "list"
            else -> "profile"
        }
    }
}