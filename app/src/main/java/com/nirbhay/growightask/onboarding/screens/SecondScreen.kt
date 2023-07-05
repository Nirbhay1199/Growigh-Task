package com.nirbhay.growightask.onboarding.screens

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.nirbhay.growightask.R

class SecondScreen : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_second_screen, container, false)

        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager)

        val next : ImageView = view.findViewById(R.id.next2)
        val skip : ImageView = view.findViewById(R.id.skip2)

        next.setOnClickListener {
            viewPager?.currentItem = 2
        }

        skip.setOnClickListener {
            findNavController().navigate(R.id.action_viewPagerFragment_to_welcomeFragment)
            onBoardingFinished()
        }


        return view
    }

    private fun onBoardingFinished(){
        val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putBoolean("Finished", true)
        editor.apply()
    }

}