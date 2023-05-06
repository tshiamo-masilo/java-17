package com.security.java17.services;
import com.security.java17.model.ServerData;
import org.springframework.stereotype.Service;

@Service
public class DataServiceImpl implements DataService {

    @Override
    public ServerData getSecuredData(String source) {
        return new ServerData(source, "Some Data", System.currentTimeMillis());
    }

}
