package com.fym.hos.service.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.fym.hos.dao.DoctorRepository;
import com.fym.hos.dto.PageDto;
import com.fym.hos.dto.PageQueryDto;
import com.fym.hos.dto.TDoctorDto;
import com.fym.hos.entity.TDoctor;
import com.fym.hos.service.DoctorService;
import com.fym.utils.BeanMapperUtils;

@Service
public class DoctorServiceImpl implements DoctorService {
  // wo gen ni 我跟你讲一下代码， 有问题，QQ发我
    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    @Transactional
	public TDoctorDto save(TDoctor tDoctor) {
    	// 保存实体医生,保存成功完毕，会返回对象
    	tDoctor = doctorRepository.saveAndFlush(tDoctor);
    	// 这一步 是将 实体里面得数据 -> copy 拷贝 到  TDoctorDto 这个类里面去，要求 属性名一致，类型一致
    	// 为什么这么做，前面说了，用DTO是为了什么 明白？明白。。
        return BeanMapperUtils.map(tDoctor,TDoctorDto.class);
    }
 

    @Override
    @Transactional
    public void delete(String id) {
        doctorRepository.delete(id); //根据id删除数据
    }

    @Override
    @Transactional
    public void removeMulti(String ids) {
        String[] id = ids.split(",");
        for (int i = 0; i < id.length; i++) {  
            doctorRepository.delete(id[i]);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public PageDto<TDoctorDto> page(PageQueryDto<TDoctor> page, String theName) {
    	// 分页查询，并模糊查询theName(姓名）
    	/*
    	 * 第一步：创建分页对象，传递当前页以及每页多少条目
    	 * 第二步：创建条件对象，进行模糊查询
    	 * 第三步：
    	 */
        PageRequest pageable = new PageRequest(page.getCurrentPage(), page.getPageSize());
        Specification<TDoctor> spec = new Specification<TDoctor>() { 
        	//这个为什么这么用，是因为indAll(Specification<T> spec, Pageable pageable); 很明显，需要传递条件，所以我们使用匿名类，我是图快，采用匿名类。
           // 默认 让实现一个方法，就是下面这个
        	@Override
            public Predicate toPredicate(Root<TDoctor> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Predicate p1 = cb.conjunction(); // 1=1  如果是  where  theName=1    这里是如果theName有值就行模糊差，无值正常查询。
                // conjunction 方法 默认 添加条件 1=1  也就是   where  1 = 1   
                // 添加查询条件
                if (!StringUtils.isEmpty(theName)) { // 判断查询条件是否为空，不为空，则添加条件， 
                    p1 = cb.like(root.get("theName").as(String.class), "%" + theName + "%");
                }
                // 这里就返回组装好得条件
                return p1;
            }
        };
        // 查询将条件传递包括分页
        Page<TDoctor> findAll = doctorRepository.findAll(spec, pageable);
        // 最后 将分页数据 换对象返回。 当前页，总页数，页面条目。当页数据
        return new PageDto<TDoctorDto>(findAll.getNumber(), findAll.getTotalPages(), findAll.getSize(),
                BeanMapperUtils.mapList(findAll.getContent(), TDoctor.class, TDoctorDto.class)); 
    }

    @Override
    @Transactional(readOnly = true)	
    public TDoctorDto get(String id) { 
        TDoctor TDoctor = doctorRepository.getOne(id);
        return BeanMapperUtils.map(TDoctor,TDoctorDto.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TDoctorDto> findAll(String theName) {
    	
        List<TDoctor> list = doctorRepository.findAll(new Specification<TDoctor>() {
        	
        	// or条件查询
            @Override
            public Predicate toPredicate(Root<TDoctor> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
               // 这个跟上面不一样，这个是提供给手机使用，手机只有一个输入框，但是却可以查两类，
            	Predicate predicate = cb.conjunction(); // 0=1  这个代表 where 0=1 不成立得一个条目
                // 添加查询条件
                if (!StringUtils.isEmpty(theName)) {
                    predicate.getExpressions() // 添加条件
                            .add(cb.like(root.get("theName"), "%" + theName + "%"));
                }
                Predicate two = cb.conjunction(); // 0=1  这个代表 where 0=1 不成立得一个条目
                // 添加查询条件
                if (!StringUtils.isEmpty(theName)) {
                    two.getExpressions() // 添加条件
                            .add(cb.like(root.get("theDesc"), "%" + theName + "%"));
                }
                return cb.or(predicate, two); // or条件拼接 where theName like  or theDesc like  不懂可以测试看SQL
            }
        });

        // 一定要进行映射，否则会进行懒加载数据，导致查询数据缓慢（集合映射）将集合映射为TDoctorDto 集合
        return BeanMapperUtils.mapList(list, TDoctor.class, TDoctorDto.class);
    }

    @Override
    @Transactional(readOnly = true)
    public PageDto<TDoctorDto> pageByApp(PageQueryDto<TDoctor> page, String theName) {// 你看下这个 看懂了吗感觉差不多。。对得，后期我们做平台要封装得
        PageRequest pageable = new PageRequest(page.getCurrentPage(), page.getPageSize());

        Specification<TDoctor> spec = new Specification<TDoctor>() {
            @Override
            public Predicate toPredicate(Root<TDoctor> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Predicate predicate = cb.conjunction();
                // 添加查询条件
                if (!StringUtils.isEmpty(theName)) {
                    predicate.getExpressions()
                            .add(cb.like(root.get("theName"), "%" + theName + "%"));
                }
                return predicate;
            }// 代码讲完了，就这么简单 ？ 你把控制层 我走啦
        };
        Page<TDoctor> findAll = doctorRepository.findAll(spec, pageable);
        return new PageDto<TDoctorDto>(findAll.getNumber(), findAll.getTotalPages(), findAll.getSize(),
                BeanMapperUtils.mapList(findAll.getContent(), TDoctor.class, TDoctorDto.class));
    }

}
