/**
 * © 2020 Copyright Amadeus Unauthorised use and disclosure strictly forbidden.
 */
package tr.com.ogedik.commons.util;

import tr.com.ogedik.commons.expection.ErrorException;
import tr.com.ogedik.commons.expection.constants.CommonErrorType;
import tr.com.ogedik.commons.model.AbstractBo;
import tr.com.ogedik.commons.model.MetaInformation;

import java.time.LocalDateTime;

/**
 * @author orkun.gedik
 */
public class MetaUtils {

  /**
   * Fills meta information of the given authentication bo
   *
   * @param bo to be filled {@link AbstractBo}
   * @param authenticatedUsername request owner
   */
  public static void fillMeta(AbstractBo bo, String authenticatedUsername) {
    if (bo == null) {
      throw new ErrorException(CommonErrorType.INVALID_INPUT, "Request Body must not be null.");
    }

    if (bo.getMetaInformation() == null) {
      bo.setMetaInformation(new MetaInformation());
    }

    if (bo.getMetaInformation().getCreatedAt() == null) {
      bo.getMetaInformation().setCreatedAt(LocalDateTime.now());
      bo.getMetaInformation().setCreatedBy(authenticatedUsername);
    } else {
      bo.getMetaInformation().setUpdatedAt(LocalDateTime.now());
      bo.getMetaInformation().setUpdatedBy(authenticatedUsername);
    }
  }
}
