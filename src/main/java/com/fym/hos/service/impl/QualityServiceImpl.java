package com.fym.hos.service.impl;

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
import com.fym.hos.dao.QualityRepository;
import com.fym.hos.dto.PageDto;
import com.fym.hos.dto.PageQueryDto;
import com.fym.hos.dto.TPatientDto;
import com.fym.hos.dto.TQualityDto;
import com.fym.hos.entity.TQuality;
import com.fym.hos.service.PatientService;
import com.fym.hos.service.QualityService;
import com.fym.utils.BeanMapperUtils;

@Service
public class QualityServiceImpl implements QualityService {

    @Autowired
    private QualityRepository qualityRepository;
    @Autowired
    PatientService patientService;
    /**
	 * 保存方法
	 * @param tQuality 质控人员
	 * @return
	 */
    @Override
    @Transactional
    public TQualityDto save(TQuality tQuality) {
        tQuality = qualityRepository.saveAndFlush(tQuality);
        return BeanMapperUtils.map(tQuality, TQualityDto.class);
    }

    @Override
    public void saveAndUpdate(TQuality tQuality) {
    }
    /**
	 * 单条删除
	 * @param id    
	 */
    @Override
    public void delete(String id) {
        qualityRepository.delete(id);
    }
    /**
	 * 多条删除
	 * @param ids  
	 */
    @Override
    @Transactional
    public void removeMulti(String ids) {
        String[] id = ids.split(",");
        for (int i = 0; i < id.length; i++) {
            qualityRepository.delete(id[i]);
        }
    }
    /**
	 * 分页查询，并模糊查询theName(姓名）,也可以不需要条件
	 * @param page	  分页条件
	 * @param theName 质控人员名称
	 * @return
	 */
    @Override
    @Transactional(readOnly = true)
    public PageDto<TQualityDto> page(PageQueryDto<TQuality> page, String theName) {
        PageRequest pageable = new PageRequest(page.getCurrentPage(), page.getPageSize());

        Specification<TQuality> spec = new Specification<TQuality>() {
        	
            @Override
            public Predicate toPredicate(Root<TQuality> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
            	
                Predicate p1 = cb.conjunction(); // 0=1
                // 添加查询条件
                if (!StringUtils.isEmpty(theName)) {
                    p1 = cb.like(root.get("theName").as(String.class), "%" + theName + "%");
                }
                return p1;
            }
        };
        
        Page<TQuality> findAll = qualityRepository.findAll(spec, pageable);
//        System.out.println(findAll.getNumber());
//        System.out.println(findAll.getTotalPages());
//        System.out.println(findAll.getSize());
//        System.out.println(findAll.getContent());
        return new PageDto<TQualityDto>(findAll.getNumber(), findAll.getTotalPages(), findAll.getSize(),
                BeanMapperUtils.mapList(findAll.getContent(), TQuality.class, TQualityDto.class));
    }
    /**
	 * 根据Id 获取质控实体，返回医生DTO
	 * @param id
	 * @return
	 */
    @Override
    @Transactional(readOnly = true)
    public TQualityDto get(String id) {
        TQuality tQuality = qualityRepository.getOne(id);
        return BeanMapperUtils.map(tQuality, TQualityDto.class);
    }
    /**
	 * 根据姓名，描述 来查询，返回一个质控dto LIST，（用于手机app上面）
	 * @param theName 查询的名称
	 * @return
	 */
    @Override
    @Transactional(readOnly = true)
    public List<TQualityDto> findAll(String theName) {
        List<TQuality> list = qualityRepository.findAll(new Specification<TQuality>() {
            @Override
            public Predicate toPredicate(Root<TQuality> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Predicate predicate = cb.conjunction(); // 0=1
                // 添加查询条件
                if (!StringUtils.isEmpty(theName)) {
                    predicate.getExpressions()
                            .add(cb.like(root.get("theName"), "%" + theName + "%"));
                }
                Predicate two = cb.conjunction();
                // 添加查询条件
                if (!StringUtils.isEmpty(theName)) {
                    two.getExpressions()
                            .add(cb.like(root.get("theDesc"), "%" + theName + "%"));
                }
                return cb.or(predicate, two);
            }
        });

        // 一定要进行映射，否则会进行懒加载数据，导致查询数据缓慢
        return BeanMapperUtils.mapList(list, TQuality.class, TQualityDto.class);
    }
    /**
	 * 分页查询，并模糊查询theName(姓名）
	 * @param page
	 * @param theName
	 * @return
	 */
    @Override
    @Transactional(readOnly = true)
    public PageDto<TQualityDto> pageByApp(PageQueryDto<TQuality> page, String theName) {
        PageRequest pageable = new PageRequest(page.getCurrentPage(), page.getPageSize());

        Specification<TQuality> spec = new Specification<TQuality>() {
            @Override
            public Predicate toPredicate(Root<TQuality> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Predicate predicate = cb.conjunction();
                // 添加查询条件
                if (!StringUtils.isEmpty(theName)) {
                    predicate.getExpressions()
                            .add(cb.like(root.get("theName"), "%" + theName + "%"));
                }
                return predicate;
            }
        };
        Page<TQuality> findAll = qualityRepository.findAll(spec, pageable);
        return new PageDto<TQualityDto>(findAll.getNumber(), findAll.getTotalPages(), findAll.getSize(),
                BeanMapperUtils.mapList(findAll.getContent(), TQuality.class, TQualityDto.class));
    }

	@Override
	public boolean isCite(String ids,String type) {
		List<TPatientDto> patientList = patientService.findAll("");
		for (TPatientDto tPatientDto : patientList) {
			if(type.equals("doctor")){
				if(ids.contains(tPatientDto.getDoctor().getId())){
					return false;
				}
			}else{
				if(ids.contains(tPatientDto.getQuality().getId())){
					return false;
				}
			}
		}
		return true;
	}
}
