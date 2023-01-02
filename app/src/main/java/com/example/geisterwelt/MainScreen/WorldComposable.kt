package com.example.geisterwelt.MainScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.geisterwelt.R

@ExperimentalMaterialApi
@Composable
fun WorldComposable(mWorldViewModel: WorldViewModel = viewModel()) {

    val mHero by mWorldViewModel.mHero.observeAsState()
    val mX by mWorldViewModel.mX.observeAsState()
    val mY by mWorldViewModel.mY.observeAsState()
    val mKarte = mWorldViewModel.mKarte
    val mPictureMapLevelOne = mWorldViewModel.mPictureMapLevelOne
    val mPictureMapLevelTwo = mWorldViewModel.mPictureMapLevelTwo

    val mSheetScope = rememberCoroutineScope()
    val mBottomSheetScaffoldState = rememberBottomSheetScaffoldState(bottomSheetState = BottomSheetState(BottomSheetValue.Collapsed))

    BottomSheetScaffold(
        scaffoldState = mBottomSheetScaffoldState,
        sheetContent = {
            Column(
                Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.3F)
                    .background(colorResource(id = R.color.bottomSheetColor))
            ) {
                Spacer(modifier = Modifier.height(32.dp))
                Text(
                    text = "X: $mX, Y: $mY",
                    modifier = Modifier.padding(16.dp)
                )
                Text(
                    text = "Moves: ${mHero?.mMoves}",
                    modifier = Modifier.padding(16.dp)
                )
            }
        },
        sheetPeekHeight = 16.dp,
        sheetShape = RoundedCornerShape(topEnd = 16.dp, topStart = 16.dp),
    ) {

        // content of the Scaffold
        Column(
            modifier = Modifier
                .background(Color.Black)
                .fillMaxSize()
        ) {

            Text(
                text = "X: $mX, Y: $mY",
                modifier = Modifier.padding(8.dp),
                color = Color.White
            )

            // Two Pictures
            Row(
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                mPictureMapLevelOne[mKarte[mX!!][mY!!].mEbene1]
                    ?.let { it1 -> painterResource(id = it1) }?.let { it2 ->
                        Image(
                            //painter = painterResource(id = mKarte[mX!!][mY!!].mLevelOnePicture),
                            painter = it2,
                            contentDescription = "",
                            modifier = Modifier.size(120.dp)
                        )
                    }
                mPictureMapLevelTwo[mKarte[mX!!][mY!!].mEbene2]
                    ?.let { it1 -> painterResource(it1) }?.let { it2 ->
                        Image(
                            painter = it2,
                            contentDescription = "",
                            modifier = Modifier.size(120.dp)
                        )
                    }
            }


            Text(
                text = "Nadelwald",
                modifier = Modifier.padding(8.dp),
                color = Color.White
            )
            Text(
                text = "unten liegt ein Stein",
                modifier = Modifier.padding(8.dp),
                color = Color.White
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .padding(8.dp)
            ) {

                IconButton(
                    onClick = { mWorldViewModel.up() },
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .background(Color.Gray)
                ) {
                    Icon(
                        Icons.Filled.KeyboardArrowUp,
                        contentDescription = "Up",
                        modifier = Modifier
                            .size(48.dp),
                        tint = Color.White

                    )
                }
                IconButton(
                    onClick = { mWorldViewModel.down() },
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .background(Color.Gray)
                ) {
                    Icon(
                        Icons.Filled.KeyboardArrowDown,
                        contentDescription = "Down",
                        modifier = Modifier
                            .size(48.dp),
                        tint = Color.White
                    )
                }
                IconButton(
                    onClick = { mWorldViewModel.left() },
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .background(Color.Gray)
                ) {
                    Icon(
                        Icons.Filled.KeyboardArrowLeft,
                        contentDescription = "Left",
                        modifier = Modifier
                            .size(48.dp),
                        tint = Color.White

                    )
                }
                IconButton(
                    onClick = { mWorldViewModel.right() },
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .background(Color.Gray)
                ) {
                    Icon(
                        Icons.Filled.KeyboardArrowRight,
                        contentDescription = "Right",
                        modifier = Modifier
                            .size(48.dp),
                        tint = Color.White

                    )
                }
            } // end of the Box

        } // end of the Column
    } // end of Content of the Scoffold

}