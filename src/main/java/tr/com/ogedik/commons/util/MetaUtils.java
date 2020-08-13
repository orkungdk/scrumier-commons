package tr.com.ogedik.commons.util;

import tr.com.ogedik.commons.expection.ErrorException;
import tr.com.ogedik.commons.expection.constants.CommonErrorType;
import tr.com.ogedik.commons.model.AbstractBo;
import tr.com.ogedik.commons.model.MetaInformation;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author orkun.gedik
 */
public class MetaUtils {

  /**
   * Fills meta information of the given the list of authentication bo
   *
   * @param bos to be filled List<{@link AbstractBo}>
   * @param authenticatedUsername request owner
   */
  public static <T extends AbstractBo> void fillMetaList(List<T> bos, String authenticatedUsername) {
    if (bos == null || bos.isEmpty()) {
      throw new ErrorException(CommonErrorType.INVALID_INPUT, "Request body must not be null");
    }
    bos.forEach(bo -> fillMeta(bo, authenticatedUsername));
  }

  /**
   * Fills meta information of the given authentication bo
   *
   * @param bo to be filled {@link AbstractBo}
   * @param authenticatedUsername request owner
   */
  public static <T extends AbstractBo> void fillMeta(T bo, String authenticatedUsername) {
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
