package org.kodluyoruz.medium.service;



import org.kodluyoruz.medium.dao.TagDao;
import org.kodluyoruz.medium.model.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {
    @Autowired
    private TagDao tagDao;

    public void createTag(Tag tag){
        tagDao.saveTag(tag);
    }

    public List<Tag> getAllTags() {
        return tagDao.findAll();
    }

    public void printAllTags() {
        getAllTags().forEach(tag -> System.out.println(tag));
    }



}
