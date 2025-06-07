package HashMap_커피메뉴만들기;

public class MenuInfo {
    String name;        //제품이름
    int price;          //가격
    String category;    //분류
    String desc;        //상세설명 내림차순

    public MenuInfo( String name, int price, String category, String desc) {
        this.price = price;
        this.name = name;
        this.category = category;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
