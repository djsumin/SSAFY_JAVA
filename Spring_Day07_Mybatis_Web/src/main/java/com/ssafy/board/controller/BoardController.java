package com.ssafy.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ssafy.board.model.dto.Board;
import com.ssafy.board.model.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;

//	@RequestMapping(value = "/", method = RequestMethod.GET)
	@GetMapping("/")
	public String index() {
		// 서비스 호출 -> Dao -> DB -> 쭉 뿌려준다?
		// 현재로써는 index.jsp인 대문페이지가 없어서 바로 리스트로 요청을 다시 하게끔 돌려보내기
		return "redirect:list";
	}

	@GetMapping("list")
	public String list(Model model) {
		List<Board> list = boardService.getList();
		model.addAttribute("list", list);
		return "/board/list";
	}

	@GetMapping("detail")
	public String detail(Model model, int id) {
		Board board = boardService.getBoard(id);
		model.addAttribute("board", board);

		return "/board/detail";
	}

	@GetMapping("writeform")
	public String writeform() {
		return "/board/writeform";
	}

	@PostMapping("write")
	public String write(Board board) {
		boardService.writeBoard(board);
		return "redirect:list";
	}

	@GetMapping("updateform")
	public String updateform(Model model, int id) {
		// 게시글 하나 읽어와서 모델에 실어놓고 폼으로 보내야겠다.
		// 현재로써는 게시글을 하나 얻어오면 조회수가 하나 증가해버려 ㅠㅜ 사실 잘못된거임
		model.addAttribute("board", boardService.getBoard(id));

		return "/board/updateform";
	}

	@PostMapping("update")
	public String update(Board board) {
		boardService.modifyBoard(board);
		return "redirect:detail?id="+board.getId();
	}

	@GetMapping("delete")
	public String delete(int id) {
		boardService.removeBoard(id);

		return "redirect:list";
	}

}
