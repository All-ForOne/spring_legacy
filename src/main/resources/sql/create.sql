CREATE TABLE `menu` (
  `id` varchar(10) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `url` varchar(45) DEFAULT NULL,
  `top_id` varchar(10) DEFAULT NULL,
  `reg_dt` datetime DEFAULT NULL,
  `mod_dt` datetime DEFAULT NULL,
  `use_yn` varchar(1) DEFAULT 'N',
  `orders` int DEFAULT '0',
  PRIMARY KEY (`id`)
);
