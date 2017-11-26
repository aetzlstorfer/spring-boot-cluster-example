package org.mufuku.dockercluster.backend.services;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * @author Andreas Etzlstorfer (a.etzlstorfer@gmail.com)
 */
@Service
public class DefaultAuthenticationService implements AuthenticationService {
    @Override
    public AuthenticationDetails getAuthentication() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AuthenticationDetails details = new AuthenticationDetails();
        details.setUserCode(authentication.getName());
        return details;
    }
}
