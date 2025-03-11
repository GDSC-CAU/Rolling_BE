package com.gdg.rolling.Service;

import com.gdg.rolling.Dto.response.GetPapersDto;
import com.gdg.rolling.entity.Paper;
import com.gdg.rolling.respository.PaperRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PaperServiceImpl implements PaperService {

    private final PaperRepository paperRepository;

    @Override
    public Long createPaper(String name) {
        Paper paper = paperRepository.save(Paper.builder()
                .name(name)
                .build());

        return paper.getId(); // 생성된 Paper의 ID 반환
    }


    @Override
    public List<GetPapersDto> getPapers() {
        return paperRepository.findAll().stream()
                .map(m -> new GetPapersDto(m.getId(), m.getName()))
                .collect(Collectors.toList());
    }
}
