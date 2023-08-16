-- Exported from QuickDBD: https://www.quickdatabasediagrams.com/
-- Link to schema: https://app.quickdatabasediagrams.com/#/d/nIMrom
-- NOTE! If you have used non-SQL datatypes in your design, you will have to change these here.


CREATE TABLE `user` (
    `user_id` int  NOT NULL ,
    `board_id` int  NOT NULL ,
    `user_name` varchar(64)  NOT NULL ,
    `user_email` varchar(128)  NOT NULL ,
    `user_password` varchar(128)  NOT NULL ,
    `create_at` timestamp  NOT NULL ,
    `create_by` varchar(64)  NOT NULL ,
    `modified_at` timestamp  NOT NULL ,
    `modified_by` varchar(64)  NOT NULL ,
    PRIMARY KEY (
        `user_id`
    )
);

CREATE TABLE `board` (
    `board_id` int  NOT NULL ,
    `user_id` int  NOT NULL ,
    `categories_id` int  NOT NULL ,
    `comment_id` int  NOT NULL ,
    `board_title` varchar(128)  NOT NULL ,
    `board_content` longtext  NOT NULL ,
    `create_at` timestamp  NOT NULL ,
    `create_by` varchar(64)  NOT NULL ,
    `modified_at` timestamp  NOT NULL ,
    `modified_by` varchar(64)  NOT NULL ,
    PRIMARY KEY (
        `board_id`
    )
);

CREATE TABLE `categories` (
    `categories_id` int  NOT NULL ,
    `categories_name` varchar(32)  NOT NULL ,
    PRIMARY KEY (
        `categories_id`
    )
);

CREATE TABLE `comment` (
    `comment_id` int  NOT NULL ,
    `user_id` int  NOT NULL ,
    `comment_content` varchar(128)  NOT NULL ,
    `create_at` timestamp  NOT NULL ,
    `create_by` varchar(64)  NOT NULL ,
    `modified_at` timestamp  NOT NULL ,
    `modified_by` varchar(64)  NOT NULL ,
    PRIMARY KEY (
        `comment_id`
    )
);

ALTER TABLE `user` ADD CONSTRAINT `fk_user_board_id` FOREIGN KEY(`board_id`)
REFERENCES `board` (`board_id`);

ALTER TABLE `board` ADD CONSTRAINT `fk_board_user_id` FOREIGN KEY(`user_id`)
REFERENCES `user` (`user_id`);

ALTER TABLE `board` ADD CONSTRAINT `fk_board_categories_id` FOREIGN KEY(`categories_id`)
REFERENCES `categories` (`categories_id`);

ALTER TABLE `board` ADD CONSTRAINT `fk_board_comment_id` FOREIGN KEY(`comment_id`)
REFERENCES `comment` (`comment_id`);

ALTER TABLE `comment` ADD CONSTRAINT `fk_comment_user_id` FOREIGN KEY(`user_id`)
REFERENCES `user` (`user_id`);

