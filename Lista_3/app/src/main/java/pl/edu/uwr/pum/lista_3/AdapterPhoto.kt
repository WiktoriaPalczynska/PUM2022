package pl.edu.uwr.pum.lista_3

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import pl.edu.uwr.pum.lista_3.databinding.DetailViewBinding
import pl.edu.uwr.pum.lista_3.databinding.Fragment4Binding
import pl.edu.uwr.pum.lista_3.databinding.PhotoViewBinding

class AdapterPhoto (private val dbHolder: DBHolder, private val number: Int): RecyclerView.Adapter<AdapterPhoto.ViewHolder>() {
    class ViewHolder(private var itemBinding: PhotoViewBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        val del = itemBinding.DELETEPhoto

        fun bind(text: Table){
            if(text.opis != "none") {
                itemBinding.imageView.setImageURI(Uri.parse(text.opis))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = PhotoViewBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(dbHolder.getElementtt(number)[position])
        holder.del.setOnClickListener {
            dbHolder.deleteElement(dbHolder.getElementtt(number)[position].id)
            notifyDataSetChanged()
        }

    }

    override fun getItemCount(): Int{
        return dbHolder.getElementtt(number).size
    }
}