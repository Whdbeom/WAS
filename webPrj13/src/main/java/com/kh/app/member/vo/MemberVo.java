package com.kh.app.member.vo;

public class MemberVo {

	
	
	
	public MemberVo(String memberId, String memberPwd, String memberNick) {
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.memberNick = memberNick;
	}
	public MemberVo() {
	}
	private String memberId;
	private String memberPwd;
	private String memberPwd2;
	private String memberNick;
	
	
	public String getMemberPwd2() {
		return memberPwd2;
	}
	public void setMemberPwd2(String memberPwd2) {
		this.memberPwd2 = memberPwd2;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPwd() {
		return memberPwd;
	}
	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}
	public String getMemberNick() {
		return memberNick;
	}
	public void setMemberNick(String memberNick) {
		this.memberNick = memberNick;
	}
	@Override
	public String toString() {
		return "MemberVo [memberId=" + memberId + ", memberPwd=" + memberPwd + ", memberNick=" + memberNick + "]";
	}
	
	
	
}
