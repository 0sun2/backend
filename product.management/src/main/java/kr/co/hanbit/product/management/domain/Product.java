package kr.co.hanbit.product.management.domain;

public class Product {
    private Long id;
    private  String name;
    private  Integer price;
    private  Integer amount;

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public Integer getPrice() {
        return price;
    }

    public Boolean sameId(Long id) {
        return this.id.equals(id);
    }
    public  Boolean containsName(String name) {
        return this.name.contains(name);
    }
}
