package umc.spring.service.StoreService;

import umc.spring.domain.mapping.Store;
import umc.spring.web.dto.StoreRequestDTO;

public interface StoreCommandService {
    Store createStore(StoreRequestDTO.CreateStoreDTO request);
}