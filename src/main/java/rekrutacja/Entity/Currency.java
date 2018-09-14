package rekrutacja.Entity;

import org.springframework.stereotype.Component;

@Component
public class Currency {
    private String code;

    public Currency(String code) {
        this.code = code;
    }

    public Currency() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
