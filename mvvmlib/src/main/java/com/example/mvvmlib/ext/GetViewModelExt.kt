package com.example.mvvmlib.ext

import java.lang.reflect.ParameterizedType
import java.util.*

/**
 *Created by liancl on 2021/3/29 0029.
 */

/**
 *获取当前类绑定的泛型ViewModel-clazz
 */
fun <VM>getVmClazz(obj:Any):VM{
    return (obj.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0] as VM
}




