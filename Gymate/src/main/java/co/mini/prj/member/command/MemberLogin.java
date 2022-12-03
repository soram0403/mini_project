package co.mini.prj.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.mini.prj.common.Command;
import co.mini.prj.member.service.MemberService;
import co.mini.prj.member.service.MemberVO;
import co.mini.prj.member.service.MemberVOC;
import co.mini.prj.member.service.MemberVOCT;
import co.mini.prj.member.service.Impl.MemberServiceImpl;

public class MemberLogin implements Command {

   @Override
   public String exec(HttpServletRequest request, HttpServletResponse response) {
      HttpSession session = request.getSession();
      MemberService dao = new MemberServiceImpl();
      MemberVO vo = new MemberVO();
      MemberVOC voc = new MemberVOC();
      MemberVOCT voct = new MemberVOCT();
      String viewPage = "main/message";
      vo.setMemberId(request.getParameter("memberId"));
      vo.setMemberPw(request.getParameter("memberPw"));
      
      

      vo = dao.memberSelect(vo);
      if (vo != null) {
         
         if( vo.getMemberAuthor().equals("DELETED")) {
            request.setAttribute("message", "탈퇴한 계정입니다.");
            return viewPage;         
         }
         
         session.setAttribute("memberNum", vo.getMemberNum());
         session.setAttribute("memberId", vo.getMemberId());
         session.setAttribute("memberName", vo.getMemberName());
         session.setAttribute("memberNickName", vo.getMemberNickName());
         session.setAttribute("memberAge", vo.getMemberAge());
         session.setAttribute("memberTel", vo.getMemberTel());
         session.setAttribute("memberAuthor", vo.getMemberAuthor());
         session.setAttribute("message", vo.getMemberName() + "환영합니다.");
         
         
         voc = dao.memberSelectData(vo.getMemberNum());
         System.out.println("값" + voc);
         if (voc != null) {
            session.setAttribute("memberAddress", voc.getMemberAddress());
            session.setAttribute("memberHeight", voc.getMemberHeight());
            session.setAttribute("memberWeight", voc.getMemberWeight());
            session.setAttribute("memberGender", voc.getMemberGender());
         }
         voct = dao.memberSelectTr(vo.getMemberNum());
         if (voct != null) {
            session.setAttribute("trainerPrize", voct.getTrainerPrize());
            session.setAttribute("trainerCareer", voct.getTrainerCareer());
            session.setAttribute("trainerSns", voct.getTrainerSns());
         }
         viewPage = "main/main";
         
         }else {
                request.setAttribute("message", "아이디 또는 패스워드가 틀렸습니다.");

      }
         return viewPage;
   }

}