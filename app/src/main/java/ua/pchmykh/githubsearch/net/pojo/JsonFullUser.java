
package ua.pchmykh.githubsearch.net.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JsonFullUser {

    @SerializedName("login")
    @Expose
    private String login;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("avatar_url")
    @Expose
    private String avatarUrl;
    @SerializedName("gravatar_id")
    @Expose
    private String gravatarId;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("html_url")
    @Expose
    private String htmlUrl;
    @SerializedName("followers_url")
    @Expose
    private String followersUrl;
    @SerializedName("following_url")
    @Expose
    private String followingUrl;
    @SerializedName("gists_url")
    @Expose
    private String gistsUrl;
    @SerializedName("starred_url")
    @Expose
    private String starredUrl;
    @SerializedName("subscriptions_url")
    @Expose
    private String subscriptionsUrl;
    @SerializedName("organizations_url")
    @Expose
    private String organizationsUrl;
    @SerializedName("repos_url")
    @Expose
    private String reposUrl;
    @SerializedName("events_url")
    @Expose
    private String eventsUrl;
    @SerializedName("received_events_url")
    @Expose
    private String receivedEventsUrl;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("site_admin")
    @Expose
    private Boolean siteAdmin;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("company")
    @Expose
    private Object company;
    @SerializedName("blog")
    @Expose
    private String blog;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("email")
    @Expose
    private Object email;
    @SerializedName("hireable")
    @Expose
    private Object hireable;
    @SerializedName("bio")
    @Expose
    private String bio;

    @SerializedName("public_repos")
    @Expose

    private Integer publicRepos;
    @SerializedName("public_gists")
    @Expose
    private Integer publicGists;
    @SerializedName("followers")
    @Expose
    private Integer followers;
    @SerializedName("following")
    @Expose
    private Integer following;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getGravatarId() {
        return gravatarId;
    }

    public void setGravatarId(String gravatarId) {
        this.gravatarId = gravatarId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JsonFullUser)) return false;

        JsonFullUser that = (JsonFullUser) o;

        if (login != null ? !login.equals(that.login) : that.login != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (avatarUrl != null ? !avatarUrl.equals(that.avatarUrl) : that.avatarUrl != null)
            return false;
        if (gravatarId != null ? !gravatarId.equals(that.gravatarId) : that.gravatarId != null)
            return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        if (htmlUrl != null ? !htmlUrl.equals(that.htmlUrl) : that.htmlUrl != null) return false;
        if (followersUrl != null ? !followersUrl.equals(that.followersUrl) : that.followersUrl != null)
            return false;
        if (followingUrl != null ? !followingUrl.equals(that.followingUrl) : that.followingUrl != null)
            return false;
        if (gistsUrl != null ? !gistsUrl.equals(that.gistsUrl) : that.gistsUrl != null)
            return false;
        if (starredUrl != null ? !starredUrl.equals(that.starredUrl) : that.starredUrl != null)
            return false;
        if (subscriptionsUrl != null ? !subscriptionsUrl.equals(that.subscriptionsUrl) : that.subscriptionsUrl != null)
            return false;
        if (organizationsUrl != null ? !organizationsUrl.equals(that.organizationsUrl) : that.organizationsUrl != null)
            return false;
        if (reposUrl != null ? !reposUrl.equals(that.reposUrl) : that.reposUrl != null)
            return false;
        if (eventsUrl != null ? !eventsUrl.equals(that.eventsUrl) : that.eventsUrl != null)
            return false;
        if (receivedEventsUrl != null ? !receivedEventsUrl.equals(that.receivedEventsUrl) : that.receivedEventsUrl != null)
            return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (siteAdmin != null ? !siteAdmin.equals(that.siteAdmin) : that.siteAdmin != null)
            return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (company != null ? !company.equals(that.company) : that.company != null) return false;
        if (blog != null ? !blog.equals(that.blog) : that.blog != null) return false;
        if (location != null ? !location.equals(that.location) : that.location != null)
            return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (hireable != null ? !hireable.equals(that.hireable) : that.hireable != null)
            return false;
        if (bio != null ? !bio.equals(that.bio) : that.bio != null) return false;
        if (publicRepos != null ? !publicRepos.equals(that.publicRepos) : that.publicRepos != null)
            return false;
        if (publicGists != null ? !publicGists.equals(that.publicGists) : that.publicGists != null)
            return false;
        if (followers != null ? !followers.equals(that.followers) : that.followers != null)
            return false;
        if (following != null ? !following.equals(that.following) : that.following != null)
            return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null)
            return false;
        return updatedAt != null ? updatedAt.equals(that.updatedAt) : that.updatedAt == null;
    }

    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (avatarUrl != null ? avatarUrl.hashCode() : 0);
        result = 31 * result + (gravatarId != null ? gravatarId.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (htmlUrl != null ? htmlUrl.hashCode() : 0);
        result = 31 * result + (followersUrl != null ? followersUrl.hashCode() : 0);
        result = 31 * result + (followingUrl != null ? followingUrl.hashCode() : 0);
        result = 31 * result + (gistsUrl != null ? gistsUrl.hashCode() : 0);
        result = 31 * result + (starredUrl != null ? starredUrl.hashCode() : 0);
        result = 31 * result + (subscriptionsUrl != null ? subscriptionsUrl.hashCode() : 0);
        result = 31 * result + (organizationsUrl != null ? organizationsUrl.hashCode() : 0);
        result = 31 * result + (reposUrl != null ? reposUrl.hashCode() : 0);
        result = 31 * result + (eventsUrl != null ? eventsUrl.hashCode() : 0);
        result = 31 * result + (receivedEventsUrl != null ? receivedEventsUrl.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (siteAdmin != null ? siteAdmin.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (company != null ? company.hashCode() : 0);
        result = 31 * result + (blog != null ? blog.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (hireable != null ? hireable.hashCode() : 0);
        result = 31 * result + (bio != null ? bio.hashCode() : 0);
        result = 31 * result + (publicRepos != null ? publicRepos.hashCode() : 0);
        result = 31 * result + (publicGists != null ? publicGists.hashCode() : 0);
        result = 31 * result + (followers != null ? followers.hashCode() : 0);
        result = 31 * result + (following != null ? following.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    public String getFollowersUrl() {
        return followersUrl;
    }

    public void setFollowersUrl(String followersUrl) {
        this.followersUrl = followersUrl;
    }

    public String getFollowingUrl() {
        return followingUrl;
    }

    public void setFollowingUrl(String followingUrl) {
        this.followingUrl = followingUrl;
    }

    public String getGistsUrl() {
        return gistsUrl;
    }

    public void setGistsUrl(String gistsUrl) {
        this.gistsUrl = gistsUrl;
    }

    public String getStarredUrl() {
        return starredUrl;
    }

    public void setStarredUrl(String starredUrl) {
        this.starredUrl = starredUrl;
    }

    public String getSubscriptionsUrl() {
        return subscriptionsUrl;
    }

    public void setSubscriptionsUrl(String subscriptionsUrl) {
        this.subscriptionsUrl = subscriptionsUrl;
    }

    public String getOrganizationsUrl() {
        return organizationsUrl;
    }

    public void setOrganizationsUrl(String organizationsUrl) {
        this.organizationsUrl = organizationsUrl;
    }

    public String getReposUrl() {
        return reposUrl;
    }

    public void setReposUrl(String reposUrl) {
        this.reposUrl = reposUrl;
    }

    public String getEventsUrl() {
        return eventsUrl;
    }

    public void setEventsUrl(String eventsUrl) {
        this.eventsUrl = eventsUrl;
    }

    public String getReceivedEventsUrl() {
        return receivedEventsUrl;
    }

    public void setReceivedEventsUrl(String receivedEventsUrl) {
        this.receivedEventsUrl = receivedEventsUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getSiteAdmin() {
        return siteAdmin;
    }

    public void setSiteAdmin(Boolean siteAdmin) {
        this.siteAdmin = siteAdmin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getCompany() {
        return company;
    }

    public void setCompany(Object company) {
        this.company = company;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Object getEmail() {
        return email;
    }

    public void setEmail(Object email) {
        this.email = email;
    }

    public Object getHireable() {
        return hireable;
    }

    public void setHireable(Object hireable) {
        this.hireable = hireable;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Integer getPublicRepos() {
        return publicRepos;
    }

    public void setPublicRepos(Integer publicRepos) {
        this.publicRepos = publicRepos;
    }

    public Integer getPublicGists() {
        return publicGists;
    }

    public void setPublicGists(Integer publicGists) {
        this.publicGists = publicGists;
    }

    public Integer getFollowers() {
        return followers;
    }

    public void setFollowers(Integer followers) {
        this.followers = followers;
    }

    public Integer getFollowing() {
        return following;
    }

    public void setFollowing(Integer following) {
        this.following = following;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

}
