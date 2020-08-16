package dev.ldelelis.devoffchallenge.scytale;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScytaleController {
    @PostMapping(path = "/encrypt")
    public String encrypt(@RequestBody Scytale scytale) {
        ScytaleProcessor processor = new ScytaleProcessor(scytale);

        return processor.encrypt();
    }

    @PostMapping(path = "/decrypt")
    public String decrypt(@RequestBody Scytale scytale) {
        ScytaleProcessor processor = new ScytaleProcessor(scytale);

        return processor.decrypt();
    }
}