use enotes_management;

CREATE TABLE user (
  id bigint PRIMARY KEY auto_increment,
  full_name VARCHAR(45) NOT NULL,
  email VARCHAR(45) unique NOT NULL,
  password VARCHAR(45) NOT NULL,
  created_date TIMESTAMP NULL,
  modified_date TIMESTAMP NULL,
  created_by VARCHAR(45) NULL,
  modified_by VARCHAR(45) NULL
);

CREATE TABLE note (
  id bigint PRIMARY KEY auto_increment,
  title VARCHAR(255) NOT NULL,
  content text NOT NULL,
  user_id bigint NOT NULL,
  created_date TIMESTAMP NULL,
  modified_date TIMESTAMP NULL,
  created_by VARCHAR(45) NULL,
  modified_by VARCHAR(45) NULL
);


ALTER TABLE note ADD CONSTRAINT fk_post_user FOREIGN KEY(user_id) REFERENCES user(id);