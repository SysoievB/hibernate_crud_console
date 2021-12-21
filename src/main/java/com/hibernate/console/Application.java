package com.hibernate.console;

import com.hibernate.console.view.CommonView;

public class Application {
    public static void main(String[] args) {
        CommonView.getInstance().run();
    }
}
