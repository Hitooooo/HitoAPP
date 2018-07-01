package com.hito.hitoapp.ui.launch

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import butterknife.BindView
import com.airbnb.lottie.LottieAnimationView
import com.hito.hitoapp.R

/**
 * 广告页面，可设置每次进入时是否有爱心小提示。检查更新和是否已经登陆状态
 */
class SplashActivity : AppCompatActivity() {

    @BindView(R.id.animation_view)
    internal var animationView: LottieAnimationView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        initView()
    }

    private fun initView() {

    }
}
