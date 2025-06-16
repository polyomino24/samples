package net.polyomino24.repository;

import net.polyomino24.model.UserEntity;
import org.seasar.doma.*;
import org.seasar.doma.boot.ConfigAutowireable;

@Dao
@ConfigAutowireable
public interface UserRepository {
//    @Select()
//    Optional<UserEntity> findByUsername(String username);
}
