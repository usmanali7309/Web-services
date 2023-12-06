package com.contact.ContactService.payload;

public class ContactDto {

    private long cId;
    private String email;
    private String contactName;
    private  int userId;


    public ContactDto() {
    }

    public ContactDto(long cId, String email, String contactName, int userId) {
        this.cId = cId;
        this.email = email;
        this.contactName = contactName;
        this.userId = userId;
    }

    public ContactDto(long cId, String email, String contactName) {
        this.cId = cId;
        this.email = email;
        this.contactName = contactName;
    }

    public long getcId() {
        return cId;
    }

    public void setcId(long cId) {
        this.cId = cId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
