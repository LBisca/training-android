package lucas.com.training.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.client_adapter.*
import lucas.com.training.R
import lucas.com.training.controller.MainController
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private val controller = MainController()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val clientTotal = controller.getClientTotal(resources)
        val clientOrder = controller.getClientOrder(resources)

        rv_main.layoutManager = LinearLayoutManager(this)
        rv_main.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))


        rv_main.adapter = ClientAdapter(clientTotal, this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == (R.id.sort_list)) {
            val sortedList = controller.getClientTotal(resources).sortedByDescending { it.total }
            rv_main.adapter = ClientAdapter(sortedList, this)
        }

        return true
    }
}
