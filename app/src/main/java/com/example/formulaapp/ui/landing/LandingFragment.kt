package com.example.formulaapp.ui.landing

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.formulaapp.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_landing.*
import timber.log.Timber

@AndroidEntryPoint
class LandingFragment : Fragment(R.layout.fragment_landing) {

    private lateinit var rankingAdapter: RankingAdapter
    private val landingViewModel by viewModels<LandingViewModel> ()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rankingAdapter = RankingAdapter()
        rvRanking.layoutManager = LinearLayoutManager(requireContext())
        rvRanking.adapter = rankingAdapter
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        landingViewModel.formulaDrivers.observe(viewLifecycleOwner, Observer {
            rankingAdapter.setDrivers(it)
        })
    }

}