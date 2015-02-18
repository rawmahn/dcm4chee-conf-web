package org.dcm4chee.conf.browser;

import org.dcm4che3.conf.api.ConfigurationException;
import org.dcm4che3.conf.dicom.DicomConfigurationManager;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.Produces;
import javax.enterprise.util.AnnotationLiteral;
import javax.inject.Inject;

/**
 * @author Roman K
 */
public class ConfigManagerProducer {

    @Produces
    @ApplicationScoped
    @Manager
    DicomConfigurationManager getConfigManager(Instance<DicomConfigurationManager> managerBeans, @Standalone Instance<DicomConfigurationManager> standaloneManagerBean) throws ConfigurationException {
        if (!standaloneManagerBean.isUnsatisfied())
            return standaloneManagerBean.get();

        return managerBeans.get();
    }
}
