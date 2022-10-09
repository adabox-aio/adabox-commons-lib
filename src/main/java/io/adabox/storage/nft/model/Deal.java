package io.adabox.storage.nft.model;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModelProperty;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * Deal
 */
public class Deal {

    public static final String SERIALIZED_NAME_BATCH_ROOT_CID = "batchRootCid";
    @SerializedName(SERIALIZED_NAME_BATCH_ROOT_CID)
    private String batchRootCid;

    public static final String SERIALIZED_NAME_LAST_CHANGE = "lastChange";
    @SerializedName(SERIALIZED_NAME_LAST_CHANGE)
    private String lastChange;

    public static final String SERIALIZED_NAME_MINER = "miner";
    @SerializedName(SERIALIZED_NAME_MINER)
    private String miner;

    /**
     * Filecoin network for this Deal
     */
    @JsonAdapter(NetworkEnum.Adapter.class)
    public enum NetworkEnum {

        NERPANET("nerpanet"),

        MAINNET("mainnet");

        private final String value;

        NetworkEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static NetworkEnum fromValue(String value) {
            for (NetworkEnum b : NetworkEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }

        public static class Adapter extends TypeAdapter<NetworkEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final NetworkEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public NetworkEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return NetworkEnum.fromValue(value);
            }
        }
    }

    public static final String SERIALIZED_NAME_NETWORK = "network";
    @SerializedName(SERIALIZED_NAME_NETWORK)
    private NetworkEnum network;

    public static final String SERIALIZED_NAME_PIECE_CID = "pieceCid";
    @SerializedName(SERIALIZED_NAME_PIECE_CID)
    private String pieceCid;

    /**
     * Deal status
     */
    @JsonAdapter(StatusEnum.Adapter.class)
    public enum StatusEnum {
        QUEUED("queued"),

        PROPOSING("proposing"),

        ACCEPTED("accepted"),

        FAILED("failed"),

        ACTIVE("active"),

        PUBLISHED("published"),

        TERMINATED("terminated");

        private final String value;

        StatusEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static StatusEnum fromValue(String value) {
            for (StatusEnum b : StatusEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }

        public static class Adapter extends TypeAdapter<StatusEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final StatusEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public StatusEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return StatusEnum.fromValue(value);
            }
        }
    }

    public static final String SERIALIZED_NAME_STATUS = "status";
    @SerializedName(SERIALIZED_NAME_STATUS)
    private StatusEnum status;

    public static final String SERIALIZED_NAME_STATUS_TEXT = "statusText";
    @SerializedName(SERIALIZED_NAME_STATUS_TEXT)
    private String statusText;

    public static final String SERIALIZED_NAME_CHAIN_DEAL_I_D = "chainDealID";
    @SerializedName(SERIALIZED_NAME_CHAIN_DEAL_I_D)
    private BigDecimal chainDealID;

    public static final String SERIALIZED_NAME_DEAL_ACTIVATION = "dealActivation";
    @SerializedName(SERIALIZED_NAME_DEAL_ACTIVATION)
    private String dealActivation;

    public static final String SERIALIZED_NAME_DEAL_EXPIRATION = "dealExpiration";
    @SerializedName(SERIALIZED_NAME_DEAL_EXPIRATION)
    private String dealExpiration;


    public Deal batchRootCid(String batchRootCid) {

        this.batchRootCid = batchRootCid;
        return this;
    }

    /**
     * Get batchRootCid
     *
     * @return batchRootCid
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "bafkreidivzimqfqtoqxkrpge6bjyhlvxqs3rhe73owtmdulaxr5do5in7u", value = "")
    public String getBatchRootCid() {
        return batchRootCid;
    }

    public void setBatchRootCid(String batchRootCid) {
        this.batchRootCid = batchRootCid;
    }

    public Deal lastChange(String lastChange) {
        this.lastChange = lastChange;
        return this;
    }

    /**
     * This is a timestamp in [ISO 8601](<a href="https://en.wikipedia.org/wiki/ISO_8601">...</a>) format: YYYY-MM-DDTHH:MM:SSZ.
     *
     * @return lastChange
     **/
    @ApiModelProperty(example = "2021-03-18T11:46:50.000Z", required = true, value = "This is a timestamp in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format: YYYY-MM-DDTHH:MM:SSZ.")
    public String getLastChange() {
        return lastChange;
    }

    public void setLastChange(String lastChange) {
        this.lastChange = lastChange;
    }

    public Deal miner(String miner) {
        this.miner = miner;
        return this;
    }

    /**
     * Miner ID
     *
     * @return miner
     */
    @javax.annotation.Nullable
    @ApiModelProperty(example = "f05678", value = "Miner ID")
    public String getMiner() {
        return miner;
    }

    public void setMiner(String miner) {
        this.miner = miner;
    }

    public Deal network(NetworkEnum network) {
        this.network = network;
        return this;
    }

    /**
     * Filecoin network for this Deal
     *
     * @return network
     */
    @javax.annotation.Nullable
    @ApiModelProperty(value = "Filecoin network for this Deal")
    public NetworkEnum getNetwork() {
        return network;
    }

    public void setNetwork(NetworkEnum network) {
        this.network = network;
    }

    public Deal pieceCid(String pieceCid) {
        this.pieceCid = pieceCid;
        return this;
    }

    /**
     * Piece CID string
     *
     * @return pieceCid
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "bafkreidivzimqfqtoqxkrpge6bjyhlvxqs3rhe73owtmdulaxr5do5in7u", value = "Piece CID string")

    public String getPieceCid() {
        return pieceCid;
    }

    public void setPieceCid(String pieceCid) {
        this.pieceCid = pieceCid;
    }

    public Deal status(StatusEnum status) {
        this.status = status;
        return this;
    }

    /**
     * Deal status
     *
     * @return status
     **/
    @ApiModelProperty(required = true, value = "Deal status")

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public Deal statusText(String statusText) {
        this.statusText = statusText;
        return this;
    }

    /**
     * Deal status description.
     *
     * @return statusText
     */
    @javax.annotation.Nullable
    @ApiModelProperty(example = "miner rejected my data", value = "Deal status description.")

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public Deal chainDealID(BigDecimal chainDealID) {
        this.chainDealID = chainDealID;
        return this;
    }

    /**
     * Identifier for the deal stored on chain.
     *
     * @return chainDealID
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "138", value = "Identifier for the deal stored on chain.")

    public BigDecimal getChainDealID() {
        return chainDealID;
    }

    public void setChainDealID(BigDecimal chainDealID) {
        this.chainDealID = chainDealID;
    }

    public Deal dealActivation(String dealActivation) {

        this.dealActivation = dealActivation;
        return this;
    }

    /**
     * This is a timestamp in [ISO 8601](<a href="https://en.wikipedia.org/wiki/ISO_8601">...</a>) format: YYYY-MM-DDTHH:MM:SSZ.
     *
     * @return dealActivation
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "2021-03-18T11:46:50.000Z", value = "This is a timestamp in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format: YYYY-MM-DDTHH:MM:SSZ.")
    public String getDealActivation() {
        return dealActivation;
    }

    public void setDealActivation(String dealActivation) {
        this.dealActivation = dealActivation;
    }

    public Deal dealExpiration(String dealExpiration) {
        this.dealExpiration = dealExpiration;
        return this;
    }

    /**
     * This is a timestamp in [ISO 8601](<a href="https://en.wikipedia.org/wiki/ISO_8601">...</a>) format: YYYY-MM-DDTHH:MM:SSZ.
     *
     * @return dealExpiration
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "2021-03-18T11:46:50.000Z", value = "This is a timestamp in [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) format: YYYY-MM-DDTHH:MM:SSZ.")
    public String getDealExpiration() {
        return dealExpiration;
    }

    public void setDealExpiration(String dealExpiration) {
        this.dealExpiration = dealExpiration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Deal deal = (Deal) o;
        return Objects.equals(this.batchRootCid, deal.batchRootCid) &&
                Objects.equals(this.lastChange, deal.lastChange) &&
                Objects.equals(this.miner, deal.miner) &&
                Objects.equals(this.network, deal.network) &&
                Objects.equals(this.pieceCid, deal.pieceCid) &&
                Objects.equals(this.status, deal.status) &&
                Objects.equals(this.statusText, deal.statusText) &&
                Objects.equals(this.chainDealID, deal.chainDealID) &&
                Objects.equals(this.dealActivation, deal.dealActivation) &&
                Objects.equals(this.dealExpiration, deal.dealExpiration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(batchRootCid, lastChange, miner, network, pieceCid, status, statusText, chainDealID, dealActivation, dealExpiration);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Deal {\n");
        sb.append("    batchRootCid: ").append(toIndentedString(batchRootCid)).append("\n");
        sb.append("    lastChange: ").append(toIndentedString(lastChange)).append("\n");
        sb.append("    miner: ").append(toIndentedString(miner)).append("\n");
        sb.append("    network: ").append(toIndentedString(network)).append("\n");
        sb.append("    pieceCid: ").append(toIndentedString(pieceCid)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    statusText: ").append(toIndentedString(statusText)).append("\n");
        sb.append("    chainDealID: ").append(toIndentedString(chainDealID)).append("\n");
        sb.append("    dealActivation: ").append(toIndentedString(dealActivation)).append("\n");
        sb.append("    dealExpiration: ").append(toIndentedString(dealExpiration)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}

