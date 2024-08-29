package com.example.codapizza.model

import androidx.annotation.StringRes
import com.example.codapizza.R

enum class ToppingPosition(@StringRes val label: Int) {
    Left(R.string.placement_left),
    Right(R.string.placement_right),
    All(R.string.placement_all),
    None(R.string.placement_none)
}