package com.belalshatara.login

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.belalshatara.login.ui.gallery.GalleryFragment
import com.belalshatara.login.ui.home.HomeFragment
import com.belalshatara.login.ui.slideshow.SlideshowFragment

class HomeViewPagerAdapter internal constructor(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return  3
    }


    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = Fragment()
        when (position) {
            0 -> fragment = GalleryFragment()
            1 -> fragment = HomeFragment()
            2 ->  fragment = SlideshowFragment()
        }

        return fragment!!
    }


    override fun getPageTitle(position: Int): CharSequence? {

        when (position) {
            0 -> return "1"
            1 -> return "2"
            2 -> return "3"
        }
        return null
    }
}