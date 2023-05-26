package com.example.dao;

import java.sql.Timestamp;
import java.util.List;

import com.example.mapper.NoteMapper;
import com.example.model.NoteModel;

public class NoteDAO extends AbstractDAO<NoteModel> {
	public Long save(NoteModel noteModel) {
		noteModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		String sql = "insert into note (title, content, user_id, created_date, created_by) values(?,?,?,?,?)";

		Long id = insert(sql, noteModel.getTitle(), noteModel.getContent(), noteModel.getUser().getId(),
				noteModel.getCreatedDate(), noteModel.getUser().getEmail());

		return id;
	}

	public List<NoteModel> findAllByUserId(Long id) {
		String sql = "select * from note where user_id = ?";
		return query(sql, new NoteMapper(), id);
	}

	public boolean deleteNoteById(Long id) {
		String sql = "DELETE FROM note WHERE id= ? ";
		return update(sql, id);
	}

	public NoteModel findOneById(Long id) {
		String sql = "select * from note where id = ?";
		List<NoteModel> notes = query(sql, new NoteMapper(), id);
		return notes.isEmpty() ? null : notes.get(0);
	}

	public boolean updateNote(NoteModel newNote) {
		String sql = "UPDATE note set title = ?, content = ? where id = ?";
		return update(sql, newNote.getTitle(), newNote.getContent(), newNote.getId());
	}

}
