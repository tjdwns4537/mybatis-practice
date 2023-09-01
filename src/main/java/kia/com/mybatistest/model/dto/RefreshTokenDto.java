package kia.com.mybatistest.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RefreshTokenDto {
    private Long rtkId;
    private String rtkValue;

    private RefreshTokenDto(String rtkValue) {
        this.rtkValue = rtkValue;
    }

    public static RefreshTokenDto of(String rtkValue) {
        return new RefreshTokenDto(rtkValue);
    }
}
