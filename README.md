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
               增：/hos/quality/   参数：TQualily   METHOD : POST
               删：/hos/quality/{id}    参数：id    DELETE
               查： /hos/quality/    参数： Page<T> page index,totalpage totalcount  GET
               改：/host/quality/{id}   参数：TQualily   PUT
  
 - 4.2 床位医生增删查改
 
 - 4.3 病例增删查改 
 
 - 4.4 二维码生成
 
 