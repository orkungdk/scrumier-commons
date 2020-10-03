package tr.com.ogedik.commons.rest.request.model.sessions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tr.com.ogedik.commons.model.BusinessObject;

/**
 * @author orkungedik
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Session implements BusinessObject {

    private String name;

    private String value;
}
