import okhttp3.Interceptor
import okhttp3.Response

/**
 * @Author liancl
 * @Date 2021/3/30 0030-15:47
 */
class CacheInterceptor :Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val newBuilder = chain.request().newBuilder()
        return chain.proceed(newBuilder.build())
    }
}