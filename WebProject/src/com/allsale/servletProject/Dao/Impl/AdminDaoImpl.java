package com.allsale.servletProject.Dao.Impl;

import com.allsale.servletProject.Dao.AdminDao;
import com.allsale.servletProject.entity.Admin;
import com.allsale.servletProject.utils.DBUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AdminDaoImpl  implements AdminDao {

    private QueryRunner queryRunner = new QueryRunner();


    @Override
    public int insert(Admin admin) {
        return 0;
    }

    @Override
    public int delete(String username) {
        return 0;
    }

    @Override
    public int update(Admin admin) {
        return 0;
    }

    @Override
    public Admin select(String username) throws SQLException {
        Admin admin = queryRunner.query(DBUtils.getConnection(),"select * from admin where username=?;",new BeanHandler<Admin>(Admin.class),username);
        return admin;
    }

    @Override
    public List<Admin> selectAll() throws SQLException {
        List<Admin> admins = queryRunner.query(DBUtils.getConnection(),"select * from admin", new BeanListHandler<Admin>(Admin.class));
        return admins;
    }
}
