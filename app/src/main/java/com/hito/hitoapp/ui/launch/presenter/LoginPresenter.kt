package com.hito.hitoapp.ui.launch.presenter

import com.hito.chatlib.mvp.MPresenter
import com.hito.hitoapp.model.User
import com.hito.hitoapp.ui.launch.LoginActivity

/**
 * Created by dream on 2018/7/1.
 */
class LoginPresenter : MPresenter<LoginActivity>() {
    /**
     * 返回本地换成的用户信息
     */
    fun getLocalUser(): User {
        return User("")
    }
}