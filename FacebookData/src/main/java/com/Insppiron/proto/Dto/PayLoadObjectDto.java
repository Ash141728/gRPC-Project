package com.Insppiron.proto.Dto;

public class PayLoadObjectDto {
    private int PeopleId;
    private String peopleName;
    private String city;

    public int getPeopleId() {
        return PeopleId;
    }

    public void setPeopleId(int peopleId) {
        PeopleId = peopleId;
    }

    public String getPeopleName() {
        return peopleName;
    }

    public void setPeopleName(String peopleName) {
        this.peopleName = peopleName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "PayLoadObjectDto{" +
                "PeopleId=" + PeopleId +
                ", peopleName='" + peopleName + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
