package pl.edu.uwr.pum.lista_3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import pl.edu.uwr.pum.lista_3.databinding.Fragment1Binding

class Fragment1 : Fragment() {
    private lateinit var binding: Fragment1Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment1Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dbHandler = DBHolder(requireContext())
        val numberoflist = requireArguments().getInt("valNum")
        val bin = Fragment1Binding.inflate(LayoutInflater.from(context))
        bin.apply {

            binding.buttonSAVE.setOnClickListener{

                val updateInfo = binding.editTextText.text.toString()
                if (updateInfo.isNotEmpty()) {
                    val d = Table(0,0,updateInfo,numberoflist,0)
                    dbHandler.addElement(d)
                    Toast.makeText(context, "SUCCESS", Toast.LENGTH_SHORT).show()
                }

            }

        }

    }
}