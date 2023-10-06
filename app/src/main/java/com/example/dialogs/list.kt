package com.example.dialogs

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dialogs.databinding.ActivityListBinding

class list : AppCompatActivity() {
    lateinit var binding: ActivityListBinding
    var finalArray = ArrayList<String>()
    var list = ArrayList<RecModel>()
    var Array = booleanArrayOf(false, false, false)
    lateinit var recAdapter: RecAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recAdapter = RecAdapter(list)
        binding.recycler.adapter = recAdapter
        binding.recycler.layoutManager = LinearLayoutManager(this)

        binding.Btn.setOnClickListener {
            val listItems = arrayOf("Burger","Pizza","Chaap","Noodles","Momos")
            val checkedItems = BooleanArray(listItems.size)


            val dialog = AlertDialog.Builder(this)
            dialog.setTitle(R.string.List)
            //  create list in dialog
//            dialog.setItems(listItems,DialogInterface.OnClickListener { dialogInterface, i ->
//
//            })
//            dialog.create()

             //create multiple choice list
                .setMultiChoiceItems(listItems,null,object : DialogInterface.OnMultiChoiceClickListener{
                    override fun onClick(dialog: DialogInterface?, position: Int, isChecked : Boolean) {
                        if(isChecked){
                            if(finalArray.contains(listItems[position]) == false)
                                finalArray.add(listItems[position])
                        }
                        else{

                        }
                    }
                })
            dialog.setPositiveButton("Ok"){_,_,->
                for(i in finalArray.indices){
                    list.add(RecModel(finalArray[i]))
                  //  binding.newList.text = finalArray.toString()
                    val adapter = RecAdapter(list)
                    binding.recycler.adapter = adapter
                }
                recAdapter.notifyDataSetChanged()
                System.out.println("final List $finalArray")
                dialog.setCancelable(false)
            }
            dialog.setNegativeButton("Cancel"){_,_,->
                dialog.setCancelable(true)
            }

            // create single choice list
//            dialog.setSingleChoiceItems(listItems,isChecked) { _, position ->
//                if (finalArray.contains(listItems[position]) == false)
//                    finalArray.add(listItems[position])
//            }
//            dialog.setPositiveButton("Ok"){_,_,->
//                    binding.newList.text = finalArray.toString()
//                }
//                dialog.setNegativeButton("Cancel"){_,_,->
//                    dialog.setCancelable(true)
//                }
//                dialog.setCancelable(false)
            dialog.show()
        }
    }
}