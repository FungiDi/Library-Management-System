package Entities;

import javax.persistence.*;


@MappedSuperclass
public class Staff extends Person{

    private String staffregNo;


    public String getStaffregNo() {
        return staffregNo;
    }

    public void setStaffregNo(String staffregNo) {
        this.staffregNo = staffregNo;
    }
}
