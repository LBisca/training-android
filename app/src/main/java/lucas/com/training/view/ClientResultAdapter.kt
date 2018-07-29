package lucas.com.training.view

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.client_adapter.view.*
import kotlinx.android.synthetic.main.result_adapter.view.*
import lucas.com.training.R
import lucas.com.training.model.ClientOrder
import java.util.zip.Inflater

class ClientResultAdapter(
        val list: List<ClientOrder>
) : RecyclerView.Adapter<ClientResultAdapter.ClientResultViewHolder>() {

    class ClientResultViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val order: TextView = view.tv_orderId
        val distance: TextView = view.tv_distance
        val co2: TextView = view.tv_co2
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ClientResultViewHolder {
        return ClientResultViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.result_adapter, parent, false))
    }

    override fun getItemCount(): Int = list.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ClientResultViewHolder, index: Int) {
        holder.order.text = "Order ID: ${list[index].order}"
        holder.distance.text = "Distance: ${list[index].distance}"
        holder.co2.text = "CO2 Saved: ${list[index].co2}"
    }
}