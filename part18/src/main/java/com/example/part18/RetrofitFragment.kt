package com.example.part18

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.part18.databinding.FragmentRetrofitBinding
import com.example.part18.model.PageListModel
import retrofit2.Call


class RetrofitFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentRetrofitBinding.inflate(inflater, container, false)
        val call: Call<PageListModel>=MyApplication.networkService.getList(
        MyApplication.QUERY,
        MyApplication.API_KEY,
        1,
        10
        )


        return binding.root
    }


}