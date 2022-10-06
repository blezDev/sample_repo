package com.example.forms

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {

    private lateinit var solo : Solo
    private lateinit var team : TeamFrag
    private lateinit var spinner: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinner = findViewById(R.id.spinner)

        val options = arrayOf("Solo","Team")

        spinner.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options)

        spinner.onItemSelectedListener = object : AdapterView.OnItemClickListener,
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

                when(p2){
                    0 -> selectFrag(Solo())
                    1 -> selectFrag(TeamFrag())
                }
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

            override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                when(p2){
                    0 -> selectFrag(Solo())
                    1 -> selectFrag(TeamFrag())
                }
            }
        }

    }
    private fun selectFrag(frag : Fragment) {
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.Frag,frag)
        transaction.commit()
    }

}