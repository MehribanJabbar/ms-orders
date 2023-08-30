package az.ingress.msorders.mapper

import az.ingress.msorders.dao.entity.OrderEntity
import az.ingress.msorders.dto.request.SaveOrderRequest
import io.github.benas.randombeans.EnhancedRandomBuilder
import io.github.benas.randombeans.api.EnhancedRandom
import spock.lang.Specification

class OrderMapperTest extends Specification {
    EnhancedRandom random = EnhancedRandomBuilder.aNewEnhancedRandom()
    private OrderMapper orderMapper

    def "TestBuildToResponse"() {
        given:
        def order = random.nextObject(OrderEntity)

        when:
        def actual = OrderMapper.buildToResponse(order)

        then:
        actual.id == order.id
        actual.userId == order.userId
        actual.orderNumber == order.orderNumber
        actual.status == order.status
        actual.orderDetails == order.orderDetails
    }

    def "TestBuildTpEntity"() {
        given:
        def request = random.nextObject(SaveOrderRequest)

        when:
        def actual = OrderMapper.buildToEntity(request)

        then:
        actual.userId == request.userId
        actual.orderDetails == request.orderDetails
    }

    def "TestCreateTicketRequestFromOrder"() {
        given:
        def order = random.nextObject(OrderEntity)

        when:
        def actual = OrderMapper.createTicketRequestFromOrder(order)

        then:
        actual.orderId == order.id
        actual.trackingCode == order.orderNumber
        actual.ticketDetails == order.orderDetails
    }
}
