package com.example.asesmen3

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity4 : AppCompatActivity() {

    lateinit var customArrayAdapters: CustomArrayAdapters
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        val list = mutableListOf<OurData>()
        list.add(OurData(R.drawable.ic_facebook, "Pemrograman Perangkat Bergerak Multimedia", "Dalam semester 6, anda telah hadir sebanyak 70 kali /nAbsen Anda 100%"))
        list.add(OurData(R.drawable.ic_google, "Augmented Reality", "Kehadiran anda di mata kuliah ini hanyalah 50% /nAnda sering tidak melakukan absensi"))
        list.add(OurData(R.drawable.siswa__2_, "Pengujian Aplikasi Multimedia", "Dosen memberikan anda nilai bonus untuk kehadiran sebesar 1% /nAnda memiliki 80% Kehadiran"))
        list.add(OurData(R.drawable.clock, "Proyek Multimedia", "Kehadiran anda di mata kuliah ini sebanyak 90% /nAnda sering melakukan absensi menggunakan aplikasi ini dan anda mendapaptkan bonus nilai"))
        list.add(OurData(R.drawable.ic_person, "Kecerdasan Buatan", "Anda memerlukan nilai yang lebih baik /nKehadiran anda adalah 80%"))
        list.add(OurData(R.drawable.img020, "Pancasila", "Anda mendapatkan nilai kehdairan 90% /nIni adalah pencapaian yang sangat baik"))
        list.add(OurData(R.drawable.twibbon1, "Pemrograman Simulator", "Kehadiran anda di mata kuliah ini sebesar 98% /nAnda dapat melakukan hal lain"))

        customArrayAdapters = CustomArrayAdapters(this, list)

        val listView = findViewById<ListView>(R.id.list)

        listView.adapter = customArrayAdapters

        // Menambahkan OnClickListener ke setiap item di ListView
        listView.setOnItemClickListener(AdapterView.OnItemClickListener { _, _, position, _ ->
            // Mendapatkan data dari item yang diklik
            val selectedItem = list[position]

            // Mengirim data ke activity baru (DetailActivity)
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("image", selectedItem.image)
            intent.putExtra("title", selectedItem.title)
            intent.putExtra("desc", selectedItem.desc)

            // Memulai activity baru
            startActivity(intent)
        })
    }
}