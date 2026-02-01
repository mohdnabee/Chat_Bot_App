package com.example.englishaibot


import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.content
import kotlinx.coroutines.launch

class ChatViewModel: ViewModel() {

 val  messageList by  lazy {   mutableStateListOf<ModelActivity>() }

  val  generativeModel : GenerativeModel = GenerativeModel(
      modelName = "gemini-flash-latest",
      apiKey = Data.apiKey
  )

    @RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
    fun sendMessage(question : String){
        viewModelScope.launch {
            try {
                val  chat =  generativeModel.startChat(
                    history = messageList.map {
                        content (it.role){text(it.message)}
                    }.toList()
                )
                messageList.add(ModelActivity(question,"user"))
                messageList.add(ModelActivity("waiting","model"))

                val  response = chat.sendMessage(question)
                messageList.removeLast()
                messageList.add(ModelActivity(response.text.toString(), role = "model"))
            } catch (e: Exception){
                messageList.removeLast()
                messageList.add(ModelActivity("Error" + e.message.toString(),
                   "model" ))
            }
        }
    }



}