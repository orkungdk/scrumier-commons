package tr.com.ogedik.commons.rest.request.model.sessions;

import lombok.Getter;
import lombok.Setter;
import tr.com.ogedik.commons.model.BusinessObject;

/**
 * @author orkungedik
 */
@Getter
@Setter
public class JiraSession implements BusinessObject {

    private Session session;

    private JiraLoginInfo loginInfo;

    private boolean isAuthorized = true;
}
