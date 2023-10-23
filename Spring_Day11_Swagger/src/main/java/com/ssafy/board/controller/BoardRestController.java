package com.ssafy.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.board.model.dto.Board;
import com.ssafy.board.model.dto.SearchCondition;
import com.ssafy.board.model.service.BoardService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/api")
@Api(tags="게시판 컨트롤러")
@CrossOrigin("*")
public class BoardRestController {

	@Autowired
	private BoardService boardService;

	// 1. 목록(검색조건 있을 수도 있고 없을 수도 있다.)
	@GetMapping("/board")
	@ApiOperation(value="게시글조회", notes="검색조건도 넣으면 같이 가져온다.")
	public ResponseEntity<?> list(SearchCondition condition) {
//		List<Board> list = boardService.getList(); // 전체조회
		List<Board> list = boardService.search(condition); //검색조건이 있다면 그것으로 조회
		
		// 조건문의 단락평가(단축평가)
		if (list == null || list.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Board>>(list, HttpStatus.OK);

	}
	
	//2. 상세보기
	@GetMapping("/board/{id}")
	public ResponseEntity<Board> detail(@PathVariable int id){
		Board board = boardService.getBoard(id);
		//정석이라면 게시글 제목을 클릭해서 상세보기로 들어갈 거니까 여기서 마무리해도 된다.
		//꼭 주소창을 통해 접근하려고 하는 악의무리가 있기 때문에 만약 없는 값을 보냈을 때.. 처리를 해주어라.
		
		return new ResponseEntity<Board>(board, HttpStatus.OK);
	}
	
	//3. 등록
	@PostMapping("/baord")
	public ResponseEntity<Board> write(Board board){
		boardService.writeBoard(board);
		//id는 어차피 중복이 안되니까 무조건 게시글이 등록이 된다.
		//문제 발생해서 게시글이 등록이 안될 경우도 있다더라..
		//I/U/D 테이블의 행의 변환개수를 반환해주니까 이거를 이용해서 처리를 해볼 수도 있겠다.
		return new ResponseEntity<Board>(board, HttpStatus.CREATED);
	}
	
	//4. 삭제
	@DeleteMapping("/board/{id}")
	public ResponseEntity<Void> delete(@PathVariable int id){
		boardService.removeBoard(id);
		//반환값을 통해서 지워졌는지 안지워졌는지 체크
		// 이상한 값(id) 못하게 막던지
		// 다른사람도 요청 주소를 통해 내글을 지워버릴 수 있다. (권한 체크 -> 인터셉터)
		
		return new ResponseEntity<Void> (HttpStatus.OK);
	}
	
	//5-1. 수정
	@ApiIgnore
	@PutMapping("/board")
	//json 형태의 데이터로 넘어왔을 때 처리하고 싶으면?
	public ResponseEntity<Void> update(@RequestBody Board board){
		boardService.modifyBoard(board);
		//위와 같은 상황 대비
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
//	5-2.수정
//	@PutMapping("/board/{id}")
//	//json 형태의 데이터로 넘어왔을 때 처리하고 싶으면?
//	public ResponseEntity<Void> update(@RequestBody Board board, @PathVariable int id){
//		board.setId(id);
//		boardService.modifyBoard(board);
//		//위와 같은 상황 대비
//		
//		return new ResponseEntity<Void>(HttpStatus.OK);
//	}
	

	
}
