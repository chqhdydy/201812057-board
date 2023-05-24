package idusw.springboot.entity;

import com.fasterxml.jackson.databind.ser.Serializers;
import jakarta.persistence.*;
import lombok.*;

@ToString   // lombok 라이브러리 사용
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor

// JPA Auditikng 을 활용하여 생성자 ,생성일자 ,수정한사람,수정일자 등을 선택해서 감사
public class BoardEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ab_board_seq_gen")
    // Oracle : GenerationType.SEQUENCE, Mysql/MariaDB : GenerationType.IDENTITY, auto_increment
    @SequenceGenerator(sequenceName = "ab_board_seq", name = "ab_board_seq_gen", initialValue = 1, allocationSize = 1)
    private Long bno; // 유일성 있음

    @Column(length = 20, nullable = false)
    private String title;

    @Column(length = 1000, nullable = false)
    private String content;

    @ManyToOne
    // @JoinColumn(name = "seq")
    private MemberEntity writer; // BoardEntity : MemberEntity = N : 1



}
