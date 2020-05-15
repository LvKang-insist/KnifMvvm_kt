package com.lv.library_core.base.activity

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import com.lv.library_core.model.BaseViewModel

/**
 * @name BaseActivity
 * @class name：com.lv.module_main.activity.base
 * @author 345 QQ:1831712732
 * @time 2020/5/8 22:52
 * @description Activity 基类
 */

abstract class BaseActivity<VM : BaseViewModel>() : AppCompatActivity() {

    lateinit var viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider.NewInstanceFactory().create(setViewModel())
        initView()
        bindView(savedInstanceState)
        bindView()
    }

    open fun initView() {
        val content = LayoutInflater.from(this).inflate(layout(), null, false)
        when {
            content != null -> {
                setContentView(content)
            }
            else -> {
                throw NullPointerException("布局初始化异常")
            }
        }
    }

    abstract fun layout(): Int

    abstract fun bindView()

    open fun bindView(savedInstanceState: Bundle?) {}

    abstract fun setViewModel(): Class<VM>


}