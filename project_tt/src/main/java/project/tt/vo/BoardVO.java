package project.tt.vo;

import java.util.Date;

import lombok.Data;
@Data
public class BoardVO {
	private int rno; //마이페이지 자세히보기
	private int bno;  //글번호
	private String title; // 제목
	private String content; // 내용
	private String user_nickname; //닉네임
	private Date date; //날짜
	private int good; //좋아요
	private int bad; //싫어요
	private int view_count; //조회수
	private int mypage_count;

}
