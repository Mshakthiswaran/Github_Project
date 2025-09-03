package com.tnsif.customeruser1.role;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Role {

    @JsonProperty("Super-User")
    SUPER_USER, // ✅ Renamed to follow enum naming conventions

    MANAGER,
    STAFF
}