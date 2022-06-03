package com.eb.datatables.paging.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.eb.datatables.paging.service.PaginationInfo;
import com.eb.datatables.paging.service.PagingService;
import com.eb.datatables.vo.CompleteInfo;
import com.eb.datatables.vo.DatatableDto;
import com.eb.datatables.vo.DatatableParam;

@Controller
public class PagingController {

	private PagingService pagingService;

	public PagingController(PagingService pagingService) {
		this.pagingService = pagingService;
	}

	@GetMapping("/paging")
	public ModelAndView paging(DatatableParam param, @RequestParam(value="pageNo", required=false) String pageNo) {
		int draw = param.getDraw();

		String currentPage = (pageNo == null) ? "1" : pageNo;

		ModelAndView mav = new ModelAndView();

		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(Integer.parseInt(currentPage)); //현재 페이지 번호
		paginationInfo.setRecordCountPerPage(10); //한 페이지에 게시되는 게시물 건수
		paginationInfo.setPageSize(5); //페이징 리스트의 사이즈

		int total = pagingService.count();
		paginationInfo.setTotalRecordCount(total);
		paginationInfo.getFirstRecordIndex();
		paginationInfo.getRecordCountPerPage();

		DatatableDto<CompleteInfo> dto = pagingService.find(paginationInfo, draw);
		String render = pagingService.render(paginationInfo, "/paging?pageNo=", currentPage);

		mav.addObject("dto", dto);
		mav.addObject("render", render);

		mav.setViewName("paging");
		return mav;
	}
}
