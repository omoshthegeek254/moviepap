
package com.example.movie101.models2;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("original_name")
    @Expose
    private String originalName;
    @SerializedName("genre_ids")
    @Expose
    private List<Integer> genreIds = null;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("popularity")
    @Expose
    private Double popularity;
    @SerializedName("origin_country")
    @Expose
    private List<String> originCountry = null;
    @SerializedName("vote_count")
    @Expose
    private Integer voteCount;
    @SerializedName("first_air_date")
    @Expose
    private String firstAirDate;
    @SerializedName("backdrop_path")
    @Expose
    private Object backdropPath;
    @SerializedName("original_language")
    @Expose
    private String originalLanguage;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("vote_average")
    @Expose
    private Integer voteAverage;
    @SerializedName("overview")
    @Expose
    private String overview;
    @SerializedName("poster_path")
    @Expose
    private String posterPath;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Result() {
    }

    /**
     * 
     * @param overview
     * @param voteAverage
     * @param genreIds
     * @param originalLanguage
     * @param originalName
     * @param firstAirDate
     * @param popularity
     * @param name
     * @param originCountry
     * @param voteCount
     * @param backdropPath
     * @param id
     * @param posterPath
     */
    public Result(String originalName, List<Integer> genreIds, String name, Double popularity, List<String> originCountry, Integer voteCount, String firstAirDate, Object backdropPath, String originalLanguage, Integer id, Integer voteAverage, String overview, String posterPath) {
        super();
        this.originalName = originalName;
        this.genreIds = genreIds;
        this.name = name;
        this.popularity = popularity;
        this.originCountry = originCountry;
        this.voteCount = voteCount;
        this.firstAirDate = firstAirDate;
        this.backdropPath = backdropPath;
        this.originalLanguage = originalLanguage;
        this.id = id;
        this.voteAverage = voteAverage;
        this.overview = overview;
        this.posterPath = posterPath;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public List<Integer> getGenreIds() {
        return genreIds;
    }

    public void setGenreIds(List<Integer> genreIds) {
        this.genreIds = genreIds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public List<String> getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(List<String> originCountry) {
        this.originCountry = originCountry;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    public String getFirstAirDate() {
        return firstAirDate;
    }

    public void setFirstAirDate(String firstAirDate) {
        this.firstAirDate = firstAirDate;
    }

    public Object getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(Object backdropPath) {
        this.backdropPath = backdropPath;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(Integer voteAverage) {
        this.voteAverage = voteAverage;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

}
