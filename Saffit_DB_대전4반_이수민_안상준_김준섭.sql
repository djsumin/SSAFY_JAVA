
use ssafit;
create table IF NOT EXISTS `video` (
#기본 키 는 id
	`video_id` INT not null PRIMARY KEY,
    `title` varchar(1000) not null,
    `youtube` varchar(1000) not null,
    `fit_path_name` varchar(1000) not null,
    `view_cnt` INT not null default 0,
    `thumbnail` varchar(1000) not null
)engine = InnoDB;

create table IF NOT EXISTS `review`(
#기본 키 는 id
	`video_id` INT not null,
    `id` INT not null,
    `title` varchar(1000) not null,
    `writer` varchar(1000) not null,
    `content` varchar(1000) not null,
    `reg_date` DATETIME not null,
    `view_cnt` INT not null default 0,
     PRIMARY KEY(video_id , id),
    CONSTRAINT `fk_review_board`
		FOREIGN KEY (`video_id`)
        REFERENCES `video` (`video_id`)
        on delete cascade
        on update cascade
    
)engine = InnoDB;

SELECT * from video;
SELECT * from review;

INSERT INTO `video` -- (video_id, title, youtube, fit_path_name, view_cnt, thumbnail)
VALUES (1, '전신 다이어트 최고의 운동 [칼소폭 찐 핵핵매운맛]', 'https://www.youtube.com/embed/gMaB-fG4u4g','전신',0,'https://i.ytimg.com/vi/gMaB-fG4u4g/hq720.jpg?sqp=-oaymwEcCOgCEMoBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLBktn6EJzGGJi8A4QP2q94wm6HQsA'),
		(2, '하루 15분! 전신 칼로리 불태우는 다이어트 운동', 'https://www.youtube.com/embed/gMaB-fG4u4g','전신',0,'https://i.ytimg.com/vi/swRNeYw1JkY/hq720.jpg?sqp=-oaymwEcCOgCEMoBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLAAq-j4TdvhslAn2prOcl-dSilqIw'),
		(3, '상체 다이어트 최고의 운동 BEST [팔뚝살/겨드랑이살/등살/가슴어깨라인]', 'https://www.youtube.com/embed/gMaB-fG4u4g','상체',0,'https://i.ytimg.com/vi/54tTYO-vU2E/hq720.jpg?sqp=-oaymwEcCOgCEMoBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLAhnbdzdcAYVXKnIawrzrNn0-M8bw'),
		(4, '상체비만 다이어트 최고의 운동 [상체 핵매운맛]', 'https://www.ytitletitleoutube.com/embed/gMaB-fG4u4g','상체',0,'https://i.ytimg.com/vi/QqqZH3j_vH0/hq720.jpg?sqp=-oaymwEcCOgCEMoBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLAaXLYEdfaGVax3bkKlrg7wGz5_VQ'),
		(5, '하체운동이 중요한 이유? 이것만 보고 따라하자 ! [하체운동 교과서]', 'https://www.youtube.com/embed/gMaB-fG4u4g','하체',0,'https://i.ytimg.com/vi/tzN6ypk6Sps/hq720.jpg?sqp=-oaymwEcCOgCEMoBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLCWpJ6XDz0j1zs5RGLoeUIqixgZiA'),
		(6, '저는 하체 식주의자 입니다', 'https://www.youtube.com/embed/gMaB-fG4u4g','하체',0,'https://i.ytimg.com/vi/u5OgcZdNbMo/hq720.jpg?sqp=-oaymwEcCOgCEMoBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLBYl4fWsNyGzdcTsI9g1rdmAiMLEw'),
		(7, '11자복근 복부 최고의 운동 [복근 핵매운맛]', 'https://www.youtube.com/embed/gMaB-fG4u4g','복부',0,'https://i.ytimg.com/vi/PjGcOP-TQPE/hq720.jpg?sqp=-oaymwEcCOgCEMoBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLA51ZI-4HksPMwVBzADC-HC_SariA'),
		(8, '(Sub)누워서하는 5분 복부운동!! 효과보장! (매일 2주만 해보세요!)', 'https://www.youtube.com/embed/gMaB-fG4u4g','복부',0,'http://i.ytimg.com/vi/7TLk7pscICk/0.jpg');

# video에 값이 있어야 넣을 수 있다.
INSERT INTO `review` (video_id, id, title, writer, content, reg_date, view_cnt)
VALUES(1, 3, 'I dontknow222', 'jak22e', 'I said22 i dont know', '2023-10-14', 1);

# 조회
# review와 video의 id가 일치하는 부분 조회
SELECT 
    * 
from review A INNER JOIN video B
ON A.video_id = B.video_id;

# video와 review를 video_id 컬럼을 기준으로 하여 inner join한 후 해당하는 video테이블의 video.video_id, video.title, youtube 조회
SELECT video.video_id, video.title, youtube  FROM video INNER JOIN review ON video.video_id = review.video_id;