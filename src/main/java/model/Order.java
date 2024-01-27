package model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderNo;
    private int goodsNumber;
    private int amount;
    private double unitPrice;

    public Order(int orderNo, int goodsNumber, int amount, double unitPrice)
    {
        this.orderNo = orderNo;
        this.goodsNumber = goodsNumber;
        this.amount = amount;
        this.unitPrice = unitPrice;
    }

    public int getOrderNo()
    {
        return orderNo;
    }

    public void setOrderNo(int orderNo)
    {
        this.orderNo = orderNo;
    }

    public int getGoodsNumber()
    {
        return goodsNumber;
    }

    public void setGoodsNumber(int goodsNumber)
    {
        this.goodsNumber = goodsNumber;
    }

    public int getAmount()
    {
        return amount;
    }

    public void setAmount(int amount)
    {
        this.amount = amount;
    }

    public double getUnitPrice()
    {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice)
    {
        this.unitPrice = unitPrice;
    }

    public double getOrderTotalUnitPrice()
    {
        return unitPrice * amount;
    }


    @Override
    public String toString()
    {
        return
                "orderNo=" + orderNo +
                ", goodsNumber=" + goodsNumber +
                ", amount=" + amount +
                ", unitPrice=" + unitPrice + "\n";

    }

    public static List<Order> getOrderList()
    {
        var orderList = new ArrayList<Order>();
        orderList.add(new Order(1000, 2000, 12, 100.51));
        orderList.add(new Order(1000, 2001, 31, 200));
        orderList.add(new Order(1000, 2002, 22, 150.86));
        orderList.add(new Order(1000, 2003, 41, 250));
        orderList.add(new Order(1000, 2004, 55, 244));
        orderList.add(new Order(1001, 2001, 88, 44.531));
        orderList.add(new Order(1001, 2002, 121, 88.11));
        orderList.add(new Order(1001, 2004, 74, 211));
        orderList.add(new Order(1001, 2002, 14, 88.11));
        orderList.add(new Order(1002, 2003, 2, 12.1));
        orderList.add(new Order(1002, 2004, 3, 22.3));
        orderList.add(new Order(1002, 2003, 8, 12.1));
        orderList.add(new Order(1002, 2002, 16, 94));
        orderList.add(new Order(1002, 2005, 9, 44.1));
        orderList.add(new Order(1002, 2006, 19, 90));

        return orderList;
    }
}
