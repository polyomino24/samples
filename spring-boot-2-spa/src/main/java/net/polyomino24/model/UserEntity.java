package net.polyomino24.model;

import lombok.Data;
import lombok.Getter;
import org.seasar.doma.*;
import org.seasar.doma.jdbc.entity.NamingType;

@Entity(naming = NamingType.SNAKE_LOWER_CASE)
@Table(name = "user", quote = true)
@Data
public class UserEntity {

    @Id String userId;

    @Column(updatable = false)
    String password;

    String role;
}