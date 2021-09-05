package dem.vaccae.basequickadapterdemo

import com.chad.library.adapter.base.BaseSectionQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.chad.library.adapter.base.entity.SectionEntity
import dem.vaccae.basequickadapterdemo.bean.CDevice
import dem.vaccae.basequickadapterdemo.bean.CDrugs

/**
 * 作者：Vaccae
 * 邮箱：3657447@qq.com
 * 创建时间： 12:37
 * 功能模块说明：
 */
class SectionQuickAdapter(layoutResId: Int, sectionHeadResId: Int, data: MutableList<CDevice>?) :
    BaseSectionQuickAdapter<CDevice, BaseViewHolder>(layoutResId, sectionHeadResId, data) {


    override fun convert(helper: BaseViewHolder?, item: CDevice?) {
        helper?.let {
            item?.let {
                dev->
                var drugs = dev.t
                it.setText(R.id.tv_drugcode, drugs.drugs_code)
                    .setText(R.id.tv_drugname, drugs.drugs_name)
                    .setText(R.id.tvqty_h, drugs.qty_h.toString())
                    .setText(R.id.tv_qtyl, drugs.qty_l.toString())
            }

        }
    }

    override fun convertHead(helper: BaseViewHolder?, item: CDevice?) {
        helper?.let {
            item?.let { dev ->
                it.setText(R.id.tv_serialno, dev.dev_seri.toString())
                it.setText(R.id.tv_gridstr, dev.dev_gridstr)
                if (item.dev_split) {
                    it.setVisible(R.id.tv_serialno, false)
                } else {
                    it.setVisible(R.id.tv_serialno, true)
                }
            }
        }
    }

}