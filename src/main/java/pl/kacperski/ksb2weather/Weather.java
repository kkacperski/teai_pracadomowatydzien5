
package pl.kacperski.ksb2weather;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "temperature",
    "wind",
    "description",
    "forecast"
})
@Generated("jsonschema2pojo")
public class Weather {

    @JsonProperty("temperature")
    private String temperature;
    @JsonProperty("wind")
    private String wind;
    @JsonProperty("description")
    private String description;
    @JsonProperty("forecast")
    private List<Forecast> forecast = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    private String cityName;
    private LocalDate localDate;

    @JsonProperty("temperature")
    public String getTemperature() {
        return temperature;
    }

    @JsonProperty("temperature")
    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    @JsonProperty("wind")
    public String getWind() {
        return wind;
    }

    @JsonProperty("wind")
    public void setWind(String wind) {
        this.wind = wind;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("forecast")
    public List<Forecast> getForecast() {
        return forecast;
    }

    @JsonProperty("forecast")
    public void setForecast(List<Forecast> forecast) {
        this.forecast = forecast;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "temperature='" + temperature + '\'' +
                ", wind='" + wind + '\'' +
                ", description='" + description + '\'' +
                ", forecast=" + forecast +
                ", additionalProperties=" + additionalProperties +
                ", cityName='" + cityName + '\'' +
                ", LocalDate='" + localDate + '\'' +
                '}';
    }
}
