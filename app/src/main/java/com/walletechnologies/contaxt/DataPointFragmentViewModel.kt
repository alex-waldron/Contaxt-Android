package com.walletechnologies.contaxt

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import com.walletechnologies.contaxt.data.model.SensorData

class DataPointFragmentViewModel: ViewModel() {
    private val data: MutableLiveData<List<SensorData>> by lazy{
        MutableLiveData<List<SensorData>>().also {
            initListener()
        }
    }

    fun getData(): LiveData<List<SensorData>> {
        return data
    }


    private fun initListener(){
        val db = Firebase.firestore
        db
            .collection("hardware")
            .document("deviceReadings")
            .collection("F4:CF:A2:D0:39:D9")
            .orderBy("timestamp", Query.Direction.DESCENDING)
            .orderBy("counter", Query.Direction.DESCENDING)
            .limit(50).addSnapshotListener { value, e ->
                if (e != null) {
                    Log.w(TAG, "Listen failed.", e)
                    return@addSnapshotListener
                }

                val dataPoints = ArrayList<SensorData>()
                for (doc in value!!) {
                    dataPoints.add(doc.toObject<SensorData>())
                }
                data.value = dataPoints


            }
    }
}