package com.example.demo.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mall_info")
public class Mall {
    @Id
    private String m_Id;
    @Column(length = 20)
    private String m_Name;
    @Column(length = 10)
    private String m_Category;

    public String getM_Id() {
        return m_Id;
    }

    public void setM_Id(String m_Id) {
        this.m_Id = m_Id;
    }

    public String getM_Name() {
        return m_Name;
    }

    public void setM_Name(String m_Name) {
        this.m_Name = m_Name;
    }

    public String getM_Category() {
        return m_Category;
    }

    public void setM_Category(String m_Category) {
        this.m_Category = m_Category;
    }
}
