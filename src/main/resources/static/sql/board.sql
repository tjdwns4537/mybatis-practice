CREATE TABLE boards(
                       board_id INT NOT NULL AUTO_INCREMENT,
                       board_title VARCHAR(256),
                       board_content LONGTEXT,
                       create_at TIMESTAMP,
                       modify_at TIMESTAMP,
                       PRIMARY KEY(board_id)
)

