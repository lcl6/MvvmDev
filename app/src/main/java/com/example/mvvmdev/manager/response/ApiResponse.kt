/**
 * @Author liancl
 * @Date 2021/3/31 0031-11:13
 */
 class ApiResponse<T> : BaseResponse<T>() {
    /**
     * 判断接口是否成功返回
     * @return Boolean
     */
    fun isSuccess():Boolean{
        return getRequestCode()==0
    }

    fun getRequestCode():Int{
        return errorCode
    }

    /**
     * 接口返回的错误信息
     * @return String
     */
    fun getRequestMsg():String{
        return errorMsg
    }


    /**
     * 返回
     * @return T
     */
    fun getRequestData(): T{
        return data!!
    }

}