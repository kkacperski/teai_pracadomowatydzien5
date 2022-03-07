package pl.kacperski.ksb2weather;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Controller
public class WeatherController {
    private static final LocalDate localDate = LocalDate.now();

    private RestTemplate restTemplate;

    private Weather cityWeather = new Weather();

    public WeatherController() {
        this.restTemplate = new RestTemplate();
    }

    private Weather getWeather(String city) {
        String ENDPOINT_URL = "https://goweather.herokuapp.com/weather/";
        ResponseEntity<Weather> exchange = restTemplate.exchange(ENDPOINT_URL + city,
                HttpMethod.GET,
                HttpEntity.EMPTY,
                Weather.class);

        return exchange.getBody();
    }

    @PostMapping("/getCity")
    public String getCity(@RequestParam(value = "city") String city, Model model) {

        System.out.println(city);

        if (city != null) {
            cityWeather = getWeather(city);
            cityWeather.setCityName(city);
            cityWeather.setLocalDate(localDate);

            for (Forecast forecast : cityWeather.getForecast()) {
                forecast.setLocalDate(localDate.plusDays(Integer.parseInt(forecast.getDay())));
            }
        }

        return "redirect:/cityWeather";
    }

    @GetMapping("/cityWeather")
    public String getCityWeather(Model model) {
        model.addAttribute("weather", cityWeather);
        return "cityWeather";
    }
}