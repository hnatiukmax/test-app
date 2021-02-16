package com.hnatiuk.maxim.pages.opening

import android.annotation.SuppressLint
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hnatiuk.maxim.storage.OpeningDao

@SuppressLint("StaticFieldLeak")
class OpeningViewModel(application: Application) : AndroidViewModel(application) {

    private val context = getApplication<Application>().applicationContext
    private val openingDao by lazy {
        OpeningDao(context)
    }

    val onOpenSecondPage = MutableLiveData<Any>()

    fun onOpenSecondPageClick() {
        openingDao.increaseOpeningTimes()
        onOpenSecondPage.value = null
    }
}