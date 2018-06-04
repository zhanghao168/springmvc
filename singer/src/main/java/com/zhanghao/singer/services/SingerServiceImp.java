package com.zhanghao.singer.services;

import com.google.common.collect.Lists;
import com.zhanghao.singer.entity.Singer;
import com.zhanghao.singer.repos.SingerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SingerServiceImp implements SingerService {

    private SingerRepository singerRepository;

    @Override
    public List<Singer> findAll() {
        return Lists.newArrayList(singerRepository.findAll());
    }

    @Override
    public Singer findById(Long id) {
        return singerRepository.findById(id).get();
    }

    @Override
    public Singer save(Singer singer) {
        return singerRepository.save(singer);
    }

    @Override
    public void delete(Long id) {
        singerRepository.deleteById(id);}

    @Autowired
    public void setSingerRepository(SingerRepository singerRepository) {
        this.singerRepository = singerRepository;
    }

}
