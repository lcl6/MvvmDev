import android.util.Log
import okhttp3.FormBody
import okhttp3.Interceptor
import okhttp3.Response
import java.nio.charset.Charset
import java.nio.charset.UnsupportedCharsetException

/**
 * 日志拦截器
 * @Author liancl
 * @Date 2021/3/30 0030-15:45
 */
class LogInterceptor  :Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
//        val newBuilder = chain.request().newBuilder()
        val orgRequest = chain.request()
        val response = chain.proceed(orgRequest)

        val body = orgRequest.body
        val sb = StringBuilder()
        if (orgRequest.method == "POST" && body is FormBody) {
            for (i in 0 until body.size) {
                sb.append(body.encodedName(i) + "=" + body.encodedValue(i) + ",")
            }
            sb.delete(sb.length - 1, sb.length)
            Log.d("result","code=" + response.code + "|method=" + orgRequest.method + "|url=" + orgRequest.url
                    + "\n" + "headers:" + orgRequest.headers.toMultimap()
                    + "\n" + "post请求体:{" + sb.toString() + "}")
//            //打印post请求的信息
        } else {
//            //打印get请求的信息
            Log.d("result","code=" + response.code + "|method=" + orgRequest.method + "|url=" + orgRequest.url
                    + "\n" + "headers:" + orgRequest.headers.toMultimap())
        }
        //返回json
        val responseBody = response.body
        val contentLength = responseBody!!.contentLength()
        val source = responseBody.source()
        source.request(java.lang.Long.MAX_VALUE)
        val buffer = source.buffer
        if (contentLength != 0L) {
            //打印返回json
            //json日志使用鼠标中键进行选中
            val logJson = buffer.clone().readString(Charset.forName("UTF-8"))
            Log.d("result",logJson);

        }
        //日志拦截操作
        return response
    }
}