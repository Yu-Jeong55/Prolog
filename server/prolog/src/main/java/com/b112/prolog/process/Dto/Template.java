package com.b112.prolog.process.Dto;

import com.b112.prolog.process.Entity.Qna;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class Template {

    private int template_type;
    private String template_name;
    private List<QnaDto> content;// 이거를 QNA DTO로 바꾸자 !!!!!!!!
//    private List<Qna> populatecontent;



}
