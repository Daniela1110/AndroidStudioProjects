package com.example.mycrud

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.Adapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.example.mycrud.adapter.UserAdapter
import com.example.mycrud.data.AppDatabase
import com.example.mycrud.data.entity.User
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var  fab: FloatingActionButton
    private var list = mutableListOf<User>()
    private lateinit var adapter: UserAdapter
    private lateinit var database: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)
        fab =findViewById(R.id.fab)

           database = AppDatabase.getInstance(applicationContext)
           adapter = UserAdapter(list)
           adapter.setDialog(object : UserAdapter.Dialog{

               override fun onClick(position: Int) {
                  val dialog = AlertDialog.Builder(this@MainActivity)
                   dialog.setTitle(list[position].fullName)
                   dialog.setItems(R.array.items_option, DialogInterface.OnClickListener{dialog, which ->
                       if (which==0){
                           val intent = Intent(this@MainActivity, EditorActivity::class.java)
                           intent.putExtra("id",list[position].vid)
                           startActivity(intent)
                       }else if(which==1){
                           database.userDao().delete(list[position])
                           getData()
                       }else{
                           dialog.dismiss()
                       }

                   })
                   val dialogView = dialog.create()
                   dialogView.show()
               }

           })

        recyclerView.adapter =adapter
        recyclerView.layoutManager  = LinearLayoutManager(applicationContext,VERTICAL, false)
        recyclerView.addItemDecoration(DividerItemDecoration(applicationContext,VERTICAL))


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
            fab.setOnClickListener {
                startActivity(Intent(this, EditorActivity::class.java))

               }
        }

         override fun onResume(){
            super.onResume()
            getData()
        }

        @SuppressLint("NotifyDataSetChanged")
        fun getData(){
           list.clear()
            list.addAll(database.userDao().getAll())
            adapter.notifyDataSetChanged()
        }
    }
