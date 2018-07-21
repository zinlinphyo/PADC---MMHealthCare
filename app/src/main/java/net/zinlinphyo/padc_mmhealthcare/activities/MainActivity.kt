package net.zinlinphyo.padc_mmhealthcare.activities

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.customtabs.CustomTabsIntent
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import net.zinlinphyo.padc_mmhealthcare.R
import net.zinlinphyo.padc_mmhealthcare.adapters.InfoListAdapter
import net.zinlinphyo.padc_mmhealthcare.data.vos.HealthCareInfoVO
import net.zinlinphyo.padc_mmhealthcare.delegates.HealthCareInfoDelegate
import net.zinlinphyo.padc_mmhealthcare.mvp.presenters.HealthCareInfoPresenter
import net.zinlinphyo.padc_mmhealthcare.mvp.views.HealthCareInfoView
import saschpe.android.customtabs.CustomTabsHelper
import saschpe.android.customtabs.WebViewFallback

class MainActivity : BaseActivity(), HealthCareInfoView, HealthCareInfoDelegate {

    private var mHealthCareInfoAdapter: InfoListAdapter? = null
    private var mPresenter: HealthCareInfoPresenter? = null

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

        mHealthCareInfoAdapter = InfoListAdapter(applicationContext, this)
        rvHealthCare.adapter = mHealthCareInfoAdapter
        rvHealthCare.layoutManager = LinearLayoutManager(this)

        mPresenter = HealthCareInfoPresenter(this)
        mPresenter!!.getAllHealthCareInfo().observe(this, Observer<List<HealthCareInfoVO>> {response ->
            displayHealthInfoList(response!!)
        })

        mPresenter!!.getErrorMessage().observe(this, Observer<String> { message ->
            displayErrorMessage(message!!)
        })
	}

    override fun displayHealthInfoList(data: List<HealthCareInfoVO>) {
        mHealthCareInfoAdapter!!.setNewData(data)
    }

    override fun displayErrorMessage(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }

    override fun onTapItem(url: String) {
        displayUrl(url)
    }

    private fun displayUrl(url: String) {
        val customTabsIntent = CustomTabsIntent.Builder()
                .addDefaultShareMenuItem()
                .setShowTitle(true)
                .build()
        CustomTabsHelper.addKeepAliveExtra(this, customTabsIntent.intent)
        CustomTabsHelper.openCustomTab(
                this, customTabsIntent,
                Uri.parse(url),
                WebViewFallback())
    }
}
