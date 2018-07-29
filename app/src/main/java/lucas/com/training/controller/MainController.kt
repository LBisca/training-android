package lucas.com.training.controller

import android.content.res.Resources
import lucas.com.training.R
import lucas.com.training.model.ClientOrder
import lucas.com.training.model.ClientTotal
import lucas.com.training.reader.CsvReader

class MainController {

    val reader = CsvReader()

    fun getClient(resources: Resources, name: String): List<ClientOrder> {
        val list: List<ClientOrder> = getClientOrder(resources)
        return list.filter { it.name == name }
    }

    fun getClientTotal(resources: Resources): List<ClientTotal> {
        val list: List<ClientOrder> = getClientOrder(resources)
        val grouped: Map<String, List<ClientOrder>> = list.groupBy { it.name }

        return grouped.entries.map {
            val name = it.key
            val total = it.value.sumByDouble { it.co2 }
            ClientTotal(name, total)
        }
    }

    fun getClientOrder(resources: Resources): List<ClientOrder> {
        return reader.read(resources.openRawResource(R.raw.client_orders))
    }

}