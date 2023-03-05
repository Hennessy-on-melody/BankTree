package com.zerobase.banktree.domain.member;

import com.zerobase.banktree.dto.MemberDto;
import javax.validation.constraints.NotBlank;
import lombok.*;

public class MemberForm {
    @Getter
    @Setter
    @AllArgsConstructor
    public static class Request{

        @NotBlank
        private String email;
        @NotBlank
        private String name;
        @NotBlank
        private String password;
        private String mobile;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response{
        private String email;
        private String name;

        public static Response from(MemberDto memberDto){
            return Response.builder()
                    .email(memberDto.getEmail())
                    .name(memberDto.getName())
                    .build();
        }
    }
}
