package com.example.tablayout

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.tablayout.databinding.FragmentLoginBinding
import com.example.tablayout.databinding.FragmentRegisterBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        parentFragmentManager.setFragmentResultListener("registerData", this) { _, bundle ->
            val nameFromRegister = bundle.getString("name")
            val emailFromRegister = bundle.getString("email")
            val passwordFromRegister = bundle.getString("password")

            Log.d("LoginFragment", "Register data - Name: $nameFromRegister, Email: $emailFromRegister, Password: $passwordFromRegister")

            binding.btnLogin.setOnClickListener {
                val emailInput = binding.fieldEmail.text.toString()
                val passwordInput = binding.fieldPassword.text.toString()

                if (emailInput == emailFromRegister && passwordInput == passwordFromRegister) {
                    val intent = Intent(context, DashboardActivity::class.java)
                    intent.putExtra("name", nameFromRegister)
                    intent.putExtra("email", emailFromRegister)
                    startActivity(intent)
                } else {
                    Toast.makeText(context, "Invalid credentials", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
