package com.zhanghao.singer.services;

import com.zhanghao.singer.entity.Singer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SingerService {
    List<Singer> findAll();
    Singer findById(Long id);
    Singer save(Singer singer);
    void delete(Long id);
}
