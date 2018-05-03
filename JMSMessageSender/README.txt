JMS message sender (following tutorials on the web) ...

How I did it :

1. Download and install -> ActiveMQ 
http://activemq.apache.org/getting-started.html#GettingStarted-DocumentOrganization 

C:\apache-activemq-5.15.3\bin>activemq start

following (https://dzone.com/articles/java-message-service-jms)

2. Start it, check localhost:8161 for more details and monitor topics/subscribers and so on ...

3. Active the JMSMessageListener on eclipse IDE

4. Export and run JMSMessageSender via command line : java -jar xxx.jar -console -consoleLog