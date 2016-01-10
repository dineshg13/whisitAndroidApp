package whisit.repository;

import whisit.model.place.PlaceEvent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoPage;
import org.springframework.data.geo.Point;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import whisit.repo.IdRepository;

/**
 * Created by dinesh on 12/6/2015.
 */
public interface PlaceEventRepository extends IdRepository<PlaceEvent> {

    GeoPage<PlaceEvent> findByLocationNear(@Param("point") Point point, @Param("max") Distance max, Pageable pageable);

    @RestResource(path = "nearLoc", rel = "nearLoc")
    Page<PlaceEvent> findByLocationNear(@Param("point") Point point, Pageable pageable);

}
