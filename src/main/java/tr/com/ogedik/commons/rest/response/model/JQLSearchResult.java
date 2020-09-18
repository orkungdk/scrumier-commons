package tr.com.ogedik.commons.rest.response.model;

import lombok.Getter;
import lombok.Setter;
import tr.com.ogedik.commons.model.BusinessObject;

import java.util.List;


/*
*
* @author enes.erciyes
* */

@Getter
public class JQLSearchResult implements BusinessObject {
    int maxResults;
    int startAt;
    int total;
    List<Issue> issues;
}
