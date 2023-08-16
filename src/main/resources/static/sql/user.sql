/** CREATE user **/

CREATE TABLE user(
                     user_id INT NOT NULL AUTO_INCREMENT,
                     user_name VARCHAR(64),
                     user_email VARCHAR(128),
                     user_password VARCHAR(128),
                     create_at TIMESTAMP,
                     modified_At TIMESTAMP,
                     PRIMARY KEY(user_id)
)