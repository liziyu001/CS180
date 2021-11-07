/**
 * Homework 7 - Video
 * <p>
 * The Video class represents common details about a video uploaded to a video sharing platform.
 * Each video is created by a Channel.
 * @author Ziyu Li
 * @version October 5, 2021
 */
public class Video {
    /**
     * Name of the video.
     */
    private final String videoName;
    /**
     * Channel which created the video.
     */
    private final Channel channel;
    /**
     * Length of video in seconds
     */
    private final int duration;
    /**
     * Number of views for the video, initialized at zero.
     */
    private int numViews;

    public Video(String videoName, Channel channel, int minutes, int seconds) {
        this.channel = channel;
        this.videoName = videoName;
        this.duration = minutes * 60 + seconds;
        this.numViews = 0;
    }

    public void addView() {
        numViews = numViews + 1;
    }

    public Channel getChannel() {
        return channel;
    }

    public String getDuration() {
        return this.duration / 60 + ":" + this.duration % 60;
    }

    public String getVideoName() {
        return videoName;
    }

    public int getViews() {
        return numViews;
    }

    public void setViews(int numViews) {
        this.numViews = numViews;
    }

    public String toString() {
        String s = "Video[" + this.videoName + ", "
                + this.channel + ", " + this.duration / 60
                + ":" + this.duration % 60 + ", " + this.numViews + "]";
        return s;
    }
}

