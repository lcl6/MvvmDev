package com.dev.mvvmdev.ui.ac

import android.Manifest
import android.os.Build
import android.os.Bundle
import com.dev.mvvm.ext.showToast
import com.dev.mvvmdev.R
import com.dev.mvvmdev.base.ui.BaseDbActivity
import com.dev.mvvmdev.databinding.ActivityWelcomeBinding
import com.dev.mvvmdev.vm.WelcomeViewModel
import permissions.dispatcher.*

/**
 * 欢迎页
 * @Author liancl
 * @Date 2021/4/1 0001-8:41
 */
@RuntimePermissions
class WelcomeActivity : BaseDbActivity<WelcomeViewModel, ActivityWelcomeBinding>() {

    override fun creatObserver() {
    }

    override fun initView(savedInstanceState: Bundle?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            needPermissionWithPermissionCheck()
        } else {
            initLogic()
        }

    }

    private fun initLogic() {
        TestAcitvity.start(this)
        finish()
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_welcome
    }

    @NeedsPermission(
        Manifest.permission.CAMERA,
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.WRITE_EXTERNAL_STORAGE
    )
    fun needPermission() {
        initLogic()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        onRequestPermissionsResult(requestCode, grantResults)
    }

    /***
     * 显示原因
     * @param request PermissionRequest
     */
    @OnShowRationale(
        Manifest.permission.CAMERA,
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.WRITE_EXTERNAL_STORAGE
    )
    fun showRation(request: PermissionRequest) {
        request.proceed()
    }

    @OnPermissionDenied(
        Manifest.permission.CAMERA,
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.WRITE_EXTERNAL_STORAGE
    )
    fun permissionDeny() {
        showToast(this, "您拒绝了改权限")

    }

    @OnNeverAskAgain(
        Manifest.permission.CAMERA,
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.WRITE_EXTERNAL_STORAGE
    )
    fun neverAsk() {
    }
}