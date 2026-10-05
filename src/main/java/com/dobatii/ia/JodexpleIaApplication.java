package com.dobatii.ia;

import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

// Utiliser OpenAiChatModel dans spring boot 4.xx 
//import com.openai.models.ChatModel;

/**
 * @author juoud
 * @version 1.0
 * @since octobre 2026
 */
@SpringBootApplication
public class JodexpleIaApplication {

	private static final String PROMPT_AI = "AI> ";
	private static final String PROMPT_USER = "User> ";

	public static void main(String[] args) {
//		SpringApplication.run(JodexpleIaApplication.class, args);
		new SpringApplicationBuilder(JodexpleIaApplication.class)
			.web(WebApplicationType.NONE)
			.build()
			.run(args);
	}
	
	@Bean
	ApplicationRunner appRunner(OpenAiChatModel chatModel) {
		return args -> {
			String prompt = "In a single word, 'what is the answer to life and the universe'";
			
			IO.println(PROMPT_USER + prompt);
			String response = chatModel.call(prompt);
			IO.println(PROMPT_AI + response);
		};
	}

}
