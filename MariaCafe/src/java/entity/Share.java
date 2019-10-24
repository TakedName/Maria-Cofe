
package entity;

public class Share {
    private String icon, socialNetwork, URL;

    public Share() {
    }

    public Share(String icon, String socialNetwork, String URL) {
        this.icon = icon;
        this.socialNetwork = socialNetwork;
        this.URL = URL;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getSocialNetwork() {
        return socialNetwork;
    }

    public void setSocialNetwork(String socialNetwork) {
        this.socialNetwork = socialNetwork;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }
    
}
