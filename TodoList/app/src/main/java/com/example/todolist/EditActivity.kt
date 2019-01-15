package com.example.todolist

import android.annotation.SuppressLint
import android.icu.util.Calendar
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.todolist.R.id.*
import io.realm.Realm
import io.realm.kotlin.createObject
import io.realm.kotlin.where
import kotlinx.android.synthetic.main.activity_edit.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.yesButton

class EditActivity : AppCompatActivity() {

    var realm = Realm.getDefaultInstance() // 인스턴스 받기

    val calendar: Calendar = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        Calendar.getInstance()
    } else {
        TODO("VERSION.SDK_INT < N")
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        // 업데이트 조건
        val id = intent.getLongExtra("id", -1L)
        if (id == -1L) {
            insertMode()
        } else {
            updateMode(id)
        }

        // 캘린더뷰의 날짜를 선택했을 때 Caleandar 객체에 설정
        calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                calendar.set(Calendar.YEAR, year)
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                calendar.set(Calendar.MONTH, month)
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            }
        }
    }


    // 추가 모드 초기화
    @SuppressLint("RestrictedApi")
    private fun insertMode() {
        // 삭제 버튼을 감추기
        deleteFab.visibility = View.GONE

        // 완료 버튼을 클릭하면 추가
        fab.setOnClickListener {
            insertTodo()
        }
    }

    // 수정 모드 초기화
    private fun updateMode(id: Long) {
        // id에 해당하는 객체를 화면에 표시
        val todo = realm.where<Todo>().equalTo("id", id).findFirst()!!
        todoEditText.setText(todo.title)
        calendarView.date = todo.date

        // 완료 버튼을 클릭하면 수정
        fab.setOnClickListener {
            updateTodo(id)
        }

        // 삭제 버튼을 클릭하면 삭제
        deleteFab.setOnClickListener {
            deleteTodo(id)
        }
    }
    private fun insertTodo() {
        realm.beginTransaction() // 트랜잭션 시작

        val newItem = realm.createObject<Todo>(nextId()) // 새 객체 생성

        // 값 설정
        newItem.title = todoEditText.text.toString()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            newItem.date = calendar.timeInMillis
        }

        realm.commitTransaction() // 트랜잭션 종료 반영

        // 다이얼로그 표시
        alert("내용이 추가되었습니다.") {
            yesButton { finish() }
        }.show()
    }

    private fun updateTodo(id: Long) {
        realm.beginTransaction()

        val updateItem = realm.where<Todo>().equalTo("id", id).findFirst()!!
        // 값 수정
        updateItem.title = todoEditText.text.toString()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            updateItem.date = calendar.timeInMillis
        }

        realm.commitTransaction()

        // 다이얼로그 표시
        alert("내용이 변경되었습니다.") {
            yesButton { finish() }
        }.show()
    }

    private fun deleteTodo(id: Long) {
        realm.beginTransaction()
        val todo = realm.where<Todo>().equalTo("id", id).findFirst()!!
        // 삭제할 객체
        todo.deleteFromRealm()
        realm.commitTransaction()

        alert("내용이 삭제되었습니다.") {
            yesButton { finish() }
        }.show()
    }

    // 다음 Id를 반환
    private fun nextId(): Int {
        val maxID = realm.where<Todo>().max("id")
        if (maxID != null) {
            return maxID.toInt() + 1
        }
        return 0
    }


    override fun onDestroy() {
        super.onDestroy()
        realm.close() // 인스턴스 해제
    }
}
