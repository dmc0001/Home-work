package com.anyandroid.letstrain

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.anyandroid.letstrain.databinding.FragmentAnswerBinding
import java.io.Serializable
import java.util.*


/**
 * A simple [Fragment] subclass.
 * Use the [AnswerFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AnswerFragment : Fragment() {
    lateinit var binding: FragmentAnswerBinding
    private var trainingMap: MutableMap<String, String>? = null



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentAnswerBinding.inflate(inflater, container, false)

        // Retrieve trainingMap from arguments
        trainingMap = arguments?.getSerializable("trainingMap") as? MutableMap<String, String>
        binding.textView.text = trainingMap?.map { (key, value) -> "$key = $value" }?.joinToString(", ")

        // Display the data in a Toast
        val toastText = trainingMap?.map { (key, value) -> "$key = $value" }?.joinToString(", ")
        toastText?.let {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }
        return binding.root
    }







    companion object {
        @JvmStatic
        fun newInstance(trainingMap: MutableMap<String, String>) =
            AnswerFragment().apply {
                arguments = Bundle().apply {
                    putSerializable("trainingMap", trainingMap as Serializable)
                }
            }
    }
}