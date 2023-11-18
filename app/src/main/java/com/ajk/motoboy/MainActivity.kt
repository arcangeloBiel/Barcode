package com.ajk.motoboy

import android.os.Bundle
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

    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.commit()
    }

    override fun showActionButton(show: Boolean) {
        try {
            if (show) {
            }
        } catch (e: Exception) {
            TODO("Not yet implemented")
        }
    }
}