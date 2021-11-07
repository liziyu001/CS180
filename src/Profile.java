/**
 * Homework 7 - Profile
 * <p>
 * The Profile class represents details about a content viewer.
 * This includes their username, an array of Channel
 * objects representing content creators they've subscribed to, and the
 * number of channels subscribed to.
 *
 * @author Ziyu Li
 * @version October 5, 2021
 */
public class Profile {
    /**
     * Username of the user
     */
    private final String username;
    /**
     * An array containing channels subscribed to by this user.
     */
    private Channel[] subscribed;
    /**
     * Number of channels subscribed to by this user
     */
    private int numSubscribed;

    public Profile(String username) {
        this.username = username;
        numSubscribed = 0;
        subscribed = new Channel[100];
    }

    public Channel[] getSubscribed() {
        return subscribed;
    }

    public String getUsername() {
        return username;
    }

    public void setSubscribed(Channel[] subscribed, int numSubscribed) {
        this.subscribed = subscribed;
        this.numSubscribed = numSubscribed;
    }

    public Channel findChannel(String channelName) {
        for (int i = 0; i < subscribed.length; i++) {
            if (subscribed[i].getChannelName().equals(channelName)) {
                return subscribed[i];
            }
        }
        return null;
    }

    public boolean subscribeToChannel(Channel channel) {


       for (int i = 0; i < subscribed.length; i++) {
            if (subscribed[i] != null) {
                if (subscribed[i].getChannelName().equals(channel.getChannelName())) {
                    return false;
                }
            } else {
                if (i > 100) {
                    return false;
                } else {
                    subscribed[i] = channel;
                    numSubscribed = numSubscribed + 1;
                    channel.addChannelSubscriber();
                    return true;
                }
            }
        }
        return false;

    }

    public String toString() {
        String s = "Profile[" + username + "]";
        return s;
    }
}

