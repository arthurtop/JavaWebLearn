package com.allsale.servletProject.service.Impl;

import com.allsale.servletProject.Dao.AdminDao;
import com.allsale.servletProject.Dao.Impl.AdminDaoImpl;
import com.allsale.servletProject.entity.Admin;
import com.allsale.servletProject.service.AdminService;
import com.allsale.servletProject.utils.DBUtils;

import java.awt.image.DataBufferByte;
import java.sql.SQLException;
import java.util.List;

public class AdminServiceImpl implements AdminService {

    private AdminDao adminDao = new AdminDaoImpl();

    @Override
    public Admin login(String username, String password) {

        Admin result = null;
        try {
            DBUtils.begin();
            Admin admin = adminDao.select(username);
            if (admin != null){
                if (admin.getPassword().equals(password)){
                    result = admin;
                }
            }
            DBUtils.commit();
        } catch (SQLException throwables) {
            DBUtils.rollback();
            throwables.printStackTrace();
        }


        return result;
    }

    @Override
    public List<Admin> showAllAdmin() {
        return null;
    }
}



