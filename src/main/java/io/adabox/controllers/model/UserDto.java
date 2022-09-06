package io.adabox.controllers.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Getter
@Setter
@ToString
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {

	private Long id;
	private String baseAddress;
	private String email;

	@JsonIgnore
	private boolean isEmailVerified;
	private String username;
	private String preferredLanguage;
	private String bio;
	private String imageUrl;
	private String coverUrl;
	private String twitter;
	private String instagram;
	private String github;
	private String twitch;
	private String facebook;
	private String website;
	private String youtube;
	protected Date createdDate;

	@JsonIgnore
	protected Date modifiedDate;

	@JsonIgnore
	private boolean banned;
	private Set<ProjectDto> projects = new HashSet<>();
	private Set<NotificationDto> notifications;
}
