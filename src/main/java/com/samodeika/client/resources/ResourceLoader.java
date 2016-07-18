package com.samodeika.client.resources;

import org.fusesource.restygwt.client.Defaults;

import javax.inject.Inject;

public class ResourceLoader {

//    static {
//        Defaults.setServiceRoot("/");
//    }
//

    @Inject
    ResourceLoader(AppResources appResources) {
        appResources.normalize().ensureInjected();
        appResources.style().ensureInjected();
    }
}
