package com.konnectify.www.konnectify;


/**
 * Created by rushabh.a.sheth on 17-02-2016.
 */
public class card_data {

        private String name;

        private int imageRes;

        public card_data(int imageRes, String name) {
            this.imageRes = imageRes;
            this.name  = name;
        }

        public String getName() {
            return name;
        }

        public int getImage() {
            return imageRes;
        }

}
