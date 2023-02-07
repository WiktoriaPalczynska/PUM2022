package pl.edu.uwr.pum.todo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView

class AdapterMain: RecyclerView.Adapter<AdapterMain.listMainViewHolder>() {
    private val lista = ListsObject.list

    inner class listMainViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        val listNameButton: Button = itemView.findViewById(R.id.button2)
        fun bind(item: Lists) {
            println(item.id.toString())
            listNameButton.text = item.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): listMainViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.list_view, parent, false)

        return listMainViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: listMainViewHolder, position: Int) {
        val currentItem = lista[position]
        holder.bind(currentItem)
        holder.listNameButton.setOnClickListener {
            holder.listNameButton.findNavController().navigate(
                FragmentMainDirections.actionFragmentMainToFragmentDetail(
                    valNum = lista[position].num

                )
            )
        }

    }

    override fun getItemCount(): Int {
        return lista.size
    }
}