package com.anwar.alodoktertest.ui.login

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.anwar.alodoktertest.R
import com.anwar.alodoktertest.domain.Constants
import com.anwar.alodoktertest.utils.SPHelper
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {

    private lateinit var loginViewModel: LoginViewModel

    override fun onStart() {
        super.onStart()
        val isLogin: Boolean = SPHelper.instance.getSharedPreferences(Constants.IS_LOGIN, false)

        Log.i("MAIN", "Is login --> $isLogin")
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
            SPHelper.instance.setPreferences(Constants.IS_LOGIN, true)
            it.findNavController().navigate(R.id.action_login_to_home)
        }

    }
}