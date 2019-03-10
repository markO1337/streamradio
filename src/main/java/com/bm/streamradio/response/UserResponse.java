package com.bm.streamradio.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserResponse implements Serializable {
    private String username;
    private String email;
    private String license;
}
