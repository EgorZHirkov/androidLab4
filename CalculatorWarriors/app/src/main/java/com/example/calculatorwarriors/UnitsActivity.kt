package com.example.calculatorwarriors

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.InputFilter
import android.text.TextWatcher
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_units.*

class CustomTextWatcher(
    private val editText: EditText
) : TextWatcher {
    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
    override fun afterTextChanged(s: Editable?) {
        if (!s.isNullOrEmpty()) {
            if (s.matches("^0[\\d]+".toRegex())) {
                editText.setText("0")
                editText.setSelection(editText.length())
            }
        }
    }
}

class UnitsActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_units)
        val maxLengthInputField = 3
        val filterArray = arrayOfNulls<InputFilter>(1)
        filterArray[0] = InputFilter.LengthFilter(maxLengthInputField)
        count_barbarian.filters = filterArray
        count_archer.filters = filterArray
        count_giant.filters = filterArray
        count_goblin.filters = filterArray
        count_wizard.filters = filterArray
        count_dragon.filters = filterArray
        count_lightning.filters = filterArray
        count_healing.filters = filterArray
        count_rage.filters = filterArray
        count_poison.filters = filterArray
        count_skeletons.filters = filterArray
        count_barbarian.addTextChangedListener(CustomTextWatcher(count_barbarian))
        count_archer.addTextChangedListener(CustomTextWatcher(count_archer))
        count_giant.addTextChangedListener(CustomTextWatcher(count_giant))
        count_goblin.addTextChangedListener(CustomTextWatcher(count_goblin))
        count_wizard.addTextChangedListener(CustomTextWatcher(count_wizard))
        count_dragon.addTextChangedListener(CustomTextWatcher(count_dragon))
        count_lightning.addTextChangedListener(CustomTextWatcher(count_lightning))
        count_healing.addTextChangedListener(CustomTextWatcher(count_healing))
        count_rage.addTextChangedListener(CustomTextWatcher(count_rage))
        count_poison.addTextChangedListener(CustomTextWatcher(count_poison))
        count_skeletons.addTextChangedListener(CustomTextWatcher(count_skeletons))
        swipeRight.setOnClickListener {
            val extras = intent.extras
            var camp1Capacity = 0
            var camp2Capacity = 0
            var camp3Capacity = 0
            var camp4Capacity = 0
            var factoryCapacity = 0
            if (extras != null) {
                camp1Capacity = extras.getInt("camp1Capacity")
                camp2Capacity = extras.getInt("camp2Capacity")
                camp3Capacity = extras.getInt("camp3Capacity")
                camp4Capacity = extras.getInt("camp4Capacity")
                factoryCapacity = extras.getInt("factoryCapacity")
            }
            val totalActivity = Intent(this@UnitsActivity, TotalActivity::class.java)
            if (count_barbarian.text.isNullOrEmpty()) {
                totalActivity.putExtra("count_barbarian", 0)
            }
            else {
                totalActivity.putExtra("count_barbarian", count_barbarian.text.toString().toInt())
            }
            if (count_archer.text.isNullOrEmpty()) {
                totalActivity.putExtra("count_archer", 0)
            }
            else {
                totalActivity.putExtra("count_archer", count_archer.text.toString().toInt())
            }
            if (count_giant.text.isNullOrEmpty()) {
                totalActivity.putExtra("count_giant", 0)
            }
            else {
                totalActivity.putExtra("count_giant", count_giant.text.toString().toInt())
            }
            if (count_goblin.text.isNullOrEmpty()) {
                totalActivity.putExtra("count_goblin", 0)
            }
            else {
                totalActivity.putExtra("count_goblin", count_goblin.text.toString().toInt())
            }
            if (count_wizard.text.isNullOrEmpty()) {
                totalActivity.putExtra("count_wizard", 0)
            }
            else {
                totalActivity.putExtra("count_wizard", count_wizard.text.toString().toInt())
            }
            if (count_dragon.text.isNullOrEmpty()) {
                totalActivity.putExtra("count_dragon", 0)
            }
            else {
                totalActivity.putExtra("count_dragon", count_dragon.text.toString().toInt())
            }
            if (count_lightning.text.isNullOrEmpty()) {
                totalActivity.putExtra("count_lightning", 0)
            }
            else {
                totalActivity.putExtra("count_lightning", count_lightning.text.toString().toInt())
            }
            if (count_healing.text.isNullOrEmpty()) {
                totalActivity.putExtra("count_healing", 0)
            }
            else {
                totalActivity.putExtra("count_healing", count_healing.text.toString().toInt())
            }
            if (count_rage.text.isNullOrEmpty()) {
                totalActivity.putExtra("count_rage", 0)
            }
            else {
                totalActivity.putExtra("count_rage", count_rage.text.toString().toInt())
            }
            if (count_poison.text.isNullOrEmpty()) {
                totalActivity.putExtra("count_poison", 0)
            }
            else {
                totalActivity.putExtra("count_poison", count_poison.text.toString().toInt())
            }
            if (count_skeletons.text.isNullOrEmpty()) {
                totalActivity.putExtra("count_skeletons", 0)
            }
            else {
                totalActivity.putExtra("count_skeletons", count_skeletons.text.toString().toInt())
            }
            totalActivity.putExtra("camp1Capacity", camp1Capacity)
            totalActivity.putExtra("camp2Capacity", camp2Capacity)
            totalActivity.putExtra("camp3Capacity", camp3Capacity)
            totalActivity.putExtra("camp4Capacity", camp4Capacity)
            totalActivity.putExtra("factoryCapacity", factoryCapacity)
            startActivity(totalActivity)
            finish()
        }
        swipeLeft.setOnClickListener {
            val mainActivity = Intent(this@UnitsActivity, MainActivity::class.java)
            //mainActivity.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
            startActivity(mainActivity)
            finish()
        }
    }
}