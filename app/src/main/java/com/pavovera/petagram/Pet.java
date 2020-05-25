package com.pavovera.petagram;

public class Pet {
    private int imgAvatarPet;
    private String nickName;
    private int raiting;

    public Pet(int imgAvatarPet, String nickName, int raiting) {
        this.imgAvatarPet = imgAvatarPet;
        this.nickName = nickName;
        this.raiting = raiting;
    }

    public int getImgAvatarPet() {
        return imgAvatarPet;
    }

    public void setImgAvatarPet(int imgAvatarPet) {
        this.imgAvatarPet = imgAvatarPet;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getRaiting() {

        return raiting;
    }

    public void setRaiting(int raiting) {

        this.raiting = raiting;
    }
}
