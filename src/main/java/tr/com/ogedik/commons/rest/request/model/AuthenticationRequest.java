package tr.com.ogedik.commons.rest.request.model;

import lombok.*;
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
public class AuthenticationRequest implements BusinessObject {
  @NotNull
  private String username;
  @NotNull
  private String password;

}