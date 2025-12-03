package ml.e_jago.catalog.controllers;

import jakarta.servlet.http.HttpServletRequest;
import ml.e_jago.catalog.config.MailConfig;
import ml.e_jago.catalog.dto.MailConfigDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mail")
public class MailConfigRessource {

    private final MailConfig mailConfig;
    private String instance;
    public MailConfigRessource(MailConfig mailConfig) {
        this.mailConfig = mailConfig;
    }

    @GetMapping(value = "/config")
    private ResponseEntity<MailConfig> getMailConfig(HttpServletRequest request) {
        //mailConfig.setInstance(request.getServerName()+" "+request.getLocalPort());
        return ResponseEntity.ok(mailConfig);
    }

    /*@GetMapping(value = "/config")
    private ResponseEntity<MailConfigDto> getMailConfig(HttpServletRequest request) {
        MailConfigDto dto = new MailConfigDto(
                mailConfig.getHost(),
                mailConfig.getPort(),
                mailConfig.getUsername()
        );
        return ResponseEntity.ok(dto);
    }*/
}
