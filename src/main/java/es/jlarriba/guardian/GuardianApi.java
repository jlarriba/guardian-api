/*
 * Copyright 2019 juanlarriba.
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
package es.jlarriba.guardian;   

import com.google.gson.Gson;
import es.jlarriba.guardian.http.HttpClient;
import es.jlarriba.guardian.model.Response;
import es.jlarriba.guardian.model.ResponseWrapper;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author juanlarriba
 */
public class GuardianApi {
    
    private static final String BASE_URL = "https://content.guardianapis.com"; 
    private static final String SEARCH_BASE_URL = BASE_URL + "/search";
    
    private final String apiKey;
    private String section;
    private String tag;
    private LocalDateTime toDate;
    private LocalDateTime fromDate;
    private int pageSize;
    
    private final Gson gson;
    
    private final HttpClient http;
    
    public GuardianApi(String apiKey) {
        this.apiKey = apiKey;
        this.gson = new Gson();
        this.pageSize = 10;
        this.http = new HttpClient();
    }
    
    public Response search() {
        return search(null);
    }
    
    public Response search(String query) {
        RequestBuilder rb = RequestBuilder.get(SEARCH_BASE_URL)
                .addParameter("api-key", apiKey)
                .addHeader("Accept", "application/json");
        
        if (query != null && !query.isEmpty()) {
            rb.addParameter("q", query);
        }
        
        if (this.section != null && !this.section.isEmpty()) {
            rb.addParameter("section", this.section);
        }
        
        if (this.tag != null && !this.tag.isEmpty()) {
            rb.addParameter("tag", this.tag);
        }
        
        if (this.toDate != null) {
            rb.addParameter("to-date", this.toDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        }
        
        if (this.fromDate != null) {
            rb.addParameter("from-date", this.fromDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        }
        
        if (this.pageSize != 10) {
            rb.addParameter("page-size", Integer.toString(this.pageSize));
        }
        
        String json = http.sendRequest(rb);
        if (json != null && !json.isEmpty()) {
            return gson.fromJson(json, ResponseWrapper.class).getResponse();
        } else {
            return new Response();
        }
    }

    public GuardianApi section(String section) {
        this.section = section;
        return this;
    }

    public GuardianApi tag(String tag) {
        this.tag = tag;
        return this;
    }

    public GuardianApi toDate(LocalDateTime toDate) {
        this.toDate = toDate;
        return this;
    }

    public GuardianApi fromDate(LocalDateTime fromDate) {
        this.fromDate = fromDate;
        return this;
    }

    public GuardianApi pageSize(int pageSize) {
        this.pageSize = pageSize;
        return this;
    }
}
