package com.hnatiuk.maxim.pages.second

import android.annotation.SuppressLint
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations.map
import androidx.lifecycle.viewModelScope
import com.hnatiuk.maxim.entities.ToDo
import com.hnatiuk.maxim.repositories.TodoRepository
import com.hnatiuk.maxim.storage.OpeningDao
import kotlinx.coroutines.launch

@SuppressLint("StaticFieldLeak")
class SecondPageViewModel(application: Application) : AndroidViewModel(application) {

    companion object {
        private const val STAR_IMAGE_URL = "https://upload.wikimedia.org/wikipedia/commons/thumb/1/18/Five-pointed_star.svg/1200px-Five-pointed_star.svg.png"
        private const val SUN_IMAGE_URL = "https://solarsystem.nasa.gov/system/basic_html_elements/11561_Sun.png"
    }

    private val context = getApplication<Application>().applicationContext
    private val openingDao by lazy { OpeningDao(context) }
    private val toDoRepository by lazy { TodoRepository }

    private val toDoEntity = MutableLiveData<ToDo>()

    val openingTimes = MutableLiveData<Int>()
    val id: LiveData<Int> = map(toDoEntity) { it.id }
    val title: LiveData<String> = map(toDoEntity) { it.title }
    val statusLogo: LiveData<String> = map(toDoEntity) {
        if (it.completed) STAR_IMAGE_URL else SUN_IMAGE_URL
    }
    val isProgressVisible = MutableLiveData<Boolean>()

    fun load() {
        openingTimes.value = openingDao.getOpeningTimes()

        viewModelScope.launch {
            val id = openingTimes.value
            checkNotNull(id)

            isProgressVisible.value = true
            val toDo = toDoRepository.getTodoById(id)
            toDoEntity.value = toDo
            isProgressVisible.value = false
        }
    }
}
