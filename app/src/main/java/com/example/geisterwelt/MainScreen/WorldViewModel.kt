package com.example.geisterwelt.MainScreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import com.example.geisterwelt.Classes.Field
import com.example.geisterwelt.Classes.Hero

class WorldViewModel: ViewModel() {

    val mHero = MutableLiveData(Hero())
    val mY = mHero.map { mHero.value?.mY }
    val mX = mHero.map { mHero.value?.mX }


    var Karte = Array(10) { Array(10){ Field() } }

    init {
        Karte[5][3].mEbene1 = 1
        /*
        for (x in 0..9)
            for (y in 0..9){
                Karte[x][y].mEbene1 = 1
                Karte[x][y].mEbene2 = 3
            }
        println("-> ${Karte[4][9].mEbene2}")

         */
    }



    fun up(){

        if (mHero.value?.checkUp(Karte) == true) {
            mHero.value = mHero.value?.copy(mY = mHero.value!!.mY.minus(1))
        }
    }

    fun down(){
        if (mHero.value?.checkDown() == true) {
            mHero.value = mHero.value?.copy(mY = mHero.value!!.mY.plus(1))
        }
    }

    fun left(){
        if (mHero.value?.checkLeft() == true) {
            mHero.value = mHero.value?.copy(mX = mHero.value!!.mX.minus(1))
        }
    }

    fun right(){
        if (mHero.value?.checkRight() == true) {
            mHero.value = mHero.value?.copy(mX = mHero.value!!.mX.plus(1))
        }
    }
}