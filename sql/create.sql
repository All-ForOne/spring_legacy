CREATE TABLE `menu` (
  `id` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `name` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `url` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `top_id` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `reg_dt` datetime DEFAULT NULL,
  `mod_dt` datetime DEFAULT NULL,
  `use_yn` varchar(1) COLLATE utf8mb4_unicode_ci DEFAULT 'N',
  `orders` int DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
