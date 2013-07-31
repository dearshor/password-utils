package org.fkjava.security.password.utils;

/**
 * 密码生成请求
 *
 * @author lwq
 */
public class PasswordGeneratRequest {

    /**
     * 域名
     */
    private String domainName;
    /**
     * 安全问题
     */
    private String securityQuestion;
    /**
     * 安全答案
     */
    private String securityAnswer;
    /**
     * 生日
     */
    private String birthday;
    /**
     * 生成的密码的长度
     */
    private String passwordLength;

    /**
     * 域名
     *
     * @return the domainName
     */
    public String getDomainName() {
        return domainName;
    }

    /**
     * 域名
     *
     * @param domainName the domainName to set
     */
    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    /**
     * 安全问题
     *
     * @return the securityQuestion
     */
    public String getSecurityQuestion() {
        return securityQuestion;
    }

    /**
     * 安全问题
     *
     * @param securityQuestion the securityQuestion to set
     */
    public void setSecurityQuestion(String securityQuestion) {
        this.securityQuestion = securityQuestion;
    }

    /**
     * 安全答案
     *
     * @return the securityAnswer
     */
    public String getSecurityAnswer() {
        return securityAnswer;
    }

    /**
     * 安全答案
     *
     * @param securityAnswer the securityAnswer to set
     */
    public void setSecurityAnswer(String securityAnswer) {
        this.securityAnswer = securityAnswer;
    }

    /**
     * 生日
     *
     * @return the birthday
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * 生日
     *
     * @param birthday the birthday to set
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /**
     * 生成的密码的长度
     *
     * @return the passwordLength
     */
    public String getPasswordLength() {
        return passwordLength;
    }

    /**
     * 生成的密码的长度
     *
     * @param passwordLength the passwordLength to set
     */
    public void setPasswordLength(String passwordLength) {
        this.passwordLength = passwordLength;
    }
}
