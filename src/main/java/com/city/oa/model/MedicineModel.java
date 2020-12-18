package com.city.oa.model;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @ClassName: MedicineModel
 * @Description: TODO
 * @Author: xad
 * @Date: 2020/12/7 14:05
 */
public class MedicineModel implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
    private String name;
    private Double price;
    private Integer number=0;
    private String type;
    private String path;
    private byte[] photo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

	@Override
	public String toString() {
		return "MedicineModel [id=" + id + ", name=" + name + ", price=" + price + ", number=" + number + ", type="
				+ type + ", path=" + path + ", photo=" + Arrays.toString(photo) + "]";
	}
}
