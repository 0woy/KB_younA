DROP TABLE IF EXISTS tbl_board;

CREATE TABLE tbl_board(
    no  INTEGER AUTO_INCREMENT PRIMARY KEY,
    title   VARCHAR(200) NOT NULL,
    content TEXT,
    writer VARCHAR(50) NOT NULL,
    reg_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    update_date DATETIME DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO tbl_board(title, content,writer)
VALUES
    ('테스트 제목 1', '테스트 내용 1', 'user00'),
    ('테스트 제목 2', '테스트 내용 2', 'user02'),
    ('테스트 제목 3', '테스트 내용 3', 'user03'),
    ('테스트 제목 4', '테스트 내용 4', 'user04'),
    ('테스트 제목 5', '테스트 내용 5', 'user05');

SELECT * from tbl_board;


DROP TABLE IF EXISTS tbl_board_attachment;
CREATE TABLE tbl_board_attachment (
                                      no INTEGER AUTO_INCREMENT PRIMARY KEY,
                                      filename VARCHAR(256) NOT NULL, -- 원본 파일 명
                                      path VARCHAR(256) NOT NULL, -- 서버에서의 파일 경로
                                      content_type VARCHAR(56), -- content-type
                                      size INTEGER, -- 파일의 크기
                                      bno INTEGER NOT NULL, -- 게시글 번호, FK
                                      reg_date DATETIME DEFAULT now(),
                                      CONSTRAINT FOREIGN KEY(bno) REFERENCES tbl_board(no)
);
show tables;