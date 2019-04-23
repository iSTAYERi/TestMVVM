package com.example.testmvvm.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.testmvvm.R
import com.example.testmvvm.User
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
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val userID = arguments!!.getString(ARG_UID)!!
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.init(userID)
        val binding = DataBindingUtil.setContentView<MainFragmentBinding>(activity!!, R.layout.main_fragment)
        binding.model = viewModel
        binding.handler = object : MyHandler() {
            override fun btnPressOnClick() {
//                viewModel.user.get()!!.age = viewModel.user.get()!!.age + 10
                viewModel.user.set(User("OH MY", "Mr. Dick", 102))
            }
        }
    }

}
