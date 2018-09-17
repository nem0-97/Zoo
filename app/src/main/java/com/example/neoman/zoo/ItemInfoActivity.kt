package com.example.neoman.zoo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_item_info.*

class ItemInfoActivity : AppCompatActivity() {
    var index:Int?=null
    var pic:Int?=null
    var name:String?=null
    var desc:String?=null
    var pred:Boolean?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_info)
        val b:Bundle=intent.extras
        name=b.get("name") as String
        desc=b.get("desc") as String
        pic=b.get("pic") as Int
        pred=b.get("pred") as Boolean
        index=b.get("index") as Int
        Pic.setImageResource(pic!!)
        Name.text=name
        Desc.text=desc
    }

    //fix the startActivities? and find out what is called when returning to mainactivity
    /*fun del(){
        val intent= Intent(this,ItemInfoActivity::class.java)
        intent.putExtra("index",index)
        intent.putExtra("action","del")
        this.startActivity(intent)
    }

    fun update(){
        val intent= Intent(this,ItemInfoActivity::class.java)
        intent.putExtra("index",index)
        intent.putExtra("action","upd")
        intent.putExtra("name",name)
        intent.putExtra("desc",desc)
        intent.putExtra("pic",pic)
        intent.putExtra("pred",pred)
        this.startActivity(intent)
    }*/
}
