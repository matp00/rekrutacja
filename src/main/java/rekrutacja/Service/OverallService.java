package rekrutacja.Service;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import org.springframework.stereotype.Service;
import rekrutacja.Entity.Currency;
import rekrutacja.Entity.Sorter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Comparator;
import java.util.List;

@Service
public class OverallService {
    public List<Integer> sortNumbers(Sorter sorter){
        List<Integer> list = sorter.getList();

        if(sorter.getOrder().equals("ASC")){
            list.sort(Comparator.naturalOrder());
            sorter.setList(list);
        }
        else {
            list.sort(Comparator.reverseOrder());
            sorter.setList(list);
        }
        return sorter.getList();
    }


    public  String getCurrencyValue(String currency) throws Exception  {

            String url = "http://api.nbp.pl/api/exchangerates/tables/A?format=json";
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine.subSequence(1, inputLine.length() - 1));

            }
            in.close();
            JSONObject object = new JSONObject(response.toString());
            JSONArray array = object.getJSONArray("rates");
            for (int i = 0; i < array.length(); i++) {
                if (array.getJSONObject(i).getString("code").equalsIgnoreCase(currency))
                    return String.valueOf(array.getJSONObject(i).getDouble("mid"));
            }

            return "No such element";
    }

}
