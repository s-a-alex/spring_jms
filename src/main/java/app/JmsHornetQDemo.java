package app;

import config.AppHornetQConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import util.MessageSender;

import java.util.Arrays;

public class JmsHornetQDemo {
    public static void main(String... args) throws Exception{
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(AppHornetQConfig.class);

        MessageSender messageSender = ctx.getBean("messageSender", MessageSender.class);

        for(int i=0; i < 10; ++i) {
            messageSender.sendMessage("Test message: " + i);
        }

        System.in.read();
        ctx.close();
    }
}
