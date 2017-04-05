package com.valtech.gifter.domain.repository.partner;

import com.valtech.gifter.domain.model.partner.Partner;
import com.valtech.gifter.domain.repository.commun.DomainRepository;
import org.springframework.stereotype.Repository;

@Repository
public class PartnerRepository extends DomainRepository {

    public void insertPartner(Partner partner) {
        getEntityManager().persist(partner);
    }
}
