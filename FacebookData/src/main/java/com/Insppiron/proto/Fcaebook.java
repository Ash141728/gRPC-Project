package com.Insppiron.proto;

import com.BharatKaData.FacebookDataAccessGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

import javax.swing.plaf.PanelUI;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class Fcaebook {

    public static void main(String[] args)
    {
        SpringApplication.run(Fcaebook.class,args);
    }


}
