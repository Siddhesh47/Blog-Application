package com.bms.blog.domain.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateTagsRequest {

    @NotEmpty(message = "At Least One Tag name is required")
    @Size(min = 1, max = 10, message = "Tags must be between {min} and {max} characters")

    private Set<
            @Size(min = 2, max = 30, message = "Tag name must be between {min} and {max} characters")
            @Pattern(regexp = "^[\\w\\s-]+$", message = "Tag name can only contain letters, spaces, and hyphens.")
            String> names;
}
