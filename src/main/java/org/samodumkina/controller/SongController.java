package org.samodumkina.controller;

import java.util.List;
import org.samodumkina.dto.SongCreateResponseDTO;
import org.samodumkina.dto.SongDTO;
import org.samodumkina.dto.SongDeleteResponseDTO;
import org.samodumkina.service.SongService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/songs", produces = MediaType.APPLICATION_JSON_VALUE)
public class SongController {

  private final SongService service;

  public SongController(SongService service) {
    this.service = service;
  }

  @GetMapping(value = "/{id}")
  public SongDTO getSong(@PathVariable Integer id) {
    return service.getSong(id);
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  public SongCreateResponseDTO createSong(@RequestBody SongDTO songDTO) {
    return service.createSong(songDTO);
  }

  @DeleteMapping()
  public SongDeleteResponseDTO deleteSongs(@RequestParam List<Integer> ids) {
    return service.deleteSongs(ids);
  }
}
