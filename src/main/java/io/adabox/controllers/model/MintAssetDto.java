package io.adabox.controllers.model;

import com.bloxbean.cardano.client.cip.cip25.NFT;
import com.bloxbean.cardano.client.cip.cip25.NFTFile;
import com.bloxbean.cardano.client.cip.cip25.NFTMetadata;
import com.bloxbean.cardano.client.transaction.spec.Asset;
import com.bloxbean.cardano.client.transaction.spec.MultiAsset;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class MintAssetDto implements Comparable<MintAssetDto> {

    private String assetId;
    private String assetName;
    private int value;
    private String image;
    private String mediaType;
    private boolean isSold;
    private String soldTo;
    private String description;
    private Map<String,Object> additionalAttributes;
    private List<AdditionalFileDto> additionalFiles;
    private Date dateCreated;
    private Date dateSold;
    private String policyId;

    @JsonIgnore
    public NFT getNFT() {
        NFT nft = NFT.create().assetName(getAssetName()).name(getAssetName()).image(getImage()).mediaType(getMediaType()) //TODO Asset Name
                .description(getDescription());
        for (AdditionalFileDto additionalFile : getAdditionalFiles()) {
            nft.addFile(NFTFile.create().name(additionalFile.getName()).mediaType(additionalFile.getMediaType()).src(additionalFile.getSrc()));
        }
        return nft;
    }

    @JsonIgnore
    public NFTMetadata getNFTMetadata() {
        return NFTMetadata.create().version("1.0").addNFT(getPolicyId(), getNFT());
    }

    @JsonIgnore
    public Asset getAsset() {
        return new Asset(getAssetName(), BigInteger.valueOf(1));
    }

    @JsonIgnore
    public MultiAsset getMultiAsset() {
        MultiAsset multiAsset = new MultiAsset();
        multiAsset.setPolicyId(getPolicyId());
        multiAsset.getAssets().add(getAsset());
        return multiAsset;
    }

    @Override
    public int compareTo(@NotNull MintAssetDto asset) {
        if (getDateSold() == null || asset.getDateSold() == null) {
            return 0;
        }
        return Long.compare(getDateSold().getTime(), asset.getDateSold().getTime());
    }
}
