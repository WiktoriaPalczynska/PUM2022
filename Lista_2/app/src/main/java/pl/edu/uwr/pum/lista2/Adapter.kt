package pl.edu.uwr.pum.lista2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.navigation.findNavController


class Adapter: RecyclerView.Adapter<Adapter.ListViewHolder>() {

    private val crimeList = Crime_Info_Object.crime

    inner class ListViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {
        val caseId: TextView = itemView.findViewById(R.id.case_id_list)
        val caseData: TextView = itemView.findViewById(R.id.casedetal)
        val image: ImageView = itemView.findViewById(R.id.image)
        fun bind(item: Crime_Info) {
            caseId.text = "#" + item.Id.toString()
            caseData.text = item.crimeDate
            if (item.caseProcess == true){
                image.setImageResource(R.drawable.ic_baseline_check_circle_outline_24)

            }else{
                image.setImageResource(R.drawable.ic_baseline_change_circle_24)

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.list_view, parent, false)

        return  ListViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val currentItem = crimeList[position]
        holder.bind(currentItem)
        holder.itemView.setOnClickListener {
            holder.itemView.findNavController().navigate(
                Fragment_1Directions.actionFragment1ToFragment2(
                    moduleId = currentItem.Id
                )
            )
        }
    }

    override fun getItemCount(): Int {
        return crimeList.size
    }
}