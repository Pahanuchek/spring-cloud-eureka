package com.novozhilov;

import com.novozhilov.aspect.TimerAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@Configuration
public class TimerConfiguration {

    @Bean
    public TimerAspect timerAspect() {
        return new TimerAspect();
    }
}
