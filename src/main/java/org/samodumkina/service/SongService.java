package org.samodumkina.service;

import java.util.List;
import org.samodumkina.dao.SongRepository;
import org.samodumkina.dao.entity.SongEntity;
import org.samodumkina.dto.SongCreateResponseDTO;
import org.samodumkina.dto.SongDTO;
import org.samodumkina.dto.SongDeleteResponseDTO;
import org.samodumkina.exception.NotFoundException;
import org.samodumkina.service.mapper.SongMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class SongService {

  private final SongMapper songMapper;
  private final SongRepository songRepository;

  public SongService(SongMapper songMapper, SongRepository songRepository) {
    this.songMapper = songMapper;
    this.songRepository = songRepository;
  }

  public SongDTO getSong(Integer id) {
    SongEntity entity = songRepository.findById(id).orElseThrow(() ->
        new NotFoundException("The song metadata with the specified id='%d' does not exist".formatted(id)));

    return songMapper.mapEntityToDTO(entity);
  }

  @Transactional
  public SongCreateResponseDTO createSong(SongDTO songDTO) {
    SongEntity entity = songMapper.mapDTOToEntity(songDTO);

    SongEntity saved = songRepository.save(entity);
    return new SongCreateResponseDTO(saved.getId());
  }

  @Transactional
  public SongDeleteResponseDTO deleteSongs(List<Integer> ids) {
    List<SongEntity> songEntities = songRepository.deleteByIdIn(ids);
    return new SongDeleteResponseDTO(songEntities.stream().map(SongEntity::getId).toList());
  }
}
