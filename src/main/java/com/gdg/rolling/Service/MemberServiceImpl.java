package com.gdg.rolling.Service;

import com.gdg.rolling.Config.S3Manager;
import com.gdg.rolling.Dto.request.AddMemberDto;
import com.gdg.rolling.Dto.response.GetMemberDto;
import com.gdg.rolling.Dto.response.GetMembersDto;
import com.gdg.rolling.entity.Member;
import com.gdg.rolling.respository.MemberRepository;
import com.gdg.rolling.respository.PaperRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final PaperRepository paperRepository;
    private final S3Manager s3Manager;

    @Override
    public void addMember(Long paperId, AddMemberDto addMemberDto, MultipartFile video) throws Exception {
        String videoUrl = s3Manager.uploadFile(video);

        memberRepository.save(Member.builder()
                .emoji(addMemberDto.getEmoji())
                .name(addMemberDto.getName())
                .video(videoUrl)
                .phone(addMemberDto.getPhone())
                .instagram(addMemberDto.getInstagram())
                .ps(addMemberDto.getPs())
                .x(addMemberDto.getX())
                .y(addMemberDto.getY())
                .paper(paperRepository.findById(paperId)
                        .orElseThrow())
                .build());
    }

    @Override
    public List<GetMembersDto> getMembers(Long paperId) {
        return memberRepository.findAllByPaper_Id(paperId).stream()
                .map(m -> new GetMembersDto(m.getId(), m.getEmoji(), m.getName(), m.getX(), m.getY()))
                .collect(Collectors.toList());
    }

    @Override
    public GetMemberDto getMember(Long paperId, Long memberId) throws Exception {
        return memberRepository.findByPaper_IdAndId(paperId, memberId)
                .map(m -> new GetMemberDto(m.getId(), m.getEmoji(), m.getName(), m.getVideo(), m.getPhone(), m.getInstagram(), m.getPs()))
                .orElseThrow(Exception::new);
    }
}
