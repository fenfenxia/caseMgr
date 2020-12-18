package com.city.oa.model;

import java.io.Serializable;

/**
 * @ClassName: AddrModel
 * @Description: TODO
 * @Author: xad
 * @Date: 2020/12/7 11:02
 */

public class PatientModel implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
    private String name;
    private Integer age;
    private  String sex;
    private Double weight;
    private Double height;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

	@Override
	public String toString() {
		return "PatientModel [id=" + id + ", name=" + name + ", age=" + age + ", sex=" + sex + ", weight=" + weight
				+ ", height=" + height + "]";
	}
}
