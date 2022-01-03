package com.alvarolongueira.customerservice.configuration;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class AuditorConfig implements AuditorAware<String> {

	@Override
	public Optional<String> getCurrentAuditor() {
		try {
			UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			return Optional.ofNullable(userDetails.getUsername());

		} catch (Exception e) {
		}

		return Optional.empty();
	}

}