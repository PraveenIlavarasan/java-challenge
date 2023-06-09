package jp.co.axa.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@Configuration
public class APIRequestLoggingConfig {

	@Bean
	CommonsRequestLoggingFilter logFilter() {
		CommonsRequestLoggingFilter filter = new CommonsRequestLoggingFilter();
		filter.setIncludeQueryString(true);
		filter.setIncludePayload(true);
		filter.setMaxPayloadLength(15000);
		filter.setIncludeHeaders(false);
		filter.setAfterMessagePrefix("REQUEST : ");
		return filter;
	}
}