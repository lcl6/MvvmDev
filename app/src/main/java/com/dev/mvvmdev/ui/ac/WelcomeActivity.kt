package com.dev.mvvmdev.ui.ac
import android.Manifest
import android.os.Bundle
import com.dev.mvvm.ext.showToast
import com.dev.mvvmdev.R
import com.dev.mvvmdev.base.ui.BaseDbActivity
import com.dev.mvvmdev.databinding.ActivityWelcomeBinding
import com.dev.mvvmdev.vm.WelcomeViewModel
import com.permissionx.guolindev.PermissionX

/**
 * 欢迎页
 * @Author liancl
 * @Date 2021/4/1 0001-8:41
 */
class WelcomeActivity : BaseDbActivity<WelcomeViewModel, ActivityWelcomeBinding>(){

    override fun creatObserver() {

    }

    override fun initView(savedInstanceState: Bundle?) {
        PermissionX.init(this)
            .permissions(Manifest.permission.CAMERA,Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE)
            .request { allGranted, grantedList, deniedList ->
                if (allGranted) {
//                    MainActivity.start(this)
                    TestAcitvity.start(this)
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