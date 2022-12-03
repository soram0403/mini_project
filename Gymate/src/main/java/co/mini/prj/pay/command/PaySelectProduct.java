package co.mini.prj.pay.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.mini.prj.common.Command;
import co.mini.prj.product.service.ProductService;
import co.mini.prj.product.service.ProductVO;
import co.mini.prj.product.serviceImpl.ProductServiceImpl;
import co.mini.prj.service.PayService;
import co.mini.prj.service.PayVO;
import co.mini.prj.serviceImpl.PayServiceImpl;

public class PaySelectProduct implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		PayService dao = new PayServiceImpl();
		PayVO vo = new PayVO();
		vo.setPayNum(Integer.valueOf(request.getParameter("id")));
		vo = dao.paySelect(vo);
		System.out.println(vo.getPayNum());
		request.setAttribute("vo", vo);
		
		return "pay/paySelectProduct";
	}

}
