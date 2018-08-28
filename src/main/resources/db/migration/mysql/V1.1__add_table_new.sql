/*==============================================================*/
/* Database name:  hospital                                      */
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/8/25 17:32:42                           */
/*==============================================================*/
 

/*==============================================================*/
/* Database: hospital                                            */
/*==============================================================*/

/*==============================================================*/
/* Table: quality                                               */
/*==============================================================*/
create table t_quality
(
   id                   varchar(32) not null,
   the_name                 varchar(255) default NULL,
   the_age                  int(11) default NULL,
   the_sex                  int(11) default NULL,
   the_desc             varchar(255) default NULL,
   f1                   varchar(255),
   f2                   varchar(255),
   f3                   varchar(255),
   f4                   varchar(255),
   f5                   varchar(255),
   primary key (id)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*==============================================================*/
/* Table: doctor                                                */
/*==============================================================*/
create table t_doctor
(
   id                   varchar(32) not null,
   the_name             varchar(255) default NULL,
   the_age              int(11) default NULL,
   the_sex              int(11) default NULL,
   the_desc             varchar(255) default NULL,
   department           varchar(255) default NULL,
   f1                   varchar(255),
   f2                   varchar(255),
   f3                   varchar(255),
   f4                   varchar(255),
   f5                   varchar(255),
   primary key (id)
)
ENGINE=InnoDB DEFAULT CHARSET=utf8;


 

 

/*==============================================================*/
/* Table: patient                                               */
/*==============================================================*/
create table t_patient
(  id  					varchar(32) not NULL,
   h_number             bigint(20) not null ,
   bed_number          	varchar(32) default NULL,
   endemic_area			int(11) default NULL,
   id_number			varchar(255) default NULL,
   guardian  			varchar(255) default NULL,
   the_name                 varchar(255) default NULL,
   the_sex                  varchar(255) default NULL,
   the_age                  int(11) default NULL,
   doctor_id            varchar(255) default NULL,
   in_hospital_date     datetime default NULL,
   out_hospital_date    datetime default NULL,
   in_hospital_diagnosis varchar(255) default NULL,
   out_hospital_diagnosis varchar(255) default NULL,
   archive_date          datetime default NULL,
   quality_id           varchar(255) default NULL,
   quality_date          datetime default NULL,
   sample_diagnosis      int(11) default NULL,
   expect_archive        int(11) default NULL,
   f1                   varchar(255),
   f2                   varchar(255),
   f3                   varchar(255),
   f4                   varchar(255),
   f5                   varchar(255),
   primary key (id),
   key FKmer5utvy1hiff7ovs6f4bjtnw (doctor_id),
   key FK8evv7d2fthpa3n3nho22aluvp (quality_id)
)
ENGINE=InnoDB AUTO_INCREMENT=5504 DEFAULT CHARSET=utf8;

alter table t_patient add constraint FK8evv7d2fthpa3n3nho22aluvp foreign key (quality_id)
      references t_quality (id);

alter table t_patient add constraint FKmer5utvy1hiff7ovs6f4bjtnw foreign key (doctor_id)
      references t_doctor (id);

