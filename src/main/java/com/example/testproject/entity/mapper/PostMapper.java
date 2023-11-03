package com.example.testproject.entity.mapper;

import com.example.testproject.entity.Post;
import com.example.testproject.payload.PostDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PostMapper {

    void  updatePostToDTO(PostDTO postDTO, @MappingTarget Post post);
}
