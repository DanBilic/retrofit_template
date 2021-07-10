package com.example.retrofit_template

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.retrofit_template.databinding.ActivityMainBinding
import com.example.retrofit_template.repository.Repository

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    private lateinit var binding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

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



    }
}