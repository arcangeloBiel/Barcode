package com.ajk.motoboy

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.ajk.motoboy.databinding.FragmentBarCodeBinding
import com.ajk.motoboy.view.ActivityCallback
import com.ajk.motoboy.view.CustomScannerActivity
import com.journeyapps.barcodescanner.ScanContract
import com.journeyapps.barcodescanner.ScanIntentResult
import com.journeyapps.barcodescanner.ScanOptions


class BarCodeFragment : Fragment() {

    private var _binding: FragmentBarCodeBinding? = null
    private val binding get() = _binding!!

    private var activityCallback: ActivityCallback? = null



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBarCodeBinding.inflate(inflater, container, false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
      teste()
    }

    fun teste() {
        launchScanner()
        binding?.listaAlunos?.setOnClickListener {
            launchScanner()

        }
    }

    private fun launchScanner() {
        val options = ScanOptions()
            .setOrientationLocked(false)
            .setCaptureActivity(CustomScannerActivity::class.java)
            .setCameraId(0)
            .setBeepEnabled(false)
            .setBarcodeImageEnabled(true)
            .setDesiredBarcodeFormats(ScanOptions.ALL_CODE_TYPES)
        barcodeLauncher.launch(options)
    }


    private val barcodeLauncher = registerForActivityResult(
        ScanContract()
    ) { result: ScanIntentResult ->
        if (!result.contents.isNullOrEmpty()) {
            binding.textBarcode.text = result.contents
            Toast.makeText(requireContext(), "Scan Result: ${result.contents}", Toast.LENGTH_SHORT).show()
        } else {
            // CANCELEDJoao2023..

        }
    }



    private fun startLoading() = activityCallback?.showActionButton("")

    // 1) Como se comunicar com a main activity
    // 2) como definir callbacks
    // 3) como chamar os metodos partindo do fragment


    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            activityCallback = context as ActivityCallback
        } catch (e: Exception) {
            TODO("Not yet implemented")
        }
    }

    /**
    Clear activity  callback to avoid memory leaks
     */
    override fun onDetach() {
        super.onDetach()
        activityCallback = null
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BarCodeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BarCodeFragment().apply {
                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
                }
            }
    }


}