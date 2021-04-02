package com.example.mvvmdev.ui.ac
import BaseActivity
import WelcomeViewModel
import android.Manifest
import android.os.Bundle
import com.example.mvvmdev.R
import com.example.mvvmdev.databinding.ActivityWelcomeBinding
import com.example.mvvmlib.ext.showToast
import com.permissionx.guolindev.PermissionX

/**
 * 欢迎页
 * @Author liancl
 * @Date 2021/4/1 0001-8:41
 */
class WelcomeActivity :BaseActivity<WelcomeViewModel,ActivityWelcomeBinding>(){

    override fun creatObserver() {

    }

    override fun initView(savedInstanceState: Bundle?) {
        PermissionX.init(this)
            .permissions(Manifest.permission.CAMERA,Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE)
            .request { allGranted, grantedList, deniedList ->
                if (allGranted) {
                    MainActivity.start(this)
                    finish()
                } else {
                    showToast(this,"These permissions are denied: $deniedList")
                }
            }
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_welcome
    }
//
}