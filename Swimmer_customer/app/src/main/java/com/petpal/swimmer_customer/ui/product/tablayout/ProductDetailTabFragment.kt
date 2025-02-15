package com.petpal.swimmer_customer.ui.product.tablayout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.petpal.swimmer_customer.databinding.FragmentProductDetailTabBinding
import com.petpal.swimmer_customer.data.model.exList
import com.petpal.swimmer_customer.ui.product.ProductViewModel

class ProductDetailTabFragment(var idx: Int) : Fragment() {

    lateinit var fragmentProductDetailTabBinding: FragmentProductDetailTabBinding
    private lateinit var viewModel: ProductViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        fragmentProductDetailTabBinding = FragmentProductDetailTabBinding.inflate(inflater)

        viewModel = ViewModelProvider(this)[ProductViewModel::class.java]
        viewModel.setProductDetailRanking(exList)

        viewModel.productDetail.observe(viewLifecycleOwner) {
            Glide
                .with(requireActivity())
                .load( it[idx].description)
                .override(500, 10000)
                .into(fragmentProductDetailTabBinding.productDetailImageView)
        }

        return fragmentProductDetailTabBinding.root

    }
}