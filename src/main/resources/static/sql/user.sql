/** CREATE user **/

CREATE TABLE users(
                     user_id INT NOT NULL AUTO_INCREMENT,
                     user_name VARCHAR(64),
                     user_email VARCHAR(128),
                     user_password VARCHAR(128),
                     create_at TIMESTAMP,
                     modify_At TIMESTAMP,
                     PRIMARY KEY(user_id)
)

/** INSERT user **/

INSERT INTO users(
    user_name, user_email, user_password, create_at, modified_at
    ) VALUES (
    'test','test@com','test123','2023-08-10','2023-08-10'
    );


/** EDIT column **/

ALTER TABLE users MODIFY COLUMN user_name varchar(32) not null;

ALTER TABLE users MODIFY COLUMN user_email varchar(128) not null;

ALTER TABLE users MODIFY COLUMN user_password varchar(64) not null;

ALTER TABLE users MODIFY COLUMN create_at varchar(64) not null;

ALTER TABLE users MODIFY COLUMN modify_At varchar(64) null;

ALTER TABLE users CHANGE modify_At modify_at TIMESTAMP;


/****/