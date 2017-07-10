package entity;

import entity.MarkaCoffi;

import java.math.BigDecimal;

public class Coffi {
    private BigDecimal price;
    private String name;
    private MarkaCoffi markaCoffi;

    public Coffi() {
    }

    public Coffi(BigDecimal price, String name, MarkaCoffi markaCoffi) {
        this.price = price;
        this.name = name;
        this.markaCoffi = markaCoffi;
    }
public String toString(){
    return "entity.Coffi is name " + name  + ", price " + price + ", marka: " + markaCoffi.getName();
}
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MarkaCoffi getMarkaCoffi() {
        return markaCoffi;
    }

    public void setMarkaCoffi(MarkaCoffi markaCoffi) {
        this.markaCoffi = markaCoffi;
    }
}
