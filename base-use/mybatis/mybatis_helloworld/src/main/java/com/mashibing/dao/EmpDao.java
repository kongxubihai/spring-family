package com.mashibing.dao;

import com.mashibing.bean.Emp;

public interface EmpDao {
    Emp findEmpByEmpno(Integer empno);

    public int updateEmp(Emp emp);

    public int deleteEmp(Integer empno);

    public int insertEmp(Emp emp);
}