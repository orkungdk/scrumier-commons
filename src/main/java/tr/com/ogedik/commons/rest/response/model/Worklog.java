package tr.com.ogedik.commons.rest.response.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import tr.com.ogedik.commons.model.BusinessObject;

import java.util.List;

@Getter
@Setter
public class Worklog implements BusinessObject {
    private int startAt;
    private int maxResults;
    private int total;
    private List<WorklogRecord> worklogs;
}
