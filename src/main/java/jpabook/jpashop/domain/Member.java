package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
//Setter는 사용 지양. 필요한 경우에만 열어둔다.
@Setter
public class Member {
    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member") // Order 테이블에 있는 Member 필드에 의해 맵핑 됨. 거울. 읽기 전용
    private List<Order> orders = new ArrayList<>();
}
