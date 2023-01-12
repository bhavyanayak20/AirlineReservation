package com.example.demo.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class Config {
	/*
	 * @Bean public ModelMapper modelMapper(){ ModelMapper modelMapper = new
	 * ModelMapper(); modelMapper.addMappings(propertiesForConvertToDto); return
	 * modelMapper; }
	 */

	@Component
	public class ModelMapperUtil extends ModelMapper {
		public ModelMapperUtil() {
			this.getConfiguration().setFieldMatchingEnabled(true)
					.setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE);
		}
	}
}
