##商家用户信息表
CREATE TABLE `app_xiaoye2016`.`vender_user` (
  `id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '主键' ,
  `code` VARCHAR(20) NULL COMMENT '编码' ,
  `account` VARCHAR(20) NOT NULL COMMENT '账号' ,
  `password` VARCHAR(40) NOT NULL COMMENT '密码' ,
  `nikeName` VARCHAR(40) NOT NULL COMMENT '昵称' ,
  `phone` VARCHAR(20) NULL COMMENT '电话' ,
  `email` VARCHAR(20) NULL COMMENT '邮箱' ,
  `gender` TINYINT(1) NOT NULL COMMENT '性别 1-男 2-女 3-其他' ,
  `carCode` VARCHAR(20) NOT NULL COMMENT '车牌号' ,
  `type` TINYINT(1) NOT NULL COMMENT '类型 1-商家 2-客户' ,
  `staus` TINYINT(1) NOT NULL COMMENT '状态 1-正常 -1-删除' ,
  `created` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间' ,
  `modified` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间' ,
  PRIMARY KEY (`id`) COMMENT '主键' ,
  INDEX `idx_account` (`account`) COMMENT '账号'
) ENGINE = InnoDB COMMENT = '商家用户信息表';