package com.allsale.servletProject.Dao.Impl;

import com.allsale.servletProject.Dao.ManagerDao;
import com.allsale.servletProject.entity.Manager;
import com.allsale.servletProject.utils.DBUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class ManagerDaoImpl implements ManagerDao {

    private QueryRunner queryRunner = new QueryRunner();


    @Override
    public Manager select(String username) {

        try {
            Manager manager = queryRunner.query(DBUtils.getConnection(),"select * from manager where username=?",new BeanHandler<Manager>(Manager.class),username);
                    return manager;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }
}
