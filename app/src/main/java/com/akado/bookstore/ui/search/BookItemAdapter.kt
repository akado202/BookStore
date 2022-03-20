package com.akado.bookstore.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.akado.bookstore.databinding.ViewBookItemRowBinding
import com.akado.bookstore.domain.model.BookItemDomainModel

class BookItemAdapter(
    private var onItemClickListener: OnItemClickListener? = null
) : RecyclerView.Adapter<BookItemAdapter.ViewHolder>() {

    private var items: MutableList<BookItemDomainModel> = mutableListOf()

    interface OnItemClickListener {
        fun onItemClick(model: BookItemDomainModel)
    }

    fun updateItems(items: List<BookItemDomainModel>) {
        val diffCallback = DiffUtilCallback(this.items, items)
        val diffResult = DiffUtil.calculateDiff(diffCallback)

        this.items.run {
            clear()
            addAll(items)
        }
        diffResult.dispatchUpdatesTo(this)
    }

    fun setOnItemClickListener(listener: OnItemClickListener?) {
        this.onItemClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ViewBookItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = items[position]
        holder.bind(model)
        holder.binding.vAction.setOnClickListener { onItemClickListener?.onItemClick(model) }
    }

    class ViewHolder(val binding: ViewBookItemRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: BookItemDomainModel) {
            binding.viewModel = model
        }
    }

    class DiffUtilCallback(
        private val oldList: List<BookItemDomainModel>,
        private val newList: List<BookItemDomainModel>
    ) : DiffUtil.Callback() {
        override fun getOldListSize(): Int = oldList.size

        override fun getNewListSize(): Int = newList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            oldList[oldItemPosition] == newList[newItemPosition]

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            val oldItem = oldList[oldItemPosition]
            val newItem = newList[newItemPosition]

            return oldItem.title == newItem.title
                    && oldItem.subTitle == newItem.subTitle
                    && oldItem.isbn13 == newItem.isbn13
                    && oldItem.price == newItem.price
                    && oldItem.image == newItem.image
                    && oldItem.url == newItem.url
        }
    }
}