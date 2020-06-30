package com.lv.module_home

import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.net.Uri
import android.view.View
import androidx.core.net.toUri
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.hjq.toast.ToastUtils
import com.standalone.core.base.ui.frag.BaseBindingFragment
import com.lv.module_home.databinding.HomeFragBinding
import com.lv.module_home.navigation.HomeNavigation
import com.xiaojinzi.component.anno.FragmentAnno
import kotlinx.android.synthetic.main.home_frag.*


/**
 * @name HomeFragment
 * @package com.lv.module_home
 * @author 345 QQ:1831712732
 * @time 2020/5/12 21:51
 * @description
 */

@FragmentAnno("HomeFragment")
class HomeFragment : BaseBindingFragment<HomeFragBinding, HomeViewModel>() {


    override fun createViewModel(): Class<HomeViewModel>? = HomeViewModel::class.java

    override fun layout(): Int {
        return R.layout.home_frag
    }


    override fun bindView(rootView: View) {
        home.setOnClickListener {
            val intent = Intent(ACTION_VIEW)
            intent.data = "home://www.google.com".toUri()
            startActivity(intent)
//            Navigation.findNavController(rootView).navigate(Uri.parse("home://frag3"))
        }

        request.setOnClickListener {
            viewModel.login()
        }
        viewModel.loginLiveData.observe(this, Observer {
            ToastUtils.show(it)
            binding.data = it
        })
    }

}