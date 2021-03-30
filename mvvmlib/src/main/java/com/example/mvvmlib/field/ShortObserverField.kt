import androidx.databinding.ObservableField

/**
 * @Author liancl
 * @Date 2021/3/30 0030-10:51
 */
class ShortObserverField(value:Short) :ObservableField<Short>() {
    override fun get(): Short {
        return super.get()!!
    }
}