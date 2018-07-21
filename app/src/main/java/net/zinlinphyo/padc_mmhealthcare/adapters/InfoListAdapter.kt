package net.zinlinphyo.padc_mmhealthcare.adapters

import android.content.Context
import android.view.ViewGroup
import net.zinlinphyo.padc_mmhealthcare.R
import net.zinlinphyo.padc_mmhealthcare.data.vos.HealthCareInfoVO
import net.zinlinphyo.padc_mmhealthcare.delegates.HealthCareInfoDelegate
import net.zinlinphyo.padc_mmhealthcare.viewholders.HealthCareInfoViewHolder

class InfoListAdapter(context: Context, private val mDelegate: HealthCareInfoDelegate) : BaseRecyclerAdapter<HealthCareInfoViewHolder, HealthCareInfoVO>(context) {

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HealthCareInfoViewHolder {
        val infoItemView = mLayoutInflator.inflate(R.layout.view_item_health_care_info, parent, false)
        return HealthCareInfoViewHolder(infoItemView, mDelegate)
	}
}
