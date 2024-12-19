package com.quangbach1709.globits_rest_api.DTO;

public class UserDTO {
    private String email;
    private String password;
    private boolean isActive;
    private Long personId;

    public UserDTO() {
    }

    public UserDTO(String email, String password, boolean isActive, Long personId) {
        this.email = email;
        this.password = password;
        this.isActive = isActive;
        this.personId = personId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }
}
