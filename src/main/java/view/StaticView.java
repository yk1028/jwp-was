package view;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.FileIoUtils;

import java.io.IOException;
import java.net.URISyntaxException;

public class StaticView implements View {
    private static final Logger log = LoggerFactory.getLogger(StaticView.class);

    private String viewPath;

    public StaticView(String viewPath) {
        this.viewPath = viewPath;
    }

    @Override
    public byte[] render() {
        try {
            if (viewPath != null) {
                return FileIoUtils.loadFileFromClasspath(viewPath);
            }
        } catch (IOException | URISyntaxException e) {
            log.debug(e.getMessage());
        }
        return null;
    }
}