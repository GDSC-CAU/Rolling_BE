package com.gdg.rolling.Controller;

import com.gdg.rolling.Dto.request.CreatePaperDto;
import com.gdg.rolling.Dto.response.GetPapersDto;
import com.gdg.rolling.Service.PaperService;
import com.gdg.rolling.Service.PaperServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/papers")
@RequiredArgsConstructor
public class PaperController {

  private final PaperService paperService;
  private final PaperServiceImpl paperServiceImpl;

  @PostMapping
  public ResponseEntity<Long> createPaper(@RequestBody CreatePaperDto createPaperDto) {
    Long paperId = paperServiceImpl.createPaper(createPaperDto.getName());
    return ResponseEntity.ok(paperId); // 생성된 Paper ID 반환
  }

  @GetMapping
  public ResponseEntity<List<GetPapersDto>> getPapers() {
    return ResponseEntity.ok(paperService.getPapers());
  }
}
