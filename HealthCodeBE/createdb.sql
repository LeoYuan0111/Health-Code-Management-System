drop database backendtest;
create database backendtest;
use backendtest;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`  (
                            `id_number` char(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                            `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '',
                            `phone_number` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '',
                            `admin` boolean NOT NULL DEFAULT 0,
                            `sampler` boolean NOT NULL DEFAULT 0,
                            `tester` boolean NOT NULL DEFAULT 0,
                            PRIMARY KEY (`id_number`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `account` VALUES ('333333333333333333', 'password', '17000000000', 1, 0, 0);
INSERT INTO `account` VALUES ('333333333333333360', 'password', '17000000000', 1, 0, 0);
INSERT INTO `account` VALUES ('333333333333333361', 'password', '17000000000', 0, 1, 0);
INSERT INTO `account` VALUES ('333333333333333362', 'password', '17000000000', 0, 0, 1);
INSERT INTO `account` VALUES ('333333333333333363', 'password', '17000000000', 1, 1, 1);
-- ----------------------------
-- Table structure for person
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person`  (
                           `id_number` char(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                           `real_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '',
                           `phone` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '',
                           `age` integer NOT NULL DEFAULT 0,
                           `addr` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '',
                           PRIMARY KEY (`id_number`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of person
-- ----------------------------
-- INSERT INTO `person` VALUES ('333333333333333333', 'Jack', '17000000001', 20, 'Hangzhou');
INSERT INTO `person` VALUES ('333333333333333333', 'Jack', '17000000000', 20, 'Hangzhou');
INSERT INTO `person` VALUES ('333333333333333360', 'Neil', '17000000000', 19, 'Hangzhou');
INSERT INTO `person` VALUES ('333333333333333361', 'Hello', '17000000000', 43, 'Hangzhou');
INSERT INTO `person` VALUES ('333333333333333362', 'Bye', '17000000000', 24, 'Hangzhou');
INSERT INTO `person` VALUES ('333333333333333363', 'Miles&Gwen', '17000000000', 15, 'Hangzhou');

-- ----------------------------
-- Table structure for vaccination record
-- ----------------------------
DROP TABLE IF EXISTS `vaccination_record`;
CREATE TABLE `vaccination_record`  (
                                       `id_number` char(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                                       `vacc_id` int(12) NOT NULL,
                                       `inject_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                       `doc_id_number` char(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                                       PRIMARY KEY (`vacc_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of vaccination record
-- ----------------------------
INSERT INTO `vaccination_record` (id_number, vacc_id, inject_date, doc_id_number) VALUES ('333333333333333333', 0, NOW(), '555555555555555555');

-- ----------------------------
-- Table structure for test record
-- ----------------------------
DROP TABLE IF EXISTS `test_record`;
CREATE TABLE `test_record`  (
                                `id_number` char(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                                `tube_id` int(12) NOT NULL,
                                `date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                `sampler_id_number` char(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                                `tester_id_number` char(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                                `result` tinyint(1) NOT NULL DEFAULT 0,
                                PRIMARY KEY (`tube_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of test record
-- ----------------------------
INSERT INTO `test_record` (id_number, tube_id, date, sampler_id_number, tester_id_number, result) VALUES ('333333333333333333', 0, NOW(), '555555555555555555', '666666666666666666', 2);

-- ----------------------------
-- Table structure for tube
-- ----------------------------
DROP TABLE IF EXISTS `tube`;
CREATE TABLE `tube`  (
                         `tube_id` int(12) NOT NULL AUTO_INCREMENT UNIQUE,
                         `date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                         `provider` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '',
                         `expiration_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                         PRIMARY KEY (`tube_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tube
-- ----------------------------
INSERT INTO `tube` (date, provider, expiration_date) VALUES (NOW(), 'xxx company', NOW());

-- ----------------------------
-- Table structure for vaccine
-- ----------------------------
DROP TABLE IF EXISTS `vaccine`;
CREATE TABLE `vaccine`  (
                            `vacc_id` int(12) NOT NULL AUTO_INCREMENT UNIQUE,
                            `date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                            `provider` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '',
                            `expiration_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                            PRIMARY KEY (`vacc_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of vaccine
-- ----------------------------
INSERT INTO `vaccine` (date, provider, expiration_date) VALUES (NOW(), 'xxx company', NOW());

-- ----------------------------
-- Table structure for health code
-- ----------------------------
DROP TABLE IF EXISTS `health_code`;
CREATE TABLE `health_code`  (
                                `id_number` char(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                                `color` tinyint(1) NOT NULL DEFAULT 0,
                                `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                `qr_code` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '',
                                PRIMARY KEY (`id_number`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of health code
-- ----------------------------
INSERT INTO `health_code` (id_number, color, update_time, qr_code) VALUES ('333333333333333333', 1, NOW(), 'asdfasdfaasdf');

-- ----------------------------
-- Table structure for plaec code
-- ----------------------------
DROP TABLE IF EXISTS `place_code`;
CREATE TABLE `place_code`  (
                               `place_id` int(12) NOT NULL AUTO_INCREMENT UNIQUE,
                               `phone_number` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
                               `longitude` double NOT NULL,
                               `latitude` double NOT NULL,
                               `province` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '',
                               `city` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '',
                               `county` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '',
                               `village` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '',
                               `detail_addr` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '',
                               PRIMARY KEY (`place_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of place code
-- ----------------------------
INSERT INTO `place_code` (longitude, latitude, province, city, county, village, detail_addr) VALUES (100.0, 100.0, 'Zhejiang', 'Hangzhou', 'Xihu', 'Sandun', 'asdf');

-- ----------------------------
-- Table structure for place visit
-- ----------------------------
DROP TABLE IF EXISTS `place_visit`;
CREATE TABLE `place_visit`  (
                                `id_number` char(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                                `place_id` int(12) NOT NULL,
                                `visit_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                PRIMARY KEY (`id_number`,  `place_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of place visit
-- ----------------------------
INSERT INTO `place_visit` (id_number, place_id, visit_time) VALUES ('333333333333333333', 0, NOW());

-- ----------------------------
-- Table structure for test position
-- ----------------------------
DROP TABLE IF EXISTS `test_position`;
CREATE TABLE `test_position`  (
                                  `place_id` int(12) NOT NULL UNIQUE,
                                  `manager_id_number` char(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                                  `start_time` TIME,
                                  `end_time` TIME,
                                  PRIMARY KEY (`place_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of test position
-- ----------------------------
INSERT INTO `test_position` (place_id, manager_id_number, start_time, end_time) VALUES (1, '333333333333333333', '18:00:00', '20:00:00');

-- ----------------------------
-- Table structure for test time
-- ----------------------------
DROP TABLE IF EXISTS `test_time`;

-- ----------------------------
-- Table structure for color change
-- ----------------------------
DROP TABLE IF EXISTS `color_change`;
CREATE TABLE `color_change`  (
                                 `id_number` char(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                                 `time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                 `tocolor` tinyint(1) NOT NULL DEFAULT 0,
                                 `reason` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '',
                                 PRIMARY KEY (`id_number`, `time`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of color change
-- ----------------------------
INSERT INTO `color_change` (id_number, time, tocolor, reason) VALUES ('333333333333333333', NOW(), 0, 'change color');

# -- ----------------------------
# -- Table structure for travel code
# -- ----------------------------
# DROP TABLE IF EXISTS `travel_code`;
# CREATE TABLE `travel_code`  (
#     `id_number` char(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
#     `province` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '',
#     `city` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '',
#     `county` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '',
#     `time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
#     PRIMARY KEY (`id_number`, `time`) USING BTREE
# ) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;
#
# -- ----------------------------
# -- Records of travel code
# -- ----------------------------
# INSERT INTO `travel_code` (id_number, province, city, county, time) VALUES ('333333333333333333', 'Zhejiang', 'Hangzhou', 'Xihu', NOW());

-- ----------------------------
-- Table structure for authorize record
-- ----------------------------
DROP TABLE IF EXISTS `authorize`;
CREATE TABLE `authorize`  (
                              `authorize_id` int(12) NOT NULL AUTO_INCREMENT UNIQUE,
                              `author_id_number` char(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                              `user_id_number` char(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                              `time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                              `admin` boolean NOT NULL DEFAULT 0,
                              `sampler` boolean NOT NULL DEFAULT 0,
                              `tester` boolean NOT NULL DEFAULT 0,
                              PRIMARY KEY (`authorize_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of authorize record
-- ----------------------------
INSERT INTO `authorize` (author_id_number, user_id_number, time, admin, sampler, tester) VALUES ('333333333333333333', '333333333333333333', NOW(), 0, 1, 1);

-- ----------------------------
-- Table structure for complain
-- ----------------------------
DROP TABLE IF EXISTS `complain`;
CREATE TABLE `complain`  (
                             `complain_id` int(12) NOT NULL AUTO_INCREMENT UNIQUE,
                             `time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                             `id_number` char(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
                             `content` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '',
                             `result` tinyint(1) NOT NULL DEFAULT 0,
                             `reply` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
                             `withdraw` tinyint(1) NOT NULL DEFAULT 0,
                             PRIMARY KEY (`complain_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of complain
-- ----------------------------
INSERT INTO `complain` (time, id_number, content, result, withdraw) VALUES (NOW(), '333333333333333333', 'asdfasdf', 0, 0);