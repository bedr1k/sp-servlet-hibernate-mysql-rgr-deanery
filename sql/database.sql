DROP DATABASE IF EXISTS deanery; 
CREATE DATABASE deanery DEFAULT CHARACTER SET utf8;
USE deanery;


CREATE TABLE `students_group` (
	`id` BIGINT NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(45) NULL,
	`course` BIGINT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `discipline` (
	`id` BIGINT NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(45) NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `student` (
	`id` BIGINT NOT NULL AUTO_INCREMENT,
	`first_name` VARCHAR(45) NULL,
	`second_name` VARCHAR(45) NULL,
    `patronymic` VARCHAR(45) NULL,
	`group_id` BIGINT NULL,
	PRIMARY KEY (`id`),
    FOREIGN KEY (`group_id`) REFERENCES `students_group` (`id`)
);

CREATE TABLE `exam` (
	`id` BIGINT NOT NULL AUTO_INCREMENT,
    `grade` TINYINT UNSIGNED NULL,
	`exam_day` DATE NULL,
    `discipline_id` BIGINT NULL,
	`student_id` BIGINT NULL,
    CHECK (`grade` <= 10),
	PRIMARY KEY (`id`),
    FOREIGN KEY (`student_id`) REFERENCES `student` (`id`),
	FOREIGN KEY (`discipline_id`) REFERENCES `discipline` (`id`)
);

INSERT INTO `students_group` VALUES ('1', 'Ит-10', '3');
INSERT INTO `students_group` VALUES ('2', 'А-34', '3');
INSERT INTO `students_group` VALUES ('3', 'Ит-11', '2');
INSERT INTO `students_group` VALUES ('4', 'А-35', '2');

INSERT INTO `student` VALUES ('1', 'Тони', 'Старк', 'Андреевич', '1');
INSERT INTO `student` VALUES ('2', 'Сергей', 'Маханьков', 'Александрович', '1');
INSERT INTO `student` VALUES ('3', 'Роман', 'Сушанский', 'Сергеевич', '1');
INSERT INTO `student` VALUES ('4', 'Фреско', 'Жак', 'Дмитриевич', '1');
INSERT INTO `student` VALUES ('5', 'Максим', 'Сильный', 'Наборович', '1');
INSERT INTO `student` VALUES ('6', 'Алексей', 'Алексеев', 'Евгеньевич', '2');
INSERT INTO `student` VALUES ('7', 'Александр', 'Жмышенко', 'Сергеевич', '2');
INSERT INTO `student` VALUES ('8', 'Владислав', 'Лючок',  'Андреевич', '2');
INSERT INTO `student` VALUES ('9', 'Кирилл', 'Карасев', 'Владимирович', '2');
INSERT INTO `student` VALUES ('10', 'Алексей', 'Неудачнов', 'Викторович', '2');
INSERT INTO `student` VALUES ('11', 'Павел', 'Чемоданов', 'Сергеевич', '3');
INSERT INTO `student` VALUES ('12', 'Азиз', 'Жебали', 'Амогусович', '3');
INSERT INTO `student` VALUES ('13', 'Павел', 'Бедрик', 'Кишиневскович', '3');
INSERT INTO `student` VALUES ('14', 'Максим', 'Знаешев', 'Вадимович', '3');
INSERT INTO `student` VALUES ('15', 'Вадим', 'Астапов', 'Попускович', '3');
INSERT INTO `student` VALUES ('16', 'Дмитрий', 'Журавлев', 'Неважнович', '4');
INSERT INTO `student` VALUES ('17', 'Антов', 'Дубов', 'Малинкович', '4');
INSERT INTO `student` VALUES ('18', 'Михаил', 'Громов', 'Михайлович', '4');
INSERT INTO `student` VALUES ('19', 'Демид', 'Помидорков', 'Алексеевич', '4');
INSERT INTO `student` VALUES ('20', 'Дмитрий', 'Грекав', 'Токсовович', '4');

INSERT INTO `discipline` VALUES ('1', 'Высшая математика');
INSERT INTO `discipline` VALUES ('2', 'Основы алгоритмизации и программирования');
INSERT INTO `discipline` VALUES ('3', 'Специальные главы высшей математики');
INSERT INTO `discipline` VALUES ('4', 'Физика');
INSERT INTO `discipline` VALUES ('5', 'Электронные приборы');

INSERT INTO `exam` VALUES ('1', '6', '2020-12-25', '1', '1');
INSERT INTO `exam` VALUES ('2', '10', '2020-12-26', '2', '1');
INSERT INTO `exam` VALUES ('3', '4', '2020-12-27', '3', '1');
INSERT INTO `exam` VALUES ('4', '6', '2020-12-25', '1', '2');
INSERT INTO `exam` VALUES ('5', '5', '2020-12-26', '2', '2');
INSERT INTO `exam` VALUES ('6', '4', '2020-12-27', '3', '2');
INSERT INTO `exam` VALUES ('7', '4', '2020-12-25', '1', '3');
INSERT INTO `exam` VALUES ('8', '4', '2020-12-26', '2', '3');
INSERT INTO `exam` VALUES ('9', '3', '2020-12-27', '3', '3');
INSERT INTO `exam` VALUES ('10', '5', '2020-12-25', '1', '4');
INSERT INTO `exam` VALUES ('11', '10', '2020-12-26', '2', '4');
INSERT INTO `exam` VALUES ('12', '4', '2020-12-27', '3', '4');
INSERT INTO `exam` VALUES ('13', '6', '2020-12-25', '1', '5');
INSERT INTO `exam` VALUES ('14', '10', '2020-12-26', '2', '5');
INSERT INTO `exam` VALUES ('15', '4', '2020-12-27', '3', '5');
INSERT INTO `exam` VALUES ('16', '4', '2020-12-23', '3', '6');
INSERT INTO `exam` VALUES ('17', '6', '2020-12-24', '4', '6');
INSERT INTO `exam` VALUES ('18', '6', '2020-12-25', '5', '6');
INSERT INTO `exam` VALUES ('19', '4', '2020-12-23', '3', '7');
INSERT INTO `exam` VALUES ('20', '8', '2020-12-24', '4', '7');
INSERT INTO `exam` VALUES ('21', '6', '2020-12-25', '5', '7');
INSERT INTO `exam` VALUES ('22', '4', '2020-12-23', '3', '8');
INSERT INTO `exam` VALUES ('23', '8', '2020-12-24', '4', '8');
INSERT INTO `exam` VALUES ('24', '6', '2020-12-25', '5', '8');
INSERT INTO `exam` VALUES ('25', '4', '2020-12-23', '3', '9');
INSERT INTO `exam` VALUES ('26', '9', '2020-12-24', '4', '9');
INSERT INTO `exam` VALUES ('27', '7', '2020-12-25', '5', '9');
INSERT INTO `exam` VALUES ('28', '2', '2020-12-23', '3', '10');
INSERT INTO `exam` VALUES ('29', '2', '2020-12-24', '4', '10');
INSERT INTO `exam` VALUES ('30', '2', '2020-12-25', '5', '10');
INSERT INTO `exam` VALUES ('31', '7', '2021-12-25', '1', '11');
INSERT INTO `exam` VALUES ('32', '7', '2021-12-26', '2', '11');
INSERT INTO `exam` VALUES ('33', '4', '2021-12-27', '3', '11');
INSERT INTO `exam` VALUES ('34', '8', '2021-12-25', '1', '12');
INSERT INTO `exam` VALUES ('35', '8', '2021-12-26', '2', '12');
INSERT INTO `exam` VALUES ('36', '4', '2021-12-27', '3', '12');
INSERT INTO `exam` VALUES ('37', '6', '2021-12-25', '1', '13');
INSERT INTO `exam` VALUES ('38', '6', '2021-12-26', '2', '13');
INSERT INTO `exam` VALUES ('39', '4', '2021-12-27', '3', '13');
INSERT INTO `exam` VALUES ('40', '8', '2021-12-25', '1', '14');
INSERT INTO `exam` VALUES ('41', '8', '2021-12-26', '2', '14');
INSERT INTO `exam` VALUES ('42', '4', '2021-12-27', '3', '14');
INSERT INTO `exam` VALUES ('43', '9', '2021-12-25', '1', '15');
INSERT INTO `exam` VALUES ('44', '9', '2021-12-26', '2', '15');
INSERT INTO `exam` VALUES ('45', '4', '2021-12-27', '3', '15');
INSERT INTO `exam` VALUES ('46', '4', '2021-12-23', '3', '16');
INSERT INTO `exam` VALUES ('47', '8', '2021-12-24', '4', '16');
INSERT INTO `exam` VALUES ('48', '7', '2021-12-25', '5', '16');
INSERT INTO `exam` VALUES ('49', '4', '2021-12-23', '3', '17');
INSERT INTO `exam` VALUES ('50', '6', '2021-12-24', '4', '17');
INSERT INTO `exam` VALUES ('51', '7', '2021-12-25', '5', '17');
INSERT INTO `exam` VALUES ('52', '4', '2021-12-23', '3', '18');
INSERT INTO `exam` VALUES ('53', '10', '2021-12-24', '4', '18');
INSERT INTO `exam` VALUES ('54', '4', '2021-12-25', '5', '18');
INSERT INTO `exam` VALUES ('55', '4', '2021-12-23', '3', '19');
INSERT INTO `exam` VALUES ('56', '8', '2021-12-24', '4', '19');
INSERT INTO `exam` VALUES ('57', '6', '2021-12-25', '5', '19');
INSERT INTO `exam` VALUES ('58', '4', '2021-12-23', '3', '20');
INSERT INTO `exam` VALUES ('59', '8', '2021-12-24', '4', '20');
INSERT INTO `exam` VALUES ('60', '6', '2021-12-25', '5', '20');