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

import com.fym.hos.dao.QualityRepository;
import com.fym.hos.dto.PageDto;
import com.fym.hos.dto.PageQueryDto;
import com.fym.hos.dto.TQualityDto;
import com.fym.hos.entity.TQuality;
import com.fym.hos.service.QualityService;
import com.fym.utils.BeanMapperUtils;

@Service
public class QualityServiceImpl implements QualityService {

    @Autowired
    private QualityRepository qualityRepository;

    @Override
    @Transactional
    public TQualityDto save(TQuality tQuality) {
        tQuality = qualityRepository.saveAndFlush(tQuality);
        return BeanMapperUtils.map(tQuality, TQualityDto.class);
    }

    @Override
    public void saveAndUpdate(TQuality tQuality) {
    }

    @Override
    public void delete(String id) {
        qualityRepository.delete(id);
    }

    @Override
    @Transactional
    public void removeMulti(String ids) {
        String[] id = ids.split(",");
        for (int i = 0; i < id.length; i++) {
            qualityRepository.delete(id[i]);
        }
    }

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
        return new PageDto<TQualityDto>(findAll.getNumber(), findAll.getTotalPages(), findAll.getSize(),
                BeanMapperUtils.mapList(findAll.getContent(), TQuality.class, TQualityDto.class));
    }

    @Override
    @Transactional(readOnly = true)
    public TQualityDto get(String id) {
        TQuality tQuality = qualityRepository.getOne(id);
        return BeanMapperUtils.map(tQuality, TQualityDto.class);
    }

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


}
