package tn.enis.member.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.enis.member.entities.Member;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByCin (String cin);

    List<Member> findByNomStartingWith (String caractere);

    Member findByEmail (String email);

    void deleteMemberById (Long id);

    List<Member> findByNom (String nom);

}
