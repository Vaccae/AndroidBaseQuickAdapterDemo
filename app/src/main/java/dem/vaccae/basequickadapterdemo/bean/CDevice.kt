package dem.vaccae.basequickadapterdemo.bean

import com.chad.library.adapter.base.entity.SectionEntity

/**
 * 作者：Vaccae
 * 邮箱：3657447@qq.com
 * 创建时间： 12:33
 * 功能模块说明：
 */
class CDevice : SectionEntity<CDrugs> {

    constructor(isHead: Boolean, headstr:String):super(isHead, headstr)

    constructor(item: CDrugs):super(item)

    var dev_seri = 1;

    var dev_gridstr = "555|5555"

    var dev_split = false

}