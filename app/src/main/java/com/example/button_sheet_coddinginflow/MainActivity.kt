package com.example.button_sheet_coddinginflow

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var bottonSheetBehavior:BottomSheetBehavior<View>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottonSheetBehavior= BottomSheetBehavior.from(botton_sheet)

        btn_expand.setOnClickListener {
            bottonSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED)

        }
        btn_collaps.setOnClickListener {
            bottonSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED)

        }
        bottonSheetBehavior.setBottomSheetCallback(object :BottomSheetBehavior.BottomSheetCallback(){

            override fun onSlide(p0: View, p1: Float) {


            }

            @SuppressLint("SwitchIntDef")
            override fun onStateChanged(p0: View, p1: Int) {
                when (p1){
                    BottomSheetBehavior.STATE_COLLAPSED-> text_view_state.text="Collaps"
                    BottomSheetBehavior.STATE_EXPANDED-> text_view_state.text="Expanded" // Press Tab to overwrite
                    BottomSheetBehavior.STATE_DRAGGING-> text_view_state.text="Dragging" // Press Tab to overwrite
                    BottomSheetBehavior.STATE_HIDDEN-> text_view_state.text="Hidding" // Press Tab to overwrite
                    BottomSheetBehavior.STATE_SETTLING-> text_view_state.text="Setting" // Press Tab to overwrite
                    BottomSheetBehavior.STATE_HALF_EXPANDED-> text_view_state.text="Half Expanding" // Press Tab to overwrite
                }


            }


        })
    }
}

/*
* class MainActivity:AppCompatActivity() {
  private val mBottomSheetBehavior:BottomSheetBehavior
  private val mTextViewState:TextView
  protected fun onCreate(savedInstanceState:Bundle) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    val bottomSheet = findViewById(R.id.bottom_sheet)
    mBottomSheetBehavior = BottomSheetBehavior.from(bottomSheet)
    *
    mTextViewState = findViewById(R.id.text_view_state)
    val buttonExpand = findViewById(R.id.button_expand)
    val buttonCollapse = findViewById(R.id.button_collapse)
    buttonExpand.setOnClickListener(object:View.OnClickListener() {
      fun onClick(v:View) {
        mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED)
      }
    })
    buttonCollapse.setOnClickListener(object:View.OnClickListener() {
      fun onClick(v:View) {
        mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED)
      }
    })
    mBottomSheetBehavior.setBottomSheetCallback(object:BottomSheetBehavior.BottomSheetCallback() {
      fun onStateChanged(@NonNull bottomSheet:View, newState:Int) {
        when (newState) {
          BottomSheetBehavior.STATE_COLLAPSED -> mTextViewState.setText("Collapsed")
          BottomSheetBehavior.STATE_DRAGGING -> mTextViewState.setText("Dragging...")
          BottomSheetBehavior.STATE_EXPANDED -> mTextViewState.setText("Expanded")
          BottomSheetBehavior.STATE_HIDDEN -> mTextViewState.setText("Hidden")
          BottomSheetBehavior.STATE_SETTLING -> mTextViewState.setText("Settling...")
        }
      }
      fun onSlide(@NonNull bottomSheet:View, slideOffset:Float) {
        mTextViewState.setText("Sliding...")
      }
    })
  }
}*/
