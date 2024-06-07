package com.skillsunion.notification;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class NotificationApplication {
  @Autowired
  private NotificationService notificationService;

  public static void main(String[] args) {
    SpringApplication.run(NotificationApplication.class, args);
  }

  /*
   * TODO:
   * - Create a @PostConstruct method to be executed after spring container has
   * completed configuration.
   * - Invite input using Scanner and System.in for value "to" and "message".
   * - Set the input to setup(string, string) method in NotificationService.java.
   * - Invoke send() method in Notification.java.
   */
  @PostConstruct
  public void init() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter the recipient (to): ");
    String to = scanner.nextLine();

    System.out.print("Enter the message: ");
    String message = scanner.nextLine();

    notificationService.setup(to, message);
    notificationService.send();
  }
}
