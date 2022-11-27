package pl.edu.uwr.pum.lista2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class Fragment_2 : Fragment() {
    private val module by lazy {
        val moduleId = arguments?.getInt("moduleId")
            ?: throw IllegalArgumentException("moduleId doesn't exist")
        Crime_Info_Object.crime[moduleId - 1]
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_fragment2, container, false)
    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)

        itemView.findViewById<TextView>(R.id.case_id).text = "#" + module.Id.toString()
        itemView.findViewById<TextView>(R.id.student_name).text = module.name
        itemView.findViewById<TextView>(R.id.case_info).text = module.detal
        val casePro: String
        if (module.caseProcess == true){
            casePro = "Solved"
        }
        else{
            casePro = " In progress"
        }
        itemView.findViewById<TextView>(R.id.case_isSolve).text = casePro
        itemView.findViewById<TextView>(R.id.case_date).text = module.crimeDate

    }

}