package pl.edu.uwr.pum.lista1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    private val Summary: TextView by lazy {findViewById(R.id.textView)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val score = intent.getIntExtra("score", 0)
        val correct = intent.getIntExtra("correct", 0)
        val cheat = intent.getIntExtra("cheat", 0)

        Summary.text = "Zdobyłeś " + score.toString() + " punktów. Wybrałeś " + correct.toString() + " poprawnych odpowiedzi i " + cheat.toString() + " razy oszukałeś. :)"
    }
}
