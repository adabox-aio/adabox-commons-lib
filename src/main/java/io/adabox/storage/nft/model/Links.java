package io.adabox.storage.nft.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Links
 */
public class Links {

    public static final String SERIALIZED_NAME_IPFS = "io/ipfs";
    private String ipfs;
    public static final String SERIALIZED_NAME_HTTP = "http";
    private String http;
    public static final String SERIALIZED_NAME_FILE = "file";
    private List<LinksFile> file = null;

    public Links ipfs(String ipfs) {
        this.ipfs = ipfs;
        return this;
    }

    /**
     * Get ipfs
     *
     * @return ipfs
     **/
    public String getIpfs() {
        return ipfs;
    }

    public void setIpfs(String ipfs) {
        this.ipfs = ipfs;
    }

    public Links http(String http) {
        this.http = http;
        return this;
    }

    /**
     * Get http
     *
     * @return http
     **/
    public String getHttp() {
        return http;
    }

    public void setHttp(String http) {
        this.http = http;
    }

    public Links file(List<LinksFile> file) {
        this.file = file;
        return this;
    }

    public Links addFileItem(LinksFile fileItem) {
        if (this.file == null) {
            this.file = new ArrayList<>();
        }
        this.file.add(fileItem);
        return this;
    }

    /**
     * Get file
     *
     * @return file
     **/
    public List<LinksFile> getFile() {
        return file;
    }

    public void setFile(List<LinksFile> file) {
        this.file = file;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Links links = (Links) o;
        return Objects.equals(this.ipfs, links.ipfs) &&
                Objects.equals(this.http, links.http) &&
                Objects.equals(this.file, links.file);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ipfs, http, file);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Links {\n");
        sb.append("    ipfs: ").append(toIndentedString(ipfs)).append("\n");
        sb.append("    http: ").append(toIndentedString(http)).append("\n");
        sb.append("    file: ").append(toIndentedString(file)).append("\n");
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
