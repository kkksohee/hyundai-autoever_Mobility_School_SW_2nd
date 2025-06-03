package 제네릭;

public class GenericPrint<T extends Material> {
    private T material;
    //material은 T타입, 실제로는 Powder나 Plastic객체가 저장되어 있음
    public void setMaterial(T material){
        this.material =material;
    }
    public T getMaterial(){
        return material;
    }
    @Override
    public String toString(){
        //Powder나 Plastic 클래스에 오버라이딩 된 toString()메서드 호출
        return material.toString();
    }
    public void printing(){
        material.doPrinting();
    }
}
