package com.security.java17.services;

import com.security.java17.model.ServerData;

/**
 * Service providing protected data.
 */
public interface DataService {

    /**
     * Get data for source.
     * @param source source identifier or name.
     * @return
     */
    ServerData getSecuredData(String source);

}
