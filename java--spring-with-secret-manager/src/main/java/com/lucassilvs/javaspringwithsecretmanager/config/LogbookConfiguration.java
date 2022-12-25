package com.lucassilvs.javaspringwithsecretmanager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zalando.logbook.CurlHttpLogFormatter;
import org.zalando.logbook.DefaultHttpLogWriter;
import org.zalando.logbook.DefaultSink;
import org.zalando.logbook.Logbook;
import org.zalando.logbook.json.JsonHttpLogFormatter;

@Configuration
public class LogbookConfiguration {

    @Bean
    public Logbook logbook() {
        Logbook logbook = Logbook.builder()
//                .sink(new CommonsLogFormatSink(new DefaultHttpLogWriter(), ZoneId.systemDefault())) Log HTTPS, exemplo: 0:0:0:0:0:0:0:1 - - [25/dez./2022:16:08:13 -0300] "GET /usuario?cpf=23634689889 HTTP/1.1" 200 118
                .sink(new DefaultSink(new CurlHttpLogFormatter(new JsonHttpLogFormatter()), new DefaultHttpLogWriter()))
                .build();
        return logbook;
    }

}
