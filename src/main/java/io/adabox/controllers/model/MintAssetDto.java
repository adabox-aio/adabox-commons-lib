package io.adabox.controllers.model;

import com.bloxbean.cardano.client.cip.cip25.NFT;
import com.bloxbean.cardano.client.cip.cip25.NFTFile;
import com.bloxbean.cardano.client.cip.cip25.NFTMetadata;
import com.bloxbean.cardano.client.transaction.spec.Asset;
import com.bloxbean.cardano.client.transaction.spec.MultiAsset;
import com.bloxbean.cardano.client.util.HexUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.springframework.util.StringUtils;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class MintAssetDto implements Comparable<MintAssetDto> {

    private Long id;
    private Long projectId;
    private String assetName;
    private int value;
    private String image;
    private String mediaType;
    private boolean isSold;
    private String soldTo;
    private String description;
    private Map<String, Object> additionalAttributes;
    private List<AdditionalFileDto> additionalFiles;
    private Date dateCreated;
    private Date dateSold;

    @JsonIgnore
    public NFT getNFT() {
        NFT nft = NFT.create().assetName(getAssetName()).name(getAssetName()).image(getImage())
                .mediaType(getMediaType()).description(getDescription());
        if (getAdditionalFiles() != null) {
            for (AdditionalFileDto additionalFile : getAdditionalFiles()) {
                NFTFile nftFile = NFTFile.create();
                if (StringUtils.hasText(additionalFile.getName())) {
                    nftFile.name(additionalFile.getName());
                }
                if (StringUtils.hasText(additionalFile.getMediaType())) {
                    nftFile.mediaType(additionalFile.getMediaType());
                }
                if (StringUtils.hasText(additionalFile.getSrc())) {
                    nftFile.src(additionalFile.getSrc());
                }
                nft.addFile(nftFile);
            }
        }
        return nft;
    }

    @JsonIgnore
    public NFTMetadata getNFTMetadata(String policyId) {
        return NFTMetadata.create().version("1.0").addNFT(policyId, getNFT());
    }

    @JsonIgnore
    public String getAssetId(String policyId) {
        return policyId + HexUtil.encodeHexString(getAssetName().getBytes(StandardCharsets.UTF_8));
    }

    @JsonIgnore
    public String getNFTMetadataJson(String policyId) {
        return NFTMetadata.create().version("1.0").addNFT(policyId, getNFT()).toJson();
    }

    @JsonIgnore
    public Asset getAsset() {
        return new Asset(getAssetName(), BigInteger.valueOf(1));
    }

    @JsonIgnore
    public MultiAsset getMultiAsset(String policyId) {
        MultiAsset multiAsset = new MultiAsset();
        multiAsset.setPolicyId(policyId);
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
