package me.iksadnorth.board.domain;

import lombok.Getter;
import lombok.ToString;

import java.util.Objects;


public class User {
    private Long id;
    private String username;    // 유저명
    private String email;       // 이메일
}
