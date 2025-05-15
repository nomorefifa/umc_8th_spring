package umc.spring.converter;

import umc.spring.domain.mapping.FoodCategory;
import umc.spring.domain.mapping.MemberPrefer;

import java.util.List;
import java.util.stream.Collectors;

public class MemberPreferConverter {

    public static List<MemberPrefer> toMemberPreferList(List<FoodCategory> foodCategories) {
        return foodCategories.stream()
                .map(category -> MemberPrefer.builder()
                        .foodCategory(category)
                        .build())
                .collect(Collectors.toList());
    }
}