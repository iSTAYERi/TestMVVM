package com.example.testmvvm.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.testmvvm.R
import com.example.testmvvm.models.User
import com.example.testmvvm.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    companion object {

        private const val ARG_UID = "arg_uid"

        fun newInstance(userId: String): MainFragment {
            val fragment = MainFragment()
            val bundle = Bundle()
            bundle.putString(ARG_UID, userId)
            fragment.arguments = bundle
            return fragment
        }
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val binding: MainFragmentBinding =
                DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false)
        val view = binding.root
        val userID = arguments!!.getString(ARG_UID)!!

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
//        viewModel = MainViewModel()
        viewModel.init(userID)
        binding.model = viewModel
        binding.handler = object : MyHandler() {
            override fun btnPressOnClick() {
//                viewModel.user.get()!!.age = viewModel.user.get()!!.age + 10
                viewModel.user.set(User("OH MY", "Mr. Dick", 102))
            }
        }

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

}
