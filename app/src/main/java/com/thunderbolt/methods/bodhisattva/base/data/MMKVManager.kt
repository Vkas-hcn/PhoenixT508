package com.thunderbolt.methods.bodhisattva.base.data

import android.content.Context
import com.tencent.mmkv.MMKV
import kotlin.properties.ReadOnlyProperty
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty



object MMKVManager {
    private lateinit var mmkv: MMKV

    fun init(context: Context) {
        MMKV.initialize(context)
        mmkv = MMKV.defaultMMKV()
    }

    // 为每种基本类型创建专门的委托类
    class StringPreferenceDelegate(
        private val key: String,
        private val defaultValue: String
    ) : ReadWriteProperty<Any, String> {
        override fun getValue(thisRef: Any, property: KProperty<*>) =
            mmkv.decodeString(key, defaultValue) ?: defaultValue

        override fun setValue(thisRef: Any, property: KProperty<*>, value: String) {
            mmkv.encode(key, value)
        }
    }

    class IntPreferenceDelegate(
        private val key: String,
        private val defaultValue: Int
    ) : ReadWriteProperty<Any, Int> {
        override fun getValue(thisRef: Any, property: KProperty<*>) =
            mmkv.decodeInt(key, defaultValue)

        override fun setValue(thisRef: Any, property: KProperty<*>, value: Int) {
            mmkv.encode(key, value)
        }
    }

    class BooleanPreferenceDelegate(
        private val key: String,
        private val defaultValue: Boolean
    ) : ReadWriteProperty<Any, Boolean> {
        override fun getValue(thisRef: Any, property: KProperty<*>) =
            mmkv.decodeBool(key, defaultValue)

        override fun setValue(thisRef: Any, property: KProperty<*>, value: Boolean)  {
            mmkv.encode(key, value)
        }
    }

    class FloatPreferenceDelegate(
        private val key: String,
        private val defaultValue: Float
    ) : ReadWriteProperty<Any, Float> {
        override fun getValue(thisRef: Any, property: KProperty<*>) =
            mmkv.decodeFloat(key, defaultValue)

        override fun setValue(thisRef: Any, property: KProperty<*>, value: Float)  {
            mmkv.encode(key, value)
        }
    }

    class LongPreferenceDelegate(
        private val key: String,
        private val defaultValue: Long
    ) : ReadWriteProperty<Any, Long> {
        override fun getValue(thisRef: Any, property: KProperty<*>) =
            mmkv.decodeLong(key, defaultValue)

        override fun setValue(thisRef: Any, property: KProperty<*>, value: Long)  {
            mmkv.encode(key, value)
        }
    }

    // 提供简洁的扩展函数创建委托实例
    fun stringPreference(key: String, defaultValue: String = "") =
        StringPreferenceDelegate(key, defaultValue)

    fun intPreference(key: String, defaultValue: Int = 0) =
        IntPreferenceDelegate(key, defaultValue)

    fun booleanPreference(key: String, defaultValue: Boolean = false) =
        BooleanPreferenceDelegate(key, defaultValue)

    fun floatPreference(key: String, defaultValue: Float = 0f) =
        FloatPreferenceDelegate(key, defaultValue)

    fun longPreference(key: String, defaultValue: Long = 0L) =
        LongPreferenceDelegate(key, defaultValue)
}


