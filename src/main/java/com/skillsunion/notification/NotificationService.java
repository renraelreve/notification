package com.skillsunion.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
    TODO:
    - Annotate this class with @Component
    - Inject the Channel and Message instance using @Autowired
*/
@Component
public class NotificationService {
  @Autowired
  private Channel channel;

  private Message message;

  public NotificationService(Channel channel, Message message) {
    this.channel = channel;
    this.message = message;
  }

  public void setup(String to, String message) {
    this.message.setTo(to);
    this.message.setMessage(message);
  }

  public void send() {
    StringBuilder messageBuilder = new StringBuilder();
    messageBuilder.append("To:");
    messageBuilder.append(this.message.getTo());
    messageBuilder.append("\nMessage:");
    messageBuilder.append(this.message.getMessage());
    messageBuilder.append("\nChannel:");
    messageBuilder.append(this.channel.getType());

    System.out.println(messageBuilder.toString());
  }
}
