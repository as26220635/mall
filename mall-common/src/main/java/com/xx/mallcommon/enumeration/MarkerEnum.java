package com.xx.mallcommon.enumeration;


import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.slf4j.MarkerFactory;

/**
 * Created by 余庚鑫 on 2019/1/1
 * 日志名称
 */
public enum MarkerEnum {
    /**
     * kafka日志名称
     */
    KAFKA(MarkerManager.getMarker("kafkaLog"));

    private Marker marker;

    MarkerEnum(Marker marker) {
        this.marker = marker;
    }

    public Marker getMarker() {
        return this.marker;
    }
}
