package com.anyandroid.letstrain

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.anyandroid.letstrain.databinding.FragmentSplashScreenBinding


class SplashScreenFragment : Fragment() {

    private lateinit var binding: FragmentSplashScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentSplashScreenBinding.inflate(inflater, container, false)


//I wanna after 3 seconds go to HomeFragment
        val thread = Thread {
            Thread.sleep(3000)
            val fragment = HomeFragment()
            val fragmentManager = activity?.supportFragmentManager
            val fragmentTransaction = fragmentManager?.beginTransaction()
            fragmentTransaction?.replace(R.id.fragment_container, fragment)
            fragmentTransaction?.addToBackStack(null)
            fragmentTransaction?.commit()
        }
        thread.start()
        return binding.root
    }


}