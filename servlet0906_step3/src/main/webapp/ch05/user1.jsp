<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "test.User" %>
<%
	User info = new User();
	info.setName("홍말자");	//jsp:setProperty name ="info" (객체이름) property(멤버변수/name)
	info.setNum(7);			//jsp:setProperty name ="info" (객체이름) property(멤버변수/num)
	//속성, attribute, property, 필드 field, 멤버변수, 칼럼 <- 동일한 뜻
%>
<HTML>
<BODY>
<CENTER>
 <TABLE border=0 width=300 >
  <FORM method="POST">
   <TR>
    <TH bgcolor=#996699 colspan=2>
     <FONT color=white size=+1>JSP Beans테스트</FONT>
    </TH>
   </TR>
   <TR>
    <TH width=20% bgcolor=#BB6699 width=40% >
     <FONT color=white size=-1>이름</FONT>
    </TH>
    <TD bgcolor=#99ccff width=60%>
     <INPUT type=text name="name" value=<%=info.getName()%> size=10>
    </TD>
   </TR>
   <TR>
    <TH width=40% bgcolor=#BB6699 >
     <FONT color=white size=-1>학번</FONT>
    </TH>
    <TD bgcolor=#99ccff>
     <INPUT type=text name="id" value=<%=info.getNum()%>  size=10>
    </TD>
   </TR>
   <TR>
    <TD colspan=2>
     <INPUT type=submit value=" 보내기 "  >
     <INPUT type=reset value=" 다시쓰기 " >
    </TD>
   </TR>
  </FORM>
 </TABLE>
</CENTER>
<jsp:include page="setget.jsp"></jsp:include>
</BODY>
</HTML>
