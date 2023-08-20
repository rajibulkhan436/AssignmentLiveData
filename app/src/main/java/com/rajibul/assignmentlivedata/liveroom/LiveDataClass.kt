package com.rajibul.assignmentlivedata.liveroom

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class LiveDataClass():ViewModel() {
        var data : MutableLiveData<NotesEntity> = MutableLiveData()
    }
