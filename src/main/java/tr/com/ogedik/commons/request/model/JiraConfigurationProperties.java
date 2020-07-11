/**
 * © 2020 Copyright Amadeus Unauthorised use and disclosure strictly forbidden.
 */
package tr.com.ogedik.commons.request.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tr.com.ogedik.commons.annotation.NotNull;
import tr.com.ogedik.commons.model.BusinessObject;

/**
 * @author orkun.gedik
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JiraConfigurationProperties implements BusinessObject {
  @NotNull
  private String baseURL;
  @NotNull
  private String username;
  @NotNull
  private String password;
  @NotNull
  private String apiVersion;
}
