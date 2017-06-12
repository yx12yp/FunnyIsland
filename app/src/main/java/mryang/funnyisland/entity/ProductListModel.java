package mryang.funnyisland.entity;

/**
 * Created by Mr.Yang on 2017/5/16.
 */

public class ProductListModel {

    private int imgs;
    private String title;

    public ProductListModel(int  imgs, String title) {
        this.imgs = imgs;
        this.title = title;
    }

    public int getImgs() {
        return imgs;
    }

    public void setImgs(int imgs) {
        this.imgs = imgs;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
