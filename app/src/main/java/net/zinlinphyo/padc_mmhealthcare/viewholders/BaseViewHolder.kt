package net.zinlinphyo.padc_mmhealthcare.viewholders

import android.support.v7.widget.RecyclerView
import android.view.View

abstract class BaseViewHolder<in W>(itemView: View) : RecyclerView.ViewHolder(itemView) {

	abstract fun setData(data: W)
}
