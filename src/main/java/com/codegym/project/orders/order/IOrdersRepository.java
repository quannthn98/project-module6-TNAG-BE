package com.codegym.project.orders.order;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrdersRepository extends JpaRepository<Orders, Long> {
//    @Query("select o.id,o.address.address,o.orderTime,o.totalPayment,u.userProfile.fullName,u.userProfile.phone" +
//            " from Orders o join o.user.userProfile," +
//            "User u where (:id is null ) and " +
//            "(:name is null or lower(u.userProfile.fullName)" +
//            " like %:name%) and " +
//            "(:phone is null or lower(u.userProfile.phone)" +
//            " like %:phone%)")
// Page<orderDto> findByOrderFull(@Param("id")Long id,
//                              @Param("name")String name,
//                              @Param("phone") String phone, Pageable pageable);

//    @Query("select o from Orders o join o.user.userProfile,UserProfile " +
//            "where (:id is null or lower (o.id) like %:id% and " +
//            "(:fullname is null or lower(o.user.userProfile.fullName) like %:fullname%)" +
//            " and (:phone is null or lower(o.user.userProfile.phone) like %:phone%))")
//    Page<Orders> findOrdersByIdPhoneName(@Param("id") Long id,
//                                         @Param("fullname") String fullName,
//                                         @Param("phone") String phone, Pageable pageable);


}
