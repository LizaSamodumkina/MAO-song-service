package org.samodumkina.dao;

import java.util.List;
import org.samodumkina.dao.entity.SongEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<SongEntity, Integer> {

  List<SongEntity> deleteByIdIn(List<Integer> ids);
}
