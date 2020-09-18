package tr.com.ogedik.commons.rest.request.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tr.com.ogedik.commons.model.BusinessObject;

/*
 * @author enes.erciyes
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WorklogVisibility implements BusinessObject {
    String type;
    String value;

}
