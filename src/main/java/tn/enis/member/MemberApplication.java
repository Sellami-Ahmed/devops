package tn.enis.member;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import tn.enis.member.entities.EnseignantChercheur;
import tn.enis.member.entities.Etudiant;
import tn.enis.member.services.MemberService;

import java.util.Date;

@SpringBootApplication
@EntityScan(basePackages = "tn.enis.member.entities")
@AllArgsConstructor
@EnableDiscoveryClient
@EnableFeignClients
public class MemberApplication implements CommandLineRunner {
	MemberService memberService;
	public static void main(String[] args) {
		SpringApplication.run(MemberApplication.class, args);
	}

	@Override
	public void run (String... args) throws Exception {

		Etudiant etd1=Etudiant.builder()
				.cin("123456")
				.dateInscription(new Date())
				.dateNaissance(new Date())
				.diplome("mastère")
				.email("etd1@gmail.com")
				.password("pass1")
				.cv("cv1")
				.nom("abid")
				.prenom("youssef)")
				.diplome("blockhain")
				.build();

		memberService.addMember(etd1);

		Etudiant etd2=Etudiant.builder()
				.cin("123456")
				.dateInscription(new Date())
				.dateNaissance(new Date())
				.diplome("mastère")
				.email("etd2@gmail.com")
				.password("pass2")
				.cv("cv2")
				.nom("abid")
				.prenom("Ahmed)")
				.diplome("blockhain")
				.build();
		memberService.addMember(etd2);


		EnseignantChercheur ens1 = EnseignantChercheur.builder()
				.cin("123458")
				.nom("firas")
				.prenom("chakroun")
				.email("ens1@gmail.com")
				.password("pass2")
				.etablissement("enis")
				.dateNaissance(new Date())
				.grade("grade")
				.cv("cv2")
				.build();


		memberService.addMember(ens1);

		EnseignantChercheur ens2 = EnseignantChercheur.builder()
				.cin("123459")
				.nom("firas")
				.prenom("chakroun")
				.email("ens1@gmail.com")
				.password("pass2")
				.etablissement("enis")
				.dateNaissance(new Date())
				.grade("grade")
				.cv("cv2")
				.build();
		memberService.addMember(ens2);
		memberService.affecterEtudiantEnseignant(etd1.getId(), ens1.getId());
		memberService.affecterAuteurToPublication(ens1.getId(), 1L);
		memberService.affecterAuteurToPublication(ens1.getId(), 2L);
	}
}
