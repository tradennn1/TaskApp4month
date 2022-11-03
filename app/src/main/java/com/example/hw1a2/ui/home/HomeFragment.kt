package com.example.hw1a2.ui.home

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.hw1a2.App
import com.example.hw1a2.News
import com.example.hw1a2.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var adapter: TaskAdapter
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = TaskAdapter()
      //  val list = App.dataBase.newsDao().getAll()
       // adapter.addItems(list)
    }





    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.fap.setOnClickListener {
            findNavController().navigate(com.example.hw1a2.R.id.secondFragment)
        }
        parentFragmentManager.setFragmentResultListener(
            "rk_news",
            viewLifecycleOwner
        ) { _, bundle ->
            val news = bundle.getSerializable("news") as News
            Log.e("Home", "text - $news")
            adapter.addItem(news)
            binding.recycleView.adapter = adapter

        }
        binding.recycleView.adapter = adapter
        rename()
        alert()

    }

    private fun alert() {

        adapter.onLongClick = {

            val dialog = AlertDialog.Builder(context)
            dialog.setTitle("Delet project list")
            dialog.setMessage("You want to delete project?")
            dialog.setPositiveButton("Yes") { _, _ ->
                val news :News
                news = adapter.getItem(it)
                adapter.deleteItemsAndNotifyAdapter(it)
                binding.recycleView.adapter = adapter
                //Delete items in RecyclerView**
                App.getInstance().getDatabase().newsDao().delete(news);
                adapter
            }
            dialog.setNegativeButton("Cancel") {dialog, _ -> dialog.cancel()}
            dialog.show()
        }

    }
    //override fun onOptionsItemSelected(item: MenuItem): Boolean {
     //   if (item.itemId === com.example.hw1a2.R.id.actionSort) {
       //     getSortedList()


        //}
       // return super.onOptionsItemSelected(item)
    //}

    //private fun getSortedList() {
      //  val list: List<News> = App.getInstance().getDatabase().newsDao().getAllSortedTitle() as List<News>
        //adapter.addItems(list)
    //}


    private fun rename() {
        adapter.onClick = {
            val bundle = Bundle()
            bundle.putString("key1", it.title)
            findNavController().navigate(com.example.hw1a2.R.id.secondFragment, bundle)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
