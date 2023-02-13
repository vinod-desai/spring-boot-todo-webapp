package com.java.example.service;

import com.azure.messaging.servicebus.ServiceBusClientBuilder;
import com.azure.messaging.servicebus.ServiceBusMessage;
import com.azure.messaging.servicebus.ServiceBusSenderClient;
import org.springframework.stereotype.Service;

@Service
public class ServiceMessageQueue {
    private static String connectionString = "Endpoint=sb://todoapp-servicebus.servicebus.windows.net/;SharedAccessKeyName=todoapp-queue-policy;SharedAccessKey=vVPZrSEBR1EvK3Lf0zrTqDxMCUhy5oYiK36ejjf0W1M=;EntityPath=todoapp";
    private static String queueName = "todoapp";

    public void sendMessage(String message)
    {
        // create a Service Bus Sender client for the queue
        ServiceBusSenderClient senderClient = new ServiceBusClientBuilder()
                .connectionString(connectionString)
                .sender()
                .queueName(queueName)
                .buildClient();

        // send one message to the queue
        senderClient.sendMessage(new ServiceBusMessage(message));
    }
}
