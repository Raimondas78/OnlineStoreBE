CREATE TABLE category (
                          id BIGINT NOT NULL AUTO_INCREMENT,
                          name varchar(256) NOT NULL,
                          parent_id BIGINT,
                          PRIMARY KEY (id),
                          constraint fk_category  FOREIGN KEY (parent_id)
                              references category (id) on update cascade on delete restrict
)  ENGINE=INNODB DEFAULT CHARSET=UTF8MB4;
