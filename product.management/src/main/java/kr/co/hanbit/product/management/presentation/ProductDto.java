package kr.co.hanbit.product.management.presentation;

import kr.co.hanbit.product.management.domain.Product;

public class ProductDto {
    private Long id;
    private  String name;
    private  Integer price;
    private  Integer amount;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getAmount() {
        return amount;
    }

}