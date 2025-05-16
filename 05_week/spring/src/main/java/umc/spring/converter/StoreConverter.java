package umc.spring.converter;

import umc.spring.domain.mapping.Region;
import umc.spring.domain.mapping.Store;
import umc.spring.web.dto.StoreRequestDTO;
import umc.spring.web.dto.StoreResponseDTO;

public class StoreConverter {
    public static Store toStore(StoreRequestDTO.CreateStoreDTO dto, Region region) {
        return Store.builder()
                .name(dto.getName())
                .address(dto.getAddress())
                .score(0.0f) // 초기 평점 기본값
                .region(region)
                .build();
    }

    public static StoreResponseDTO.CreateResultDTO toCreateResultDTO(Store store) {
        return StoreResponseDTO.CreateResultDTO.builder()
                .storeId(store.getId())
                .name(store.getName())
                .address(store.getAddress())
                .build();
    }
}
