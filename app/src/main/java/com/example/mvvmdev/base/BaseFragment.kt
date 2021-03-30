import androidx.databinding.ViewDataBinding
import com.example.mvvmlib.vm.BaseViewModel

/**
 * 基本的fragment 使用databinding
 * @Author liancl
 * @Date 2021/3/29 0029-17:24
 */
abstract class BaseFragment<VM:BaseViewModel,DB:ViewDataBinding> :BaseVmDbfragment<VM,DB>(){

    override fun showLoading(msg: String?) {
    }

    override fun showResult(it: String?) {
    }

    override fun showNoData(it: String?) {
    }



}