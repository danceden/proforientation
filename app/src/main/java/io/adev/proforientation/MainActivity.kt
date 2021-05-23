package io.adev.proforientation

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.main_activity)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer, QuestionFragment())
            .commit()
    }
}