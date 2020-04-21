package com.rebeccablum.covidlocal.screens

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.rebeccablum.covidlocal.R
import com.rebeccablum.covidlocal.databinding.ActivityStatsBinding

class StatsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityStatsBinding>(this, R.layout.activity_stats)
    }
}