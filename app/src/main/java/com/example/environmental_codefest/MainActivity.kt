package com.example.environmental_codefest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.*
import android.view.Menu
import com.example.environmental_codefest.ui.main.IssueDetailFragment
import com.example.environmental_codefest.ui.main.IssuesFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, IssuesFragment.newInstance())
                    .commitNow()
        }
    }

    // feel like this is more beginner friendly way of fragment navigation even if it's not the best
    fun navigateToIssueDetail(position: Int) {
        val fragment = IssueDetailFragment()
        val args = Bundle().apply {
            putInt("KEY", position)
        }
        fragment.arguments = args
        fragment.enterTransition = Fade()
        fragment.exitTransition = Fade()
        supportFragmentManager.beginTransaction()
            .addToBackStack(IssueDetailFragment.TAG)
            .replace(R.id.container, fragment, IssueDetailFragment.TAG)
            .commit()
    }

    // todo set up menu ?
    /* override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    } */

    // todo add bottom nav
}
