package com.fym.hos.service.impl;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.fym.hos.dao.PatientRepository;
import com.fym.hos.dto.PageDto;
import com.fym.hos.dto.PageQueryDto;
import com.fym.hos.dto.TPatientDto;
import com.fym.hos.entity.TPatient;
import com.fym.hos.service.PatientService;
import com.fym.utils.BeanMapperUtils;
import org.springframework.web.bind.annotation.CrossOrigin;

@Service
public class PatientServiceImpl implements PatientService {
  // wo gen ni 我跟你讲一下代码， 有问题，QQ发我
    @Autowired
    private PatientRepository patientRepository;
    /**
	 * 保存方法
	 */
    @Override
    @Transactional
	public TPatientDto save(TPatient tPatient) {
    	tPatient = patientRepository.saveAndFlush(tPatient);
        return BeanMapperUtils.map(tPatient,TPatientDto.class);
    }
 
    /**
	 * 单条删除
	 */
    @Override
    @Transactional
    public void delete(String id) {
    	patientRepository.delete(id); //根据id删除数据
    }
    /**
	 * 多条删除
	 */
    @Override
    @Transactional
    public void removeMulti(String ids) {
        String[] id = ids.split(",");
        for (int i = 0; i < id.length; i++) {  
        	patientRepository.delete(id[i]);
        }
    }
    /**
	 *  分页查询，并模糊查询theName(姓名）,也可以不需要条件
	 */
    @Override
    @Transactional(readOnly = true)
    public PageDto<TPatientDto> page(PageQueryDto<TPatient> page, String theName) {
        PageRequest pageable = new PageRequest(page.getCurrentPage(), page.getPageSize());
        Specification<TPatient> spec = new Specification<TPatient>() { 
        	@Override
            public Predicate toPredicate(Root<TPatient> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Predicate p1 = cb.conjunction(); // 1=1  如果是  where  theName=1    这里是如果theName有值就行模糊差，无值正常查询。
                if (!StringUtils.isEmpty(theName)) { // 判断查询条件是否为空，不为空，则添加条件， 
                    p1 = cb.like(root.get("theName").as(String.class), "%" + theName + "%");
                }
                return p1;
            }
        };
        Page<TPatient> findAll = patientRepository.findAll(spec, pageable);
        return new PageDto<TPatientDto>(findAll.getNumber(), findAll.getTotalPages(), findAll.getSize(),
                BeanMapperUtils.mapList(findAll.getContent(), TPatient.class, TPatientDto.class)); 
    }
    /**
	 * 根据Id 获取病例实体，返回病例DTO
	 */
    @Override
    @Transactional(readOnly = true)	
    public TPatientDto get(String id) { 
        TPatient TPatient = patientRepository.getOne(id);
        return BeanMapperUtils.map(TPatient,TPatientDto.class);
    }
    /**
	 * 根据姓名，描述 来查询，返回一个病例dto LIST，（用于手机app上面）
	 */
    @Override
    @Transactional(readOnly = true)
    public List<TPatientDto> findAll(String theName) {
    	
        List<TPatient> list = patientRepository.findAll(new Specification<TPatient>() {
        	
            @Override
            public Predicate toPredicate(Root<TPatient> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
            	Predicate predicate = cb.conjunction(); // 0=1  这个代表 where 0=1 不成立得一个条目
                // 添加查询条件
                if (!StringUtils.isEmpty(theName)) {
                    predicate.getExpressions() // 添加条件
                            .add(cb.like(root.get("theName"), "%" + theName + "%"));
                }
                Predicate two = cb.disjunction(); // 0=1  这个代表 where 0=1 不成立得一个条目

                try{
                    // 添加查询条件
                    if (!StringUtils.isEmpty(theName)) {
                        two.getExpressions() // 添加条件
                                .add(cb.equal(root.get("hNumber") , theName  ));
                    }
                }catch(Exception e){

                }


                return cb.or(predicate, two); // or条件拼接 where theName like  or theDesc like  不懂可以测试看SQL
            }
        });

        // 一定要进行映射，否则会进行懒加载数据，导致查询数据缓慢（集合映射）将集合映射为TDoctorDto 集合
        return BeanMapperUtils.mapList(list, TPatient.class, TPatientDto.class);
    }
    /**
	 * 分页查询，并模糊查询theName(姓名）
	 */
    @Override
    @Transactional(readOnly = true)
    public PageDto<TPatientDto> pageByApp(PageQueryDto<TPatient> page, String theName) {// 你看下这个 看懂了吗感觉差不多。。对得，后期我们做平台要封装得
        PageRequest pageable = new PageRequest(page.getCurrentPage(), page.getPageSize());

        Specification<TPatient> spec = new Specification<TPatient>() {
            @Override
            public Predicate toPredicate(Root<TPatient> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Predicate predicate = cb.conjunction();
                // 添加查询条件
                if (!StringUtils.isEmpty(theName)) {
                    predicate.getExpressions()
                            .add(cb.like(root.get("theName"), "%" + theName + "%"));
                }
                return predicate;
            }// 代码讲完了，就这么简单 ？ 你把控制层 我走啦
        };
        Page<TPatient> findAll = patientRepository.findAll(spec, pageable);
        return new PageDto<TPatientDto>(findAll.getNumber(), findAll.getTotalPages(), findAll.getSize(),
                BeanMapperUtils.mapList(findAll.getContent(), TPatient.class, TPatientDto.class));
    }


    @Override
    @Transactional(readOnly = true)
    public boolean validTheHNumber(BigInteger hNumber) {
        TPatient patient = patientRepository.findByHNumber(hNumber);
        if (patient == null)
            return true;
        else return false;
    }
}
