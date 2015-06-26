/**
 * 
 */
package net.xomak.openinitiative.repository;

import net.xomak.openinitiative.model.Attachment;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.RepositoryDefinition;

/**
 * @author Konstantin Danilov
 *
 */
@RepositoryDefinition(domainClass=Attachment.class, idClass=Long.class)
public interface AttachmentRepository extends CrudRepository<Attachment, Long> {


}
