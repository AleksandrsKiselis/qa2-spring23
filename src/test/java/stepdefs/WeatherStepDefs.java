package stepdefs;

import com.beust.ah.A;
import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.weather.WeatherResponse;
import org.junit.jupiter.api.Assertions;
import requesters.WeatherRequester;

import java.util.Map;

public class WeatherStepDefs {
    private long cityId;
    private WeatherResponse response;

    @Given("city ID is {long}")
    public void set_city_id(long cityId) {
        this.cityId = cityId;
    }

    @When("we are requesting weather forecast")
    public void request_weather() throws JsonProcessingException {
        WeatherRequester requester = new WeatherRequester();
        response = requester.requestWeather(cityId);
    }

    @Then("latitude is {double}")
    public void latitude_check(double latitude) {
        Assertions.assertEquals(latitude, response.getLat(), "Incorrect Latitude!");
    }

    @Then("longitude is {double}")
    public void longitude_check(double longitude) {
        Assertions.assertEquals(longitude, response.getLon(), "Incorrect Longitude!");
    }

    @Then("timezone is {string}")
    public void timezone_check(String timezone) {
        Assertions.assertEquals(timezone, response.getTimezone(), "Incorrect timezone!");
    }

    @Then("timezone offset is {int}")
    public void timezone_offset_check(int offset) {
        Assertions.assertEquals(offset, response.getTimezoneOffset(), "Incorrect offset!");
    }

    @Then("current weather data is:")
    public void current_weather_check(Map<String, String> params) {
        Assertions.assertEquals(Long.parseLong(params.get("dt")), response.getCurrent().getDt(), "Incorrect DT!");
        Assertions.assertEquals(Long.parseLong(params.get("sunrise")), response.getCurrent().getSunrise(), "Incorrect SUNRISE!");
        Assertions.assertEquals(Long.parseLong(params.get("sunset")), response.getCurrent().getSunset(), "Incorrect SUNSET!");
        Assertions.assertEquals(Double.parseDouble(params.get("temp")), response.getCurrent().getTemp(), "Incorrect TEMP!");
        Assertions.assertEquals(Double.parseDouble(params.get("feels_like")), response.getCurrent().getFeelsLike(), "Incorrect FELLS LIKE!");
        Assertions.assertEquals(Integer.parseInt(params.get("pressure")), response.getCurrent().getPressure(), "Incorrect PRESSURE");
        Assertions.assertEquals(Integer.parseInt(params.get("humidity")), response.getCurrent().getHumidity(), "Incorrect HUMIDITY!");
        Assertions.assertEquals(Double.parseDouble(params.get("dew_point")), response.getCurrent().getDewPoint(), "Incorrect DEW POINT");
        Assertions.assertEquals(Double.parseDouble(params.get("uvi")), response.getCurrent().getUvi(), "Incorrect UVI!");
        Assertions.assertEquals(Integer.parseInt(params.get("clouds")), response.getCurrent().getClouds(), "Incorrect CLOUDS!");
        Assertions.assertEquals(Integer.parseInt(params.get("visibility")), response.getCurrent().getVisibility(), "Incorrect VISIBILITY");
        Assertions.assertEquals(Double.parseDouble(params.get("wind_speed")), response.getCurrent().getWindSpeed(), "Incorrect WIND SPEED!");
        Assertions.assertEquals(Integer.parseInt(params.get("wind_deg")), response.getCurrent().getWindDeg(), "Incorrect WIND DEG!");
        Assertions.assertEquals(Double.parseDouble(params.get("wind_gust")), response.getCurrent().getWindGust(), "Incorrect WIND GUST!");

    }

    @Then("current weather details are:")
    public void current_weather_details_check(Map<String, String> params) {
        Assertions.assertEquals(Integer.parseInt(params.get("id")), response.getCurrent().getWeathers(), "Incorrect ID!");
        Assertions.assertEquals(params.get("main"), response.getCurrent().getWeathers(), "Incorrect MAIN!");
        Assertions.assertEquals(params.get("description"), response.getCurrent().getWeathers(), "Incorrect DESCRIPTION!");
        Assertions.assertEquals(params.get("icon"), response.getCurrent().getWeathers(), "Incorrect ICON!");
    }

    @Then("minutely weather data is:")
    public void minutely_weather_check(Map<String, String> params) {
        Assertions.assertEquals(Long.parseLong(params.get("dt")), response.getMinutelies(), "Incorrect DT!");
        Assertions.assertEquals(Integer.parseInt(params.get("precipitation")), response.getMinutelies(), "Incorrect PRECIPITATION!");

    }

    @Then("hourly weather data is:")
    public void hourly_weather_check(Map<String, String> params) {
        Assertions.assertEquals(Long.parseLong(params.get("dt")), response.getHourlies(), "Incorrect DT!");
        Assertions.assertEquals(Double.parseDouble(params.get("temp")), response.getHourlies(), "Incorrect TEMP!");
        Assertions.assertEquals(Double.parseDouble(params.get("feels_like")), response.getHourlies(), "Incorrect FELLS LIKE!");
        Assertions.assertEquals(Integer.parseInt(params.get("pressure")), response.getHourlies(), "Incorrect PRESSURE!");
        Assertions.assertEquals(Integer.parseInt(params.get("humidity")), response.getHourlies(), "Incorrect HUMIDITY!");
        Assertions.assertEquals(Double.parseDouble(params.get("dew_point")), response.getHourlies(), "Incorrect DEW POINT!");
        Assertions.assertEquals(Double.parseDouble(params.get("uvi")), response.getHourlies());
        Assertions.assertEquals(Integer.parseInt(params.get("clouds")), response.getHourlies());
        Assertions.assertEquals(Integer.parseInt(params.get("visibility")), response.getHourlies());
        Assertions.assertEquals(Double.parseDouble(params.get("wind_speed")), response.getHourlies());
        Assertions.assertEquals(Integer.parseInt(params.get("wind_deg")), response.getHourlies());
        Assertions.assertEquals(Double.parseDouble(params.get("wind_gust")), response.getHourlies());
        Assertions.assertEquals(Double.parseDouble(params.get("pop")), response.getHourlies());
    }

    @Then("hourly weather details are:")
    public void hourly_weather_details_check(Map<String, String> params) {
        Assertions.assertEquals(Integer.parseInt(params.get("id")), response.getHourlies());
        Assertions.assertEquals(params.get("main"), response.getHourlies());
        Assertions.assertEquals(params.get("description"), response.getHourlies());
        Assertions.assertEquals(params.get("icon"), response.getHourlies());
    }

    @Then("daily weather data is:")
    public void daily_weather_check(Map<String, String> params) {
        Assertions.assertEquals(Long.parseLong(params.get("dt")), response.getDailies());
        Assertions.assertEquals(Long.parseLong(params.get("sunrise")), response.getDailies());
        Assertions.assertEquals(Long.parseLong(params.get("sunset")), response.getDailies());
        Assertions.assertEquals(Long.parseLong(params.get("moonrise")), response.getDailies());
        Assertions.assertEquals(Long.parseLong(params.get("moonset")), response.getDailies());
        Assertions.assertEquals(Double.parseDouble(params.get("moon_phase")), response.getDailies());
        Assertions.assertEquals(Integer.parseInt(params.get("pressure")), response.getDailies());
        Assertions.assertEquals(Integer.parseInt(params.get("humidity")), response.getDailies());
        Assertions.assertEquals(Double.parseDouble(params.get("dew_point")), response.getDailies());
        Assertions.assertEquals(Double.parseDouble(params.get("wind_speed")), response.getDailies());
        Assertions.assertEquals(Integer.parseInt(params.get("wind_deg")), response.getDailies());
        Assertions.assertEquals(Double.parseDouble(params.get("wind_gust")), response.getDailies());
        Assertions.assertEquals(Integer.parseInt(params.get("clouds")), response.getDailies());
        Assertions.assertEquals(Double.parseDouble(params.get("pop")), response.getDailies());
        Assertions.assertEquals(Double.parseDouble(params.get("rain")), response.getDailies());
        Assertions.assertEquals(Double.parseDouble(params.get("uvi")), response.getDailies());
    }

    @Then("daily temperature weather details are:")
    public void daily_temperature_weather_check(Map<String, String> params) {
        Assertions.assertEquals(Double.parseDouble(params.get("day")), response.getDailies());
        Assertions.assertEquals(Double.parseDouble(params.get("min")), response.getDailies());
        Assertions.assertEquals(Double.parseDouble(params.get("max")), response.getDailies());
        Assertions.assertEquals(Double.parseDouble(params.get("night")), response.getDailies());
        Assertions.assertEquals(Double.parseDouble(params.get("eve")), response.getDailies());
        Assertions.assertEquals(Double.parseDouble(params.get("morn")), response.getDailies());
    }

    @Then("daily feels like weather details are:")
    public void daily_feels_like_weather_check(Map<String, String> params) {
        Assertions.assertEquals(Double.parseDouble(params.get("day")), response.getDailies());
        Assertions.assertEquals(Double.parseDouble(params.get("night")), response.getDailies());
        Assertions.assertEquals(Double.parseDouble(params.get("eve")), response.getDailies());
        Assertions.assertEquals(Double.parseDouble(params.get("morn")), response.getDailies());
    }

    @Then("daily weather details are:")
    public void daily_weather_details_check(Map<String, String> params) {
        Assertions.assertEquals(Integer.parseInt(params.get("id")), response.getDailies());
        Assertions.assertEquals(params.get("main"), response.getDailies());
        Assertions.assertEquals(params.get("description"), response.getDailies());
        Assertions.assertEquals(params.get("icon"), response.getDailies());
    }

    @Then("alerts weather data is:")
    public void alerts_weather_check(Map<String, String> params) {
        Assertions.assertEquals(params.get("sender_name"), response.getAlerts());
        Assertions.assertEquals(params.get("event"), response.getAlerts());
        Assertions.assertEquals(Long.parseLong(params.get("start")), response.getAlerts());
        Assertions.assertEquals(Long.parseLong(params.get("end")), response.getAlerts());
        Assertions.assertEquals(params.get("description"), response.getAlerts());
    }

    @Then("alerts tags weather details are:")
    public void alerts_tags_weather_check() {

    }
}
