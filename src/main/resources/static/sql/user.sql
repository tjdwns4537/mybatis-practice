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

/** INSERT user **/

INSERT INTO users(
    user_name, user_email, user_password, create_at, modified_at
    ) VALUES (
    'test','test@com','test123','2023-08-10','2023-08-10'
    );
