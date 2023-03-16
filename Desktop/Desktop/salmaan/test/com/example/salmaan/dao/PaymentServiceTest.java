package com.example.salmaan.dao;

import com.example.salmaan.entity.CustomerBuilder;
import com.example.salmaan.entity.Customers;
import com.example.salmaan.entity.main.PaymentBuilder;
import com.example.salmaan.entity.main.Payments;
import com.example.salmaan.entity.service.Pending;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PaymentServiceTest {

    @Test
    void fetchCustomersOfflinePayment() throws SQLException {
//        System.out.println(PaymentService.fetchCustomersOfflinePayment("4303924"));
//
//        System.out.println(PaymentService.fetchCustomersOfflinePayment("4303924"));
        System.out.println(PaymentService.fetchCustomersOfflinePayment("4303924"));
//
//        System.out.println();
//        System.out.println();
//        System.out.println(PaymentService.fetchCustomersOfflinePayment("4303923"));
//
        //  System.out.println(PaymentService.fetchCustomersOfflinePayment("4303923"));
//

        System.out.println(PaymentService.fetchCustomersOfflinePayment("4303923"));
    }

    @Test
    void insertPayment() throws SQLException {

        Payments payment = new PaymentBuilder()
                .setExpDate(LocalDate.now().minusDays(60))
                .setPaymentDate(LocalDate.now().toString())
                .setAmountPaid(12)
                .setBox(null)
                .setOnline(false)
//                .setCustomerFK("4303924")
                .setDiscount(0)
                .setPaidBy("Cash")
                .setPoxing(false).build();


        Customers customer = new CustomerBuilder()
                .setImage(null)
                .setAddress("tuurta")
                .setPhone("4303923")
                .setGander("Male")
                .setMiddleName("Saeed")
                .setFirstName("Mohamed")
                .setLastName("Ogleh")
                .setShift("Afternoon")
                .setWeight(65)
                .setWhoAdded("Ogleh")
                .build();
        customer.getPayments().add(0, payment);

        PaymentService.insertPayment(customer);
        //  System.out.println(customer);
    }

    @Test
    void fetchCustomersOnlinePayment() throws SQLException {
        System.out.println(PaymentService.fetchCustomersOfflinePayment("4303924"));
    }

    @Test
    void fetchAllCustomersPayments() throws SQLException {
        System.out.println(PaymentService.fetchAllCustomersPayments("4303924"));
    }

    @Test
    void pendPayment() throws SQLException {
        Payments payment = PaymentService.fetchAllCustomersPayments("4303924").get(0);
        System.out.println(payment);

        PaymentService.pendPayment(payment,10);
    }

    @Test
    void updatePendingPayment() {
    }

    @Test
    void fetchPendedPayment() throws SQLException {
        //  System.out.println();

//        Pending pending = PaymentService.fetchPendedPayment().get(1);
//
//        PaymentService.updatePendingPayment(pending);

    //    System.out.println(PaymentService.fetchPendedPayment().size());


        // TODO: 03/03/2023 Insha Allah kala habee payment model and servise sido kale ka dhig kuwo hal data soo cesha qaybta customerka
        //
    }

}