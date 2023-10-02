package org.samodumkina.service.mapper;

import org.samodumkina.dao.entity.SongEntity;
import org.samodumkina.dto.SongDTO;
import org.springframework.stereotype.Component;

@Component
public class SongMapper {

  public SongEntity mapDTOToEntity(SongDTO songDTO) {
    SongEntity entity = new SongEntity();

    entity.setName(songDTO.name());
    entity.setArtist(songDTO.artist());
    entity.setAlbum(songDTO.album());
    entity.setLength(songDTO.length());
    entity.setResourceId(songDTO.resourceId());
    entity.setYear(songDTO.year());

    return entity;
  }

  public SongDTO mapEntityToDTO(SongEntity entity) {
    return new SongDTO(entity.getName(), entity.getArtist(), entity.getAlbum(), entity.getLength(),
        entity.getResourceId(), entity.getYear());
  }
}
