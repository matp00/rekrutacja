package rekrutacja.Controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rekrutacja.Entity.Currency;
import rekrutacja.Entity.Sorter;
import rekrutacja.Service.OverallService;

import javax.xml.bind.SchemaOutputResolver;
import java.util.List;
import java.util.Map;


@RestController
public class Main {
    @Autowired
    OverallService service;


    @GetMapping("status/ping")
    @ResponseBody
    public String ping(){
        return "<h1>pong</h1>";
    }

    @PostMapping("/numbers/sort-command")
    public List<Integer> sortNumbers(@RequestBody Sorter sorter){
        return service.sortNumbers(sorter);
    }

    @PostMapping("/currencies/get-current-currency-value-command")
    public String currency(@RequestBody Currency currency)  {

        try {
            return service.getCurrencyValue(currency.getCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}

