package com.walletechnologies.contaxt

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.walletechnologies.contaxt.placeholder.PlaceholderContent

/**
 * A fragment representing a list of Items.
 */
class SensorDataDetailFragment : Fragment() {

    private val args by navArgs<SensorDataDetailFragmentArgs>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.sensor_detail_list, container, false)
        val sensorData = args.sensorData
        val featureList = arrayOf(
            Pair("Timestamp", sensorData.timestamp.toString()),
            Pair("Force Sensor Resistance", sensorData.fsrResistance.toString()),
            Pair("X Acceleration", sensorData.accelerometer.x.toString()),
            Pair("Y Acceleration", sensorData.accelerometer.y.toString()),
            Pair("Z Acceleration", sensorData.accelerometer.z.toString()),
            Pair("GPS Longitude", sensorData.gps.longitude.toString()),
            Pair("GPS Latitude", sensorData.gps.latitude.toString()),
            Pair("GPS Altitude", sensorData.gps.altitude.toString())
        )

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = LinearLayoutManager(context)

                adapter = MySensorDataDetailRecyclerViewAdapter(featureList)
            }
        }
        return view
    }

    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
            SensorDataDetailFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }
}