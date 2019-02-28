package com.aib.view.fragment

import android.os.Bundle
import android.provider.Settings
import android.text.TextUtils
import android.view.View

import com.aib.utils.Constants
import com.atguigu.p2pinvest0828.R
import com.atguigu.p2pinvest0828.activity.BarChartActivity
import com.atguigu.p2pinvest0828.activity.ChongZhiActivity
import com.atguigu.p2pinvest0828.activity.LineChartActivity
import com.aib.view.activity.LoginActivity
import com.aib.view.activity.SettingsActivity
import com.atguigu.p2pinvest0828.activity.PieChartActivity
import com.atguigu.p2pinvest0828.activity.TiXianActivity
import com.atguigu.p2pinvest0828.activity.UserInfoActivity
import com.atguigu.p2pinvest0828.common.BaseActivity
import com.blankj.utilcode.util.ActivityUtils
import com.blankj.utilcode.util.SPUtils
import com.blankj.utilcode.util.ThreadUtils
import kotlinx.android.synthetic.main.fragment_center.*

class CenterFragment : BaseFragment() {
    fun setting(view: View) {
        //启动用户信息界面的Activity
        (this.activity as BaseActivity).goToActivity(UserInfoActivity::class.java, null)
    }

    //设置“充值”操作
    fun reCharge(view: View) {
        (this.activity as BaseActivity).goToActivity(ChongZhiActivity::class.java, null)
    }

    //设置“提现”操作
    fun withdraw(view: View) {
        (this.activity as BaseActivity).goToActivity(TiXianActivity::class.java, null)
    }

    //启动折线图
    fun startLineChart(view: View) {
        (this.activity as BaseActivity).goToActivity(LineChartActivity::class.java, null)
    }

    //启动折线图
    fun startBarChart(view: View) {
        (this.activity as BaseActivity).goToActivity(BarChartActivity::class.java, null)
    }

    //启动折线图
    fun startPieChart(view: View) {
        (this.activity as BaseActivity).goToActivity(PieChartActivity::class.java, null)
    }

    override fun getResId(): Int = R.layout.fragment_center

    override fun initData(savedInstanceState: Bundle?) {
        openSettings()
    }

    private fun openSettings() {
        iv_settings.setOnClickListener {
            ActivityUtils.startActivity(SettingsActivity::class.java)
        }
    }

    /**
     * 打开图库
     */
    fun openGallery() {
        ThreadUtils.executeByIo(object : ThreadUtils.SimpleTask<String>() {
            @Throws(Throwable::class)
            override fun doInBackground(): String? {
                return SPUtils.getInstance().getString(Constants.TOKEN)
            }

            override fun onSuccess(result: String?) {
                if (TextUtils.isEmpty(result)) {
                    ActivityUtils.startActivity(LoginActivity::class.java)
                } else {

                }
            }
        })
    }
}
