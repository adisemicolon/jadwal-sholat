package com.gmail.adipriyanto023.workshomobile

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.gmail.adipriyanto023.workshomobile.service.Api
import com.gmail.adipriyanto023.workshomobile.model.Jadwal
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Api.jadwalService()
                .getJadwal("1a49c18773227c45068925e4960d1c93")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    result -> njupuk(result.items.get(0))
                }, {
                    e -> Log.e("HASIL", e.message)
                })

    }
    fun njupuk(jadwal: Jadwal){
        val date = findViewById<TextView>(R.id.date_for)
        val subuh = findViewById<TextView>(R.id.fajr)
        val luhur = findViewById<TextView>(R.id.dhuhr)
        val asar = findViewById<TextView>(R.id.asr)
        val mahrib = findViewById<TextView>(R.id.maghrib)
        val isak = findViewById<TextView>(R.id.isha)

        date.text=jadwal.date_for
        subuh.text=jadwal.fajr
        luhur.text=jadwal.dhuhr
        asar.text=jadwal.asr
        mahrib.text=jadwal.maghrib
        isak.text=jadwal.isha

    }
}
