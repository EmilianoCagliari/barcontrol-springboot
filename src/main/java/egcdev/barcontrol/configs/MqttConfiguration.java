package egcdev.barcontrol.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessageProducer;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;

@Configuration
public class MqttConfiguration {


    @Value("${security.mqtt.url}")
    private String mqtt_url;
    @Value("${security.mqtt.topic-peso}")
    private String mqtt_topic_peso;

    @Value("${security.mqtt.topic-status}")
    private String mqtt_topic_status;


    // Canal para el tópico de peso
    @Bean
    public MessageChannel mqttInputChannelPeso() {
        return new DirectChannel();
    }

    // Canal para el tópico de estado del dispositivo
    @Bean
    public MessageChannel mqttInputChannelStatus() {
        return new DirectChannel();
    }
    @Bean
    public MessageProducer inbound() {
        MqttPahoMessageDrivenChannelAdapter adapter =
                new MqttPahoMessageDrivenChannelAdapter(mqtt_url, "springClientPeso", mqtt_topic_peso );
                adapter.setConverter( new DefaultPahoMessageConverter());
                adapter.setQos(1);
                adapter.setOutputChannel( mqttInputChannelPeso() );

        return adapter;
    }

    // Adapter para el tópico de estado del dispositivo
    @Bean
    public MessageProducer inboundStatus() {
        MqttPahoMessageDrivenChannelAdapter adapter =
                new MqttPahoMessageDrivenChannelAdapter(mqtt_url, "springClientStatus", mqtt_topic_status);
        adapter.setConverter(new DefaultPahoMessageConverter());
        adapter.setQos(1);
        adapter.setOutputChannel(mqttInputChannelStatus());
        return adapter;
    }

    @Bean
    @ServiceActivator( inputChannel = "mqttInputChannelPeso")
    public MessageHandler handler() {
        return message -> {
          String payload = message.getPayload().toString();
            System.out.println("Peso recibido: " + payload );
        };
    }

    // Handler para el tópico de estado del dispositivo
    @Bean
    @ServiceActivator(inputChannel = "mqttInputChannelStatus")
    public MessageHandler handlerStatus() {
        return message -> {
            String payload = message.getPayload().toString();
            if ("connected".equals(payload)) {
                System.out.println("Dispositivo conectado");
                // Acciones cuando el dispositivo se conecta
            } else if ("disconnected".equals(payload)) {
                System.out.println("Dispositivo desconectado");
                // Acciones cuando el dispositivo se desconecta
            }
        };
    }
}
