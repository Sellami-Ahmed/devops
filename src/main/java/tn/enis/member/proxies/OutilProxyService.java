package tn.enis.member.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tn.enis.member.beans.OutilBean;

import java.util.Optional;

@FeignClient(name = "OUTIL-SERVICE")
public interface OutilProxyService {
    @GetMapping("/api/v1/outils/{id}")
    ResponseEntity<Optional<OutilBean>> getOutilById (@PathVariable Long id);
}
