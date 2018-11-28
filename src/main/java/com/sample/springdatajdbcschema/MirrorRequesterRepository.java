package com.sample.springdatajdbcschema;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

public interface MirrorRequesterRepository extends CrudRepository<MirrorRequester, Long> {
    @Query("SELECT mreq.id AS id, mreq.service_instance_id AS service_instance_id, p.id AS parameters_id, p.parameters AS parameters_parameters " +
            "FROM mirror_requester mreq " +
            "LEFT OUTER JOIN config_server_parameters p ON p.mirror_requester = mreq.id " +
            "WHERE mreq.service_instance_id = :serviceInstanceId")
    List<MirrorRequester> findByServiceInstanceId(@Param("serviceInstanceId") String serviceInstanceId);

    @Override
    boolean existsById(Long aLong);
}
