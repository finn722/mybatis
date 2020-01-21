package com.mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Author {

	private int id;
    private String name;
    private String dynasty;
    private String birth;
    private String briefDescription;



}
