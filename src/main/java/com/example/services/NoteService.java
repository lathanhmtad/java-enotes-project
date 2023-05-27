package com.example.services;

import java.util.List;

import com.example.dao.NoteDAO;
import com.example.model.NoteModel;

public class NoteService {

	private static NoteService noteService = null;
	
	private NoteDAO dao;
	
	public NoteService() {
		super();
		this.dao = new NoteDAO();
	}
	
	public static NoteService getInstance() {
		if(noteService == null) {
			noteService = new NoteService();
		}
		return noteService;
	}



	public Long save(NoteModel noteModel) {
		return dao.save(noteModel);
	}


	public List<NoteModel> findAllByUserId(Long id, Long latestId) {
		return dao.findAllByUserId(id, latestId);
	}

	public boolean deleteNoteById(Long id) {
		return dao.deleteNoteById(id);
		
	}

	public NoteModel findOneById(Long id) {
		return dao.findOneById(id);
	}


	public boolean update(NoteModel newNote) {
		return dao.update(newNote);
	}
	
}
