package stepdefs;

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
        Assertions.assertEquals(Integer.parseInt(params.get("id")), response.getCurrent().getWeathers().get(0).getId(), "Incorrect ID!");
        Assertions.assertEquals(params.get("main"), response.getCurrent().getWeathers().get(0).getMain(), "Incorrect MAIN!");
        Assertions.assertEquals(params.get("description"), response.getCurrent().getWeathers().get(0).getDescription(), "Incorrect DESCRIPTION!");
        Assertions.assertEquals(params.get("icon"), response.getCurrent().getWeathers().get(0).getIcon(), "Incorrect ICON!");
    }

    @Then("minutely weather data is:")
    public void minutely_weather_check(Map<String, String> params) {
        Assertions.assertEquals(Long.parseLong(params.get("dt")), response.getMinutelies().get(0).getDt(), "Incorrect MN DT!");
        Assertions.assertEquals(Integer.parseInt(params.get("precipitation")), response.getMinutelies().get(0).getPrecipitation(), "Incorrect MN PRECIPITATION!");

    }

    @Then("hourly weather data is:")
    public void hourly_weather_check(Map<String, String> params) {
        Assertions.assertEquals(Long.parseLong(params.get("dt")), response.getHourlies().get(0).getDt(), "Incorrect HOURLY DT!");
        Assertions.assertEquals(Double.parseDouble(params.get("temp")), response.getHourlies().get(0).getTemp(), "Incorrect HOURLY TEMP!");
        Assertions.assertEquals(Double.parseDouble(params.get("feels_like")), response.getHourlies().get(0).getFeelsLike(), "Incorrect HOURLY FELLS LIKE!");
        Assertions.assertEquals(Integer.parseInt(params.get("pressure")), response.getHourlies().get(0).getPressure(), "Incorrect HOURLY PRESSURE!");
        Assertions.assertEquals(Integer.parseInt(params.get("humidity")), response.getHourlies().get(0).getHumidity(), "Incorrect HOURLY HUMIDITY!");
        Assertions.assertEquals(Double.parseDouble(params.get("dew_point")), response.getHourlies().get(0).getDewPoint(), "Incorrect HOURLY DEW POINT!");
        Assertions.assertEquals(Double.parseDouble(params.get("uvi")), response.getHourlies().get(0).getUvi());
        Assertions.assertEquals(Integer.parseInt(params.get("clouds")), response.getHourlies().get(0).getClouds());
        Assertions.assertEquals(Integer.parseInt(params.get("visibility")), response.getHourlies().get(0).getVisibility());
        Assertions.assertEquals(Double.parseDouble(params.get("wind_speed")), response.getHourlies().get(0).getWindSpeed());
        Assertions.assertEquals(Integer.parseInt(params.get("wind_deg")), response.getHourlies().get(0).getWindDeg());
        Assertions.assertEquals(Double.parseDouble(params.get("wind_gust")), response.getHourlies().get(0).getWindGust());
        Assertions.assertEquals(Double.parseDouble(params.get("pop")), response.getHourlies().get(0).getPop());
    }

    @Then("hourly weather details are:")
    public void hourly_weather_details_check(Map<String, String> params) {
        Assertions.assertEquals(Integer.parseInt(params.get("id")), response.getHourlies().get(0).getHourlyWeathers().get(0).getId());
        Assertions.assertEquals(params.get("main"), response.getHourlies().get(0).getHourlyWeathers().get(0).getMain());
        Assertions.assertEquals(params.get("description"), response.getHourlies().get(0).getHourlyWeathers().get(0).getDescription());
        Assertions.assertEquals(params.get("icon"), response.getHourlies().get(0).getHourlyWeathers().get(0).getIcon());
    }

    @Then("daily weather data is:")
    public void daily_weather_check(Map<String, String> params) {
        Assertions.assertEquals(Long.parseLong(params.get("dt")), response.getDailies().get(0).getDt());
        Assertions.assertEquals(Long.parseLong(params.get("sunrise")), response.getDailies().get(0).getSunrise());
        Assertions.assertEquals(Long.parseLong(params.get("sunset")), response.getDailies().get(0).getSunset());
        Assertions.assertEquals(Long.parseLong(params.get("moonrise")), response.getDailies().get(0).getMoonrise());
        Assertions.assertEquals(Long.parseLong(params.get("moonset")), response.getDailies().get(0).getMoonset());
        Assertions.assertEquals(Double.parseDouble(params.get("moon_phase")), response.getDailies().get(0).getMoonPhase());
        Assertions.assertEquals(Integer.parseInt(params.get("pressure")), response.getDailies().get(0).getPressure());
        Assertions.assertEquals(Integer.parseInt(params.get("humidity")), response.getDailies().get(0).getHumidity());
        Assertions.assertEquals(Double.parseDouble(params.get("dew_point")), response.getDailies().get(0).getDewPoint());
        Assertions.assertEquals(Double.parseDouble(params.get("wind_speed")), response.getDailies().get(0).getWindSpeed());
        Assertions.assertEquals(Integer.parseInt(params.get("wind_deg")), response.getDailies().get(0).getWindDeg());
        Assertions.assertEquals(Double.parseDouble(params.get("wind_gust")), response.getDailies().get(0).getWindGust());
        Assertions.assertEquals(Integer.parseInt(params.get("clouds")), response.getDailies().get(0).getClouds());
        Assertions.assertEquals(Double.parseDouble(params.get("pop")), response.getDailies().get(0).getPop());
        Assertions.assertEquals(Double.parseDouble(params.get("rain")), response.getDailies().get(0).getRain());
        Assertions.assertEquals(Double.parseDouble(params.get("uvi")), response.getDailies().get(0).getUvi());
    }

    @Then("daily temperature weather details are:")
    public void daily_temperature_weather_check(Map<String, String> params) {
        Assertions.assertEquals(Double.parseDouble(params.get("day")), response.getDailies().get(0).getTemps().get(0).getDay());
        Assertions.assertEquals(Double.parseDouble(params.get("min")), response.getDailies().get(0).getTemps().get(0).getMin());
        Assertions.assertEquals(Double.parseDouble(params.get("max")), response.getDailies().get(0).getTemps().get(0).getMax());
        Assertions.assertEquals(Double.parseDouble(params.get("night")), response.getDailies().get(0).getTemps().get(0).getNight());
        Assertions.assertEquals(Double.parseDouble(params.get("eve")), response.getDailies().get(0).getTemps().get(0).getEve());
        Assertions.assertEquals(Double.parseDouble(params.get("morn")), response.getDailies().get(0).getTemps().get(0).getMorn());
    }

    @Then("daily feels like weather details are:")
    public void daily_feels_like_weather_check(Map<String, String> params) {
        Assertions.assertEquals(Double.parseDouble(params.get("day")), response.getDailies().get(0).getFeelsLikes().get(0).getDay());
        Assertions.assertEquals(Double.parseDouble(params.get("night")), response.getDailies().get(0).getFeelsLikes().get(0).getNight());
        Assertions.assertEquals(Double.parseDouble(params.get("eve")), response.getDailies().get(0).getFeelsLikes().get(0).getEve());
        Assertions.assertEquals(Double.parseDouble(params.get("morn")), response.getDailies().get(0).getFeelsLikes().get(0).getMorn());
    }

    @Then("daily weather details are:")
    public void daily_weather_details_check(Map<String, String> params) {
        Assertions.assertEquals(Integer.parseInt(params.get("id")), response.getDailies().get(0).getDailyWeathers().get(0).getId());
        Assertions.assertEquals(params.get("main"), response.getDailies().get(0).getDailyWeathers().get(0).getMain());
        Assertions.assertEquals(params.get("description"), response.getDailies().get(0).getDailyWeathers().get(0).getDescription());
        Assertions.assertEquals(params.get("icon"), response.getDailies().get(0).getDailyWeathers().get(0).getIcon());
    }

    @Then("alerts weather data is:")
    public void alerts_weather_check(Map<String, String> params) {
        Assertions.assertEquals(params.get("sender_name"), response.getAlerts().get(0).getSenderName());
        Assertions.assertEquals(params.get("event"), response.getAlerts().get(0).getEvent());
        Assertions.assertEquals(Long.parseLong(params.get("start")), response.getAlerts().get(0).getStart());
        Assertions.assertEquals(Long.parseLong(params.get("end")), response.getAlerts().get(0).getEnd());
        Assertions.assertEquals(params.get("description"), response.getAlerts().get(0).getDescription());
    }

    @Then("alerts tags weather details are:")
    public void alerts_tags_weather_check(Map<String, String> params) {
        Assertions.assertEquals(params.get("tags"), response.getAlerts().get(0).getTags());
    }
}
