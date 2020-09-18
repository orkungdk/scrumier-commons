package tr.com.ogedik.commons.rest.response.model;

/*
*
* @author enes.erciyes
* */

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tr.com.ogedik.commons.model.BusinessObject;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Issue implements BusinessObject {
    private long id;
    private String key;
    private String description;
    private Fields fields;
    private String summary;
}
