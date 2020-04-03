package com.liangzai.kotlin

import android.view.View
import androidx.fragment.app.Fragment
import com.google.gson.Gson
import com.liangzai.kotlin.activity.BaseActivity
import com.liangzai.kotlin.bean.RecommendBean
import com.liangzai.kotlin.fragment.*
import com.liangzai.kotlin.utils.ToolUtils
import kotlinx.android.synthetic.main.common_bottom_layout.*

/**
 * @author zhouliang
 * 版本 1.0
 * 创建时间 2020-03-19
 * 描述:
 * 1.构建5个Fragment[设置默认的Fragment]
 */
class HomeActivity : BaseActivity() {


    var mFirstFragment: FirstFragment? = null
    var mSecondFragment: SecondFragment? = null
    var mThirdFragment: ThirdFragment? = null
    var mFourFragment: FourFragment? = null
    var mFiveFragment: FiveFragment? = null
    var mCurrentFragment: Fragment? = null


    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }


    override fun initData() {
        ToolUtils.getStartInfo()

        initFragment()

//        val gson = Gson()
//        val jsonString = "{\"name\":\"sunny\",\"age\":24}"
//        val user: RecommendBean = gson.fromJson<RecommendBean>(jsonString, RecommendBean::class.java)

    }


    /** 默认的Fragment */
    private fun initFragment() {
        var transaction = supportFragmentManager.beginTransaction()
        mFirstFragment = FirstFragment.getInstance()
        mCurrentFragment = mFirstFragment
        transaction.add(R.id.fragmentLayout, mCurrentFragment!!)
        transaction.commit()
    }


    /** 点击事件 */
    fun click(v:View?){
        commonSwitch(v?.id)
    }

    private fun commonSwitch(indexPosition: Int?) {
        when(indexPosition){
           R.id.index_first ->{
               hideImageStatus()
               if (null === mFirstFragment) {
                   mFirstFragment = FirstFragment.getInstance()
               }
               index_first_icon.setImageResource(R.mipmap.index_11)
               index_first_text.setTextColor(resources.getColor(R.color.text_news_title_color))
               switchFragment(mFirstFragment)
           }
            R.id.index_second ->{
                hideImageStatus()
                if (null === mSecondFragment) {
                    mSecondFragment = SecondFragment.getInstance()
                }
                index_second_icon.setImageResource(R.mipmap.index_21)
                index_second_text.setTextColor(resources.getColor(R.color.text_news_title_color))
                switchFragment(mSecondFragment)
            }
            R.id.index_third ->{
                hideImageStatus()
                if (null === mThirdFragment) {
                    mThirdFragment = ThirdFragment.getInstance()
                }
                index_third_icon.setImageResource(R.mipmap.index_31)
                index_third_text.setTextColor(resources.getColor(R.color.text_news_title_color))
                switchFragment(mThirdFragment)
            }
            R.id.index_four ->{
                hideImageStatus()
                if (null === mFourFragment) {
                    mFourFragment = FourFragment.getInstance()
                }
                index_four_icon.setImageResource(R.mipmap.index_41)
                index_four_text.setTextColor(resources.getColor(R.color.text_news_title_color))
                switchFragment(mFourFragment)
            }

            R.id.index_five ->{
                hideImageStatus()
                if (null === mFiveFragment) {
                    mFiveFragment = FiveFragment.getInstance()
                }
                index_five_icon.setImageResource(R.mipmap.index_51)
                index_five_text.setTextColor(resources.getColor(R.color.text_news_title_color))
                switchFragment(mFiveFragment)
            }

        }
    }

    /** 切换 Fragment */
    private fun switchFragment(fragment: Fragment?) {
        if(fragment !== mCurrentFragment){
            var transaction = supportFragmentManager.beginTransaction()
            transaction.hide(mCurrentFragment!!)
            mCurrentFragment = fragment
            if (!fragment!!.isAdded) {
                transaction.add(R.id.fragmentLayout, fragment)
            } else {
                transaction.show(fragment)
            }
            transaction.commit()
        }
    }

    private fun hideImageStatus() {

        index_first_icon.setImageResource(R.mipmap.index_10)
        index_second_icon.setImageResource(R.mipmap.index_20)
        index_third_icon.setImageResource(R.mipmap.index_30)
        index_four_icon.setImageResource(R.mipmap.index_40)
        index_five_icon.setImageResource(R.mipmap.index_50)
        index_first_text.setTextColor(resources.getColor(R.color.text_default_color))
        index_second_text.setTextColor(resources.getColor(R.color.text_default_color))
        index_third_text.setTextColor(resources.getColor(R.color.text_default_color))
        index_four_text.setTextColor(resources.getColor(R.color.text_default_color))
        index_five_text.setTextColor(resources.getColor(R.color.text_default_color))
    }
}
