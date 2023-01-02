package com.example.geisterwelt.MainScreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import com.example.geisterwelt.Classes.Field
import com.example.geisterwelt.Classes.Hero
import com.example.geisterwelt.R

class WorldViewModel: ViewModel() {

    val mRepository = Repository()
    val mHero = MutableLiveData(Hero())
    val mY = mHero.map { mHero.value?.mY }
    val mX = mHero.map { mHero.value?.mX }


    var mKarte = Array(101) { Array(101){ Field() } }
    val mPictureMapLevelOne = mRepository.mPictureMapLevelOne
    val mPictureMapLevelTwo = mRepository.mPictureMapLevelTwo

    init {
        mKarte[4][5].mEbene1 = 1
        mKarte[4][5].mEbene2 = 1


        for (x in 0..100)
            for (y in 0..100){
                mKarte[x][y].mEbene1 = (0..4).random()
                mKarte[x][y].mEbene2 = (0..8).random()
            }
    }



    fun up(){

        if (mHero.value?.checkUp(mKarte) == true) {
            mHero.value = mHero.value?.copy(mY = mHero.value!!.mY.minus(1), mMoves = mHero.value!!.mMoves.plus(1))
        }
    }

    fun down(){
        if (mHero.value?.checkDown() == true) {
            mHero.value = mHero.value?.copy(mY = mHero.value!!.mY.plus(1), mMoves = mHero.value!!.mMoves.plus(1))
        }
    }

    fun left(){
        if (mHero.value?.checkLeft() == true) {
            mHero.value = mHero.value?.copy(mX = mHero.value!!.mX.minus(1), mMoves = mHero.value!!.mMoves.plus(1))
        }
    }

    fun right(){
        if (mHero.value?.checkRight() == true) {
            mHero.value = mHero.value?.copy(mX = mHero.value!!.mX.plus(1), mMoves = mHero.value!!.mMoves.plus(1))
        }
    }
}