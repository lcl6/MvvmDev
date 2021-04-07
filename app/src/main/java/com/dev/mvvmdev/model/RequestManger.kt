import com.dev.mvvmdev.base.bean.response.ApiResponse
import com.dev.mvvmdev.manager.net.apiManger
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 *
 * @Author liancl
 * @Date 2021/3/31 0031-10:48
 */

val requestManger: RequestManger by lazy (mode = LazyThreadSafetyMode.SYNCHRONIZED){
    RequestManger()
}

class RequestManger {

    suspend fun getBanner(): ApiResponse<ArrayList<BannerResponse>> {
        return withContext(Dispatchers.IO) {
            apiManger.getBanner()
        }
    }

}