package pl.edu.uwr.pum.todo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputBinding
import android.widget.Button
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import pl.edu.uwr.pum.todo.databinding.Fragment1Binding
import pl.edu.uwr.pum.todo.databinding.FragmentDetailBinding

class FragmentDetail : Fragment() {
    private val dbHolder by lazy {
        DBHolder(requireContext())
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val numlist = requireArguments().getInt("valNum")
        view.findViewById<ViewPager2>(R.id.viewPager).apply {
            adapter = PagerAdapter(dbHolder,numlist)
            println("jasne")
        }

        var button = view.findViewById<Button>(R.id.button4)
        button.setOnClickListener {
            view.findNavController().navigate(
                FragmentDetailDirections.actionFragmentDetailToFragment1(
                    valNum = numlist

                )
            )
        }

        var button1 = view.findViewById<Button>(R.id.button_photos)
        button1.setOnClickListener {
            view.findNavController().navigate(
                FragmentDetailDirections.actionFragmentDetailToFragment4(
                    valNum = numlist

                )
            )
        }
    }

}