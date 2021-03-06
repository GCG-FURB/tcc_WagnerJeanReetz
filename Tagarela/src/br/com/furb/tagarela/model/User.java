package br.com.furb.tagarela.model;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table USER.
 */
public class User {

    private String email;
    private String name;
    private byte[] patientPicture;
    private Integer type;
    private Integer serverID;
    private Long id;

    public User() {
    }

    public User(Long id) {
        this.id = id;
    }

    public User(String email, String name, byte[] patientPicture, Integer type, Integer serverID, Long id) {
        this.email = email;
        this.name = name;
        this.patientPicture = patientPicture;
        this.type = type;
        this.serverID = serverID;
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getPatientPicture() {
        return patientPicture;
    }

    public void setPatientPicture(byte[] patientPicture) {
        this.patientPicture = patientPicture;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getServerID() {
        return serverID;
    }

    public void setServerID(Integer serverID) {
        this.serverID = serverID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
