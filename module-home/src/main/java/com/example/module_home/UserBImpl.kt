package com.example.module_home

import javax.inject.Inject

class UserBImpl @Inject constructor() : User {
    override fun getName(): String {
        return "Lv"
    }
}