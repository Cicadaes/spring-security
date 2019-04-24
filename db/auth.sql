/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : localhost:3306
 Source Schema         : auth

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : 65001

 Date: 24/04/2019 16:25:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_app_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_app_user`;
CREATE TABLE `sys_app_user` (
  `USER_ID` varchar(100) NOT NULL,
  `USERNAME` varchar(255) DEFAULT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  `RIGHTS` varchar(255) DEFAULT NULL,
  `ROLE_ID` varchar(100) DEFAULT NULL,
  `LAST_LOGIN` varchar(255) DEFAULT NULL,
  `IP` varchar(100) DEFAULT NULL,
  `STATUS` varchar(32) DEFAULT NULL,
  `BZ` varchar(255) DEFAULT NULL,
  `PHONE` varchar(100) DEFAULT NULL,
  `SFID` varchar(100) DEFAULT NULL,
  `START_TIME` varchar(100) DEFAULT NULL,
  `END_TIME` varchar(100) DEFAULT NULL,
  `YEARS` int(10) DEFAULT NULL,
  `NUMBER` varchar(100) DEFAULT NULL,
  `EMAIL` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`USER_ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_app_user
-- ----------------------------
BEGIN;
INSERT INTO `sys_app_user` VALUES ('1e89e6504be349a68c025976b3ecc1d1', 'a1', '698d51a19d8a121ce581499d7b701668', '会员甲', '', '115b386ff04f4352b060dffcd2b5d1da', '', '', '1', '121', '1212', '1212', '2015-12-02', '2015-12-25', 2, '111', '313596790@qq.com');
COMMIT;

-- ----------------------------
-- Table structure for sys_blacklist
-- ----------------------------
DROP TABLE IF EXISTS `sys_blacklist`;
CREATE TABLE `sys_blacklist` (
  `BLACKLIST_ID` varchar(100) NOT NULL,
  `IP` varchar(20) DEFAULT NULL COMMENT 'IP',
  `BZ` varchar(255) DEFAULT NULL COMMENT '备注',
  `CTIME` varchar(32) DEFAULT NULL COMMENT '时间',
  PRIMARY KEY (`BLACKLIST_ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_codeeditor
-- ----------------------------
DROP TABLE IF EXISTS `sys_codeeditor`;
CREATE TABLE `sys_codeeditor` (
  `CODEEDITOR_ID` varchar(100) NOT NULL,
  `TYPE` varchar(30) DEFAULT NULL COMMENT '类型',
  `FTLNMAME` varchar(30) DEFAULT NULL COMMENT '文件名',
  `CTIME` varchar(32) DEFAULT NULL COMMENT '创建时间',
  `CODECONTENT` text COMMENT '代码',
  PRIMARY KEY (`CODEEDITOR_ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_codeeditor
-- ----------------------------
BEGIN;
INSERT INTO `sys_codeeditor` VALUES ('18c459804cb8467db7b49d141f94b833', 'createHtml', 'indexTemplate', '2017-07-03 02:09:34', '<!DOCTYPE html>\n<!--[if lt IE 7 ]><html class=\"ie ie6\" lang=\"en\"> <![endif]-->\n<!--[if IE 7 ]><html class=\"ie ie7\" lang=\"en\"> <![endif]-->\n<!--[if IE 8 ]><html class=\"ie ie8\" lang=\"en\"> <![endif]-->\n<!--[if (gte IE 9)|!(IE)]><!-->\n<html lang=\"en\">\n<!--<![endif]-->\n<head>\n<meta charset=\"utf-8\">\n<title>${TITLE}</title>\n<meta name=\"keywords\" content=\"${KEYWORDS}\" />\n<meta name=\"description\" content=\"${DESCRIPTION}\">\n<meta name=\"author\" content=\"fhadmin\">\n<meta name=\"viewport\"\n	content=\"width=device-width, initial-scale=1, maximum-scale=1\">\n<!-- CSS -->\n<link rel=\"stylesheet\" href=\"fh_static_1/css/style.css\">\n<link rel=\"stylesheet\" type=\"text/css\"\n	href=\"fh_static_1/css/settings.css\" media=\"screen\" />\n<!-- JS -->\n<script src=\"fh_static_1/js/jquery-1.8.2.min.js\" type=\"text/javascript\"></script>\n<!-- jQuery -->\n<script src=\"fh_static_1/js/jquery.easing.1.3.js\" type=\"text/javascript\"></script>\n<!-- jQuery easing -->\n<script src=\"fh_static_1/js/modernizr.custom.js\" type=\"text/javascript\"></script>\n<!-- Modernizr -->\n<script src=\"fh_static_1/js/jquery-ui-1.10.1.custom.min.js\"\n	type=\"text/javascript\"></script>\n<!-- tabs, toggles, accordion -->\n<script src=\"fh_static_1/js/custom.js\" type=\"text/javascript\"></script>\n<!-- jQuery initialization -->\n<!-- Responsive Menu -->\n<script src=\"fh_static_1/js/jquery.meanmenu.js\"></script>\n<script>\n	jQuery(document).ready(function() {\n		jQuery(\'header nav\').meanmenu();\n	});\n</script>\n<!-- Revolution Slider -->\n<script src=\"fh_static_1/js/jquery.themepunch.plugins.min.js\"></script>\n<script src=\"fh_static_1/js/jquery.themepunch.revolution.min.js\"></script>\n<script src=\"fh_static_1/js/revolution-slider-options.js\"></script>\n<!-- Prety photo -->\n<script src=\"fh_static_1/js/jquery.prettyPhoto.js\"></script>\n<script>\n	$(document).ready(function() {\n		$(\"a[data-gal^=\'prettyPhoto\']\").prettyPhoto();\n	});\n</script>\n<!-- Tooltip -->\n<script src=\"fh_static_1/js/tooltip.js\"></script>\n<!-- Flexisel -->\n<script type=\"text/javascript\" src=\"fh_static_1/js/jquery.flexisel.js\"></script>\n<!-- Favicons  -->\n<link rel=\"shortcut icon\" href=\"fh_static_1/images/favicon.ico\">\n<link rel=\"apple-touch-icon\" href=\"fh_static_1/images/apple-touch-icon.png\">\n<link rel=\"apple-touch-icon\" sizes=\"72x72\" href=\"fh_static_1/images/apple-touch-icon-72x72.png\">\n<link rel=\"apple-touch-icon\" sizes=\"114x114\" href=\"fh_static_1/images/apple-touch-icon-114x114.png\">\n</head>\n<body>\n\n	<!-- header 包含导航菜单 -->\n	<#include \"headerTemplate.ftl\"> \n	<!-- header 包含导航菜单 -->\n\n	<!-- REVOLUTION SLIDER -->\n	<div class=\"fullwidthbanner-container top-shadow\">\n		<div class=\"fullwidthbanner\">\n			<ul>\n				<#list fieldList1 as var>\n					<li data-transition=\"boxfade\" data-slotamount=\"${var_index+1+1}\" data-masterspeed=\"300\">\n						<img src=\"${var[1]}\" alt=\"${var[0]}\">\n					</li>\n				</#list>\n			</ul>\n		</div>\n	</div>\n	<!-- END REVOLUTION SLIDER  -->\n	<div class=\"copyrights\">\n	</div>\n	<div class=\"container\">\n\n		<div class=\"sixteen columns welcome\">\n			<h3>\n				${TITLE1}\n				<br />\n				${TITLE2}\n			</h3>\n		</div>\n\n		<div class=\"separator\"></div>\n\n		<div class=\"four columns\">\n			<!-- Icon Box -->\n			<div class=\"service\">\n				<a href=\"${CPTOURL1}\">\n					<i class=\"fa fa-desktop colored square\"></i>\n				</a>\n				<h3 class=\"centered\">\n					<a href=\"${CPTOURL1}\" class=\"dark-link\">${CPTITLE1}</a>\n				</h3>\n				<p class=\"centered\">${CPCONTENT1}</p>\n			</div>\n			<!-- End Icon Box -->\n		</div>\n		<div class=\"four columns\">\n			<!-- Icon Box -->\n			<div class=\"service\">\n				<a href=\"${CPTOURL2}\">\n					<i class=\"fa fa-html5 colored square\"></i>\n				</a>\n				<h3 class=\"centered\">\n					<a href=\"${CPTOURL2}\" class=\"dark-link\">${CPTITLE2}</a>\n				</h3>\n				<p class=\"centered\">${CPCONTENT2}</p>\n			</div>\n			<!-- End Icon Box -->\n		</div>\n		<div class=\"four columns\">\n			<!-- Icon Box -->\n			<div class=\"service\">\n				<a href=\"${CPTOURL3}\">\n					<i class=\"fa fa-css3 colored square\"></i>\n				</a>\n				<h3 class=\"centered\">\n					<a href=\"${CPTOURL3}\" class=\"dark-link\">${CPTITLE3}</a>\n				</h3>\n				<p class=\"centered\">${CPCONTENT3}</p>\n			</div>\n			<!-- End Icon Box -->\n		</div>\n		<div class=\"four columns\">\n			<!-- Icon Box -->\n			<div class=\"service\">\n				<a href=\"${CPTOURL4}\">\n					<i class=\"fa fa-magic colored square\"></i>\n				</a>\n				<h3 class=\"centered\">\n					<a href=\"${CPTOURL4}\" class=\"dark-link\">${CPTITLE4}</a>\n				</h3>\n				<p class=\"centered\">${CPCONTENT4}</p>\n			</div>\n			<!-- End Icon Box -->\n		</div>\n\n		<div class=\"clearfix\"></div>\n\n		<div class=\"separator\"></div>\n\n		<div class=\"sixteen columns\">\n			<h4 class=\"headline\">项目案例 ></h4>\n		</div>\n\n		<#list fieldList2 as var>\n		<div class=\"four columns identity\">\n			<div class=\"work\">\n				<a href=\"${var[1]}\" data-gal=\"prettyPhoto\" class=\"work-image\">\n					<img src=\"${var[1]}\" alt=\"${var[0]}\">\n					<div class=\"link-overlay fa fa-search\"></div>\n				</a>\n				<a href=\"${var[2]}\" class=\"work-name\">${var[0]}</a>\n				<div class=\"tags\">${var[3]}</div>\n			</div>\n		</div>\n		</#list>\n\n		<div class=\"clearfix\"></div>\n\n		<!-- begin promobox -->\n		<div class=\"sixteen columns\">\n			<div class=\"promo-box clearfix\">\n				<div class=\"text\">\n					<h3>${CONTENT1}</h3>\n					<p>${CONTENT2}</p>\n				</div>\n				<a class=\"btn big colored\" href=\"${TOURL}\" target=\"_blank\">\n					<i class=\"fa fa-hand-o-right\"></i>了解更多</a>\n			</div>\n		</div>\n		<!-- end promobox -->\n\n		<div class=\"separator\"></div>\n\n		<!-- Our Clients  -->\n		<div class=\"sixteen columns clients\">\n			<h4 class=\"headline\">合作伙伴 ></h4>\n\n			<!-- Start brand carousel -->\n			<ul id=\"flexiselDemo2\">\n			<#list fieldList3 as var>\n				<li onclick=\"window.location.href=\'${var[2]}\'\"><img src=\"${var[1]}\" alt=\"${var[0]}\" /></li>\n			</#list>	\n			</ul>\n			<div class=\"clearout\"></div>\n			<!-- End brand carousel -->\n		</div>\n\n	</div>\n	<!-- container -->\n	\n	<!-- footer 包含底部 -->\n	<#include \"footerTemplate.ftl\"> \n	<!-- footer 包含底部  -->\n\n	<script type=\"text/javascript\">\n		$(window).load(function() {\n		\n			$(\"#index\").addClass(\"current_page_item\");\n		\n			$(\"#flexiselDemo2\").flexisel({\n				visibleItems : 5,\n				animationSpeed : 1000,\n				autoPlay : true,\n				autoPlaySpeed : 3000,\n				pauseOnHover : true,\n				enableResponsiveBreakpoints : true,\n				responsiveBreakpoints : {\n					portrait : {\n						changePoint : 480,\n						visibleItems : 1\n					},\n					landscape : {\n						changePoint : 640,\n						visibleItems : 2\n					},\n					tablet : {\n						changePoint : 768,\n						visibleItems : 3\n					}\n				}\n			});\n\n		});\n	</script>\n	<!-- End Document  -->\n</body>\n</html>\n');
COMMIT;

-- ----------------------------
-- Table structure for sys_createcode
-- ----------------------------
DROP TABLE IF EXISTS `sys_createcode`;
CREATE TABLE `sys_createcode` (
  `CREATECODE_ID` varchar(100) NOT NULL,
  `PACKAGENAME` varchar(50) DEFAULT NULL COMMENT '包名',
  `OBJECTNAME` varchar(50) DEFAULT NULL COMMENT '类名',
  `TABLENAME` varchar(50) DEFAULT NULL COMMENT '表名',
  `FIELDLIST` varchar(5000) DEFAULT NULL COMMENT '属性集',
  `CREATETIME` varchar(100) DEFAULT NULL COMMENT '创建时间',
  `TITLE` varchar(255) DEFAULT NULL COMMENT '描述',
  `FHTYPE` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`CREATECODE_ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_dictionaries
-- ----------------------------
DROP TABLE IF EXISTS `sys_dictionaries`;
CREATE TABLE `sys_dictionaries` (
  `DICTIONARIES_ID` varchar(100) NOT NULL,
  `NAME` varchar(30) DEFAULT NULL COMMENT '名称',
  `NAME_EN` varchar(50) DEFAULT NULL COMMENT '英文',
  `BIANMA` varchar(50) DEFAULT NULL COMMENT '编码',
  `ORDER_BY` int(11) NOT NULL COMMENT '排序',
  `PARENT_ID` varchar(100) DEFAULT NULL COMMENT '上级ID',
  `BZ` varchar(255) DEFAULT NULL COMMENT '备注',
  `TBSNAME` varchar(100) DEFAULT NULL COMMENT '排查表',
  PRIMARY KEY (`DICTIONARIES_ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_dictionaries
-- ----------------------------
BEGIN;
INSERT INTO `sys_dictionaries` VALUES ('0193ffbfae1e49e0b7810546cada316a', '济南', 'JiNan', '0030301', 1, '10f46a521ea0471f8d71ee75ac3b5f3a', '济南', '');
INSERT INTO `sys_dictionaries` VALUES ('096e4ec8986149d994b09e604504e38d', '黄浦区', 'huangpu', '0030201', 1, 'f1ea30ddef1340609c35c88fb2919bee', '黄埔', '');
INSERT INTO `sys_dictionaries` VALUES ('10f46a521ea0471f8d71ee75ac3b5f3a', '山东', 'ShanDong', '00303', 3, 'be4a8c5182c744d28282a5345783a77f', '山东省', '');
INSERT INTO `sys_dictionaries` VALUES ('12a62a3e5bed44bba0412b7e6b733c93', '北京', 'beijing', '00301', 1, 'be4a8c5182c744d28282a5345783a77f', '北京', '');
INSERT INTO `sys_dictionaries` VALUES ('507fa87a49104c7c8cdb52fdb297da12', '宣武区', 'xuanwuqu', '0030101', 1, '12a62a3e5bed44bba0412b7e6b733c93', '宣武区', '');
INSERT INTO `sys_dictionaries` VALUES ('66f1ff79b13947da98525aff7380ef50', '高新区', 'gaoxinqu', '003030101', 1, '0193ffbfae1e49e0b7810546cada316a', '高新区', '');
INSERT INTO `sys_dictionaries` VALUES ('8994f5995f474e2dba6cfbcdfe5ea07a', '语文', 'yuwen', '00201', 1, 'fce20eb06d7b4b4d8f200eda623f725c', '语文', '');
INSERT INTO `sys_dictionaries` VALUES ('8ea7c44af25f48b993a14f791c8d689f', '分类', 'fenlei', '001', 1, '0', '分类', '');
INSERT INTO `sys_dictionaries` VALUES ('be4a8c5182c744d28282a5345783a77f', '地区', 'diqu', '003', 3, '0', '地区', '');
INSERT INTO `sys_dictionaries` VALUES ('d428594b0494476aa7338d9061e23ae3', '红色', 'red', '00101', 1, '8ea7c44af25f48b993a14f791c8d689f', '红色', '');
INSERT INTO `sys_dictionaries` VALUES ('de9afadfbed0428fa343704d6acce2c4', '绿色', 'green', '00102', 2, '8ea7c44af25f48b993a14f791c8d689f', '绿色', '');
INSERT INTO `sys_dictionaries` VALUES ('f1ea30ddef1340609c35c88fb2919bee', '上海', 'shanghai', '00302', 2, 'be4a8c5182c744d28282a5345783a77f', '上海', '');
INSERT INTO `sys_dictionaries` VALUES ('fce20eb06d7b4b4d8f200eda623f725c', '课程', 'kecheng', '002', 2, '0', '课程', '');
COMMIT;

-- ----------------------------
-- Table structure for sys_fhbutton
-- ----------------------------
DROP TABLE IF EXISTS `sys_fhbutton`;
CREATE TABLE `sys_fhbutton` (
  `FHBUTTON_ID` varchar(100) NOT NULL,
  `NAME` varchar(30) DEFAULT NULL COMMENT '名称',
  `QX_NAME` varchar(50) DEFAULT NULL COMMENT '权限标识',
  `BZ` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`FHBUTTON_ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_fhbutton
-- ----------------------------
BEGIN;
INSERT INTO `sys_fhbutton` VALUES ('3542adfbda73410c976e185ffe50ad06', '导出EXCEL', 'toExcel', '导出EXCEL');
INSERT INTO `sys_fhbutton` VALUES ('46992ea280ba4b72b29dedb0d4bc0106', '发邮件', 'email', '发送电子邮件');
INSERT INTO `sys_fhbutton` VALUES ('4efa162fce8340f0bd2dcd3b11d327ec', '导入EXCEL', 'FromExcel', '导入EXCEL到系统用户');
INSERT INTO `sys_fhbutton` VALUES ('cc51b694d5344d28a9aa13c84b7166cd', '发短信', 'sms', '发送短信');
COMMIT;

-- ----------------------------
-- Table structure for sys_fhlog
-- ----------------------------
DROP TABLE IF EXISTS `sys_fhlog`;
CREATE TABLE `sys_fhlog` (
  `FHLOG_ID` varchar(100) NOT NULL,
  `USERNAME` varchar(100) DEFAULT NULL COMMENT '用户名',
  `CZTIME` varchar(32) DEFAULT NULL COMMENT '操作时间',
  `CONTENT` varchar(255) DEFAULT NULL COMMENT '事件',
  PRIMARY KEY (`FHLOG_ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_fhlog
-- ----------------------------
BEGIN;
INSERT INTO `sys_fhlog` VALUES ('001670356c6d4fdca703dad3b10390a9', 'admin', '2018-06-28 11:42:13', '修改角色菜单权限，角色ID为:1');
INSERT INTO `sys_fhlog` VALUES ('06442e3c55084b25beeebd974d59b1ed', 'admin', '2019-01-04 03:32:50', '新增菜单模版七');
INSERT INTO `sys_fhlog` VALUES ('07f46591bf8e4198a3ee3a86042fe766', 'admin', '2018-10-20 13:31:47', '登录系统');
INSERT INTO `sys_fhlog` VALUES ('093a1a54c6834fcfa614d3905da2209c', 'admin', '2018-10-10 00:26:32', '登录系统');
INSERT INTO `sys_fhlog` VALUES ('0b55c48626f746c780127d1d491794c4', 'admin', '2018-06-22 19:31:58', '登录系统');
INSERT INTO `sys_fhlog` VALUES ('0d3b133233c84120a949a1f30ab1fadc', 'admin', '2018-06-23 17:52:03', '登录系统');
INSERT INTO `sys_fhlog` VALUES ('0ece0f7a709145e9a88047d8173fb28a', 'admin', '2018-10-20 12:22:07', '登录系统');
INSERT INTO `sys_fhlog` VALUES ('12cb9d79753441ad8a13173c2be0698f', 'admin', '2018-12-13 10:46:45', '登录系统');
INSERT INTO `sys_fhlog` VALUES ('12fce927500f46c1bf904895bdffbd35', 'admin', '2018-12-29 02:05:07', '登录系统');
INSERT INTO `sys_fhlog` VALUES ('18d4d84db59640288d1c720711f625e7', 'admin', '2018-06-28 11:39:26', '新增菜单合作共赢');
INSERT INTO `sys_fhlog` VALUES ('1e1e7544c836461991ed6cdcb266d518', 'admin', '2018-10-16 10:03:59', '登录系统');
INSERT INTO `sys_fhlog` VALUES ('228bc17f513b4f53b0bb5b6513258c4a', 'admin', '2019-01-02 18:14:17', '登录系统');
INSERT INTO `sys_fhlog` VALUES ('23a2f6d05b894b7298c1826e414520ef', 'admin', '2018-10-13 11:28:11', '登录系统');
INSERT INTO `sys_fhlog` VALUES ('243ba5ec3e36401ca8625d9356be105d', 'admin', '2019-01-04 03:34:50', '修改角色菜单权限，角色ID为:1');
INSERT INTO `sys_fhlog` VALUES ('2667b5b74ddd485fbb1639ae027d9bb4', 'admin', '2018-12-27 16:25:12', '登录系统');
INSERT INTO `sys_fhlog` VALUES ('28cf798e935e4f739ce79c2a4c0b012e', 'admin', '2019-01-04 03:33:24', '新增菜单模版八');
INSERT INTO `sys_fhlog` VALUES ('2e3b5f172c9143f58fc1a4ed3d3185a9', 'admin', '2018-06-28 11:41:28', '新增菜单页头');
INSERT INTO `sys_fhlog` VALUES ('2ec3b7f4cc114539b129583c2b731176', 'dfg4', '2019-04-19 11:14:37', '登录系统密码或用户名错误');
INSERT INTO `sys_fhlog` VALUES ('32f92fd451d74247b9ee341987fe3794', 'admin', '2018-06-28 11:38:58', '新增菜单产品案例');
INSERT INTO `sys_fhlog` VALUES ('35cb1823357b4b0898896d1db67a8d19', 'admin', '2018-10-20 14:09:49', '登录系统');
INSERT INTO `sys_fhlog` VALUES ('36ff26cb5daa4c3db42f6fe2464cfc0d', 'admin', '2019-01-04 03:35:07', '登录系统');
INSERT INTO `sys_fhlog` VALUES ('43cf340bba13485da56e7af8bcf96190', 'admin', '2018-10-16 14:14:19', '登录系统');
INSERT INTO `sys_fhlog` VALUES ('44a1a225b27c4e949b757706ac304b59', 'admin', '2018-06-28 11:40:27', '新增菜单新闻详情');
INSERT INTO `sys_fhlog` VALUES ('4fb63b8e44e343e59eb7ebdd6ef48400', 'admin', '2018-12-26 16:31:45', '登录系统');
INSERT INTO `sys_fhlog` VALUES ('5752f6caf8bf4532bf3f5b8c15f181c4', 'admin', '2019-01-04 01:42:59', '登录系统');
INSERT INTO `sys_fhlog` VALUES ('5974823da0e54136b56c2c86d9af75e0', 'admin', '2018-06-28 11:42:23', '登录系统');
INSERT INTO `sys_fhlog` VALUES ('5f1e37b23a7740e4aae6f6102366f822', 'admin', '2018-10-16 14:24:41', '登录系统');
INSERT INTO `sys_fhlog` VALUES ('634710ee9b7e4e6c86abf50aa7394a93', 'admin', '2018-06-28 11:37:48', '新增菜单首页');
INSERT INTO `sys_fhlog` VALUES ('6379f2d40c82443fb7c4453aea42792c', 'admin', '2018-10-16 12:04:19', '登录系统');
INSERT INTO `sys_fhlog` VALUES ('63caca282e354a9b8b4a31ecc077b447', 'admin', '2018-10-20 19:10:27', '登录系统');
INSERT INTO `sys_fhlog` VALUES ('669f4a0b946743898ce1308698884a7d', 'admin', '2018-10-10 02:11:10', '修改角色菜单权限，角色ID为:1');
INSERT INTO `sys_fhlog` VALUES ('6716015a1f4a41f2bce1f9d8d1e43e41', 'admin', '2018-06-23 01:24:29', '登录系统');
INSERT INTO `sys_fhlog` VALUES ('673685e3c19949378c87c2088b4c0a7c', 'admin', '2018-06-28 11:38:44', '修改菜单关于我们');
INSERT INTO `sys_fhlog` VALUES ('72a73f8ec7a24103b7c15c09b012e881', 'admin', '2018-10-16 14:35:19', '登录系统');
INSERT INTO `sys_fhlog` VALUES ('7714d7107a2a44fda9a24908c461eddb', 'admin', '2018-07-05 15:16:27', '登录系统');
INSERT INTO `sys_fhlog` VALUES ('7864958f06bb435f8821ee7f96eaf743', 'admin', '2018-10-10 02:10:28', '修改菜单模版六');
INSERT INTO `sys_fhlog` VALUES ('7a80dd4a6f07454b90bb44f0f4e36644', 'admin', '2019-01-04 03:29:59', '登录系统');
INSERT INTO `sys_fhlog` VALUES ('7ec51e00e383484391d6b0b40785a1cb', 'admin', '2018-10-10 02:10:05', '修改菜单模版六');
INSERT INTO `sys_fhlog` VALUES ('8889ada807594d25bed34018823cf6c6', 'admin', '2018-12-29 02:12:07', '登录系统');
INSERT INTO `sys_fhlog` VALUES ('8b53faaba4cc4e789680ad28f80eb97d', 'admin', '2018-10-09 15:58:38', '登录系统');
INSERT INTO `sys_fhlog` VALUES ('8bdc2356b7a24613879b41061be95169', 'admin', '2019-01-04 03:34:03', '新增菜单单页');
INSERT INTO `sys_fhlog` VALUES ('8f7d74ad139f42ae8db8a52e9e3f8418', 'admin', '2018-12-29 02:55:10', '登录系统');
INSERT INTO `sys_fhlog` VALUES ('91c6b199484d4c70920a376e9295816f', 'admin', '2018-10-09 01:40:54', '登录系统');
INSERT INTO `sys_fhlog` VALUES ('9427dd051dfa44688d01a1987b7b40e0', 'admin', '2018-10-09 01:02:34', '登录系统');
INSERT INTO `sys_fhlog` VALUES ('9462904a8a23421da249cba64c6e0760', 'admin', '2018-07-27 15:37:43', '登录系统');
INSERT INTO `sys_fhlog` VALUES ('99e3c9f2bac7410db4ddc359498cb8c1', 'admin', '2018-10-09 17:55:06', '登录系统');
INSERT INTO `sys_fhlog` VALUES ('9b4de1441b6a408884c5e046b46b8157', 'admin', '2019-01-02 16:11:06', '登录系统密码或用户名错误');
INSERT INTO `sys_fhlog` VALUES ('9dc8e268703040e9b2134aef41e7bd58', 'admin', '2018-06-28 11:40:56', '新增菜单联系我们');
INSERT INTO `sys_fhlog` VALUES ('9df176fddcdf48dfb3df75640cc4b478', 'admin', '2018-06-28 11:36:21', '登录系统');
INSERT INTO `sys_fhlog` VALUES ('a353460d3e3e470d9985cafd24b3b5e5', 'admin', '2018-03-09 14:58:20', '退出');
INSERT INTO `sys_fhlog` VALUES ('a509fc2d182a453dab647008e0fc2131', 'admin', '2018-12-29 03:12:36', '登录系统');
INSERT INTO `sys_fhlog` VALUES ('a75fcca6f20a489e9d0b3209bda83cfa', 'admin', '2018-06-22 23:02:04', '登录系统');
INSERT INTO `sys_fhlog` VALUES ('aa55f2b9354d4d2da25e2f1195c5c48a', 'admin', '2018-10-10 02:11:23', '登录系统');
INSERT INTO `sys_fhlog` VALUES ('ac08ca36e0724847a7bb48f916c1a7da', 'admin', '2019-01-02 16:43:16', '登录系统');
INSERT INTO `sys_fhlog` VALUES ('ae763e30515549b58a3bf8f390e4c52c', 'admin', '2018-06-22 17:09:48', '登录系统');
INSERT INTO `sys_fhlog` VALUES ('b064376b01b743d4bd08548ac93324ff', 'admin', '2018-12-13 02:37:34', '登录系统');
INSERT INTO `sys_fhlog` VALUES ('b39fcbdb6dc44e1e97c85682af3d02d9', 'admin', '2018-06-28 11:42:15', '退出');
INSERT INTO `sys_fhlog` VALUES ('b631d75d33114ecdb80205162f43d763', 'admin', '2018-10-10 02:10:45', '新增菜单单页');
INSERT INTO `sys_fhlog` VALUES ('b651c3d296fb43e18d78509ac8423a07', 'admin', '2019-01-04 00:45:35', '登录系统');
INSERT INTO `sys_fhlog` VALUES ('baf1d0119f5642c295ff103779bb744b', 'admin', '2018-06-28 11:38:21', '新增菜单关于我们');
INSERT INTO `sys_fhlog` VALUES ('be00fde6073648b8bfe2cdf312bd49ce', 'admin', '2019-01-02 16:11:20', '登录系统');
INSERT INTO `sys_fhlog` VALUES ('c0ed5cabc78c4d87b787226d72af7d9f', 'admin', '2018-12-13 02:13:11', '登录系统');
INSERT INTO `sys_fhlog` VALUES ('c878bd7870e242bfabc2d47bd5df0237', 'admin', '2019-04-19 11:15:16', '登录系统');
INSERT INTO `sys_fhlog` VALUES ('c941a224bdbb49029207d271e4c3ff3e', 'admin', '2018-10-13 11:20:22', '登录系统');
INSERT INTO `sys_fhlog` VALUES ('ca4d7ec828bf49e89b78a570f495f958', 'admin', '2018-10-10 02:09:16', '新增菜单模版六');
INSERT INTO `sys_fhlog` VALUES ('caad06e0c8d44dbc85c9d4a3c3ee5513', 'admin', '2018-06-22 17:39:03', '登录系统');
INSERT INTO `sys_fhlog` VALUES ('cea7c32685444feb93b7b371ba488d94', 'admin', '2018-10-16 14:53:26', '登录系统');
INSERT INTO `sys_fhlog` VALUES ('d05c606f3e5e405eb681f1151a811306', 'admin', '2019-01-02 02:16:01', '登录系统');
INSERT INTO `sys_fhlog` VALUES ('d616e53f10d240a6895b96d18d09fbea', 'admin', '2019-01-04 03:34:57', '退出');
INSERT INTO `sys_fhlog` VALUES ('d8b00f14fdf145799d79b3bdc52edc79', 'admin', '2018-06-28 11:41:57', '新增菜单页尾');
INSERT INTO `sys_fhlog` VALUES ('d982684838764b11a051047058eb4bc8', 'admin', '2018-12-27 16:29:35', '登录系统');
INSERT INTO `sys_fhlog` VALUES ('dab161e4268e4436b39b2834cda5fd06', 'admin', '2019-01-04 03:34:31', '新增菜单单页');
INSERT INTO `sys_fhlog` VALUES ('df11d2ddc41e42999f5d35bd7f768606', 'admin', '2018-07-27 15:44:30', '登录系统');
INSERT INTO `sys_fhlog` VALUES ('e026d38b510545e395ec0416587e6b55', 'admin', '2018-10-10 02:11:15', '退出');
INSERT INTO `sys_fhlog` VALUES ('e7860c269adb465d90e3ab0f411b23d5', 'admin', '2018-06-28 11:36:54', '修改菜单模版五');
INSERT INTO `sys_fhlog` VALUES ('ec053ed7811547c392f85b7b4a08865c', 'admin', '2018-12-18 23:52:33', '登录系统');
INSERT INTO `sys_fhlog` VALUES ('ec7af90f10e042789e7e1f9871b5f456', 'admin', '2018-06-22 22:53:28', '登录系统');
INSERT INTO `sys_fhlog` VALUES ('f11588762a0048b6add8f0eadef72600', 'admin', '2018-06-28 11:39:57', '新增菜单新闻动态');
INSERT INTO `sys_fhlog` VALUES ('f8ad1058f5d64ac4bece2835f1830a54', 'admin', '2018-06-28 11:36:48', '新增菜单模版五');
COMMIT;

-- ----------------------------
-- Table structure for sys_loginimg
-- ----------------------------
DROP TABLE IF EXISTS `sys_loginimg`;
CREATE TABLE `sys_loginimg` (
  `LOGINIMG_ID` varchar(100) NOT NULL,
  `NAME` varchar(30) DEFAULT NULL COMMENT '文件名',
  `FILEPATH` varchar(100) DEFAULT NULL COMMENT '路径',
  `TYPE` int(2) NOT NULL COMMENT '状态',
  `FORDER` int(3) NOT NULL COMMENT '排序',
  PRIMARY KEY (`LOGINIMG_ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `MENU_ID` int(11) NOT NULL,
  `MENU_NAME` varchar(255) DEFAULT NULL,
  `MENU_URL` varchar(255) DEFAULT NULL,
  `PARENT_ID` varchar(100) DEFAULT NULL,
  `MENU_ORDER` varchar(100) DEFAULT NULL,
  `MENU_ICON` varchar(60) DEFAULT NULL,
  `MENU_TYPE` varchar(10) DEFAULT NULL,
  `MENU_STATE` int(1) DEFAULT NULL,
  PRIMARY KEY (`MENU_ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
BEGIN;
INSERT INTO `sys_menu` VALUES (1, '系统管理', '#', '0', '1', 'menu-icon fa fa-desktop blue', '2', 1);
INSERT INTO `sys_menu` VALUES (2, '权限管理', '#', '1', '1', 'menu-icon fa fa-lock black', '1', 1);
INSERT INTO `sys_menu` VALUES (3, '日志管理', 'fhlog/list.do', '1', '6', 'menu-icon fa fa-book blue', '1', 1);
INSERT INTO `sys_menu` VALUES (6, '资源管理', '#', '0', '5', 'menu-icon fa fa-credit-card green', '2', 1);
INSERT INTO `sys_menu` VALUES (7, '图片管理', '#', '6', '1', 'menu-icon fa fa-folder-o pink', '2', 1);
INSERT INTO `sys_menu` VALUES (8, '性能监控', 'druid/index.html', '9', '8', 'menu-icon fa fa-tachometer red', '1', 1);
INSERT INTO `sys_menu` VALUES (9, '系统工具', '#', '0', '3', 'menu-icon fa fa-cog black', '2', 1);
INSERT INTO `sys_menu` VALUES (22, '一级菜单', '#', '0', '10', 'menu-icon fa fa-fire orange', '1', 1);
INSERT INTO `sys_menu` VALUES (23, '二级菜单', '#', '22', '1', 'menu-icon fa fa-leaf black', '1', 1);
INSERT INTO `sys_menu` VALUES (24, '三级菜单', '#', '23', '1', 'menu-icon fa fa-leaf black', '1', 1);
INSERT INTO `sys_menu` VALUES (30, '四级菜单', '#', '24', '1', 'menu-icon fa fa-leaf black', '1', 1);
INSERT INTO `sys_menu` VALUES (31, '五级菜单1', '#', '30', '1', 'menu-icon fa fa-leaf black', '1', 1);
INSERT INTO `sys_menu` VALUES (32, '五级菜单2', '#', '30', '2', 'menu-icon fa fa-leaf black', '1', 1);
INSERT INTO `sys_menu` VALUES (33, '六级菜单', '#', '31', '1', 'menu-icon fa fa-leaf black', '1', 1);
INSERT INTO `sys_menu` VALUES (34, '六级菜单2', 'login_default.do', '31', '2', 'menu-icon fa fa-leaf black', '1', 1);
INSERT INTO `sys_menu` VALUES (35, '四级菜单2', 'login_default.do', '24', '2', 'menu-icon fa fa-leaf black', '1', 1);
INSERT INTO `sys_menu` VALUES (36, '角色(基础权限)', 'role.do', '2', '1', 'menu-icon fa fa-key orange', '1', 1);
INSERT INTO `sys_menu` VALUES (37, '按钮权限', 'buttonrights/list.do', '2', '2', 'menu-icon fa fa-key green', '1', 1);
INSERT INTO `sys_menu` VALUES (38, '菜单管理', 'menu/listAllMenu.do', '1', '3', 'menu-icon fa fa-folder-open-o brown', '1', 1);
INSERT INTO `sys_menu` VALUES (39, '按钮管理', 'fhbutton/list.do', '1', '2', 'menu-icon fa fa-download orange', '1', 1);
INSERT INTO `sys_menu` VALUES (40, '用户管理', '#', '0', '2', 'menu-icon fa fa-users blue', '2', 1);
INSERT INTO `sys_menu` VALUES (41, '系统用户', 'user/listUsers.do', '40', '1', 'menu-icon fa fa-users green', '1', 1);
INSERT INTO `sys_menu` VALUES (42, '会员管理', 'happuser/listUsers.do', '40', '2', 'menu-icon fa fa-users orange', '1', 1);
INSERT INTO `sys_menu` VALUES (43, '数据字典', 'dictionaries/listAllDict.do?DICTIONARIES_ID=0', '1', '4', 'menu-icon fa fa-book purple', '1', 1);
INSERT INTO `sys_menu` VALUES (44, '代码生成器', '#', '9', '0', 'menu-icon fa fa-cogs brown', '1', 1);
INSERT INTO `sys_menu` VALUES (45, '七级菜单1', '#', '33', '1', 'menu-icon fa fa-leaf black', '1', 1);
INSERT INTO `sys_menu` VALUES (46, '七级菜单2', '#', '33', '2', 'menu-icon fa fa-leaf black', '1', 1);
INSERT INTO `sys_menu` VALUES (47, '八级菜单', 'login_default.do', '45', '1', 'menu-icon fa fa-leaf black', '1', 1);
INSERT INTO `sys_menu` VALUES (51, '图片列表', 'pictures/list.do', '7', '1', 'menu-icon fa fa-folder-open-o green', '1', 1);
INSERT INTO `sys_menu` VALUES (52, '图片爬虫', 'pictures/goImageCrawler.do', '7', '2', 'menu-icon fa fa-cloud-download green', '1', 1);
INSERT INTO `sys_menu` VALUES (53, '表单构建器', 'tool/goFormbuilder.do', '9', '1', 'menu-icon fa fa-leaf black', '1', 1);
INSERT INTO `sys_menu` VALUES (54, '数据库管理', '#', '0', '9', 'menu-icon fa fa-hdd-o blue', '2', 1);
INSERT INTO `sys_menu` VALUES (55, '数据库备份', 'brdb/listAllTable.do', '54', '1', 'menu-icon fa fa-cloud-upload blue', '1', 1);
INSERT INTO `sys_menu` VALUES (56, '数据库还原', 'brdb/list.do', '54', '3', 'menu-icon fa fa-cloud-download blue', '1', 1);
INSERT INTO `sys_menu` VALUES (57, '备份定时器', 'timingbackup/list.do', '54', '2', 'menu-icon fa fa-tachometer blue', '1', 1);
INSERT INTO `sys_menu` VALUES (58, 'SQL编辑器', 'sqledit/view.do', '54', '4', 'menu-icon fa fa-pencil-square-o blue', '1', 1);
INSERT INTO `sys_menu` VALUES (61, '反向生成', 'recreateCode/list.do', '44', '2', 'menu-icon fa fa-cogs blue', '1', 1);
INSERT INTO `sys_menu` VALUES (62, '正向生成', 'createCode/list.do', '44', '1', 'menu-icon fa fa-cogs green', '1', 1);
INSERT INTO `sys_menu` VALUES (67, '首页管理', '#', '0', '11', 'menu-icon fa fa-globe green', '2', 1);
INSERT INTO `sys_menu` VALUES (68, '网站信息', 'information/list.do', '67', '1', 'menu-icon fa fa-book blue', '1', 1);
INSERT INTO `sys_menu` VALUES (69, '轮播图片', 'image/list.do?TYPE=1', '67', '2', 'menu-icon fa fa-camera-retro green', '1', 1);
INSERT INTO `sys_menu` VALUES (70, '项目案例', 'image/list.do?TYPE=2', '67', '3', 'menu-icon fa fa-camera-retro blue', '1', 1);
INSERT INTO `sys_menu` VALUES (71, '合作伙伴', 'image/list.do?TYPE=3', '67', '4', 'menu-icon fa fa-camera-retro purple', '1', 1);
INSERT INTO `sys_menu` VALUES (72, '技术团队', 'image/list.do?TYPE=4', '67', '5', 'menu-icon fa fa-camera-retro orange', '1', 1);
INSERT INTO `sys_menu` VALUES (73, '业务说明', 'ourbusiness/list.do', '67', '1', 'menu-icon fa fa-book green', '1', 1);
INSERT INTO `sys_menu` VALUES (74, '公司理念', 'corporatephilosophy/list.do', '67', '1', 'menu-icon fa fa-book purple', '1', 1);
INSERT INTO `sys_menu` VALUES (75, '联系我们', 'contactus/list.do', '80', '5', 'menu-icon fa fa-home green', '1', 1);
INSERT INTO `sys_menu` VALUES (76, '访客留言', 'leavemsg/list.do', '80', '6', 'menu-icon fa fa-bookmark blue', '1', 1);
INSERT INTO `sys_menu` VALUES (77, '关于我们', 'aboutus/list.do', '80', '1', 'menu-icon fa fa-home purple', '1', 1);
INSERT INTO `sys_menu` VALUES (78, '合作共赢', 'cooperation/list.do', '80', '3', 'menu-icon fa fa-fire green', '1', 1);
INSERT INTO `sys_menu` VALUES (79, '产品案例', 'image/list.do?TYPE=5', '80', '2', 'menu-icon fa fa-camera-retro orange', '1', 1);
INSERT INTO `sys_menu` VALUES (80, '内容管理', '#', '0', '12', 'menu-icon fa fa-book blue', '2', 1);
INSERT INTO `sys_menu` VALUES (81, '新闻动态', 'news/list.do', '80', '4', 'menu-icon fa fa-pencil-square-o red', '1', 1);
INSERT INTO `sys_menu` VALUES (82, '模版管理', '#', '0', '13', 'menu-icon fa fa-folder-open orange', '2', 1);
INSERT INTO `sys_menu` VALUES (83, '模版一', '#', '82', '1', 'menu-icon fa fa-folder-open-o blue', '1', 1);
INSERT INTO `sys_menu` VALUES (84, '模版二', '#', '82', '2', 'menu-icon fa fa-folder-open-o green', '1', 1);
INSERT INTO `sys_menu` VALUES (85, '模版三', '#', '82', '3', 'menu-icon fa fa-folder-open-o purple', '1', 1);
INSERT INTO `sys_menu` VALUES (86, '首页', 'codeeditor/goEdit.do?type=createHtml&ftl=indexTemplate', '83', '1', 'menu-icon fa fa-folder red', '1', 1);
INSERT INTO `sys_menu` VALUES (87, '关于我们', 'codeeditor/goEdit.do?type=createHtml&ftl=aboutusTemplate', '83', '2', 'menu-icon fa fa-folder green', '1', 1);
INSERT INTO `sys_menu` VALUES (88, '产品案例', 'codeeditor/goEdit.do?type=createHtml&ftl=productTemplate', '83', '3', 'menu-icon fa fa-folder orange', '1', 1);
INSERT INTO `sys_menu` VALUES (89, '合作共赢', 'codeeditor/goEdit.do?type=createHtml&ftl=cooperationTemplate', '83', '4', 'menu-icon fa fa-folder purple', '1', 1);
INSERT INTO `sys_menu` VALUES (90, '新闻动态', 'codeeditor/goEdit.do?type=createHtml&ftl=newsTemplate', '83', '5', 'menu-icon fa fa-folder pink', '1', 1);
INSERT INTO `sys_menu` VALUES (91, '联系我们', 'codeeditor/goEdit.do?type=createHtml&ftl=contactusTemplate', '83', '7', 'menu-icon fa fa-folder grey', '1', 1);
INSERT INTO `sys_menu` VALUES (92, '新闻详情', 'codeeditor/goEdit.do?type=createHtml&ftl=newsdetailTemplate', '83', '6', 'menu-icon fa fa-folder blue', '1', 1);
INSERT INTO `sys_menu` VALUES (93, '页头', 'codeeditor/goEdit.do?type=createHtml&ftl=headerTemplate', '83', '8', 'menu-icon fa fa-folder brown', '1', 1);
INSERT INTO `sys_menu` VALUES (94, '页尾', 'codeeditor/goEdit.do?type=createHtml&ftl=footerTemplate', '83', '9', 'menu-icon fa fa-folder purple', '1', 1);
INSERT INTO `sys_menu` VALUES (95, '首页', 'codeeditor/goEdit.do?type=createHtml2&ftl=indexTemplate', '84', '1', 'menu-icon fa fa-folder red', '1', 1);
INSERT INTO `sys_menu` VALUES (96, '关于我们', 'codeeditor/goEdit.do?type=createHtml2&ftl=aboutusTemplate', '84', '2', 'menu-icon fa fa-folder green', '1', 1);
INSERT INTO `sys_menu` VALUES (97, '产品案例', 'codeeditor/goEdit.do?type=createHtml2&ftl=productTemplate', '84', '3', 'menu-icon fa fa-folder orange', '1', 1);
INSERT INTO `sys_menu` VALUES (98, '合作共赢', 'codeeditor/goEdit.do?type=createHtml2&ftl=cooperationTemplate', '84', '4', 'menu-icon fa fa-folder purple', '1', 1);
INSERT INTO `sys_menu` VALUES (99, '新闻动态', 'codeeditor/goEdit.do?type=createHtml2&ftl=newsTemplate', '84', '5', 'menu-icon fa fa-folder pink', '1', 1);
INSERT INTO `sys_menu` VALUES (100, '联系我们', 'codeeditor/goEdit.do?type=createHtml2&ftl=contactusTemplate', '84', '7', 'menu-icon fa fa-folder grey', '1', 1);
INSERT INTO `sys_menu` VALUES (101, '新闻详情', 'codeeditor/goEdit.do?type=createHtml2&ftl=newsdetailTemplate', '84', '6', 'menu-icon fa fa-folder blue', '1', 1);
INSERT INTO `sys_menu` VALUES (102, '页头', 'codeeditor/goEdit.do?type=createHtml2&ftl=headerTemplate', '84', '8', 'menu-icon fa fa-folder brown', '1', 1);
INSERT INTO `sys_menu` VALUES (103, '页尾', 'codeeditor/goEdit.do?type=createHtml2&ftl=footerTemplate', '84', '9', 'menu-icon fa fa-folder purple', '1', 1);
INSERT INTO `sys_menu` VALUES (104, '首页', 'codeeditor/goEdit.do?type=createHtml3&ftl=indexTemplate', '85', '1', 'menu-icon fa fa-folder red', '1', 1);
INSERT INTO `sys_menu` VALUES (105, '关于我们', 'codeeditor/goEdit.do?type=createHtml3&ftl=aboutusTemplate', '85', '2', 'menu-icon fa fa-folder green', '1', 1);
INSERT INTO `sys_menu` VALUES (106, '产品案例', 'codeeditor/goEdit.do?type=createHtml3&ftl=productTemplate', '85', '3', 'menu-icon fa fa-folder orange', '1', 1);
INSERT INTO `sys_menu` VALUES (107, '合作共赢', 'codeeditor/goEdit.do?type=createHtml3&ftl=cooperationTemplate', '85', '4', 'menu-icon fa fa-folder purple', '1', 1);
INSERT INTO `sys_menu` VALUES (108, '新闻动态', 'codeeditor/goEdit.do?type=createHtml3&ftl=newsTemplate', '85', '5', 'menu-icon fa fa-folder pink', '1', 1);
INSERT INTO `sys_menu` VALUES (109, '联系我们', 'codeeditor/goEdit.do?type=createHtml3&ftl=contactusTemplate', '85', '7', 'menu-icon fa fa-folder grey', '1', 1);
INSERT INTO `sys_menu` VALUES (110, '新闻详情', 'codeeditor/goEdit.do?type=createHtml3&ftl=newsdetailTemplate', '85', '6', 'menu-icon fa fa-folder blue', '1', 1);
INSERT INTO `sys_menu` VALUES (111, '页头', 'codeeditor/goEdit.do?type=createHtml3&ftl=headerTemplate', '85', '8', 'menu-icon fa fa-folder brown', '1', 1);
INSERT INTO `sys_menu` VALUES (112, '页尾', 'codeeditor/goEdit.do?type=createHtml3&ftl=footerTemplate', '85', '9', 'menu-icon fa fa-folder purple', '1', 1);
INSERT INTO `sys_menu` VALUES (113, '访问记录', 'statistics/grlist.do', '1', '7', 'menu-icon fa fa-globe orange', '1', 1);
INSERT INTO `sys_menu` VALUES (114, 'IP黑名单', 'blacklist/list.do', '1', '8', 'menu-icon fa fa-adjust black', '1', 1);
INSERT INTO `sys_menu` VALUES (115, '流量统计', 'chartsstatistics/pvcharts.do', '1', '9', 'menu-icon fa fa-bar-chart-o green', '1', 1);
INSERT INTO `sys_menu` VALUES (116, '模版四', '#', '82', '4', 'menu-icon fa fa-folder-open-o pink', '1', 1);
INSERT INTO `sys_menu` VALUES (117, '首页', 'codeeditor/goEdit.do?type=createHtml4&ftl=indexTemplate', '116', '1', 'menu-icon fa fa-folder red', '1', 1);
INSERT INTO `sys_menu` VALUES (118, '关于我们', 'codeeditor/goEdit.do?type=createHtml4&ftl=aboutusTemplate', '116', '2', 'menu-icon fa fa-folder green', '1', 1);
INSERT INTO `sys_menu` VALUES (119, '产品案例', 'codeeditor/goEdit.do?type=createHtml4&ftl=productTemplate', '116', '3', 'menu-icon fa fa-folder orange', '1', 1);
INSERT INTO `sys_menu` VALUES (120, '合作共赢', 'codeeditor/goEdit.do?type=createHtml4&ftl=cooperationTemplate', '116', '4', 'menu-icon fa fa-folder purple', '1', 1);
INSERT INTO `sys_menu` VALUES (121, '新闻动态', 'codeeditor/goEdit.do?type=createHtml4&ftl=newsTemplate', '116', '5', 'menu-icon fa fa-folder pink', '1', 1);
INSERT INTO `sys_menu` VALUES (122, '新闻详情', 'codeeditor/goEdit.do?type=createHtml4&ftl=newsdetailTemplate', '116', '6', 'menu-icon fa fa-folder blue', '1', 1);
INSERT INTO `sys_menu` VALUES (123, '联系我们', 'codeeditor/goEdit.do?type=createHtml4&ftl=contactusTemplate', '116', '7', 'menu-icon fa fa-folder grey', '1', 1);
INSERT INTO `sys_menu` VALUES (124, '页头', 'codeeditor/goEdit.do?type=createHtml4&ftl=headerTemplate', '116', '8', 'menu-icon fa fa-folder brown', '1', 1);
INSERT INTO `sys_menu` VALUES (125, '尾页', 'codeeditor/goEdit.do?type=createHtml4&ftl=footerTemplate', '116', '9', 'menu-icon fa fa-folder orange', '1', 1);
INSERT INTO `sys_menu` VALUES (126, '模版五', '#', '82', '5', 'menu-icon fa fa-folder-open-o orange', '1', 1);
INSERT INTO `sys_menu` VALUES (127, '首页', 'codeeditor/goEdit.do?type=createHtml5&ftl=indexTemplate', '126', '1', 'menu-icon fa fa-folder red', '1', 1);
INSERT INTO `sys_menu` VALUES (128, '关于我们', 'codeeditor/goEdit.do?type=createHtml5&ftl=aboutusTemplate', '126', '2', 'menu-icon fa fa-folder green', '1', 1);
INSERT INTO `sys_menu` VALUES (129, '产品案例', 'codeeditor/goEdit.do?type=createHtml5&ftl=productTemplate', '126', '3', 'menu-icon fa fa-folder orange', '1', 1);
INSERT INTO `sys_menu` VALUES (130, '合作共赢', 'codeeditor/goEdit.do?type=createHtml5&ftl=cooperationTemplate', '126', '4', 'menu-icon fa fa-folder purple', '1', 1);
INSERT INTO `sys_menu` VALUES (131, '新闻动态', 'codeeditor/goEdit.do?type=createHtml5&ftl=newsTemplate', '126', '5', 'menu-icon fa fa-folder pink', '1', 1);
INSERT INTO `sys_menu` VALUES (132, '新闻详情', 'codeeditor/goEdit.do?type=createHtml5&ftl=newsdetailTemplate', '126', '6', 'menu-icon fa fa-folder blue', '1', 1);
INSERT INTO `sys_menu` VALUES (133, '联系我们', 'codeeditor/goEdit.do?type=createHtml5&ftl=contactusTemplate', '126', '7', 'menu-icon fa fa-folder grey', '1', 1);
INSERT INTO `sys_menu` VALUES (134, '页头', 'codeeditor/goEdit.do?type=createHtml5&ftl=headerTemplate', '126', '8', 'menu-icon fa fa-folder brown', '1', 1);
INSERT INTO `sys_menu` VALUES (135, '页尾', 'codeeditor/goEdit.do?type=createHtml5&ftl=footerTemplate', '126', '9', 'menu-icon fa fa-folder black', '1', 1);
INSERT INTO `sys_menu` VALUES (136, '模版六', '#', '82', '6', 'menu-icon fa fa-folder-open-o blue', '1', 1);
INSERT INTO `sys_menu` VALUES (137, '单页', 'codeeditor/goEdit.do?type=createHtml6&ftl=indexTemplate', '136', '1', 'menu-icon fa fa-folder green', '1', 1);
INSERT INTO `sys_menu` VALUES (138, '模版七', '#', '82', '7', 'menu-icon fa fa-folder-open-o black', '1', 1);
INSERT INTO `sys_menu` VALUES (139, '模版八', '#', '82', '8', 'menu-icon fa fa-folder-open-o brown', '1', 1);
INSERT INTO `sys_menu` VALUES (140, '单页', 'codeeditor/goEdit.do?type=createHtml7&ftl=indexTemplate', '138', '1', 'menu-icon fa fa-folder blue', '1', 1);
INSERT INTO `sys_menu` VALUES (141, '单页', 'codeeditor/goEdit.do?type=createHtml8&ftl=indexTemplate', '139', '1', 'menu-icon fa fa-folder purple', '1', 1);
COMMIT;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `ROLE_ID` varchar(100) NOT NULL,
  `ROLE_NAME` varchar(100) DEFAULT NULL,
  `RIGHTS` varchar(255) DEFAULT NULL,
  `PARENT_ID` varchar(100) DEFAULT NULL,
  `ADD_QX` varchar(255) DEFAULT NULL,
  `DEL_QX` varchar(255) DEFAULT NULL,
  `EDIT_QX` varchar(255) DEFAULT NULL,
  `CHA_QX` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ROLE_ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
BEGIN;
INSERT INTO `sys_role` VALUES ('1', '系统管理组', '5575186299632655785383789486228954763232206', '0', '1', '1', '1', '1');
INSERT INTO `sys_role` VALUES ('115b386ff04f4352b060dffcd2b5d1da', '中级会员', '', '2', '0', '0', '0', '0');
INSERT INTO `sys_role` VALUES ('1b67fc82ce89457a8347ae53e43a347e', '初级会员', '', '2', '0', '0', '0', '0');
INSERT INTO `sys_role` VALUES ('2', '会员组', '', '0', '0', '0', '0', '1');
INSERT INTO `sys_role` VALUES ('3', '注册用户', '', '1', '', '0', '0', '0');
INSERT INTO `sys_role` VALUES ('3264c8e83d0248bb9e3ea6195b4c0216', '一级管理员', '147573389638682795998', '1', '36892925196425486294', '36892925196425486294', '36892925196425486294', '36892925196425486294');
INSERT INTO `sys_role` VALUES ('46294b31a71c4600801724a6eb06bb26', '职位组', '', '0', '0', '0', '0', '0');
INSERT INTO `sys_role` VALUES ('5466347ac07044cb8d82990ec7f3a90e', '主管', '', '46294b31a71c4600801724a6eb06bb26', '0', '0', '0', '0');
INSERT INTO `sys_role` VALUES ('68f8e4a39efe47c7bb869e9d15ab925d', '二级管理员', '73786413343844589510', '1', '0', '0', '2251798773489606', '0');
INSERT INTO `sys_role` VALUES ('856849f422774ad390a4e564054d8cc8', '经理', '', '46294b31a71c4600801724a6eb06bb26', '0', '0', '0', '0');
INSERT INTO `sys_role` VALUES ('8b70a7e67f2841e7aaba8a4d92e5ff6f', '高级会员', '', '2', '0', '0', '0', '0');
INSERT INTO `sys_role` VALUES ('c21cecf84048434b93383182b1d98cba', '组长', '', '46294b31a71c4600801724a6eb06bb26', '0', '0', '0', '0');
INSERT INTO `sys_role` VALUES ('d449195cd8e7491080688c58e11452eb', '总监', '', '46294b31a71c4600801724a6eb06bb26', '0', '0', '0', '0');
INSERT INTO `sys_role` VALUES ('de9de2f006e145a29d52dfadda295353', '三级管理员', '73786413343844589510', '1', '0', '0', '0', '0');
COMMIT;

-- ----------------------------
-- Table structure for sys_role_fhbutton
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_fhbutton`;
CREATE TABLE `sys_role_fhbutton` (
  `RB_ID` varchar(100) NOT NULL,
  `ROLE_ID` varchar(100) DEFAULT NULL,
  `BUTTON_ID` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`RB_ID`) USING BTREE,
  KEY `角色表外键` (`ROLE_ID`) USING BTREE,
  KEY `fbutton` (`BUTTON_ID`) USING BTREE,
  CONSTRAINT `sys_role_fhbutton_ibfk_1` FOREIGN KEY (`BUTTON_ID`) REFERENCES `sys_fhbutton` (`FHBUTTON_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `sys_role_fhbutton_ibfk_2` FOREIGN KEY (`ROLE_ID`) REFERENCES `sys_role` (`ROLE_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_fhbutton
-- ----------------------------
BEGIN;
INSERT INTO `sys_role_fhbutton` VALUES ('1743733f366240c693c4295b527d1b0e', 'de9de2f006e145a29d52dfadda295353', '4efa162fce8340f0bd2dcd3b11d327ec');
INSERT INTO `sys_role_fhbutton` VALUES ('469ffb4848ad49c389867d99560a4698', 'de9de2f006e145a29d52dfadda295353', '46992ea280ba4b72b29dedb0d4bc0106');
INSERT INTO `sys_role_fhbutton` VALUES ('4ee1e2bc03a64ef1bc578fcf2e2ea2c1', '68f8e4a39efe47c7bb869e9d15ab925d', '3542adfbda73410c976e185ffe50ad06');
INSERT INTO `sys_role_fhbutton` VALUES ('5669c8754b4d4e368365ed5065f9fc10', '3264c8e83d0248bb9e3ea6195b4c0216', '3542adfbda73410c976e185ffe50ad06');
INSERT INTO `sys_role_fhbutton` VALUES ('74203935bfa34ce3b9b80e81f2a2bcfe', '68f8e4a39efe47c7bb869e9d15ab925d', '4efa162fce8340f0bd2dcd3b11d327ec');
INSERT INTO `sys_role_fhbutton` VALUES ('81d31bc5bf02490a85ce496b6755ef26', '3', '46992ea280ba4b72b29dedb0d4bc0106');
INSERT INTO `sys_role_fhbutton` VALUES ('8231c216fb514b4188e4162e629c6237', '3264c8e83d0248bb9e3ea6195b4c0216', '4efa162fce8340f0bd2dcd3b11d327ec');
INSERT INTO `sys_role_fhbutton` VALUES ('88f66a65ee1642bea7979e0e1050ac5f', '3', '4efa162fce8340f0bd2dcd3b11d327ec');
INSERT INTO `sys_role_fhbutton` VALUES ('8e478e8615ee455e95671ba05a29e457', 'de9de2f006e145a29d52dfadda295353', '3542adfbda73410c976e185ffe50ad06');
INSERT INTO `sys_role_fhbutton` VALUES ('d80abc961d594f75b65e90d5b7437aa9', '3', 'cc51b694d5344d28a9aa13c84b7166cd');
INSERT INTO `sys_role_fhbutton` VALUES ('f0329033d0914faf8ea6e9ff252cc5e6', '68f8e4a39efe47c7bb869e9d15ab925d', '46992ea280ba4b72b29dedb0d4bc0106');
INSERT INTO `sys_role_fhbutton` VALUES ('f627982cc9d4479dbc03af726dc6ac58', 'de9de2f006e145a29d52dfadda295353', 'cc51b694d5344d28a9aa13c84b7166cd');
INSERT INTO `sys_role_fhbutton` VALUES ('f919c1f620634bdaa353a9f63194a2e0', '3', '3542adfbda73410c976e185ffe50ad06');
COMMIT;

-- ----------------------------
-- Table structure for sys_statistics
-- ----------------------------
DROP TABLE IF EXISTS `sys_statistics`;
CREATE TABLE `sys_statistics` (
  `STATISTICS_ID` varchar(100) NOT NULL,
  `IP` varchar(20) DEFAULT NULL COMMENT 'IP',
  `AREA` varchar(255) DEFAULT NULL COMMENT '地区',
  `OPERATOR` varchar(10) DEFAULT NULL COMMENT '运营商',
  `CDATE` varchar(32) DEFAULT NULL COMMENT '日期',
  `CTIME` varchar(32) DEFAULT NULL COMMENT '时间',
  `REGION` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`STATISTICS_ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_statistics
-- ----------------------------
BEGIN;
INSERT INTO `sys_statistics` VALUES ('01a19ec06f8d4da982cd0a3ec553b94e', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-12-29', '2018-12-29 02:54:50', 'XX');
INSERT INTO `sys_statistics` VALUES ('0296e5c6144e444ab4286d307be62bfb', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-12-29', '2018-12-29 02:13:35', 'XX');
INSERT INTO `sys_statistics` VALUES ('02c05280f59b48fc9829991ac56e7a2a', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-10-16', '2018-10-16 14:38:27', 'XX');
INSERT INTO `sys_statistics` VALUES ('02c0e5bfab754e0a8a9cc0f0f1828223', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-12-13', '2018-12-13 02:38:00', 'XX');
INSERT INTO `sys_statistics` VALUES ('032057dc5a4b4dd2802cbcdee8b335d1', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2019-01-04', '2019-01-04 02:57:02', 'XX');
INSERT INTO `sys_statistics` VALUES ('04151c1f697543b2ac92417ee7a4c6d5', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-10-20', '2018-10-20 12:25:13', 'XX');
INSERT INTO `sys_statistics` VALUES ('04ee3b44ada2416aa34f1da68308fe9b', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-12-13', '2018-12-13 02:38:22', 'XX');
INSERT INTO `sys_statistics` VALUES ('0601ebe448fb4f809394395917592370', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-10-20', '2018-10-20 19:14:22', 'XX');
INSERT INTO `sys_statistics` VALUES ('0627e322218749b988f9c1e36ab581d9', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2019-01-04', '2019-01-04 00:52:05', 'XX');
INSERT INTO `sys_statistics` VALUES ('065bdf16069e4c28bc5d66fcf7875919', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2019-01-04', '2019-01-04 03:05:35', 'XX');
INSERT INTO `sys_statistics` VALUES ('11f7ee0675164cd499dd6344dfd612e5', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2019-01-03', '2019-01-03 02:33:40', 'XX');
INSERT INTO `sys_statistics` VALUES ('12b127b781fb42f39fced1b06fd32104', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-10-16', '2018-10-16 14:38:31', 'XX');
INSERT INTO `sys_statistics` VALUES ('1360d0b80df04b2a9443975439adb5ca', '192.168.0.8', 'XX  XX 内网IP', '内网IP', '2019-01-03', '2019-01-03 01:35:07', 'XX');
INSERT INTO `sys_statistics` VALUES ('14152beb687f4e84a3143a20faa9f64b', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2019-01-02', '2019-01-02 03:19:37', 'XX');
INSERT INTO `sys_statistics` VALUES ('1b46bb3611bb43d29ef91c0bfd771578', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-12-13', '2018-12-13 10:48:48', 'XX');
INSERT INTO `sys_statistics` VALUES ('1f2b226a098945c28cfb523a59e68c6e', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-10-16', '2018-10-16 14:56:13', 'XX');
INSERT INTO `sys_statistics` VALUES ('20804ab7a7e544e8aaf30ae134e289ee', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-12-13', '2018-12-13 02:13:37', 'XX');
INSERT INTO `sys_statistics` VALUES ('21a86efb546c4c68b722afb03bb902fb', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-12-29', '2018-12-29 02:13:03', 'XX');
INSERT INTO `sys_statistics` VALUES ('21abc367140b4fcf980c9c737f0d2a42', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-10-20', '2018-10-20 19:10:49', 'XX');
INSERT INTO `sys_statistics` VALUES ('22b3c5e2fea044dd8bafd6ac437c6354', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-10-16', '2018-10-16 14:54:38', 'XX');
INSERT INTO `sys_statistics` VALUES ('249872d30bee49eb88271cba66e4ba33', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2019-01-02', '2019-01-02 03:19:52', 'XX');
INSERT INTO `sys_statistics` VALUES ('263be02ea8c54e928cc14a9b5d801e63', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-10-20', '2018-10-20 14:09:59', 'XX');
INSERT INTO `sys_statistics` VALUES ('28beba48a4ce4175bda5ec42cd452337', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-12-13', '2018-12-13 10:46:56', 'XX');
INSERT INTO `sys_statistics` VALUES ('28f653400a0643f097b334c3ec0f5d43', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-10-20', '2018-10-20 19:14:21', 'XX');
INSERT INTO `sys_statistics` VALUES ('2f298f6920d94d7a838054cd1e08aa9e', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-12-29', '2018-12-29 02:13:38', 'XX');
INSERT INTO `sys_statistics` VALUES ('2fb9bc205b9149608c79c71d36a69025', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-12-13', '2018-12-13 02:38:17', 'XX');
INSERT INTO `sys_statistics` VALUES ('305b35a18c464dbbac3c4f5dfbb1c1af', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2019-01-03', '2019-01-03 01:41:20', 'XX');
INSERT INTO `sys_statistics` VALUES ('3079a1d9f7d94a528b4fd04ea4f880c1', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2019-01-04', '2019-01-04 03:06:12', 'XX');
INSERT INTO `sys_statistics` VALUES ('31d890cce50f4392a7cf1655da8038d6', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2019-01-04', '2019-01-04 03:31:13', 'XX');
INSERT INTO `sys_statistics` VALUES ('3887811ea4c64e0ca4ac81df4caf73f6', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-12-13', '2018-12-13 02:13:29', 'XX');
INSERT INTO `sys_statistics` VALUES ('38d9649a70e646ecb4efcac7daa223cb', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-10-16', '2018-10-16 14:38:16', 'XX');
INSERT INTO `sys_statistics` VALUES ('3d95df26eba146aab8c454a8e2411809', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2019-01-04', '2019-01-04 03:16:03', 'XX');
INSERT INTO `sys_statistics` VALUES ('438aad701bb34a58b57fc00764148260', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-10-16', '2018-10-16 14:53:55', 'XX');
INSERT INTO `sys_statistics` VALUES ('4449a9db59d0478a993630254ab34925', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2019-01-02', '2019-01-02 03:22:51', 'XX');
INSERT INTO `sys_statistics` VALUES ('49ef64097a9a489d97dae6a926ea4d7f', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2019-01-04', '2019-01-04 03:30:05', 'XX');
INSERT INTO `sys_statistics` VALUES ('4afe955bf36d4ba2ba36673f5a94f8cc', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-12-13', '2018-12-13 02:30:11', 'XX');
INSERT INTO `sys_statistics` VALUES ('4b1986fe27424ba292d59f0924e1caab', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-12-13', '2018-12-13 02:35:57', 'XX');
INSERT INTO `sys_statistics` VALUES ('5161fda7db644a3ea008d8423ff54c31', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2019-01-04', '2019-01-04 02:49:22', 'XX');
INSERT INTO `sys_statistics` VALUES ('51a1fccb885a4809857785f98b9eea30', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-10-20', '2018-10-20 19:14:07', 'XX');
INSERT INTO `sys_statistics` VALUES ('5891552d12da4c9e8508e9eb95c073f8', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2019-01-04', '2019-01-04 00:48:25', 'XX');
INSERT INTO `sys_statistics` VALUES ('5baaec67958f4c03b8848498b4bcca94', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2019-01-04', '2019-01-04 03:23:04', 'XX');
INSERT INTO `sys_statistics` VALUES ('5ddf6cdeecbd4eec9d349a6cb35ba6b1', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-10-16', '2018-10-16 14:56:11', 'XX');
INSERT INTO `sys_statistics` VALUES ('5e44056dac58490aa405c1cf09d03cc9', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-10-20', '2018-10-20 12:31:18', 'XX');
INSERT INTO `sys_statistics` VALUES ('60ccac03e80c4220b605948c65a754af', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2019-01-02', '2019-01-02 03:19:55', 'XX');
INSERT INTO `sys_statistics` VALUES ('61dc4097d4a94a9ab2b1aea093d4eb62', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-12-13', '2018-12-13 02:32:46', 'XX');
INSERT INTO `sys_statistics` VALUES ('62701c3d43a14036ab6fc8b25859b97a', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-10-20', '2018-10-20 19:11:59', 'XX');
INSERT INTO `sys_statistics` VALUES ('62a2d6f9911d4882b5b88b03dd5d4c23', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-12-29', '2018-12-29 02:12:44', 'XX');
INSERT INTO `sys_statistics` VALUES ('6636a41d2cd744d2b871b24b830bd317', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-12-13', '2018-12-13 02:38:04', 'XX');
INSERT INTO `sys_statistics` VALUES ('67febc7e16784a62acc18fe20bffad54', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-12-13', '2018-12-13 02:39:00', 'XX');
INSERT INTO `sys_statistics` VALUES ('6b6ddeb26cbd4bf5abd544a197a2ae10', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2019-01-02', '2019-01-02 02:49:23', 'XX');
INSERT INTO `sys_statistics` VALUES ('6c2934edf88d41d9be74501eb91539ba', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-10-16', '2018-10-16 14:55:09', 'XX');
INSERT INTO `sys_statistics` VALUES ('707963adf2b74efa91a0f69ec5f72ff5', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-12-29', '2018-12-29 02:27:09', 'XX');
INSERT INTO `sys_statistics` VALUES ('730171224f0c4fe3ba93011ed88258e1', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2019-01-02', '2019-01-02 03:03:59', 'XX');
INSERT INTO `sys_statistics` VALUES ('7343aebbbb51471492b30617e55f8c1f', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-10-20', '2018-10-20 14:09:16', 'XX');
INSERT INTO `sys_statistics` VALUES ('7440e8bc68154adbb9566d4d66384418', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2019-01-04', '2019-01-04 02:52:41', 'XX');
INSERT INTO `sys_statistics` VALUES ('783da5a0ef6148e6bbd2e42602e4c051', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-12-13', '2018-12-13 02:38:31', 'XX');
INSERT INTO `sys_statistics` VALUES ('78994c4c82f942cb9735de683bb0272c', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-10-16', '2018-10-16 14:56:19', 'XX');
INSERT INTO `sys_statistics` VALUES ('799c6b72147d4d4082665378818f6495', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-10-16', '2018-10-16 14:56:17', 'XX');
INSERT INTO `sys_statistics` VALUES ('7b68f3de9a8747d4a2aacf550004c461', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-10-16', '2018-10-16 14:54:45', 'XX');
INSERT INTO `sys_statistics` VALUES ('7e0ea02712e14db78c982d3dc3dff678', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2019-01-04', '2019-01-04 03:08:50', 'XX');
INSERT INTO `sys_statistics` VALUES ('82927a654a7f4caa96b19d9d739fd4f7', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-12-13', '2018-12-13 02:37:58', 'XX');
INSERT INTO `sys_statistics` VALUES ('84ee1a28f00e4fd2adf3ff6a87eb124d', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-10-20', '2018-10-20 12:26:10', 'XX');
INSERT INTO `sys_statistics` VALUES ('861768e26a1f45018159a57ec5ab7ae4', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-12-13', '2018-12-13 02:38:04', 'XX');
INSERT INTO `sys_statistics` VALUES ('8645f94445024253a8b404ab1da004d0', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-12-13', '2018-12-13 10:48:49', 'XX');
INSERT INTO `sys_statistics` VALUES ('88f7f80613f64d92b956a1ef0c964d44', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-12-13', '2018-12-13 02:37:56', 'XX');
INSERT INTO `sys_statistics` VALUES ('8a6a316e79a743d8b9a6c4bc13be832e', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-10-17', '2018-10-17 08:44:16', 'XX');
INSERT INTO `sys_statistics` VALUES ('8d696ba922a9440aae6d3bf83ae1ed3b', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2019-01-04', '2019-01-04 03:30:51', 'XX');
INSERT INTO `sys_statistics` VALUES ('8d70bf5643844631af95231c12b4490c', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-12-29', '2018-12-29 02:27:27', 'XX');
INSERT INTO `sys_statistics` VALUES ('8db8f6b4c87a4437aadfe8a3a4d959cb', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-10-16', '2018-10-16 14:53:58', 'XX');
INSERT INTO `sys_statistics` VALUES ('8e5da8c0918a46c7bd2576d318ae78df', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-12-13', '2018-12-13 02:31:56', 'XX');
INSERT INTO `sys_statistics` VALUES ('9454da4e8bfa4aa88bb5b8b77607973d', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-12-13', '2018-12-13 02:38:12', 'XX');
INSERT INTO `sys_statistics` VALUES ('9529c08be4de4ae38bea884951d4d9b1', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2019-01-02', '2019-01-02 03:03:24', 'XX');
INSERT INTO `sys_statistics` VALUES ('9ae66ed376534d3dbf5ed186fc704a03', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-12-13', '2018-12-13 02:38:50', 'XX');
INSERT INTO `sys_statistics` VALUES ('9b2efed61c1047f6bf0f117d29603eba', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2019-01-02', '2019-01-02 02:21:53', 'XX');
INSERT INTO `sys_statistics` VALUES ('9c7fa6a29f6a469faee14af97914dde0', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-10-16', '2018-10-16 14:54:43', 'XX');
INSERT INTO `sys_statistics` VALUES ('9d75a5b241ea4057bcf91376f83f4b54', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-10-20', '2018-10-20 19:11:22', 'XX');
INSERT INTO `sys_statistics` VALUES ('9e48fe46f9424a12ad5ec5b3d77535f9', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-12-29', '2018-12-29 02:13:49', 'XX');
INSERT INTO `sys_statistics` VALUES ('a1261c572fee49a18c1e5b817c75f8f9', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-12-13', '2018-12-13 02:38:45', 'XX');
INSERT INTO `sys_statistics` VALUES ('a13112b2a72b4e7cac448b791d6d0ebc', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-10-16', '2018-10-16 14:36:32', 'XX');
INSERT INTO `sys_statistics` VALUES ('a29757fdbb1e4f6d9a4fe374f53959fa', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-12-13', '2018-12-13 02:38:02', 'XX');
INSERT INTO `sys_statistics` VALUES ('a2bc6245f5414ff78bea91c83adae068', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2019-01-02', '2019-01-02 02:45:49', 'XX');
INSERT INTO `sys_statistics` VALUES ('a4847d84cd5e40928f145bbc4365b9c4', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-12-29', '2018-12-29 02:13:11', 'XX');
INSERT INTO `sys_statistics` VALUES ('aa421ab56bb346d49b218069be1f3222', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-12-13', '2018-12-13 02:38:43', 'XX');
INSERT INTO `sys_statistics` VALUES ('ab7d47481a0946b6a5663a0753554f9b', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-12-13', '2018-12-13 02:39:03', 'XX');
INSERT INTO `sys_statistics` VALUES ('abdf13a0f7a145188aceb7081cfc2e84', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-10-20', '2018-10-20 12:30:16', 'XX');
INSERT INTO `sys_statistics` VALUES ('aca8e776dae94296b653326b0bc78ab0', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-12-13', '2018-12-13 02:38:21', 'XX');
INSERT INTO `sys_statistics` VALUES ('ae8ed7cdb65f4eb181c73672c9255b19', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-12-29', '2018-12-29 02:12:16', 'XX');
INSERT INTO `sys_statistics` VALUES ('aeefdd266bbf46da827448086593292e', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2019-01-02', '2019-01-02 02:45:31', 'XX');
INSERT INTO `sys_statistics` VALUES ('b19deff7f7cb4616973a873af6e2b98a', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-10-16', '2018-10-16 14:38:32', 'XX');
INSERT INTO `sys_statistics` VALUES ('b1e2e7768a3646ec9633b902324f0dfd', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-12-13', '2018-12-13 02:13:33', 'XX');
INSERT INTO `sys_statistics` VALUES ('b59553e4561f43e7bc9f2e298b7b2041', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-10-16', '2018-10-16 14:53:50', 'XX');
INSERT INTO `sys_statistics` VALUES ('b59a526686134cf38762f2441d137ccd', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2019-01-04', '2019-01-04 03:30:20', 'XX');
INSERT INTO `sys_statistics` VALUES ('b7000ac9610c4e4594b3c4e68a95312e', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-12-29', '2018-12-29 02:13:34', 'XX');
INSERT INTO `sys_statistics` VALUES ('ba104d01547745afa3620ccf589bc0ad', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-10-16', '2018-10-16 14:38:26', 'XX');
INSERT INTO `sys_statistics` VALUES ('be49b585e92849819095580d5945cc32', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-12-13', '2018-12-13 02:13:35', 'XX');
INSERT INTO `sys_statistics` VALUES ('c0a583b96a4d4602ac6e8cd15b012119', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-10-16', '2018-10-16 14:38:23', 'XX');
INSERT INTO `sys_statistics` VALUES ('c74a1065f6114fd091ddb6bd0737fb18', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2019-01-04', '2019-01-04 00:51:20', 'XX');
INSERT INTO `sys_statistics` VALUES ('c8965c17f2ff4f5d9f4835ce10474e29', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-12-29', '2018-12-29 02:55:16', 'XX');
INSERT INTO `sys_statistics` VALUES ('cdbee768f8c3425791152028445aa78a', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-10-20', '2018-10-20 19:15:34', 'XX');
INSERT INTO `sys_statistics` VALUES ('cf328542db424d4aa5e1de07157f43e9', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-12-29', '2018-12-29 02:13:57', 'XX');
INSERT INTO `sys_statistics` VALUES ('d10bf5d6422d472f91e59c3a6ba58881', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-12-13', '2018-12-13 02:39:19', 'XX');
INSERT INTO `sys_statistics` VALUES ('d19fa015ccb3484687a6809285bd710a', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-12-29', '2018-12-29 02:13:24', 'XX');
INSERT INTO `sys_statistics` VALUES ('d43b6a241c74424b8040d8dd61686804', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-12-13', '2018-12-13 02:13:41', 'XX');
INSERT INTO `sys_statistics` VALUES ('d60c77df2fea46868f540bf434869dd8', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-12-13', '2018-12-13 02:37:26', 'XX');
INSERT INTO `sys_statistics` VALUES ('d6462d8190d84b2d8d45f3fe61de16e9', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-12-13', '2018-12-13 10:46:55', 'XX');
INSERT INTO `sys_statistics` VALUES ('d7ae788f6fdd4e848c05d3ea36c4563a', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-12-13', '2018-12-13 02:38:25', 'XX');
INSERT INTO `sys_statistics` VALUES ('d98ac27f0dbe47aca502798395c41c73', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-12-13', '2018-12-13 10:46:53', 'XX');
INSERT INTO `sys_statistics` VALUES ('dae6f7673fe94c3dad36a16b953ece4e', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2019-01-02', '2019-01-02 03:19:54', 'XX');
INSERT INTO `sys_statistics` VALUES ('dd4a70ff63a04ca39cb4e66f2ec76fa0', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-10-16', '2018-10-16 14:55:20', 'XX');
INSERT INTO `sys_statistics` VALUES ('df336118974c44d9bd3d94d49edd6fa6', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-10-20', '2018-10-20 19:13:34', 'XX');
INSERT INTO `sys_statistics` VALUES ('e217a0ac04954b6a971e0bf97d3bd7c6', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2019-01-02', '2019-01-02 03:04:16', 'XX');
INSERT INTO `sys_statistics` VALUES ('e231d50e18e040f989e0541f2a36e2e1', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2019-01-04', '2019-01-04 03:23:21', 'XX');
INSERT INTO `sys_statistics` VALUES ('e55f3563991741e09f91b3b475a71148', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2019-01-04', '2019-01-04 03:11:52', 'XX');
INSERT INTO `sys_statistics` VALUES ('e689d34afac946f6b040e76f1bd5680e', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-12-13', '2018-12-13 10:48:46', 'XX');
INSERT INTO `sys_statistics` VALUES ('e781f36dc94948b29e5cc5a1bfea534a', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2019-01-03', '2019-01-03 01:15:46', 'XX');
INSERT INTO `sys_statistics` VALUES ('eb9bf77edfe540c3869ddfc2d9d8cbad', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-12-29', '2018-12-29 02:27:04', 'XX');
INSERT INTO `sys_statistics` VALUES ('ed5b2b6d6e8a4ee89196337e0b17996a', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-10-16', '2018-10-16 14:55:16', 'XX');
INSERT INTO `sys_statistics` VALUES ('ee3ad5d57e624a27a30a6567b0207073', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-10-16', '2018-10-16 14:53:48', 'XX');
INSERT INTO `sys_statistics` VALUES ('f09a4f000cad4c8fbb5b4a98595550aa', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-10-20', '2018-10-20 19:15:13', 'XX');
INSERT INTO `sys_statistics` VALUES ('f27d11b8ecb0407ab1fe8fd3d2398f6a', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-12-13', '2018-12-13 02:38:19', 'XX');
INSERT INTO `sys_statistics` VALUES ('f3d05f0fe8614dc1b3b136a185c066c6', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-12-13', '2018-12-13 02:38:34', 'XX');
INSERT INTO `sys_statistics` VALUES ('f456697d5b9640b3a9cf1b0743274217', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-12-13', '2018-12-13 02:13:39', 'XX');
INSERT INTO `sys_statistics` VALUES ('f5bf11ba70e74763b9713d979badf4f3', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2018-12-13', '2018-12-13 10:48:45', 'XX');
INSERT INTO `sys_statistics` VALUES ('f5c1cee1eda6488386d25d02a8180263', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2019-01-03', '2019-01-03 02:34:03', 'XX');
INSERT INTO `sys_statistics` VALUES ('f82bb01cb2b04c83adfa658a16caf2b9', '127.0.0.1', 'XX  XX 内网IP', '内网IP', '2019-01-04', '2019-01-04 03:31:26', 'XX');
COMMIT;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `USER_ID` varchar(100) NOT NULL,
  `USERNAME` varchar(255) DEFAULT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  `RIGHTS` varchar(255) DEFAULT NULL,
  `ROLE_ID` varchar(100) DEFAULT NULL,
  `LAST_LOGIN` varchar(255) DEFAULT NULL,
  `IP` varchar(100) DEFAULT NULL,
  `STATUS` varchar(32) DEFAULT NULL,
  `BZ` varchar(255) DEFAULT NULL,
  `SKIN` varchar(100) DEFAULT NULL,
  `EMAIL` varchar(32) DEFAULT NULL,
  `NUMBER` varchar(100) DEFAULT NULL,
  `PHONE` varchar(32) DEFAULT NULL,
  `ENABLED` int(11) DEFAULT NULL,
  `LASTPASSWORDRESETDATE` date DEFAULT NULL,
  PRIMARY KEY (`USER_ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
BEGIN;
INSERT INTO `sys_user` VALUES ('1', 'admin', 'de41b7fb99201d8334c23c014db35ecd92df81bc', 'FH', '1133671055321055258374707980945218933803269864762743594642571294', '1', '2019-04-19 11:15:16', '0:0:0:0:0:0:0:1', '0', 'admin', 'no-skin', 'QQ313596790@main.com', '001', '18788888888', 0, NULL);
INSERT INTO `sys_user` VALUES ('7', 'superadmin', '$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi', 'superadmin', '1133671055321055258374707980945218933803269864762743594642571294', '1', NULL, NULL, '0', NULL, NULL, 'admin@admin.com', NULL, NULL, 0, NULL);
INSERT INTO `sys_user` VALUES ('8', 'user', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'user', '1133671055321055258374707980945218933803269864762743594642571294', '2', NULL, NULL, '0', NULL, NULL, 'enabled@user.com', NULL, NULL, 0, NULL);
INSERT INTO `sys_user` VALUES ('9', 'disabled', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'user', '1133671055321055258374707980945218933803269864762743594642571294', '3', NULL, NULL, '0', NULL, NULL, 'disabled@user.com', NULL, NULL, 0, NULL);
INSERT INTO `sys_user` VALUES ('eded77bdf35347249b2bacfa181c869d', 'w1', 'c46e5c325e9edfbf213d5d82018ba3c522eabbea', '1212', '1133671055321055258374707980945218933803269864762743594642571294', '68f8e4a39efe47c7bb869e9d15ab925d', '', '', '0', '111', 'no-skin', '313596790@qq.com', '112', '13566625555', 0, NULL);
COMMIT;

-- ----------------------------
-- Table structure for sys_userphoto
-- ----------------------------
DROP TABLE IF EXISTS `sys_userphoto`;
CREATE TABLE `sys_userphoto` (
  `USERPHOTO_ID` varchar(100) NOT NULL,
  `USERNAME` varchar(30) DEFAULT NULL COMMENT '用户名',
  `PHOTO0` varchar(255) DEFAULT NULL COMMENT '原图',
  `PHOTO1` varchar(100) DEFAULT NULL COMMENT '头像1',
  `PHOTO2` varchar(100) DEFAULT NULL COMMENT '头像2',
  `PHOTO3` varchar(100) DEFAULT NULL COMMENT '头像3',
  PRIMARY KEY (`USERPHOTO_ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
