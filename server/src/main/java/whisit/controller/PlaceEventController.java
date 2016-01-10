package whisit.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.PropertiesEditor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoPage;
import org.springframework.data.geo.GeoResult;
import org.springframework.data.geo.Point;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import whisit.model.place.PlaceEvent;
import whisit.repository.PlaceEventRepository;

import java.util.Properties;


/**
 * Created by dinesh on 12/13/2015.
 */
@RepositoryRestController
public class PlaceEventController {

    public Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PlaceEventRepository placeEventRepository;


    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Point.class, new PropertiesEditor() {

            public void setAsText(String text) {
                String[] arr = text.split(",");
                Double x = Double.valueOf(arr[1]);
                Double y = Double.valueOf(arr[0]);

                setValue(new Point(x, y));
            }

            public void setValue(Point p) {

                Properties props = new Properties();
                props.put("point", p.getX() + "," + p.getY());
                LOGGER.info("Calling setValue props:" + props);
                super.setValue(props);
            }
        });
    }


    @RequestMapping(method = RequestMethod.GET, value = "/placeEvents/search/listplaces")
    public
    @ResponseBody
    ResponseEntity<?> getNearBy(@RequestParam(value = "point") Point point, @RequestParam(value = "max", defaultValue = "1mi") Distance max
            , @RequestParam(value = "page", defaultValue = "0") Integer page
            , @RequestParam(value = "size", defaultValue = "20") Integer size) {
//        Point point = new Point(-73.99528, 40.71306);

        GeoPage<PlaceEvent> placeEventGeoResults = placeEventRepository.findByLocationNear(point, max,
                new PageRequest(page, size, new Sort(new Sort.Order("distance"))));
        LOGGER.info("Context size:" + placeEventGeoResults.getTotalElements() + ", size:" + placeEventGeoResults.getNumberOfElements());
        PagedResources<GeoResult<PlaceEvent>> resources = new PagedResources<GeoResult<PlaceEvent>>(placeEventGeoResults.getContent(), new PagedResources.PageMetadata(placeEventGeoResults.getSize(), placeEventGeoResults.getNumber(), placeEventGeoResults.getTotalElements(), placeEventGeoResults.getTotalPages()));

//        resources.add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(PlaceEventController.class).getNearBy(point, max, page, size)).withSelfRel());
//        String url = ControllerLinkBuilder.linkTo(this).withSelfRel().getRel();
//        LOGGER.info("url:" + url);
        return ResponseEntity.ok(resources);

    }
}
