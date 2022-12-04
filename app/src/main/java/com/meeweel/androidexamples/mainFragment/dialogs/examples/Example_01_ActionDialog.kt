package com.meeweel.androidexamples.mainFragment.dialogs.examples

import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.meeweel.androidexamples.mainFragment.dialogs.BaseExampleFragment

class Example_01_ActionDialog : BaseExampleFragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.title.text = "ActionDialog"
        binding.btn.setOnClickListener {
            val dialog = AlertDialog.Builder(requireContext())
                .setTitle("AlertDialog title")
                .setMessage("AlertDialog message")
                .setPositiveButton("Yes") { _, _ ->
                    toast("Yes")
                }
                .setNegativeButton("No") { _, _ ->
                    toast("No")
                }
                .create()
            dialog.show()
        }
    }

    private fun toast(text: String) {
        Toast.makeText(requireContext(), "Yes", Toast.LENGTH_SHORT).show()
    }
}