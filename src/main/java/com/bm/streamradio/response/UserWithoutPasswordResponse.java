package com.bm.streamradio.response;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Data
public class UserWithoutPasswordResponse implements Serializable {
    private UUID id;
    private String username;
    private String email;
    private String license;
}
