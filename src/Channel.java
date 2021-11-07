/**
 * Homework 7 - Channel
 * <p>
 * The Channel class represents details about a content uploader.
 * This includes their channel name, subscribers, an array of Video
 * objects created by them, and the number of uploads.
 *
 * @author Ziyu Li
 * @version October 5, 2021
 */
public class Channel {
    /**
     * Name of the channel
     */
    private final String channelName;
    /**
     * Number of subscribers of this channel
     */
    private int channelSubscribers;
    /**
     * Number of videos uploaded by this channel. This may be of use when iterating through the videos array.
     */
    private int numUploads;
    /**
     * An array containing videos uploaded by this creator.
     */
    private Video[] videos;

    public Channel(String channelName) {
        this.channelName = channelName;
        this.channelSubscribers = 0;
        this.numUploads = 0;
        this.videos = new Video[100];
    }

    public Channel(String channelName, int channelSubscribers, int numUploads, Video[] videos) {
        this.channelName = channelName;
        this.channelSubscribers = channelSubscribers;
        this.numUploads = numUploads;
        this.videos = videos;
    }

    public void addChannelSubscriber() {
        channelSubscribers = channelSubscribers + 1;
    }

    public String getChannelName() {
        return channelName;
    }

    public int getChannelSubscribers() {
        return channelSubscribers;
    }

    public int getNumUploads() {
        return numUploads;
    }

    public void setChannelSubscribers(int channelSubscribers) {
        this.channelSubscribers = channelSubscribers;
    }

    public void setVideos(Video[] videos, int numUploads) {
        this.videos = videos;
        this.numUploads = numUploads;
    }

    public Video findVideo(String videoName) {
        for (int i = 0; i < this.videos.length; i++) {
            if (videoName.equals(this.videos[i].getVideoName())) {
                return this.videos[i];
            }
        }
        return null;
    }

    public int getTotalViews() {
        int total = 0;
        for (int i = 0; i < videos.length; i++) {
            total = videos[i].getViews();
            if(videos[i] == null){
                continue;
            }
        }
        return total;
    }

    public boolean uploadVideo(Video video) {
        for (int i = 0; i < videos.length; i++) {
            if (videos[i] != null) {
                if (videos[i].getVideoName().equals(video.getVideoName())) {
                    return false;
                }
            } else {
                if (i > 100) {
                    return false;
                } else {
                    videos[i] = video;
                    numUploads = numUploads + 1;
                    return true;
                }
            }
        }
        return false;

    }

    public Video[] getVideos() {
        return videos;
    }

    public String toString() {
        String s = "Channel[" + channelName + ", " + channelSubscribers + ", " + numUploads + "]";
        return s;
    }
}
