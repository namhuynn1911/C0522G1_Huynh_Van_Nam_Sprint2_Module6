package com.example.sprintbe.repository.cart;

import com.example.sprintbe.dto.cart.CartDto;
import com.example.sprintbe.dto.cart.ISumCart;
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
    @Query(value = "select (cart.amount * product.price) as total, cart.id as id, product.name as name, product.image," +
            "cart.amount as amount, product.price as price, product.id as productId " +
            "from product " +
            "join cart on product.id = cart.product_id " +
            "where cart.is_delete =0 ",
            countQuery = "select count(*) ", nativeQuery = true)
    List<CartDto> productCart();

    @Query(value = "select sum(cart.amount * product.price) as sumCart " +
            "from product " +
            "join cart on product.id = cart.product_id " +
            "where cart.is_delete =0 ",
            countQuery = "select count(*) ", nativeQuery = true)
    ISumCart sumCart();

    @Modifying
    @Query(value = "insert into cart(product_id, amount) values(:id, 1) ", nativeQuery = true)
    void insertToCart(@Param("id") Integer id);

    @Query(value = "select * from cart where product_id = :id", nativeQuery = true)
    CartDto findByIdCart(@Param("id") Integer id);

    @Modifying
    @Query(value = "update cart set amount = amount + 1 " +
            "where product_id = :id and is_delete = 0", nativeQuery = true)
    void updateCart(@Param("id") Integer id);

    @Modifying
    @Query(value = "update cart set amount = :amount " +
            "where id = :id and is_delete = 0", nativeQuery = true)
    void updateAmount(Integer id, Integer amount);

    @Modifying
    @Query(value = "delete from cart " +
            "where id = :id", nativeQuery = true)
    void deleteProduct(Integer id);
}
