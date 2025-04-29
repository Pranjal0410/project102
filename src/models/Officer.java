package models;

public class Officer {
    private String id;
    private String name;
    private String rank;
    private boolean isAvailable;

    public Officer(String id, String name, String rank) {
        this.id = id;
        this.name = name;
        this.rank = rank;
        this.isAvailable = true;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRank() {
        return rank;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Officer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", rank='" + rank + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }
} 