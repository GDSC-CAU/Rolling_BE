package com.gdg.rolling.Service;

import com.gdg.rolling.Dto.response.GetPapersDto;

import java.util.List;

public interface PaperService {
    void createPaper(String name);

    List<GetPapersDto> getPapers();
}
