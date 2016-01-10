package whisit.component;

import whisit.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import whisit.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dinesh on 12/20/2015.
 */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    private Logger LOGGER = LoggerFactory.getLogger(CustomAuthenticationProvider.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        LOGGER.info("auth called:" + authentication);
        User user = userRepository.findByEmail((String) authentication.getPrincipal());
        if (user != null) {
            List<GrantedAuthority> grantedAuths = new ArrayList<>();

            grantedAuths.add(new SimpleGrantedAuthority(user.getRole() != null ? user.getRole().name() : "ROLE_USER"));
            Authentication auth = new UsernamePasswordAuthenticationToken(user.getEmail(), "", grantedAuths);

            return auth;
        } else if ("test".equals(authentication.getPrincipal())) {
            List<GrantedAuthority> grantedAuths = new ArrayList<>();

            grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
            Authentication auth = new TestingAuthenticationToken("test", grantedAuths);

            return auth;
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(TestingAuthenticationToken.class);
    }
}
