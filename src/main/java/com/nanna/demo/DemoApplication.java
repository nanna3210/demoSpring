package com.nanna.demo;

import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@SpringBootApplication
@Log
public class DemoApplication  implements CommandLineRunner {
	
	
	private final DataSource dataSource;
	
	public DemoApplication ( DataSource dataSource ) {
		this.dataSource = dataSource;
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Override
	public void run ( String... args ) throws Exception {
		JdbcTemplate restTemplate = new JdbcTemplate ( dataSource );
		restTemplate.execute ( "select 1" );
		log.info ( "app is started" );
		log.info ( "data source is : " + dataSource.toString () );
		log.info ( "app is running " );
		
		
	
	}
}
