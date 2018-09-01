package com.fym.hospital.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fym.hos.dto.GlobalResponse;
import com.fym.hos.dto.PageQueryDto;
import com.fym.hos.dto.Show;
import com.fym.hos.dto.TQualityDto;
import com.fym.hos.entity.TQuality;
import com.fym.hos.service.QualityService;

@RestController
@RequestMapping("/hos/quality")
public class QualityController {

	@Autowired
	private QualityService qualityService;
	 


    /**
     * 保存
     *
     * @param tQuality  质控实体
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
     * @param page      分页条件
     * @param theName	模糊查询条件
     * @return
     */
    @GetMapping("/")
//    public GlobalResponse<TQualityDto> page(PageQueryDto<TQuality> page, String theName,@RequestParam(name="page") int cPage,@RequestParam(name="limit") int limit) {
    public Show page(PageQueryDto<TQuality> page, String theName,@RequestParam(name="page") int cPage,@RequestParam(name="limit") int limit) {
    	page.setCurrentPage(cPage-1);
    	page.setPageSize(limit);
//    	System.out.println(new GlobalResponse<TQualityDto>(qualityService.page(page, theName)).getPage().getData().get(1).getTheName());
    	Show show = new Show();
    	List<TQualityDto> tq = new ArrayList<TQualityDto>();
    	GlobalResponse<TQualityDto>  g = findAll(theName);
    	tq = new GlobalResponse<TQualityDto>(qualityService.page(page, theName)).getPage().getData();
    	show.setCount(g.getData().size());
    	show.setData(tq);
    	return show;
//        return new GlobalResponse<TQualityDto>(qualityService.page(page, theName));
    }


    /**
     * 查询所有
     *
     * @param theName        模糊查询条件（可根据名称或描述）来查询
     * @return
     */
    @GetMapping("/findAll")
    public GlobalResponse<TQualityDto> findAll(String theName) {
        return new GlobalResponse<TQualityDto>(qualityService.findAll(theName));
    }


    /**
     * 提供给app的分页查询
     *
     * @param page      分页条件
     * @param theName	模糊查询条件
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
    public GlobalResponse<TQuality> removeMulti(@RequestParam(name="ids") String ids) {
    	boolean flag = qualityService.isCite(ids,"quliaty");
    	if(flag == false){
    		 return new GlobalResponse<TQuality>(1, "删除失败");
    	}
        qualityService.removeMulti(ids);
        return new GlobalResponse<TQuality>(0, "删除成功");
    }


}
