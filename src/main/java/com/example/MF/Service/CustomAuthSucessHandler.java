package com.example.MF.Service;

import java.io.IOException;
import java.util.Set;

import com.example.MF.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;



import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CustomAuthSucessHandler extends SimpleUrlAuthenticationSuccessHandler {

	@Autowired
	private UserService userService;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());

		CustomUser userDetails = (CustomUser) authentication.getPrincipal();

		if (userDetails != null) {

			User user = userDetails.getUser();

			if (user.getFailedAttempt() > 0) {
				userService.resetFailedAttempt(user.getEmail());
			}

			if (roles.contains("ROLE_ADMIN")) {
				response.sendRedirect("/admin/profile");
			} else {
				response.sendRedirect("/user/profile");
			}
		}
		super.onAuthenticationSuccess(request, response, authentication);
	}

}
