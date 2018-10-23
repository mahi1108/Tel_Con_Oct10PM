package cubex.mahesh.tel_con_oct10pm

import android.content.Context
import android.net.ConnectivityManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.telephony.TelephonyManager
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

     var tManager =   getSystemService(Context.TELEPHONY_SERVICE)
                as TelephonyManager
     var cManager = getSystemService(Context.CONNECTIVITY_SERVICE)
                as ConnectivityManager
     var list = mutableListOf<String>()
     list.add("IMEI : ${tManager.getDeviceId()}")
     list.add("Sim Sno : ${tManager.simSerialNumber}")
        list.add("N/w Name : ${tManager.simOperatorName}")
        list.add("Country Name : ${tManager.simCountryIso}")
        list.add("Phone  Type : ${tManager.phoneType}")

        if(cManager.activeNetworkInfo != null)
        {
            list.add("Data Enabled :   True")
        }else{
            list.add("Data Enabled :   False")
        }

        var adapter = ArrayAdapter<String>(this@MainActivity,
                android.R.layout.simple_list_item_single_choice,list)
        lview.adapter = adapter
    }
}
