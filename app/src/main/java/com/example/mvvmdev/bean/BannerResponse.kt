/**
 * 业务基本格式
 * @Author liancl
 * @Date 2021/3/31 0031-11:30
 */
data class BannerResponse(
    var desc: String = "",
    var id: Int = 0,
    var imagePath: String = "",
    var isVisible: Int = 0,
    var order: Int = 0,
    var title: String = "",
    var type: Int = 0,
    var url: String = ""
)