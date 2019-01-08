package com.example.odongju.mywebbrowser

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.inputmethod.EditorInfo
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 웹뷰 기본 설정
        webview.apply {
            settings.javaScriptEnabled = true
            webViewClient = WebViewClient()
        }
        webview.loadUrl("https://www.google.com")

        urlInput.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                webview.loadUrl(urlInput.text.toString())
                true
            } else {
                false
            }
        }


        // 컨텍스트 메뉴 등록
        registerForContextMenu(webview)
    }

    // 옵션 메뉴 작성
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    // 9.0버전부터 http 보안문제로 매니페스트를 추가해줘야 작동됩니다.
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.action_google, R.id.action_home -> {
                webview.loadUrl("http://www.google.com")
                return true
            }
            R.id.action_naver -> {
                webview.loadUrl("http://www.naver.com")
                return true
            }
            R.id.action_daum -> {
                webview.loadUrl("http://www.daum.net")
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {

        if (webview.canGoBack()) {
            webview.goBack()
        } else {
            super.onBackPressed()
        }
    }


}
