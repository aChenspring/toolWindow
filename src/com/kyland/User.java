package com.kyland;

/***
 * @author achen
 * 树节点模型
 */
public class User {
        private String name;

        public User(String n) {
            name = n;
        }

       @Override
        public String toString() {
            return name;
        }
}
