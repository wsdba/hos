package com.fym.hos.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;


/**
 * 病案类
 * @author  fym
 * @since  2018-08-27
 */
@Entity
@Table(name="t_patient")
public class TPatient implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GenericGenerator(name="idGenerator", strategy="uuid") //这个是hibernate的注解/生成32位UUID
    @GeneratedValue(generator="idGenerator")
	private String id;

	/**
	 * 归档时间
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="archive_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date archiveDate;
	/**
	 * 床号
	 */
	@Column(name="bed_number")
	private String bedNumber;
	/**
	 * 病区
	 */
	@Column(name="endemic_area")
	private int endemicArea;
	/**
	 * 期内归档
	 */
	@Column(name="expect_archive")
	private int expectArchive;

	private String f1;

	private String f2;

	private String f3;

	private String f4;

	private String f5;

	/**
	 * 监护人
	 */
	private String guardian;

	/**
	 * 住院号
	 */
	@Column(name="h_number")
	private BigInteger hNumber;

	/**
	 * 身份证号
	 */
	@Column(name="id_number")
	private String idNumber;

	/**
	 * 入院日期
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="in_hospital_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss" )
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date inHospitalDate;
	/**
	 * 入院诊断
	 */
	@Column(name="in_hospital_diagnosis")
	private String inHospitalDiagnosis;

	/**
	 * 出院日期
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="out_hospital_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date outHospitalDate;
	/**
	 * 出院诊断
	 */
	@Column(name="out_hospital_diagnosis")
	private String outHospitalDiagnosis;

	/**
	 * 质控时间
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="quality_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date qualityDate;

	/**
	 * 入出相符
	 */
	@Column(name="sample_diagnosis")
	private int sampleDiagnosis;

	/**
	 * 年龄
	 */
	@Column(name="the_age")
	private int theAge;

	/**
	 * 姓名
	 */
	@Column(name="the_name")
	private String theName;

	/**
	 * 性别
	 */
	@Column(name="the_sex")
	private String theSex;

	/**
	 * 质控人员
	 */
	//bi-directional many-to-one association to TQuality
	@ManyToOne
	@JoinColumn(name="quality_id")
	private TQuality  quality;

	/**
	 * 医生
	 */
	//bi-directional many-to-one association to TDoctor
	@ManyToOne
	@JoinColumn(name="doctor_id")
	private TDoctor doctor;

	public TPatient() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getArchiveDate() {
		return this.archiveDate;
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
		return this.endemicArea;
	}

	public void setEndemicArea(int endemicArea) {
		this.endemicArea = endemicArea;
	}


	public String getF1() {
		return this.f1;
	}

	public void setF1(String f1) {
		this.f1 = f1;
	}

	public String getF2() {
		return this.f2;
	}

	public void setF2(String f2) {
		this.f2 = f2;
	}

	public String getF3() {
		return this.f3;
	}

	public void setF3(String f3) {
		this.f3 = f3;
	}

	public String getF4() {
		return this.f4;
	}

	public void setF4(String f4) {
		this.f4 = f4;
	}

	public String getF5() {
		return this.f5;
	}

	public void setF5(String f5) {
		this.f5 = f5;
	}

	public String getGuardian() {
		return this.guardian;
	}

	public void setGuardian(String guardian) {
		this.guardian = guardian;
	}

	public BigInteger getHNumber() {
		return this.hNumber;
	}

	public void setHNumber(BigInteger hNumber) {
		this.hNumber = hNumber;
	}

	public String getIdNumber() {
		return this.idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public Date getInHospitalDate() {
		return this.inHospitalDate;
	}

	public void setInHospitalDate(Date inHospitalDate) {
		this.inHospitalDate = inHospitalDate;
	}

	public String getInHospitalDiagnosis() {
		return this.inHospitalDiagnosis;
	}

	public void setInHospitalDiagnosis(String inHospitalDiagnosis) {
		this.inHospitalDiagnosis = inHospitalDiagnosis;
	}

	public Date getOutHospitalDate() {
		return this.outHospitalDate;
	}

	public void setOutHospitalDate(Date outHospitalDate) {
		this.outHospitalDate = outHospitalDate;
	}

	public String getOutHospitalDiagnosis() {
		return this.outHospitalDiagnosis;
	}

	public void setOutHospitalDiagnosis(String outHospitalDiagnosis) {
		this.outHospitalDiagnosis = outHospitalDiagnosis;
	}

	public Date getQualityDate() {
		return this.qualityDate;
	}

	public void setQualityDate(Date qualityDate) {
		this.qualityDate = qualityDate;
	}



	public int getTheAge() {
		return this.theAge;
	}

	public void setTheAge(int theAge) {
		this.theAge = theAge;
	}

	public String getTheName() {
		return this.theName;
	}

	public void setTheName(String theName) {
		this.theName = theName;
	}

	public String getTheSex() {
		return this.theSex;
	}

	public void setTheSex(String theSex) {
		this.theSex = theSex;
	}

	public BigInteger gethNumber() {
		return hNumber;
	}

	public void sethNumber(BigInteger hNumber) {
		this.hNumber = hNumber;
	}

	public TQuality getQuality() {
		return quality;
	}

	public void setQuality(TQuality quality) {
		this.quality = quality;
	}

	public TDoctor getDoctor() {
		return doctor;
	}

	public void setDoctor(TDoctor doctor) {
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

	public void setSampleDiagnosis(int sampleDiagnosis) {
		this.sampleDiagnosis = sampleDiagnosis;
	}
}