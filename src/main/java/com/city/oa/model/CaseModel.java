package com.city.oa.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @ClassName: CaseModel
 * @Description: TODO
 * @Author: xad
 * @Date: 2020/12/7 11:01
 */
public class CaseModel implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
    private Date date;
    private String suggest;
    private Double price;
    private List<MedicineModel> medicines;
    private Integer pId;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSuggest() {
        return suggest;
    }

    public void setSuggest(String suggest) {
        this.suggest = suggest;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<MedicineModel> getMedicines() {
        return medicines;
    }

    public void setMedicines(List<MedicineModel> medicines) {
        this.medicines = medicines;
    }

    public Integer getPId() {
        return pId;
    }

    public void setPId(Integer pId) {
        this.pId = pId;
    }

	@Override
	public String toString() {
		return "CaseModel [id=" + id + ", date=" + date + ", suggest=" + suggest + ", price=" + price + ", medicines="
				+ medicines + ", pId=" + pId + "]";
	}
    
}
