package com.example.projeto_kotlin

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.Gravity
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Criar um FrameLayout como contêiner pai
      val containerLayout = FrameLayout(this).apply {
        setBackgroundColor(Color.parseColor("#006400")) // Cor de fundo verde escuro
      }


      // Criar um LinearLayout para o cartão de visita
        val cardLayout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            setPadding(38, 38, 38, 38)

          // Definir um GradientDrawable para a borda e fundo do cartão
          val border = GradientDrawable()
          border.setColor(Color.parseColor("#4B5320")) // Cor de fundo verde militar
          border.setStroke(5, Color.parseColor("#FFFFFF")) // Largura e cor da borda (branca)
          border.cornerRadius = 12f // Arredondamento dos cantos



          // Aplicar o GradientDrawable como fundo do cartão de visita
            background = border

            // Definir as dimensões do cartão de visita
            layoutParams = LinearLayout.LayoutParams(
                550, // Largura específica do cartão
                LinearLayout.LayoutParams.WRAP_CONTENT // Altura ajustada ao conteúdo
            ).apply {
                gravity = Gravity.CENTER // Centralizar o cartão na tela
            }
        }

        // Adicionar uma ImageView para a foto de perfil
        val profileImage = ImageView(this).apply {
            setImageResource(R.drawable.foto_user) // Substitua pelo seu recurso de imagem
            layoutParams = LinearLayout.LayoutParams(400, 400).apply { // Ajustar tamanho da imagem
                gravity = Gravity.CENTER
            }
        }

        // Adicionar TextViews para o nome, cargo, email e telefone
        val nameTextView = TextView(this).apply {
            text = "João Victor Neves De Souza"
            textSize = 18f
            setTextColor(Color.BLACK)
            gravity = Gravity.CENTER
        }

        val jobTitleTextView = TextView(this).apply {
            text = "FULL STACK-DEVELOPER"
            textSize = 15f
            setTextColor(Color.BLACK)
            gravity = Gravity.CENTER
        }

        val emailTextView = TextView(this).apply {
            text = "jvictor.neves20@gmail.com"
            textSize = 15f
            setTextColor(Color.BLACK)
            gravity = Gravity.CENTER
        }

        val githubTextView = TextView(this).apply {
          text = "https://www.linkedin.com/in/jo%C3%A3o-victor-neves-de-souza-3a81891a8/"
          textSize = 13f
          setTextColor(Color.BLACK)
          gravity = Gravity.CENTER
        }

        val phoneTextView = TextView(this).apply {
            text = "+55 81 99138-2292"
            textSize = 15f
            setTextColor(Color.BLACK)
            gravity = Gravity.CENTER
        }

        // Adicionar os elementos ao layout do cartão
        cardLayout.addView(profileImage)
        cardLayout.addView(nameTextView)
        cardLayout.addView(jobTitleTextView)
        cardLayout.addView(emailTextView)
        cardLayout.addView(githubTextView)
        cardLayout.addView(phoneTextView)

        // Criar um layout para centralizar o cartão de visita
        val centerLayout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            layoutParams = FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT
            )
        }

        // Adicionar o layout do cartão ao layout centralizado
        centerLayout.addView(cardLayout)

        // Adicionar o layout centralizado ao contêiner principal
        containerLayout.addView(centerLayout)

        // Definir o layout principal como o conteúdo da atividade
        setContentView(containerLayout)
    }
}
