package com.example.tablayoutexample

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.moengage.cards.ui.CardFragment
import com.moengage.cards.ui.CategoryFragment
import com.moengage.inbox.ui.view.InboxFragment


//ViewPager
private const val MAX_PAGE = 2
enum class Page {
    FragmentNews,
    FragmentBookMark,
    FragmentInBox
}
class ViewPagerAdapter(fa:FragmentActivity) :FragmentStateAdapter(fa) {

    override fun getItemCount(): Int {
        return MAX_PAGE
    }

    override fun createFragment(position: Int): Fragment {
        return when {
            position == 0 -> CardFragment()
            else -> InboxFragment()
        }
    }
}