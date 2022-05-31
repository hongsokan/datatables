package com.eb.datatables.config;

/*
@Configuration
public class PebbleConfig {
    @Bean
    public SpringExtension springExtension() {
        return new SpringExtension(null);
    }

    @Bean
    public PebbleEngine pebbleEngine() {
        return new PebbleEngine.Builder()
                .extension(springExtension())
                .cacheActive(false)   //이 옵션을 안주면 html수정시 refresh해도 안됨,
                .build();
    }

	@Bean
    public ViewResolver viewResolver(PebbleEngine pebbleEngine) {
        PebbleViewResolver resolver = new PebbleViewResolver(pebbleEngine);
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".html");
        resolver.setContentType("text/html; charset=UTF-8");
        //resolver.setPebbleEngine(pebbleEngine());
        return resolver;
    }
}
*/