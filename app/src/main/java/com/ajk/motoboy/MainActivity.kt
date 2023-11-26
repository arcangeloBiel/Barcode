package com.ajk.motoboy

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.ajk.motoboy.databinding.ActivityMainBinding
import com.ajk.motoboy.view.ActivityCallback

class MainActivity : AppCompatActivity(), ActivityCallback {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        loadFragment(BarCodeFragment())

       binding.bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    loadFragment(BarCodeFragment())
                    true
                }
                R.id.foto -> {
                    loadFragment(HomeFragment())
                    true
                }

                else -> {
                    false
                }
            }
        }

    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.commit()
    }

    override fun showActionButton(codigoBarraLido: String) {
        TODO("Not yet implemented")
    }

}