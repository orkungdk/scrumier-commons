package tr.com.ogedik.commons.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

/**
 * @author orkun.gedik
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JiraUser {

    private String http;

    private String key;

    private String name;

    private String emailAddress;

    private String displayName;

    private String active;

    private String deleted;

    private String timeZone;

    private String locale;

    private String size;

    private Map<String ,String> avatarUrls;

}