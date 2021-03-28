package com.et.stocklist.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.et.stocklist.R
import com.et.stocklist.ui.MainActivity
import com.et.stocklist.ui.Sort
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class SortOptionDialogFragment : BottomSheetDialogFragment() {

    lateinit var selectedItem: String

    fun newInstance(option: Sort): SortOptionDialogFragment {
        val args = Bundle()
        args.putString("selectedSort", option.name)
        val fragment = SortOptionDialogFragment()
        fragment.arguments = args
        return fragment
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        selectedItem = arguments?.getString("selectedSort").toString()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.sort_dialog, container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val currentHightoLowSortOptionTxtView =
            view.findViewById<TextView>(R.id.current_rate_high_sort_option_view)
        val currentLowtoHighSortOptionTxtView =
            view.findViewById<TextView>(R.id.current_rate_low_sort_option_view)
        val absoluteHightoLowSortOptionTxtView =
            view.findViewById<TextView>(R.id.absolute_change_high_sort_option_view)
        val absoluteLowtoHighSortOptionTxtView =
            view.findViewById<TextView>(R.id.absolute_change_low_sort_option_view)

        when (selectedItem) {
            Sort.CURRENT_HIGH.name ->
                currentHightoLowSortOptionTxtView.setTextColor(resources.getColor(R.color.selectedTextColor))
            Sort.CURRENT_LOW.name ->
                currentLowtoHighSortOptionTxtView.setTextColor(resources.getColor(R.color.selectedTextColor))
            Sort.CHANGE_HIGH.name ->
                absoluteHightoLowSortOptionTxtView.setTextColor(resources.getColor(R.color.selectedTextColor))
            Sort.CHANGE_LOW.name ->
                absoluteLowtoHighSortOptionTxtView.setTextColor(resources.getColor(R.color.selectedTextColor))
        }

        currentHightoLowSortOptionTxtView.setOnClickListener {
            (activity as MainActivity).setSortOption(Sort.CURRENT_HIGH)
            dismiss()
        }

        currentLowtoHighSortOptionTxtView.setOnClickListener {
            (activity as MainActivity).setSortOption(Sort.CURRENT_LOW)
            dismiss()
        }

        absoluteLowtoHighSortOptionTxtView.setOnClickListener {
            (activity as MainActivity).setSortOption(Sort.CHANGE_LOW)
            dismiss()
        }

        absoluteHightoLowSortOptionTxtView.setOnClickListener {
            (activity as MainActivity).setSortOption(Sort.CHANGE_HIGH)
            dismiss()
        }

    }

}