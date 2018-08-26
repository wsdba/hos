package com.fym.hospital.web;

import com.fym.hos.dto.GlobalResponse;
import com.fym.hos.dto.PageQueryDto;
import com.fym.hos.dto.TQualityDto;
import com.fym.hos.entity.TQuality;
import com.fym.hos.service.QualityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hos/quality")
public class QualityController {

    @Autowired
    private QualityService qualityService;


    /**
     * 保存
     *
     * @param tQuality
     * @return
     */
    @PostMapping("/")
    public GlobalResponse<TQuality> add(@RequestBody TQuality tQuality) {
        qualityService.save(tQuality);
        return new GlobalResponse<TQuality>(0, "保存成功");
    }


    /**
     * 删除
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public GlobalResponse<TQuality> delete(@PathVariable String id) {
        qualityService.delete(id);
        return new GlobalResponse<TQuality>(0, "删除成功");
    }

    /**
     * 分页
     *
     * @param page
     * @param theName
     * @return
     */
    @GetMapping("/")
    public GlobalResponse<TQualityDto> page(PageQueryDto<TQuality> page, String theName) {
        return new GlobalResponse<TQualityDto>(qualityService.page(page, theName));
    }


    /**
     * 查询所有
     *
     * @param theName
     * @return
     */
    @GetMapping("/findAll")
    public GlobalResponse<TQualityDto> findAll(String theName) {
        return new GlobalResponse<TQualityDto>(qualityService.findAll(theName));
    }


    /**
     * 提供给app的分页查询
     *
     * @param page
     * @param theName
     * @return
     */
    @GetMapping("/pageByApp")
    public GlobalResponse<TQualityDto> pageByApp(PageQueryDto<TQuality> page, String theName) {
        return new GlobalResponse<TQualityDto>(qualityService.pageByApp(page, theName));
    }

    /**
     * 根据id获取数据
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public GlobalResponse<TQualityDto> get(@PathVariable String id) {
        return new GlobalResponse<TQualityDto>(qualityService.get(id));
    }

    /**
     * 根据id更新数据
     *
     * @param id
     * @param tQuality
     * @return
     */
    @PutMapping("/{id}")
    public GlobalResponse<TQuality> update(@PathVariable String id, @RequestBody TQuality tQuality) {
        qualityService.save(tQuality);
        return new GlobalResponse<TQuality>(0, "更新成功");
    }


    /**
     * 删除多个
     *
     * @param ids，以逗号分隔。 比如1,2,3
     * @return
     */
    @DeleteMapping("/removeMulti")
    public GlobalResponse<TQuality> removeMulti(String ids) {
        qualityService.removeMulti(ids);
        return new GlobalResponse<TQuality>(0, "删除成功");
    }


}
