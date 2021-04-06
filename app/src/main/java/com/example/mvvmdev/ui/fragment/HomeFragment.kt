import android.os.Bundle
import com.example.mvvmdev.R
import com.example.mvvmdev.databinding.FgHomeBinding

/**
 *
 * @Author liancl
 * @Date 2021/3/29 0029-15:37
 */
class HomeFragment :BaseDbFragment<HomeViewModel,FgHomeBinding>(){

    override fun layoutId(): Int {
        return R.layout.fg_home
    }

    override fun initData() {
    }

    override fun creatObserver() {
    }

    override fun initView(savedInstanceState: Bundle?) {
    }

}