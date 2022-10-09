package io.adabox.storage.nft.api;

import com.google.gson.reflect.TypeToken;
import io.adabox.storage.nft.*;
import io.adabox.storage.nft.model.DeleteResponse;
import io.adabox.storage.nft.model.GetResponse;
import io.adabox.storage.nft.model.ListResponse;
import io.adabox.storage.nft.model.UploadResponse;
import org.threeten.bp.OffsetDateTime;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NftStorageApi {

    private ApiClient localVarApiClient;
    private final String[] localVarAccepts = { "application/json" };

    public NftStorageApi() {
        this(Configuration.getDefaultApiClient());
    }

    public NftStorageApi(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return localVarApiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    /**
     * Build call for delete
     * @param cid CID for the NFT (required)
     * @param callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public okhttp3.Call deleteCall(String cid, final ApiCallback callback) throws ApiException {
        // create path and map variables
        String localVarPath = "/{cid}".replaceAll("\\{" + "cid" + "\\}", localVarApiClient.escapeString(cid));
        List<Pair> localVarQueryParams = new ArrayList<>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<>();
        Map<String, String> localVarHeaderParams = new HashMap<>();
        Map<String, String> localVarCookieParams = new HashMap<>();
        Map<String, Object> localVarFormParams = new HashMap<>();
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }
        final String[] localVarContentTypes = {};
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);
        String[] localVarAuthNames = new String[] { "bearerAuth" };
        return localVarApiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, null, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, callback);
    }

    private okhttp3.Call deleteValidateBeforeCall(String cid, final ApiCallback<DeleteResponse> callback) throws ApiException {
        // verify the required parameter 'cid' is set
        if (cid == null) {
            throw new ApiException("Missing the required parameter 'cid' when calling delete(Async)");
        }
        return deleteCall(cid, callback);
    }

    /**
     * Stop storing the content with the passed CID
     * Stop storing the content with the passed CID on nft.storage. - Unpin the item from the underlying IPFS pinning service. - Cease renewals for expired Filecoin deals involving the CID.    ⚠️ This does not remove the content from the network.  - Does not terminate any established Filecoin deal. - Does not remove the content from other IPFS nodes in the network that already cached or pinned the CID.    Note: the content will remain available if another user has stored the CID with nft.storage.
     * @param cid CID for the NFT (required)
     * @return DeleteResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public DeleteResponse delete(String cid) throws ApiException {
        ApiResponse<DeleteResponse> localVarResp = deleteWithHttpInfo(cid);
        return localVarResp.getData();
    }

    /**
     * Stop storing the content with the passed CID
     * Stop storing the content with the passed CID on nft.storage. - Unpin the item from the underlying IPFS pinning service. - Cease renewals for expired Filecoin deals involving the CID.    ⚠️ This does not remove the content from the network.  - Does not terminate any established Filecoin deal. - Does not remove the content from other IPFS nodes in the network that already cached or pinned the CID.    Note: the content will remain available if another user has stored the CID with nft.storage.
     * @param cid CID for the NFT (required)
     * @return ApiResponse&lt;DeleteResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<DeleteResponse> deleteWithHttpInfo(String cid) throws ApiException {
        okhttp3.Call localVarCall = deleteValidateBeforeCall(cid, null);
        Type localVarReturnType = new TypeToken<DeleteResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Stop storing the content with the passed CID (asynchronously)
     * Stop storing the content with the passed CID on nft.storage. - Unpin the item from the underlying IPFS pinning service. - Cease renewals for expired Filecoin deals involving the CID.    ⚠️ This does not remove the content from the network.  - Does not terminate any established Filecoin deal. - Does not remove the content from other IPFS nodes in the network that already cached or pinned the CID.    Note: the content will remain available if another user has stored the CID with nft.storage.
     * @param cid CID for the NFT (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public okhttp3.Call deleteAsync(String cid, final ApiCallback<DeleteResponse> callback) throws ApiException {
        okhttp3.Call localVarCall = deleteValidateBeforeCall(cid, callback);
        Type localVarReturnType = new TypeToken<DeleteResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, callback);
        return localVarCall;
    }

    /**
     * Build call for list
     * @param before Return results created before provided timestamp (optional)
     * @param limit Max records to return (optional, default to 10)
     * @param callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public okhttp3.Call listCall(OffsetDateTime before, Integer limit, final ApiCallback<ListResponse> callback) throws ApiException {
        // create path and map variables
        String localVarPath = "/";
        List<Pair> localVarQueryParams = new ArrayList<>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<>();
        Map<String, String> localVarHeaderParams = new HashMap<>();
        Map<String, String> localVarCookieParams = new HashMap<>();
        Map<String, Object> localVarFormParams = new HashMap<>();
        if (before != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("before", before));
        }
        if (limit != null) {
            localVarQueryParams.addAll(localVarApiClient.parameterToPair("limit", limit));
        }
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }
        final String[] localVarContentTypes = {};
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        String[] localVarAuthNames = new String[] { "bearerAuth" };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, null, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, callback);
    }

    private okhttp3.Call listValidateBeforeCall(OffsetDateTime before, Integer limit, final ApiCallback<ListResponse> callback) throws ApiException {
        return listCall(before, limit, callback);
    }

    /**
     * List all stored files
     *
     * @param before Return results created before provided timestamp (optional)
     * @param limit Max records to return (optional, default to 10)
     * @return ListResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ListResponse list(OffsetDateTime before, Integer limit) throws ApiException {
        ApiResponse<ListResponse> localVarResp = listWithHttpInfo(before, limit);
        return localVarResp.getData();
    }

    /**
     * List all stored files
     *
     * @param before Return results created before provided timestamp (optional)
     * @param limit Max records to return (optional, default to 10)
     * @return ApiResponse&lt;ListResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<ListResponse> listWithHttpInfo(OffsetDateTime before, Integer limit) throws ApiException {
        okhttp3.Call localVarCall = listValidateBeforeCall(before, limit, null);
        Type localVarReturnType = new TypeToken<ListResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * List all stored files (asynchronously)
     *
     * @param before Return results created before provided timestamp (optional)
     * @param limit Max records to return (optional, default to 10)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public okhttp3.Call listAsync(OffsetDateTime before, Integer limit, final ApiCallback<ListResponse> callback) throws ApiException {
        okhttp3.Call localVarCall = listValidateBeforeCall(before, limit, callback);
        localVarApiClient.executeAsync(localVarCall, new TypeToken<ListResponse>(){}.getType(), callback);
        return localVarCall;
    }

    /**
     * Build call for status
     * @param cid CID for the NFT (required)
     * @param callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public okhttp3.Call statusCall(String cid, final ApiCallback<GetResponse> callback) throws ApiException {
        // create path and map variables
        String localVarPath = "/{cid}"
            .replaceAll("\\{" + "cid" + "\\}", localVarApiClient.escapeString(cid));
        List<Pair> localVarQueryParams = new ArrayList<>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<>();
        Map<String, String> localVarHeaderParams = new HashMap<>();
        Map<String, String> localVarCookieParams = new HashMap<>();
        Map<String, Object> localVarFormParams = new HashMap<>();
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }
        final String[] localVarContentTypes = {

        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);
        String[] localVarAuthNames = new String[] { "bearerAuth" };
        return localVarApiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, null, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, callback);
    }

    private okhttp3.Call statusValidateBeforeCall(String cid, final ApiCallback<GetResponse> callback) throws ApiException {
        // verify the required parameter 'cid' is set
        if (cid == null) {
            throw new ApiException("Missing the required parameter 'cid' when calling status(Async)");
        }
        return statusCall(cid, callback);
    }

    /**
     * Get information for the stored file CID
     * Includes the IPFS pinning state and the Filecoin deal state.
     * @param cid CID for the NFT (required)
     * @return GetResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public GetResponse status(String cid) throws ApiException {
        ApiResponse<GetResponse> localVarResp = statusWithHttpInfo(cid);
        return localVarResp.getData();
    }

    /**
     * Get information for the stored file CID
     * Includes the IPFS pinning state and the Filecoin deal state.
     * @param cid CID for the NFT (required)
     * @return ApiResponse&lt;GetResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<GetResponse> statusWithHttpInfo(String cid) throws ApiException {
        okhttp3.Call localVarCall = statusValidateBeforeCall(cid, null);
        Type localVarReturnType = new TypeToken<GetResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Get information for the stored file CID (asynchronously)
     * Includes the IPFS pinning state and the Filecoin deal state.
     * @param cid CID for the NFT (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public okhttp3.Call statusAsync(String cid, final ApiCallback<GetResponse> callback) throws ApiException {
        okhttp3.Call localVarCall = statusValidateBeforeCall(cid, callback);
        Type localVarReturnType = new TypeToken<GetResponse>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, callback);
        return localVarCall;
    }
    /**
     * Build call for store
     * @param body  (required)
     * @param callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public okhttp3.Call storeCall(File body, final ApiCallback<UploadResponse> callback) throws ApiException, IOException {
        List<Pair> localVarCollectionQueryParams = new ArrayList<>();
        Map<String, String> localVarHeaderParams = new HashMap<>();
        Map<String, String> localVarCookieParams = new HashMap<>();
        Map<String, Object> localVarFormParams = new HashMap<>();
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }
        String mimeType = Files.probeContentType(body.toPath());
        final List<String> localVarContentTypesList = new ArrayList<>();
        localVarContentTypesList.add(mimeType);
        localVarContentTypesList.add("application/octet-stream");
        localVarContentTypesList.add("multipart/form-data");
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypesList.toArray(new String[0]));
        localVarHeaderParams.put("Content-Type", localVarContentType);
        String[] localVarAuthNames = new String[] { "bearerAuth" };
        return localVarApiClient.buildCall("/upload", "POST", new ArrayList<>(), localVarCollectionQueryParams, body, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, callback);
    }

    private okhttp3.Call storeValidateBeforeCall(File body, final ApiCallback<UploadResponse> callback) throws ApiException, IOException {
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new ApiException("Missing the required parameter 'body' when calling store(Async)");
        }
        return storeCall(body, callback);
    }

    /**
     * Store a file
     * Store a file with nft.storage.  - Submit a HTTP &#x60;POST&#x60; request passing the file data in the request body. - To store multiple files in a directory, submit a &#x60;multipart/form-data&#x60; HTTP &#x60;POST&#x60; request.  Use the &#x60;Content-Disposition&#x60; header for each part to specify a filename.
     * @param body  (required)
     * @return UploadResponse
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public UploadResponse store(File body) throws ApiException, IOException {
        return storeWithHttpInfo(body).getData();
    }

    /**
     * Store a file
     * Store a file with nft.storage.  - Submit a HTTP &#x60;POST&#x60; request passing the file data in the request body. - To store multiple files in a directory, submit a &#x60;multipart/form-data&#x60; HTTP &#x60;POST&#x60; request.  Use the &#x60;Content-Disposition&#x60; header for each part to specify a filename.
     * @param body  (required)
     * @return ApiResponse&lt;UploadResponse&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<UploadResponse> storeWithHttpInfo(File body) throws ApiException, IOException {
        okhttp3.Call localVarCall = storeValidateBeforeCall(body, null);
        Type localVarReturnType = new TypeToken<UploadResponse>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Store a file (asynchronously)
     * Store a file with nft.storage.  - Submit a HTTP &#x60;POST&#x60; request passing the file data in the request body. - To store multiple files in a directory, submit a &#x60;multipart/form-data&#x60; HTTP &#x60;POST&#x60; request.  Use the &#x60;Content-Disposition&#x60; header for each part to specify a filename.
     * @param body  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public okhttp3.Call storeAsync(File body, final ApiCallback<UploadResponse> callback) throws ApiException, IOException {
        okhttp3.Call localVarCall = storeValidateBeforeCall(body, callback);
        localVarApiClient.executeAsync(localVarCall, new TypeToken<UploadResponse>(){}.getType(), callback);
        return localVarCall;
    }
}
