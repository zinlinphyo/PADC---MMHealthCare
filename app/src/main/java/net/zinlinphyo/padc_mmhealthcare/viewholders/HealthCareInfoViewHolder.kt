package net.zinlinphyo.padc_mmhealthcare.viewholders

import android.view.View
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.view_item_health_care_info.view.*
import net.zinlinphyo.padc_mmhealthcare.data.vos.HealthCareInfoVO
import net.zinlinphyo.padc_mmhealthcare.delegates.HealthCareInfoDelegate

class HealthCareInfoViewHolder(itemView: View, private val mDelegate: HealthCareInfoDelegate) : BaseViewHolder<HealthCareInfoVO>(itemView), View.OnClickListener {

    private var mData: HealthCareInfoVO? = null

    override fun setData(data: HealthCareInfoVO) {
        mData = data

        itemView.tv_info_title.text = data.title
        itemView.tv_info_description.text = data.description
        Glide.with(itemView.context)
                .load(data.image)
                .into(itemView.iv_info_image)
    }

    override fun onClick(v: View?) {
        mDelegate.onTapItem(mData!!.url!!)
    }
}
