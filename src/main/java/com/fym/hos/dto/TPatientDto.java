package com.fym.hos.dto;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fym.hos.entity.TDoctor;
import com.fym.hos.entity.TQuality;

public class TPatientDto {
    private String id;

    private Date archiveDate;

    private String bedNumber;

    private int endemicArea;
    private String endemicAreaText;

    private int expectArchive;
    private String expectArchiveText;

    private String f1;

    private String f2;

    private String f3;

    private String f4;

    private String f5;

    private String guardian;

    private BigInteger hNumber;

    private String idNumber;

    private Date inHospitalDate;

    private String inHospitalDiagnosis;

    private Date outHospitalDate;

    private String outHospitalDiagnosis;

    private Date qualityDate;

    private int sampleDiagnosis;
    private String sampleDiagnosisText;
    private int theAge;

    private String theName;

    private String theSex;
    private String theSexText;


    private TQualityDto quality;

    private TDoctorDto doctor;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getArchiveDate() {
        return archiveDate;
    }

    public void setArchiveDate(Date archiveDate) {
        this.archiveDate = archiveDate;
    }

    public String getBedNumber() {
        return bedNumber;
    }

    public void setBedNumber(String bedNumber) {
        this.bedNumber = bedNumber;
    }

    public int getEndemicArea() {
        return endemicArea;
    }

    public void setEndemicArea(int endemicArea) {
        this.endemicArea = endemicArea;
    }


    public String getF1() {
        return f1;
    }

    public void setF1(String f1) {
        this.f1 = f1;
    }

    public String getF2() {
        return f2;
    }

    public void setF2(String f2) {
        this.f2 = f2;
    }

    public String getF3() {
        return f3;
    }

    public void setF3(String f3) {
        this.f3 = f3;
    }

    public String getF4() {
        return f4;
    }

    public void setF4(String f4) {
        this.f4 = f4;
    }

    public String getF5() {
        return f5;
    }

    public void setF5(String f5) {
        this.f5 = f5;
    }

    public String getGuardian() {
        return guardian;
    }

    public void setGuardian(String guardian) {
        this.guardian = guardian;
    }

    public BigInteger gethNumber() {
        return hNumber;
    }

    public void sethNumber(BigInteger hNumber) {
        this.hNumber = hNumber;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public Date getInHospitalDate() {
        return inHospitalDate;
    }

    public void setInHospitalDate(Date inHospitalDate) {
        this.inHospitalDate = inHospitalDate;
    }

    public String getInHospitalDiagnosis() {
        return inHospitalDiagnosis;
    }

    public void setInHospitalDiagnosis(String inHospitalDiagnosis) {
        this.inHospitalDiagnosis = inHospitalDiagnosis;
    }

    public Date getOutHospitalDate() {
        return outHospitalDate;
    }

    public void setOutHospitalDate(Date outHospitalDate) {
        this.outHospitalDate = outHospitalDate;
    }

    public String getOutHospitalDiagnosis() {
        return outHospitalDiagnosis;
    }

    public void setOutHospitalDiagnosis(String outHospitalDiagnosis) {
        this.outHospitalDiagnosis = outHospitalDiagnosis;
    }

    public Date getQualityDate() {
        return qualityDate;
    }

    public void setQualityDate(Date qualityDate) {
        this.qualityDate = qualityDate;
    }


    public int getTheAge() {
        return theAge;
    }

    public void setTheAge(int theAge) {
        this.theAge = theAge;
    }

    public String getTheName() {
        return theName;
    }

    public void setTheName(String theName) {
        this.theName = theName;
    }

    public String getTheSex() {
        return theSex;
    }

    public void setTheSex(String theSex) {
        this.theSex = theSex;
    }

    public TQualityDto getQuality() {
        return quality;
    }

    public void setQuality(TQualityDto quality) {
        this.quality = quality;
    }

    public TDoctorDto getDoctor() {
        return doctor;
    }

    public void setDoctor(TDoctorDto doctor) {
        this.doctor = doctor;
    }

    public int getExpectArchive() {
        return expectArchive;
    }

    public void setExpectArchive(int expectArchive) {
        this.expectArchive = expectArchive;
    }

    public int getSampleDiagnosis() {
        return sampleDiagnosis;
    }

    public String getTheSexText() {
        if ("0".equals(theSex))
            return "女";
        else
            return "男";
    }

    public void setTheSexText(String theSexText) {
        this.theSexText = theSexText;
    }

    public void setSampleDiagnosis(int sampleDiagnosis) {
        this.sampleDiagnosis = sampleDiagnosis;
    }


    public String getExpectArchiveText() {
        if(expectArchive==1 ) return "是";
        else return "否";
    }

    public void setExpectArchiveText(String expectArchiveText) {
        this.expectArchiveText = expectArchiveText;
    }

    public String getSampleDiagnosisText() {
        if(sampleDiagnosis==1 ) return "是";
        else return "否";
    }

    public void setSampleDiagnosisText(String sampleDiagnosisText) {
        this.sampleDiagnosisText = sampleDiagnosisText;
    }

    public String getEndemicAreaText() {
       if(endemicArea==1){
           return "三病区";
       }else if(endemicArea==2){
           return "四病区";
       }else if(endemicArea==3){

           return "五病区";
       }else if(endemicArea==4){

           return "六病区";
       }else if(endemicArea==5){
           return "七病区";
       }else
           return "二病区";
    }

    public void setEndemicAreaText(String endemicAreaText) {
        this.endemicAreaText = endemicAreaText;
    }
}
