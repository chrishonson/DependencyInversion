package com.example.dependencyinversion.policy

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.dependencyinversion.IPolicyService
import com.example.dependencyinversion.Post
import com.example.dependencyinversion.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

private val uiScope = CoroutineScope(Dispatchers.Main + SupervisorJob())
//realizes the policy service interface
class PolicyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        uiScope.launch {
            //realizes the policy service interface through the supplied application that is a mechanism
            val posts = (application as IPolicyService).getPostsPolicy()
            Log.d("post", posts.toString())
            val recycler = findViewById<RecyclerView>(R.id.recycler)
            recycler.adapter = PostsAdapter(posts)
        }
    }

    class PostsAdapter(private val posts: List<Post>) : RecyclerView.Adapter<PostsAdapter.PostViewHolder>() {
        inner class PostViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            var userId: TextView = view.findViewById(R.id.user_id)
            val id: TextView = view.findViewById(R.id.id)
            val title = view.findViewById<TextView>(R.id.title)
            val body = view.findViewById<TextView>(R.id.body)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
            val itemView = LayoutInflater.from(parent.context).inflate(
                R.layout.layout_post_list_item,
                parent, false
            )
            return PostViewHolder(itemView)
        }

        override fun getItemCount(): Int {
            return posts.size
        }

        override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
            holder.userId.text = posts[position].userId.toString()
            holder.id.text = posts[position].id.toString()
            holder.title.text = posts[position].title
            holder.body.text = posts[position].body
        }
    }
}