package mryang.funnyisland.entity;

/**
 * Created by Mr.Yang on 2017/5/16.
 */

public class ProductListModel {

    private String imgUrl;
    private String title;

    public ProductListModel(String imgUrl, String title) {
        this.imgUrl = imgUrl;
        this.title = title;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
