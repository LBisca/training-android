package lucas.com.training.view

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.client_adapter.view.*
import lucas.com.training.R
import lucas.com.training.model.ClientTotal

class ClientAdapter(
        val list: List<ClientTotal>,
        private val context: Context
) : RecyclerView.Adapter<ClientAdapter.ClientViewHolder>() {

    class ClientViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvName: TextView = view.tv_name
        val tvTotal: TextView = view.tv_total
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ClientViewHolder {
        return ClientViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.client_adapter, parent, false) )
    }

    override fun getItemCount(): Int = list.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ClientViewHolder, index: Int) {
        holder.tvName.text = list[index].name
        val formatted = String.format("%.3f", list[index].total)
        holder.tvTotal.text = formatted
        holder.tvName.setOnClickListener{
            val intent = Intent(context, ClientActivity::class.java)
            intent.putExtra("name",list[index].name)
            startActivity(context, intent, null)
        }
    }
}
