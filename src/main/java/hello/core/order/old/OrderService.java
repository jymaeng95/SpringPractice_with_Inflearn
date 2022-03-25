package hello.core.order.old;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
