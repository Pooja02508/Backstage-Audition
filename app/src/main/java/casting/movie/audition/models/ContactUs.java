package casting.movie.audition.models;

public class ContactUs {

    String image,gif_image;

    public ContactUs(String gif_image,String image) {
        this.image = image;
        this.gif_image = gif_image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getGif_image() {
        return gif_image;
    }

    public void setGif_image(String gif_image) {
        this.gif_image = gif_image;
    }
}
