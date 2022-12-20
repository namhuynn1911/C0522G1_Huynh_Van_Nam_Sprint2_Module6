package com.example.sprintbe.repository.cart;

import com.example.sprintbe.dto.cart.CartDto;
import com.example.sprintbe.dto.cart.ISumCart;
import com.example.sprintbe.dto.product.IProductDto;
import com.example.sprintbe.model.cart.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Repository
public interface ICartRepository extends JpaRepository<Cart, Integer> {
    //ok
    @Query(value = "select (product_customer.amount * product.price) as total, product.id as id, product.name as name, product.image," +
            "product_customer.amount as amount, product.price as price " +
            "from product_customer " +
            "join cart on cart.id = product_customer.cart_id " +
            "join product on product.id = product_customer.product_id " +
            "where product_customer.cart_id =:cartId and product_customer.is_delete =0 " +
            "group by product.id", nativeQuery = true)
    List<CartDto> productCart(Integer cartId);
//ok
    @Query(value = "select * from cart where username = :username and is_delete = 0", nativeQuery = true)
    Cart findCartId(@Param("username") String username);
//ok
    @Query(value = "select sum(product_customer.amount * product.price) as sumCart, " +
            "count(product_customer.product_id) as countProduct  " +
            "from product_customer " +
            "join product on product.id = product_customer.product_id " +
            "where product_customer.cart_id =:cartId and product_customer.is_delete = 0 ", nativeQuery = true)
    ISumCart sumCart(@Param("cartId") Integer cartId);

    @Modifying
    @Query(value = "insert into product_customer(cart_id,product_id, amount) values(:cartId, :id, 1) ", nativeQuery = true)
    void insertToCart(@Param("cartId") Integer cartId,
            @Param("id") Integer id);

    @Query(value = "select product.id, cart.username as username from product_customer " +
            "join product on product_customer.product_id = product.id " +
            "join cart on product_customer.cart_id = cart.id " +
            "where product_customer.product_id =:id " +
            "and cart.username = :username " +
            "and product_customer.is_delete = 0", nativeQuery = true)
    IProductDto findByIdCart(@Param("id") Integer id,
                             @Param("username") String username);

    //ok
    @Modifying
    @Query(value = "update product_customer set amount = amount + 1 " +
            "where product_customer.product_id =:id and is_delete = 0", nativeQuery = true)
    void updateCart(@Param("id") Integer id);

    @Modifying
    @Query(value = "update product_customer set amount = :amount " +
            "where product_customer.product_id =:id and cart_id = :cartId and is_delete = 0", nativeQuery = true)
    void updateAmount(Integer id, Integer amount,Integer cartId);

    @Modifying
    @Query(value = "delete from product_customer " +
            "where product_id = :id", nativeQuery = true)
    void deleteProduct(Integer id);
}
