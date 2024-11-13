package com.desafiolatam.coroutines.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.desafiolatam.coroutines.data.TaskEntity
import com.desafiolatam.coroutines.repository.TaskRepositoryImp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import repository.TaskRepository
import javax.inject.Inject


class TaskViewModel @Inject constructor(private val repository: TaskRepository) : ViewModel() {

    val tasks: Flow<List<TaskEntity>> = repository.getTasks()

    fun addTask(task: TaskEntity) {
        viewModelScope.launch {
            repository.addTask(task)
        }
    }

    fun deleteTask(task: TaskEntity) {
        viewModelScope.launch {
            repository.deleteTask(task)
        }
    }

    fun completeTask(task: TaskEntity, isCompleted: Boolean) {
        viewModelScope.launch {
            repository.isTaskCompleted(task, isCompleted)
        }
    }
}