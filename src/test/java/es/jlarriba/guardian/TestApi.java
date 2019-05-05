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
import com.google.gson.GsonBuilder;
import java.time.LocalDateTime;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

/**
 *
 * @author juanlarriba
 */
public class TestApi {
    
    private static final String API_KEY = "";
    
    @Test
    public void testBasicQuery() {
        GuardianApi api = new GuardianApi(API_KEY);
        api.search().getResults().forEach(System.out::println);
    }
    
    @Test
    public void testResultsFromTechnology() {
        GuardianApi api = new GuardianApi(API_KEY)
                .section("technology")
                .pageSize(20);
        api.search().getResults().forEach(System.out::println);
    }
    
    @Test
    public void testFromToDate() {
        GuardianApi api = new GuardianApi(API_KEY)
                .fromDate(LocalDateTime.now().minusDays(1))
                .toDate(LocalDateTime.now())
                .pageSize(100);
                
        api.search().getResults().forEach(System.out::println);
    }
    
    @Test
    public void testResultsFromLinuxInTechnology() {
        GuardianApi api = new GuardianApi(API_KEY)
                .section("technology")
                .pageSize(20);
        api.search("linux").getResults().forEach(System.out::println);
    }
}
