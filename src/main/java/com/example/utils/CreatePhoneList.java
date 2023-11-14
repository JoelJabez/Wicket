package com.example.utils;

import com.example.domain.Phone;

import java.util.Arrays;
import java.util.List;

public class CreatePhoneList {
    private CreatePhoneList() {}

    public static List<Phone> apple() {
        return Arrays.asList(
            new Phone("iPhone 15 Pro", "https://www.apple.com/my/iphone-15-pro/"),
            new Phone("iPhone 15", "https://www.apple.com/my/iphone-15/"),
            new Phone("iPhone 14", "https://www.apple.com/my/shop/buy-iphone/iphone-14"),
            new Phone("iPhone 13", "https://www.apple.com/my/shop/buy-iphone/iphone-13"),
            new Phone("iPhone SE", "https://www.apple.com/my/iphone-se/")
        );
    }

    public static List<Phone> samsung() {
       return Arrays.asList(
           new Phone(
                   "Galaxy Z Flip5",
                   "https://www.samsung.com/my/smartphones/galaxy-z-flip5/buy/"
           ),

           new Phone(
                   "Galaxy Z Fold5",
                   "https://www.samsung.com/my/smartphones/galaxy-z-fold5/buy/"
           ),

           new Phone(
                   "Galaxy S23 FE",
                   "https://www.samsung.com/my/smartphones/galaxy-s/galaxy-s23-fe-mint-128gb-sm-s711blgbxme/buy/"
           ),

           new Phone(
                   "Galaxy S23",
                   "https://www.samsung.com/my/smartphones/galaxy-s23/buy/"
           ),

           new Phone(
                   "Galaxy A54 5G",
                   "https://www.samsung.com/my/smartphones/galaxy-a/galaxy-a54-5g-awesome-violet-256gb-sm-a546elvdxme/buy/"
           )
       );
    }

    public static List<Phone> nothingPhone() {
        return Arrays.asList(
            new Phone("Nothing Phone(1)", "https://my.nothing.tech/products/phone-1"),
            new Phone("Nothing Phone(2)", "https://my.nothing.tech/pages/phone-2")
        );
    }

    public static List<Phone> nokia() {
        return Arrays.asList(
            new Phone("Nokia X30 5G", "https://www.nokia.com/phones/en_my/nokia-x-30?sku=VMA751R9FI1AL0"),
            new Phone("Nokia C21 Plus", "https://www.nokia.com/phones/en_my/nokia-c-21-plus?sku=719901189181"),
            new Phone("Nokia C21", "https://www.nokia.com/phones/en_my/nokia-c-21?sku=286717235"),
            new Phone("Nokia G21", "https://www.nokia.com/phones/en_my/nokia-g-21?sku=719901185181"),
            new Phone("Nokia C01 Plus", "https://www.nokia.com/phones/en_my/nokia-c-01-plus?sku=719901162051")
        );
    }
}
