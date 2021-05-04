import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Iterator;
import java.util.Scanner;

public class Exchanger {
    //dbb05023d4e92e3b35fb5b735a3ec0015cc348e0/
    public static String getExchanger_nbu(String message, Model_nbu model ) throws IOException {
        URL url = new URL("https://api.minfin.com.ua/nbu/9d7e578abef43ede1494e5e30481b039b7d9f235/");
        Scanner in = new Scanner((InputStream) url.getContent());
        String result = "";
        while (in.hasNext()) {
            result += in.nextLine();
        }

        JSONObject object=new JSONObject(result);


        JSONObject usd =  object.getJSONObject("usd");
        model.setDate(usd.getString("date"));
        model.setKey(usd.getString("currency"));
        model.setBib(usd.getDouble("bid"));
        model.setAsk(usd.getDouble("ask"));


        JSONObject eur=object.getJSONObject("eur");
        model.setKey(eur.getString("currency"));
        model.setBib(eur.getDouble("bid"));
        model.setAsk(eur.getDouble("ask"));


        JSONObject rub =object.getJSONObject("rub");
        model.setKey(rub.getString("currency"));
        model.setBib(rub.getDouble("bid"));
        model.setAsk(rub.getDouble("ask"));



        return //"Курс НБУ"+"\n"+
                usd.getString("date")+"\n\n"+
                usd.getString("currency")+" "+
                usd.getDouble("bid")+" "+
                usd.getDouble("ask")+"\n"+

                eur.getString("currency")+" "+
                eur.getDouble("bid")+" "+
                eur.getDouble("ask")+"\n"+

                rub.getString("currency")+" "+
                rub.getDouble("bid")+" "+
                rub.getDouble("ask");




    }
    public static String getExchanger_kyrs_v_bankah(String message,Model_kyrs_v_bankah model ) throws IOException{
        URL url=new URL("https://api.minfin.com.ua/summary/9d7e578abef43ede1494e5e30481b039b7d9f235/");
        Scanner in = new Scanner((InputStream) url.getContent());
        String result = "";
        while (in.hasNext()) {
            result += in.nextLine();
        }

        JSONObject object=new JSONObject(result);

        JSONObject usd =  object.getJSONObject("usd");
        model.setBid(usd.getDouble("bid"));
        model.setAsk(usd.getDouble("ask"));

        JSONObject eur =object.getJSONObject("eur");
        model.setBid(eur.getDouble("bid"));
        model.setAsk(eur.getDouble("ask"));

        JSONObject rub =object.getJSONObject("rub");
        model.setBid(rub.getDouble("bid"));
        model.setAsk(rub.getDouble("ask"));

        JSONObject gbp =object.getJSONObject("gbp");
        model.setBid(gbp.getDouble("bid"));
        model.setAsk(gbp.getDouble("ask"));


        return// "Курс в банках"+"\n\n"+
"\n"+
                "usd "+ usd.getDouble("bid")+"  "+
                usd.getDouble("ask")+"\n"+

                "eur "+eur.getDouble("bid")+"  "+
                eur.getDouble("ask")+"\n"+

                "rub "+rub.getDouble("bid")+"  "+
                rub.getDouble("ask")+"\n"+

               "gbp "+gbp.getDouble("bid")+"  "+
                gbp.getDouble("ask");
    }

}

