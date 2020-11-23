package com.example.environmental_codefest

import android.content.Context
import android.os.Bundle
import android.transition.Fade
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.environmental_codefest.ui.main.IssueCreateFragment
import com.example.environmental_codefest.ui.main.IssueDetailFragment
import com.example.environmental_codefest.ui.main.IssuesFragment
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.qualifiers.ApplicationContext

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
        // create database probably wrong but oh well
        createDatabase(applicationContext)
        // found on stack overflow really quick idk whats the best way of doing this
        // but this works for now
        supportFragmentManager.addOnBackStackChangedListener {
            val stackHeight = supportFragmentManager.backStackEntryCount
            if (stackHeight > 0) {
                // if we have something on the stack (doesn't include the current shown fragment)
                supportActionBar!!.setHomeButtonEnabled(true)
                supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            } else {
                supportActionBar!!.setDisplayHomeAsUpEnabled(false)
                supportActionBar!!.setHomeButtonEnabled(false)
            }
        }
    }

    // feel like this is a really easy and quick way rather than trying to set up nav graph for this
    // project
    fun navigateToIssueDetail(id: Int) {
        val fragment = IssueDetailFragment()
        val args = Bundle().apply {
            putInt("KEY", id)
        }
        fragment.arguments = args
        fragment.enterTransition = Fade()
        fragment.exitTransition = Fade()
        supportFragmentManager.beginTransaction()
            .addToBackStack(IssueDetailFragment.TAG)
            .replace(R.id.container, fragment, IssueDetailFragment.TAG)
            .commit()
    }

    fun navigateToIssueCreate() {
        val fragment = IssueCreateFragment()
        fragment.apply {
            enterTransition = Fade()
            exitTransition = Fade()
        }

        supportFragmentManager.beginTransaction()
            .addToBackStack(IssueCreateFragment.TAG)
            .replace(R.id.container, fragment, IssueCreateFragment.TAG)
            .commit()
    }

    fun navigateToIssues() {
        val fragment = IssueCreateFragment()
        fragment.apply {
            enterTransition = Fade()
            exitTransition = Fade()
        }

        supportFragmentManager.beginTransaction()
            .addToBackStack(IssuesFragment.TAG)
            .replace(R.id.container, fragment, IssuesFragment.TAG)
            .commit()
    }

    // not sure if this will interfere with other overrides of this function in fragments
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> supportFragmentManager.popBackStack()
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        lateinit var db: IssueDatabase

        fun createDatabase(context: Context) {
            db = Room.databaseBuilder(
                context,
                IssueDatabase::class.java, "database-name"
            ).build()
        }

    }
}
