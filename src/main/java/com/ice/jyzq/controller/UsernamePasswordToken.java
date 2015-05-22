package com.ice.jyzq.controller;


/**
 * 用户和密码（包含验证码）令牌类
 */
public class UsernamePasswordToken extends org.apache.shiro.authc.UsernamePasswordToken {

	private static final long serialVersionUID = 1L;

    // 验证码
	private String captcha;
    private String dcname;
	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

    public String getDcname() {
        return dcname;
    }

    public void setDcname(String dcname) {
        this.dcname = dcname;
    }

    public UsernamePasswordToken() {
		super();
	}

	public UsernamePasswordToken(String username, char[] password,
			boolean rememberMe, String host, String captcha, String dcname) {
		super(username, password, rememberMe, host);
		this.captcha = captcha;
        this.dcname = dcname;
	}

}