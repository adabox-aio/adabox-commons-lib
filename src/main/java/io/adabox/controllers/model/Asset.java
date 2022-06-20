package io.adabox.controllers.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rest.koios.client.backend.api.asset.model.AssetInformation;

import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
public class Asset {

    private AssetInformation assetInformation;
    private BigInteger quantity;
}
