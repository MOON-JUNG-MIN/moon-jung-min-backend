package com.example.moonjungminbackend.global.config

import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.context.annotation.Configuration

@ConfigurationPropertiesScan(basePackages = ["com.example.moonjungminbackend"])
@Configuration
class PropertiesConfig {
}