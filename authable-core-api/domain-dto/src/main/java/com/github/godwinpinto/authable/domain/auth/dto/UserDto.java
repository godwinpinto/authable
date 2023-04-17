package com.github.godwinpinto.authable.domain.auth.dto;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements UserDetails {
    private static final long serialVersionUID = 1L;

    private String username;

    private String systemId;

    private String jwtCode;

    private String password;

    private long expiryTime;

    @Getter
    @Setter
    private Boolean enabled;

    @Getter
    @Setter
    private List<Role> roles;

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream()
                .map(authority -> new SimpleGrantedAuthority(authority.name()))
                .toList();
    }

    //    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

    //  @JsonProperty
    public void setPassword(String password) {
        this.password = password;
    }

    public long getExpiryTime() {
        return expiryTime;
    }

    //  @JsonProperty
    public void setExpiryTime(long expiryTime) {
        this.expiryTime = expiryTime;
    }

    public String getJwtCode() {
        return jwtCode;
    }

    //  @JsonProperty
    public void setJwtCode(String jwtCode) {
        this.jwtCode = jwtCode;
    }

    public String getSystemId() {
        return systemId;
    }

    //  @JsonProperty
    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

}
