package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Delivery {
    @Id @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)    //연관관계의 주인(Order)에 의해 delivery라는 이름으로 맵핑 됨.
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)    //String 자체로 저장. READY, COMP
    //@Enumerated(EnumType.ORDINAL) -> 0, 1, 2 ... 이런식을 저장됨. 중간에 다른 값 생기면 인덱스 밀려서 망함
    private DeliveryStatus status;  //READY, COMP
}
