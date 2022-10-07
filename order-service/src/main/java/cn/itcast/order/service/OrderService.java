package cn.itcast.order.service;

import cn.itcast.order.mapper.OrderMapper;
import cn.itcast.order.pojo.Order;
import cn.itcast.order.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private RestTemplate restTemplate;

    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);
        // 2.查询用户
        Long userId = order.getUserId();
        // 3.发送Http请求查询用户
        String url = "http://userservice/user/" + userId;
        User user = restTemplate.getForObject(url, User.class);
        // 4.返回
        order.setUser(user);
        return order;
    }
}
