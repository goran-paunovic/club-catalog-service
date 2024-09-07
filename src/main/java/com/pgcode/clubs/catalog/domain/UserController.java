package com.pgcode.clubs.catalog.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Goran Paunovic
 */

@RestController
@RequestMapping("/api/users")
public class UserController {
    @GetMapping
    public User getCurrentUser(@AuthenticationPrincipal OidcUser oidcUser) {
        return new User(oidcUser.getPreferredUsername(),
                oidcUser.getGivenName(),
                oidcUser.getFamilyName(),
                List.of("owner", "player"));
//                oidcUser.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList());
    }
}
