package casting.movie.audition.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import casting.movie.audition.R;
import casting.movie.audition.models.ChatAdapter;

public class ChatbotActivity extends AppCompatActivity {

    private RecyclerView chatRecyclerView;
    private EditText messageEditText;
    private ImageButton sendButton;
    private ChatAdapter chatAdapter;
    private List<String> chatMessages;
    LinearLayout ll;

    int flag=0;
    String name,emailid,phone;
    final Handler handler = new Handler();
    final int delay = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatbot);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        chatRecyclerView = findViewById(R.id.chatRecyclerView);
        messageEditText = findViewById(R.id.messageEditText);
        sendButton = findViewById(R.id.sendButton);
        ll=findViewById(R.id.ll);

        chatMessages = new ArrayList<>();
        chatAdapter = new ChatAdapter(chatMessages);
        chatRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        chatRecyclerView.setAdapter(chatAdapter);

        handler.postDelayed(new Runnable() {
            public void run() {
                generateBotResponse("Hi. I am a smart bot that can get some information from you and have someone contact you right away.");
            }
        }, 500);
        handler.postDelayed(new Runnable() {
            public void run() {
                generateBotResponse("What's your name?");
            }
        }, 1500);


        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = messageEditText.getText().toString().trim();
                if (!message.isEmpty()) {

                    sendMessage(message);
//                    messageEditText.setText("");

                    flag++;

                    switch (flag){
                        case 1: name=messageEditText.getText().toString().trim();
                            messageEditText.setText("");

                            handler.postDelayed(new Runnable() {
                                public void run() {
                                    generateBotResponse("How about your email?");
                                }
                            }, delay);

                            break;
                        case 2: emailid=messageEditText.getText().toString().trim();
                            messageEditText.setText("");
                            handler.postDelayed(new Runnable() {
                                public void run() {
                                    generateBotResponse("What's your phone number?");
                                }
                            }, delay);

                            break;
                        case 3: phone=messageEditText.getText().toString().trim();
                            messageEditText.setText("");
                            handler.postDelayed(new Runnable() {
                                public void run() {
                                    generateBotResponse("Perfect. Thank you. I'll have someone contact you soon.");
                                }
                            }, delay);

                            ll.setVisibility(View.INVISIBLE);
                            break;
                        default: messageEditText.setText("");
                            generateBotResponse("I didn't recognize that as an email. Please enter a valid email.");
                            break;
                    }


//                    if(flag==1){
//                        messageEditText.setText("");
//                        generateBotResponse("How about your email?");
//                    }
//
//                    else if(!messageEditText.getText().toString().contains("@") || !messageEditText.getText().toString().contains(".") ){
//                        messageEditText.setText("");
//                        generateBotResponse("I didn't recognize that as an email. Please enter a valid email.");
//                        generateBotResponse("How about your email?");
//                    }
//
//                    else {
//                        messageEditText.setText("");
//                        generateBotResponse("What's your phone number?");
//
//                    }

//                    if ( messageEditText.getText().toString().matches("[0-9]+")){
//                        generateBotResponse("Perfect. Thank you. I'll have someone contact you soon.");
//                    }
//                    else{
//                        generateBotResponse("Please tell me a phone number.");
//                        generateBotResponse("What's your phone number?");
//                    }
//                    else{
//                        generateBotResponse("Please tell me a phone number.");
//                        generateBotResponse("What's your phone number?");
//                    }
//                    generateBotResponse("Please tell me a phone number.");
//                    generateBotResponse("What's your phone number?");
//                    generateBotResponse("Perfect. Thank you. I'll have someone contact you soon.");
                }

//                Toast.makeText(MainActivity.this, "name:"+name+emailid+phone, Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void sendMessage(String message) {

        chatAdapter.addMessage("You : " + message);
        chatRecyclerView.smoothScrollToPosition(chatMessages.size() - 1);
    }

    private void generateBotResponse(String message) {
        // TODO: Implement your chatbot logic here to generate appropriate responses
        // You can use if-else statements, switch-case, or any other method for response generation
        // For simplicity, we'll just echo the user's message as a bot response

        chatAdapter.addMessage(message);
        chatRecyclerView.smoothScrollToPosition(chatMessages.size() - 1);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}