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
package es.jlarriba.guardian.model;

/**
 *
 * @author juanlarriba
 */
public class Result {

    private String id;
    private String type;
    private String sectionId;
    private String sectionName;
    private String webPublicationDate;
    private String webTitle;
    private String webUrl;
    private String apiUrl;
    private boolean isHosted;
    private String pillarId;
    private String pillarName;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the sectionId
     */
    public String getSectionId() {
        return sectionId;
    }

    /**
     * @param sectionId the sectionId to set
     */
    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }

    /**
     * @return the sectionName
     */
    public String getSectionName() {
        return sectionName;
    }

    /**
     * @param sectionName the sectionName to set
     */
    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    /**
     * @return the webPublicationDate
     */
    public String getWebPublicationDate() {
        return webPublicationDate;
    }

    /**
     * @param webPublicationDate the webPublicationDate to set
     */
    public void setWebPublicationDate(String webPublicationDate) {
        this.webPublicationDate = webPublicationDate;
    }

    /**
     * @return the webTitle
     */
    public String getWebTitle() {
        return webTitle;
    }

    /**
     * @param webTitle the webTitle to set
     */
    public void setWebTitle(String webTitle) {
        this.webTitle = webTitle;
    }

    /**
     * @return the webUrl
     */
    public String getWebUrl() {
        return webUrl;
    }

    /**
     * @param webUrl the webUrl to set
     */
    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    /**
     * @return the apiUrl
     */
    public String getApiUrl() {
        return apiUrl;
    }

    /**
     * @param apiUrl the apiUrl to set
     */
    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    /**
     * @return the isHosted
     */
    public boolean isIsHosted() {
        return isHosted;
    }

    /**
     * @param isHosted the isHosted to set
     */
    public void setIsHosted(boolean isHosted) {
        this.isHosted = isHosted;
    }

    /**
     * @return the pillarId
     */
    public String getPillarId() {
        return pillarId;
    }

    /**
     * @param pillarId the pillarId to set
     */
    public void setPillarId(String pillarId) {
        this.pillarId = pillarId;
    }

    /**
     * @return the pillarName
     */
    public String getPillarName() {
        return pillarName;
    }

    /**
     * @param pillarName the pillarName to set
     */
    public void setPillarName(String pillarName) {
        this.pillarName = pillarName;
    }

    @Override
    public String toString() {
        return "Result{"
                + "id='" + id + '\''
                + ", type='" + type + '\''
                + ", sectionId='" + sectionId + '\''
                + ", sectionName='" + sectionName + '\''
                + ", webPublicationDate='" + webPublicationDate + '\''
                + ", webTitle='" + webTitle + '\''
                + ", webUrl='" + webUrl + '\''
                + ", apiUrl='" + apiUrl + '\''
                + ", isHosted='" + isHosted + '\''
                + '}';
    }
}
