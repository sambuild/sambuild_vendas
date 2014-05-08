package br.com.sambuild.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class ApplicationProperties {

    private static final Logger LOG = Logger.getLogger(ApplicationProperties.class);

    private static final String CONFIG_LOG4J = "resources/log4j.properties";

    private static Properties props = new Properties();

    public static void load() {
        try {
            props.load(new FileInputStream(CONFIG_LOG4J));
            PropertyConfigurator.configureAndWatch(CONFIG_LOG4J, 10000);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Properties getProps() {
        return new Properties(props);
    }
}