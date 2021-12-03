package com.codegym.project.controller;

import com.codegym.project.cart.cart.Cart;
import com.codegym.project.cart.cart.ICartService;
import com.codegym.project.orders.order.IOrdersService;
import com.codegym.project.orders.order.Orders;
import com.codegym.project.orders.order.OrdersForm;
import com.codegym.project.orders.orderDetail.OrdersDetail;
import com.codegym.project.orders.payment.PaymentMethod;
import com.codegym.project.role.IRoleService;
import com.codegym.project.role.Role;
import com.codegym.project.role.RoleConst;
import com.codegym.project.users.userAddress.UserDeliverAddress;
import com.codegym.project.users.users.IUserService;
import com.codegym.project.users.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private IOrdersService ordersService;
    @Autowired
    private ICartService cartService;
    @Autowired
    private IUserService userService;
    @Autowired
    private IRoleService roleService;

    @PostMapping("/{merchantId}")
    public ResponseEntity<Orders> newOrder(@RequestBody OrdersForm ordersForm,
                                           @PathVariable("merchantId") Long merchantId,
                                           Authentication authentication){
        UserDeliverAddress userDeliverAddress = ordersForm.getAddress();
        PaymentMethod paymentMethod = ordersForm.getPaymentMethod();
        User user = userService.getUserFromAuthentication(authentication);
        Role merchantRole = roleService.findByName(RoleConst.MERCHANT);
        User merchant = userService.findByRolesContainingAndId(merchantRole, merchantId);
        if (merchant == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Cart cart = cartService.findByMerchantAndUser(merchant, user);
        Set<OrdersDetail> ordersDetailSet = ordersService.convertCartDetailToOrderDetail(cart);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
