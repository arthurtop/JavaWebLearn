package com.allsale.servletProject.Dao;

import com.allsale.servletProject.entity.Admin;

import java.sql.SQLException;
import java.util.List;

public interface AdminDao {

    public int insert(Admin admin);
    public int delete(String username);
    public int update(Admin admin);
    public Admin select(String username) throws SQLException;
    public List<Admin> selectAll() throws SQLException;

}
