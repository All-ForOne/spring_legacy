INSERT INTO `spring`.`user` (`id`, `password`, `name`, `reg_dt`, `mod_dt`) VALUES ('abc@abc.co.kr', '1234', '신비', '20220203', '20220203');
INSERT INTO `spring`.`user` (`id`, `password`, `name`, `reg_dt`, `mod_dt`) VALUES ('def@abc.co.kr', '1234', '금비', '2022-02-03', '2022-02-03');

INSERT INTO `spring`.`menu` (`id`, `name`, `reg_dt`, `mod_dt`, `use_yn`, `order`) VALUES ('100', '번호 생성기', '2022-02-03', '2022-02-03', 'Y', '10');
INSERT INTO `spring`.`menu` (`id`, `name`, `top_id`, `reg_dt`, `mod_dt`, `use_yn`, `order`) VALUES ('200', '나의 로또', '', '2022-02-03', '2022-02-03', 'Y', '20');
INSERT INTO `spring`.`menu` (`id`, `name`, `top_id`, `reg_dt`, `mod_dt`, `use_yn`, `order`) VALUES ('300', '당첨 번호', '', '2022-02-03', '2022-02-03', 'Y', '30');