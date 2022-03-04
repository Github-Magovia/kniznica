package githubmagovia.vzorovyprojekt.kniznica.borrowing;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BorrowingRepository extends JpaRepository<BorrowingEntity, Long> {
}
