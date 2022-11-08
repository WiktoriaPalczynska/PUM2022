package pl.edu.uwr.pum.lista1

import android.content.Intent
import android.content.Intent.CATEGORY_BROWSABLE
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Question(
    val question: String,
    val answer: Int
)

object Questions{
    val questions = listOf<Question>(
        Question("Przechodzenie substancji ze stanu stałego w stan gazowy to sublimacja.",1),
        Question("Podstawową jednostką szybkości w ruchu jednostajnym jest 1 m/s.",1),
        Question("Dyfrakcja to zjawisko odbicia fali.",0),
        Question("Ładunek elementarny e = 9,81 m/s^2.",0),
        Question("Długość fali λ to droga, jaką przebywa fala w czasie, gdy dowolna cząsteczka ośrodka wykonuje jedno pełne drganie.",1),
        Question("Moc prądu (moc elektryczna) jest pracą, jaką wykonuje energia elektryczna w danym okresie.",1),
        Question("Jednostką mocy jest Volt.",0),
        Question("Amperomierz to przyrząd do pomiaru natężenia prądu.",1),
        Question("Ultradźwięki to fale dźwiękowe o częstotliwości powyżej 20 000 Hz, słyszalne dla człowieka.",0),
        Question("Szkło, drewno lub porcelana są izolatorami.",1),

        )
}

class MainActivity : AppCompatActivity() {
    private val textView: TextView by lazy {findViewById(R.id.textView2)}
    private val tak: Button by lazy {findViewById(R.id.buttonT)}
    private val nie: Button by lazy {findViewById(R.id.buttonN)}

    var count = 0 //zmienna ustalająca na któym jestem pytaniu
    var score = 0 //licznik punktów
    var cheat = 0 //licznik oszustw
    var correct = 0 //licznik poprawnych

    val text_question: List<Question> = Questions.questions //tresc pytania

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState != null) {
            count = savedInstanceState.getInt("count")
            score = savedInstanceState.getInt("score")
            cheat = savedInstanceState.getInt("cheat")
            correct = savedInstanceState.getInt("correct")

        }

        setContentView(R.layout.activity_main)
        tak.setOnClickListener {onClickButton(1)}   //który przycisk kliknięty
        nie.setOnClickListener {onClickButton(0)}
        textView.text = text_question[count].question

        //obsluga przycisku 'oszukuj' i wyszukiwanie frazy w przegladarce
        findViewById<Button>(R.id.buttonO).setOnClickListener{
            val url = "https://www.google.com/search?q=" + text_question[count].question
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url)).apply{
                addCategory(CATEGORY_BROWSABLE)

            }

            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }
            cheat+=1
            score-=15
            println(score)
        }

    }

    fun onClickButton(click:Int) {
        val answers = text_question[count].answer //answers pobiera odpowiedz do odpowiedniego pytania
        if(click==answers)
        {
            score +=10
            correct+=1
            println(score)
        }
        println(count)
        count++
        if (count>9)
        {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("score",score)
            intent.putExtra("correct",correct)
            intent.putExtra("cheat",cheat)
            startActivity(intent)

        }
        else {
            textView.text = text_question[count].question //wyswietl kolejne pytanie
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("count", count)
        outState.putInt("score", score)
        outState.putInt("cheat", cheat)
        outState.putInt("correct", correct)
    }

}