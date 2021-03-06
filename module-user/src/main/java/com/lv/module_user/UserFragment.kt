package com.lv.module_user

import androidx.fragment.app.viewModels
import com.standalone.core.base.ui.activity.skin.SkinManager
import com.standalone.core.base.ui.activity.skin.config.SkinPreUtils
import com.standalone.core.base.ui.frag.KnifeLayoutFragment
import com.xiaojinzi.component.anno.FragmentAnno
import kotlinx.android.synthetic.main.user_frag.*

/**
 * @name HomeFragment
 * @package com.lv.module_home
 * @author 345 QQ:1831712732
 * @time 2020/5/12 21:51
 * @description
 */

@FragmentAnno("user-fragment")
class UserFragment : KnifeLayoutFragment() {

    val userViewModel by viewModels<UserViewModel>()


    override fun isBarDark(): Boolean = false

    override fun isImmersionBar(): Boolean {
        return true
    }

    override fun layout(): Int {
        return R.layout.user_frag
    }

    override fun bindView() {

        main_Skin.setOnClickListener {
            if (SkinPreUtils.getTag()) {
                SkinManager.restoreDefault()
                SkinPreUtils.setTag(false)
                main_Skin.setImageResource(R.drawable.main_daytime)
            } else {
                val code = SkinManager.loadSkin(context?.cacheDir?.path + "/knif.skin")
                SkinPreUtils.setTag(true)
                main_Skin.setImageResource(R.drawable.main_night)
            }
        }
    }


}