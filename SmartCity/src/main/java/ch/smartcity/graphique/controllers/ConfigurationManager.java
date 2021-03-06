package ch.smartcity.graphique.controllers;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Manageur de configuration permettant de charger les textes par rapport
 * au fichier de messageBundle.
 *
 * @author Loan Lassalle
 * @author Tano Iannetta
 */
public class ConfigurationManager {

    private final String messageBundlePropertiesFile =
            "ch/smartcity/graphique/messagesBundles/messageBundle";

    private ResourceBundle resourceBundle;

    private ConfigurationManager() {
        resourceBundle = ResourceBundle.getBundle(messageBundlePropertiesFile, Locale.getDefault());
    }

    public static ConfigurationManager getInstance() {
        return SingletonHolder.instance;
    }

    public ResourceBundle getResourceBundle() {
        return getInstance().resourceBundle;
    }

    public void setResourceBundle(ResourceBundle resourceBundle) {
        getInstance().resourceBundle = resourceBundle;
    }

    public String getString(String key) {
        return getResourceBundle().getString(key);
    }

    public void c3p0Logging() {
        System.setProperty(
                "com.mchange.v2.log.FallbackMLog.DEFAULT_CUTOFF_LEVEL",
                getString("com.mchange.v2.log.FallbackMLog.DEFAULT_CUTOFF_LEVEL"));
        System.setProperty(
                "com.mchange.v2.log.MLog",
                getString("com.mchange.v2.log.MLog"));
    }

    private static class SingletonHolder {
        private final static ConfigurationManager instance = new ConfigurationManager();
    }
}