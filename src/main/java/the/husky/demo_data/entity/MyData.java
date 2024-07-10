package the.husky.demo_data.entity;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Column;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "mydata")
public class MyData {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "data_id_seq")
    @SequenceGenerator(name = "data_id_seq", sequenceName = "data_id_sequence", allocationSize = 1)
    private Integer id;

    @Column(name = "bytes")
    private byte[] bytes;

    @Column(name = "modify_at")
    private LocalDateTime modifyAt;

    @PrePersist
    public void onCreate() {
        modifyAt = LocalDateTime.now();
    }
}
