package pl.edu.uwr.pum.todo

import  pl.edu.uwr.pum.todo.MainActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import pl.edu.uwr.pum.todo.databinding.DetailViewBinding


class PagerAdapter (private val dbHolder: DBHolder, private val number: Int): RecyclerView.Adapter<PagerAdapter.ViewHolder>() {
    class ViewHolder(private var itemBinding: DetailViewBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        val del = itemBinding.DELETE
        val edit = itemBinding.EDIT
        fun bind(text: Table){
            println(text)
            itemBinding.textView.text = text.opis
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = DetailViewBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(dbHolder.getElement(number)[position])
        holder.del.setOnClickListener {
            dbHolder.deleteElement(dbHolder.getElement(number)[position].id)
            notifyDataSetChanged()
        }
        holder.edit.setOnClickListener {
            holder.itemView.findNavController().navigate(
                FragmentDetailDirections.actionFragmentDetailToFragment3(
                    valId = dbHolder.getElement(number)[position].id
                )
            )
        }
    }

    override fun getItemCount(): Int{
        return dbHolder.getElement(number).size
    }
}