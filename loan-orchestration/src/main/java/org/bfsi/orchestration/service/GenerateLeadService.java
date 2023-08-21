package org.bfsi.orchestration.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bfsi.orchestration.bean.bureau.CommonServiceBean;
import org.bfsi.orchestration.entity.LeadRequest;
import org.bfsi.orchestration.service.feign.entity.*;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;

@Service
public class GenerateLeadService {
    Logger logger = LogManager.getLogger(GenerateLeadService.class);
    @Autowired
    BREConnectorService breConnectorService;

    @Autowired
    BureauConnectorService bureauConnectorService;

    @Autowired
    HunterConnectorService hunterConnectorService;

    @Autowired
    UpdateUserService updateUserService;

    public void executeLeadActions(LeadRequest leadRequest) throws InvocationTargetException, IllegalAccessException {
        logger.info("Inside GenerateLeadService:executeLeadActions() start - " + leadRequest);

        CommonServiceBean commonServiceBean = createObject(leadRequest);
        logger.info("commonServiceBean -" + commonServiceBean);
        BureauResponse bureauResponse = bureauInvoke(commonServiceBean);
         logger.info("Sending notification for bureau ");
            updateUserService.sendBureauNotification(bureauResponse);
        BREResponse breResponse = breInvoke(commonServiceBean);
        logger.info("Sending notification for BRE ");
            updateUserService.sendBRENotification(breResponse);
        HunterResponse hunterResponse = hunterInvoke(commonServiceBean);
        logger.info("Sending notification for hunter ");
            updateUserService.sendHunterNotification(hunterResponse);
    }

    private HunterResponse hunterInvoke(CommonServiceBean commonServiceBean) throws InvocationTargetException, IllegalAccessException {
        HunterRequest hunterRequest = new HunterRequest();
        BeanUtils.copyProperties(hunterRequest, commonServiceBean);
        logger.info("hunterRequest -" + hunterRequest);
        return hunterConnectorService.callHunterServiceFeign(hunterRequest);
    }

    private BREResponse breInvoke(CommonServiceBean commonServiceBean) throws InvocationTargetException, IllegalAccessException {
        BRERequest breRequest = new BRERequest();
        BeanUtils.copyProperties(breRequest, commonServiceBean);
        logger.info("bureauRequest -" + breRequest);
        return breConnectorService.callBREServiceFeign(breRequest);
    }

    private BureauResponse bureauInvoke(CommonServiceBean commonServiceBean) throws InvocationTargetException, IllegalAccessException {
        BureauRequest bureauRequest = new BureauRequest();
        BeanUtils.copyProperties(bureauRequest, commonServiceBean);
        logger.info("bureauRequest -" + bureauRequest);
        return bureauConnectorService.callBureauServiceFeign(bureauRequest);
    }

    private static CommonServiceBean createObject(LeadRequest leadRequest) {
        return CommonServiceBean.builder()
                .leadId(leadRequest.getLeadId())
                .firstName(leadRequest.getPersonalDetails().getFirstName())
                .lastName(leadRequest.getPersonalDetails().getLastName())
                .pan(leadRequest.getPersonalDetails().getPan())
                .mobileNumber(leadRequest.getContactDetails().getMobileNumber())
                .email(leadRequest.getContactDetails().getEmail())
                .amount(leadRequest.getPersonalDetails().getAmount())
                .city(leadRequest.getPersonalDetails().getCity())
                .address1(leadRequest.getOfficeAddress().getAddress1())
                .address2(leadRequest.getOfficeAddress().getAddress2())
                .pincode(leadRequest.getOfficeAddress().getPincode())
                .build();
    }

}
