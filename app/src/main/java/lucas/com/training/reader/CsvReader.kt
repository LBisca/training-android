package lucas.com.training.reader

import lucas.com.training.model.ClientOrder
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

class CsvReader {

    fun read(inputStream: InputStream): List<ClientOrder> {
        val reader = InputStreamReader(inputStream)
        val bufferedReader = BufferedReader(reader)
        val list = readLines(bufferedReader, mutableListOf())

        return list.map {
            val tokens = it.split(",")
            val name = tokens[0]
            val order = tokens[1].toInt()
            val distance = tokens[2].toDouble()
            val co2 = (distance / 1000) * 0.113

            ClientOrder(name, order, distance, co2)
        }
    }

    fun readLines(bufferedReader: BufferedReader, list: MutableList<String>): List<String> {
        val newLine = bufferedReader.readLine()
        return if (newLine != null) {
            list.add(newLine)
            readLines(bufferedReader, list)
        } else {
            list
        }
    }
}