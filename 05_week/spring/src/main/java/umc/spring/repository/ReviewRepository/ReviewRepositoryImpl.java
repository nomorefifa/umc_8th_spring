package umc.spring.repository.ReviewRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import umc.spring.domain.mapping.QReview;
import umc.spring.domain.mapping.Review;

import java.util.List;

@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepositoryCustom{
    private final JPAQueryFactory queryFactory;

    @Override
    public List<Review> findAllByStoreId(Long storeId) {
        QReview review = QReview.review;

        return queryFactory
                .selectFrom(review)
                .where(review.store.id.eq(storeId))
                .orderBy(review.createdAt.desc())  // 최근 리뷰부터
                .fetch();
    }
}
