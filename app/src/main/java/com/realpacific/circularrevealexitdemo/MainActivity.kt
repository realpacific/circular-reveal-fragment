package com.realpacific.circularrevealexitdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.realpacific.circularrevealexitdemo.fragments.DashboardFragment
import com.realpacific.circularrevealexitdemo.utils.ExitWithAnimation
import com.realpacific.circularrevealexitdemo.utils.exitCircularReveal
import com.realpacific.circularrevealexitdemo.utils.open

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.open {
            replace(R.id.container, DashboardFragment.newInstance())
        }
    }

    override fun onBackPressed() {
        with(supportFragmentManager.findFragmentById(R.id.container)) {
            // Check if the current fragment implements the [ExitWithAnimation] interface or not
            // Also check if the [ExitWithAnimation.isToBeExitedWithAnimation] is `true` or not
            if ((this as? ExitWithAnimation)?.isToBeExitedWithAnimation() == true) {
                if (this.posX == null || this.posY == null) {
                    super.onBackPressed()
                } else {
                    this.view?.exitCircularReveal(this.posX!!, this.posY!!) {
                        super.onBackPressed()
                    } ?: super.onBackPressed()
                }
            } else {
                super.onBackPressed()
            }
        }
    }
}
