package com.example.neoman.zoo

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list_element_layout.view.*

class MainActivity : AppCompatActivity() {
    var animals=ArrayList<Animal>()
    var adapter:AnimalAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //load animals
        animals.add(Animal("Fennec","cute",R.drawable.fennec,false))
        animals.add(Animal("Lion","fierce",R.drawable.lion,true))
        animals.add(Animal("Owl","wise",R.drawable.owl,true))
        animals.add(Animal("Fennec","cute",R.drawable.fennec,false))
        animals.add(Animal("Lion","fierce",R.drawable.lion,true))
        animals.add(Animal("Owl","wise",R.drawable.owl,true))
        animals.add(Animal("Fennec","cute",R.drawable.fennec,false))
        animals.add(Animal("Lion","fierce",R.drawable.lion,true))
        animals.add(Animal("Owl","wise",R.drawable.owl,true))

        adapter= AnimalAdapter(this,animals)

        ZooList.adapter=adapter

    }

    //fun onReturnToActivity(){
    /*put this code into whatever function is called when
     an intent that leads to this activity,
     specifically after that confirming intent
       was from iteminfoactivity*/

      /*
        val b:Bundle=intent.extras
        val pos:Int=b.getInt("index")
        if(b.getString("action")=="del"){
            del(pos)
        }else{
            upd(pos,b.getString("name"),b.getString("desc"),b.getInt("pic"),b.getBoolean("pred"))
        }
    }

    public fun del(pos:Int){
        animals.removeAt(pos)
        adapter!!.notifyDataSetChanged()
    }

    fun upd(pos:Int,name:String,desc:String,pic:Int,pred:Boolean){
        animals[pos]= Animal(name,desc,pic,pred)
        adapter!!.notifyDataSetChanged()
    }*/

    class AnimalAdapter:BaseAdapter{
        var animals=ArrayList<Animal>()
        var context:Context?=null
        constructor(context:Context,animals:ArrayList<Animal>):super(){
            this.context=context
            this.animals=animals
        }
        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val animal=animals[p0]
            var inflator=context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var view:View
            if(animal.predator){
                view=inflator.inflate(R.layout.pred_list_element_layout,null)
            }else{
                view=inflator.inflate(R.layout.list_element_layout,null)
            }
            view.Name.text=animal.name
            view.Desc.text=animal.desc
            view.Pic.setImageResource(animal.pic!!)
            view.setOnClickListener{
                val intent= Intent(context,ItemInfoActivity::class.java)
                intent.putExtra("name",animal.name)
                intent.putExtra("desc",animal.desc)
                intent.putExtra("pic",animal.pic!!)
                intent.putExtra("pred",animal.predator)
                intent.putExtra("index",p0)
                context!!.startActivity(intent)
            }
            return view
        }

        override fun getItem(p0: Int): Any {
            return animals[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getCount(): Int {
            return animals.size
        }

    }
}
