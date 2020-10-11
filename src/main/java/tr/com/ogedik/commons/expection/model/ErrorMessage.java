package tr.com.ogedik.commons.expection.model;

import lombok.*;
import tr.com.ogedik.commons.model.BusinessObject;

/**
 * @author orkun.gedik
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ErrorMessage implements BusinessObject {
    private Integer status;
    private String title;
    private String detail;
    private String pointer;
    private String parameter;
}
