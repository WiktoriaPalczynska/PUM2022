package pl.edu.uwr.pum.todo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import pl.edu.uwr.pum.todo.databinding.Fragment3Binding


class Fragment3 : Fragment() {
    private lateinit var binding: Fragment3Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Fragment3Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dbHolder = DBHolder(requireContext())
        val iD = requireArguments().getInt("valId")
        val num = requireArguments().getInt("valNum")
        val bin = Fragment3Binding.inflate(LayoutInflater.from(context))
        bin.apply {

            binding.editTextText1.setText(dbHolder.getElementt(iD)[0])

            binding.buttonSAVE1.setOnClickListener {

                val updateInfo = binding.editTextText1.text.toString()
                if (updateInfo.isNotEmpty()) {
                    dbHolder.updateElement(iD, updateInfo)
                    Toast.makeText(context, "SUCCESS", Toast.LENGTH_SHORT).show()
                }

            }


        }
    }
}