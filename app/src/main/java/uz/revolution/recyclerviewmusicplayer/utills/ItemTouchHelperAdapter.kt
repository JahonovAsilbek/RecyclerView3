package uz.revolution.recyclerviewmusicplayer.utills

interface ItemTouchHelperAdapter {

    fun OnItemMove(fromPosition: Int, toPosition: Int)

    fun onItemDismiss(position: Int)

}