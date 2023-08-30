package az.ingress.msorders.service

import az.ingress.msorders.dao.entity.OrderEntity
import az.ingress.msorders.dao.repository.OrderRepository
import io.github.benas.randombeans.EnhancedRandomBuilder
import io.github.benas.randombeans.api.EnhancedRandom
import spock.lang.Specification

class OrderServiceTest extends Specification{
    EnhancedRandom random = EnhancedRandomBuilder.aNewEnhancedRandom()
    private OrderRepository orderRepository
    private OrderService orderService

//    def "TestFindOrderById success"(){
//        given:
//        def id = random.nextLong()
//        def order = random.nextObject(OrderEntity)
//
//        when:
//        def actual = orderService.findOrderById(id)
//
//        then:
//        1 * orderRepository.findById(id) >> Optional.of(order)
//        actual.id == order.id
//        actual.userId == order.userId
//        actual.orderNumber == order.orderNumber
//        actual.status == order.status
//        actual.orderDetails == order.orderDetails
//    }
}
