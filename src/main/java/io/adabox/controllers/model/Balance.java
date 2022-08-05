package io.adabox.controllers.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;

/**
 * Balance
 */
@Getter
@Setter
@NoArgsConstructor
public class Balance {

    private BigInteger coin;
    private HashMap<String, List<Asset>> multiAssets;
}
