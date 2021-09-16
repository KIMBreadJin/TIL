package com.green.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
	@Select("select sysdate from dual")
	public String getTime();
	
	@Select("select dummy from dual")
	public String a();
	
	@Select("select TO_CHAR(sysdate, 'HH:MI:SS') from dual")
	public String stime();
	
	@Select("select sysdate+ 10 from dual")
	public String timeplus();
	
	public String getTime2();
	
	
	

}
