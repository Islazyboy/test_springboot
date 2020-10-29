package com.usian.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.usian.entity.Emp;
import com.usian.mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class EmpService {
    @Autowired
    private EmpMapper empMapper;
    public PageInfo<Emp> selectAll(Emp emp, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        Example example = new Example(Emp.class);
        Example.Criteria criteria = example.createCriteria();
        if(StringUtil.isNotEmpty(emp.getName())){
            criteria.andLike("name","%"+emp.getName()+"%");
        }
        if(emp.getStarttime()!=null){
            criteria.andGreaterThanOrEqualTo("birthday",emp.getStarttime());
        }
        if(emp.getEndtime()!=null){
            criteria.andLessThan("birthday",emp.getEndtime());
        }
        List<Emp> list = empMapper.selectByExample(example);
        return new PageInfo<Emp>(list);
    }

    public void insert(Emp emp) {
        empMapper.insert(emp);
    }

    public void delById(Integer id) {
        empMapper.deleteByPrimaryKey(id);
    }

    public Emp queryById(Integer id) {
        return empMapper.selectByPrimaryKey(id);
    }

    public void update(Emp emp) {
        empMapper.updateByPrimaryKey(emp);
    }
}
