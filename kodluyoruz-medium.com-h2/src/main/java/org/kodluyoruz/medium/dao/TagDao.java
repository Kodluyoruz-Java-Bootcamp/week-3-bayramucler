package org.kodluyoruz.medium.dao;

import org.kodluyoruz.medium.model.Tag;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class TagDao {
    private static List<Tag> tagList = new ArrayList<>();

    public void saveTag(Tag tag) {
        tagList.add(tag);
    }

    public List<Tag> findAll(){
        return tagList;
    }
}
