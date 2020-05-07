package com.hemagni.javaproject;

import java.time.ZonedDateTime;

public interface AbstractZoneTimeClient extends TimeClient {
    
    @Override
    public ZonedDateTime getZonedDateTime(String zoneString);
}
