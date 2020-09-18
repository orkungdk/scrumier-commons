package tr.com.ogedik.commons.rest.request.model;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class JiraCreateWorklogRequest implements BusinessObject {
    private String comment;
    private WorklogVisibility visibility;
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private Date started;
    private int timeSpentSeconds;
}
