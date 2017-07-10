package entity;

public class MarkaCoffi {
long id;
    private String name;
    private TypeCoffi typeCoffi;
    private String proizvoditel;

    public MarkaCoffi() {
    }

    public MarkaCoffi(String name, TypeCoffi typeCoffi, String proizvoditel) {
        this.name = name;
        this.typeCoffi = typeCoffi;
        this.proizvoditel = proizvoditel;
    }

    public String getProizvoditel() {
        return proizvoditel;
    }

    public void setProizvoditel(String proizvoditel) {
        this.proizvoditel = proizvoditel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypeCoffi getTypeCoffi() {
        return typeCoffi;
    }

    public void setTypeCoffi(TypeCoffi typeCoffi) {
        this.typeCoffi = typeCoffi;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
       return id;

    }

    @Override
    public String toString() {
        return "MarkaCoffi{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", typeCoffi=" + typeCoffi +
                ", proizvoditel='" + proizvoditel + '\'' +
                '}';
    }
}
