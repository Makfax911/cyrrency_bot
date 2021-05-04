import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class bot extends TelegramLongPollingBot {

    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new bot());
        }catch (TelegramApiException e){
e.printStackTrace();
        }
    }
public void sendMsg(Message message, String text ){
    SendMessage sendMessage=new SendMessage();
    sendMessage.enableMarkdown(true);
    sendMessage.setChatId(message.getChatId().toString());
    sendMessage.setReplyToMessageId(message.getMessageId());
    sendMessage.setText(text);
    try{
        setButtoms(sendMessage);
        sendMessage(sendMessage);
    }catch (TelegramApiException e){
        e.printStackTrace();
    }
}
    public void onUpdateReceived(Update update) {
       Model_kyrs_v_bankah model_kyrs_v_bankah= new Model_kyrs_v_bankah();
       Model_nbu model_nbu=new Model_nbu();
        Message message = update.getMessage();
        if(message !=null && message.hasText()) {
            switch (message.getText()) {

                case "/start":
                    sendMsg(message, "Привіт цей бот  поможе вам дізнатись конвертацію валют в різних напрямках." +
                            "Виберіть напрямок курсу який вас цікавить ");
                    break;
                case "Курс НБУ":
                    try {
                        sendMsg(message,((Exchanger.getExchanger_nbu(message.getText(), model_nbu))));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case "Курс в банках":
                    try {
                        sendMsg(message, ((Exchanger.getExchanger_kyrs_v_bankah(message.getText(), model_kyrs_v_bankah))));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    sendMsg(message,"Щось пішло не так вибачте за тимчасові незручності ");


            }
        }

    }
public void setButtoms(SendMessage sendMessage){
    ReplyKeyboardMarkup replyKeyboardMarkup=new ReplyKeyboardMarkup();
    sendMessage.setReplyMarkup(replyKeyboardMarkup);
    replyKeyboardMarkup.setSelective(true);
    replyKeyboardMarkup.setResizeKeyboard(true);
    replyKeyboardMarkup.setOneTimeKeyboard(false);


    KeyboardRow keyboardFirstRow1= new KeyboardRow();
    keyboardFirstRow1.add(new KeyboardButton("/start"));

    List<KeyboardRow>keyboardRows=new ArrayList<>();
    KeyboardRow keyboardFirstRow=new KeyboardRow();
    keyboardFirstRow.add(new KeyboardButton("Курс НБУ"));
    keyboardFirstRow.add(new KeyboardButton("Курс в банках"));




    keyboardRows.add(keyboardFirstRow);
    replyKeyboardMarkup.setKeyboard(keyboardRows);

}
    public String getBotUsername() {
        return "typuy_bot";
    }

    public String getBotToken() {
        return "842136063:AAEnXeLD85yVDdgK0g5tUZgenaehGMksIG4";
    }
}
