package com.example.contactapp

import android.content.Intent
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuInflater
import android.view.View
import android.widget.ListView
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.contactapp.databinding.ContactBinding

class MainActivity : ComponentActivity() {
    private lateinit var binding : ContactBinding
    private lateinit var user : ArrayList<User>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ContactBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var listview : ListView = findViewById(R.id.listview)
        val name = arrayOf("Chris","Meg","Peter","Stewy","Brian","Louise","Jotaro","Yoma")
        val ids = arrayOf("01","02","03", "04","05","06","07","08")
        val phone = arrayOf("020214646631","00114446631","00124663631","00146144631","00120426631","0002446631","00124663541","0012146445")
        val email = arrayOf("chris.com@gmail.com","chris1.com@gmail.com","chris2.com@gmail.com"
                            ,"chris3.com@gmail.com","chris4.com@gmail.com","chris5.com@gmail.com"
                             ,"chris6.com@gmail.com","chris7.com@gmail.com")
        user = ArrayList()
        for (i in name.indices) {
            val user1 = User(name[i],ids[i],phone[i],email[i])
            user.add(user1)
        }
        registerForContextMenu(listview)
       binding.listview.isClickable = true
       binding.listview.adapter = MyAdapter(this,user)

       binding.listview.setOnItemClickListener {parent,view,position,id ->
           val name = name[position]
           val phone = phone[position]
           val ids = ids[position]
           val email = email[position]

           val i = Intent(this,UserActivity::class.java)
           i.putExtra("name",name)
           i.putExtra("id",ids)
           i.putExtra("phone",phone)
           i.putExtra("email",email)

           startActivity(i)

       }


    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_exam,menu)
    }
}