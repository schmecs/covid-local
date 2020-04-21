package com.rebeccablum.covidlocal.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import com.rebeccablum.covidlocal.R
import com.rebeccablum.covidlocal.databinding.FragmentStateStatsBinding
import com.rebeccablum.covidlocal.viewmodels.StateStatsViewModel

class StateStatsFragment : Fragment() {

    private lateinit var binding: FragmentStateStatsBinding
    private lateinit var adapter: ArrayAdapter<String>

    private val stateStatsViewModel: StateStatsViewModel by lazy {
        ViewModelProvider(this).get(StateStatsViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStateStatsBinding.inflate(inflater, container, false)
            .apply {
                viewModel = stateStatsViewModel
                lifecycleOwner = viewLifecycleOwner

                adapter =
                    ArrayAdapter(
                        requireContext(),
                        R.layout.select_state_dropdown_item,
                        arrayListOf()
                    )
                selectStateTextView.setAdapter(adapter)

                selectStateTextView.onItemClickListener =
                    AdapterView.OnItemClickListener { _, _, position, _ ->
                        stateStatsViewModel.setSelectedState(position)
                    }

                subscribeUi()
            }
        return binding.root
    }

    private fun subscribeUi() {

        stateStatsViewModel.stateList.observe(viewLifecycleOwner) { states ->
            adapter.clear()
            adapter.addAll(states.map { it.state })
            adapter.notifyDataSetChanged()
        }
    }
}
