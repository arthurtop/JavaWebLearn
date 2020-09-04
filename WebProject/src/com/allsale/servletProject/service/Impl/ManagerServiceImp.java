package com.allsale.servletProject.service.Impl;

import com.allsale.servletProject.Dao.Impl.ManagerDaoImpl;
import com.allsale.servletProject.Dao.ManagerDao;
import com.allsale.servletProject.entity.Manager;
import com.allsale.servletProject.service.ManagerService;
import com.allsale.servletProject.utils.DBUtils;

public class ManagerServiceImp implements ManagerService {

    private ManagerDao managerDao = new ManagerDaoImpl();

    @Override
    public Manager login(String username, String password) {

        Manager manager = null;

        try {
            DBUtils.begin();
            Manager temp = managerDao.select(username);
            if (temp != null){
                if (temp.getPassword().equals(password)){
                    manager = temp;
                }
            }
            DBUtils.commit();
        } catch (Exception e) {
            DBUtils.rollback();

            e.printStackTrace();
        }

        return manager;
    }
}









