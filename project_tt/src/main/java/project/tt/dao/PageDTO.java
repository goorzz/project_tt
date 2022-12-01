package project.tt.dao;

import lombok.Data;
import lombok.ToString;

@Data
//@ToString //관련 필드의 값을 인쇄하는 것으로 구성된 모든 개체에 상속된 toString 메서드에 대한 구현을 생성합니다.
	public class PageDTO {
		/*페이지 번호 끝계산
		*endPage=(int)(Math.ceil(페이지번호/ 10.0))* 10;
		*페이지 시작번호
		*endPage= this.endPage-9;
		*/
		private int startPage; //시작페이지 
		private int endPage; // 끝페이지
		private boolean prev, next; // 이전 ,다음 페이지 
		
		private int totalpage; //전체 게시물 수
		private Criteria cri; // 현재 페이지, 페이지당 게시물 표시수 정보 
	
		public PageDTO(Criteria cri, int totalpage) { //Criteria 생성자정의  total 전체페이지수
			this.cri=cri;
			this.totalpage=totalpage;
			
		//마지막 페이지 
		endPage = (int)(Math.ceil(cri.getPageNum()/10.0))*10;
		
		//시작 페이지 
		startPage = this.endPage- 9;
		//10페이지가 일떄가 -9
		
		//전체페이지
		int RealEnd=(int)(Math.ceil((totalpage)*1.0/cri.getAmount()));
		
		//전체 마지막 페이지(realend)가 화면에 보이는 마지막 페이지(endpage)보다 작은경우에는  보이는 페이지 (endpage)값을 조정한다. 
		if(RealEnd<this.endPage) {
			endPage=RealEnd;
		}
			// 시작 페이지 (startpage)값이 1보다 큰경우 true
			this.prev=this.startPage>1;
			// 마지막 페이지(endpage)값이 1보다 큰 경우 ture
			this.next = this.endPage< RealEnd;
		}
		
}
