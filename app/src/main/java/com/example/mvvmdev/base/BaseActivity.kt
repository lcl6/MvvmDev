import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.mvvmlib.ext.showToast
import com.example.mvvmlib.vm.BaseViewModel

/**
 *
 * 基类
 * @Author liancl
 * @Date 2021/3/30 0030-9:09
 */
abstract class BaseActivity<VM:BaseViewModel,DB:ViewDataBinding> :BaseVmDbActivity<VM,DB>() {

    /**
     * 自定义弹窗
     * @param it String?
     */
    override fun showLoading(it: String?) {
        showToast(this,it)
    }

    override fun showNoData(it: String?) {
    }

    override fun showResult(it: String?) {

    }

}