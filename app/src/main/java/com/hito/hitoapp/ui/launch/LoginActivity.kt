package com.hito.hitoapp.ui.launch

import android.os.Bundle
import android.widget.Toast
import com.hito.chatlib.mvp.IView
import com.hito.chatlib.mvp.MActivity
import com.hito.hitoapp.ui.launch.presenter.LoginPresenter

/**
 * Created by dream on 2018/7/1.
 */
class LoginActivity : MActivity<LoginPresenter>(),IView<LoginPresenter> {
    override fun initData(savedInstanceState: Bundle?) {
        super.initData(savedInstanceState)
        Toast.makeText(this, "为什么Kotlin没有分号！？", Toast.LENGTH_LONG).show()
    }
}