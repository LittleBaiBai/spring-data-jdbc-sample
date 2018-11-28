package com.sample.springdatajdbcschema;

import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

public interface MirrorRepository extends CrudRepository<Mirror, Long> {
    @Query("SELECT * FROM mirror WHERE source_uri = :sourceUri")
    Optional<Mirror> findBySourceUri(@Param("sourceUri") String sourceUri);
}
