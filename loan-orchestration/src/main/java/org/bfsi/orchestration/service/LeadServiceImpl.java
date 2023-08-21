package org.bfsi.orchestration.service;

import org.bfsi.orchestration.entity.LeadRequest;
import org.bfsi.orchestration.entity.LeadResponse;
import org.bfsi.orchestration.exception.LeadNotFoundException;
import org.bfsi.orchestration.repository.AddressRepository;
import org.bfsi.orchestration.repository.BankDetailsRepository;
import org.bfsi.orchestration.repository.ContactDetailsRepository;
import org.bfsi.orchestration.repository.PersonalDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class LeadServiceImpl implements LeadService{

    @Autowired
    public PersonalDetailsRepository personalDetailsRepository;

    @Autowired
    BankDetailsRepository bankDetailsRepository;

    @Autowired
    ContactDetailsRepository contactDetailsRepository;

    @Autowired
    AddressRepository addressRepository;

    @Override
    public LeadResponse persistLeadData(LeadRequest leadRequest) {
        try {

            personalDetailsRepository.save(leadRequest.getPersonalDetails());
            addressRepository.save(leadRequest.getHomeAddress());
            addressRepository.save(leadRequest.getOfficeAddress());
            contactDetailsRepository.save(leadRequest.getContactDetails());
            bankDetailsRepository.save(leadRequest.getBankDetails());
        }catch (RuntimeException e){
            e.printStackTrace();
        }
        return null;
    }

    public LeadRequest getLeadData(String leadId) {
        LeadRequest leadRequest = new LeadRequest();
        try {
            leadRequest.setLeadId(leadId);
            leadRequest.setPersonalDetails(personalDetailsRepository.findByLeadId(leadId));
            leadRequest.setHomeAddress(addressRepository.findByLeadId(leadId).get(0));
            leadRequest.setOfficeAddress(addressRepository.findByLeadId(leadId).get(1));
            leadRequest.setBankDetails(bankDetailsRepository.findByLeadId(leadId));
            leadRequest.setContactDetails(contactDetailsRepository.findByLeadId(leadId));
        }catch (RuntimeException e){
            e.printStackTrace();
        }
        if(null == leadRequest.getPersonalDetails().getFirstName() ){
            throw new LeadNotFoundException("Given lead is not available.");
        }
        return leadRequest;
    }
}
