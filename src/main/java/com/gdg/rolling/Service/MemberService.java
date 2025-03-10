package com.gdg.rolling.Service;

import com.gdg.rolling.Dto.request.AddMemberDto;
import com.gdg.rolling.Dto.response.GetMemberDto;
import com.gdg.rolling.Dto.response.GetMembersDto;
import com.gdg.rolling.Dto.response.GetPapersDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface MemberService {
    void addMember(Long paperId, AddMemberDto addMemberDto, MultipartFile video) throws Exception;

    List<GetMembersDto> getMembers(Long paperID);

    GetMemberDto getMember(Long paperId, Long memberId) throws Exception;
}
