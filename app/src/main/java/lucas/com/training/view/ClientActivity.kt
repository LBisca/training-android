package lucas.com.training.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_client.*
import lucas.com.training.R
import lucas.com.training.controller.MainController
import lucas.com.training.model.ClientOrder

class ClientActivity : AppCompatActivity() {

    val controller = MainController()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_client)

        val name = intent.getStringExtra("name")

        tv_title.text = name
        val clientResult: List<ClientOrder> = controller.getClient(resources, name)

        rv_client.layoutManager = LinearLayoutManager(this)
        rv_client.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
        rv_client.adapter = ClientResultAdapter(clientResult)
    }
}
