package com.fredhappyface.ewesticker

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import java.io.File

class StickerPackAdapter(
	private val iconSize: Int,
	private val stickers: Array<File>,
	private val listener: StickerClickListener
) :


	RecyclerView.Adapter<StickerPackViewHolder>() {

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StickerPackViewHolder {
		val itemView = LayoutInflater.from(parent.context)
			.inflate(R.layout.sticker_card, parent, false)
		return StickerPackViewHolder(itemView)
	}

	override fun onBindViewHolder(holder: StickerPackViewHolder, position: Int) {
		val stickerFile = stickers[position]
		holder.stickerThumbnail.load(stickerFile)
		holder.stickerThumbnail.layoutParams.height = iconSize
		holder.stickerThumbnail.layoutParams.width = iconSize
		holder.stickerThumbnail.tag = stickerFile
		holder.stickerThumbnail.setOnClickListener {
			val file = it.tag as File
			listener.onStickerClicked(file)
		}
	}

	override fun getItemCount(): Int = stickers.size
}
