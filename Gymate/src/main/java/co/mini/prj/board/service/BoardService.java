package co.mini.prj.board.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface BoardService {
	List<BoardVO> boardSelectList(String str, String searchMenu, String searchVal);
//	List<BoardVO> boardSelectList(int lownum, int highnum, String searchMenu, String searchVal);

//	int boardCount();

	List<BoardVO> boardNoticeSelect();

	BoardVO boardSelect(BoardVO vo);

	int boardInsert(BoardVO vo);

	int boardUpdate(BoardVO vo);

	int boardDelete(BoardVO vo);

	void boardHitUpdate(int num);

	int boardGoodExist(int boardNum, int memberNum);

	int boardGoodInsert(int boardNum, int memberNum);

	int boardGoodDelete(int boardNum, int memberNum);

	void boardGoodDeleteAll(int num);

	//
	List<BoardVO> boardSearchList(String key, String val);
}
