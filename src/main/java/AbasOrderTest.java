import model.Order;

import java.util.List;
import java.util.stream.Collectors;

public class AbasOrderTest {

    public static void run()
    {
        List<Order> orderList = Order.getOrderList();

        //1.a
        printTotalPriceOfGoods(orderList);
        //1.b
        printAveragePriceOfAllGoods(orderList);
        //1.c
        printAveragePriceOfEachGoods(orderList);
        //1.d
        printOrderAndAmountInfoOfEachGoods(orderList);


    }

    // a. Üç siparişteki malların toplam tutarının çıktısını veren java kodu. (3 siparişin toplam)
    private static void printTotalPriceOfGoods(List<Order> orderList)
    {
        System.out.printf("Tüm ürünlerin toplam fiyatı : %f\n", getTotalPriceOfGivenOrders(orderList));
    }

    // b. Üç siparişteki bütün malların ortalama fiyatını bulan java kodu.
    private static void printAveragePriceOfAllGoods(List<Order> orderList)
    {
        System.out.printf("Tüm malların ortalama fiyatı : %f\n", getTotalPriceOfGivenOrders(orderList) / getTotalAmountOfGivenOrders(orderList));

    }

    private static double getTotalPriceOfGivenOrders(List<Order> orderList)
    {
        return  orderList.stream().mapToDouble(o -> o.getAmount() * o.getUnitPrice()).sum();
    }

    private static int getTotalAmountOfGivenOrders(List<Order> orderList)
    {
        return orderList.stream().mapToInt(o -> o.getAmount()).sum();
    }

    //c. Üç siparişteki bütün malların tek tek mal bazlı ortalama fiyatını bulan java kodu.
    private static void printAveragePriceOfEachGoods(List<Order> orderList)
    {
        orderList.stream()
                .collect(Collectors.groupingBy(Order::getGoodsNumber))
                .forEach((goodNumber, listOfOrder) -> printByGivenInfoByMessage("Nolu Mal için ortalama fiyat : ", goodNumber, listOfOrder));

        //System.out.println(a);
    }
    private static void printByGivenInfoByMessage(String msg, Integer goodNumber, List<Order> listOfOrder)
    {
        System.out.printf("%d %s %f\n", goodNumber, msg, getTotalPriceOfGivenOrders(listOfOrder) / getTotalAmountOfGivenOrders(listOfOrder));
    }

    //d. Tek tek mal bazlı, malların hangi siparişlerde kaç adet olduğunun çıktısını veren java kodu.
    private static void printOrderAndAmountInfoOfEachGoods(List<Order> orderList)
    {
        orderList.stream()
                .collect(Collectors.groupingBy(Order::getGoodsNumber))
                .forEach((goodNumber, listOfOrder) -> printOrderAndAmountInfoOfGivenGoodNumber(goodNumber, listOfOrder));
    }
    private static void printOrderAndAmountInfoOfGivenGoodNumber(Integer goodNumber, List<Order> listOfOrder)
    {
        listOfOrder.stream()
                .collect(Collectors.groupingBy(Order::getOrderNo)).forEach((on, ol) ->
                                                                   System.out.printf("%d Nolu Mal --> %d Nolu Siparişte --> %d adet vardır.\n",
                                                                                     goodNumber, on, ol.stream().mapToInt(ol2 -> ol2.getAmount()).sum()));
    }














}
