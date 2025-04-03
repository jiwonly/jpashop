package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id // 기본 키
    @GeneratedValue // 기본 키 값을 자동 생성
    @Column(name="member_id") // 실제 컬럼명 지정
    private Long id;

    private String name;

    @Embedded // address 라는 별도의 값 타입 클래스
    private Address address;

    @OneToMany(mappedBy = "member")
    // 한 명 회원이 여러 개 주문 가질 수 있음.
    // order 엔터티에서 member 필드로 관계를 매핑.
    // 연관관계 주인은 order 엔터티의 member 필드
    private List<Order> orders = new ArrayList<>();

}
