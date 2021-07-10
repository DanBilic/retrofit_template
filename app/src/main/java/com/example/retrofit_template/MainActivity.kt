package com.example.retrofit_template

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofit_template.adapter.MyAdapter
import com.example.retrofit_template.databinding.ActivityMainBinding
import com.example.retrofit_template.model.Post
import com.example.retrofit_template.repository.Repository
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    private lateinit var binding: ActivityMainBinding
    private val myAdapter by lazy {MyAdapter()}



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpRecyclerView()

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        // viewModel.getCustomPosts(2, "id", "desc")
        val myPost = Post(2,2, "Daniel", "Developer")
        viewModel.pushPost(myPost)
        viewModel.myResponse.observe(this, Observer { response ->
            if(response.isSuccessful){
                Log.d("Body:", response.body().toString())
                Log.d("Headers:", response.headers().toString())
            }else{
                Toast.makeText(this, response.code(), Toast.LENGTH_SHORT).show()
            }

        })
        /*
        viewModel.myCustomPosts.observe(this, Observer { response ->
            if(response.isSuccessful){
                response.body()?.let { myAdapter.setData(it) }
            }else{
                Toast.makeText(this, response.code(), Toast.LENGTH_SHORT).show()
            }

        })
        */

        /*
        val options: HashMap<String, String> = HashMap()
        options["_sort"] = "id"
        options["_order"] = "desc"

        binding.button.setOnClickListener {

            val myNumber = binding.numberEditText.text.toString()
            viewModel.getCustomPosts2(Integer.parseInt(myNumber), options)
            viewModel.myCustomPosts2.observe(this, Observer { response ->
                if(response.isSuccessful){
                    binding.textView.text = response.body().toString()
                }else{
                    binding.textView.text = response.body().toString()
                }
            })
        }
        */




    }

    private fun setUpRecyclerView(){
        binding.recyclerView.adapter = myAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }
}