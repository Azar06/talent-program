package com.valtech.gifter.domain.repository.partner;

import com.valtech.gifter.domain.model.partner.Partner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
public class PartnerRepositoryTest {

    @Autowired
    private EntityManager em;
    @Autowired
    private PartnerRepository repo;

    private Partner createDunnyPartner(String duns) {
        Partner partner = new Partner(duns);
        partner.setName("Entreprise Name");
        return partner;
    }

    @Test
    public void insertPartner() throws Exception {
        Partner partner = createDunnyPartner("123456789");
        repo.insertPartner(partner);
        em.flush();
        em.clear();

        assertThat(partner.getId()).isNotNull();

        Partner foundPartner = em.find(Partner.class, partner.getId());
        assertThat(foundPartner).isEqualTo(partner);

    }
}
