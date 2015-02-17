package org.dcm4chee.conf;

import org.dcm4che3.conf.api.ConfigurationException;
import org.dcm4che3.conf.dicom.CommonDicomConfigurationWithHL7;
import org.dcm4che3.conf.dicom.DicomConfigurationBuilder;
import org.dcm4che3.conf.dicom.DicomConfigurationManager;
import org.dcm4che3.net.hl7.HL7DeviceExtension;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

/**
 * @author Roman K
 */
@ApplicationScoped
public class DefaultConfigFactory {

    @Produces
    @ApplicationScoped
    DicomConfigurationManager createConfig() throws ConfigurationException {
        DicomConfigurationBuilder builder = DicomConfigurationBuilder.newConfigurationBuilder(System.getProperties());
        builder.registerDeviceExtension(HL7DeviceExtension.class);
        return builder.build();
    }


}
