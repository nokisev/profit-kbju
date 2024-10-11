package ru.nokisev.profit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.nokisev.profit.dao.Authority;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}
