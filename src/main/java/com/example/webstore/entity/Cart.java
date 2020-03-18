package com.example.webstore.entity;

import javax.persistence.*;
import java.util.List;
@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //private Integer quantity;

    @OneToOne (mappedBy = "cart")
    private User user;

    @OneToMany (mappedBy = "cart", fetch = FetchType.LAZY)
    private List<Orders> orders;

    public Cart() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

   /* public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
*/

}
