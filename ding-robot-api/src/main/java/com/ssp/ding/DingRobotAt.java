package com.ssp.ding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 消息机器人at的人员列表
 *
 * @author: sunshaoping
 * @date: Create by in 10:21 上午 2020/7/21
 */
public interface DingRobotAt {


    List<String> atMobiles();

    default boolean isAtAll() {
        return false;
    }

    static Default newDingRobotAt() {
        return newDingRobotAt(false);
    }

    static Default newDingRobotAt(boolean isAtAll) {
        return new Default(new ArrayList<>(), isAtAll);
    }

    /**
     * 空实现，不at任何人
     */
    DingRobotAt EMPTY = Collections::emptyList;

    class Default implements DingRobotAt {

        private final List<String> atMobiles;

        private final boolean isAtAll;

        public Default(List<String> atMobiles, boolean isAtAll) {
            this.atMobiles = atMobiles;
            this.isAtAll = isAtAll;
        }

        @Override
        public List<String> atMobiles() {
            return atMobiles;
        }

        @Override
        public boolean isAtAll() {
            return isAtAll;
        }

        public Default atMobile(String mobile) {
            atMobiles.add(mobile);
            return this;
        }

    }
}
