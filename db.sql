create database HgShopSys default character set utf8;

use HgShopSys;

set names gbk;

create table T_ADMIN(
	A_ID int primary key auto_increment comment '主键',
	A_ADMINNAME varchar(50) not null unique comment '管理员名',
	A_PASSWORD varchar(20) not null comment '密码',
	A_REALNAME varchar(50) not null comment '真实姓名',
	A_GENDER varchar(20) not null comment '性别',
    A_DESC varchar(200) not null comment '描述' 
);

create table T_USER( 
	U_ID int primary key auto_increment comment '主键', 
	U_USERNAME varchar(20) not null unique comment '用户名',
	U_PWD varchar(20) not null comment '密码',
	U_EMAIL varchar(50) unique not null comment '邮箱',
	U_MOBILE varchar(11) not null comment '手机' 
);
 
create table T_BRAND( 
	B_ID int primary key auto_increment comment '主键',
	B_CNNAME varchar(20) not null  comment '中文名',
	B_ENNAME varchar(20) not null comment '英文名',
	B_BIGPHOTO varchar(100)  not null comment '大照片',
	B_SMALLPHOTO varchar(100) not null comment '小照片',
	B_DESC varchar(500) comment '描述'
);

insert into T_BRAND(B_CNNAME,B_ENNAME,B_BIGPHOTO,B_SMALLPHOTO,B_DESC) 
values("地方","xdfcsd","1B6D.tmp.png","1BD5.tmp.png","sdasdasdsa");

CREATE TABLE T_PRODUCT (
  P_ID int(11) PRIMARY KEY NOT NULL auto_increment,
  P_NAME varchar(100) default NULL,
  P_MARKET_PRICE double default NULL,
  P_DISCOUTED_PRICE double default NULL,
  P_BRAND_ID int(11) default NULL,
  P_CATEGORY_ID int(11) default NULL,
  P_DESC mediumtext,
  P_REMARK varchar(100) default NULL,
  P_ADD_DATE datetime default NULL,
  P_COLOR varchar(20) default NULL,
  P_NUMBER varchar(32) default NULL,
  P_MAINIMAGE varchar(100) default NULL,
  P_RECOMMEND bit(1) default '\0' COMMENT '是否推荐',
  P_PROMOTION bit(1) default '\0' COMMENT '是否促销',
  P_ATTENTION int(11) default '0' COMMENT '浏览或者关注次数',
  P_BUY_COUNT bigint(20) default '0' COMMENT '购买次数',
  P_CLS varchar(100) default NULL COMMENT '当前产品的类别与它上面的所有父类别组成的id序列'
)  

CREATE TABLE t_product_image (
  PI_ID int(11)  NOT NULL auto_increment,
  PI_NAME varchar(50) default NULL,
  PI_URL varchar(100) default NULL,
  PI_PRODUCT_ID int(11) default NULL,
  PI_INDEX int(11) default '1',
  PRIMARY KEY  (PI_ID),
  KEY PI_PRODUCT_ID (PI_PRODUCT_ID),
  CONSTRAINT t_product_image_ibfk_1 FOREIGN KEY (PI_PRODUCT_ID) REFERENCES t_product (P_ID)
) 

DROP TABLE IF EXISTS t_category;
CREATE TABLE t_category (
  C_ID int(11) NOT NULL auto_increment,
  C_NAME varchar(20) default NULL,
  C_LEVEL int(11) default '1',
  C_DESC varchar(200) default NULL,
  C_PID int(11) default NULL,
  C_CLS varchar(100) default NULL,
  PRIMARY KEY  (C_ID)
)

INSERT INTO t_category VALUES ('1', '手机数码', '1', '手机数码', null, '');
INSERT INTO t_category VALUES ('2', '手机通讯', '2', '手机通讯', '1', '|1|');
INSERT INTO t_category VALUES ('3', '手机', '3', '手机', '2', '|2|,|1|');
INSERT INTO t_category VALUES ('4', '图书、电子书刊、音像', '1', '图书、电子书刊、音像', null, '');
INSERT INTO t_category VALUES ('5', '电子书刊 ', '2', '电子书刊 ', '4', '|4|');
INSERT INTO t_category VALUES ('6', '数字音乐', '2', '数字音乐', '4', '|4|');
INSERT INTO t_category VALUES ('7', '通俗流行', '3', '通俗流行', '6', '|6|,|4|');
INSERT INTO t_category VALUES ('8', '古典音乐', '3', '古典音乐', '6', '|6|,|4|');
INSERT INTO t_category VALUES ('9', '计算机', '2', '计算机', '4', '|4|');
INSERT INTO t_category VALUES ('10', '软件开发', '3', '软件开发', '9', '|9|,|4|');