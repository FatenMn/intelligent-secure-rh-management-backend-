package tn.sesame.rhmanagementbackend.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.sesame.rhmanagementbackend.Entities.User;

import java.util.UUID;
@Repository
public interface EmbeddingModelRepository extends JpaRepository<User, UUID> {
}
