package io.flowsquad.camunda.test.delegates;

import org.springframework.stereotype.Service;

@Service
public class MailingService {

    public void sendMail(String customer) {
        System.out.println("Send Mail to " + customer + "...");
    }

}
