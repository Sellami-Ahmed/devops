package tn.enis.member.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tn.enis.member.beans.EvenementBean;
import tn.enis.member.beans.OutilBean;

import java.util.Optional;

@FeignClient(name = "EVENEMENT-SERVICE")
public interface EvenementProxyService {
    @GetMapping("/api/v1/evenements/{id}")
    ResponseEntity<Optional<EvenementBean>> getEvenementById (@PathVariable Long id);
}
