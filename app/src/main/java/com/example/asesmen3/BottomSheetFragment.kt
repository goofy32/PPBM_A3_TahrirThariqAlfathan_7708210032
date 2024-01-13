package com.example.asesmen3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetFragment : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.bottomsheet_fragment, container, false)

        val moveToChatButton = view.findViewById<Button>(R.id.moveToChatButton)

        moveToChatButton.setOnClickListener {
            // Panggil metode untuk pindah ke FragmentChat
            moveToFragmentChat()
            dismiss() // Tutup bottom sheet setelah pindah ke FragmentChat
        }

        return view
    }

    private fun moveToFragmentChat() {
        // Buat objek FragmentChat
        val fragmentChat = ChatFragment()

        // Dapatkan instance FragmentManager
        val fragmentManager = requireActivity().supportFragmentManager

        // Mulai transaksi fragment
        val transaction = fragmentManager.beginTransaction()

        // Ganti fragment saat ini dengan FragmentChat
        transaction.replace(R.id.FragmentChat, fragmentChat)

        // Tambahkan transaksi ke back stack (opsional)
        transaction.addToBackStack(null)

        // Jalankan transaksi
        transaction.commit()
    }
}



