package veroslaves.upcoming_events_back.config;

import org.springframework.stereotype.Component;

@Component
public class EventImagesStoreConfiguration {
    String uploadDir = "src/main/resources/static/images/";

    public String getUploadDir() {
        return uploadDir;
    }

    public void setUploadDir(String uploadDir) {
        this.uploadDir = uploadDir;
    }
    
}
