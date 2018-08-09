/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alfilsoft.bo;

import com.alfilsoft.dao.BillDAO;
import com.alfilsoft.dao.ShopDAO;
import com.alfilsoft.model.Bill;
import com.alfilsoft.model.Shop;
import com.alfilsoft.util.BOException;
import com.alfilsoft.util.Util;

import com.alfilsoft.util.UtilSingleton;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author luis.carvajal
 */
@Service
public class BillBOImpl implements BillBO {

    @Autowired
    private BillDAO billDAO;
    @Autowired
    private ShopDAO shopDAO;
    private Util util;

    @Override
    public Bill save(Bill bill) throws BOException {
        bill.getItemDetailList().forEach((id) -> {
            id.setBill(bill);
        });
        return billDAO.save(bill);
    }

    @Override
    public List<Bill> list(Long shopId) throws BOException {
        return billDAO.list(shopId);
    }

    @Override
    public Boolean sendEmail(Long shopId, Long billId) throws BOException {

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        Bill bill;
        Shop shop;

        bill = billDAO.search(shopId, billId);
        util = UtilSingleton.getUtil();
        shop = shopDAO.search(shopId);
        
        if (null != bill && null != shop) {
            Util.sendEmail(bill.getClient().getEmail(), shop.getEmail(), "smtp.gmail.com", "Factura" + dateFormat.format(date),
                    "Información de la factura", "compucarvajal", "L@@3128761260");
            return TRUE;
        }
        return FALSE;

    }

}
