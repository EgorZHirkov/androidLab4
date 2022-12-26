package com.example.calculatorwarriors

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_total.*

class TotalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_total)
        val hours: Int
        val minutes: Int
        var seconds: Int
        val extras = intent.extras
        if (extras != null) {
            if (extras.getInt("count_barbarian") != 0) {
                total_barbarian.text = extras.getInt("count_barbarian").toString()
            }
            else {
                layout_barbarian.visibility = View.GONE
            }
            if (extras.getInt("count_archer") != 0) {
                total_archer.text = extras.getInt("count_archer").toString()
            }
            else {
                layout_archer.visibility = View.GONE
            }
            if (extras.getInt("count_giant") != 0) {
                total_giant.text = extras.getInt("count_giant").toString()
            }
            else {
                layout_giant.visibility = View.GONE
            }
            if (extras.getInt("count_goblin") != 0) {
                total_goblin.text = extras.getInt("count_goblin").toString()
            }
            else {
                layout_goblin.visibility = View.GONE
            }
            if (extras.getInt("count_wizard") != 0) {
                total_wizard.text = extras.getInt("count_wizard").toString()
            }
            else {
                layout_wizard.visibility = View.GONE
            }
            if (extras.getInt("count_dragon") != 0) {
                total_dragon.text = extras.getInt("count_dragon").toString()
            }
            else {
                layout_dragon.visibility = View.GONE
            }
            if (extras.getInt("count_lightning") != 0) {
                total_lightning.text = extras.getInt("count_lightning").toString()
            }
            else {
                layout_lightning.visibility = View.GONE
            }
            if (extras.getInt("count_healing") != 0) {
                total_healing.text = extras.getInt("count_healing").toString()
            }
            else {
                layout_healing.visibility = View.GONE
            }
            if (extras.getInt("count_rage") != 0) {
                total_rage.text = extras.getInt("count_rage").toString()
            }
            else {
                layout_rage.visibility = View.GONE
            }
            if (extras.getInt("count_poison") != 0) {
                total_poison.text = extras.getInt("count_poison").toString()
            }
            else {
                layout_poison.visibility = View.GONE
            }
            if (extras.getInt("count_skeletons") != 0) {
                total_skeleton.text = extras.getInt("count_skeletons").toString()
            }
            else {
                layout_skeleton.visibility = View.GONE
            }
            seconds = 5 * extras.getInt("count_barbarian") +
                      6 * extras.getInt("count_archer") +
                      30 * extras.getInt("count_giant") +
                      7 * extras.getInt("count_goblin") +
                      30 * extras.getInt("count_wizard") +
                      3 * 60 * extras.getInt("count_dragon") +
                      3 * 60 * extras.getInt("count_lightning") +
                      6 * 60 * extras.getInt("count_healing") +
                      6 * 60 * extras.getInt("count_rage") +
                      3 * 60 * extras.getInt("count_poison") +
                      3 * 60 * extras.getInt("count_skeletons")
            hours = seconds / 3600
            minutes = (seconds / 60) - (hours * 60)
            seconds -= (minutes * 60) + (hours * 3600)
            total_time.text = "${hours}h. ${minutes}m. ${seconds}s."
            total_troops.text = (extras.getInt("count_barbarian") +
                                extras.getInt("count_archer") +
                                extras.getInt("count_giant") +
                                extras.getInt("count_goblin") +
                                extras.getInt("count_wizard") +
                                extras.getInt("count_dragon")).toString()
            total_spells.text = (extras.getInt("count_lightning") +
                                 extras.getInt("count_healing") +
                                 extras.getInt("count_rage") +
                                 extras.getInt("count_poison") +
                                 extras.getInt("count_skeletons")).toString()
            total_all1.text = (extras.getInt("camp1Capacity") +
                              extras.getInt("camp2Capacity") +
                              extras.getInt("camp3Capacity") +
                              extras.getInt("camp4Capacity")).toString()
            total_all2.text = extras.getInt("factoryCapacity").toString()

        }
        parameters.setOnClickListener {
            val unitsActivity = Intent(this@TotalActivity, UnitsActivity::class.java)
            //unitsActivity.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)
            startActivity(unitsActivity)
            finish()
        }

    }
}
