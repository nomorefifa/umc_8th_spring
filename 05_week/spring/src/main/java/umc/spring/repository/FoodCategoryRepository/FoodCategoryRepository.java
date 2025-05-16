package umc.spring.repository.FoodCategoryRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.mapping.FoodCategory;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {
}