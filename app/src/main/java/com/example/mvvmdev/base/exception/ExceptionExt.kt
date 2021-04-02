package com.example.mvvmdev.base.exception

import AppException
import NetEnum
import android.util.MalformedJsonException
import com.google.gson.JsonParseException
import org.json.JSONException
import retrofit2.HttpException
import java.net.ConnectException
import java.text.ParseException

/**
 * 错误信息的扩展函数
 * @Author liancl
 * @Date 2021/4/2 0002-9:56
 */
fun Throwable.handlerError():AppException{
    var exEnum: NetEnum
    when(this){
        is HttpException -> {
            exEnum= NetEnum.HTTP_ERROR
        }
        is ConnectException-> {
            exEnum= NetEnum.NETWORK_ERROR
        }
        is JsonParseException, is JSONException, is ParseException, is MalformedJsonException -> {
            exEnum= NetEnum.PARSE_ERROR
        }
        is javax.net.ssl.SSLException -> {
            exEnum=NetEnum.SSL_ERROR
        }
        is java.net.SocketTimeoutException , is java.net.UnknownHostException -> {
            exEnum=NetEnum.TIMEOUT_ERROR
        }
        else->{
            exEnum=NetEnum.UNKNOWN
        }
    }
    return AppException(exEnum.getValue(),exEnum.getKey(),exEnum.getValue())
}





