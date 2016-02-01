package com.example.kwame.weatherapp.service;

import com.example.kwame.weatherapp.data.Channel;

/**
 * Created by kwame on 10/10/15.
 */
public interface WeatherServiceCallback  {
    void serviceSuccess(Channel channel);
    void serviceFailure(Exception exception);
}
