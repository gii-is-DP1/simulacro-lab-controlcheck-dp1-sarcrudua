package org.springframework.samples.petclinic.product;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import org.springframework.samples.petclinic.model.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseEntity{

    @NotNull
    @Size(min = 3, max = 50)
    String name;

    @NotNull
    @PositiveOrZero
    double price;

    @ManyToOne
    @JoinColumn(name = "product_types_id")
    ProductType productType;

}
