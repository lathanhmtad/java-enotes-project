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

	public List<NoteModel> findAllByUserId(Long userId) {
		String sql = "select *\r\n"
				+ "from note\r\n"
				+ "where user_id = ?\r\n"
				+ "order by modified_date desc, id desc;";
		return query(sql, new NoteMapper(), userId);
	}
	
	public List<NoteModel> findAllByUserId(Long userId, Long latestNoteId) {
		String sql = "select *\r\n"
				+ "from note\r\n"
				+ "where user_id = ?\r\n"
				+ "order by \r\n"
				+ "	case when id = ? then 0 else 1 end,\r\n"
				+ "    modified_date desc,\r\n"
				+ "    id desc;";
		return query(sql, new NoteMapper(), userId, latestNoteId);
	}

	public boolean deleteNoteById(Long id) {
		String sql = "DELETE FROM note WHERE id= ?";
		return update(sql, id);
	}

	public NoteModel findOneById(Long id) {
		String sql = "select * from note where id = ?";
		List<NoteModel> notes = query(sql, new NoteMapper(), id);
		return notes.isEmpty() ? null : notes.get(0);
	}

	public boolean update(NoteModel newNote) {
		newNote.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		String sql = "UPDATE note set title = ?, content = ?, modified_date = ? where id = ?";
		return update(sql, newNote.getTitle(), newNote.getContent(), newNote.getModifiedDate(), newNote.getId());
	}

}
