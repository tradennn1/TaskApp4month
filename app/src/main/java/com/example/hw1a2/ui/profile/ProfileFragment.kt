package com.example.hw1a2.ui.profile

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.hw1a2.databinding.List4FragmentBinding

class ProfileFragment : Fragment() {

    private lateinit var binding: List4FragmentBinding

    private lateinit var mSetting: SharedPreferences
    private lateinit var launcher: ActivityResultLauncher<Intent>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = List4FragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initLauncher()
        initListener()
       // saver()
       // loadet()
        

    }
 //   @SuppressLint("CommitPrefEdits")
 //   fun saver() {
 //       binding.btnimage.setOnClickListener {
   //         mSetting = requireActivity().getPreferences(android.content.Context.MODE_PRIVATE)
     //       val editor: SharedPreferences.Editor = mSetting.edit()
       //     editor.putString("key3", binding.edittext.text.toString())
         //   editor.apply()

        //}
    //}
    //fun loadet(){
      //  mSetting = requireActivity().getPreferences(Context.MODE_PRIVATE)
        //val saveText = mSetting.getString("key3","")
        //binding.edittext.setText(saveText)

    private fun initListener() {
        binding.btnimage.setOnClickListener {
            val intent = Intent()
            intent.action = Intent.ACTION_PICK
            intent.type = "image/*"
            launcher.launch(intent)
        }
    }

    private fun initLauncher() {
        launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {

            if (it.resultCode == AppCompatActivity.RESULT_OK) {
                val image = it.data?.data
                if (image != null) {
                    binding.image.setImageURI(image)
                }
            }
        }
    }
}

