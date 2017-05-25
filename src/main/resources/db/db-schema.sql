CREATE TABLE IF NOT EXISTS `tb_user` (
  `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
  `code` VARCHAR(40) NOT NULL UNIQUE ,
  `name` VARCHAR(120) NOT NULL ,
  `gender` VARCHAR(10) NOT NULL,
  `birthday` DATE NOT NULL,
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP(),
  `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP() ON UPDATE CURRENT_TIMESTAMP(),
  `delete_time` TIMESTAMP NULL
);

CREATE TABLE IF NOT EXISTS `tb_exam` (
  `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
  `code` VARCHAR(40) NOT NULL UNIQUE ,
  `subject` VARCHAR(240) NOT NULL ,
  `begin_time` TIMESTAMP DEFAULT NOW(),
  `end_time` TIMESTAMP DEFAULT NOW(),
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP(),
  `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP() ON UPDATE CURRENT_TIMESTAMP(),
  `delete_time` TIMESTAMP NULL
);
