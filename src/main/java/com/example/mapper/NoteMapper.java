package com.example.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.model.NoteModel;

public class NoteMapper implements RowMapper<NoteModel> {



	@Override
	public NoteModel mapRow(ResultSet rs) {
		NoteModel note = new NoteModel();
		try {
			note.setId(rs.getLong("id"));
			note.setTitle(rs.getString("title"));
			note.setContent(rs.getString("content"));
			note.setCreatedDate(rs.getTimestamp("created_date"));
			note.setCreatedBy(rs.getString("created_by"));
			
			return note;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
