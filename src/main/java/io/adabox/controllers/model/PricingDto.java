package io.adabox.controllers.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PricingDto {

    private PricingPlanEnum plan;
    private Long fixedPrice;
    private MintingFeePayerEnum mintingFeePayer;
    private String tokensPerStakeAddress;
    private List<SaleConditionDto> conditions;
    private List<BundleDto> bundle;
    private List<DiscountConditionDto> discounts;
}
