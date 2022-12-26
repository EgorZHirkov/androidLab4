package com.example.calculatorwarriors

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val camp1Level = camp1.selectedItemPosition
        val camp2Level = camp2.selectedItemPosition
        val camp3Level = camp3.selectedItemPosition
        val camp4Level = camp4.selectedItemPosition
        var factoryLevel = factory.selectedItemPosition
        var darkFactoryLevel = darkFactory.selectedItemPosition
        val listCampLevels = mutableListOf<Int>(camp1Level, camp2Level, camp3Level, camp4Level)
        val listCampCapacity = listOf(20, 30, 35, 40, 45, 50, 55, 60, 65, 70, 75)
        val listFactoryCapacity = listOf(0, 2, 4, 6, 8, 10, 10, 10)
        val imageCamps = listOf(R.drawable.img_army_camp_1lvl_130_110, R.drawable.img_army_camp_2lvl_130_110,
            R.drawable.img_army_camp_3lvl_130_110, R.drawable.img_army_camp_4lvl_130_110, R.drawable.img_army_camp_5lvl_130_110,
            R.drawable.img_army_camp_6lvl_130_110, R.drawable.img_army_camp_7lvl_130_110, R.drawable.img_army_camp_8lvl_130_110,
            R.drawable.img_army_camp_9lvl_130_110, R.drawable.img_army_camp_10lvl_130_110, R.drawable.img_army_camp_11lvl_130_110)
        camp1.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?,
                                        itemSelected: View, selectedItemPosition: Int, selectedId: Long) {
                listCampLevels[0] = selectedItemPosition
                imageCamp1.setImageResource(imageCamps[selectedItemPosition])
                camp1Capacity.text = listCampCapacity[selectedItemPosition].toString()
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
        camp2.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?,
                                        itemSelected: View, selectedItemPosition: Int, selectedId: Long) {
                listCampLevels[1] = selectedItemPosition
                imageCamp2.setImageResource(imageCamps[selectedItemPosition])
                camp2Capacity.text = listCampCapacity[selectedItemPosition].toString()
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
        camp3.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?,
                                        itemSelected: View, selectedItemPosition: Int, selectedId: Long) {
                listCampLevels[2] = selectedItemPosition
                imageCamp3.setImageResource(imageCamps[selectedItemPosition])
                camp3Capacity.text = listCampCapacity[selectedItemPosition].toString()
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
        camp4.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?,
                                        itemSelected: View, selectedItemPosition: Int, selectedId: Long) {
                listCampLevels[3] = selectedItemPosition
                imageCamp4.setImageResource(imageCamps[selectedItemPosition])
                camp4Capacity.text = listCampCapacity[selectedItemPosition].toString()
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
        factory.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?,
                                        itemSelected: View, selectedItemPosition: Int, selectedId: Long) {
                factoryLevel = selectedItemPosition
                factoryCapacity.text = listFactoryCapacity[selectedItemPosition].toString()
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
        darkFactory.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?,
                                        itemSelected: View, selectedItemPosition: Int, selectedId: Long) {
                darkFactoryLevel = selectedItemPosition
                if (darkFactoryLevel > 0) {
                    darkFactoryCapacity.text = "1"
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
        swipeRight.setOnClickListener {
            val unitsActivity = Intent(this@MainActivity, UnitsActivity::class.java)
            for (i in listCampLevels.indices) {
                unitsActivity.putExtra("camp${i}Capacity", listCampCapacity[listCampLevels[i]])
            }
            if (darkFactoryLevel > 0) {
                unitsActivity.putExtra("factoryCapacity", listFactoryCapacity[factoryLevel] + 1)
            }
            else {
                unitsActivity.putExtra("factoryCapacity", listFactoryCapacity[factoryLevel])
            }
            unitsActivity.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
            startActivity(unitsActivity)
            finish()
        }
    }
}
