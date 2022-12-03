package co.mini.prj.product.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.mini.prj.common.Command;
import co.mini.prj.product.service.ProductService;
import co.mini.prj.product.service.ProductVO;
import co.mini.prj.product.serviceImpl.ProductServiceImpl;

public class ProductSelect implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 제품 상세 조회

		ProductService dao = new ProductServiceImpl();
		ProductVO vo = new ProductVO();
		vo.setProductNum(Integer.valueOf(request.getParameter("num")));
		vo=dao.productSelect(vo); //검색결과 얻기
		if (vo != null) {
			dao.productHitUpdate(vo.getProductNum()); // 조회수 증가
			request.setAttribute("product", vo); // 페이지에 전달하기 위해
	
		}
		
		return "product/productSelect";
	}

}
