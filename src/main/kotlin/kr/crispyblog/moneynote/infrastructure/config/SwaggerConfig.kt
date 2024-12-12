package kr.crispyblog.moneynote.infrastructure.config

import org.springdoc.core.models.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig {

    @Bean
    fun springDocApi(): GroupedOpenApi {
        return GroupedOpenApi.builder()
            .group("1️⃣ v1") // API 그룹 이름
            .packagesToScan("kr.crispyblog.moneynote.application") // API 컨트롤러 패키지
            .pathsToMatch("/v1/**") // 해당 경로에 대한 API만 노출
            .addOpenApiCustomizer { openapi ->
                openapi.info(
                    io.swagger.v3.oas.models.info.Info()
                        .title("MoneyNote")
                        .description("MoneyNote API")
                        .version("1.0.0")
                )
            }
            .build()
    }


    @Bean
    fun springDocAdminApi(): GroupedOpenApi {
        return GroupedOpenApi.builder()
            .group("2️⃣ admin") // API 그룹 이름
            .packagesToScan("kr.crispyblog.moneynote.application.controllers.admin") // API 컨트롤러 패키지
            .pathsToMatch("/admin/**") // 해당 경로에 대한 API만 노출
            .addOpenApiCustomizer { openapi ->
                openapi.info(
                    io.swagger.v3.oas.models.info.Info()
                        .title("MoneyNote Admin")
                        .description("MoneyNote Admin API")
                        .version("1.0.0")
                )
            }
            .build()
    }
}