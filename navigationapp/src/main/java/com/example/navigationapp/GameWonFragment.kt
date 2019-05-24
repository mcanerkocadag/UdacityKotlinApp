/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.navigationapp

import android.content.Intent
import androidx.databinding.DataBindingUtil
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.core.app.ShareCompat
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.navigationapp.R
import com.example.navigationapp.databinding.FragmentGameWonBinding

class GameWonFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentGameWonBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_game_won, container, false
        )
        binding.nextMatchButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_gameWonFragment_to_gameFragment)
        }

        val args = arguments?.let { GameWonFragmentArgs.fromBundle(it) }
        Toast.makeText(
            context,
            "NumCorrect: " + args?.numCorrect + " NumQuestions: " + args?.numQuestions,
            Toast.LENGTH_LONG
        ).show()

        setHasOptionsMenu(true)
        return binding.root
    }

    fun getShareIntent(): Intent {

        val args = arguments?.let { GameWonFragmentArgs.fromBundle(it) }

        /**
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "text/plain"
        shareIntent.putExtra(
            Intent.EXTRA_TEXT,
            getString(R.string.share_success_text, args?.numCorrect, args?.numQuestions)
        )
        **/

        return ShareCompat.IntentBuilder.from(activity)
            .setText(getString(R.string.share_success_text, args?.numCorrect, args?.numQuestions))
            .setType("text/plain")
            .intent
        //  return shareIntent
    }

    private fun shareSuccess() {
        startActivity(getShareIntent())
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.winner_menu, menu)
        if (null == getShareIntent().resolveActivity(activity!!.packageManager)) {
            // hide the menu item if it doesn't resolve
            menu?.findItem(R.id.share)?.setVisible(false)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.share -> shareSuccess()
        }

        return super.onOptionsItemSelected(item)
    }
}
