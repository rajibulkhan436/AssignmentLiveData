package com.rajibul.assignmentlivedata

import android.app.Dialog
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.rajibul.assignmentlivedata.databinding.ActivityMainBinding
import com.rajibul.assignmentlivedata.databinding.AdditionDialogBinding
import com.rajibul.assignmentlivedata.liveroom.NotesEntity
import com.rajibul.assignmentlivedata.liveroom.NotesViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var notesViewModel: NotesViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        notesViewModel = ViewModelProvider(this)[NotesViewModel::class.java]
        notesViewModel.notesList.observe(this) {
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
            dialogBinding.btnAdd.setOnClickListener {
                if (dialogBinding.etTitle.text.isNullOrEmpty()) {

                } else {
                    notesViewModel.insertNotes(
                        NotesEntity(title = dialogBinding.etTitle.text.toString(),
                            description = dialogBinding.etDescription.text.toString()
                        )
                    )

                }
                dialog.dismiss()

            }
        }
    }

}