package uz.revolution.recyclerviewmusicplayer.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_music.view.*
import uz.revolution.recyclerviewmusicplayer.R
import uz.revolution.recyclerviewmusicplayer.models.Music
import uz.revolution.recyclerviewmusicplayer.utills.ItemTouchHelperAdapter
import java.util.*
import kotlin.collections.ArrayList

class MusicAdapter(var listMusic: ArrayList<Music>) : RecyclerView.Adapter<MusicAdapter.VH>(), ItemTouchHelperAdapter{

    inner class VH(itemView: View):RecyclerView.ViewHolder(itemView){
        fun onBind(music: Music) {
            itemView.author.text = music.author
            itemView.name.text = music.name

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(LayoutInflater.from(parent.context).inflate(R.layout.item_music, parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(listMusic[position])
    }

    override fun getItemCount(): Int {
        return listMusic.size
    }

    override fun OnItemMove(fromPosition: Int, toPosition: Int) {
        if (fromPosition < toPosition) {
            for (i in fromPosition until toPosition) {
                Collections.swap(listMusic, i, i + 1)
            }
        } else {
            for (i in fromPosition until toPosition + 1) {
                Collections.swap(listMusic, i, i - 1)
            }
        }
        notifyItemMoved(fromPosition,toPosition)
    }

    override fun onItemDismiss(position: Int) {
        listMusic.removeAt(position)
        notifyItemRemoved(position)
    }
}