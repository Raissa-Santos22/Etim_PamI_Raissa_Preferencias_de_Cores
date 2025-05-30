package android.raissa.etimpamiraissapreferenciasdecores

import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.raissa.etimpamiraissapreferenciasdecores.databinding.ActivityMainBinding
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var preferencias: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)

        setContentView(binding.root)
        var cor = ""

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

    private fun salvarCor(cor:String){
        binding.layoutPrincipal.setBackgroundColor(Color.parseColor(cor))
    }

}