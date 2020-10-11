package tr.com.ogedik.commons.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * @author orkun.gedik
 */
@MappedSuperclass
@Getter
@Setter
@ToString
public class ResourceEntity extends AbstractEntity{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(updatable = false, nullable = false)
  private Long resourceId;

}
