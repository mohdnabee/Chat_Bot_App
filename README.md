# 🤖 Gemini AI Chat Bot (Jetpack Compose)

A **simple, clean AI chat bot Android app** built using **Jetpack Compose** and **Google Gemini AI**.
This project focuses on **chat-only functionality** with a modern Compose UI.

---

## 📱 Project Overview

**Project Name:** Gemini AI Chat Bot
**Platform:** Android
**UI Framework:** Jetpack Compose
**AI Model:** Google Gemini (Chat only)

The app allows users to chat with Gemini AI in real time using a minimal and responsive UI.

---

## ✨ Features

* 💬 Real-time AI chat using **Gemini API**
* 🎨 Modern UI built with **Jetpack Compose**
* ⚡ Fast and lightweight
* 🌙 Material 3 support (Light/Dark theme)
* 📱 Responsive layout for all screen sizes
* ❌ No image generation
* ❌ No voice input/output

---

## 🧠 AI Model Used

* **Model Name:** `gemini-1.5-flash` (or latest supported)
* **Usage Type:** Chat-based text responses only

---

## 🛠 Tech Stack

* **Language:** Kotlin
* **UI:** Jetpack Compose
* **Architecture:** MVVM
* **Networking:** Retrofit + OkHttp
* **State Management:** ViewModel + State
* **AI API:** Google Gemini

---

## 📂 Project Structure

```
com.example.geminiaichatbot
│
├── ui
│   ├── screens
│   │   └── ChatScreen.kt
│   ├── components
│   │   ├── ChatBubble.kt
│   │   └── MessageInput.kt
│
├── viewmodel
│   └── ChatViewModel.kt
│
├── network
│   ├── GeminiApi.kt
│   └── ApiClient.kt
│
├── model
│   └── ChatMessage.kt
│
└── MainActivity.kt
```

---

## 🔑 API Key Setup

1. Create a Gemini API key from **Google AI Studio**
2. Store the key securely (recommended: `local.properties`)

```
GEMINI_API_KEY=your_api_key_here
```

---

## 🚀 How It Works

1. User enters a message
2. Message is sent to Gemini API
3. Gemini generates a response
4. Response is displayed in chat UI

---

## 📸 Screenshorts 

<img width="300" height="650" alt="Screenshot_20260201_234432" src="https://github.com/user-attachments/assets/7e089276-4dc0-476f-bbf5-7c31e314edd2" />
<img width="300" height="650" alt="Screenshot_20260201_234502" src="https://github.com/user-attachments/assets/79e0ff01-1eed-4be3-a220-10132ae9419b" />
<img width="300" height="650" alt="Screenshot_20260201_234531" src="https://github.com/user-attachments/assets/b9c5ff6f-9d69-4bed-96a7-4af2eed2fe7b" />




---

## ⚠️ Limitations

* Internet connection required
* Free API usage may have rate limits
* Chat-only (no image, no audio)

---

## 📌 Future Improvements

* Chat history storage
* Message copy/share option
* Typing animation
* Markdown support

---

## 👨‍💻 Author

**Nabeel**
Android Developer | Jetpack Compose Enthusiast

---

## 📜 License

This project is for **learning and educational purposes**.

---

⭐ If you like this project, give it a star and keep building!
