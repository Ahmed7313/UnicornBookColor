package com.example.unicornbookcolor;

class UnicornImages {

    private int unicornImage;

    public UnicornImages (int unicornImage){
        this.unicornImage = unicornImage;
    }
    public UnicornImages(){}

    public static int imagesArray [] = new int[]{
            R.drawable.unicorn_1,
            R.drawable.unicorn_2,
            R.drawable.unicorn_3};

    public int getUnicornImage() {
        return unicornImage;
    }

    public void setUnicornImage(int unicornImage) {
        this.unicornImage = unicornImage;
    }
}
