package pl.edu.uwr.pum.lista_3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import androidx.viewpager2.widget.ViewPager2


class Fragment4 : Fragment() {
    private val dbHolder by lazy {
        DBHolder(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_4, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val numlist = requireArguments().getInt("valNum")
        view.findViewById<ViewPager2>(R.id.viewPager2).apply {
            adapter = AdapterPhoto(dbHolder,numlist)
        }

        var button = view.findViewById<Button>(R.id.button_add_photo)
        button.setOnClickListener {
            view.findNavController().navigate(
                Fragment4Directions.actionFragment4ToFragment2(
                    valNum = numlist
                )
            )
        }


    }

}