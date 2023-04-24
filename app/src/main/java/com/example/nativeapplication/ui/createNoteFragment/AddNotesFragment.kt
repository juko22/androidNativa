package com.example.nativeapplication.ui.createNoteFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.nativeapplication.App
import com.example.nativeapplication.R
import com.example.nativeapplication.common.lazyViewModel
import com.example.nativeapplication.common.openFragment
import com.example.nativeapplication.databinding.AddNoteFragmentBinding
import com.example.nativeapplication.injection.viewModelProvider
import com.example.nativeapplication.repository.AppRepository
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class AddNotesFragment : Fragment() {

    @Inject lateinit var repository: AppRepository

    private lateinit var binding: AddNoteFragmentBinding
    private val viewModel by lazyViewModel(
        { requireActivity().application as App },
        { viewModelProvider.provideGameViewModel(repository) }
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = AddNoteFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.addNote.setOnClickListener {
            viewModel.addNote(
                binding.title.text.toString(),
                binding.text.text.toString()
            )
            Timber.d("Note added")
            openFragment(R.id.main_fragment)
        }
    }
}