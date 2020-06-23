package com.ssp.ding.conf;

import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;
import java.util.Map;

/**
 * TypeReference 泛型常量
 *
 * @author: sunshaoping
 * @date: Create by in 5:56 下午 2020/6/8
 * @see TypeReference
 */
public interface TypeReferenceConf {

    TypeReference<Map<String, String>> MAP_STRING_STRING = new TypeReference<Map<String, String>>() {};

    TypeReference<Map<Long, Boolean>> MAP_LONG_BOOLEAN = new TypeReference<Map<Long, Boolean>>() {};

    TypeReference<Map<Long, Long>> MAP_LONG_LONG = new TypeReference<Map<Long, Long>>() {};

    TypeReference<List<List<Long>>> LIST_LIST_LONG = new TypeReference<List<List<Long>>>() {};

    TypeReference<List<Long>> LIST_LONG = new TypeReference<List<Long>>() {};

    TypeReference<List<Long>> LIST_STRING = new TypeReference<List<Long>>() {};


}
