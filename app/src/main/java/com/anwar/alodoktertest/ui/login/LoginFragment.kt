package com.anwar.alodoktertest.ui.login

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.anwar.alodoktertest.R
import com.anwar.alodoktertest.domain.Constants
import com.anwar.alodoktertest.utils.SPHelper
import kotlinx.android.synthetic.main.fragment_login.*
import android.text.TextUtils
import androidx.navigation.findNavController


class LoginFragment : Fragment() {

    private lateinit var loginViewModel: LoginViewModel

    override fun onStart() {
        super.onStart()
        val isLogin: Boolean = SPHelper.instance.getSharedPreferences(Constants.IS_LOGIN, false)

        if (isLogin) {
            findNavController().navigate(R.id.action_login_to_home)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)

        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {

        btn_fragment_login_submit.setOnClickListener {

            prepareLogin()

        }

    }

    private fun prepareLogin() {
        val email: String = til_fragment_login_email.editText?.text.toString()
        val password: String = til_fragment_login_password.editText?.text.toString()
        if (isValidEmail(email) && password.isNotEmpty()) {
            // Open Main
            SPHelper.instance.setPreferences(Constants.IS_LOGIN, true)
            btn_fragment_login_submit.findNavController().navigate(R.id.action_login_to_home)

        } else {
            if (isValidEmail(email)) {
                til_fragment_login_email.error = getString(R.string.msg_email_not_valid)
            } else if (password.isEmpty()) {
                til_fragment_login_password.error = getString(R.string.msg_password_empty)
            }
        }

    }

    private fun isValidEmail(target: CharSequence): Boolean {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches()
    }
}