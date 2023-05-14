package com.anyandroid.letstrain

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast

import com.anyandroid.letstrain.databinding.FragmentHomeBinding
import java.text.SimpleDateFormat
import java.util.*

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    var trainingMap : MutableMap<String, String> = mutableMapOf()

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        setTraining()
        setDaysOfTheWeek()

        binding.checkButton.setOnClickListener {

            // now I wanna send the trainingMap to AnswerFragment

            val newFragment = AnswerFragment.newInstance(trainingMap)
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, newFragment)
                .addToBackStack(null)
                .commit()
        }






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
    @SuppressLint("ClickableViewAccessibility")
    fun setTraining (){
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
        binding.muscleGroupEditText.setOnItemClickListener { _, _, position, _ ->
            val selectedMuscleGroup = suggestions[position]
            val currentDate = minusOneDay(getCurrentDate(), -1)
            trainingMap[currentDate] = selectedMuscleGroup
        }
        binding.muscleGroupEditText3.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, suggestions)
                binding.muscleGroupEditText3.setAdapter(adapter)
                binding.muscleGroupEditText3.showDropDown()
                return@setOnTouchListener true
            }
            return@setOnTouchListener false
        }
        binding.muscleGroupEditText3.setOnItemClickListener { _, _, position, _ ->
            val selectedMuscleGroup = suggestions[position]
            val currentDate = minusOneDay(getCurrentDate(), -3)
            trainingMap[currentDate] = selectedMuscleGroup
        }
        binding.muscleGroupEditText2.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, suggestions)
                binding.muscleGroupEditText2.setAdapter(adapter)
                binding.muscleGroupEditText2.showDropDown()
                return@setOnTouchListener true
            }
            return@setOnTouchListener false
        }
        binding.muscleGroupEditText2.setOnItemClickListener { _, _, position, _ ->
            val selectedMuscleGroup = suggestions[position]
            val currentDate = minusOneDay(getCurrentDate(), -2)
            trainingMap[currentDate] = selectedMuscleGroup
        }
        binding.muscleGroupEditText4.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, suggestions)
                binding.muscleGroupEditText4.setAdapter(adapter)
                binding.muscleGroupEditText4.showDropDown()
                return@setOnTouchListener true
            }
            return@setOnTouchListener false
        }
        binding.muscleGroupEditText4.setOnItemClickListener { _, _, position, _ ->
            val selectedMuscleGroup = suggestions[position]
            val currentDate = minusOneDay(getCurrentDate(), -4)
            trainingMap[currentDate] = selectedMuscleGroup
        }
        binding.muscleGroupEditText5.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, suggestions)
                binding.muscleGroupEditText5.setAdapter(adapter)
                binding.muscleGroupEditText5.showDropDown()
                return@setOnTouchListener true
            }
            return@setOnTouchListener false
        }
        binding.muscleGroupEditText5.setOnItemClickListener { _, _, position, _ ->
            val selectedMuscleGroup = suggestions[position]
            val currentDate = minusOneDay(getCurrentDate(), -5)
            trainingMap[currentDate] = selectedMuscleGroup
        }
        binding.muscleGroupEditText6.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, suggestions)
                binding.muscleGroupEditText6.setAdapter(adapter)
                binding.muscleGroupEditText6.showDropDown()
                return@setOnTouchListener true
            }
            return@setOnTouchListener false
        }
        binding.muscleGroupEditText6.setOnItemClickListener { _, _, position, _ ->
            val selectedMuscleGroup = suggestions[position]
            val currentDate = minusOneDay(getCurrentDate(), -6)
            trainingMap[currentDate] = selectedMuscleGroup
        }
    }

    private fun setDaysOfTheWeek() {
        binding.dayOneDateEditText.setText(minusOneDay(getCurrentDate(), -1))
        binding.dayOneDateEditText.isEnabled = false
        binding.dayTwoDateEditText.setText(minusOneDay(getCurrentDate(), -2))
        binding.dayTwoDateEditText.isEnabled = false
        binding.dayThirdDateEditText.setText(minusOneDay(getCurrentDate(), -3))
        binding.dayThirdDateEditText.isEnabled = false
        binding.dayFourthDateEditText.setText(minusOneDay(getCurrentDate(), -4))
        binding.dayFourthDateEditText.isEnabled = false
        binding.dayFifthDateEditText.setText(minusOneDay(getCurrentDate(), -5))
        binding.dayFifthDateEditText.isEnabled = false
        binding.daySixthDateEditText.setText(minusOneDay(getCurrentDate(), -6))
        binding.daySixthDateEditText.isEnabled = false

    }

}