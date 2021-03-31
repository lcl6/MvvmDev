import kotlin.properties.Delegates

/**
 *
 * 基本的包装
 * @Author liancl
 * @Date 2021/3/31 0031-11:09
 */
open class BaseResponse<T> {
    var errorCode:Int=-1
    var errorMsg:String=""
    var data :T ?=null


}