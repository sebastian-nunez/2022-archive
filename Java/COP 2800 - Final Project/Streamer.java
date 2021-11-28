/**
 * The {@code Streamer} class represents an individual streamer.
 * <pre>
 *     Streamer(String name, String category, Integer viewers)
 * </pre>
 */
public class Streamer {
    private String name;
    private String category;
    private Integer viewers;

    public Streamer() {
        this.name = "";
        this.viewers = 0;
        this.category = "";
    }

    public Streamer(String name) {
        this.name = name;
        this.viewers = 0;
        this.category = "";
    }

    public Streamer(String name, String category, Integer viewers) {
        this.name = name;
        setCategory(category);
        setViewers(viewers);
    }

    public String getName() {
        return name;
    }

    public Integer getViewers() {
        return viewers;
    }

    public void setViewers(Integer viewers) {
        if (viewers >= 0) {
            this.viewers = viewers;
        } else {
            this.viewers = 0;
        }
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Compares streamers based on their number of viewers.
     */
    public int compareTo(Streamer other) {
        if (viewers > other.getViewers()) {
            return 1;
        } else if (viewers < other.getViewers()) {
            return -1;
        } else {
            return 0;
        }
    }

    public String toString() {
        return name + ": " + this.category + " -> " + viewers;
    }

}
