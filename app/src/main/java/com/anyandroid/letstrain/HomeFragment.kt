package com.anyandroid.letstrain

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter

import com.anyandroid.letstrain.databinding.FragmentHomeBinding
import java.text.SimpleDateFormat
import java.util.*

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        val suggestions = arrayOf("Chest", "Back", "Legs", "Arms","Nothing")

        binding.muscleGroupEditText.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, suggestions)
                binding.muscleGroupEditText.setAdapter(adapter)
                binding.muscleGroupEditText.showDropDown()
                return@setOnTouchListener true
            }
            return@setOnTouchListener false
        }
        /*binding.muscleGroupEditText2.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, suggestions)
                binding.muscleGroupEditText2.setAdapter(adapter)
                binding.muscleGroupEditText2.showDropDown()
                return@setOnTouchListener true
            }
            return@setOnTouchListener false
        }*/
        binding.dayThirdDateEditText.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, suggestions)
               // binding.dayThirdDateEditText.setAdapter(adapter)
              // binding.dayThirdDateEditText.showDropDown()
                return@setOnTouchListener true
            }
            return@setOnTouchListener false
        }
        binding.dayFourthDateEditText.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, suggestions)
                binding.muscleGroupEditText.setAdapter(adapter)
                binding.muscleGroupEditText.showDropDown()
                return@setOnTouchListener true
            }
            return@setOnTouchListener false
        }
        binding.dayFifthDateEditText.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, suggestions)
                binding.muscleGroupEditText.setAdapter(adapter)
                binding.muscleGroupEditText.showDropDown()
                return@setOnTouchListener true
            }
            return@setOnTouchListener false
        }
        binding.daySixthDateEditText.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, suggestions)
                binding.muscleGroupEditText.setAdapter(adapter)
                binding.muscleGroupEditText.showDropDown()
                return@setOnTouchListener true
            }
            return@setOnTouchListener false
        }
        binding.daySeventhDateEditText.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, suggestions)
                binding.muscleGroupEditText.setAdapter(adapter)
                binding.muscleGroupEditText.showDropDown()
                return@setOnTouchListener true
            }
            return@setOnTouchListener false
        }

        setDaysOfTheWeek()
         // I wanna make edit text auto complete




        return binding.root
    }

    // fun get the current day of the week and month and year and return it as a date
    private fun getCurrentDate(): String {
        val currentDate = Date()
        val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        return dateFormat.format(currentDate)
    }

    // fun take date and minus 1 day and return it as a String
    private fun minusOneDay(dateString: String, num: Int): String {
        val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        val date = dateFormat.parse(dateString)

        val calendar = Calendar.getInstance()
        calendar.time = date!!
        calendar.add(Calendar.DAY_OF_YEAR, num)

        val resultDate = calendar.time
        return dateFormat.format(resultDate)
    }

    private fun setDaysOfTheWeek() {
        binding.dayOneDateEditText.setText(getCurrentDate())
        binding.dayOneDateEditText.isEnabled = false
        binding.dayTwoDateEditText.setText(minusOneDay(getCurrentDate(), -1))
        binding.dayTwoDateEditText.isEnabled = false
        binding.dayThirdDateEditText.setText(minusOneDay(getCurrentDate(), -2))
        binding.dayThirdDateEditText.isEnabled = false
        binding.dayFourthDateEditText.setText(minusOneDay(getCurrentDate(), -3))
        binding.dayFourthDateEditText.isEnabled = false
        binding.dayFifthDateEditText.setText(minusOneDay(getCurrentDate(), -4))
        binding.dayFifthDateEditText.isEnabled = false
        binding.daySixthDateEditText.setText(minusOneDay(getCurrentDate(), -5))
        binding.daySixthDateEditText.isEnabled = false
        binding.daySeventhDateEditText.setText(minusOneDay(getCurrentDate(), -6))
        binding.daySeventhDateEditText.isEnabled = false
    }

}