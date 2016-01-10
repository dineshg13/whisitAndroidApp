package whisit.controller;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.SocialException;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.User;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import whisit.repository.UserRepository;
import whisit.types.Role;
import whisit.types.SocialMediaService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dinesh on 12/21/2015.
 */
@RestController
public class LoginController {

    public static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);


    @Autowired
    private UserRepository userRepository;


    @RequestMapping(value = "/login", method = RequestMethod.GET, produces = "application/json")
    public String login(HttpServletRequest request, HttpSession session) {

        LOGGER.debug("in login method");

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); //get logged in username

        LOGGER.info("auth:" + auth + ",sucessfully logged in");
        LOGGER.info("name:" + name);
        String SUCCESS_STR = "{status:success}";

        return new JSONObject(SUCCESS_STR).toString();
    }

    @RequestMapping(value = "/getsession", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public String authorized(@RequestBody String jsonAcessToken) {

        String SUCCESS_STR = "{status:success}";
        String FAIL_STR = "{status:fail}";
        try {
            String urlDecoded = URLDecoder.decode(jsonAcessToken, "UTF-8");
            LOGGER.info("accessToken=" + urlDecoded);

            JSONObject object = new JSONObject(urlDecoded);
            String accessToken = (String) object.get("accessToken");
            if (accessToken != null) {
                Facebook facebook = new FacebookTemplate(accessToken);
                User facebookUser = facebook.fetchObject("me", User.class, "id", "birthday", "email", "firstName", "lastName");
                if (facebookUser != null) {

                    List<GrantedAuthority> grantedAuths = new ArrayList<>();
                    grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));

                    SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(facebookUser.getEmail(), "", grantedAuths));
                    whisit.model.User user = userRepository.findByEmail(facebookUser.getEmail());

                    if (user == null) {
                        user = new whisit.model.User();
                        user.setEmail(facebookUser.getEmail());
                        user.setFirstName(facebookUser.getFirstName());
                        user.setLastName(facebookUser.getLastName());
                        user.setRole(Role.ROLE_USER);
                        user.setSignInProvider(SocialMediaService.FACEBOOK);
                        userRepository.save(user);
                    }
                    return new JSONObject(SUCCESS_STR).toString();
                }
            }

            return new JSONObject(FAIL_STR).toString();
        } catch (JSONException e) {
            LOGGER.error(e.getMessage(), e);
        } catch (SocialException e) {
            LOGGER.error(e.getMessage(), e);
        } catch (UnsupportedEncodingException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return new JSONObject(FAIL_STR).toString();
    }
}
