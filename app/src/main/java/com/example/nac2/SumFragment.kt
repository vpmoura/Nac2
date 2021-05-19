package com.example.nac2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.nac2.databinding.FragmentSumBinding

class SumFragment : Fragment() {
    private lateinit var bindings: FragmentSumBinding
    private lateinit var buttonSoma: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bindings = DataBindingUtil.inflate(inflater, R.layout.fragment_sum, container, false)
        return bindings.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonSoma = bindings.buttonSoma
        buttonSoma.setOnClickListener {
            val action = SumFragmentDirections.actionSumFragmentToResultFragment(
                number1 = bindings.inputNumber1.text.toString().toInt(),
                number2 = bindings.inputNumber2.text.toString().toInt()
            )
            findNavController().navigate(action)
        }
    }
}