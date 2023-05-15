import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.anyandroid.letstrain.databinding.FragmentAnswerBinding
import java.io.Serializable
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.abs

class AnswerFragment : Fragment() {
    private lateinit var binding: FragmentAnswerBinding
    private var trainingMap: MutableMap<String, String>? = null

    companion object {
        @JvmStatic
        fun newInstance(trainingMap: MutableMap<String, String>) =
            AnswerFragment().apply {
                arguments = Bundle().apply {
                    putSerializable("trainingMap", trainingMap as Serializable)
                }
            }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnswerBinding.inflate(inflater, container, false)

        // Retrieve trainingMap from arguments
        trainingMap = arguments?.getSerializable("trainingMap") as? MutableMap<String, String>

        val muscleGroups = findMuscleGroups(trainingMap!!)

        val muscleGroupsString = muscleGroups.joinToString(", ")

        binding.textView.text = muscleGroupsString

        return binding.root
    }

    private fun findMuscleGroups(map: Map<String, String>): List<String> {
        val currentDate = Calendar.getInstance().time
        val dateFormatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())

        val muscleGroups: MutableList<String> = mutableListOf()

        val allowedMuscleGroups = setOf("Legs", "Chest", "Back", "Arms")

        val latestMuscleGroupDates = mutableMapOf<String, Date>()

        for ((dateString, muscleGroup) in map) {
            val date = dateFormatter.parse(dateString)

            if (muscleGroup !in allowedMuscleGroups)
                continue

            if (latestMuscleGroupDates.containsKey(muscleGroup)) {
                val latestDate = latestMuscleGroupDates[muscleGroup]
                if (date.after(latestDate)) {
                    latestMuscleGroupDates[muscleGroup] = date
                }
            } else {
                latestMuscleGroupDates[muscleGroup] = date
            }
        }

        for ((muscleGroup, latestDate) in latestMuscleGroupDates) {
            val difference = abs(currentDate.time - latestDate.time) / (24 * 60 * 60 * 1000)
            val targetDifference = getTargetDifference(muscleGroup)

            if (difference >= targetDifference) {
                muscleGroups.add(muscleGroup)
            }
        }

        return if (muscleGroups.isNotEmpty()) muscleGroups else listOf("Rest")
    }

    private fun getTargetDifference(muscleGroup: String): Int {
        return when (muscleGroup) {
            "Legs" -> 4
            "Chest" -> 3
            "Back" -> 3
            "Arms" -> 2
            else -> 0
        }
    }
}
