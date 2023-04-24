package com.example.nativeapplication.common

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.nativeapplication.R

fun FragmentActivity.getNavController() =
    (supportFragmentManager.findFragmentById(R.id.navigation_host_fragment) as NavHostFragment).navController

fun FragmentActivity.openFragment(id: Int) = getNavController().run {
    if (currentBackStackEntry?.destination?.id == id) return@run
    if (!popBackStack(id, false)) {
        navigate(id)
    }
}

fun Fragment.openFragment(id: Int) = activity?.openFragment(id)
