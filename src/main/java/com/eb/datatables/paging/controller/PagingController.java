package com.eb.datatables.paging.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.eb.datatables.paging.service.PaginationInfo;
import com.eb.datatables.paging.service.PagingService;
import com.eb.datatables.vo.CompleteInfo;

@Controller
public class PagingController {

	private PagingService pagingService;

	public PagingController(PagingService pagingService) {
		this.pagingService = pagingService;
	}

	@GetMapping("/paging")
	public ModelAndView paging(@RequestParam(value="pageNo", required=false) String pageNo) {

		if (pageNo == null) {
			pageNo = "1";
		}

		ModelAndView mav = new ModelAndView();

		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(Integer.parseInt(pageNo)); //현재 페이지 번호
		paginationInfo.setRecordCountPerPage(10); //한 페이지에 게시되는 게시물 건수
		paginationInfo.setPageSize(8); //페이징 리스트의 사이즈

		int total = pagingService.count();
		paginationInfo.setTotalRecordCount(total);

		int firstRecordIndex = paginationInfo.getFirstRecordIndex();
		int recordCountPerPage = paginationInfo.getRecordCountPerPage();

		mav.addObject("firstIndex", firstRecordIndex);
		mav.addObject("recordCountPerPage", recordCountPerPage);

		List<CompleteInfo> list = pagingService.find(paginationInfo);
		String render = pagingService.render(paginationInfo, "/paging?pageNo=", pageNo);

		mav.addObject("list", list);
		mav.addObject("render", render);

		//mav.addObject("paginationInfo", paginationInfo);

		mav.setViewName("paging");
		return mav;
	}
}
