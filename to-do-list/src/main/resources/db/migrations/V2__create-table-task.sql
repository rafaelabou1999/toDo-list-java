CREATE TABLE task (
    id BIGINT NOT NULL AUTO_INCREMENT,
    title VARCHAR(80) NOT NULL,
    description VARCHAR(100),
    is_completed BOOLEAN NOT NULL DEFAULT FALSE,
    user_id BIGINT NOT NULL,

    PRIMARY KEY (id),

    CONSTRAINT fk_task_user
        FOREIGN KEY (user_id)
        REFERENCES users(id)
        ON DELETE CASCADE
);