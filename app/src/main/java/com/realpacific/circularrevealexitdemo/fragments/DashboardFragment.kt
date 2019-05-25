package com.realpacific.circularrevealexitdemo.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.realpacific.circularrevealexitdemo.R
import com.realpacific.circularrevealexitdemo.utils.findLocationOfCenterOnTheScreen
import com.realpacific.circularrevealexitdemo.utils.open
import kotlinx.android.synthetic.main.fragment_dashboard.*


class DashboardFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance(): DashboardFragment = DashboardFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fab1.setOnClickListener {
            val positions = it.findLocationOfCenterOnTheScreen()
            fragmentManager?.open {
                // Pass center as the end position of the circular reveal
                add(R.id.container, OneFragment.newInstance(positions)).addToBackStack(null)
            }
        }

        fab2.setOnClickListener {
            val positions = it.findLocationOfCenterOnTheScreen()
            fragmentManager?.open {
                // Pass center as the end position of the circular reveal
                add(R.id.container, TwoFragment.newInstance(positions)).addToBackStack(null)
            }
        }
    }
}
