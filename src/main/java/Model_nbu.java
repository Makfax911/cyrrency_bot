/* Ключ - валюта,
  date - дата,
  bid - продажа,
  ask - покупка,
  trendBid - тренд продажи,
 trendAsk - тренд покупки.*/

public class Model_nbu{
    private String key;
    private  String date;
    private Double bid;
    private Double ask;
    private Double trendBid;
    private Double trendAsk;


    public String getKey() {

        return key;
    }

    public void setKey(String key) {

        this.key = key;
    }
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public Double getBib(double bib) {

        return this.bid;
    }

    public void setBib(Double bid) {
        this.bid = bid;
    }

    public Double getAsk(double ask) {

        return this.ask;
    }

    public void setAsk(Double ask) {

        this.ask = ask;
    }

    public Double getTrendBid() {
        return trendBid;
    }

    public void setTrendBid(Double trendBid) {
        this.trendBid = trendBid;
    }

    public Double getTrendAsk() {
        return trendAsk;
    }

    public void setTrendAsk(Double trendAsk) {
        this.trendAsk = trendAsk;
    }
}

