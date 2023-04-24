package com.example.nativeapplication.ui.notesFragment

import android.opengl.Visibility
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.nativeapplication.App
import com.example.nativeapplication.R
import com.example.nativeapplication.common.launchMain
import com.example.nativeapplication.common.lazyViewModel
import com.example.nativeapplication.common.openFragment
import com.example.nativeapplication.databinding.NoteFragmentBinding
import com.example.nativeapplication.injection.viewModelProvider
import com.example.nativeapplication.repository.AppRepository
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class NotesFragment : Fragment() {

    @Inject lateinit var repository: AppRepository

    private lateinit var binding: NoteFragmentBinding
    private val viewModel by lazyViewModel(
        { requireActivity().application as App },
        { viewModelProvider.provideGameViewModel(repository) }
    )

    private val adapter by lazy {
        NotesAdapter { note ->
            viewModel.deleteNote(note)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = NoteFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter.notes = emptyList()
        binding.notesList.adapter = adapter
        binding.notesList.itemAnimator = null

        launchMain {
            viewModel.getNotes.collect{ notes ->
                binding.emptyList.visibility = if (notes.isEmpty()) View.VISIBLE else View.GONE
                adapter.notes = notes
                Timber.d("Notes collected: $notes")
            }
        }

        binding.addNote.setOnClickListener {
            openFragment(R.id.add_note_fragment)
        }
    }
}