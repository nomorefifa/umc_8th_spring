package umc.spring.web.dto;

import lombok.Getter;

public class StoreRequestDTO {

    @Getter
    public static class CreateStoreDTO {
        private String name;
        private String address;
        private Long regionId;
    }

}
