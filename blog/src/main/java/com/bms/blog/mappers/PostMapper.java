package com.bms.blog.mappers;

import com.bms.blog.domain.CreatePostRequest;
import com.bms.blog.domain.UpdatePostRequest;
import com.bms.blog.domain.dtos.CreatePostRequestDto;
import com.bms.blog.domain.dtos.PostDto;
import com.bms.blog.domain.dtos.UpdatePostRequestDto;
import com.bms.blog.domain.entities.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PostMapper {
    @Mapping(target = "author", source = "author")
    @Mapping(target = "category", source = "category")
    @Mapping(target = "tags", source = "tags")
    PostDto toDto(Post post);

    CreatePostRequest toCreatePostRequest(CreatePostRequestDto createPostRequestDto);

    UpdatePostRequest toUpdatePostRequest(UpdatePostRequestDto dto);
}
