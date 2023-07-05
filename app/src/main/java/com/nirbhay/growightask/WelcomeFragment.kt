package com.nirbhay.growightask

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class WelcomeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_welcome, container, false)

        val feed: TextView = view.findViewById(R.id.feedBtn)
        val upload: TextView = view.findViewById(R.id.uploadBtn)


        feed.setOnClickListener {
            val intent = Intent(requireContext(), FeedActivity::class.java)
            startActivity(intent)
        }

        upload.setOnClickListener {
            val intent = Intent(requireContext(), UploadActivity::class.java)
            startActivity(intent)
        }




        return view
    }






}