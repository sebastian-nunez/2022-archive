/**
 * The {@code Streamer} class represents an individual streamer.
 * <pre>
 *     Streamer(String name, String category, Integer views)
 * </pre>
 */
public class Streamer {
    private String name;
    private String category;
    private Integer views;

    public Streamer() {
        this.name = "";
        this.views = 0;
        this.category = "";
    }

    public Streamer(String name) {
        this.name = name;
        this.views = 0;
        this.category = "";
    }

    public Streamer(String name, String category, Integer views) {
        this.name = name;
        setCategory(category);
        setViews(views);
    }

    public String getName() {
        return name;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        if (views >= 0) {
            this.views = views;
        } else {
            this.views = 0;
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
        if (views > other.getViews()) {
            return 1;
        } else if (views < other.getViews()) {
            return -1;
        } else {
            return 0;
        }
    }

    public String toString() {
        if (views == 0) {
            return "'" + name + "' is offline!";
        }

        return name + ": " + this.category + " -> " + views;
    }

}
