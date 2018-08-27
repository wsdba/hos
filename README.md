# 1. 数据库名 hospital
  1.1 数据库表设计 ，必须有id这一列，代表主键
  1.2 实体属性为驼峰XxLx，表列名为xx_lx
  1.3 通用列名前 加the_列名
  1.4 列名加注释
# 2. 实体
病区表对应多个病区（暂时不做）1

# 3. 页面要求
  住院号：页面正则，（唯一，后台判断）
 床位号： 页面正则
 

# 4.API
 - 4.1 质控人员管理
 - web 
               增：/hos/quality/                     参数：TQuality                     METHOD : POST       
               删：/hos/quality/{id}                 参数：id                           METHOD : DELETE
               删：/hos/quality/removeMulti          参数：ids                          METHOD : DELETE
               查： /hos/quality/                    参数：PageQueryDto<TQuality>       METHOD :  GET
               改：/host/quality/{id}                参数：TQuality                     METHOD :  PUT
         
         
        -  App 特殊方法
                查： /hos/quality/findAll       参数：theName                                             METHOD :  GET
                查：/hos/quality/pageByApp      参数：PageQueryDto<TQuality> page, String theName         METHOD :  GET
                
 - 4.2 床位医生增删查改
  - web 
               增：/hos/doctor                          参数：TDoctor        	             METHOD : POST       
               删：/hos/doctor/{id}                 参数：id                           METHOD : DELETE
               删：/hos/doctor/removeMulti          参数：ids                          METHOD : DELETE
               查： /hos/doctor/                    参数：PageQueryDto<TDoctor>       METHOD :  GET
               改：/host/doctor/{id}                参数：TDoctor                     METHOD :  PUT
 - 4.3 病例增删查改 
 - web 
               增：/hos/patient/                     参数：TPatient        	             METHOD : POST       
               删：/hos/patient/{id}                 参数：id                           METHOD : DELETE
               删：/hos/patient/removeMulti          参数：ids                          METHOD : DELETE
               查： /hos/patient/                    参数：PageQueryDto<TPatient>       METHOD :  GET
               改：/host/patient/{id}                参数：TPatient                     METHOD :  PUT
 - 4.4 二维码生成
 
 