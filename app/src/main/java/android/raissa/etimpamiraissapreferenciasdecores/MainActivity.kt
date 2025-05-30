package android.raissa.etimpamiraissapreferenciasdecores

import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.raissa.etimpamiraissapreferenciasdecores.databinding.ActivityMainBinding
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding

    companion object{
        const val NOME_ARQUIVO = "arquivo.prefs.xml"
    }

    private var cor = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.bntCor1.setOnClickListener{
            cor = "#FD2A2A"
            salvarCor(cor)
        }

        binding.bntCor2.setOnClickListener{
            cor = "#00BCD4"
            salvarCor(cor)
        }

        binding.bntCor3.setOnClickListener{
            cor = "#9C2780"
            salvarCor(cor)
        }

        binding.bntCor4.setOnClickListener{
            cor = "#4CAF50"
            salvarCor(cor)
        }
        binding.bntCor5.setOnClickListener{
            cor = "#FFEB3B"
            salvarCor(cor)
        }

    }

    override fun onResume() {
        super.onResume()

        val preferencias = getSharedPreferences(NOME_ARQUIVO, MODE_PRIVATE)
        val cor = preferencias.getString("cor", "")

        if(cor!!.isNotEmpty()){
            binding.layoutPrincipal.setBackgroundColor(Color.parseColor(cor))
        }
    }

    private fun salvarCor(cor:String){

        binding.layoutPrincipal.setBackgroundColor(Color.parseColor(cor))

        binding.bntTrocar.setOnClickListener {view ->
            var preferencias = getSharedPreferences(NOME_ARQUIVO, MODE_PRIVATE)
            var editor = preferencias.edit()
            editor.putString("cor", cor)
            editor.putString("nome","Raissa")
            editor.putString("sobrenome", "Santos")
            editor.putInt("idade", 17)
            editor.apply()

            snackBar(view)
        }
    }

    private fun snackBar(view:View){
        val snackbar = Snackbar.make(view, "Cor de fundo trocada com sucesso!", Snackbar.LENGTH_INDEFINITE)
        snackbar.setAction("OK"){

        }
        snackbar.setActionTextColor(Color.BLUE)
        snackbar.setBackgroundTint(Color.LTGRAY)
        snackbar.setTextColor(Color.GREEN)
        snackbar.show()
    }

}