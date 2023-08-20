package com.rajibul.assignmentlivedata

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.rajibul.assignmentlivedata.databinding.ActivityMainBinding
import com.rajibul.assignmentlivedata.databinding.AdditionDialogBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fabAdd.setOnClickListener {
            var dialog= Dialog(this)
         //   var dialogBinding = AdditionDialogBinding.inflate(layoutInflater)
            dialog.setContentView(R.layout.addition_dialog)
            dialog.getWindow()?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)
            dialog.show()



        }
    }
}