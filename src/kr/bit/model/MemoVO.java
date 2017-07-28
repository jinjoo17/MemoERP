package kr.bit.model;
import java.sql.Date;
public class MemoVO {
   private int mnum;
   private String mname;
   private String mcontent;
   private Date mday;
   public MemoVO(){  }
public MemoVO(String mname, String mcontent) {
	super();
	this.mname = mname;
	this.mcontent = mcontent;
}
public MemoVO(int mnum, String mname, String mcontent, Date mday) {
	super();
	this.mnum = mnum;
	this.mname = mname;
	this.mcontent = mcontent;
	this.mday = mday;
}
public int getMnum() {
	return mnum;
}
public void setMnum(int mnum) {
	this.mnum = mnum;
}
public String getMname() {
	return mname;
}
public void setMname(String mname) {
	this.mname = mname;
}
public String getMcontent() {
	return mcontent;
}
public void setMcontent(String mcontent) {
	this.mcontent = mcontent;
}
public Date getMday() {
	return mday;
}
public void setMday(Date mday) {
	this.mday = mday;
}
@Override
public String toString() {
	return "MemoVO [mnum=" + mnum + ", mname=" + mname + ", mcontent=" + mcontent + ", mday=" + mday + "]";
}
   
   
}
