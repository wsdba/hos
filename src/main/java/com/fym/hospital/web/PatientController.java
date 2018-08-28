package com.fym.hospital.web;

import com.fym.hos.dto.GlobalResponse;
import com.fym.hos.dto.PageQueryDto;
import com.fym.hos.dto.TPatientDto;
import com.fym.hos.entity.TPatient;
import com.fym.hos.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@RestController
@RequestMapping("/hos/patient")
public class PatientController {

	@Autowired
	private PatientService patientService;
	 


    /**
     * 保存
     *
     * @param tPatient
     * @return
     */
    @PostMapping("/")
    @CrossOrigin
    public GlobalResponse<TPatientDto> add(@RequestBody TPatient tPatient) {
        TPatientDto tPatientDto = patientService.save(tPatient);
        return new GlobalResponse<TPatientDto>(tPatientDto);
    }


    /**
     * 删除
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public GlobalResponse<TPatient> delete(@PathVariable String id) {
    	patientService.delete(id);
        return new GlobalResponse<TPatient>(0, "删除成功");
    }

    /**
     * 分页
     *
     * @param page
     * @param theName
     * @return
     */
    @GetMapping("/")
    public GlobalResponse<TPatientDto> page(PageQueryDto<TPatient> page, String theName) {
        return new GlobalResponse<TPatientDto>(patientService.page(page, theName));
    }


    /**
     * 查询所有
     *
     * @param theName
     * @return
     */
    @GetMapping("/findAll")
    public GlobalResponse<TPatientDto> findAll(String theName) {
        return new GlobalResponse<TPatientDto>(patientService.findAll(theName));
    }


    /**
     * 提供给app的分页查询
     *
     * @param page
     * @param theName
     * @return
     */
    @GetMapping("/pageByApp")
    public GlobalResponse<TPatientDto> pageByApp(PageQueryDto<TPatient> page, String theName) {
        return new GlobalResponse<TPatientDto>(patientService.pageByApp(page, theName));
    }

    /**
     * 提供给app的住院号校验
     *
     * @param hNumber 住院号
     * @return
     */
    @GetMapping("/validTheHNumber")
    public GlobalResponse<TPatientDto> validTheHNumber(BigInteger hNumber) {
        boolean flag  = patientService.validTheHNumber(hNumber);
        if(flag){
            return new GlobalResponse<TPatientDto>(-1,"唯一，不重复");
        }else{
            return new GlobalResponse<TPatientDto>(0,"重复");
        }
    }

    /**
     * 根据id获取数据
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public GlobalResponse<TPatientDto> get(@PathVariable String id) {
        return new GlobalResponse<TPatientDto>(patientService.get(id));
    }

    /**
     * 根据id更新数据
     *
     * @param id
     * @param tPatient
     * @return
     */
    @PutMapping("/{id}")
    @CrossOrigin
    public GlobalResponse<TPatient> update(@PathVariable String id, @RequestBody TPatient tPatient) {
    	patientService.save(tPatient);
        return new GlobalResponse<TPatient>(0, "更新成功");
    }


    /**
     * 删除多个
     *
     * @param ids，以逗号分隔。 比如1,2,3
     * @return
     */
    @DeleteMapping("/removeMulti")
    public GlobalResponse<TPatient> removeMulti(String ids) {
    	patientService.removeMulti(ids);
        return new GlobalResponse<TPatient>(0, "删除成功");
    }


}
