package com.hito.chatlib.net.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Generated;

/**
 * description ：测试greenDAO
 * author : LENOVO
 * creation date: 2018/5/29 15:39
 */
@Entity
public class DAOTest {
    @Id
    private Long id;

    private String name;

    @Transient
    private int tempUsageCount; // not persisted

    @Generated(hash = 448629914)
    public DAOTest(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Generated(hash = 1460093321)
    public DAOTest() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
