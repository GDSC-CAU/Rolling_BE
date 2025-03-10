package com.gdg.rolling.Controller;

import com.gdg.rolling.Dto.request.CreatePaperDto;
import com.gdg.rolling.Dto.response.GetPapersDto;
import com.gdg.rolling.Service.PaperService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/papers")
@RequiredArgsConstructor
public class PaperController {

  private final PaperService paperService;

  @PostMapping
  public ResponseEntity<Void> createPaper(@RequestBody CreatePaperDto createPaperDto) {
    paperService.createPaper(createPaperDto.getName());
    return ResponseEntity.ok().build();
  }

  @GetMapping
  public ResponseEntity<List<GetPapersDto>> getPapers() {
    return ResponseEntity.ok(paperService.getPapers());
  }
}
