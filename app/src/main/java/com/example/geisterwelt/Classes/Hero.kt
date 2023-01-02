package com.example.geisterwelt.Classes

import androidx.lifecycle.MutableLiveData

data class Hero(var mX: Int = 5, var mY: Int = 5, var mMoves: Int = 0) {


    fun checkUp(Karte: Array<Array<Field>>): Boolean{
        return mY>1
        //return Karte[mX][mY-1].mEbene1 < 10
    }
    fun checkDown(): Boolean{
        return mY<100
    }
    fun checkLeft(): Boolean{
        return mX>1
    }
    fun checkRight(): Boolean{
        return mX<100
    }

}