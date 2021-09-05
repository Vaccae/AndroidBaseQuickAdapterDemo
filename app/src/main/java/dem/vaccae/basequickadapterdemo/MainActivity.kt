package dem.vaccae.basequickadapterdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dem.vaccae.basequickadapterdemo.bean.CDevice
import dem.vaccae.basequickadapterdemo.bean.CDrugs

class MainActivity : AppCompatActivity() {

    val colspan = 60

    var devices = ArrayList<CDevice>()

    var gridstrtype = arrayListOf("555|5555", "443|4444", "22|332")
    var drugnames = arrayListOf("健胃消食口服液", "六味地黄丸", "芬太尼", "注射用头胞他定", "盐酸安溴索口服液")


    val recyclerview: RecyclerView by lazy { findViewById(R.id.recycler_view) }

    lateinit var sadapter: SectionQuickAdapter
    lateinit var llmanager: GridLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()

        sadapter = SectionQuickAdapter(R.layout.rcl_body, R.layout.rcl_head, devices)
        val gridLayoutManager = GridLayoutManager(this, colspan)
        recyclerview.layoutManager = gridLayoutManager
        recyclerview.adapter = sadapter

        gridLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                var item = devices.get(position)
                if (item.isHeader) {
                    return colspan
                } else {
                    var drugs = item.t
                    return drugs.colspansize
                }
            }
        }




    }


    fun initData() {
        devices = ArrayList()
        for (i in 1..3) {
            var dev = CDevice(true, i.toString())
            dev.dev_seri = i
            var idx = i % gridstrtype.size
            dev.dev_gridstr = gridstrtype[idx]

            devices.add(dev)

            var list = getGridList(dev.dev_gridstr)
            var rowno = 1;
            for (k in list) {
                if (k > 0) {
                    var spansize = colspan / k
                    for (itemi in 1..k) {
                        var drugs = CDrugs()
                        drugs.drugs_code =
                            i.toString() + rowno.toString() + String.format("%04d", itemi)
                        var drugsidx = itemi % drugnames.size
                        drugs.drugs_name = drugnames[drugsidx]
                        drugs.qty_h = 50
                        drugs.qty_l = 20
                        drugs.colspansize = spansize

                        devices.add(CDevice(drugs))
                    }
                    rowno++
                } else {
                    var dev = CDevice(true, i.toString())
                    dev.dev_seri = i
                    dev.dev_gridstr = "---------------------------------------"
                    dev.dev_split = true;
                    devices.add(dev)
                }
            }
        }
    }

    fun getGridList(str: String): ArrayList<Int> {
        val list = ArrayList<Int>()
        for (s in str) {
            if (s.toString() == "|") {
                list.add(-1)
            } else {
                list.add(s.toString().toInt())
            }
        }
        return list
    }
}