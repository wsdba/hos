 

-- ----------------------------
-- Records of t_doctor
-- ----------------------------
INSERT INTO `t_doctor` VALUES ('1', '杨过', '27', '1', '外科医生', '外科', null, null, null, null, null);
INSERT INTO `t_doctor` VALUES ('2', '小龙女', '25', '0', '内科医生', null, null, null, null, null, null);
INSERT INTO `t_doctor` VALUES ('3', '张三丰', '65', '1', '眼科医生', null, null, null, null, null, null);
INSERT INTO `t_doctor` VALUES ('4', '周芷若', '56', '0', '外科医生', null, null, null, null, null, null);
INSERT INTO `t_doctor` VALUES ('5', '张无忌', '46', '1', '脑科医生', null, null, null, null, null, null);
 
 
-- ----------------------------
-- Records of t_quality
-- ----------------------------
INSERT INTO `t_quality` VALUES ('40284a816574772101657484c2f10001', '刘备', '12', '0', '外科医生', null, null, null, null, null);
INSERT INTO `t_quality` VALUES ('40284a816574e157016574e1ba060000', '金庸', '12', '0', '外科', null, null, null, null, null);
INSERT INTO `t_quality` VALUES ('40284a816574e157016574e200ba0001', '关羽', '12', '0', '外科', null, null, null, null, null);
INSERT INTO `t_quality` VALUES ('40284a816574e157016574e229d50002', '曹操', '12', '0', '外科', null, null, null, null, null);
INSERT INTO `t_quality` VALUES ('40284a816574e157016574e267d00003', '典韦', '12', '0', '外科', null, null, null, null, null);
INSERT INTO `t_quality` VALUES ('40284a8165750d2a0165751161720000', '赵子龙', '12', '0', '外科', null, null, null, null, null);
INSERT INTO `t_quality` VALUES ('40284a8165750d2a01657511c7e80001', '孙权', '12', '0', '外科', null, null, null, null, null);
INSERT INTO `t_quality` VALUES ('40284a8165750d2a01657511ed940002', '周瑜', '12', '0', '外科', null, null, null, null, null);
INSERT INTO `t_quality` VALUES ('40284a8165750d2a0165751254cc0003', '诸葛亮', '12', '0', '外科', null, null, null, null, null);
INSERT INTO `t_quality` VALUES ('40284a8165750d2a01657512ab490004', '诸葛瑾 ', '12', '0', '外科', null, null, null, null, null);
INSERT INTO `t_quality` VALUES ('40284a8165750d2a0165751306fa0005', '关飞', '12', '0', '外科', null, null, null, null, null);
INSERT INTO `t_quality` VALUES ('40284a8165750d2a0165751349330006', '李四', '12', '0', '外科', null, null, null, null, null);
INSERT INTO `t_quality` VALUES ('40284a8165753c8e0165753d18390000', '大乔', '12', '0', '内科', null, null, null, null, null);
INSERT INTO `t_quality` VALUES ('40284a81657562390165756521d20001', '飞狐', '23', '0', '内科', null, null, null, null, null);
INSERT INTO `t_quality` VALUES ('40284a81657562390165756665ba0002', '小乔', '43', '1', '这是一名好质控人员', null, null, null, null, null);
 
-- ----------------------------
-- Records of t_patient
-- ----------------------------
INSERT INTO `t_patient` VALUES ('1', '80001', '01', '1', '4310041987050466472', '萧炎', '萧薰儿', '0', '23', '1', '2018-08-14 23:30:35', '2018-08-28 23:30:38', '头痛', '头痛', '2018-08-27 23:30:59', '40284a816574772101657484c2f10001', '2018-08-27 23:31:08', '1', '0', null, null, null, null, null);
INSERT INTO `t_patient` VALUES ('40284a81657fea0d01657fea4a960000', '80002', '02', '1', '4210051997090623452', '梅超风', '林动', '1', '23', '1', '2018-08-29 01:39:48', '2018-08-29 01:39:48', '头痛', '头痛', '2018-08-29 01:39:48', '40284a816574e157016574e229d50002', '2018-08-29 01:39:48', '1', '1', null, null, null, null, null);
INSERT INTO `t_patient` VALUES ('40284a81657fea0d01657fec29cd0001', '80003', '03', '2', '3001198709052345222', '穆念慈', '杨康', '0', '23', '3', '2018-08-28 20:43:46', '2018-08-28 17:43:46', '头痛', '头痛', '2018-08-28 17:43:46', '40284a8165750d2a0165751161720000', '2018-08-28 17:43:46', '1', '1', null, null, null, null, null);
INSERT INTO `t_patient` VALUES ('40284a81657fea0d01657ff2edbc0002', '80004', '04', '1', '424004187605042345', '李爽', '谢文东', '1', '32', '3', '2018-08-28 17:50:35', '2018-08-28 17:50:35', '头痛', '头痛', '2018-08-28 17:50:35', '40284a8165750d2a0165751161720000', '2018-08-28 17:50:35', '1', '1', null, null, null, null, null);
INSERT INTO `t_patient` VALUES ('40284a8165800c78016580269ac40000', '80005', '02', '1', '431006194209053456', '佟湘玉', '郭芙蓉', '0', '23', '3', '2018-08-28 18:46:44', '2018-08-28 18:46:44', '头痛', '头痛', '2018-08-28 18:46:44', '40284a816574e157016574e267d00003', '2018-08-28 18:46:44', '1', '1', null, null, null, null, null);
INSERT INTO `t_patient` VALUES ('40284a8165800c780165802cf0590001', '80006', '11', '2', '410002934829323', '刘宇', '李傲天', '1', '43', '4', '2018-08-28 18:53:19', '2018-08-28 18:53:19', '头痛', '头痛', '2018-08-28 18:53:19', '40284a816574e157016574e267d00003', '2018-08-28 18:53:19', '1', '1', null, null, null, null, null);
INSERT INTO `t_patient` VALUES ('40284a81658072b601658074bf530000', '80007', '06', '3', '42100456190323', '大玉儿', '弘历', '0', '23', '3', '2018-08-28 20:13:02', '2018-08-28 20:13:02', '头痛', '头痛', '2018-08-28 21:13:02', '40284a816574e157016574e267d00003', '2018-08-28 20:13:02', '1', '1', null, null, null, null, null);


 