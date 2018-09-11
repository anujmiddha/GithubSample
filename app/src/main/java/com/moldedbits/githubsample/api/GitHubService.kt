package com.moldedbits.githubsample.api

import com.moldedbits.githubsample.model.RepositoriesResponse
import com.moldedbits.githubsample.model.Repository
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GitHubService {

    /**
     * Fetch the trending Repositories for a given keyword, sorted by the highest starred first
     *
     * @param query     The keyword to search. Default is "android"
     * @param page      Which page to fetch (for pagination). By default the first page is fetched
     * @param perPage   Number of repositories to be fetched (for pagination). Default is 30
     */
    @GET("/search/repositories?sort=stars&order=desc")
    fun trendingRepos(@Query("q") query: String = "android",
                      @Query("page") page: Int = 1,
                      @Query("per_page") perPage: Int = 30):
            Single<RepositoriesResponse>

    /**
     * Fetch the repository details
     *
     * @param owner Login id of the repository owner
     * @param repo  Repo name
     */
    @GET("/repos/{owner}/{repo}")
    fun repoDetails(@Path("owner") owner: String,
                    @Path("repo") repo: String):
            Single<Repository>
}