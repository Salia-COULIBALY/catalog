package ml.e_jago.catalog.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MailConfigDto {
    private String host;
    private int port;
    private String username;
}
