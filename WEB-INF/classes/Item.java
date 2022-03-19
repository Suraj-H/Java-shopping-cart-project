package cart;

public class Item {
    private int id;
    private String name;
    private String imagePath;
    private String description;
    private double price;

    public Item() { }

    public Item(final int id, final String name, final String imagePath, final String description, final double price) {
        this.id = id;
        this.name = name;
        this.imagePath = imagePath;
        this.description = description;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(final String imagePath) {
        this.imagePath = imagePath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(final double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        return (((Item) obj).id == id);
    }
}