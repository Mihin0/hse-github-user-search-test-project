package com.mihail.githubusersearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val searchbar: SearchView = findViewById(R.id.searchbar)
        val searchResults: LinearLayout = findViewById(R.id.searchResults)

        searchbar.setOnQueryTextListener(
            object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    if (query == null)
                        return true

                    val results: List<User> = submitSearchQuery(query)
                    // Get search results

                    searchResults.removeAllViews()
                    // Delete previous search results

                    for (user in results) {

                        val element: View = layoutInflater.inflate(
                            R.layout.user_short_info,
                            searchResults,
                            false
                        )

                        val elementLayout: LinearLayout = element as LinearLayout

                        val nameField: TextView = elementLayout.getChildAt(0) as TextView
                        val repoCountField: TextView = elementLayout.getChildAt(1) as TextView

                        nameField.text = user.name

                        repoCountField.text = resources.getQuantityString(
                            R.plurals.numberOfRepositories,
                            user.repositories.size,
                            user.repositories.size
                        )

                        searchResults.addView(element)
                    }
                    // Add search results to layout

                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    return false
                }
            }
        )


    }
}