package tr.com.ogedik.commons.rest.request.model;

import lombok.*;
import tr.com.ogedik.commons.model.BusinessObject;

import java.util.Date;

/*
 * @author enes.erciyes
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateWorklogRequest implements BusinessObject {
    private String issueKey;
    private String comment;
    private Date started;
    private int timeSpentSeconds;
}
