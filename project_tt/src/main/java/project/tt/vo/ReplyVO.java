package project.tt.vo;

import java.sql.Date;

import lombok.Data;
@Data
public class ReplyVO {
	
	private int no; //댓글 순서번호 
	private int rno; //댓글 고유번호
	private int bno; // 게시물 고유번호 
	private String reply_content;// 댓글 내용
	private String user_nickname;// 닉네임
	private String reply_date;// 댓글 작성날짜
	
}
