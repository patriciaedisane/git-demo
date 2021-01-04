package resources;

import pojo.addPlaceAPI;
import pojo.location;

import java.util.ArrayList;
import java.util.List;

public class testDataBuild {
    public addPlaceAPI addPlacePayLoad() {
        pojo.addPlaceAPI p = new pojo.addPlaceAPI();
        p.setAccuracy(100);
        p.setAddress("101 Street");
        p.setLanguage("French-IN");
        p.setPhone_number("04222053");
        p.setWebsite("www.py.com");
        p.setName("Yvette");

        List<String> myList = new ArrayList<String>();
        myList.add("shoe park");
        myList.add("shop");

        p.setTypes(myList);

        location loc = new location();

        loc.setLat(-38);
        loc.setLng(33);

        return p;

    }
}
