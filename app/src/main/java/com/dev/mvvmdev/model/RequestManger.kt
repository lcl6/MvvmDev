import com.dev.mvvmdev.base.bean.response.ApiResponse
import com.dev.mvvmdev.bean.BannerResponse
import com.dev.mvvmdev.bean.NewsBean
import com.dev.mvvmdev.manager.net.apiManger
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
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

    suspend fun getTestData() :NewsBean{
        return withContext(Dispatchers.IO){
            delay(2000)
            val newsBean = NewsBean()
            newsBean.name.set("晓明")
            newsBean.title="真帅呀"
            return@withContext newsBean
        }
    }

}