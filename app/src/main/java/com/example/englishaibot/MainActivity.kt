package com.example.englishaibot

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.example.englishaibot.Activity.BaseActivity
import com.example.englishaibot.ui.theme.EasyBotTheme


class MainActivity : BaseActivity() {
    @RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val  ChatViewModel = ViewModelProvider(this)[ChatViewModel:: class.java]
        setContent {
            EasyBotTheme() {
                Scaffold(modifier = Modifier.fillMaxSize()) {innerPadding ->

                    ChatPage(modifier = Modifier.padding(innerPadding),
                        ChatViewModel)

                }
            }
            }
        }
    }

