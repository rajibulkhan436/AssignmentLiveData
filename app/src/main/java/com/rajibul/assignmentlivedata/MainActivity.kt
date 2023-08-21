package com.rajibul.assignmentlivedata

import android.app.Dialog
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.TextClock
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.rajibul.assignmentlivedata.databinding.ActivityMainBinding
import com.rajibul.assignmentlivedata.databinding.AdditionDialogBinding
import com.rajibul.assignmentlivedata.liveroom.NotesEntity
import com.rajibul.assignmentlivedata.liveroom.NotesViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var notesViewModel: NotesViewModel
    var layoutManager: LinearLayoutManager?=null
     var list:ArrayList<NotesEntity> = ArrayList()
    lateinit var notesRecycler: NotesRecycler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        notesRecycler= NotesRecycler(list)
        layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding?.rvNotes?.layoutManager = layoutManager
        binding?.rvNotes?.adapter = notesRecycler
        notesViewModel = ViewModelProvider(this)[NotesViewModel::class.java]
        notesViewModel.notesList.observe(this) {
            list.addAll(it)
            notesRecycler.notifyDataSetChanged()
            for (notesEntity in it) {
                System.out.println("in list entity ${notesEntity.id}")
            }
        }

        binding.fabAdd.setOnClickListener {
            var dialog = Dialog(this)
            var dialogBinding = AdditionDialogBinding.inflate(layoutInflater)
            dialog.setContentView(dialogBinding.root)
            //   dialog.getWindow()?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)
            dialog.show()
            dialogBinding.textClock.setOnClickListener{

                Toast.makeText(this@MainActivity, "TextClock",Toast.LENGTH_SHORT).show()
            }
            dialogBinding.btnAdd.setOnClickListener {
                if (dialogBinding.etTitle.text.isNullOrEmpty()) {
                    Toast.makeText(this@MainActivity, "Please Insert Title",Toast.LENGTH_SHORT).show()

                } else {
                    notesViewModel.insertNotes(
                        NotesEntity(title = dialogBinding.etTitle.text.toString(),
                            description = dialogBinding.etDescription.text.toString(),
                            time= dialogBinding.textClock.text.toString()
                        )
                    )
                }
                list.clear()
                dialog.dismiss()


            }
        }
    }

}