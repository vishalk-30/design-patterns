package com.scaler.lld.design.assignments.singleton;

public class ConfigurationManager extends FileBasedConfigurationManager{
    private static ConfigurationManager INSTANCE = null;

    private ConfigurationManager() {}

    public static ConfigurationManager getInstance(){
        if (INSTANCE == null) {
            synchronized (ConfigurationManager.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ConfigurationManager();
                }
            }
        }return INSTANCE;
    }

    public static void resetInstance(){
        INSTANCE = null;
    }
    @Override
    public String getConfiguration(String key) {
        return properties.getProperty(key);
    }

    @Override
    public <T> T getConfiguration(String key, Class<T> type) {
        T property = null;
        String configuration = properties.getProperty(key);
        if (configuration != null){
            property = convert(configuration,type);
        }

        return property;
    }

    @Override
    public void setConfiguration(String key, String value) {
        properties.setProperty(key, value);

    }

    @Override
    public <T> void setConfiguration(String key, T value) {
        properties.setProperty(key,(String) value);

    }

    @Override
    public void removeConfiguration(String key) {
        properties.remove(key);

    }

    @Override
    public void clear() {
        properties.clear();

    }
}
