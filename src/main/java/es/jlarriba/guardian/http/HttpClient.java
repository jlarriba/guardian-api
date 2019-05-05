/*
 * Copyright 2019 jlarriba.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package es.jlarriba.guardian.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author jlarriba
 */
public class HttpClient {

    private static final Logger LOGGER = LogManager.getLogger();
    
    private final RequestConfig requestConfig;
    
    public HttpClient() {
        this.requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(5000)
                .setConnectTimeout(5000)
                .setSocketTimeout(2000)
                .build();
    }
    
    public String sendRequest(RequestBuilder builder) {
        HttpUriRequest request = builder.setConfig(requestConfig)
                .addHeader("Accept", "application/json")
                .build();
        
        CloseableHttpClient instance = HttpClientBuilder.create().build();
        CloseableHttpResponse response;
        String res = null;

        try {
            LOGGER.debug(request.getURI());
            LOGGER.debug(Arrays.asList(request.getAllHeaders()));
            
            response = instance.execute(request);
            LOGGER.debug(response.getStatusLine().getStatusCode() + " " + response.getStatusLine().getReasonPhrase());
            if (response.getStatusLine().getStatusCode() == 200) {
                res = new BufferedReader(new InputStreamReader(response.getEntity().getContent()))
                        .lines().parallel().collect(Collectors.joining("\n"));
            } else {
                LOGGER.debug(new BufferedReader(new InputStreamReader(response.getEntity().getContent()))
                        .lines().parallel().collect(Collectors.joining("\n")));
            }
            response.close();
        } catch (IOException e) {
            LOGGER.error("Error while launching request", e);
        }

        return res;
    }
}
