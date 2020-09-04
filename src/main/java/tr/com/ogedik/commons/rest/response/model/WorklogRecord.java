package tr.com.ogedik.commons.rest.response.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tr.com.ogedik.commons.model.BusinessObject;
import tr.com.ogedik.commons.model.JiraUser;

/**
 *
 * @author enes.erciyes
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WorklogRecord implements BusinessObject {
    private long id;
    private JiraUser author;
    private JiraUser updateAuthor;
    private String comment;
    private String timeSpent;
    private String created;
    private String updated;
    private String started;
    private String issueId;
}
