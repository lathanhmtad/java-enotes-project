package com.example.services;

import java.util.List;

import com.example.dao.NoteDAO;
import com.example.model.NoteModel;

public class NoteService {

	private NoteDAO dao;
	
	public NoteService() {
		super();
		this.dao = new NoteDAO();
	}



	public Long save(NoteModel noteModel) {
		return dao.save(noteModel);
	}


	public List<NoteModel> findAllByUserId(Long id) {
		return dao.findAllByUserId(id);
	}



	public boolean deleteNoteById(Long id) {
		return dao.deleteNoteById(id);
		
	}



	public NoteModel findOneById(Long id) {
		return dao.findOneById(id);
	}


	public boolean updateNote(NoteModel newNote) {
		return dao.updateNote(newNote);
	}
	
}
