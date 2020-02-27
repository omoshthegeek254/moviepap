
package com.example.movie101.models2;

import java.util.List;

import com.example.movie101.models.Result;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Series {

    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("total_results")
    @Expose
    private Integer totalResults;
    @SerializedName("total_pages")
    @Expose
    private Integer totalPages;
    @SerializedName("results")
    @Expose
    private List<com.example.movie101.models.Result> results = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Series() {
    }

    /**
     * 
     * @param totalResults
     * @param totalPages
     * @param page
     * @param results
     */
    public Series(Integer page, Integer totalResults, Integer totalPages, List<com.example.movie101.models.Result> results) {
        super();
        this.page = page;
        this.totalResults = totalResults;
        this.totalPages = totalPages;
        this.results = results;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public List<com.example.movie101.models.Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

}
