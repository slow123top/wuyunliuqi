-- CREATE DATABASE IF NOT EXISTS `sinomed_dev` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

CREATE TABLE IF NOT EXISTS `user` (
  `uuid`                    VARCHAR(255) NOT NULL
  COLLATE 'utf8_unicode_ci',
  `account_non_expired`     BIT(1)       NOT NULL,
  `account_non_locked`      BIT(1)       NOT NULL,
  `credentials_non_expired` BIT(1)       NOT NULL,
  `display_name`            VARCHAR(255) NULL     DEFAULT NULL COLLATE 'utf8_unicode_ci',
  `enabled`                 BIT(1)       NOT NULL,
  `password_hash`           VARCHAR(255) NULL     DEFAULT NULL COLLATE 'utf8_unicode_ci',
  `role`                    VARCHAR(255) NULL     DEFAULT NULL COLLATE 'utf8_unicode_ci',
  `username`                VARCHAR(255) NOT NULL
  COLLATE 'utf8_unicode_ci',
  `add_time`                TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`uuid`)
)
  COLLATE = 'utf8_unicode_ci'
  ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `yao_cai` (
  `yao_cai_id`         VARCHAR(255) NOT NULL
  COLLATE 'utf8_unicode_ci',
  `gong_xiao`          VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8_unicode_ci',
  `gui_jing`           VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8_unicode_ci',
  `yao_ming`           VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8_unicode_ci',
  `yao_wei`            VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8_unicode_ci',
  `ying_yong`          VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8_unicode_ci',
  `yong_fa_yong_liang` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8_unicode_ci',
  PRIMARY KEY (`yao_cai_id`)
)
  COLLATE = 'utf8_unicode_ci'
  ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `yao_fang` (
  `yao_fang_id`          VARCHAR(255) NOT NULL
  COLLATE 'utf8_unicode_ci',
  `cheng_fen`            VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8_unicode_ci',
  `fang_jie`             VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8_unicode_ci',
  `fang_ming`            VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8_unicode_ci',
  `gong_xiao`            VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8_unicode_ci',
  `lin_chuang_ying_yong` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8_unicode_ci',
  `yong_fa`              VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8_unicode_ci',
  `zhu_yi_shi_xiang`     VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8_unicode_ci',
  `zhu_zhi`              VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8_unicode_ci',
  PRIMARY KEY (`yao_fang_id`)
)
  COLLATE = 'utf8_unicode_ci'
  ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `zhong_cheng_yao` (
  `zhong_cheng_yao_id` VARCHAR(255) NOT NULL
  COLLATE 'utf8_unicode_ci',
  `fu_yong_tian_shu`   VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8_unicode_ci',
  `gui_ge`             VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8_unicode_ci',
  `lei_bie`            VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8_unicode_ci',
  `pin_ming`           VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8_unicode_ci',
  `shi_yong_ren_qun`   VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8_unicode_ci',
  `tong_ming_jing_pin` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8_unicode_ci',
  `tong_xiao_chan_pin` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8_unicode_ci',
  `wen_hao_shu_liang`  VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8_unicode_ci',
  `yao_pin_lei_xing`   VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8_unicode_ci',
  `yong_fa_yong_liang` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8_unicode_ci',
  `zhu_yao_cheng_fen`  VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8_unicode_ci',
  PRIMARY KEY (`zhong_cheng_yao_id`)
)
  COLLATE = 'utf8_unicode_ci'
  ENGINE = InnoDB;
