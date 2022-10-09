package io.adabox.storage.nft.auth;

import okhttp3.Credentials;
import io.adabox.storage.nft.Pair;

import java.util.List;
import java.util.Map;

public class HttpBasicAuth implements Authentication {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void applyToParams(List<Pair> queryParams, Map<String, String> headerParams, Map<String, String> cookieParams) {
        if (username == null && password == null) {
            return;
        }
        headerParams.put("Authorization", Credentials.basic(username == null ? "" : username, password == null ? "" : password));
    }
}
