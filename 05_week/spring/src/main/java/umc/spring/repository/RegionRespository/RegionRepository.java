package umc.spring.repository.RegionRespository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.mapping.Region;

public interface RegionRepository extends JpaRepository<Region, Long> {
}