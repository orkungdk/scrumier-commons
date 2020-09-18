package tr.com.ogedik.commons.rest.response.model;

import lombok.Getter;
import lombok.Setter;
import tr.com.ogedik.commons.model.BusinessObject;

/*
*
* @author enes.erciyes
*/
@Getter
@Setter
public class Fields implements BusinessObject {
    private String summary;
    private Worklog worklog;

}
