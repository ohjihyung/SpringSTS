package org.hdcd.mapper;

import java.util.List;

import org.hdcd.vo.NoticeVO;
import org.hdcd.vo.PaginationInfoVO;

public interface INoticeMapper {
	public int insertNotice(NoticeVO noticeVO);
	public int selectNoticeCount(PaginationInfoVO<NoticeVO> pagingVO);
	public List<NoticeVO> selectNoticeList(PaginationInfoVO<NoticeVO> pagingVO);
	public void incrementHit(int boNo);
	public NoticeVO selectNotice(int boNo);
	public int updateNotice(NoticeVO noticeVO);
	public int deleteNotice(int boNo);
}
