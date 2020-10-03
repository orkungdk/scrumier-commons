package tr.com.ogedik.commons.rest.request.model.sessions;

import lombok.Getter;
import lombok.Setter;

/**
 * @author orkungedik
 */
@Getter
@Setter
public class JiraLoginInfo {

    private String loginCount;

    private String previousLoginTime;
}
