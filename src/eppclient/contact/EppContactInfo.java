/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eppclient.contact;

public class EppContactInfo {

    private String contactId;
    private String roid;
//        List<String> statusList
    private String name;
    private String org;
    private String locStreet1;
    private String locStreet2;
    private String locStreet3;
    private String sp;
    private String pc;
    private String cc;
    private String voice;
    private String fax;
    private String email;

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    public String getRoid() {
        return roid;
    }

    public void setRoid(String roid) {
        this.roid = roid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public String getLocStreet1() {
        return locStreet1;
    }

    public void setLocStreet1(String locStreet1) {
        this.locStreet1 = locStreet1;
    }

    public String getLocStreet2() {
        return locStreet2;
    }

    public void setLocStreet2(String locStreet2) {
        this.locStreet2 = locStreet2;
    }

    public String getLocStreet3() {
        return locStreet3;
    }

    public void setLocStreet3(String locStreet3) {
        this.locStreet3 = locStreet3;
    }

    public String getSp() {
        return sp;
    }

    public void setSp(String sp) {
        this.sp = sp;
    }

    public String getPc() {
        return pc;
    }

    public void setPc(String pc) {
        this.pc = pc;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getVoice() {
        return voice;
    }

    public void setVoice(String voice) {
        this.voice = voice;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "EppContactInfo{" + "contactId=" + contactId + ", roid=" + roid + ", name=" + name + ", org=" + org + ", locStreet1=" + locStreet1 + ", locStreet2=" + locStreet2 + ", locStreet3=" + locStreet3 + ", sp=" + sp + ", pc=" + pc + ", cc=" + cc + ", voice=" + voice + ", fax=" + fax + ", email=" + email + '}';
    }

    
}
