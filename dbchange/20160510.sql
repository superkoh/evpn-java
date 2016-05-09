/* 上午12:08:37 10.211.55.6 evpn */ ALTER TABLE `banner` ADD `online_time` DATETIME  NOT NULL  AFTER `link_url`;
/* 上午12:08:46 10.211.55.6 evpn */ ALTER TABLE `banner` ADD `offline_time` DATETIME  NOT NULL  AFTER `online_time`;
