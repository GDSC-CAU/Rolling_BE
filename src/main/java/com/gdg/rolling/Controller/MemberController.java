package com.gdg.rolling.Controller;

import com.gdg.rolling.Dto.request.AddMemberDto;
import com.gdg.rolling.Dto.request.CreatePaperDto;
import com.gdg.rolling.Dto.response.GetMemberDto;
import com.gdg.rolling.Dto.response.GetMembersDto;
import com.gdg.rolling.Dto.response.GetPapersDto;
import com.gdg.rolling.Service.MemberService;
import com.gdg.rolling.Service.PaperService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/papers/{paperId}/members")
@RequiredArgsConstructor
public class MemberController {

  private final MemberService memberService;

  @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
  public ResponseEntity<Void> addMember(@PathVariable("paperId") Long paperId, @RequestPart(value = "member") AddMemberDto addMemberDto,
                                        @RequestPart(value = "video") MultipartFile video) throws Exception {
    memberService.addMember(paperId, addMemberDto, video);
    return ResponseEntity.ok().build();
  }

  @GetMapping
  public ResponseEntity<List<GetMembersDto>> getMembers(@PathVariable("paperId") Long paperId) {
    return ResponseEntity.ok(memberService.getMembers(paperId));
  }

  @GetMapping(value = "/{memberId}")
  public ResponseEntity<GetMemberDto> getMember(@PathVariable("paperId") Long paperId, @PathVariable("memberId") Long memberId) throws Exception {
    return ResponseEntity.ok(memberService.getMember(paperId, memberId));
  }
}
