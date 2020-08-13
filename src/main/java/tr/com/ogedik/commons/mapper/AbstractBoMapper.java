package tr.com.ogedik.commons.mapper;

import org.mapstruct.AfterMapping;
import org.mapstruct.MappingTarget;
import tr.com.ogedik.commons.entity.AbstractEntity;
import tr.com.ogedik.commons.model.AbstractBo;
import tr.com.ogedik.commons.model.MetaInformation;
import tr.com.ogedik.commons.util.ListUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author orkun.gedik
 */
public abstract class AbstractBoMapper<I extends AbstractBo, O extends AbstractEntity> {

  public abstract I convert(O entity);

  public abstract O convert(I model);

  public List<I> convert(List<O> entities) {
    return ListUtils.emptyIfNull(entities).stream().map(entity -> convert(entity)).collect(Collectors.toList());
  }

  @AfterMapping
  public void fillEntityMeta(I model, @MappingTarget O entity) {
    if (model.getMetaInformation() == null) {
      return;
    }
    entity.setCreatedAt(model.getMetaInformation().getCreatedAt());
    entity.setCreatedBy(model.getMetaInformation().getCreatedBy());
    entity.setUpdatedAt(model.getMetaInformation().getUpdatedAt());
    entity.setUpdatedBy(model.getMetaInformation().getUpdatedBy());
  }

  @AfterMapping
  public void fillModelMeta(O entity, @MappingTarget I model) {
    if (model.getMetaInformation() == null) {
      model.setMetaInformation(new MetaInformation());
    }
    model.getMetaInformation().setCreatedAt(entity.getCreatedAt());
    model.getMetaInformation().setCreatedBy(entity.getCreatedBy());
    model.getMetaInformation().setUpdatedAt(entity.getUpdatedAt());
    model.getMetaInformation().setUpdatedBy(entity.getUpdatedBy());
  }
}
